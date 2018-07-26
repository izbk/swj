package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TownshipAnnualDoneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TownshipAnnualDoneExample() {
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

        public Criteria andGrossDoneIsNull() {
            addCriterion("gross_done is null");
            return (Criteria) this;
        }

        public Criteria andGrossDoneIsNotNull() {
            addCriterion("gross_done is not null");
            return (Criteria) this;
        }

        public Criteria andGrossDoneEqualTo(BigDecimal value) {
            addCriterion("gross_done =", value, "grossDone");
            return (Criteria) this;
        }

        public Criteria andGrossDoneNotEqualTo(BigDecimal value) {
            addCriterion("gross_done <>", value, "grossDone");
            return (Criteria) this;
        }

        public Criteria andGrossDoneGreaterThan(BigDecimal value) {
            addCriterion("gross_done >", value, "grossDone");
            return (Criteria) this;
        }

        public Criteria andGrossDoneGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gross_done >=", value, "grossDone");
            return (Criteria) this;
        }

        public Criteria andGrossDoneLessThan(BigDecimal value) {
            addCriterion("gross_done <", value, "grossDone");
            return (Criteria) this;
        }

        public Criteria andGrossDoneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gross_done <=", value, "grossDone");
            return (Criteria) this;
        }

        public Criteria andGrossDoneIn(List<BigDecimal> values) {
            addCriterion("gross_done in", values, "grossDone");
            return (Criteria) this;
        }

        public Criteria andGrossDoneNotIn(List<BigDecimal> values) {
            addCriterion("gross_done not in", values, "grossDone");
            return (Criteria) this;
        }

        public Criteria andGrossDoneBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gross_done between", value1, value2, "grossDone");
            return (Criteria) this;
        }

        public Criteria andGrossDoneNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gross_done not between", value1, value2, "grossDone");
            return (Criteria) this;
        }

        public Criteria andDoneRatioIsNull() {
            addCriterion("done_ratio is null");
            return (Criteria) this;
        }

        public Criteria andDoneRatioIsNotNull() {
            addCriterion("done_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andDoneRatioEqualTo(BigDecimal value) {
            addCriterion("done_ratio =", value, "doneRatio");
            return (Criteria) this;
        }

        public Criteria andDoneRatioNotEqualTo(BigDecimal value) {
            addCriterion("done_ratio <>", value, "doneRatio");
            return (Criteria) this;
        }

        public Criteria andDoneRatioGreaterThan(BigDecimal value) {
            addCriterion("done_ratio >", value, "doneRatio");
            return (Criteria) this;
        }

        public Criteria andDoneRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("done_ratio >=", value, "doneRatio");
            return (Criteria) this;
        }

        public Criteria andDoneRatioLessThan(BigDecimal value) {
            addCriterion("done_ratio <", value, "doneRatio");
            return (Criteria) this;
        }

        public Criteria andDoneRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("done_ratio <=", value, "doneRatio");
            return (Criteria) this;
        }

        public Criteria andDoneRatioIn(List<BigDecimal> values) {
            addCriterion("done_ratio in", values, "doneRatio");
            return (Criteria) this;
        }

        public Criteria andDoneRatioNotIn(List<BigDecimal> values) {
            addCriterion("done_ratio not in", values, "doneRatio");
            return (Criteria) this;
        }

        public Criteria andDoneRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("done_ratio between", value1, value2, "doneRatio");
            return (Criteria) this;
        }

        public Criteria andDoneRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("done_ratio not between", value1, value2, "doneRatio");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthIsNull() {
            addCriterion("retail_sales_growth is null");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthIsNotNull() {
            addCriterion("retail_sales_growth is not null");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthEqualTo(BigDecimal value) {
            addCriterion("retail_sales_growth =", value, "retailSalesGrowth");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthNotEqualTo(BigDecimal value) {
            addCriterion("retail_sales_growth <>", value, "retailSalesGrowth");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthGreaterThan(BigDecimal value) {
            addCriterion("retail_sales_growth >", value, "retailSalesGrowth");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("retail_sales_growth >=", value, "retailSalesGrowth");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthLessThan(BigDecimal value) {
            addCriterion("retail_sales_growth <", value, "retailSalesGrowth");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("retail_sales_growth <=", value, "retailSalesGrowth");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthIn(List<BigDecimal> values) {
            addCriterion("retail_sales_growth in", values, "retailSalesGrowth");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthNotIn(List<BigDecimal> values) {
            addCriterion("retail_sales_growth not in", values, "retailSalesGrowth");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retail_sales_growth between", value1, value2, "retailSalesGrowth");
            return (Criteria) this;
        }

        public Criteria andRetailSalesGrowthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retail_sales_growth not between", value1, value2, "retailSalesGrowth");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthIsNull() {
            addCriterion("sales_growth is null");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthIsNotNull() {
            addCriterion("sales_growth is not null");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthEqualTo(BigDecimal value) {
            addCriterion("sales_growth =", value, "salesGrowth");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthNotEqualTo(BigDecimal value) {
            addCriterion("sales_growth <>", value, "salesGrowth");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthGreaterThan(BigDecimal value) {
            addCriterion("sales_growth >", value, "salesGrowth");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_growth >=", value, "salesGrowth");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthLessThan(BigDecimal value) {
            addCriterion("sales_growth <", value, "salesGrowth");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_growth <=", value, "salesGrowth");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthIn(List<BigDecimal> values) {
            addCriterion("sales_growth in", values, "salesGrowth");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthNotIn(List<BigDecimal> values) {
            addCriterion("sales_growth not in", values, "salesGrowth");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_growth between", value1, value2, "salesGrowth");
            return (Criteria) this;
        }

        public Criteria andSalesGrowthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_growth not between", value1, value2, "salesGrowth");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthIsNull() {
            addCriterion("overall_growth is null");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthIsNotNull() {
            addCriterion("overall_growth is not null");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthEqualTo(BigDecimal value) {
            addCriterion("overall_growth =", value, "overallGrowth");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthNotEqualTo(BigDecimal value) {
            addCriterion("overall_growth <>", value, "overallGrowth");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthGreaterThan(BigDecimal value) {
            addCriterion("overall_growth >", value, "overallGrowth");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("overall_growth >=", value, "overallGrowth");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthLessThan(BigDecimal value) {
            addCriterion("overall_growth <", value, "overallGrowth");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("overall_growth <=", value, "overallGrowth");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthIn(List<BigDecimal> values) {
            addCriterion("overall_growth in", values, "overallGrowth");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthNotIn(List<BigDecimal> values) {
            addCriterion("overall_growth not in", values, "overallGrowth");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overall_growth between", value1, value2, "overallGrowth");
            return (Criteria) this;
        }

        public Criteria andOverallGrowthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overall_growth not between", value1, value2, "overallGrowth");
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

        public Criteria andRealAddIsNull() {
            addCriterion("real_add is null");
            return (Criteria) this;
        }

        public Criteria andRealAddIsNotNull() {
            addCriterion("real_add is not null");
            return (Criteria) this;
        }

        public Criteria andRealAddEqualTo(Integer value) {
            addCriterion("real_add =", value, "realAdd");
            return (Criteria) this;
        }

        public Criteria andRealAddNotEqualTo(Integer value) {
            addCriterion("real_add <>", value, "realAdd");
            return (Criteria) this;
        }

        public Criteria andRealAddGreaterThan(Integer value) {
            addCriterion("real_add >", value, "realAdd");
            return (Criteria) this;
        }

        public Criteria andRealAddGreaterThanOrEqualTo(Integer value) {
            addCriterion("real_add >=", value, "realAdd");
            return (Criteria) this;
        }

        public Criteria andRealAddLessThan(Integer value) {
            addCriterion("real_add <", value, "realAdd");
            return (Criteria) this;
        }

        public Criteria andRealAddLessThanOrEqualTo(Integer value) {
            addCriterion("real_add <=", value, "realAdd");
            return (Criteria) this;
        }

        public Criteria andRealAddIn(List<Integer> values) {
            addCriterion("real_add in", values, "realAdd");
            return (Criteria) this;
        }

        public Criteria andRealAddNotIn(List<Integer> values) {
            addCriterion("real_add not in", values, "realAdd");
            return (Criteria) this;
        }

        public Criteria andRealAddBetween(Integer value1, Integer value2) {
            addCriterion("real_add between", value1, value2, "realAdd");
            return (Criteria) this;
        }

        public Criteria andRealAddNotBetween(Integer value1, Integer value2) {
            addCriterion("real_add not between", value1, value2, "realAdd");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddIsNull() {
            addCriterion("overfulfilled_add is null");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddIsNotNull() {
            addCriterion("overfulfilled_add is not null");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddEqualTo(Integer value) {
            addCriterion("overfulfilled_add =", value, "overfulfilledAdd");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddNotEqualTo(Integer value) {
            addCriterion("overfulfilled_add <>", value, "overfulfilledAdd");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddGreaterThan(Integer value) {
            addCriterion("overfulfilled_add >", value, "overfulfilledAdd");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddGreaterThanOrEqualTo(Integer value) {
            addCriterion("overfulfilled_add >=", value, "overfulfilledAdd");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddLessThan(Integer value) {
            addCriterion("overfulfilled_add <", value, "overfulfilledAdd");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddLessThanOrEqualTo(Integer value) {
            addCriterion("overfulfilled_add <=", value, "overfulfilledAdd");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddIn(List<Integer> values) {
            addCriterion("overfulfilled_add in", values, "overfulfilledAdd");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddNotIn(List<Integer> values) {
            addCriterion("overfulfilled_add not in", values, "overfulfilledAdd");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddBetween(Integer value1, Integer value2) {
            addCriterion("overfulfilled_add between", value1, value2, "overfulfilledAdd");
            return (Criteria) this;
        }

        public Criteria andOverfulfilledAddNotBetween(Integer value1, Integer value2) {
            addCriterion("overfulfilled_add not between", value1, value2, "overfulfilledAdd");
            return (Criteria) this;
        }

        public Criteria andAddScoreIsNull() {
            addCriterion("add_score is null");
            return (Criteria) this;
        }

        public Criteria andAddScoreIsNotNull() {
            addCriterion("add_score is not null");
            return (Criteria) this;
        }

        public Criteria andAddScoreEqualTo(Integer value) {
            addCriterion("add_score =", value, "addScore");
            return (Criteria) this;
        }

        public Criteria andAddScoreNotEqualTo(Integer value) {
            addCriterion("add_score <>", value, "addScore");
            return (Criteria) this;
        }

        public Criteria andAddScoreGreaterThan(Integer value) {
            addCriterion("add_score >", value, "addScore");
            return (Criteria) this;
        }

        public Criteria andAddScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_score >=", value, "addScore");
            return (Criteria) this;
        }

        public Criteria andAddScoreLessThan(Integer value) {
            addCriterion("add_score <", value, "addScore");
            return (Criteria) this;
        }

        public Criteria andAddScoreLessThanOrEqualTo(Integer value) {
            addCriterion("add_score <=", value, "addScore");
            return (Criteria) this;
        }

        public Criteria andAddScoreIn(List<Integer> values) {
            addCriterion("add_score in", values, "addScore");
            return (Criteria) this;
        }

        public Criteria andAddScoreNotIn(List<Integer> values) {
            addCriterion("add_score not in", values, "addScore");
            return (Criteria) this;
        }

        public Criteria andAddScoreBetween(Integer value1, Integer value2) {
            addCriterion("add_score between", value1, value2, "addScore");
            return (Criteria) this;
        }

        public Criteria andAddScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("add_score not between", value1, value2, "addScore");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingIsNull() {
            addCriterion("gross_qualifying is null");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingIsNotNull() {
            addCriterion("gross_qualifying is not null");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingEqualTo(Integer value) {
            addCriterion("gross_qualifying =", value, "grossQualifying");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingNotEqualTo(Integer value) {
            addCriterion("gross_qualifying <>", value, "grossQualifying");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingGreaterThan(Integer value) {
            addCriterion("gross_qualifying >", value, "grossQualifying");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingGreaterThanOrEqualTo(Integer value) {
            addCriterion("gross_qualifying >=", value, "grossQualifying");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingLessThan(Integer value) {
            addCriterion("gross_qualifying <", value, "grossQualifying");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingLessThanOrEqualTo(Integer value) {
            addCriterion("gross_qualifying <=", value, "grossQualifying");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingIn(List<Integer> values) {
            addCriterion("gross_qualifying in", values, "grossQualifying");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingNotIn(List<Integer> values) {
            addCriterion("gross_qualifying not in", values, "grossQualifying");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingBetween(Integer value1, Integer value2) {
            addCriterion("gross_qualifying between", value1, value2, "grossQualifying");
            return (Criteria) this;
        }

        public Criteria andGrossQualifyingNotBetween(Integer value1, Integer value2) {
            addCriterion("gross_qualifying not between", value1, value2, "grossQualifying");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingIsNull() {
            addCriterion("progress_qualifying is null");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingIsNotNull() {
            addCriterion("progress_qualifying is not null");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingEqualTo(Integer value) {
            addCriterion("progress_qualifying =", value, "progressQualifying");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingNotEqualTo(Integer value) {
            addCriterion("progress_qualifying <>", value, "progressQualifying");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingGreaterThan(Integer value) {
            addCriterion("progress_qualifying >", value, "progressQualifying");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingGreaterThanOrEqualTo(Integer value) {
            addCriterion("progress_qualifying >=", value, "progressQualifying");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingLessThan(Integer value) {
            addCriterion("progress_qualifying <", value, "progressQualifying");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingLessThanOrEqualTo(Integer value) {
            addCriterion("progress_qualifying <=", value, "progressQualifying");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingIn(List<Integer> values) {
            addCriterion("progress_qualifying in", values, "progressQualifying");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingNotIn(List<Integer> values) {
            addCriterion("progress_qualifying not in", values, "progressQualifying");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingBetween(Integer value1, Integer value2) {
            addCriterion("progress_qualifying between", value1, value2, "progressQualifying");
            return (Criteria) this;
        }

        public Criteria andProgressQualifyingNotBetween(Integer value1, Integer value2) {
            addCriterion("progress_qualifying not between", value1, value2, "progressQualifying");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingIsNull() {
            addCriterion("growth_qualifying is null");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingIsNotNull() {
            addCriterion("growth_qualifying is not null");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingEqualTo(Integer value) {
            addCriterion("growth_qualifying =", value, "growthQualifying");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingNotEqualTo(Integer value) {
            addCriterion("growth_qualifying <>", value, "growthQualifying");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingGreaterThan(Integer value) {
            addCriterion("growth_qualifying >", value, "growthQualifying");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingGreaterThanOrEqualTo(Integer value) {
            addCriterion("growth_qualifying >=", value, "growthQualifying");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingLessThan(Integer value) {
            addCriterion("growth_qualifying <", value, "growthQualifying");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingLessThanOrEqualTo(Integer value) {
            addCriterion("growth_qualifying <=", value, "growthQualifying");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingIn(List<Integer> values) {
            addCriterion("growth_qualifying in", values, "growthQualifying");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingNotIn(List<Integer> values) {
            addCriterion("growth_qualifying not in", values, "growthQualifying");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingBetween(Integer value1, Integer value2) {
            addCriterion("growth_qualifying between", value1, value2, "growthQualifying");
            return (Criteria) this;
        }

        public Criteria andGrowthQualifyingNotBetween(Integer value1, Integer value2) {
            addCriterion("growth_qualifying not between", value1, value2, "growthQualifying");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingIsNull() {
            addCriterion("add_qualifying is null");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingIsNotNull() {
            addCriterion("add_qualifying is not null");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingEqualTo(Integer value) {
            addCriterion("add_qualifying =", value, "addQualifying");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingNotEqualTo(Integer value) {
            addCriterion("add_qualifying <>", value, "addQualifying");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingGreaterThan(Integer value) {
            addCriterion("add_qualifying >", value, "addQualifying");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_qualifying >=", value, "addQualifying");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingLessThan(Integer value) {
            addCriterion("add_qualifying <", value, "addQualifying");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingLessThanOrEqualTo(Integer value) {
            addCriterion("add_qualifying <=", value, "addQualifying");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingIn(List<Integer> values) {
            addCriterion("add_qualifying in", values, "addQualifying");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingNotIn(List<Integer> values) {
            addCriterion("add_qualifying not in", values, "addQualifying");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingBetween(Integer value1, Integer value2) {
            addCriterion("add_qualifying between", value1, value2, "addQualifying");
            return (Criteria) this;
        }

        public Criteria andAddQualifyingNotBetween(Integer value1, Integer value2) {
            addCriterion("add_qualifying not between", value1, value2, "addQualifying");
            return (Criteria) this;
        }

        public Criteria andGrossPointIsNull() {
            addCriterion("gross_point is null");
            return (Criteria) this;
        }

        public Criteria andGrossPointIsNotNull() {
            addCriterion("gross_point is not null");
            return (Criteria) this;
        }

        public Criteria andGrossPointEqualTo(Integer value) {
            addCriterion("gross_point =", value, "grossPoint");
            return (Criteria) this;
        }

        public Criteria andGrossPointNotEqualTo(Integer value) {
            addCriterion("gross_point <>", value, "grossPoint");
            return (Criteria) this;
        }

        public Criteria andGrossPointGreaterThan(Integer value) {
            addCriterion("gross_point >", value, "grossPoint");
            return (Criteria) this;
        }

        public Criteria andGrossPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("gross_point >=", value, "grossPoint");
            return (Criteria) this;
        }

        public Criteria andGrossPointLessThan(Integer value) {
            addCriterion("gross_point <", value, "grossPoint");
            return (Criteria) this;
        }

        public Criteria andGrossPointLessThanOrEqualTo(Integer value) {
            addCriterion("gross_point <=", value, "grossPoint");
            return (Criteria) this;
        }

        public Criteria andGrossPointIn(List<Integer> values) {
            addCriterion("gross_point in", values, "grossPoint");
            return (Criteria) this;
        }

        public Criteria andGrossPointNotIn(List<Integer> values) {
            addCriterion("gross_point not in", values, "grossPoint");
            return (Criteria) this;
        }

        public Criteria andGrossPointBetween(Integer value1, Integer value2) {
            addCriterion("gross_point between", value1, value2, "grossPoint");
            return (Criteria) this;
        }

        public Criteria andGrossPointNotBetween(Integer value1, Integer value2) {
            addCriterion("gross_point not between", value1, value2, "grossPoint");
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

        public Criteria andTaskPointIsNull() {
            addCriterion("task_point is null");
            return (Criteria) this;
        }

        public Criteria andTaskPointIsNotNull() {
            addCriterion("task_point is not null");
            return (Criteria) this;
        }

        public Criteria andTaskPointEqualTo(Integer value) {
            addCriterion("task_point =", value, "taskPoint");
            return (Criteria) this;
        }

        public Criteria andTaskPointNotEqualTo(Integer value) {
            addCriterion("task_point <>", value, "taskPoint");
            return (Criteria) this;
        }

        public Criteria andTaskPointGreaterThan(Integer value) {
            addCriterion("task_point >", value, "taskPoint");
            return (Criteria) this;
        }

        public Criteria andTaskPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_point >=", value, "taskPoint");
            return (Criteria) this;
        }

        public Criteria andTaskPointLessThan(Integer value) {
            addCriterion("task_point <", value, "taskPoint");
            return (Criteria) this;
        }

        public Criteria andTaskPointLessThanOrEqualTo(Integer value) {
            addCriterion("task_point <=", value, "taskPoint");
            return (Criteria) this;
        }

        public Criteria andTaskPointIn(List<Integer> values) {
            addCriterion("task_point in", values, "taskPoint");
            return (Criteria) this;
        }

        public Criteria andTaskPointNotIn(List<Integer> values) {
            addCriterion("task_point not in", values, "taskPoint");
            return (Criteria) this;
        }

        public Criteria andTaskPointBetween(Integer value1, Integer value2) {
            addCriterion("task_point between", value1, value2, "taskPoint");
            return (Criteria) this;
        }

        public Criteria andTaskPointNotBetween(Integer value1, Integer value2) {
            addCriterion("task_point not between", value1, value2, "taskPoint");
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

        public Criteria andAddPointIsNull() {
            addCriterion("add_point is null");
            return (Criteria) this;
        }

        public Criteria andAddPointIsNotNull() {
            addCriterion("add_point is not null");
            return (Criteria) this;
        }

        public Criteria andAddPointEqualTo(Integer value) {
            addCriterion("add_point =", value, "addPoint");
            return (Criteria) this;
        }

        public Criteria andAddPointNotEqualTo(Integer value) {
            addCriterion("add_point <>", value, "addPoint");
            return (Criteria) this;
        }

        public Criteria andAddPointGreaterThan(Integer value) {
            addCriterion("add_point >", value, "addPoint");
            return (Criteria) this;
        }

        public Criteria andAddPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_point >=", value, "addPoint");
            return (Criteria) this;
        }

        public Criteria andAddPointLessThan(Integer value) {
            addCriterion("add_point <", value, "addPoint");
            return (Criteria) this;
        }

        public Criteria andAddPointLessThanOrEqualTo(Integer value) {
            addCriterion("add_point <=", value, "addPoint");
            return (Criteria) this;
        }

        public Criteria andAddPointIn(List<Integer> values) {
            addCriterion("add_point in", values, "addPoint");
            return (Criteria) this;
        }

        public Criteria andAddPointNotIn(List<Integer> values) {
            addCriterion("add_point not in", values, "addPoint");
            return (Criteria) this;
        }

        public Criteria andAddPointBetween(Integer value1, Integer value2) {
            addCriterion("add_point between", value1, value2, "addPoint");
            return (Criteria) this;
        }

        public Criteria andAddPointNotBetween(Integer value1, Integer value2) {
            addCriterion("add_point not between", value1, value2, "addPoint");
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