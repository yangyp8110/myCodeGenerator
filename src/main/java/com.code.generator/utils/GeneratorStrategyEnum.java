package com.code.generator.utils;

/**
 * @author mr.yang.localhost
 * @Description:
 * @date 2018/5/6
 * <!--生成策略：1:增量生成;2:仅当前库表重新生成;3:整个项目重新生成;4:指定表重新生成-->
 */
public enum GeneratorStrategyEnum {
    /**
     * 增量生成
     */
    ADDED_GENERATOR(1),
    /**
     * 仅当前库重新生成
     */
    OVERWRITE_ALL_TABLES(2),
    /**
     * 整个项目重新生成
     */
    DELETE_PROJECT(3),
    /**
     * 指定表重新生成
     */
    TABLES_GENERATOR(4);

    private Integer code;

    public Integer getCode() {
        return code;
    }

    GeneratorStrategyEnum(Integer var) {
        this.code = var;
    }
}
