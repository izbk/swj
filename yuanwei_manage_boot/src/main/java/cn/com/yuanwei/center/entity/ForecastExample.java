package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ForecastExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForecastExample() {
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

        public Criteria andLastAddIsNull() {
            addCriterion("last_add is null");
            return (Criteria) this;
        }

        public Criteria andLastAddIsNotNull() {
            addCriterion("last_add is not null");
            return (Criteria) this;
        }

        public Criteria andLastAddEqualTo(BigDecimal value) {
            addCriterion("last_add =", value, "lastAdd");
            return (Criteria) this;
        }

        public Criteria andLastAddNotEqualTo(BigDecimal value) {
            addCriterion("last_add <>", value, "lastAdd");
            return (Criteria) this;
        }

        public Criteria andLastAddGreaterThan(BigDecimal value) {
            addCriterion("last_add >", value, "lastAdd");
            return (Criteria) this;
        }

        public Criteria andLastAddGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last_add >=", value, "lastAdd");
            return (Criteria) this;
        }

        public Criteria andLastAddLessThan(BigDecimal value) {
            addCriterion("last_add <", value, "lastAdd");
            return (Criteria) this;
        }

        public Criteria andLastAddLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last_add <=", value, "lastAdd");
            return (Criteria) this;
        }

        public Criteria andLastAddIn(List<BigDecimal> values) {
            addCriterion("last_add in", values, "lastAdd");
            return (Criteria) this;
        }

        public Criteria andLastAddNotIn(List<BigDecimal> values) {
            addCriterion("last_add not in", values, "lastAdd");
            return (Criteria) this;
        }

        public Criteria andLastAddBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_add between", value1, value2, "lastAdd");
            return (Criteria) this;
        }

        public Criteria andLastAddNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_add not between", value1, value2, "lastAdd");
            return (Criteria) this;
        }

        public Criteria andLastAmountIsNull() {
            addCriterion("last_amount is null");
            return (Criteria) this;
        }

        public Criteria andLastAmountIsNotNull() {
            addCriterion("last_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLastAmountEqualTo(BigDecimal value) {
            addCriterion("last_amount =", value, "lastAmount");
            return (Criteria) this;
        }

        public Criteria andLastAmountNotEqualTo(BigDecimal value) {
            addCriterion("last_amount <>", value, "lastAmount");
            return (Criteria) this;
        }

        public Criteria andLastAmountGreaterThan(BigDecimal value) {
            addCriterion("last_amount >", value, "lastAmount");
            return (Criteria) this;
        }

        public Criteria andLastAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last_amount >=", value, "lastAmount");
            return (Criteria) this;
        }

        public Criteria andLastAmountLessThan(BigDecimal value) {
            addCriterion("last_amount <", value, "lastAmount");
            return (Criteria) this;
        }

        public Criteria andLastAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last_amount <=", value, "lastAmount");
            return (Criteria) this;
        }

        public Criteria andLastAmountIn(List<BigDecimal> values) {
            addCriterion("last_amount in", values, "lastAmount");
            return (Criteria) this;
        }

        public Criteria andLastAmountNotIn(List<BigDecimal> values) {
            addCriterion("last_amount not in", values, "lastAmount");
            return (Criteria) this;
        }

        public Criteria andLastAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_amount between", value1, value2, "lastAmount");
            return (Criteria) this;
        }

        public Criteria andLastAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_amount not between", value1, value2, "lastAmount");
            return (Criteria) this;
        }

        public Criteria andCurrRiseIsNull() {
            addCriterion("curr_rise is null");
            return (Criteria) this;
        }

        public Criteria andCurrRiseIsNotNull() {
            addCriterion("curr_rise is not null");
            return (Criteria) this;
        }

        public Criteria andCurrRiseEqualTo(BigDecimal value) {
            addCriterion("curr_rise =", value, "currRise");
            return (Criteria) this;
        }

        public Criteria andCurrRiseNotEqualTo(BigDecimal value) {
            addCriterion("curr_rise <>", value, "currRise");
            return (Criteria) this;
        }

        public Criteria andCurrRiseGreaterThan(BigDecimal value) {
            addCriterion("curr_rise >", value, "currRise");
            return (Criteria) this;
        }

        public Criteria andCurrRiseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_rise >=", value, "currRise");
            return (Criteria) this;
        }

        public Criteria andCurrRiseLessThan(BigDecimal value) {
            addCriterion("curr_rise <", value, "currRise");
            return (Criteria) this;
        }

        public Criteria andCurrRiseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_rise <=", value, "currRise");
            return (Criteria) this;
        }

        public Criteria andCurrRiseIn(List<BigDecimal> values) {
            addCriterion("curr_rise in", values, "currRise");
            return (Criteria) this;
        }

        public Criteria andCurrRiseNotIn(List<BigDecimal> values) {
            addCriterion("curr_rise not in", values, "currRise");
            return (Criteria) this;
        }

        public Criteria andCurrRiseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_rise between", value1, value2, "currRise");
            return (Criteria) this;
        }

        public Criteria andCurrRiseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_rise not between", value1, value2, "currRise");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseIsNull() {
            addCriterion("curr_under_rise is null");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseIsNotNull() {
            addCriterion("curr_under_rise is not null");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseEqualTo(BigDecimal value) {
            addCriterion("curr_under_rise =", value, "currUnderRise");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseNotEqualTo(BigDecimal value) {
            addCriterion("curr_under_rise <>", value, "currUnderRise");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseGreaterThan(BigDecimal value) {
            addCriterion("curr_under_rise >", value, "currUnderRise");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_under_rise >=", value, "currUnderRise");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseLessThan(BigDecimal value) {
            addCriterion("curr_under_rise <", value, "currUnderRise");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_under_rise <=", value, "currUnderRise");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseIn(List<BigDecimal> values) {
            addCriterion("curr_under_rise in", values, "currUnderRise");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseNotIn(List<BigDecimal> values) {
            addCriterion("curr_under_rise not in", values, "currUnderRise");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_under_rise between", value1, value2, "currUnderRise");
            return (Criteria) this;
        }

        public Criteria andCurrUnderRiseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_under_rise not between", value1, value2, "currUnderRise");
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

        public Criteria andCurrAmountRiseIsNull() {
            addCriterion("curr_amount_rise is null");
            return (Criteria) this;
        }

        public Criteria andCurrAmountRiseIsNotNull() {
            addCriterion("curr_amount_rise is not null");
            return (Criteria) this;
        }

        public Criteria andCurrAmountRiseEqualTo(BigDecimal value) {
            addCriterion("curr_amount_rise =", value, "currAmountRise");
            return (Criteria) this;
        }

        public Criteria andCurrAmountRiseNotEqualTo(BigDecimal value) {
            addCriterion("curr_amount_rise <>", value, "currAmountRise");
            return (Criteria) this;
        }

        public Criteria andCurrAmountRiseGreaterThan(BigDecimal value) {
            addCriterion("curr_amount_rise >", value, "currAmountRise");
            return (Criteria) this;
        }

        public Criteria andCurrAmountRiseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_amount_rise >=", value, "currAmountRise");
            return (Criteria) this;
        }

        public Criteria andCurrAmountRiseLessThan(BigDecimal value) {
            addCriterion("curr_amount_rise <", value, "currAmountRise");
            return (Criteria) this;
        }

        public Criteria andCurrAmountRiseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_amount_rise <=", value, "currAmountRise");
            return (Criteria) this;
        }

        public Criteria andCurrAmountRiseIn(List<BigDecimal> values) {
            addCriterion("curr_amount_rise in", values, "currAmountRise");
            return (Criteria) this;
        }

        public Criteria andCurrAmountRiseNotIn(List<BigDecimal> values) {
            addCriterion("curr_amount_rise not in", values, "currAmountRise");
            return (Criteria) this;
        }

        public Criteria andCurrAmountRiseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_amount_rise between", value1, value2, "currAmountRise");
            return (Criteria) this;
        }

        public Criteria andCurrAmountRiseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_amount_rise not between", value1, value2, "currAmountRise");
            return (Criteria) this;
        }

        public Criteria andCurrAmountIsNull() {
            addCriterion("curr_amount is null");
            return (Criteria) this;
        }

        public Criteria andCurrAmountIsNotNull() {
            addCriterion("curr_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCurrAmountEqualTo(BigDecimal value) {
            addCriterion("curr_amount =", value, "currAmount");
            return (Criteria) this;
        }

        public Criteria andCurrAmountNotEqualTo(BigDecimal value) {
            addCriterion("curr_amount <>", value, "currAmount");
            return (Criteria) this;
        }

        public Criteria andCurrAmountGreaterThan(BigDecimal value) {
            addCriterion("curr_amount >", value, "currAmount");
            return (Criteria) this;
        }

        public Criteria andCurrAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_amount >=", value, "currAmount");
            return (Criteria) this;
        }

        public Criteria andCurrAmountLessThan(BigDecimal value) {
            addCriterion("curr_amount <", value, "currAmount");
            return (Criteria) this;
        }

        public Criteria andCurrAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("curr_amount <=", value, "currAmount");
            return (Criteria) this;
        }

        public Criteria andCurrAmountIn(List<BigDecimal> values) {
            addCriterion("curr_amount in", values, "currAmount");
            return (Criteria) this;
        }

        public Criteria andCurrAmountNotIn(List<BigDecimal> values) {
            addCriterion("curr_amount not in", values, "currAmount");
            return (Criteria) this;
        }

        public Criteria andCurrAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_amount between", value1, value2, "currAmount");
            return (Criteria) this;
        }

        public Criteria andCurrAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("curr_amount not between", value1, value2, "currAmount");
            return (Criteria) this;
        }

        public Criteria andLastRatioIsNull() {
            addCriterion("last_ratio is null");
            return (Criteria) this;
        }

        public Criteria andLastRatioIsNotNull() {
            addCriterion("last_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andLastRatioEqualTo(BigDecimal value) {
            addCriterion("last_ratio =", value, "lastRatio");
            return (Criteria) this;
        }

        public Criteria andLastRatioNotEqualTo(BigDecimal value) {
            addCriterion("last_ratio <>", value, "lastRatio");
            return (Criteria) this;
        }

        public Criteria andLastRatioGreaterThan(BigDecimal value) {
            addCriterion("last_ratio >", value, "lastRatio");
            return (Criteria) this;
        }

        public Criteria andLastRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last_ratio >=", value, "lastRatio");
            return (Criteria) this;
        }

        public Criteria andLastRatioLessThan(BigDecimal value) {
            addCriterion("last_ratio <", value, "lastRatio");
            return (Criteria) this;
        }

        public Criteria andLastRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last_ratio <=", value, "lastRatio");
            return (Criteria) this;
        }

        public Criteria andLastRatioIn(List<BigDecimal> values) {
            addCriterion("last_ratio in", values, "lastRatio");
            return (Criteria) this;
        }

        public Criteria andLastRatioNotIn(List<BigDecimal> values) {
            addCriterion("last_ratio not in", values, "lastRatio");
            return (Criteria) this;
        }

        public Criteria andLastRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_ratio between", value1, value2, "lastRatio");
            return (Criteria) this;
        }

        public Criteria andLastRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_ratio not between", value1, value2, "lastRatio");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioIsNull() {
            addCriterion("last_under_ratio is null");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioIsNotNull() {
            addCriterion("last_under_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioEqualTo(BigDecimal value) {
            addCriterion("last_under_ratio =", value, "lastUnderRatio");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioNotEqualTo(BigDecimal value) {
            addCriterion("last_under_ratio <>", value, "lastUnderRatio");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioGreaterThan(BigDecimal value) {
            addCriterion("last_under_ratio >", value, "lastUnderRatio");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last_under_ratio >=", value, "lastUnderRatio");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioLessThan(BigDecimal value) {
            addCriterion("last_under_ratio <", value, "lastUnderRatio");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last_under_ratio <=", value, "lastUnderRatio");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioIn(List<BigDecimal> values) {
            addCriterion("last_under_ratio in", values, "lastUnderRatio");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioNotIn(List<BigDecimal> values) {
            addCriterion("last_under_ratio not in", values, "lastUnderRatio");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_under_ratio between", value1, value2, "lastUnderRatio");
            return (Criteria) this;
        }

        public Criteria andLastUnderRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_under_ratio not between", value1, value2, "lastUnderRatio");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustIsNull() {
            addCriterion("last_no_adjust is null");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustIsNotNull() {
            addCriterion("last_no_adjust is not null");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustEqualTo(BigDecimal value) {
            addCriterion("last_no_adjust =", value, "lastNoAdjust");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustNotEqualTo(BigDecimal value) {
            addCriterion("last_no_adjust <>", value, "lastNoAdjust");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustGreaterThan(BigDecimal value) {
            addCriterion("last_no_adjust >", value, "lastNoAdjust");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last_no_adjust >=", value, "lastNoAdjust");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustLessThan(BigDecimal value) {
            addCriterion("last_no_adjust <", value, "lastNoAdjust");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last_no_adjust <=", value, "lastNoAdjust");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustIn(List<BigDecimal> values) {
            addCriterion("last_no_adjust in", values, "lastNoAdjust");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustNotIn(List<BigDecimal> values) {
            addCriterion("last_no_adjust not in", values, "lastNoAdjust");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_no_adjust between", value1, value2, "lastNoAdjust");
            return (Criteria) this;
        }

        public Criteria andLastNoAdjustNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_no_adjust not between", value1, value2, "lastNoAdjust");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedIsNull() {
            addCriterion("last_adjusted is null");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedIsNotNull() {
            addCriterion("last_adjusted is not null");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedEqualTo(BigDecimal value) {
            addCriterion("last_adjusted =", value, "lastAdjusted");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedNotEqualTo(BigDecimal value) {
            addCriterion("last_adjusted <>", value, "lastAdjusted");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedGreaterThan(BigDecimal value) {
            addCriterion("last_adjusted >", value, "lastAdjusted");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last_adjusted >=", value, "lastAdjusted");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedLessThan(BigDecimal value) {
            addCriterion("last_adjusted <", value, "lastAdjusted");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last_adjusted <=", value, "lastAdjusted");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedIn(List<BigDecimal> values) {
            addCriterion("last_adjusted in", values, "lastAdjusted");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedNotIn(List<BigDecimal> values) {
            addCriterion("last_adjusted not in", values, "lastAdjusted");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_adjusted between", value1, value2, "lastAdjusted");
            return (Criteria) this;
        }

        public Criteria andLastAdjustedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_adjusted not between", value1, value2, "lastAdjusted");
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