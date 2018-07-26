package cn.com.yuanwei.center.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdviceExample() {
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

        public Criteria andAdviceTitleIsNull() {
            addCriterion("advice_title is null");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleIsNotNull() {
            addCriterion("advice_title is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleEqualTo(String value) {
            addCriterion("advice_title =", value, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleNotEqualTo(String value) {
            addCriterion("advice_title <>", value, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleGreaterThan(String value) {
            addCriterion("advice_title >", value, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("advice_title >=", value, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleLessThan(String value) {
            addCriterion("advice_title <", value, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleLessThanOrEqualTo(String value) {
            addCriterion("advice_title <=", value, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleLike(String value) {
            addCriterion("advice_title like", value, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleNotLike(String value) {
            addCriterion("advice_title not like", value, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleIn(List<String> values) {
            addCriterion("advice_title in", values, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleNotIn(List<String> values) {
            addCriterion("advice_title not in", values, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleBetween(String value1, String value2) {
            addCriterion("advice_title between", value1, value2, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceTitleNotBetween(String value1, String value2) {
            addCriterion("advice_title not between", value1, value2, "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceContentIsNull() {
            addCriterion("advice_content is null");
            return (Criteria) this;
        }

        public Criteria andAdviceContentIsNotNull() {
            addCriterion("advice_content is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceContentEqualTo(String value) {
            addCriterion("advice_content =", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentNotEqualTo(String value) {
            addCriterion("advice_content <>", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentGreaterThan(String value) {
            addCriterion("advice_content >", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentGreaterThanOrEqualTo(String value) {
            addCriterion("advice_content >=", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentLessThan(String value) {
            addCriterion("advice_content <", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentLessThanOrEqualTo(String value) {
            addCriterion("advice_content <=", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentLike(String value) {
            addCriterion("advice_content like", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentNotLike(String value) {
            addCriterion("advice_content not like", value, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentIn(List<String> values) {
            addCriterion("advice_content in", values, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentNotIn(List<String> values) {
            addCriterion("advice_content not in", values, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentBetween(String value1, String value2) {
            addCriterion("advice_content between", value1, value2, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceContentNotBetween(String value1, String value2) {
            addCriterion("advice_content not between", value1, value2, "adviceContent");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeIsNull() {
            addCriterion("advice_type is null");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeIsNotNull() {
            addCriterion("advice_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeEqualTo(Integer value) {
            addCriterion("advice_type =", value, "adviceType");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeNotEqualTo(Integer value) {
            addCriterion("advice_type <>", value, "adviceType");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeGreaterThan(Integer value) {
            addCriterion("advice_type >", value, "adviceType");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("advice_type >=", value, "adviceType");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeLessThan(Integer value) {
            addCriterion("advice_type <", value, "adviceType");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("advice_type <=", value, "adviceType");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeIn(List<Integer> values) {
            addCriterion("advice_type in", values, "adviceType");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeNotIn(List<Integer> values) {
            addCriterion("advice_type not in", values, "adviceType");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeBetween(Integer value1, Integer value2) {
            addCriterion("advice_type between", value1, value2, "adviceType");
            return (Criteria) this;
        }

        public Criteria andAdviceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("advice_type not between", value1, value2, "adviceType");
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

        public Criteria andIsDealIsNull() {
            addCriterion("is_deal is null");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNotNull() {
            addCriterion("is_deal is not null");
            return (Criteria) this;
        }

        public Criteria andIsDealEqualTo(Integer value) {
            addCriterion("is_deal =", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotEqualTo(Integer value) {
            addCriterion("is_deal <>", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThan(Integer value) {
            addCriterion("is_deal >", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deal >=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThan(Integer value) {
            addCriterion("is_deal <", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThanOrEqualTo(Integer value) {
            addCriterion("is_deal <=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealIn(List<Integer> values) {
            addCriterion("is_deal in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotIn(List<Integer> values) {
            addCriterion("is_deal not in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealBetween(Integer value1, Integer value2) {
            addCriterion("is_deal between", value1, value2, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deal not between", value1, value2, "isDeal");
            return (Criteria) this;
        }

        public Criteria andResContentIsNull() {
            addCriterion("res_content is null");
            return (Criteria) this;
        }

        public Criteria andResContentIsNotNull() {
            addCriterion("res_content is not null");
            return (Criteria) this;
        }

        public Criteria andResContentEqualTo(String value) {
            addCriterion("res_content =", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentNotEqualTo(String value) {
            addCriterion("res_content <>", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentGreaterThan(String value) {
            addCriterion("res_content >", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentGreaterThanOrEqualTo(String value) {
            addCriterion("res_content >=", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentLessThan(String value) {
            addCriterion("res_content <", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentLessThanOrEqualTo(String value) {
            addCriterion("res_content <=", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentLike(String value) {
            addCriterion("res_content like", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentNotLike(String value) {
            addCriterion("res_content not like", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentIn(List<String> values) {
            addCriterion("res_content in", values, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentNotIn(List<String> values) {
            addCriterion("res_content not in", values, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentBetween(String value1, String value2) {
            addCriterion("res_content between", value1, value2, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentNotBetween(String value1, String value2) {
            addCriterion("res_content not between", value1, value2, "resContent");
            return (Criteria) this;
        }

        public Criteria andDealByIsNull() {
            addCriterion("deal_by is null");
            return (Criteria) this;
        }

        public Criteria andDealByIsNotNull() {
            addCriterion("deal_by is not null");
            return (Criteria) this;
        }

        public Criteria andDealByEqualTo(Integer value) {
            addCriterion("deal_by =", value, "dealBy");
            return (Criteria) this;
        }

        public Criteria andDealByNotEqualTo(Integer value) {
            addCriterion("deal_by <>", value, "dealBy");
            return (Criteria) this;
        }

        public Criteria andDealByGreaterThan(Integer value) {
            addCriterion("deal_by >", value, "dealBy");
            return (Criteria) this;
        }

        public Criteria andDealByGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_by >=", value, "dealBy");
            return (Criteria) this;
        }

        public Criteria andDealByLessThan(Integer value) {
            addCriterion("deal_by <", value, "dealBy");
            return (Criteria) this;
        }

        public Criteria andDealByLessThanOrEqualTo(Integer value) {
            addCriterion("deal_by <=", value, "dealBy");
            return (Criteria) this;
        }

        public Criteria andDealByIn(List<Integer> values) {
            addCriterion("deal_by in", values, "dealBy");
            return (Criteria) this;
        }

        public Criteria andDealByNotIn(List<Integer> values) {
            addCriterion("deal_by not in", values, "dealBy");
            return (Criteria) this;
        }

        public Criteria andDealByBetween(Integer value1, Integer value2) {
            addCriterion("deal_by between", value1, value2, "dealBy");
            return (Criteria) this;
        }

        public Criteria andDealByNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_by not between", value1, value2, "dealBy");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andAudit1ByIsNull() {
            addCriterion("audit1_by is null");
            return (Criteria) this;
        }

        public Criteria andAudit1ByIsNotNull() {
            addCriterion("audit1_by is not null");
            return (Criteria) this;
        }

        public Criteria andAudit1ByEqualTo(Integer value) {
            addCriterion("audit1_by =", value, "audit1By");
            return (Criteria) this;
        }

        public Criteria andAudit1ByNotEqualTo(Integer value) {
            addCriterion("audit1_by <>", value, "audit1By");
            return (Criteria) this;
        }

        public Criteria andAudit1ByGreaterThan(Integer value) {
            addCriterion("audit1_by >", value, "audit1By");
            return (Criteria) this;
        }

        public Criteria andAudit1ByGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit1_by >=", value, "audit1By");
            return (Criteria) this;
        }

        public Criteria andAudit1ByLessThan(Integer value) {
            addCriterion("audit1_by <", value, "audit1By");
            return (Criteria) this;
        }

        public Criteria andAudit1ByLessThanOrEqualTo(Integer value) {
            addCriterion("audit1_by <=", value, "audit1By");
            return (Criteria) this;
        }

        public Criteria andAudit1ByIn(List<Integer> values) {
            addCriterion("audit1_by in", values, "audit1By");
            return (Criteria) this;
        }

        public Criteria andAudit1ByNotIn(List<Integer> values) {
            addCriterion("audit1_by not in", values, "audit1By");
            return (Criteria) this;
        }

        public Criteria andAudit1ByBetween(Integer value1, Integer value2) {
            addCriterion("audit1_by between", value1, value2, "audit1By");
            return (Criteria) this;
        }

        public Criteria andAudit1ByNotBetween(Integer value1, Integer value2) {
            addCriterion("audit1_by not between", value1, value2, "audit1By");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeIsNull() {
            addCriterion("audit1_time is null");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeIsNotNull() {
            addCriterion("audit1_time is not null");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeEqualTo(Date value) {
            addCriterion("audit1_time =", value, "audit1Time");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeNotEqualTo(Date value) {
            addCriterion("audit1_time <>", value, "audit1Time");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeGreaterThan(Date value) {
            addCriterion("audit1_time >", value, "audit1Time");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit1_time >=", value, "audit1Time");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeLessThan(Date value) {
            addCriterion("audit1_time <", value, "audit1Time");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeLessThanOrEqualTo(Date value) {
            addCriterion("audit1_time <=", value, "audit1Time");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeIn(List<Date> values) {
            addCriterion("audit1_time in", values, "audit1Time");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeNotIn(List<Date> values) {
            addCriterion("audit1_time not in", values, "audit1Time");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeBetween(Date value1, Date value2) {
            addCriterion("audit1_time between", value1, value2, "audit1Time");
            return (Criteria) this;
        }

        public Criteria andAudit1TimeNotBetween(Date value1, Date value2) {
            addCriterion("audit1_time not between", value1, value2, "audit1Time");
            return (Criteria) this;
        }

        public Criteria andAudit2ByIsNull() {
            addCriterion("audit2_by is null");
            return (Criteria) this;
        }

        public Criteria andAudit2ByIsNotNull() {
            addCriterion("audit2_by is not null");
            return (Criteria) this;
        }

        public Criteria andAudit2ByEqualTo(Integer value) {
            addCriterion("audit2_by =", value, "audit2By");
            return (Criteria) this;
        }

        public Criteria andAudit2ByNotEqualTo(Integer value) {
            addCriterion("audit2_by <>", value, "audit2By");
            return (Criteria) this;
        }

        public Criteria andAudit2ByGreaterThan(Integer value) {
            addCriterion("audit2_by >", value, "audit2By");
            return (Criteria) this;
        }

        public Criteria andAudit2ByGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit2_by >=", value, "audit2By");
            return (Criteria) this;
        }

        public Criteria andAudit2ByLessThan(Integer value) {
            addCriterion("audit2_by <", value, "audit2By");
            return (Criteria) this;
        }

        public Criteria andAudit2ByLessThanOrEqualTo(Integer value) {
            addCriterion("audit2_by <=", value, "audit2By");
            return (Criteria) this;
        }

        public Criteria andAudit2ByIn(List<Integer> values) {
            addCriterion("audit2_by in", values, "audit2By");
            return (Criteria) this;
        }

        public Criteria andAudit2ByNotIn(List<Integer> values) {
            addCriterion("audit2_by not in", values, "audit2By");
            return (Criteria) this;
        }

        public Criteria andAudit2ByBetween(Integer value1, Integer value2) {
            addCriterion("audit2_by between", value1, value2, "audit2By");
            return (Criteria) this;
        }

        public Criteria andAudit2ByNotBetween(Integer value1, Integer value2) {
            addCriterion("audit2_by not between", value1, value2, "audit2By");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeIsNull() {
            addCriterion("audit2_time is null");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeIsNotNull() {
            addCriterion("audit2_time is not null");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeEqualTo(Date value) {
            addCriterion("audit2_time =", value, "audit2Time");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeNotEqualTo(Date value) {
            addCriterion("audit2_time <>", value, "audit2Time");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeGreaterThan(Date value) {
            addCriterion("audit2_time >", value, "audit2Time");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit2_time >=", value, "audit2Time");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeLessThan(Date value) {
            addCriterion("audit2_time <", value, "audit2Time");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeLessThanOrEqualTo(Date value) {
            addCriterion("audit2_time <=", value, "audit2Time");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeIn(List<Date> values) {
            addCriterion("audit2_time in", values, "audit2Time");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeNotIn(List<Date> values) {
            addCriterion("audit2_time not in", values, "audit2Time");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeBetween(Date value1, Date value2) {
            addCriterion("audit2_time between", value1, value2, "audit2Time");
            return (Criteria) this;
        }

        public Criteria andAudit2TimeNotBetween(Date value1, Date value2) {
            addCriterion("audit2_time not between", value1, value2, "audit2Time");
            return (Criteria) this;
        }

        public Criteria andAudit3ByIsNull() {
            addCriterion("audit3_by is null");
            return (Criteria) this;
        }

        public Criteria andAudit3ByIsNotNull() {
            addCriterion("audit3_by is not null");
            return (Criteria) this;
        }

        public Criteria andAudit3ByEqualTo(Integer value) {
            addCriterion("audit3_by =", value, "audit3By");
            return (Criteria) this;
        }

        public Criteria andAudit3ByNotEqualTo(Integer value) {
            addCriterion("audit3_by <>", value, "audit3By");
            return (Criteria) this;
        }

        public Criteria andAudit3ByGreaterThan(Integer value) {
            addCriterion("audit3_by >", value, "audit3By");
            return (Criteria) this;
        }

        public Criteria andAudit3ByGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit3_by >=", value, "audit3By");
            return (Criteria) this;
        }

        public Criteria andAudit3ByLessThan(Integer value) {
            addCriterion("audit3_by <", value, "audit3By");
            return (Criteria) this;
        }

        public Criteria andAudit3ByLessThanOrEqualTo(Integer value) {
            addCriterion("audit3_by <=", value, "audit3By");
            return (Criteria) this;
        }

        public Criteria andAudit3ByIn(List<Integer> values) {
            addCriterion("audit3_by in", values, "audit3By");
            return (Criteria) this;
        }

        public Criteria andAudit3ByNotIn(List<Integer> values) {
            addCriterion("audit3_by not in", values, "audit3By");
            return (Criteria) this;
        }

        public Criteria andAudit3ByBetween(Integer value1, Integer value2) {
            addCriterion("audit3_by between", value1, value2, "audit3By");
            return (Criteria) this;
        }

        public Criteria andAudit3ByNotBetween(Integer value1, Integer value2) {
            addCriterion("audit3_by not between", value1, value2, "audit3By");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeIsNull() {
            addCriterion("audit3_time is null");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeIsNotNull() {
            addCriterion("audit3_time is not null");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeEqualTo(Date value) {
            addCriterion("audit3_time =", value, "audit3Time");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeNotEqualTo(Date value) {
            addCriterion("audit3_time <>", value, "audit3Time");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeGreaterThan(Date value) {
            addCriterion("audit3_time >", value, "audit3Time");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit3_time >=", value, "audit3Time");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeLessThan(Date value) {
            addCriterion("audit3_time <", value, "audit3Time");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeLessThanOrEqualTo(Date value) {
            addCriterion("audit3_time <=", value, "audit3Time");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeIn(List<Date> values) {
            addCriterion("audit3_time in", values, "audit3Time");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeNotIn(List<Date> values) {
            addCriterion("audit3_time not in", values, "audit3Time");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeBetween(Date value1, Date value2) {
            addCriterion("audit3_time between", value1, value2, "audit3Time");
            return (Criteria) this;
        }

        public Criteria andAudit3TimeNotBetween(Date value1, Date value2) {
            addCriterion("audit3_time not between", value1, value2, "audit3Time");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
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

        public Criteria andAdviceTitleLikeInsensitive(String value) {
            addCriterion("upper(advice_title) like", value.toUpperCase(), "adviceTitle");
            return (Criteria) this;
        }

        public Criteria andAdviceContentLikeInsensitive(String value) {
            addCriterion("upper(advice_content) like", value.toUpperCase(), "adviceContent");
            return (Criteria) this;
        }

        public Criteria andResContentLikeInsensitive(String value) {
            addCriterion("upper(res_content) like", value.toUpperCase(), "resContent");
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