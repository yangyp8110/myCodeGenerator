package com.code.generator.utils;

import org.apache.commons.cli.Options;

/**
 * @author mr.yang.localhost
 * @Description:
 * @date 2018/5/6
 */
public class CommonCliUtils {
    public static final Options OPTIONS = new Options();
    /**
     * 自定义命令
     * <p>
     * t : 指定表名(多个表名以逗号分隔)
     * o : 输出路径
     * c : 指定配置文件
     * d ：true:覆盖生成(删除老版本，重新生成);false:增量生成(已存在的不生成)
     */
    static {
        OPTIONS.addOption("c", "config", true, "指定配置文件的路径");
        OPTIONS.addOption("h", "help", true, "获取帮助");
    }
}
