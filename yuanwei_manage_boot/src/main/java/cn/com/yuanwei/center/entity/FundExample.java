package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundExample() {
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

        public Criteria andDepartIdIsNull() {
            addCriterion("depart_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartIdIsNotNull() {
            addCriterion("depart_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartIdEqualTo(Integer value) {
            addCriterion("depart_id =", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotEqualTo(Integer value) {
            addCriterion("depart_id <>", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdGreaterThan(Integer value) {
            addCriterion("depart_id >", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("depart_id >=", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLessThan(Integer value) {
            addCriterion("depart_id <", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLessThanOrEqualTo(Integer value) {
            addCriterion("depart_id <=", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdIn(List<Integer> values) {
            addCriterion("depart_id in", values, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotIn(List<Integer> values) {
            addCriterion("depart_id not in", values, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdBetween(Integer value1, Integer value2) {
            addCriterion("depart_id between", value1, value2, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("depart_id not between", value1, value2, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNull() {
            addCriterion("depart_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNotNull() {
            addCriterion("depart_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartNameEqualTo(String value) {
            addCriterion("depart_name =", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotEqualTo(String value) {
            addCriterion("depart_name <>", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThan(String value) {
            addCriterion("depart_name >", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThanOrEqualTo(String value) {
            addCriterion("depart_name >=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThan(String value) {
            addCriterion("depart_name <", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThanOrEqualTo(String value) {
            addCriterion("depart_name <=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLike(String value) {
            addCriterion("depart_name like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotLike(String value) {
            addCriterion("depart_name not like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameIn(List<String> values) {
            addCriterion("depart_name in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotIn(List<String> values) {
            addCriterion("depart_name not in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameBetween(String value1, String value2) {
            addCriterion("depart_name between", value1, value2, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotBetween(String value1, String value2) {
            addCriterion("depart_name not between", value1, value2, "departName");
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andRealAmountIsNull() {
            addCriterion("real_amount is null");
            return (Criteria) this;
        }

        public Criteria andRealAmountIsNotNull() {
            addCriterion("real_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRealAmountEqualTo(BigDecimal value) {
            addCriterion("real_amount =", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotEqualTo(BigDecimal value) {
            addCriterion("real_amount <>", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountGreaterThan(BigDecimal value) {
            addCriterion("real_amount >", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_amount >=", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountLessThan(BigDecimal value) {
            addCriterion("real_amount <", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_amount <=", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountIn(List<BigDecimal> values) {
            addCriterion("real_amount in", values, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotIn(List<BigDecimal> values) {
            addCriterion("real_amount not in", values, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_amount between", value1, value2, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_amount not between", value1, value2, "realAmount");
            return (Criteria) this;
        }

        public Criteria andNoAmountIsNull() {
            addCriterion("no_amount is null");
            return (Criteria) this;
        }

        public Criteria andNoAmountIsNotNull() {
            addCriterion("no_amount is not null");
            return (Criteria) this;
        }

        public Criteria andNoAmountEqualTo(BigDecimal value) {
            addCriterion("no_amount =", value, "noAmount");
            return (Criteria) this;
        }

        public Criteria andNoAmountNotEqualTo(BigDecimal value) {
            addCriterion("no_amount <>", value, "noAmount");
            return (Criteria) this;
        }

        public Criteria andNoAmountGreaterThan(BigDecimal value) {
            addCriterion("no_amount >", value, "noAmount");
            return (Criteria) this;
        }

        public Criteria andNoAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("no_amount >=", value, "noAmount");
            return (Criteria) this;
        }

        public Criteria andNoAmountLessThan(BigDecimal value) {
            addCriterion("no_amount <", value, "noAmount");
            return (Criteria) this;
        }

        public Criteria andNoAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("no_amount <=", value, "noAmount");
            return (Criteria) this;
        }

        public Criteria andNoAmountIn(List<BigDecimal> values) {
            addCriterion("no_amount in", values, "noAmount");
            return (Criteria) this;
        }

        public Criteria andNoAmountNotIn(List<BigDecimal> values) {
            addCriterion("no_amount not in", values, "noAmount");
            return (Criteria) this;
        }

        public Criteria andNoAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("no_amount between", value1, value2, "noAmount");
            return (Criteria) this;
        }

        public Criteria andNoAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("no_amount not between", value1, value2, "noAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountIsNull() {
            addCriterion("surplus_amount is null");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountIsNotNull() {
            addCriterion("surplus_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountEqualTo(BigDecimal value) {
            addCriterion("surplus_amount =", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountNotEqualTo(BigDecimal value) {
            addCriterion("surplus_amount <>", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountGreaterThan(BigDecimal value) {
            addCriterion("surplus_amount >", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("surplus_amount >=", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountLessThan(BigDecimal value) {
            addCriterion("surplus_amount <", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("surplus_amount <=", value, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountIn(List<BigDecimal> values) {
            addCriterion("surplus_amount in", values, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountNotIn(List<BigDecimal> values) {
            addCriterion("surplus_amount not in", values, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("surplus_amount between", value1, value2, "surplusAmount");
            return (Criteria) this;
        }

        public Criteria andSurplusAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("surplus_amount not between", value1, value2, "surplusAmount");
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andIndexIdIsNull() {
            addCriterion("index_id is null");
            return (Criteria) this;
        }

        public Criteria andIndexIdIsNotNull() {
            addCriterion("index_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndexIdEqualTo(String value) {
            addCriterion("index_id =", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdNotEqualTo(String value) {
            addCriterion("index_id <>", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdGreaterThan(String value) {
            addCriterion("index_id >", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdGreaterThanOrEqualTo(String value) {
            addCriterion("index_id >=", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdLessThan(String value) {
            addCriterion("index_id <", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdLessThanOrEqualTo(String value) {
            addCriterion("index_id <=", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdLike(String value) {
            addCriterion("index_id like", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdNotLike(String value) {
            addCriterion("index_id not like", value, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdIn(List<String> values) {
            addCriterion("index_id in", values, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdNotIn(List<String> values) {
            addCriterion("index_id not in", values, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdBetween(String value1, String value2) {
            addCriterion("index_id between", value1, value2, "indexId");
            return (Criteria) this;
        }

        public Criteria andIndexIdNotBetween(String value1, String value2) {
            addCriterion("index_id not between", value1, value2, "indexId");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileIsNull() {
            addCriterion("superior_file is null");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileIsNotNull() {
            addCriterion("superior_file is not null");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileEqualTo(String value) {
            addCriterion("superior_file =", value, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileNotEqualTo(String value) {
            addCriterion("superior_file <>", value, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileGreaterThan(String value) {
            addCriterion("superior_file >", value, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileGreaterThanOrEqualTo(String value) {
            addCriterion("superior_file >=", value, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileLessThan(String value) {
            addCriterion("superior_file <", value, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileLessThanOrEqualTo(String value) {
            addCriterion("superior_file <=", value, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileLike(String value) {
            addCriterion("superior_file like", value, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileNotLike(String value) {
            addCriterion("superior_file not like", value, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileIn(List<String> values) {
            addCriterion("superior_file in", values, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileNotIn(List<String> values) {
            addCriterion("superior_file not in", values, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileBetween(String value1, String value2) {
            addCriterion("superior_file between", value1, value2, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileNotBetween(String value1, String value2) {
            addCriterion("superior_file not between", value1, value2, "superiorFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileIsNull() {
            addCriterion("local_file is null");
            return (Criteria) this;
        }

        public Criteria andLocalFileIsNotNull() {
            addCriterion("local_file is not null");
            return (Criteria) this;
        }

        public Criteria andLocalFileEqualTo(String value) {
            addCriterion("local_file =", value, "localFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileNotEqualTo(String value) {
            addCriterion("local_file <>", value, "localFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileGreaterThan(String value) {
            addCriterion("local_file >", value, "localFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileGreaterThanOrEqualTo(String value) {
            addCriterion("local_file >=", value, "localFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileLessThan(String value) {
            addCriterion("local_file <", value, "localFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileLessThanOrEqualTo(String value) {
            addCriterion("local_file <=", value, "localFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileLike(String value) {
            addCriterion("local_file like", value, "localFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileNotLike(String value) {
            addCriterion("local_file not like", value, "localFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileIn(List<String> values) {
            addCriterion("local_file in", values, "localFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileNotIn(List<String> values) {
            addCriterion("local_file not in", values, "localFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileBetween(String value1, String value2) {
            addCriterion("local_file between", value1, value2, "localFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileNotBetween(String value1, String value2) {
            addCriterion("local_file not between", value1, value2, "localFile");
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

        public Criteria andIsValidIsNull() {
            addCriterion("is_valid is null");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNotNull() {
            addCriterion("is_valid is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidEqualTo(Integer value) {
            addCriterion("is_valid =", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotEqualTo(Integer value) {
            addCriterion("is_valid <>", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThan(Integer value) {
            addCriterion("is_valid >", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_valid >=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThan(Integer value) {
            addCriterion("is_valid <", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThanOrEqualTo(Integer value) {
            addCriterion("is_valid <=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidIn(List<Integer> values) {
            addCriterion("is_valid in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotIn(List<Integer> values) {
            addCriterion("is_valid not in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidBetween(Integer value1, Integer value2) {
            addCriterion("is_valid between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotBetween(Integer value1, Integer value2) {
            addCriterion("is_valid not between", value1, value2, "isValid");
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

        public Criteria andDepartNameLikeInsensitive(String value) {
            addCriterion("upper(depart_name) like", value.toUpperCase(), "departName");
            return (Criteria) this;
        }

        public Criteria andFundNameLikeInsensitive(String value) {
            addCriterion("upper(fund_name) like", value.toUpperCase(), "fundName");
            return (Criteria) this;
        }

        public Criteria andVoucherNoLikeInsensitive(String value) {
            addCriterion("upper(voucher_no) like", value.toUpperCase(), "voucherNo");
            return (Criteria) this;
        }

        public Criteria andIndexIdLikeInsensitive(String value) {
            addCriterion("upper(index_id) like", value.toUpperCase(), "indexId");
            return (Criteria) this;
        }

        public Criteria andSuperiorFileLikeInsensitive(String value) {
            addCriterion("upper(superior_file) like", value.toUpperCase(), "superiorFile");
            return (Criteria) this;
        }

        public Criteria andLocalFileLikeInsensitive(String value) {
            addCriterion("upper(local_file) like", value.toUpperCase(), "localFile");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
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