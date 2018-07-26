package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ServiceForecastExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceForecastExample() {
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

        public Criteria andDefineIdIsNull() {
            addCriterion("define_id is null");
            return (Criteria) this;
        }

        public Criteria andDefineIdIsNotNull() {
            addCriterion("define_id is not null");
            return (Criteria) this;
        }

        public Criteria andDefineIdEqualTo(Integer value) {
            addCriterion("define_id =", value, "defineId");
            return (Criteria) this;
        }

        public Criteria andDefineIdNotEqualTo(Integer value) {
            addCriterion("define_id <>", value, "defineId");
            return (Criteria) this;
        }

        public Criteria andDefineIdGreaterThan(Integer value) {
            addCriterion("define_id >", value, "defineId");
            return (Criteria) this;
        }

        public Criteria andDefineIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("define_id >=", value, "defineId");
            return (Criteria) this;
        }

        public Criteria andDefineIdLessThan(Integer value) {
            addCriterion("define_id <", value, "defineId");
            return (Criteria) this;
        }

        public Criteria andDefineIdLessThanOrEqualTo(Integer value) {
            addCriterion("define_id <=", value, "defineId");
            return (Criteria) this;
        }

        public Criteria andDefineIdIn(List<Integer> values) {
            addCriterion("define_id in", values, "defineId");
            return (Criteria) this;
        }

        public Criteria andDefineIdNotIn(List<Integer> values) {
            addCriterion("define_id not in", values, "defineId");
            return (Criteria) this;
        }

        public Criteria andDefineIdBetween(Integer value1, Integer value2) {
            addCriterion("define_id between", value1, value2, "defineId");
            return (Criteria) this;
        }

        public Criteria andDefineIdNotBetween(Integer value1, Integer value2) {
            addCriterion("define_id not between", value1, value2, "defineId");
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

        public Criteria andLastAmountRiseIsNull() {
            addCriterion("last_amount_rise is null");
            return (Criteria) this;
        }

        public Criteria andLastAmountRiseIsNotNull() {
            addCriterion("last_amount_rise is not null");
            return (Criteria) this;
        }

        public Criteria andLastAmountRiseEqualTo(BigDecimal value) {
            addCriterion("last_amount_rise =", value, "lastAmountRise");
            return (Criteria) this;
        }

        public Criteria andLastAmountRiseNotEqualTo(BigDecimal value) {
            addCriterion("last_amount_rise <>", value, "lastAmountRise");
            return (Criteria) this;
        }

        public Criteria andLastAmountRiseGreaterThan(BigDecimal value) {
            addCriterion("last_amount_rise >", value, "lastAmountRise");
            return (Criteria) this;
        }

        public Criteria andLastAmountRiseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last_amount_rise >=", value, "lastAmountRise");
            return (Criteria) this;
        }

        public Criteria andLastAmountRiseLessThan(BigDecimal value) {
            addCriterion("last_amount_rise <", value, "lastAmountRise");
            return (Criteria) this;
        }

        public Criteria andLastAmountRiseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last_amount_rise <=", value, "lastAmountRise");
            return (Criteria) this;
        }

        public Criteria andLastAmountRiseIn(List<BigDecimal> values) {
            addCriterion("last_amount_rise in", values, "lastAmountRise");
            return (Criteria) this;
        }

        public Criteria andLastAmountRiseNotIn(List<BigDecimal> values) {
            addCriterion("last_amount_rise not in", values, "lastAmountRise");
            return (Criteria) this;
        }

        public Criteria andLastAmountRiseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_amount_rise between", value1, value2, "lastAmountRise");
            return (Criteria) this;
        }

        public Criteria andLastAmountRiseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_amount_rise not between", value1, value2, "lastAmountRise");
            return (Criteria) this;
        }

        public Criteria andProblemIsNull() {
            addCriterion("problem is null");
            return (Criteria) this;
        }

        public Criteria andProblemIsNotNull() {
            addCriterion("problem is not null");
            return (Criteria) this;
        }

        public Criteria andProblemEqualTo(String value) {
            addCriterion("problem =", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotEqualTo(String value) {
            addCriterion("problem <>", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemGreaterThan(String value) {
            addCriterion("problem >", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemGreaterThanOrEqualTo(String value) {
            addCriterion("problem >=", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemLessThan(String value) {
            addCriterion("problem <", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemLessThanOrEqualTo(String value) {
            addCriterion("problem <=", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemLike(String value) {
            addCriterion("problem like", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotLike(String value) {
            addCriterion("problem not like", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemIn(List<String> values) {
            addCriterion("problem in", values, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotIn(List<String> values) {
            addCriterion("problem not in", values, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemBetween(String value1, String value2) {
            addCriterion("problem between", value1, value2, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotBetween(String value1, String value2) {
            addCriterion("problem not between", value1, value2, "problem");
            return (Criteria) this;
        }

        public Criteria andSolutionIsNull() {
            addCriterion("solution is null");
            return (Criteria) this;
        }

        public Criteria andSolutionIsNotNull() {
            addCriterion("solution is not null");
            return (Criteria) this;
        }

        public Criteria andSolutionEqualTo(String value) {
            addCriterion("solution =", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionNotEqualTo(String value) {
            addCriterion("solution <>", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionGreaterThan(String value) {
            addCriterion("solution >", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionGreaterThanOrEqualTo(String value) {
            addCriterion("solution >=", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionLessThan(String value) {
            addCriterion("solution <", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionLessThanOrEqualTo(String value) {
            addCriterion("solution <=", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionLike(String value) {
            addCriterion("solution like", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionNotLike(String value) {
            addCriterion("solution not like", value, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionIn(List<String> values) {
            addCriterion("solution in", values, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionNotIn(List<String> values) {
            addCriterion("solution not in", values, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionBetween(String value1, String value2) {
            addCriterion("solution between", value1, value2, "solution");
            return (Criteria) this;
        }

        public Criteria andSolutionNotBetween(String value1, String value2) {
            addCriterion("solution not between", value1, value2, "solution");
            return (Criteria) this;
        }

        public Criteria andProblemLikeInsensitive(String value) {
            addCriterion("upper(problem) like", value.toUpperCase(), "problem");
            return (Criteria) this;
        }

        public Criteria andSolutionLikeInsensitive(String value) {
            addCriterion("upper(solution) like", value.toUpperCase(), "solution");
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