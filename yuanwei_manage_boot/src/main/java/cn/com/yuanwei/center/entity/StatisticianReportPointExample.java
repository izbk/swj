package cn.com.yuanwei.center.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticianReportPointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticianReportPointExample() {
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

        public Criteria andEnterpriseCodeIsNull() {
            addCriterion("enterprise_code is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeIsNotNull() {
            addCriterion("enterprise_code is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeEqualTo(String value) {
            addCriterion("enterprise_code =", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotEqualTo(String value) {
            addCriterion("enterprise_code <>", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeGreaterThan(String value) {
            addCriterion("enterprise_code >", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_code >=", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeLessThan(String value) {
            addCriterion("enterprise_code <", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeLessThanOrEqualTo(String value) {
            addCriterion("enterprise_code <=", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeLike(String value) {
            addCriterion("enterprise_code like", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotLike(String value) {
            addCriterion("enterprise_code not like", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeIn(List<String> values) {
            addCriterion("enterprise_code in", values, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotIn(List<String> values) {
            addCriterion("enterprise_code not in", values, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeBetween(String value1, String value2) {
            addCriterion("enterprise_code between", value1, value2, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotBetween(String value1, String value2) {
            addCriterion("enterprise_code not between", value1, value2, "enterpriseCode");
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

        public Criteria andStatisticianNameIsNull() {
            addCriterion("statistician_name is null");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameIsNotNull() {
            addCriterion("statistician_name is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameEqualTo(String value) {
            addCriterion("statistician_name =", value, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameNotEqualTo(String value) {
            addCriterion("statistician_name <>", value, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameGreaterThan(String value) {
            addCriterion("statistician_name >", value, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameGreaterThanOrEqualTo(String value) {
            addCriterion("statistician_name >=", value, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameLessThan(String value) {
            addCriterion("statistician_name <", value, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameLessThanOrEqualTo(String value) {
            addCriterion("statistician_name <=", value, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameLike(String value) {
            addCriterion("statistician_name like", value, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameNotLike(String value) {
            addCriterion("statistician_name not like", value, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameIn(List<String> values) {
            addCriterion("statistician_name in", values, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameNotIn(List<String> values) {
            addCriterion("statistician_name not in", values, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameBetween(String value1, String value2) {
            addCriterion("statistician_name between", value1, value2, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameNotBetween(String value1, String value2) {
            addCriterion("statistician_name not between", value1, value2, "statisticianName");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdIsNull() {
            addCriterion("deduct_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdIsNotNull() {
            addCriterion("deduct_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdEqualTo(Integer value) {
            addCriterion("deduct_rule_id =", value, "deductRuleId");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdNotEqualTo(Integer value) {
            addCriterion("deduct_rule_id <>", value, "deductRuleId");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdGreaterThan(Integer value) {
            addCriterion("deduct_rule_id >", value, "deductRuleId");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("deduct_rule_id >=", value, "deductRuleId");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdLessThan(Integer value) {
            addCriterion("deduct_rule_id <", value, "deductRuleId");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("deduct_rule_id <=", value, "deductRuleId");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdIn(List<Integer> values) {
            addCriterion("deduct_rule_id in", values, "deductRuleId");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdNotIn(List<Integer> values) {
            addCriterion("deduct_rule_id not in", values, "deductRuleId");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdBetween(Integer value1, Integer value2) {
            addCriterion("deduct_rule_id between", value1, value2, "deductRuleId");
            return (Criteria) this;
        }

        public Criteria andDeductRuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("deduct_rule_id not between", value1, value2, "deductRuleId");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdIsNull() {
            addCriterion("increase_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdIsNotNull() {
            addCriterion("increase_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdEqualTo(Integer value) {
            addCriterion("increase_rule_id =", value, "increaseRuleId");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdNotEqualTo(Integer value) {
            addCriterion("increase_rule_id <>", value, "increaseRuleId");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdGreaterThan(Integer value) {
            addCriterion("increase_rule_id >", value, "increaseRuleId");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("increase_rule_id >=", value, "increaseRuleId");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdLessThan(Integer value) {
            addCriterion("increase_rule_id <", value, "increaseRuleId");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("increase_rule_id <=", value, "increaseRuleId");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdIn(List<Integer> values) {
            addCriterion("increase_rule_id in", values, "increaseRuleId");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdNotIn(List<Integer> values) {
            addCriterion("increase_rule_id not in", values, "increaseRuleId");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdBetween(Integer value1, Integer value2) {
            addCriterion("increase_rule_id between", value1, value2, "increaseRuleId");
            return (Criteria) this;
        }

        public Criteria andIncreaseRuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("increase_rule_id not between", value1, value2, "increaseRuleId");
            return (Criteria) this;
        }

        public Criteria andDeductPointIsNull() {
            addCriterion("deduct_point is null");
            return (Criteria) this;
        }

        public Criteria andDeductPointIsNotNull() {
            addCriterion("deduct_point is not null");
            return (Criteria) this;
        }

        public Criteria andDeductPointEqualTo(Integer value) {
            addCriterion("deduct_point =", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointNotEqualTo(Integer value) {
            addCriterion("deduct_point <>", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointGreaterThan(Integer value) {
            addCriterion("deduct_point >", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("deduct_point >=", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointLessThan(Integer value) {
            addCriterion("deduct_point <", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointLessThanOrEqualTo(Integer value) {
            addCriterion("deduct_point <=", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointIn(List<Integer> values) {
            addCriterion("deduct_point in", values, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointNotIn(List<Integer> values) {
            addCriterion("deduct_point not in", values, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointBetween(Integer value1, Integer value2) {
            addCriterion("deduct_point between", value1, value2, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointNotBetween(Integer value1, Integer value2) {
            addCriterion("deduct_point not between", value1, value2, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andIncreasePointIsNull() {
            addCriterion("increase_point is null");
            return (Criteria) this;
        }

        public Criteria andIncreasePointIsNotNull() {
            addCriterion("increase_point is not null");
            return (Criteria) this;
        }

        public Criteria andIncreasePointEqualTo(Integer value) {
            addCriterion("increase_point =", value, "increasePoint");
            return (Criteria) this;
        }

        public Criteria andIncreasePointNotEqualTo(Integer value) {
            addCriterion("increase_point <>", value, "increasePoint");
            return (Criteria) this;
        }

        public Criteria andIncreasePointGreaterThan(Integer value) {
            addCriterion("increase_point >", value, "increasePoint");
            return (Criteria) this;
        }

        public Criteria andIncreasePointGreaterThanOrEqualTo(Integer value) {
            addCriterion("increase_point >=", value, "increasePoint");
            return (Criteria) this;
        }

        public Criteria andIncreasePointLessThan(Integer value) {
            addCriterion("increase_point <", value, "increasePoint");
            return (Criteria) this;
        }

        public Criteria andIncreasePointLessThanOrEqualTo(Integer value) {
            addCriterion("increase_point <=", value, "increasePoint");
            return (Criteria) this;
        }

        public Criteria andIncreasePointIn(List<Integer> values) {
            addCriterion("increase_point in", values, "increasePoint");
            return (Criteria) this;
        }

        public Criteria andIncreasePointNotIn(List<Integer> values) {
            addCriterion("increase_point not in", values, "increasePoint");
            return (Criteria) this;
        }

        public Criteria andIncreasePointBetween(Integer value1, Integer value2) {
            addCriterion("increase_point between", value1, value2, "increasePoint");
            return (Criteria) this;
        }

        public Criteria andIncreasePointNotBetween(Integer value1, Integer value2) {
            addCriterion("increase_point not between", value1, value2, "increasePoint");
            return (Criteria) this;
        }

        public Criteria andReportPointIsNull() {
            addCriterion("report_point is null");
            return (Criteria) this;
        }

        public Criteria andReportPointIsNotNull() {
            addCriterion("report_point is not null");
            return (Criteria) this;
        }

        public Criteria andReportPointEqualTo(Integer value) {
            addCriterion("report_point =", value, "reportPoint");
            return (Criteria) this;
        }

        public Criteria andReportPointNotEqualTo(Integer value) {
            addCriterion("report_point <>", value, "reportPoint");
            return (Criteria) this;
        }

        public Criteria andReportPointGreaterThan(Integer value) {
            addCriterion("report_point >", value, "reportPoint");
            return (Criteria) this;
        }

        public Criteria andReportPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_point >=", value, "reportPoint");
            return (Criteria) this;
        }

        public Criteria andReportPointLessThan(Integer value) {
            addCriterion("report_point <", value, "reportPoint");
            return (Criteria) this;
        }

        public Criteria andReportPointLessThanOrEqualTo(Integer value) {
            addCriterion("report_point <=", value, "reportPoint");
            return (Criteria) this;
        }

        public Criteria andReportPointIn(List<Integer> values) {
            addCriterion("report_point in", values, "reportPoint");
            return (Criteria) this;
        }

        public Criteria andReportPointNotIn(List<Integer> values) {
            addCriterion("report_point not in", values, "reportPoint");
            return (Criteria) this;
        }

        public Criteria andReportPointBetween(Integer value1, Integer value2) {
            addCriterion("report_point between", value1, value2, "reportPoint");
            return (Criteria) this;
        }

        public Criteria andReportPointNotBetween(Integer value1, Integer value2) {
            addCriterion("report_point not between", value1, value2, "reportPoint");
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

        public Criteria andEnterpriseCodeLikeInsensitive(String value) {
            addCriterion("upper(enterprise_code) like", value.toUpperCase(), "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLikeInsensitive(String value) {
            addCriterion("upper(enterprise_name) like", value.toUpperCase(), "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andStatisticianNameLikeInsensitive(String value) {
            addCriterion("upper(statistician_name) like", value.toUpperCase(), "statisticianName");
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