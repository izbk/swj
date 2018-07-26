package cn.com.yuanwei.center.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ToDoListExample() {
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

        public Criteria andAuditConfigIdIsNull() {
            addCriterion("audit_config_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditConfigIdIsNotNull() {
            addCriterion("audit_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditConfigIdEqualTo(Integer value) {
            addCriterion("audit_config_id =", value, "auditConfigId");
            return (Criteria) this;
        }

        public Criteria andAuditConfigIdNotEqualTo(Integer value) {
            addCriterion("audit_config_id <>", value, "auditConfigId");
            return (Criteria) this;
        }

        public Criteria andAuditConfigIdGreaterThan(Integer value) {
            addCriterion("audit_config_id >", value, "auditConfigId");
            return (Criteria) this;
        }

        public Criteria andAuditConfigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_config_id >=", value, "auditConfigId");
            return (Criteria) this;
        }

        public Criteria andAuditConfigIdLessThan(Integer value) {
            addCriterion("audit_config_id <", value, "auditConfigId");
            return (Criteria) this;
        }

        public Criteria andAuditConfigIdLessThanOrEqualTo(Integer value) {
            addCriterion("audit_config_id <=", value, "auditConfigId");
            return (Criteria) this;
        }

        public Criteria andAuditConfigIdIn(List<Integer> values) {
            addCriterion("audit_config_id in", values, "auditConfigId");
            return (Criteria) this;
        }

        public Criteria andAuditConfigIdNotIn(List<Integer> values) {
            addCriterion("audit_config_id not in", values, "auditConfigId");
            return (Criteria) this;
        }

        public Criteria andAuditConfigIdBetween(Integer value1, Integer value2) {
            addCriterion("audit_config_id between", value1, value2, "auditConfigId");
            return (Criteria) this;
        }

        public Criteria andAuditConfigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_config_id not between", value1, value2, "auditConfigId");
            return (Criteria) this;
        }

        public Criteria andBusiNameIsNull() {
            addCriterion("busi_name is null");
            return (Criteria) this;
        }

        public Criteria andBusiNameIsNotNull() {
            addCriterion("busi_name is not null");
            return (Criteria) this;
        }

        public Criteria andBusiNameEqualTo(String value) {
            addCriterion("busi_name =", value, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiNameNotEqualTo(String value) {
            addCriterion("busi_name <>", value, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiNameGreaterThan(String value) {
            addCriterion("busi_name >", value, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiNameGreaterThanOrEqualTo(String value) {
            addCriterion("busi_name >=", value, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiNameLessThan(String value) {
            addCriterion("busi_name <", value, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiNameLessThanOrEqualTo(String value) {
            addCriterion("busi_name <=", value, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiNameLike(String value) {
            addCriterion("busi_name like", value, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiNameNotLike(String value) {
            addCriterion("busi_name not like", value, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiNameIn(List<String> values) {
            addCriterion("busi_name in", values, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiNameNotIn(List<String> values) {
            addCriterion("busi_name not in", values, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiNameBetween(String value1, String value2) {
            addCriterion("busi_name between", value1, value2, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiNameNotBetween(String value1, String value2) {
            addCriterion("busi_name not between", value1, value2, "busiName");
            return (Criteria) this;
        }

        public Criteria andBusiIdIsNull() {
            addCriterion("busi_id is null");
            return (Criteria) this;
        }

        public Criteria andBusiIdIsNotNull() {
            addCriterion("busi_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusiIdEqualTo(Integer value) {
            addCriterion("busi_id =", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdNotEqualTo(Integer value) {
            addCriterion("busi_id <>", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdGreaterThan(Integer value) {
            addCriterion("busi_id >", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("busi_id >=", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdLessThan(Integer value) {
            addCriterion("busi_id <", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdLessThanOrEqualTo(Integer value) {
            addCriterion("busi_id <=", value, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdIn(List<Integer> values) {
            addCriterion("busi_id in", values, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdNotIn(List<Integer> values) {
            addCriterion("busi_id not in", values, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdBetween(Integer value1, Integer value2) {
            addCriterion("busi_id between", value1, value2, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("busi_id not between", value1, value2, "busiId");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIsNull() {
            addCriterion("busi_type is null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIsNotNull() {
            addCriterion("busi_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeEqualTo(Integer value) {
            addCriterion("busi_type =", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotEqualTo(Integer value) {
            addCriterion("busi_type <>", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThan(Integer value) {
            addCriterion("busi_type >", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("busi_type >=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThan(Integer value) {
            addCriterion("busi_type <", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThanOrEqualTo(Integer value) {
            addCriterion("busi_type <=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIn(List<Integer> values) {
            addCriterion("busi_type in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotIn(List<Integer> values) {
            addCriterion("busi_type not in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeBetween(Integer value1, Integer value2) {
            addCriterion("busi_type between", value1, value2, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("busi_type not between", value1, value2, "busiType");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeIsNull() {
            addCriterion("sub_busi_type is null");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeIsNotNull() {
            addCriterion("sub_busi_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeEqualTo(Integer value) {
            addCriterion("sub_busi_type =", value, "subBusiType");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeNotEqualTo(Integer value) {
            addCriterion("sub_busi_type <>", value, "subBusiType");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeGreaterThan(Integer value) {
            addCriterion("sub_busi_type >", value, "subBusiType");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_busi_type >=", value, "subBusiType");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeLessThan(Integer value) {
            addCriterion("sub_busi_type <", value, "subBusiType");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sub_busi_type <=", value, "subBusiType");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeIn(List<Integer> values) {
            addCriterion("sub_busi_type in", values, "subBusiType");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeNotIn(List<Integer> values) {
            addCriterion("sub_busi_type not in", values, "subBusiType");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeBetween(Integer value1, Integer value2) {
            addCriterion("sub_busi_type between", value1, value2, "subBusiType");
            return (Criteria) this;
        }

        public Criteria andSubBusiTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_busi_type not between", value1, value2, "subBusiType");
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

        public Criteria andBusiNameLikeInsensitive(String value) {
            addCriterion("upper(busi_name) like", value.toUpperCase(), "busiName");
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