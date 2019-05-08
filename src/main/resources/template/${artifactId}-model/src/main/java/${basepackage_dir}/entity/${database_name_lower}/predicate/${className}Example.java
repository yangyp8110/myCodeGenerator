package ${basepackage}.entity.${database_name_lower}.predicate;

import java.util.List;
import ${basepackage}.BaseExample;
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

public class ${className}Example extends BaseExample {
    private ${className}Example(){}

    public static OrderByCriteria buildOrderByCriteria() {
        return new OrderByCriteria();
    }

    public static Criteria builderCriteria() {
        return new Criteria();
    }

    public static SelectFieldCriteria builderSelectFieldCriteria() {
        return new SelectFieldCriteria();
    }

    public static class Criteria extends GeneratedCriteria {
        <#list table.columns as column>
        public Criteria and${column.columnName}IsNull() {
            addCriterion("${column.sqlName} is null");
            return (Criteria) this;
        }

        public Criteria and${column.columnName}IsNotNull() {
            addCriterion("${column.sqlName} is not null");
            return (Criteria) this;
        }

        public Criteria and${column.columnName}EqualTo(${column.possibleShortJavaType} value) {
            addCriterion("${column.sqlName} =", value, "${column.columnNameLower}");
            return (Criteria) this;
        }

        public Criteria and${column.columnName}NotEqualTo(${column.possibleShortJavaType} value) {
            addCriterion("${column.sqlName} <>", value, "${column.columnNameLower}");
            return (Criteria) this;
        }

        public Criteria and${column.columnName}GreaterThan(${column.possibleShortJavaType} value) {
            addCriterion("${column.sqlName} >", value, "${column.columnNameLower}");
            return (Criteria) this;
        }

        public Criteria and${column.columnName}GreaterThanOrEqualTo(${column.possibleShortJavaType} value) {
            addCriterion("${column.sqlName} >=", value, "${column.columnNameLower}");
            return (Criteria) this;
        }

        public Criteria and${column.columnName}LessThan(${column.possibleShortJavaType} value) {
            addCriterion("${column.sqlName} <", value, "${column.columnNameLower}");
            return (Criteria) this;
        }

        public Criteria and${column.columnName}LessThanOrEqualTo(${column.possibleShortJavaType} value) {
            addCriterion("${column.sqlName} <=", value, "${column.columnNameLower}");
            return (Criteria) this;
        }

        public Criteria and${column.columnName}In(List<${column.possibleShortJavaType}> values) {
            addCriterion("${column.sqlName} in", values, "${column.columnNameLower}");
            return (Criteria) this;
        }

        public Criteria and${column.columnName}NotIn(List<${column.possibleShortJavaType}> values) {
            addCriterion("${column.sqlName} not in", values, "${column.columnNameLower}");
            return (Criteria) this;
        }

        public Criteria and${column.columnName}Between(${column.possibleShortJavaType} value1, ${column.possibleShortJavaType} value2) {
            addCriterion("${column.sqlName} between", value1, value2, "${column.columnNameLower}");
            return (Criteria) this;
        }

        public Criteria and${column.columnName}NotBetween(${column.possibleShortJavaType} value1, ${column.possibleShortJavaType} value2) {
            addCriterion("${column.sqlName} not between", value1, value2, "${column.columnNameLower}");
            return (Criteria) this;
        }
        </#list>
    }

    public static class OrderByCriteria extends BaseOrderByCriteria {
        <#list table.columns as column>
        public OrderByCriteria orderBy${column.columnName}Desc() {
            this.orderByCriteria.add(" ${column.sqlName} desc");
            return this;
        }
        public OrderByCriteria orderBy${column.columnName}Asc() {
            this.orderByCriteria.add(" ${column.sqlName} asc");
            return this;
        }

        </#list>
    }

    public static class SelectFieldCriteria extends BaseSelectFieldCriteria {
        <#list table.columns as column>
        public SelectFieldCriteria ${column.columnNameFirstLower}() {
            this.selectFields.add("${column.sqlName}");
            return this;
        }

        </#list>
    }
}