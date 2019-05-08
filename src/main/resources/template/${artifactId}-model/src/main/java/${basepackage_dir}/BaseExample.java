package ${basepackage};

import lombok.Getter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

<#include "/java_copyright.include">

public class BaseExample {
    @Getter
    protected String orderByClause;
    @Getter
    protected String selectFields;
    protected boolean distinct;
    @Getter
    protected List<GeneratedCriteria> ordCriteria;

    protected BaseExample(){}

    protected BaseExample(String orderByClause, String selectFields, boolean distinct, List<GeneratedCriteria> ordCriteria) {
        this.orderByClause = orderByClause;
        this.selectFields = selectFields;
        this.distinct = distinct;
        this.ordCriteria = ordCriteria == null ? new ArrayList<>() : ordCriteria;
    }

    public static ExampleBuilder builder() {
        return new ExampleBuilder();
    }

    public static class ExampleBuilder {
        private String orderByClause;
        private String selectFieldClause;
        private boolean distinct;
        private List<GeneratedCriteria> ordCriteria;

        private ExampleBuilder(){
            this.ordCriteria = new ArrayList<>();
        }

        public ExampleBuilder orderByClause(BaseOrderByCriteria orderByCriteria){
            this.orderByClause = orderByCriteria.build();
            return this;
        }

        public ExampleBuilder includeSelectFieldClause(BaseSelectFieldCriteria selectFieldCriteria){
            this.selectFieldClause = selectFieldCriteria.build();
            return this;
        }

        public ExampleBuilder distinct(Boolean distinct){
            this.distinct = distinct;
            return this;
        }

        public ExampleBuilder ordCriteria(List<GeneratedCriteria> ordCriteria){
            this.ordCriteria = ordCriteria;
            return this;
        }

        public ExampleBuilder addCriteria(GeneratedCriteria criteria){
            this.ordCriteria.add(criteria);
            return this;
        }

        public ExampleBuilder clear() {
            this.ordCriteria.clear();
            this.orderByClause = null;
            this.selectFieldClause = null;
            this.distinct = false;
            return this;
        }

        public BaseExample build(){
            return new BaseExample(this.orderByClause, this.selectFieldClause, this.distinct, this.ordCriteria);
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            this.criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            this.criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            this.criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            this.criteria.add(new Criterion(condition, value1, value2));
        }
    }

    public abstract static class BaseOrderByCriteria {
        protected List<String> orderByCriteria;
        protected BaseOrderByCriteria() {
            this.orderByCriteria = new ArrayList<>();
        }

        public String build() {
            return CollectionUtils.isEmpty(this.orderByCriteria) ? null : StringUtils.collectionToCommaDelimitedString(this.orderByCriteria);
        }
    }

    public abstract static class BaseSelectFieldCriteria {
        protected List<String> selectFields;
        protected BaseSelectFieldCriteria() {
            this.selectFields = new ArrayList<>();
        }

        public String build() {
            return CollectionUtils.isEmpty(this.selectFields) ? null : StringUtils.collectionToCommaDelimitedString(this.selectFields);
        }
    }
}