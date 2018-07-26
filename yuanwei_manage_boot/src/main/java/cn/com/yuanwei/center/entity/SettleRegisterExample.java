package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SettleRegisterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettleRegisterExample() {
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

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andPoliticalIsNull() {
            addCriterion("political is null");
            return (Criteria) this;
        }

        public Criteria andPoliticalIsNotNull() {
            addCriterion("political is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticalEqualTo(String value) {
            addCriterion("political =", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalNotEqualTo(String value) {
            addCriterion("political <>", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalGreaterThan(String value) {
            addCriterion("political >", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalGreaterThanOrEqualTo(String value) {
            addCriterion("political >=", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalLessThan(String value) {
            addCriterion("political <", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalLessThanOrEqualTo(String value) {
            addCriterion("political <=", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalLike(String value) {
            addCriterion("political like", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalNotLike(String value) {
            addCriterion("political not like", value, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalIn(List<String> values) {
            addCriterion("political in", values, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalNotIn(List<String> values) {
            addCriterion("political not in", values, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalBetween(String value1, String value2) {
            addCriterion("political between", value1, value2, "political");
            return (Criteria) this;
        }

        public Criteria andPoliticalNotBetween(String value1, String value2) {
            addCriterion("political not between", value1, value2, "political");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNull() {
            addCriterion("native_place is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNotNull() {
            addCriterion("native_place is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceEqualTo(String value) {
            addCriterion("native_place =", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotEqualTo(String value) {
            addCriterion("native_place <>", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThan(String value) {
            addCriterion("native_place >", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("native_place >=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThan(String value) {
            addCriterion("native_place <", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("native_place <=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLike(String value) {
            addCriterion("native_place like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotLike(String value) {
            addCriterion("native_place not like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIn(List<String> values) {
            addCriterion("native_place in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotIn(List<String> values) {
            addCriterion("native_place not in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceBetween(String value1, String value2) {
            addCriterion("native_place between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotBetween(String value1, String value2) {
            addCriterion("native_place not between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(Integer value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(Integer value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(Integer value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(Integer value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(Integer value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(Integer value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<Integer> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<Integer> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(Integer value1, Integer value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(Integer value1, Integer value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectIsNull() {
            addCriterion("business_subject is null");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectIsNotNull() {
            addCriterion("business_subject is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectEqualTo(String value) {
            addCriterion("business_subject =", value, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectNotEqualTo(String value) {
            addCriterion("business_subject <>", value, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectGreaterThan(String value) {
            addCriterion("business_subject >", value, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("business_subject >=", value, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectLessThan(String value) {
            addCriterion("business_subject <", value, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectLessThanOrEqualTo(String value) {
            addCriterion("business_subject <=", value, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectLike(String value) {
            addCriterion("business_subject like", value, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectNotLike(String value) {
            addCriterion("business_subject not like", value, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectIn(List<String> values) {
            addCriterion("business_subject in", values, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectNotIn(List<String> values) {
            addCriterion("business_subject not in", values, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectBetween(String value1, String value2) {
            addCriterion("business_subject between", value1, value2, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectNotBetween(String value1, String value2) {
            addCriterion("business_subject not between", value1, value2, "businessSubject");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNull() {
            addCriterion("legal_person is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("legal_person =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("legal_person <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("legal_person >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("legal_person <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("legal_person <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("legal_person like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("legal_person not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("legal_person in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("legal_person not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("legal_person between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("legal_person not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNull() {
            addCriterion("company_type is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNotNull() {
            addCriterion("company_type is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeEqualTo(Integer value) {
            addCriterion("company_type =", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotEqualTo(Integer value) {
            addCriterion("company_type <>", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThan(Integer value) {
            addCriterion("company_type >", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_type >=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThan(Integer value) {
            addCriterion("company_type <", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("company_type <=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIn(List<Integer> values) {
            addCriterion("company_type in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotIn(List<Integer> values) {
            addCriterion("company_type not in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeBetween(Integer value1, Integer value2) {
            addCriterion("company_type between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("company_type not between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeIsNull() {
            addCriterion("business_income is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeIsNotNull() {
            addCriterion("business_income is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeEqualTo(BigDecimal value) {
            addCriterion("business_income =", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeNotEqualTo(BigDecimal value) {
            addCriterion("business_income <>", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeGreaterThan(BigDecimal value) {
            addCriterion("business_income >", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("business_income >=", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeLessThan(BigDecimal value) {
            addCriterion("business_income <", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("business_income <=", value, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeIn(List<BigDecimal> values) {
            addCriterion("business_income in", values, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeNotIn(List<BigDecimal> values) {
            addCriterion("business_income not in", values, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("business_income between", value1, value2, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("business_income not between", value1, value2, "businessIncome");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceIsNull() {
            addCriterion("business_place is null");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceIsNotNull() {
            addCriterion("business_place is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceEqualTo(String value) {
            addCriterion("business_place =", value, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceNotEqualTo(String value) {
            addCriterion("business_place <>", value, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceGreaterThan(String value) {
            addCriterion("business_place >", value, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("business_place >=", value, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceLessThan(String value) {
            addCriterion("business_place <", value, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceLessThanOrEqualTo(String value) {
            addCriterion("business_place <=", value, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceLike(String value) {
            addCriterion("business_place like", value, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceNotLike(String value) {
            addCriterion("business_place not like", value, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceIn(List<String> values) {
            addCriterion("business_place in", values, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceNotIn(List<String> values) {
            addCriterion("business_place not in", values, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceBetween(String value1, String value2) {
            addCriterion("business_place between", value1, value2, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceNotBetween(String value1, String value2) {
            addCriterion("business_place not between", value1, value2, "businessPlace");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformIsNull() {
            addCriterion("settled_platform is null");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformIsNotNull() {
            addCriterion("settled_platform is not null");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformEqualTo(Integer value) {
            addCriterion("settled_platform =", value, "settledPlatform");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformNotEqualTo(Integer value) {
            addCriterion("settled_platform <>", value, "settledPlatform");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformGreaterThan(Integer value) {
            addCriterion("settled_platform >", value, "settledPlatform");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("settled_platform >=", value, "settledPlatform");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformLessThan(Integer value) {
            addCriterion("settled_platform <", value, "settledPlatform");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformLessThanOrEqualTo(Integer value) {
            addCriterion("settled_platform <=", value, "settledPlatform");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformIn(List<Integer> values) {
            addCriterion("settled_platform in", values, "settledPlatform");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformNotIn(List<Integer> values) {
            addCriterion("settled_platform not in", values, "settledPlatform");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformBetween(Integer value1, Integer value2) {
            addCriterion("settled_platform between", value1, value2, "settledPlatform");
            return (Criteria) this;
        }

        public Criteria andSettledPlatformNotBetween(Integer value1, Integer value2) {
            addCriterion("settled_platform not between", value1, value2, "settledPlatform");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopUrlIsNull() {
            addCriterion("shop_url is null");
            return (Criteria) this;
        }

        public Criteria andShopUrlIsNotNull() {
            addCriterion("shop_url is not null");
            return (Criteria) this;
        }

        public Criteria andShopUrlEqualTo(String value) {
            addCriterion("shop_url =", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotEqualTo(String value) {
            addCriterion("shop_url <>", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlGreaterThan(String value) {
            addCriterion("shop_url >", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlGreaterThanOrEqualTo(String value) {
            addCriterion("shop_url >=", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlLessThan(String value) {
            addCriterion("shop_url <", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlLessThanOrEqualTo(String value) {
            addCriterion("shop_url <=", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlLike(String value) {
            addCriterion("shop_url like", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotLike(String value) {
            addCriterion("shop_url not like", value, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlIn(List<String> values) {
            addCriterion("shop_url in", values, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotIn(List<String> values) {
            addCriterion("shop_url not in", values, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlBetween(String value1, String value2) {
            addCriterion("shop_url between", value1, value2, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andShopUrlNotBetween(String value1, String value2) {
            addCriterion("shop_url not between", value1, value2, "shopUrl");
            return (Criteria) this;
        }

        public Criteria andCreditRatingIsNull() {
            addCriterion("credit_rating is null");
            return (Criteria) this;
        }

        public Criteria andCreditRatingIsNotNull() {
            addCriterion("credit_rating is not null");
            return (Criteria) this;
        }

        public Criteria andCreditRatingEqualTo(String value) {
            addCriterion("credit_rating =", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingNotEqualTo(String value) {
            addCriterion("credit_rating <>", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingGreaterThan(String value) {
            addCriterion("credit_rating >", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingGreaterThanOrEqualTo(String value) {
            addCriterion("credit_rating >=", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingLessThan(String value) {
            addCriterion("credit_rating <", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingLessThanOrEqualTo(String value) {
            addCriterion("credit_rating <=", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingLike(String value) {
            addCriterion("credit_rating like", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingNotLike(String value) {
            addCriterion("credit_rating not like", value, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingIn(List<String> values) {
            addCriterion("credit_rating in", values, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingNotIn(List<String> values) {
            addCriterion("credit_rating not in", values, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingBetween(String value1, String value2) {
            addCriterion("credit_rating between", value1, value2, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCreditRatingNotBetween(String value1, String value2) {
            addCriterion("credit_rating not between", value1, value2, "creditRating");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteIsNull() {
            addCriterion("company_website is null");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteIsNotNull() {
            addCriterion("company_website is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteEqualTo(String value) {
            addCriterion("company_website =", value, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteNotEqualTo(String value) {
            addCriterion("company_website <>", value, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteGreaterThan(String value) {
            addCriterion("company_website >", value, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("company_website >=", value, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteLessThan(String value) {
            addCriterion("company_website <", value, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteLessThanOrEqualTo(String value) {
            addCriterion("company_website <=", value, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteLike(String value) {
            addCriterion("company_website like", value, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteNotLike(String value) {
            addCriterion("company_website not like", value, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteIn(List<String> values) {
            addCriterion("company_website in", values, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteNotIn(List<String> values) {
            addCriterion("company_website not in", values, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteBetween(String value1, String value2) {
            addCriterion("company_website between", value1, value2, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteNotBetween(String value1, String value2) {
            addCriterion("company_website not between", value1, value2, "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesIsNull() {
            addCriterion("average_monthly_sales is null");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesIsNotNull() {
            addCriterion("average_monthly_sales is not null");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesEqualTo(String value) {
            addCriterion("average_monthly_sales =", value, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesNotEqualTo(String value) {
            addCriterion("average_monthly_sales <>", value, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesGreaterThan(String value) {
            addCriterion("average_monthly_sales >", value, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesGreaterThanOrEqualTo(String value) {
            addCriterion("average_monthly_sales >=", value, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesLessThan(String value) {
            addCriterion("average_monthly_sales <", value, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesLessThanOrEqualTo(String value) {
            addCriterion("average_monthly_sales <=", value, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesLike(String value) {
            addCriterion("average_monthly_sales like", value, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesNotLike(String value) {
            addCriterion("average_monthly_sales not like", value, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesIn(List<String> values) {
            addCriterion("average_monthly_sales in", values, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesNotIn(List<String> values) {
            addCriterion("average_monthly_sales not in", values, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesBetween(String value1, String value2) {
            addCriterion("average_monthly_sales between", value1, value2, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesNotBetween(String value1, String value2) {
            addCriterion("average_monthly_sales not between", value1, value2, "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomIsNull() {
            addCriterion("application_room is null");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomIsNotNull() {
            addCriterion("application_room is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomEqualTo(Integer value) {
            addCriterion("application_room =", value, "applicationRoom");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomNotEqualTo(Integer value) {
            addCriterion("application_room <>", value, "applicationRoom");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomGreaterThan(Integer value) {
            addCriterion("application_room >", value, "applicationRoom");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_room >=", value, "applicationRoom");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomLessThan(Integer value) {
            addCriterion("application_room <", value, "applicationRoom");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomLessThanOrEqualTo(Integer value) {
            addCriterion("application_room <=", value, "applicationRoom");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomIn(List<Integer> values) {
            addCriterion("application_room in", values, "applicationRoom");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomNotIn(List<Integer> values) {
            addCriterion("application_room not in", values, "applicationRoom");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomBetween(Integer value1, Integer value2) {
            addCriterion("application_room between", value1, value2, "applicationRoom");
            return (Criteria) this;
        }

        public Criteria andApplicationRoomNotBetween(Integer value1, Integer value2) {
            addCriterion("application_room not between", value1, value2, "applicationRoom");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaIsNull() {
            addCriterion("application_area is null");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaIsNotNull() {
            addCriterion("application_area is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaEqualTo(String value) {
            addCriterion("application_area =", value, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaNotEqualTo(String value) {
            addCriterion("application_area <>", value, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaGreaterThan(String value) {
            addCriterion("application_area >", value, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaGreaterThanOrEqualTo(String value) {
            addCriterion("application_area >=", value, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaLessThan(String value) {
            addCriterion("application_area <", value, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaLessThanOrEqualTo(String value) {
            addCriterion("application_area <=", value, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaLike(String value) {
            addCriterion("application_area like", value, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaNotLike(String value) {
            addCriterion("application_area not like", value, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaIn(List<String> values) {
            addCriterion("application_area in", values, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaNotIn(List<String> values) {
            addCriterion("application_area not in", values, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaBetween(String value1, String value2) {
            addCriterion("application_area between", value1, value2, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaNotBetween(String value1, String value2) {
            addCriterion("application_area not between", value1, value2, "applicationArea");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceIsNull() {
            addCriterion("equipment_source is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceIsNotNull() {
            addCriterion("equipment_source is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceEqualTo(Integer value) {
            addCriterion("equipment_source =", value, "equipmentSource");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceNotEqualTo(Integer value) {
            addCriterion("equipment_source <>", value, "equipmentSource");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceGreaterThan(Integer value) {
            addCriterion("equipment_source >", value, "equipmentSource");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("equipment_source >=", value, "equipmentSource");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceLessThan(Integer value) {
            addCriterion("equipment_source <", value, "equipmentSource");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceLessThanOrEqualTo(Integer value) {
            addCriterion("equipment_source <=", value, "equipmentSource");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceIn(List<Integer> values) {
            addCriterion("equipment_source in", values, "equipmentSource");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceNotIn(List<Integer> values) {
            addCriterion("equipment_source not in", values, "equipmentSource");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceBetween(Integer value1, Integer value2) {
            addCriterion("equipment_source between", value1, value2, "equipmentSource");
            return (Criteria) this;
        }

        public Criteria andEquipmentSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("equipment_source not between", value1, value2, "equipmentSource");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andTeamNumberIsNull() {
            addCriterion("team_number is null");
            return (Criteria) this;
        }

        public Criteria andTeamNumberIsNotNull() {
            addCriterion("team_number is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNumberEqualTo(Integer value) {
            addCriterion("team_number =", value, "teamNumber");
            return (Criteria) this;
        }

        public Criteria andTeamNumberNotEqualTo(Integer value) {
            addCriterion("team_number <>", value, "teamNumber");
            return (Criteria) this;
        }

        public Criteria andTeamNumberGreaterThan(Integer value) {
            addCriterion("team_number >", value, "teamNumber");
            return (Criteria) this;
        }

        public Criteria andTeamNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_number >=", value, "teamNumber");
            return (Criteria) this;
        }

        public Criteria andTeamNumberLessThan(Integer value) {
            addCriterion("team_number <", value, "teamNumber");
            return (Criteria) this;
        }

        public Criteria andTeamNumberLessThanOrEqualTo(Integer value) {
            addCriterion("team_number <=", value, "teamNumber");
            return (Criteria) this;
        }

        public Criteria andTeamNumberIn(List<Integer> values) {
            addCriterion("team_number in", values, "teamNumber");
            return (Criteria) this;
        }

        public Criteria andTeamNumberNotIn(List<Integer> values) {
            addCriterion("team_number not in", values, "teamNumber");
            return (Criteria) this;
        }

        public Criteria andTeamNumberBetween(Integer value1, Integer value2) {
            addCriterion("team_number between", value1, value2, "teamNumber");
            return (Criteria) this;
        }

        public Criteria andTeamNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("team_number not between", value1, value2, "teamNumber");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationIsNull() {
            addCriterion("join_association is null");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationIsNotNull() {
            addCriterion("join_association is not null");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationEqualTo(Integer value) {
            addCriterion("join_association =", value, "joinAssociation");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationNotEqualTo(Integer value) {
            addCriterion("join_association <>", value, "joinAssociation");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationGreaterThan(Integer value) {
            addCriterion("join_association >", value, "joinAssociation");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_association >=", value, "joinAssociation");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationLessThan(Integer value) {
            addCriterion("join_association <", value, "joinAssociation");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationLessThanOrEqualTo(Integer value) {
            addCriterion("join_association <=", value, "joinAssociation");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationIn(List<Integer> values) {
            addCriterion("join_association in", values, "joinAssociation");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationNotIn(List<Integer> values) {
            addCriterion("join_association not in", values, "joinAssociation");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationBetween(Integer value1, Integer value2) {
            addCriterion("join_association between", value1, value2, "joinAssociation");
            return (Criteria) this;
        }

        public Criteria andJoinAssociationNotBetween(Integer value1, Integer value2) {
            addCriterion("join_association not between", value1, value2, "joinAssociation");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionIsNull() {
            addCriterion("project_introduction is null");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionIsNotNull() {
            addCriterion("project_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionEqualTo(String value) {
            addCriterion("project_introduction =", value, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionNotEqualTo(String value) {
            addCriterion("project_introduction <>", value, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionGreaterThan(String value) {
            addCriterion("project_introduction >", value, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("project_introduction >=", value, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionLessThan(String value) {
            addCriterion("project_introduction <", value, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionLessThanOrEqualTo(String value) {
            addCriterion("project_introduction <=", value, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionLike(String value) {
            addCriterion("project_introduction like", value, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionNotLike(String value) {
            addCriterion("project_introduction not like", value, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionIn(List<String> values) {
            addCriterion("project_introduction in", values, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionNotIn(List<String> values) {
            addCriterion("project_introduction not in", values, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionBetween(String value1, String value2) {
            addCriterion("project_introduction between", value1, value2, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionNotBetween(String value1, String value2) {
            addCriterion("project_introduction not between", value1, value2, "projectIntroduction");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andIdNumberLikeInsensitive(String value) {
            addCriterion("upper(id_number) like", value.toUpperCase(), "idNumber");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andPoliticalLikeInsensitive(String value) {
            addCriterion("upper(political) like", value.toUpperCase(), "political");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLikeInsensitive(String value) {
            addCriterion("upper(native_place) like", value.toUpperCase(), "nativePlace");
            return (Criteria) this;
        }

        public Criteria andMobileLikeInsensitive(String value) {
            addCriterion("upper(mobile) like", value.toUpperCase(), "mobile");
            return (Criteria) this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(email) like", value.toUpperCase(), "email");
            return (Criteria) this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return (Criteria) this;
        }

        public Criteria andPicLikeInsensitive(String value) {
            addCriterion("upper(pic) like", value.toUpperCase(), "pic");
            return (Criteria) this;
        }

        public Criteria andBusinessSubjectLikeInsensitive(String value) {
            addCriterion("upper(business_subject) like", value.toUpperCase(), "businessSubject");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLikeInsensitive(String value) {
            addCriterion("upper(legal_person) like", value.toUpperCase(), "legalPerson");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLikeInsensitive(String value) {
            addCriterion("upper(business_license) like", value.toUpperCase(), "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessPlaceLikeInsensitive(String value) {
            addCriterion("upper(business_place) like", value.toUpperCase(), "businessPlace");
            return (Criteria) this;
        }

        public Criteria andShopNameLikeInsensitive(String value) {
            addCriterion("upper(shop_name) like", value.toUpperCase(), "shopName");
            return (Criteria) this;
        }

        public Criteria andShopUrlLikeInsensitive(String value) {
            addCriterion("upper(shop_url) like", value.toUpperCase(), "shopUrl");
            return (Criteria) this;
        }

        public Criteria andCreditRatingLikeInsensitive(String value) {
            addCriterion("upper(credit_rating) like", value.toUpperCase(), "creditRating");
            return (Criteria) this;
        }

        public Criteria andCompanyWebsiteLikeInsensitive(String value) {
            addCriterion("upper(company_website) like", value.toUpperCase(), "companyWebsite");
            return (Criteria) this;
        }

        public Criteria andCategoryLikeInsensitive(String value) {
            addCriterion("upper(category) like", value.toUpperCase(), "category");
            return (Criteria) this;
        }

        public Criteria andAverageMonthlySalesLikeInsensitive(String value) {
            addCriterion("upper(average_monthly_sales) like", value.toUpperCase(), "averageMonthlySales");
            return (Criteria) this;
        }

        public Criteria andApplicationAreaLikeInsensitive(String value) {
            addCriterion("upper(application_area) like", value.toUpperCase(), "applicationArea");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLikeInsensitive(String value) {
            addCriterion("upper(business_scope) like", value.toUpperCase(), "businessScope");
            return (Criteria) this;
        }

        public Criteria andProjectIntroductionLikeInsensitive(String value) {
            addCriterion("upper(project_introduction) like", value.toUpperCase(), "projectIntroduction");
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