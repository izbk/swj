package cn.com.yuanwei.center.entity;

import java.util.ArrayList;
import java.util.List;

public class ServiceDefineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceDefineExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNull() {
            addCriterion("data_source is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNotNull() {
            addCriterion("data_source is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceEqualTo(Integer value) {
            addCriterion("data_source =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(Integer value) {
            addCriterion("data_source <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(Integer value) {
            addCriterion("data_source >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_source >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(Integer value) {
            addCriterion("data_source <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(Integer value) {
            addCriterion("data_source <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<Integer> values) {
            addCriterion("data_source in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<Integer> values) {
            addCriterion("data_source not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(Integer value1, Integer value2) {
            addCriterion("data_source between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("data_source not between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryIsNull() {
            addCriterion("calculation_industry is null");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryIsNotNull() {
            addCriterion("calculation_industry is not null");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryEqualTo(Integer value) {
            addCriterion("calculation_industry =", value, "calculationIndustry");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryNotEqualTo(Integer value) {
            addCriterion("calculation_industry <>", value, "calculationIndustry");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryGreaterThan(Integer value) {
            addCriterion("calculation_industry >", value, "calculationIndustry");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryGreaterThanOrEqualTo(Integer value) {
            addCriterion("calculation_industry >=", value, "calculationIndustry");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryLessThan(Integer value) {
            addCriterion("calculation_industry <", value, "calculationIndustry");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryLessThanOrEqualTo(Integer value) {
            addCriterion("calculation_industry <=", value, "calculationIndustry");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryIn(List<Integer> values) {
            addCriterion("calculation_industry in", values, "calculationIndustry");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryNotIn(List<Integer> values) {
            addCriterion("calculation_industry not in", values, "calculationIndustry");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryBetween(Integer value1, Integer value2) {
            addCriterion("calculation_industry between", value1, value2, "calculationIndustry");
            return (Criteria) this;
        }

        public Criteria andCalculationIndustryNotBetween(Integer value1, Integer value2) {
            addCriterion("calculation_industry not between", value1, value2, "calculationIndustry");
            return (Criteria) this;
        }

        public Criteria andDepartIdIsNull() {
            addCriterion("depart_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartIdIsNotNull() {
            addCriterion("depart_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartIdEqualTo(Integer value) {
            addCriterion("depart_id =", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotEqualTo(Integer value) {
            addCriterion("depart_id <>", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdGreaterThan(Integer value) {
            addCriterion("depart_id >", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("depart_id >=", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLessThan(Integer value) {
            addCriterion("depart_id <", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLessThanOrEqualTo(Integer value) {
            addCriterion("depart_id <=", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdIn(List<Integer> values) {
            addCriterion("depart_id in", values, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotIn(List<Integer> values) {
            addCriterion("depart_id not in", values, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdBetween(Integer value1, Integer value2) {
            addCriterion("depart_id between", value1, value2, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("depart_id not between", value1, value2, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNull() {
            addCriterion("depart_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNotNull() {
            addCriterion("depart_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartNameEqualTo(String value) {
            addCriterion("depart_name =", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotEqualTo(String value) {
            addCriterion("depart_name <>", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThan(String value) {
            addCriterion("depart_name >", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThanOrEqualTo(String value) {
            addCriterion("depart_name >=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThan(String value) {
            addCriterion("depart_name <", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThanOrEqualTo(String value) {
            addCriterion("depart_name <=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLike(String value) {
            addCriterion("depart_name like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotLike(String value) {
            addCriterion("depart_name not like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameIn(List<String> values) {
            addCriterion("depart_name in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotIn(List<String> values) {
            addCriterion("depart_name not in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameBetween(String value1, String value2) {
            addCriterion("depart_name between", value1, value2, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotBetween(String value1, String value2) {
            addCriterion("depart_name not between", value1, value2, "departName");
            return (Criteria) this;
        }

        public Criteria andIndexNameIsNull() {
            addCriterion("index_name is null");
            return (Criteria) this;
        }

        public Criteria andIndexNameIsNotNull() {
            addCriterion("index_name is not null");
            return (Criteria) this;
        }

        public Criteria andIndexNameEqualTo(String value) {
            addCriterion("index_name =", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotEqualTo(String value) {
            addCriterion("index_name <>", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameGreaterThan(String value) {
            addCriterion("index_name >", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameGreaterThanOrEqualTo(String value) {
            addCriterion("index_name >=", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLessThan(String value) {
            addCriterion("index_name <", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLessThanOrEqualTo(String value) {
            addCriterion("index_name <=", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLike(String value) {
            addCriterion("index_name like", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotLike(String value) {
            addCriterion("index_name not like", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameIn(List<String> values) {
            addCriterion("index_name in", values, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotIn(List<String> values) {
            addCriterion("index_name not in", values, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameBetween(String value1, String value2) {
            addCriterion("index_name between", value1, value2, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotBetween(String value1, String value2) {
            addCriterion("index_name not between", value1, value2, "indexName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLikeInsensitive(String value) {
            addCriterion("upper(depart_name) like", value.toUpperCase(), "departName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLikeInsensitive(String value) {
            addCriterion("upper(index_name) like", value.toUpperCase(), "indexName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}