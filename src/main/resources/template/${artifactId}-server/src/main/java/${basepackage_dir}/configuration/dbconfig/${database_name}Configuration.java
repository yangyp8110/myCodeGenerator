package ${basepackage}.configuration.dbconfig;

import ${basepackage}.configuration.DataBaseConfiguration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

<#include "/java_copyright.include">

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = {"${basepackage}.mapper.${database_name_lower}"}, sqlSessionFactoryRef = "${database_name_lower}SqlSessionFactory")
public class ${database_name}Configuration {
    /**
     * 配置数据源
     */
    @Bean(name = "${database_name_lower}DataSource", initMethod = "init", destroyMethod = "close")
    @Qualifier("${database_name_lower}DataSource")
    @ConfigurationProperties(prefix = "dataSource.${database_name_lower}")
    public DataSource get${database_name}DataSource(){
        return DataBaseConfiguration.createDefaultDruidDataSource();
    }

    /**
     * 配置SqlSessionFactory
     */
    @Bean(name = "${database_name_lower}SqlSessionFactory")
    @Qualifier("${database_name_lower}SqlSessionFactory")
    public SqlSessionFactory get${database_name}SqlSessionFactory(){
        String configLocation="classpath:/${mapper_xml_package_dir}/configuration.xml";
        String mapperLocation="classpath:/${mapper_xml_package_dir}/${database_name_lower}/**/*.xml";
        SqlSessionFactory sqlSessionFactory=DataBaseConfiguration.createDefaultSqlSessionFactory(get${database_name}DataSource(),configLocation,mapperLocation);
        return sqlSessionFactory;
    }

    /**
     * 事物管理器配置
     */
    @Bean(name="${database_name_lower}TransactionManager")
    @Qualifier("${database_name_lower}TransactionManager")
    public PlatformTransactionManager ${database_name_lower}TransactionManager() {
         return new DataSourceTransactionManager(get${database_name}DataSource());
    }
}
