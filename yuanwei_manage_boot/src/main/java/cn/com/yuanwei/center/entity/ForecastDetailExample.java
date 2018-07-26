package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ForecastDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForecastDetailExample() {
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

        public Criteria andSntqRetailSalesIsNull() {
            addCriterion("sntq_retail_sales is null");
            return (Criteria) this;
        }

        public Criteria andSntqRetailSalesIsNotNull() {
            addCriterion("sntq_retail_sales is not null");
            return (Criteria) this;
        }

        public Criteria andSntqRetailSalesEqualTo(BigDecimal value) {
            addCriterion("sntq_retail_sales =", value, "sntqRetailSales");
            return (Criteria) this;
        }

        public Criteria andSntqRetailSalesNotEqualTo(BigDecimal value) {
            addCriterion("sntq_retail_sales <>", value, "sntqRetailSales");
            return (Criteria) this;
        }

        public Criteria andSntqRetailSalesGreaterThan(BigDecimal value) {
            addCriterion("sntq_retail_sales >", value, "sntqRetailSales");
            return (Criteria) this;
        }

        public Criteria andSntqRetailSalesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sntq_retail_sales >=", value, "sntqRetailSales");
            return (Criteria) this;
        }

        public Criteria andSntqRetailSalesLessThan(BigDecimal value) {
            addCriterion("sntq_retail_sales <", value, "sntqRetailSales");
            return (Criteria) this;
        }

        public Criteria andSntqRetailSalesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sntq_retail_sales <=", value, "sntqRetailSales");
            return (Criteria) this;
        }

        public Criteria andSntqRetailSalesIn(List<BigDecimal> values) {
            addCriterion("sntq_retail_sales in", values, "sntqRetailSales");
            return (Criteria) this;
        }

        public Criteria andSntqRetailSalesNotIn(List<BigDecimal> values) {
            addCriterion("sntq_retail_sales not in", values, "sntqRetailSales");
            return (Criteria) this;
        }

        public Criteria andSntqRetailSalesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sntq_retail_sales between", value1, value2, "sntqRetailSales");
            return (Criteria) this;
        }

        public Criteria andSntqRetailSalesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sntq_retail_sales not between", value1, value2, "sntqRetailSales");
            return (Criteria) this;
        }

        public Criteria andCompareRiseIsNull() {
            addCriterion("compare_rise is null");
            return (Criteria) this;
        }

        public Criteria andCompareRiseIsNotNull() {
            addCriterion("compare_rise is not null");
            return (Criteria) this;
        }

        public Criteria andCompareRiseEqualTo(BigDecimal value) {
            addCriterion("compare_rise =", value, "compareRise");
            return (Criteria) this;
        }

        public Criteria andCompareRiseNotEqualTo(BigDecimal value) {
            addCriterion("compare_rise <>", value, "compareRise");
            return (Criteria) this;
        }

        public Criteria andCompareRiseGreaterThan(BigDecimal value) {
            addCriterion("compare_rise >", value, "compareRise");
            return (Criteria) this;
        }

        public Criteria andCompareRiseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("compare_rise >=", value, "compareRise");
            return (Criteria) this;
        }

        public Criteria andCompareRiseLessThan(BigDecimal value) {
            addCriterion("compare_rise <", value, "compareRise");
            return (Criteria) this;
        }

        public Criteria andCompareRiseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("compare_rise <=", value, "compareRise");
            return (Criteria) this;
        }

        public Criteria andCompareRiseIn(List<BigDecimal> values) {
            addCriterion("compare_rise in", values, "compareRise");
            return (Criteria) this;
        }

        public Criteria andCompareRiseNotIn(List<BigDecimal> values) {
            addCriterion("compare_rise not in", values, "compareRise");
            return (Criteria) this;
        }

        public Criteria andCompareRiseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("compare_rise between", value1, value2, "compareRise");
            return (Criteria) this;
        }

        public Criteria andCompareRiseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("compare_rise not between", value1, value2, "compareRise");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesIsNull() {
            addCriterion("curr_retail_sales is null");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesIsNotNull() {
            addCriterion("curr_retail_sales is not null");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesEqualTo(BigDecimal value) {
            addCriterion("curr_retail_sales =", value, "currRetailSales");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesNotEqualTo(BigDecimal value) {
            addCriterion("curr_retail_sales <>", value, "currRetailSales");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesGreaterThan(BigDecimal value) {
            addCriterion("curr_retail_sales >", value, "currRetailSales");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_retail_sales >=", value, "currRetailSales");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesLessThan(BigDecimal value) {
            addCriterion("curr_retail_sales <", value, "currRetailSales");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_retail_sales <=", value, "currRetailSales");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesIn(List<BigDecimal> values) {
            addCriterion("curr_retail_sales in", values, "currRetailSales");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesNotIn(List<BigDecimal> values) {
            addCriterion("curr_retail_sales not in", values, "currRetailSales");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_retail_sales between", value1, value2, "currRetailSales");
            return (Criteria) this;
        }

        public Criteria andCurrRetailSalesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_retail_sales not between", value1, value2, "currRetailSales");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNull() {
            addCriterion("enterprise_type is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIsNotNull() {
            addCriterion("enterprise_type is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeEqualTo(Integer value) {
            addCriterion("enterprise_type =", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotEqualTo(Integer value) {
            addCriterion("enterprise_type <>", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThan(Integer value) {
            addCriterion("enterprise_type >", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_type >=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThan(Integer value) {
            addCriterion("enterprise_type <", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_type <=", value, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeIn(List<Integer> values) {
            addCriterion("enterprise_type in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotIn(List<Integer> values) {
            addCriterion("enterprise_type not in", values, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_type between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andEnterpriseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_type not between", value1, value2, "enterpriseType");
            return (Criteria) this;
        }

        public Criteria andInTypeIsNull() {
            addCriterion("in_type is null");
            return (Criteria) this;
        }

        public Criteria andInTypeIsNotNull() {
            addCriterion("in_type is not null");
            return (Criteria) this;
        }

        public Criteria andInTypeEqualTo(Integer value) {
            addCriterion("in_type =", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeNotEqualTo(Integer value) {
            addCriterion("in_type <>", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeGreaterThan(Integer value) {
            addCriterion("in_type >", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_type >=", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeLessThan(Integer value) {
            addCriterion("in_type <", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeLessThanOrEqualTo(Integer value) {
            addCriterion("in_type <=", value, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeIn(List<Integer> values) {
            addCriterion("in_type in", values, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeNotIn(List<Integer> values) {
            addCriterion("in_type not in", values, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeBetween(Integer value1, Integer value2) {
            addCriterion("in_type between", value1, value2, "inType");
            return (Criteria) this;
        }

        public Criteria andInTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("in_type not between", value1, value2, "inType");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
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