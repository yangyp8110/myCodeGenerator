package ${basepackage}.mapper.${database_name_lower}.mapper;

<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
import ${basepackage}.entity.${database_name_lower}.${className}Entity;
import ${basepackage}.mapper.${database_name_lower}.BaseDaoMapper;

<#include "/java_copyright.include">

public interface ${className}Mapper extends BaseDaoMapper<${className}Entity, ${table.pkColumn.javaType}> {

}
