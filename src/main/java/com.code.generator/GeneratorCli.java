package com.code.generator;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import com.code.generator.utils.CommonCliUtils;
import com.code.generator.utils.GeneratorStrategyEnum;
import java.io.File;
import java.io.IOException;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author mr.yang.localhost
 * @date 2018/5/6
 */
public class GeneratorCli {
    private static final CommandLineParser parser = new BasicParser();
    private static final String DATABASE_NAME_KEY = "database_name";
    private static final String DATABASE_NAME_LOWER_KEY = "database_name_lower";
    private static final String OUTPUT_PATH_KEY = "outRoot";
    private static final String TABLE_NAME_KEY = "table_name";
    private static final String GENERATE_FLAG = "generate_flag";
    public static final String CONFIG_CMD = "c";

    public static void main(String[] args) throws Exception {
        /**init generator*/
        GeneratorFacade g = initGeneratorFacade(args);

        /**load generate strategy*/
        String flag = GeneratorProperties.getProperty(GENERATE_FLAG, "");
        int strategy = GeneratorStrategyEnum.ADDED_GENERATOR.getCode();
        if (NumberUtils.isDigits(flag)) {
            strategy = Integer.parseInt(flag);
        }

        /**generate by strategy*/
        generatorStrategy(strategy, g);

        System.out.print("\n\n\n");
        System.out.println("=======================generate finished=======================");
    }

    private static GeneratorFacade initGeneratorFacade(String[] args) throws IOException, ParseException {
        String templatePath = Thread.currentThread().getContextClassLoader().getResource("template").getPath();
        GeneratorFacade g = new GeneratorFacade();
        System.out.println("templatePath:" + templatePath);
        g.getGenerator().addTemplateRootDir(templatePath);

        CommandLine commandLine = parser.parse(CommonCliUtils.OPTIONS, args);
        GeneratorProperties.getProperties();
        if (commandLine.hasOption(CONFIG_CMD)) {
            String configPath = commandLine.getOptionValue(CONFIG_CMD);
            System.out.println("load config file : " + configPath);
            //覆盖属性
            GeneratorProperties.load(configPath);
        }
        String output = GeneratorProperties.getProperty("output_path", "\\out");
        if (!StringUtils.isEmpty(output)) {
            if (!output.endsWith(File.separator)) {
                output += File.separator;
            }
            output += GeneratorProperties.getProperty("artifactId").replace('.', '-');
            GeneratorProperties.setProperty(OUTPUT_PATH_KEY, output);
            g.getGenerator().setOutRootDir(output);
        }

        String dbName = GeneratorProperties.getProperty(DATABASE_NAME_KEY, "Test");
        GeneratorProperties.setProperty(DATABASE_NAME_LOWER_KEY, dbName.toLowerCase());
        return g;
    }

    private static void generatorStrategy(Integer strategy, GeneratorFacade g) throws Exception {
        if (strategy.equals(GeneratorStrategyEnum.DELETE_PROJECT.getCode())) {
            System.out.println("delete project : " + GeneratorProperties.getProperty(OUTPUT_PATH_KEY));
            g.deleteOutRootDir();
        } else if (strategy.equals(GeneratorStrategyEnum.OVERWRITE_ALL_TABLES.getCode())) {
            g.deleteByAllTable();
        } else if (strategy.equals(GeneratorStrategyEnum.TABLES_GENERATOR.getCode())) {
            String tableNames = GeneratorProperties.getProperty(TABLE_NAME_KEY, "");
            if (!StringUtils.isEmpty(tableNames.trim())) {
                g.deleteByTable(tableNames.trim().split(","));
                g.generateByTable(tableNames.trim().split(","));
                return;
            }
        }
        g.generateByAllTable();
    }
}
