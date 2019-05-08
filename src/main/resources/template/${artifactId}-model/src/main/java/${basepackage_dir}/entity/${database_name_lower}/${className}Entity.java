package ${basepackage}.entity.${database_name_lower};

import lombok.Getter;
import lombok.Setter;

<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>

@Getter
@Setter
public class ${className}Entity {
    <#list table.columns as column>
    /**
     * ${column.remarks}
     */
    private ${column.possibleShortJavaType} ${column.columnNameLower};
    </#list>
}