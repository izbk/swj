package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseRiseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterpriseRiseExample() {
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

        public Criteria andEnterCompareRiseIsNull() {
            addCriterion("enter_compare_rise is null");
            return (Criteria) this;
        }

        public Criteria andEnterCompareRiseIsNotNull() {
            addCriterion("enter_compare_rise is not null");
            return (Criteria) this;
        }

        public Criteria andEnterCompareRiseEqualTo(BigDecimal value) {
            addCriterion("enter_compare_rise =", value, "enterCompareRise");
            return (Criteria) this;
        }

        public Criteria andEnterCompareRiseNotEqualTo(BigDecimal value) {
            addCriterion("enter_compare_rise <>", value, "enterCompareRise");
            return (Criteria) this;
        }

        public Criteria andEnterCompareRiseGreaterThan(BigDecimal value) {
            addCriterion("enter_compare_rise >", value, "enterCompareRise");
            return (Criteria) this;
        }

        public Criteria andEnterCompareRiseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("enter_compare_rise >=", value, "enterCompareRise");
            return (Criteria) this;
        }

        public Criteria andEnterCompareRiseLessThan(BigDecimal value) {
            addCriterion("enter_compare_rise <", value, "enterCompareRise");
            return (Criteria) this;
        }

        public Criteria andEnterCompareRiseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("enter_compare_rise <=", value, "enterCompareRise");
            return (Criteria) this;
        }

        public Criteria andEnterCompareRiseIn(List<BigDecimal> values) {
            addCriterion("enter_compare_rise in", values, "enterCompareRise");
            return (Criteria) this;
        }

        public Criteria andEnterCompareRiseNotIn(List<BigDecimal> values) {
            addCriterion("enter_compare_rise not in", values, "enterCompareRise");
            return (Criteria) this;
        }

        public Criteria andEnterCompareRiseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enter_compare_rise between", value1, value2, "enterCompareRise");
            return (Criteria) this;
        }

        public Criteria andEnterCompareRiseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enter_compare_rise not between", value1, value2, "enterCompareRise");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseIsNull() {
            addCriterion("enter_random_rise is null");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseIsNotNull() {
            addCriterion("enter_random_rise is not null");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseEqualTo(BigDecimal value) {
            addCriterion("enter_random_rise =", value, "enterRandomRise");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseNotEqualTo(BigDecimal value) {
            addCriterion("enter_random_rise <>", value, "enterRandomRise");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseGreaterThan(BigDecimal value) {
            addCriterion("enter_random_rise >", value, "enterRandomRise");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("enter_random_rise >=", value, "enterRandomRise");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseLessThan(BigDecimal value) {
            addCriterion("enter_random_rise <", value, "enterRandomRise");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("enter_random_rise <=", value, "enterRandomRise");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseIn(List<BigDecimal> values) {
            addCriterion("enter_random_rise in", values, "enterRandomRise");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseNotIn(List<BigDecimal> values) {
            addCriterion("enter_random_rise not in", values, "enterRandomRise");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enter_random_rise between", value1, value2, "enterRandomRise");
            return (Criteria) this;
        }

        public Criteria andEnterRandomRiseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("enter_random_rise not between", value1, value2, "enterRandomRise");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseIsNull() {
            addCriterion("person_compare_rise is null");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseIsNotNull() {
            addCriterion("person_compare_rise is not null");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseEqualTo(BigDecimal value) {
            addCriterion("person_compare_rise =", value, "personCompareRise");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseNotEqualTo(BigDecimal value) {
            addCriterion("person_compare_rise <>", value, "personCompareRise");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseGreaterThan(BigDecimal value) {
            addCriterion("person_compare_rise >", value, "personCompareRise");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("person_compare_rise >=", value, "personCompareRise");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseLessThan(BigDecimal value) {
            addCriterion("person_compare_rise <", value, "personCompareRise");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("person_compare_rise <=", value, "personCompareRise");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseIn(List<BigDecimal> values) {
            addCriterion("person_compare_rise in", values, "personCompareRise");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseNotIn(List<BigDecimal> values) {
            addCriterion("person_compare_rise not in", values, "personCompareRise");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("person_compare_rise between", value1, value2, "personCompareRise");
            return (Criteria) this;
        }

        public Criteria andPersonCompareRiseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("person_compare_rise not between", value1, value2, "personCompareRise");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseIsNull() {
            addCriterion("person_random_rise is null");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseIsNotNull() {
            addCriterion("person_random_rise is not null");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseEqualTo(BigDecimal value) {
            addCriterion("person_random_rise =", value, "personRandomRise");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseNotEqualTo(BigDecimal value) {
            addCriterion("person_random_rise <>", value, "personRandomRise");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseGreaterThan(BigDecimal value) {
            addCriterion("person_random_rise >", value, "personRandomRise");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("person_random_rise >=", value, "personRandomRise");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseLessThan(BigDecimal value) {
            addCriterion("person_random_rise <", value, "personRandomRise");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("person_random_rise <=", value, "personRandomRise");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseIn(List<BigDecimal> values) {
            addCriterion("person_random_rise in", values, "personRandomRise");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseNotIn(List<BigDecimal> values) {
            addCriterion("person_random_rise not in", values, "personRandomRise");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("person_random_rise between", value1, value2, "personRandomRise");
            return (Criteria) this;
        }

        public Criteria andPersonRandomRiseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("person_random_rise not between", value1, value2, "personRandomRise");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceIsNull() {
            addCriterion("report_difference is null");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceIsNotNull() {
            addCriterion("report_difference is not null");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceEqualTo(BigDecimal value) {
            addCriterion("report_difference =", value, "reportDifference");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceNotEqualTo(BigDecimal value) {
            addCriterion("report_difference <>", value, "reportDifference");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceGreaterThan(BigDecimal value) {
            addCriterion("report_difference >", value, "reportDifference");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("report_difference >=", value, "reportDifference");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceLessThan(BigDecimal value) {
            addCriterion("report_difference <", value, "reportDifference");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("report_difference <=", value, "reportDifference");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceIn(List<BigDecimal> values) {
            addCriterion("report_difference in", values, "reportDifference");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceNotIn(List<BigDecimal> values) {
            addCriterion("report_difference not in", values, "reportDifference");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("report_difference between", value1, value2, "reportDifference");
            return (Criteria) this;
        }

        public Criteria andReportDifferenceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("report_difference not between", value1, value2, "reportDifference");
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