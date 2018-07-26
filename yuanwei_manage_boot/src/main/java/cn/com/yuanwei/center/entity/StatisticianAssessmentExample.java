package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StatisticianAssessmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticianAssessmentExample() {
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

        public Criteria andRewardIdIsNull() {
            addCriterion("reward_id is null");
            return (Criteria) this;
        }

        public Criteria andRewardIdIsNotNull() {
            addCriterion("reward_id is not null");
            return (Criteria) this;
        }

        public Criteria andRewardIdEqualTo(Integer value) {
            addCriterion("reward_id =", value, "rewardId");
            return (Criteria) this;
        }

        public Criteria andRewardIdNotEqualTo(Integer value) {
            addCriterion("reward_id <>", value, "rewardId");
            return (Criteria) this;
        }

        public Criteria andRewardIdGreaterThan(Integer value) {
            addCriterion("reward_id >", value, "rewardId");
            return (Criteria) this;
        }

        public Criteria andRewardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reward_id >=", value, "rewardId");
            return (Criteria) this;
        }

        public Criteria andRewardIdLessThan(Integer value) {
            addCriterion("reward_id <", value, "rewardId");
            return (Criteria) this;
        }

        public Criteria andRewardIdLessThanOrEqualTo(Integer value) {
            addCriterion("reward_id <=", value, "rewardId");
            return (Criteria) this;
        }

        public Criteria andRewardIdIn(List<Integer> values) {
            addCriterion("reward_id in", values, "rewardId");
            return (Criteria) this;
        }

        public Criteria andRewardIdNotIn(List<Integer> values) {
            addCriterion("reward_id not in", values, "rewardId");
            return (Criteria) this;
        }

        public Criteria andRewardIdBetween(Integer value1, Integer value2) {
            addCriterion("reward_id between", value1, value2, "rewardId");
            return (Criteria) this;
        }

        public Criteria andRewardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reward_id not between", value1, value2, "rewardId");
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

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
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

        public Criteria andRetailSalesDoneIsNull() {
            addCriterion("retail_sales_done is null");
            return (Criteria) this;
        }

        public Criteria andRetailSalesDoneIsNotNull() {
            addCriterion("retail_sales_done is not null");
            return (Criteria) this;
        }

        public Criteria andRetailSalesDoneEqualTo(BigDecimal value) {
            addCriterion("retail_sales_done =", value, "retailSalesDone");
            return (Criteria) this;
        }

        public Criteria andRetailSalesDoneNotEqualTo(BigDecimal value) {
            addCriterion("retail_sales_done <>", value, "retailSalesDone");
            return (Criteria) this;
        }

        public Criteria andRetailSalesDoneGreaterThan(BigDecimal value) {
            addCriterion("retail_sales_done >", value, "retailSalesDone");
            return (Criteria) this;
        }

        public Criteria andRetailSalesDoneGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("retail_sales_done >=", value, "retailSalesDone");
            return (Criteria) this;
        }

        public Criteria andRetailSalesDoneLessThan(BigDecimal value) {
            addCriterion("retail_sales_done <", value, "retailSalesDone");
            return (Criteria) this;
        }

        public Criteria andRetailSalesDoneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("retail_sales_done <=", value, "retailSalesDone");
            return (Criteria) this;
        }

        public Criteria andRetailSalesDoneIn(List<BigDecimal> values) {
            addCriterion("retail_sales_done in", values, "retailSalesDone");
            return (Criteria) this;
        }

        public Criteria andRetailSalesDoneNotIn(List<BigDecimal> values) {
            addCriterion("retail_sales_done not in", values, "retailSalesDone");
            return (Criteria) this;
        }

        public Criteria andRetailSalesDoneBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retail_sales_done between", value1, value2, "retailSalesDone");
            return (Criteria) this;
        }

        public Criteria andRetailSalesDoneNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retail_sales_done not between", value1, value2, "retailSalesDone");
            return (Criteria) this;
        }

        public Criteria andSalesDoneIsNull() {
            addCriterion("sales_done is null");
            return (Criteria) this;
        }

        public Criteria andSalesDoneIsNotNull() {
            addCriterion("sales_done is not null");
            return (Criteria) this;
        }

        public Criteria andSalesDoneEqualTo(BigDecimal value) {
            addCriterion("sales_done =", value, "salesDone");
            return (Criteria) this;
        }

        public Criteria andSalesDoneNotEqualTo(BigDecimal value) {
            addCriterion("sales_done <>", value, "salesDone");
            return (Criteria) this;
        }

        public Criteria andSalesDoneGreaterThan(BigDecimal value) {
            addCriterion("sales_done >", value, "salesDone");
            return (Criteria) this;
        }

        public Criteria andSalesDoneGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_done >=", value, "salesDone");
            return (Criteria) this;
        }

        public Criteria andSalesDoneLessThan(BigDecimal value) {
            addCriterion("sales_done <", value, "salesDone");
            return (Criteria) this;
        }

        public Criteria andSalesDoneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_done <=", value, "salesDone");
            return (Criteria) this;
        }

        public Criteria andSalesDoneIn(List<BigDecimal> values) {
            addCriterion("sales_done in", values, "salesDone");
            return (Criteria) this;
        }

        public Criteria andSalesDoneNotIn(List<BigDecimal> values) {
            addCriterion("sales_done not in", values, "salesDone");
            return (Criteria) this;
        }

        public Criteria andSalesDoneBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_done between", value1, value2, "salesDone");
            return (Criteria) this;
        }

        public Criteria andSalesDoneNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_done not between", value1, value2, "salesDone");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointIsNull() {
            addCriterion("retail_sales_point is null");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointIsNotNull() {
            addCriterion("retail_sales_point is not null");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointEqualTo(Integer value) {
            addCriterion("retail_sales_point =", value, "retailSalesPoint");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointNotEqualTo(Integer value) {
            addCriterion("retail_sales_point <>", value, "retailSalesPoint");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointGreaterThan(Integer value) {
            addCriterion("retail_sales_point >", value, "retailSalesPoint");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("retail_sales_point >=", value, "retailSalesPoint");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointLessThan(Integer value) {
            addCriterion("retail_sales_point <", value, "retailSalesPoint");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointLessThanOrEqualTo(Integer value) {
            addCriterion("retail_sales_point <=", value, "retailSalesPoint");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointIn(List<Integer> values) {
            addCriterion("retail_sales_point in", values, "retailSalesPoint");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointNotIn(List<Integer> values) {
            addCriterion("retail_sales_point not in", values, "retailSalesPoint");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointBetween(Integer value1, Integer value2) {
            addCriterion("retail_sales_point between", value1, value2, "retailSalesPoint");
            return (Criteria) this;
        }

        public Criteria andRetailSalesPointNotBetween(Integer value1, Integer value2) {
            addCriterion("retail_sales_point not between", value1, value2, "retailSalesPoint");
            return (Criteria) this;
        }

        public Criteria andSalesPointIsNull() {
            addCriterion("sales_point is null");
            return (Criteria) this;
        }

        public Criteria andSalesPointIsNotNull() {
            addCriterion("sales_point is not null");
            return (Criteria) this;
        }

        public Criteria andSalesPointEqualTo(Integer value) {
            addCriterion("sales_point =", value, "salesPoint");
            return (Criteria) this;
        }

        public Criteria andSalesPointNotEqualTo(Integer value) {
            addCriterion("sales_point <>", value, "salesPoint");
            return (Criteria) this;
        }

        public Criteria andSalesPointGreaterThan(Integer value) {
            addCriterion("sales_point >", value, "salesPoint");
            return (Criteria) this;
        }

        public Criteria andSalesPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_point >=", value, "salesPoint");
            return (Criteria) this;
        }

        public Criteria andSalesPointLessThan(Integer value) {
            addCriterion("sales_point <", value, "salesPoint");
            return (Criteria) this;
        }

        public Criteria andSalesPointLessThanOrEqualTo(Integer value) {
            addCriterion("sales_point <=", value, "salesPoint");
            return (Criteria) this;
        }

        public Criteria andSalesPointIn(List<Integer> values) {
            addCriterion("sales_point in", values, "salesPoint");
            return (Criteria) this;
        }

        public Criteria andSalesPointNotIn(List<Integer> values) {
            addCriterion("sales_point not in", values, "salesPoint");
            return (Criteria) this;
        }

        public Criteria andSalesPointBetween(Integer value1, Integer value2) {
            addCriterion("sales_point between", value1, value2, "salesPoint");
            return (Criteria) this;
        }

        public Criteria andSalesPointNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_point not between", value1, value2, "salesPoint");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointIsNull() {
            addCriterion("qualifying_point is null");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointIsNotNull() {
            addCriterion("qualifying_point is not null");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointEqualTo(Integer value) {
            addCriterion("qualifying_point =", value, "qualifyingPoint");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointNotEqualTo(Integer value) {
            addCriterion("qualifying_point <>", value, "qualifyingPoint");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointGreaterThan(Integer value) {
            addCriterion("qualifying_point >", value, "qualifyingPoint");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("qualifying_point >=", value, "qualifyingPoint");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointLessThan(Integer value) {
            addCriterion("qualifying_point <", value, "qualifyingPoint");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointLessThanOrEqualTo(Integer value) {
            addCriterion("qualifying_point <=", value, "qualifyingPoint");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointIn(List<Integer> values) {
            addCriterion("qualifying_point in", values, "qualifyingPoint");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointNotIn(List<Integer> values) {
            addCriterion("qualifying_point not in", values, "qualifyingPoint");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointBetween(Integer value1, Integer value2) {
            addCriterion("qualifying_point between", value1, value2, "qualifyingPoint");
            return (Criteria) this;
        }

        public Criteria andQualifyingPointNotBetween(Integer value1, Integer value2) {
            addCriterion("qualifying_point not between", value1, value2, "qualifyingPoint");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioIsNull() {
            addCriterion("retail_compare_ratio is null");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioIsNotNull() {
            addCriterion("retail_compare_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioEqualTo(BigDecimal value) {
            addCriterion("retail_compare_ratio =", value, "retailCompareRatio");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioNotEqualTo(BigDecimal value) {
            addCriterion("retail_compare_ratio <>", value, "retailCompareRatio");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioGreaterThan(BigDecimal value) {
            addCriterion("retail_compare_ratio >", value, "retailCompareRatio");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("retail_compare_ratio >=", value, "retailCompareRatio");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioLessThan(BigDecimal value) {
            addCriterion("retail_compare_ratio <", value, "retailCompareRatio");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("retail_compare_ratio <=", value, "retailCompareRatio");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioIn(List<BigDecimal> values) {
            addCriterion("retail_compare_ratio in", values, "retailCompareRatio");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioNotIn(List<BigDecimal> values) {
            addCriterion("retail_compare_ratio not in", values, "retailCompareRatio");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retail_compare_ratio between", value1, value2, "retailCompareRatio");
            return (Criteria) this;
        }

        public Criteria andRetailCompareRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retail_compare_ratio not between", value1, value2, "retailCompareRatio");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioIsNull() {
            addCriterion("sale_compare_ratio is null");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioIsNotNull() {
            addCriterion("sale_compare_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioEqualTo(BigDecimal value) {
            addCriterion("sale_compare_ratio =", value, "saleCompareRatio");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioNotEqualTo(BigDecimal value) {
            addCriterion("sale_compare_ratio <>", value, "saleCompareRatio");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioGreaterThan(BigDecimal value) {
            addCriterion("sale_compare_ratio >", value, "saleCompareRatio");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_compare_ratio >=", value, "saleCompareRatio");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioLessThan(BigDecimal value) {
            addCriterion("sale_compare_ratio <", value, "saleCompareRatio");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_compare_ratio <=", value, "saleCompareRatio");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioIn(List<BigDecimal> values) {
            addCriterion("sale_compare_ratio in", values, "saleCompareRatio");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioNotIn(List<BigDecimal> values) {
            addCriterion("sale_compare_ratio not in", values, "saleCompareRatio");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_compare_ratio between", value1, value2, "saleCompareRatio");
            return (Criteria) this;
        }

        public Criteria andSaleCompareRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_compare_ratio not between", value1, value2, "saleCompareRatio");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointIsNull() {
            addCriterion("retail_growth_point is null");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointIsNotNull() {
            addCriterion("retail_growth_point is not null");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointEqualTo(Integer value) {
            addCriterion("retail_growth_point =", value, "retailGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointNotEqualTo(Integer value) {
            addCriterion("retail_growth_point <>", value, "retailGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointGreaterThan(Integer value) {
            addCriterion("retail_growth_point >", value, "retailGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("retail_growth_point >=", value, "retailGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointLessThan(Integer value) {
            addCriterion("retail_growth_point <", value, "retailGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointLessThanOrEqualTo(Integer value) {
            addCriterion("retail_growth_point <=", value, "retailGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointIn(List<Integer> values) {
            addCriterion("retail_growth_point in", values, "retailGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointNotIn(List<Integer> values) {
            addCriterion("retail_growth_point not in", values, "retailGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointBetween(Integer value1, Integer value2) {
            addCriterion("retail_growth_point between", value1, value2, "retailGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andRetailGrowthPointNotBetween(Integer value1, Integer value2) {
            addCriterion("retail_growth_point not between", value1, value2, "retailGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointIsNull() {
            addCriterion("sales_growth_point is null");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointIsNotNull() {
            addCriterion("sales_growth_point is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointEqualTo(Integer value) {
            addCriterion("sales_growth_point =", value, "salesGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointNotEqualTo(Integer value) {
            addCriterion("sales_growth_point <>", value, "salesGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointGreaterThan(Integer value) {
            addCriterion("sales_growth_point >", value, "salesGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_growth_point >=", value, "salesGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointLessThan(Integer value) {
            addCriterion("sales_growth_point <", value, "salesGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointLessThanOrEqualTo(Integer value) {
            addCriterion("sales_growth_point <=", value, "salesGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointIn(List<Integer> values) {
            addCriterion("sales_growth_point in", values, "salesGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointNotIn(List<Integer> values) {
            addCriterion("sales_growth_point not in", values, "salesGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointBetween(Integer value1, Integer value2) {
            addCriterion("sales_growth_point between", value1, value2, "salesGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthPointNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_growth_point not between", value1, value2, "salesGrowthPoint");
            return (Criteria) this;
        }

        public Criteria andGrowthPointIsNull() {
            addCriterion("growth_point is null");
            return (Criteria) this;
        }

        public Criteria andGrowthPointIsNotNull() {
            addCriterion("growth_point is not null");
            return (Criteria) this;
        }

        public Criteria andGrowthPointEqualTo(Integer value) {
            addCriterion("growth_point =", value, "growthPoint");
            return (Criteria) this;
        }

        public Criteria andGrowthPointNotEqualTo(Integer value) {
            addCriterion("growth_point <>", value, "growthPoint");
            return (Criteria) this;
        }

        public Criteria andGrowthPointGreaterThan(Integer value) {
            addCriterion("growth_point >", value, "growthPoint");
            return (Criteria) this;
        }

        public Criteria andGrowthPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("growth_point >=", value, "growthPoint");
            return (Criteria) this;
        }

        public Criteria andGrowthPointLessThan(Integer value) {
            addCriterion("growth_point <", value, "growthPoint");
            return (Criteria) this;
        }

        public Criteria andGrowthPointLessThanOrEqualTo(Integer value) {
            addCriterion("growth_point <=", value, "growthPoint");
            return (Criteria) this;
        }

        public Criteria andGrowthPointIn(List<Integer> values) {
            addCriterion("growth_point in", values, "growthPoint");
            return (Criteria) this;
        }

        public Criteria andGrowthPointNotIn(List<Integer> values) {
            addCriterion("growth_point not in", values, "growthPoint");
            return (Criteria) this;
        }

        public Criteria andGrowthPointBetween(Integer value1, Integer value2) {
            addCriterion("growth_point between", value1, value2, "growthPoint");
            return (Criteria) this;
        }

        public Criteria andGrowthPointNotBetween(Integer value1, Integer value2) {
            addCriterion("growth_point not between", value1, value2, "growthPoint");
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

        public Criteria andTotalPointIsNull() {
            addCriterion("total_point is null");
            return (Criteria) this;
        }

        public Criteria andTotalPointIsNotNull() {
            addCriterion("total_point is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPointEqualTo(Integer value) {
            addCriterion("total_point =", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointNotEqualTo(Integer value) {
            addCriterion("total_point <>", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointGreaterThan(Integer value) {
            addCriterion("total_point >", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_point >=", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointLessThan(Integer value) {
            addCriterion("total_point <", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointLessThanOrEqualTo(Integer value) {
            addCriterion("total_point <=", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointIn(List<Integer> values) {
            addCriterion("total_point in", values, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointNotIn(List<Integer> values) {
            addCriterion("total_point not in", values, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointBetween(Integer value1, Integer value2) {
            addCriterion("total_point between", value1, value2, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointNotBetween(Integer value1, Integer value2) {
            addCriterion("total_point not between", value1, value2, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andPerPointValueIsNull() {
            addCriterion("per_point_value is null");
            return (Criteria) this;
        }

        public Criteria andPerPointValueIsNotNull() {
            addCriterion("per_point_value is not null");
            return (Criteria) this;
        }

        public Criteria andPerPointValueEqualTo(BigDecimal value) {
            addCriterion("per_point_value =", value, "perPointValue");
            return (Criteria) this;
        }

        public Criteria andPerPointValueNotEqualTo(BigDecimal value) {
            addCriterion("per_point_value <>", value, "perPointValue");
            return (Criteria) this;
        }

        public Criteria andPerPointValueGreaterThan(BigDecimal value) {
            addCriterion("per_point_value >", value, "perPointValue");
            return (Criteria) this;
        }

        public Criteria andPerPointValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("per_point_value >=", value, "perPointValue");
            return (Criteria) this;
        }

        public Criteria andPerPointValueLessThan(BigDecimal value) {
            addCriterion("per_point_value <", value, "perPointValue");
            return (Criteria) this;
        }

        public Criteria andPerPointValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("per_point_value <=", value, "perPointValue");
            return (Criteria) this;
        }

        public Criteria andPerPointValueIn(List<BigDecimal> values) {
            addCriterion("per_point_value in", values, "perPointValue");
            return (Criteria) this;
        }

        public Criteria andPerPointValueNotIn(List<BigDecimal> values) {
            addCriterion("per_point_value not in", values, "perPointValue");
            return (Criteria) this;
        }

        public Criteria andPerPointValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_point_value between", value1, value2, "perPointValue");
            return (Criteria) this;
        }

        public Criteria andPerPointValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_point_value not between", value1, value2, "perPointValue");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNull() {
            addCriterion("allowance is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNotNull() {
            addCriterion("allowance is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceEqualTo(BigDecimal value) {
            addCriterion("allowance =", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotEqualTo(BigDecimal value) {
            addCriterion("allowance <>", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThan(BigDecimal value) {
            addCriterion("allowance >", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("allowance >=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThan(BigDecimal value) {
            addCriterion("allowance <", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("allowance <=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceIn(List<BigDecimal> values) {
            addCriterion("allowance in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotIn(List<BigDecimal> values) {
            addCriterion("allowance not in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("allowance between", value1, value2, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("allowance not between", value1, value2, "allowance");
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