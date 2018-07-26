package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterpriseExample() {
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

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(Integer value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(Integer value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(Integer value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(Integer value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(Integer value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(Integer value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<Integer> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<Integer> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(Integer value1, Integer value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(Integer value1, Integer value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andChargeNameIsNull() {
            addCriterion("charge_name is null");
            return (Criteria) this;
        }

        public Criteria andChargeNameIsNotNull() {
            addCriterion("charge_name is not null");
            return (Criteria) this;
        }

        public Criteria andChargeNameEqualTo(String value) {
            addCriterion("charge_name =", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameNotEqualTo(String value) {
            addCriterion("charge_name <>", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameGreaterThan(String value) {
            addCriterion("charge_name >", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameGreaterThanOrEqualTo(String value) {
            addCriterion("charge_name >=", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameLessThan(String value) {
            addCriterion("charge_name <", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameLessThanOrEqualTo(String value) {
            addCriterion("charge_name <=", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameLike(String value) {
            addCriterion("charge_name like", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameNotLike(String value) {
            addCriterion("charge_name not like", value, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameIn(List<String> values) {
            addCriterion("charge_name in", values, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameNotIn(List<String> values) {
            addCriterion("charge_name not in", values, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameBetween(String value1, String value2) {
            addCriterion("charge_name between", value1, value2, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeNameNotBetween(String value1, String value2) {
            addCriterion("charge_name not between", value1, value2, "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeMobileIsNull() {
            addCriterion("charge_mobile is null");
            return (Criteria) this;
        }

        public Criteria andChargeMobileIsNotNull() {
            addCriterion("charge_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andChargeMobileEqualTo(String value) {
            addCriterion("charge_mobile =", value, "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andChargeMobileNotEqualTo(String value) {
            addCriterion("charge_mobile <>", value, "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andChargeMobileGreaterThan(String value) {
            addCriterion("charge_mobile >", value, "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andChargeMobileGreaterThanOrEqualTo(String value) {
            addCriterion("charge_mobile >=", value, "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andChargeMobileLessThan(String value) {
            addCriterion("charge_mobile <", value, "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andChargeMobileLessThanOrEqualTo(String value) {
            addCriterion("charge_mobile <=", value, "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andChargeMobileLike(String value) {
            addCriterion("charge_mobile like", value, "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andChargeMobileNotLike(String value) {
            addCriterion("charge_mobile not like", value, "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andChargeMobileIn(List<String> values) {
            addCriterion("charge_mobile in", values, "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andChargeMobileNotIn(List<String> values) {
            addCriterion("charge_mobile not in", values, "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andChargeMobileBetween(String value1, String value2) {
            addCriterion("charge_mobile between", value1, value2, "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andChargeMobileNotBetween(String value1, String value2) {
            addCriterion("charge_mobile not between", value1, value2, "chargeMobile");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andInDateIsNull() {
            addCriterion("in_date is null");
            return (Criteria) this;
        }

        public Criteria andInDateIsNotNull() {
            addCriterion("in_date is not null");
            return (Criteria) this;
        }

        public Criteria andInDateEqualTo(Date value) {
            addCriterion("in_date =", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotEqualTo(Date value) {
            addCriterion("in_date <>", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThan(Date value) {
            addCriterion("in_date >", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThanOrEqualTo(Date value) {
            addCriterion("in_date >=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThan(Date value) {
            addCriterion("in_date <", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThanOrEqualTo(Date value) {
            addCriterion("in_date <=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateIn(List<Date> values) {
            addCriterion("in_date in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotIn(List<Date> values) {
            addCriterion("in_date not in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateBetween(Date value1, Date value2) {
            addCriterion("in_date between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotBetween(Date value1, Date value2) {
            addCriterion("in_date not between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNull() {
            addCriterion("out_date is null");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNotNull() {
            addCriterion("out_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutDateEqualTo(Date value) {
            addCriterion("out_date =", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotEqualTo(Date value) {
            addCriterion("out_date <>", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThan(Date value) {
            addCriterion("out_date >", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThanOrEqualTo(Date value) {
            addCriterion("out_date >=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThan(Date value) {
            addCriterion("out_date <", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThanOrEqualTo(Date value) {
            addCriterion("out_date <=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIn(List<Date> values) {
            addCriterion("out_date in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotIn(List<Date> values) {
            addCriterion("out_date not in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateBetween(Date value1, Date value2) {
            addCriterion("out_date between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotBetween(Date value1, Date value2) {
            addCriterion("out_date not between", value1, value2, "outDate");
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

        public Criteria andAgentIsNull() {
            addCriterion("agent is null");
            return (Criteria) this;
        }

        public Criteria andAgentIsNotNull() {
            addCriterion("agent is not null");
            return (Criteria) this;
        }

        public Criteria andAgentEqualTo(Integer value) {
            addCriterion("agent =", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotEqualTo(Integer value) {
            addCriterion("agent <>", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThan(Integer value) {
            addCriterion("agent >", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent >=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThan(Integer value) {
            addCriterion("agent <", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThanOrEqualTo(Integer value) {
            addCriterion("agent <=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentIn(List<Integer> values) {
            addCriterion("agent in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotIn(List<Integer> values) {
            addCriterion("agent not in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentBetween(Integer value1, Integer value2) {
            addCriterion("agent between", value1, value2, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotBetween(Integer value1, Integer value2) {
            addCriterion("agent not between", value1, value2, "agent");
            return (Criteria) this;
        }

        public Criteria andThresholdIsNull() {
            addCriterion("threshold is null");
            return (Criteria) this;
        }

        public Criteria andThresholdIsNotNull() {
            addCriterion("threshold is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdEqualTo(BigDecimal value) {
            addCriterion("threshold =", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotEqualTo(BigDecimal value) {
            addCriterion("threshold <>", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThan(BigDecimal value) {
            addCriterion("threshold >", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("threshold >=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThan(BigDecimal value) {
            addCriterion("threshold <", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("threshold <=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdIn(List<BigDecimal> values) {
            addCriterion("threshold in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotIn(List<BigDecimal> values) {
            addCriterion("threshold not in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("threshold between", value1, value2, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("threshold not between", value1, value2, "threshold");
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

        public Criteria andEnterpriseCodeLikeInsensitive(String value) {
            addCriterion("upper(enterprise_code) like", value.toUpperCase(), "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLikeInsensitive(String value) {
            addCriterion("upper(enterprise_name) like", value.toUpperCase(), "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andChargeNameLikeInsensitive(String value) {
            addCriterion("upper(charge_name) like", value.toUpperCase(), "chargeName");
            return (Criteria) this;
        }

        public Criteria andChargeMobileLikeInsensitive(String value) {
            addCriterion("upper(charge_mobile) like", value.toUpperCase(), "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andUserNameLikeInsensitive(String value) {
            addCriterion("upper(user_name) like", value.toUpperCase(), "userName");
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