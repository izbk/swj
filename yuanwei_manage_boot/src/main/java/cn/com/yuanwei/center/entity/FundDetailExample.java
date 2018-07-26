package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FundDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundDetailExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andYearEqualTo(Date value) {
            addCriterionForJDBCDate("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Date value) {
            addCriterionForJDBCDate("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Date value) {
            addCriterionForJDBCDate("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Date value) {
            addCriterionForJDBCDate("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Date> values) {
            addCriterionForJDBCDate("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Date> values) {
            addCriterionForJDBCDate("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andFundIdIsNull() {
            addCriterion("fund_id is null");
            return (Criteria) this;
        }

        public Criteria andFundIdIsNotNull() {
            addCriterion("fund_id is not null");
            return (Criteria) this;
        }

        public Criteria andFundIdEqualTo(Integer value) {
            addCriterion("fund_id =", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdNotEqualTo(Integer value) {
            addCriterion("fund_id <>", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdGreaterThan(Integer value) {
            addCriterion("fund_id >", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fund_id >=", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdLessThan(Integer value) {
            addCriterion("fund_id <", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdLessThanOrEqualTo(Integer value) {
            addCriterion("fund_id <=", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdIn(List<Integer> values) {
            addCriterion("fund_id in", values, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdNotIn(List<Integer> values) {
            addCriterion("fund_id not in", values, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdBetween(Integer value1, Integer value2) {
            addCriterion("fund_id between", value1, value2, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fund_id not between", value1, value2, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundNameIsNull() {
            addCriterion("fund_name is null");
            return (Criteria) this;
        }

        public Criteria andFundNameIsNotNull() {
            addCriterion("fund_name is not null");
            return (Criteria) this;
        }

        public Criteria andFundNameEqualTo(String value) {
            addCriterion("fund_name =", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameNotEqualTo(String value) {
            addCriterion("fund_name <>", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameGreaterThan(String value) {
            addCriterion("fund_name >", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameGreaterThanOrEqualTo(String value) {
            addCriterion("fund_name >=", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameLessThan(String value) {
            addCriterion("fund_name <", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameLessThanOrEqualTo(String value) {
            addCriterion("fund_name <=", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameLike(String value) {
            addCriterion("fund_name like", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameNotLike(String value) {
            addCriterion("fund_name not like", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameIn(List<String> values) {
            addCriterion("fund_name in", values, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameNotIn(List<String> values) {
            addCriterion("fund_name not in", values, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameBetween(String value1, String value2) {
            addCriterion("fund_name between", value1, value2, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameNotBetween(String value1, String value2) {
            addCriterion("fund_name not between", value1, value2, "fundName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameIsNull() {
            addCriterion("enterpise_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameIsNotNull() {
            addCriterion("enterpise_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameEqualTo(String value) {
            addCriterion("enterpise_name =", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameNotEqualTo(String value) {
            addCriterion("enterpise_name <>", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameGreaterThan(String value) {
            addCriterion("enterpise_name >", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterpise_name >=", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameLessThan(String value) {
            addCriterion("enterpise_name <", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameLessThanOrEqualTo(String value) {
            addCriterion("enterpise_name <=", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameLike(String value) {
            addCriterion("enterpise_name like", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameNotLike(String value) {
            addCriterion("enterpise_name not like", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameIn(List<String> values) {
            addCriterion("enterpise_name in", values, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameNotIn(List<String> values) {
            addCriterion("enterpise_name not in", values, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameBetween(String value1, String value2) {
            addCriterion("enterpise_name between", value1, value2, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameNotBetween(String value1, String value2) {
            addCriterion("enterpise_name not between", value1, value2, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andApproDateIsNull() {
            addCriterion("appro_date is null");
            return (Criteria) this;
        }

        public Criteria andApproDateIsNotNull() {
            addCriterion("appro_date is not null");
            return (Criteria) this;
        }

        public Criteria andApproDateEqualTo(Date value) {
            addCriterion("appro_date =", value, "approDate");
            return (Criteria) this;
        }

        public Criteria andApproDateNotEqualTo(Date value) {
            addCriterion("appro_date <>", value, "approDate");
            return (Criteria) this;
        }

        public Criteria andApproDateGreaterThan(Date value) {
            addCriterion("appro_date >", value, "approDate");
            return (Criteria) this;
        }

        public Criteria andApproDateGreaterThanOrEqualTo(Date value) {
            addCriterion("appro_date >=", value, "approDate");
            return (Criteria) this;
        }

        public Criteria andApproDateLessThan(Date value) {
            addCriterion("appro_date <", value, "approDate");
            return (Criteria) this;
        }

        public Criteria andApproDateLessThanOrEqualTo(Date value) {
            addCriterion("appro_date <=", value, "approDate");
            return (Criteria) this;
        }

        public Criteria andApproDateIn(List<Date> values) {
            addCriterion("appro_date in", values, "approDate");
            return (Criteria) this;
        }

        public Criteria andApproDateNotIn(List<Date> values) {
            addCriterion("appro_date not in", values, "approDate");
            return (Criteria) this;
        }

        public Criteria andApproDateBetween(Date value1, Date value2) {
            addCriterion("appro_date between", value1, value2, "approDate");
            return (Criteria) this;
        }

        public Criteria andApproDateNotBetween(Date value1, Date value2) {
            addCriterion("appro_date not between", value1, value2, "approDate");
            return (Criteria) this;
        }

        public Criteria andApproAmountIsNull() {
            addCriterion("appro_amount is null");
            return (Criteria) this;
        }

        public Criteria andApproAmountIsNotNull() {
            addCriterion("appro_amount is not null");
            return (Criteria) this;
        }

        public Criteria andApproAmountEqualTo(BigDecimal value) {
            addCriterion("appro_amount =", value, "approAmount");
            return (Criteria) this;
        }

        public Criteria andApproAmountNotEqualTo(BigDecimal value) {
            addCriterion("appro_amount <>", value, "approAmount");
            return (Criteria) this;
        }

        public Criteria andApproAmountGreaterThan(BigDecimal value) {
            addCriterion("appro_amount >", value, "approAmount");
            return (Criteria) this;
        }

        public Criteria andApproAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("appro_amount >=", value, "approAmount");
            return (Criteria) this;
        }

        public Criteria andApproAmountLessThan(BigDecimal value) {
            addCriterion("appro_amount <", value, "approAmount");
            return (Criteria) this;
        }

        public Criteria andApproAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("appro_amount <=", value, "approAmount");
            return (Criteria) this;
        }

        public Criteria andApproAmountIn(List<BigDecimal> values) {
            addCriterion("appro_amount in", values, "approAmount");
            return (Criteria) this;
        }

        public Criteria andApproAmountNotIn(List<BigDecimal> values) {
            addCriterion("appro_amount not in", values, "approAmount");
            return (Criteria) this;
        }

        public Criteria andApproAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("appro_amount between", value1, value2, "approAmount");
            return (Criteria) this;
        }

        public Criteria andApproAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("appro_amount not between", value1, value2, "approAmount");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountIsNull() {
            addCriterion("real_appro_amount is null");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountIsNotNull() {
            addCriterion("real_appro_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountEqualTo(BigDecimal value) {
            addCriterion("real_appro_amount =", value, "realApproAmount");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountNotEqualTo(BigDecimal value) {
            addCriterion("real_appro_amount <>", value, "realApproAmount");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountGreaterThan(BigDecimal value) {
            addCriterion("real_appro_amount >", value, "realApproAmount");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_appro_amount >=", value, "realApproAmount");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountLessThan(BigDecimal value) {
            addCriterion("real_appro_amount <", value, "realApproAmount");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_appro_amount <=", value, "realApproAmount");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountIn(List<BigDecimal> values) {
            addCriterion("real_appro_amount in", values, "realApproAmount");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountNotIn(List<BigDecimal> values) {
            addCriterion("real_appro_amount not in", values, "realApproAmount");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_appro_amount between", value1, value2, "realApproAmount");
            return (Criteria) this;
        }

        public Criteria andRealApproAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_appro_amount not between", value1, value2, "realApproAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountIsNull() {
            addCriterion("surplus_appro_amount is null");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountIsNotNull() {
            addCriterion("surplus_appro_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountEqualTo(BigDecimal value) {
            addCriterion("surplus_appro_amount =", value, "surplusApproAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountNotEqualTo(BigDecimal value) {
            addCriterion("surplus_appro_amount <>", value, "surplusApproAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountGreaterThan(BigDecimal value) {
            addCriterion("surplus_appro_amount >", value, "surplusApproAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("surplus_appro_amount >=", value, "surplusApproAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountLessThan(BigDecimal value) {
            addCriterion("surplus_appro_amount <", value, "surplusApproAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("surplus_appro_amount <=", value, "surplusApproAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountIn(List<BigDecimal> values) {
            addCriterion("surplus_appro_amount in", values, "surplusApproAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountNotIn(List<BigDecimal> values) {
            addCriterion("surplus_appro_amount not in", values, "surplusApproAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("surplus_appro_amount between", value1, value2, "surplusApproAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusApproAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("surplus_appro_amount not between", value1, value2, "surplusApproAmount");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateIsNull() {
            addCriterion("acceptance_date is null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateIsNotNull() {
            addCriterion("acceptance_date is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateEqualTo(Date value) {
            addCriterionForJDBCDate("acceptance_date =", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("acceptance_date <>", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("acceptance_date >", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("acceptance_date >=", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateLessThan(Date value) {
            addCriterionForJDBCDate("acceptance_date <", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("acceptance_date <=", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateIn(List<Date> values) {
            addCriterionForJDBCDate("acceptance_date in", values, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("acceptance_date not in", values, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("acceptance_date between", value1, value2, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("acceptance_date not between", value1, value2, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andVoucherNoIsNull() {
            addCriterion("voucher_no is null");
            return (Criteria) this;
        }

        public Criteria andVoucherNoIsNotNull() {
            addCriterion("voucher_no is not null");
            return (Criteria) this;
        }

        public Criteria andVoucherNoEqualTo(String value) {
            addCriterion("voucher_no =", value, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andVoucherNoNotEqualTo(String value) {
            addCriterion("voucher_no <>", value, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andVoucherNoGreaterThan(String value) {
            addCriterion("voucher_no >", value, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andVoucherNoGreaterThanOrEqualTo(String value) {
            addCriterion("voucher_no >=", value, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andVoucherNoLessThan(String value) {
            addCriterion("voucher_no <", value, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andVoucherNoLessThanOrEqualTo(String value) {
            addCriterion("voucher_no <=", value, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andVoucherNoLike(String value) {
            addCriterion("voucher_no like", value, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andVoucherNoNotLike(String value) {
            addCriterion("voucher_no not like", value, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andVoucherNoIn(List<String> values) {
            addCriterion("voucher_no in", values, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andVoucherNoNotIn(List<String> values) {
            addCriterion("voucher_no not in", values, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andVoucherNoBetween(String value1, String value2) {
            addCriterion("voucher_no between", value1, value2, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andVoucherNoNotBetween(String value1, String value2) {
            addCriterion("voucher_no not between", value1, value2, "voucherNo");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
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

        public Criteria andFundNameLikeInsensitive(String value) {
            addCriterion("upper(fund_name) like", value.toUpperCase(), "fundName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLikeInsensitive(String value) {
            addCriterion("upper(project_name) like", value.toUpperCase(), "projectName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameLikeInsensitive(String value) {
            addCriterion("upper(enterpise_name) like", value.toUpperCase(), "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andVoucherNoLikeInsensitive(String value) {
            addCriterion("upper(voucher_no) like", value.toUpperCase(), "voucherNo");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andCreateNameLikeInsensitive(String value) {
            addCriterion("upper(create_name) like", value.toUpperCase(), "createName");
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