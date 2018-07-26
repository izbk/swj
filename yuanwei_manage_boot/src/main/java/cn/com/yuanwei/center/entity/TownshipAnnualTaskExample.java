package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TownshipAnnualTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TownshipAnnualTaskExample() {
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

        public Criteria andTownshipIdIsNull() {
            addCriterion("township_id is null");
            return (Criteria) this;
        }

        public Criteria andTownshipIdIsNotNull() {
            addCriterion("township_id is not null");
            return (Criteria) this;
        }

        public Criteria andTownshipIdEqualTo(Integer value) {
            addCriterion("township_id =", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdNotEqualTo(Integer value) {
            addCriterion("township_id <>", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdGreaterThan(Integer value) {
            addCriterion("township_id >", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("township_id >=", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdLessThan(Integer value) {
            addCriterion("township_id <", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdLessThanOrEqualTo(Integer value) {
            addCriterion("township_id <=", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdIn(List<Integer> values) {
            addCriterion("township_id in", values, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdNotIn(List<Integer> values) {
            addCriterion("township_id not in", values, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdBetween(Integer value1, Integer value2) {
            addCriterion("township_id between", value1, value2, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdNotBetween(Integer value1, Integer value2) {
            addCriterion("township_id not between", value1, value2, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipNameIsNull() {
            addCriterion("township_name is null");
            return (Criteria) this;
        }

        public Criteria andTownshipNameIsNotNull() {
            addCriterion("township_name is not null");
            return (Criteria) this;
        }

        public Criteria andTownshipNameEqualTo(String value) {
            addCriterion("township_name =", value, "townshipName");
            return (Criteria) this;
        }

        public Criteria andTownshipNameNotEqualTo(String value) {
            addCriterion("township_name <>", value, "townshipName");
            return (Criteria) this;
        }

        public Criteria andTownshipNameGreaterThan(String value) {
            addCriterion("township_name >", value, "townshipName");
            return (Criteria) this;
        }

        public Criteria andTownshipNameGreaterThanOrEqualTo(String value) {
            addCriterion("township_name >=", value, "townshipName");
            return (Criteria) this;
        }

        public Criteria andTownshipNameLessThan(String value) {
            addCriterion("township_name <", value, "townshipName");
            return (Criteria) this;
        }

        public Criteria andTownshipNameLessThanOrEqualTo(String value) {
            addCriterion("township_name <=", value, "townshipName");
            return (Criteria) this;
        }

        public Criteria andTownshipNameLike(String value) {
            addCriterion("township_name like", value, "townshipName");
            return (Criteria) this;
        }

        public Criteria andTownshipNameNotLike(String value) {
            addCriterion("township_name not like", value, "townshipName");
            return (Criteria) this;
        }

        public Criteria andTownshipNameIn(List<String> values) {
            addCriterion("township_name in", values, "townshipName");
            return (Criteria) this;
        }

        public Criteria andTownshipNameNotIn(List<String> values) {
            addCriterion("township_name not in", values, "townshipName");
            return (Criteria) this;
        }

        public Criteria andTownshipNameBetween(String value1, String value2) {
            addCriterion("township_name between", value1, value2, "townshipName");
            return (Criteria) this;
        }

        public Criteria andTownshipNameNotBetween(String value1, String value2) {
            addCriterion("township_name not between", value1, value2, "townshipName");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskIsNull() {
            addCriterion("retail_sales_task is null");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskIsNotNull() {
            addCriterion("retail_sales_task is not null");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskEqualTo(BigDecimal value) {
            addCriterion("retail_sales_task =", value, "retailSalesTask");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskNotEqualTo(BigDecimal value) {
            addCriterion("retail_sales_task <>", value, "retailSalesTask");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskGreaterThan(BigDecimal value) {
            addCriterion("retail_sales_task >", value, "retailSalesTask");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("retail_sales_task >=", value, "retailSalesTask");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskLessThan(BigDecimal value) {
            addCriterion("retail_sales_task <", value, "retailSalesTask");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskLessThanOrEqualTo(BigDecimal value) {
            addCriterion("retail_sales_task <=", value, "retailSalesTask");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskIn(List<BigDecimal> values) {
            addCriterion("retail_sales_task in", values, "retailSalesTask");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskNotIn(List<BigDecimal> values) {
            addCriterion("retail_sales_task not in", values, "retailSalesTask");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retail_sales_task between", value1, value2, "retailSalesTask");
            return (Criteria) this;
        }

        public Criteria andRetailSalesTaskNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retail_sales_task not between", value1, value2, "retailSalesTask");
            return (Criteria) this;
        }

        public Criteria andSalesTaskIsNull() {
            addCriterion("sales_task is null");
            return (Criteria) this;
        }

        public Criteria andSalesTaskIsNotNull() {
            addCriterion("sales_task is not null");
            return (Criteria) this;
        }

        public Criteria andSalesTaskEqualTo(BigDecimal value) {
            addCriterion("sales_task =", value, "salesTask");
            return (Criteria) this;
        }

        public Criteria andSalesTaskNotEqualTo(BigDecimal value) {
            addCriterion("sales_task <>", value, "salesTask");
            return (Criteria) this;
        }

        public Criteria andSalesTaskGreaterThan(BigDecimal value) {
            addCriterion("sales_task >", value, "salesTask");
            return (Criteria) this;
        }

        public Criteria andSalesTaskGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_task >=", value, "salesTask");
            return (Criteria) this;
        }

        public Criteria andSalesTaskLessThan(BigDecimal value) {
            addCriterion("sales_task <", value, "salesTask");
            return (Criteria) this;
        }

        public Criteria andSalesTaskLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_task <=", value, "salesTask");
            return (Criteria) this;
        }

        public Criteria andSalesTaskIn(List<BigDecimal> values) {
            addCriterion("sales_task in", values, "salesTask");
            return (Criteria) this;
        }

        public Criteria andSalesTaskNotIn(List<BigDecimal> values) {
            addCriterion("sales_task not in", values, "salesTask");
            return (Criteria) this;
        }

        public Criteria andSalesTaskBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_task between", value1, value2, "salesTask");
            return (Criteria) this;
        }

        public Criteria andSalesTaskNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_task not between", value1, value2, "salesTask");
            return (Criteria) this;
        }

        public Criteria andTotalTaskIsNull() {
            addCriterion("total_task is null");
            return (Criteria) this;
        }

        public Criteria andTotalTaskIsNotNull() {
            addCriterion("total_task is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTaskEqualTo(BigDecimal value) {
            addCriterion("total_task =", value, "totalTask");
            return (Criteria) this;
        }

        public Criteria andTotalTaskNotEqualTo(BigDecimal value) {
            addCriterion("total_task <>", value, "totalTask");
            return (Criteria) this;
        }

        public Criteria andTotalTaskGreaterThan(BigDecimal value) {
            addCriterion("total_task >", value, "totalTask");
            return (Criteria) this;
        }

        public Criteria andTotalTaskGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_task >=", value, "totalTask");
            return (Criteria) this;
        }

        public Criteria andTotalTaskLessThan(BigDecimal value) {
            addCriterion("total_task <", value, "totalTask");
            return (Criteria) this;
        }

        public Criteria andTotalTaskLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_task <=", value, "totalTask");
            return (Criteria) this;
        }

        public Criteria andTotalTaskIn(List<BigDecimal> values) {
            addCriterion("total_task in", values, "totalTask");
            return (Criteria) this;
        }

        public Criteria andTotalTaskNotIn(List<BigDecimal> values) {
            addCriterion("total_task not in", values, "totalTask");
            return (Criteria) this;
        }

        public Criteria andTotalTaskBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_task between", value1, value2, "totalTask");
            return (Criteria) this;
        }

        public Criteria andTotalTaskNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_task not between", value1, value2, "totalTask");
            return (Criteria) this;
        }

        public Criteria andAddTaskIsNull() {
            addCriterion("add_task is null");
            return (Criteria) this;
        }

        public Criteria andAddTaskIsNotNull() {
            addCriterion("add_task is not null");
            return (Criteria) this;
        }

        public Criteria andAddTaskEqualTo(Integer value) {
            addCriterion("add_task =", value, "addTask");
            return (Criteria) this;
        }

        public Criteria andAddTaskNotEqualTo(Integer value) {
            addCriterion("add_task <>", value, "addTask");
            return (Criteria) this;
        }

        public Criteria andAddTaskGreaterThan(Integer value) {
            addCriterion("add_task >", value, "addTask");
            return (Criteria) this;
        }

        public Criteria andAddTaskGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_task >=", value, "addTask");
            return (Criteria) this;
        }

        public Criteria andAddTaskLessThan(Integer value) {
            addCriterion("add_task <", value, "addTask");
            return (Criteria) this;
        }

        public Criteria andAddTaskLessThanOrEqualTo(Integer value) {
            addCriterion("add_task <=", value, "addTask");
            return (Criteria) this;
        }

        public Criteria andAddTaskIn(List<Integer> values) {
            addCriterion("add_task in", values, "addTask");
            return (Criteria) this;
        }

        public Criteria andAddTaskNotIn(List<Integer> values) {
            addCriterion("add_task not in", values, "addTask");
            return (Criteria) this;
        }

        public Criteria andAddTaskBetween(Integer value1, Integer value2) {
            addCriterion("add_task between", value1, value2, "addTask");
            return (Criteria) this;
        }

        public Criteria andAddTaskNotBetween(Integer value1, Integer value2) {
            addCriterion("add_task not between", value1, value2, "addTask");
            return (Criteria) this;
        }

        public Criteria andTotalApplyIsNull() {
            addCriterion("total_apply is null");
            return (Criteria) this;
        }

        public Criteria andTotalApplyIsNotNull() {
            addCriterion("total_apply is not null");
            return (Criteria) this;
        }

        public Criteria andTotalApplyEqualTo(Integer value) {
            addCriterion("total_apply =", value, "totalApply");
            return (Criteria) this;
        }

        public Criteria andTotalApplyNotEqualTo(Integer value) {
            addCriterion("total_apply <>", value, "totalApply");
            return (Criteria) this;
        }

        public Criteria andTotalApplyGreaterThan(Integer value) {
            addCriterion("total_apply >", value, "totalApply");
            return (Criteria) this;
        }

        public Criteria andTotalApplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_apply >=", value, "totalApply");
            return (Criteria) this;
        }

        public Criteria andTotalApplyLessThan(Integer value) {
            addCriterion("total_apply <", value, "totalApply");
            return (Criteria) this;
        }

        public Criteria andTotalApplyLessThanOrEqualTo(Integer value) {
            addCriterion("total_apply <=", value, "totalApply");
            return (Criteria) this;
        }

        public Criteria andTotalApplyIn(List<Integer> values) {
            addCriterion("total_apply in", values, "totalApply");
            return (Criteria) this;
        }

        public Criteria andTotalApplyNotIn(List<Integer> values) {
            addCriterion("total_apply not in", values, "totalApply");
            return (Criteria) this;
        }

        public Criteria andTotalApplyBetween(Integer value1, Integer value2) {
            addCriterion("total_apply between", value1, value2, "totalApply");
            return (Criteria) this;
        }

        public Criteria andTotalApplyNotBetween(Integer value1, Integer value2) {
            addCriterion("total_apply not between", value1, value2, "totalApply");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTownshipNameLikeInsensitive(String value) {
            addCriterion("upper(township_name) like", value.toUpperCase(), "townshipName");
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