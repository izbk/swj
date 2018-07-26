package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceMonthlyReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceMonthlyReportExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("enterprise_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("enterprise_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("enterprise_name =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("enterprise_name <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("enterprise_name >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_name >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("enterprise_name <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_name <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("enterprise_name like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("enterprise_name not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("enterprise_name in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("enterprise_name not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("enterprise_name between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_name not between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andCurrMonthIsNull() {
            addCriterion("curr_month is null");
            return (Criteria) this;
        }

        public Criteria andCurrMonthIsNotNull() {
            addCriterion("curr_month is not null");
            return (Criteria) this;
        }

        public Criteria andCurrMonthEqualTo(BigDecimal value) {
            addCriterion("curr_month =", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthNotEqualTo(BigDecimal value) {
            addCriterion("curr_month <>", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthGreaterThan(BigDecimal value) {
            addCriterion("curr_month >", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_month >=", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthLessThan(BigDecimal value) {
            addCriterion("curr_month <", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_month <=", value, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthIn(List<BigDecimal> values) {
            addCriterion("curr_month in", values, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthNotIn(List<BigDecimal> values) {
            addCriterion("curr_month not in", values, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_month between", value1, value2, "currMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_month not between", value1, value2, "currMonth");
            return (Criteria) this;
        }

        public Criteria andLastMonthIsNull() {
            addCriterion("last_month is null");
            return (Criteria) this;
        }

        public Criteria andLastMonthIsNotNull() {
            addCriterion("last_month is not null");
            return (Criteria) this;
        }

        public Criteria andLastMonthEqualTo(BigDecimal value) {
            addCriterion("last_month =", value, "lastMonth");
            return (Criteria) this;
        }

        public Criteria andLastMonthNotEqualTo(BigDecimal value) {
            addCriterion("last_month <>", value, "lastMonth");
            return (Criteria) this;
        }

        public Criteria andLastMonthGreaterThan(BigDecimal value) {
            addCriterion("last_month >", value, "lastMonth");
            return (Criteria) this;
        }

        public Criteria andLastMonthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last_month >=", value, "lastMonth");
            return (Criteria) this;
        }

        public Criteria andLastMonthLessThan(BigDecimal value) {
            addCriterion("last_month <", value, "lastMonth");
            return (Criteria) this;
        }

        public Criteria andLastMonthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last_month <=", value, "lastMonth");
            return (Criteria) this;
        }

        public Criteria andLastMonthIn(List<BigDecimal> values) {
            addCriterion("last_month in", values, "lastMonth");
            return (Criteria) this;
        }

        public Criteria andLastMonthNotIn(List<BigDecimal> values) {
            addCriterion("last_month not in", values, "lastMonth");
            return (Criteria) this;
        }

        public Criteria andLastMonthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_month between", value1, value2, "lastMonth");
            return (Criteria) this;
        }

        public Criteria andLastMonthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_month not between", value1, value2, "lastMonth");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountIsNull() {
            addCriterion("curr_month_amount is null");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountIsNotNull() {
            addCriterion("curr_month_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountEqualTo(BigDecimal value) {
            addCriterion("curr_month_amount =", value, "currMonthAmount");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountNotEqualTo(BigDecimal value) {
            addCriterion("curr_month_amount <>", value, "currMonthAmount");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountGreaterThan(BigDecimal value) {
            addCriterion("curr_month_amount >", value, "currMonthAmount");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_month_amount >=", value, "currMonthAmount");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountLessThan(BigDecimal value) {
            addCriterion("curr_month_amount <", value, "currMonthAmount");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_month_amount <=", value, "currMonthAmount");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountIn(List<BigDecimal> values) {
            addCriterion("curr_month_amount in", values, "currMonthAmount");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountNotIn(List<BigDecimal> values) {
            addCriterion("curr_month_amount not in", values, "currMonthAmount");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_month_amount between", value1, value2, "currMonthAmount");
            return (Criteria) this;
        }

        public Criteria andCurrMonthAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_month_amount not between", value1, value2, "currMonthAmount");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountIsNull() {
            addCriterion("last_month_amount is null");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountIsNotNull() {
            addCriterion("last_month_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountEqualTo(BigDecimal value) {
            addCriterion("last_month_amount =", value, "lastMonthAmount");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountNotEqualTo(BigDecimal value) {
            addCriterion("last_month_amount <>", value, "lastMonthAmount");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountGreaterThan(BigDecimal value) {
            addCriterion("last_month_amount >", value, "lastMonthAmount");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last_month_amount >=", value, "lastMonthAmount");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountLessThan(BigDecimal value) {
            addCriterion("last_month_amount <", value, "lastMonthAmount");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last_month_amount <=", value, "lastMonthAmount");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountIn(List<BigDecimal> values) {
            addCriterion("last_month_amount in", values, "lastMonthAmount");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountNotIn(List<BigDecimal> values) {
            addCriterion("last_month_amount not in", values, "lastMonthAmount");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_month_amount between", value1, value2, "lastMonthAmount");
            return (Criteria) this;
        }

        public Criteria andLastMonthAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_month_amount not between", value1, value2, "lastMonthAmount");
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

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("month not between", value1, value2, "month");
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

        public Criteria andEnterpriseNameLikeInsensitive(String value) {
            addCriterion("upper(enterprise_name) like", value.toUpperCase(), "enterpriseName");
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