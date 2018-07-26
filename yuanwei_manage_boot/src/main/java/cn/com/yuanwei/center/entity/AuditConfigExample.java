package cn.com.yuanwei.center.entity;

import java.util.ArrayList;
import java.util.List;

public class AuditConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuditConfigExample() {
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

        public Criteria andUserId1IsNull() {
            addCriterion("user_id1 is null");
            return (Criteria) this;
        }

        public Criteria andUserId1IsNotNull() {
            addCriterion("user_id1 is not null");
            return (Criteria) this;
        }

        public Criteria andUserId1EqualTo(Integer value) {
            addCriterion("user_id1 =", value, "userId1");
            return (Criteria) this;
        }

        public Criteria andUserId1NotEqualTo(Integer value) {
            addCriterion("user_id1 <>", value, "userId1");
            return (Criteria) this;
        }

        public Criteria andUserId1GreaterThan(Integer value) {
            addCriterion("user_id1 >", value, "userId1");
            return (Criteria) this;
        }

        public Criteria andUserId1GreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id1 >=", value, "userId1");
            return (Criteria) this;
        }

        public Criteria andUserId1LessThan(Integer value) {
            addCriterion("user_id1 <", value, "userId1");
            return (Criteria) this;
        }

        public Criteria andUserId1LessThanOrEqualTo(Integer value) {
            addCriterion("user_id1 <=", value, "userId1");
            return (Criteria) this;
        }

        public Criteria andUserId1In(List<Integer> values) {
            addCriterion("user_id1 in", values, "userId1");
            return (Criteria) this;
        }

        public Criteria andUserId1NotIn(List<Integer> values) {
            addCriterion("user_id1 not in", values, "userId1");
            return (Criteria) this;
        }

        public Criteria andUserId1Between(Integer value1, Integer value2) {
            addCriterion("user_id1 between", value1, value2, "userId1");
            return (Criteria) this;
        }

        public Criteria andUserId1NotBetween(Integer value1, Integer value2) {
            addCriterion("user_id1 not between", value1, value2, "userId1");
            return (Criteria) this;
        }

        public Criteria andUserId2IsNull() {
            addCriterion("user_id2 is null");
            return (Criteria) this;
        }

        public Criteria andUserId2IsNotNull() {
            addCriterion("user_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andUserId2EqualTo(Integer value) {
            addCriterion("user_id2 =", value, "userId2");
            return (Criteria) this;
        }

        public Criteria andUserId2NotEqualTo(Integer value) {
            addCriterion("user_id2 <>", value, "userId2");
            return (Criteria) this;
        }

        public Criteria andUserId2GreaterThan(Integer value) {
            addCriterion("user_id2 >", value, "userId2");
            return (Criteria) this;
        }

        public Criteria andUserId2GreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id2 >=", value, "userId2");
            return (Criteria) this;
        }

        public Criteria andUserId2LessThan(Integer value) {
            addCriterion("user_id2 <", value, "userId2");
            return (Criteria) this;
        }

        public Criteria andUserId2LessThanOrEqualTo(Integer value) {
            addCriterion("user_id2 <=", value, "userId2");
            return (Criteria) this;
        }

        public Criteria andUserId2In(List<Integer> values) {
            addCriterion("user_id2 in", values, "userId2");
            return (Criteria) this;
        }

        public Criteria andUserId2NotIn(List<Integer> values) {
            addCriterion("user_id2 not in", values, "userId2");
            return (Criteria) this;
        }

        public Criteria andUserId2Between(Integer value1, Integer value2) {
            addCriterion("user_id2 between", value1, value2, "userId2");
            return (Criteria) this;
        }

        public Criteria andUserId2NotBetween(Integer value1, Integer value2) {
            addCriterion("user_id2 not between", value1, value2, "userId2");
            return (Criteria) this;
        }

        public Criteria andUserId3IsNull() {
            addCriterion("user_id3 is null");
            return (Criteria) this;
        }

        public Criteria andUserId3IsNotNull() {
            addCriterion("user_id3 is not null");
            return (Criteria) this;
        }

        public Criteria andUserId3EqualTo(Integer value) {
            addCriterion("user_id3 =", value, "userId3");
            return (Criteria) this;
        }

        public Criteria andUserId3NotEqualTo(Integer value) {
            addCriterion("user_id3 <>", value, "userId3");
            return (Criteria) this;
        }

        public Criteria andUserId3GreaterThan(Integer value) {
            addCriterion("user_id3 >", value, "userId3");
            return (Criteria) this;
        }

        public Criteria andUserId3GreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id3 >=", value, "userId3");
            return (Criteria) this;
        }

        public Criteria andUserId3LessThan(Integer value) {
            addCriterion("user_id3 <", value, "userId3");
            return (Criteria) this;
        }

        public Criteria andUserId3LessThanOrEqualTo(Integer value) {
            addCriterion("user_id3 <=", value, "userId3");
            return (Criteria) this;
        }

        public Criteria andUserId3In(List<Integer> values) {
            addCriterion("user_id3 in", values, "userId3");
            return (Criteria) this;
        }

        public Criteria andUserId3NotIn(List<Integer> values) {
            addCriterion("user_id3 not in", values, "userId3");
            return (Criteria) this;
        }

        public Criteria andUserId3Between(Integer value1, Integer value2) {
            addCriterion("user_id3 between", value1, value2, "userId3");
            return (Criteria) this;
        }

        public Criteria andUserId3NotBetween(Integer value1, Integer value2) {
            addCriterion("user_id3 not between", value1, value2, "userId3");
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