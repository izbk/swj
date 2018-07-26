package cn.com.yuanwei.center.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExhibitionRegisterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExhibitionRegisterExample() {
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

        public Criteria andExhibitionIdIsNull() {
            addCriterion("exhibition_id is null");
            return (Criteria) this;
        }

        public Criteria andExhibitionIdIsNotNull() {
            addCriterion("exhibition_id is not null");
            return (Criteria) this;
        }

        public Criteria andExhibitionIdEqualTo(Integer value) {
            addCriterion("exhibition_id =", value, "exhibitionId");
            return (Criteria) this;
        }

        public Criteria andExhibitionIdNotEqualTo(Integer value) {
            addCriterion("exhibition_id <>", value, "exhibitionId");
            return (Criteria) this;
        }

        public Criteria andExhibitionIdGreaterThan(Integer value) {
            addCriterion("exhibition_id >", value, "exhibitionId");
            return (Criteria) this;
        }

        public Criteria andExhibitionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("exhibition_id >=", value, "exhibitionId");
            return (Criteria) this;
        }

        public Criteria andExhibitionIdLessThan(Integer value) {
            addCriterion("exhibition_id <", value, "exhibitionId");
            return (Criteria) this;
        }

        public Criteria andExhibitionIdLessThanOrEqualTo(Integer value) {
            addCriterion("exhibition_id <=", value, "exhibitionId");
            return (Criteria) this;
        }

        public Criteria andExhibitionIdIn(List<Integer> values) {
            addCriterion("exhibition_id in", values, "exhibitionId");
            return (Criteria) this;
        }

        public Criteria andExhibitionIdNotIn(List<Integer> values) {
            addCriterion("exhibition_id not in", values, "exhibitionId");
            return (Criteria) this;
        }

        public Criteria andExhibitionIdBetween(Integer value1, Integer value2) {
            addCriterion("exhibition_id between", value1, value2, "exhibitionId");
            return (Criteria) this;
        }

        public Criteria andExhibitionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("exhibition_id not between", value1, value2, "exhibitionId");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameIsNull() {
            addCriterion("exhibition_name is null");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameIsNotNull() {
            addCriterion("exhibition_name is not null");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameEqualTo(String value) {
            addCriterion("exhibition_name =", value, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameNotEqualTo(String value) {
            addCriterion("exhibition_name <>", value, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameGreaterThan(String value) {
            addCriterion("exhibition_name >", value, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameGreaterThanOrEqualTo(String value) {
            addCriterion("exhibition_name >=", value, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameLessThan(String value) {
            addCriterion("exhibition_name <", value, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameLessThanOrEqualTo(String value) {
            addCriterion("exhibition_name <=", value, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameLike(String value) {
            addCriterion("exhibition_name like", value, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameNotLike(String value) {
            addCriterion("exhibition_name not like", value, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameIn(List<String> values) {
            addCriterion("exhibition_name in", values, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameNotIn(List<String> values) {
            addCriterion("exhibition_name not in", values, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameBetween(String value1, String value2) {
            addCriterion("exhibition_name between", value1, value2, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameNotBetween(String value1, String value2) {
            addCriterion("exhibition_name not between", value1, value2, "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameIsNull() {
            addCriterion("enterpise_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameIsNotNull() {
            addCriterion("enterpise_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameEqualTo(String value) {
            addCriterion("enterpise_name =", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameNotEqualTo(String value) {
            addCriterion("enterpise_name <>", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameGreaterThan(String value) {
            addCriterion("enterpise_name >", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterpise_name >=", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameLessThan(String value) {
            addCriterion("enterpise_name <", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameLessThanOrEqualTo(String value) {
            addCriterion("enterpise_name <=", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameLike(String value) {
            addCriterion("enterpise_name like", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameNotLike(String value) {
            addCriterion("enterpise_name not like", value, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameIn(List<String> values) {
            addCriterion("enterpise_name in", values, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameNotIn(List<String> values) {
            addCriterion("enterpise_name not in", values, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameBetween(String value1, String value2) {
            addCriterion("enterpise_name between", value1, value2, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameNotBetween(String value1, String value2) {
            addCriterion("enterpise_name not between", value1, value2, "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("linkman is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkman is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("linkman =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("linkman <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("linkman >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("linkman >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("linkman <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("linkman <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("linkman like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("linkman not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("linkman in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("linkman not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("linkman between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("linkman not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andParticipantNumIsNull() {
            addCriterion("participant_num is null");
            return (Criteria) this;
        }

        public Criteria andParticipantNumIsNotNull() {
            addCriterion("participant_num is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantNumEqualTo(Integer value) {
            addCriterion("participant_num =", value, "participantNum");
            return (Criteria) this;
        }

        public Criteria andParticipantNumNotEqualTo(Integer value) {
            addCriterion("participant_num <>", value, "participantNum");
            return (Criteria) this;
        }

        public Criteria andParticipantNumGreaterThan(Integer value) {
            addCriterion("participant_num >", value, "participantNum");
            return (Criteria) this;
        }

        public Criteria andParticipantNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("participant_num >=", value, "participantNum");
            return (Criteria) this;
        }

        public Criteria andParticipantNumLessThan(Integer value) {
            addCriterion("participant_num <", value, "participantNum");
            return (Criteria) this;
        }

        public Criteria andParticipantNumLessThanOrEqualTo(Integer value) {
            addCriterion("participant_num <=", value, "participantNum");
            return (Criteria) this;
        }

        public Criteria andParticipantNumIn(List<Integer> values) {
            addCriterion("participant_num in", values, "participantNum");
            return (Criteria) this;
        }

        public Criteria andParticipantNumNotIn(List<Integer> values) {
            addCriterion("participant_num not in", values, "participantNum");
            return (Criteria) this;
        }

        public Criteria andParticipantNumBetween(Integer value1, Integer value2) {
            addCriterion("participant_num between", value1, value2, "participantNum");
            return (Criteria) this;
        }

        public Criteria andParticipantNumNotBetween(Integer value1, Integer value2) {
            addCriterion("participant_num not between", value1, value2, "participantNum");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeIsNull() {
            addCriterion("exhi_product_type is null");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeIsNotNull() {
            addCriterion("exhi_product_type is not null");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeEqualTo(Integer value) {
            addCriterion("exhi_product_type =", value, "exhiProductType");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeNotEqualTo(Integer value) {
            addCriterion("exhi_product_type <>", value, "exhiProductType");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeGreaterThan(Integer value) {
            addCriterion("exhi_product_type >", value, "exhiProductType");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("exhi_product_type >=", value, "exhiProductType");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeLessThan(Integer value) {
            addCriterion("exhi_product_type <", value, "exhiProductType");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeLessThanOrEqualTo(Integer value) {
            addCriterion("exhi_product_type <=", value, "exhiProductType");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeIn(List<Integer> values) {
            addCriterion("exhi_product_type in", values, "exhiProductType");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeNotIn(List<Integer> values) {
            addCriterion("exhi_product_type not in", values, "exhiProductType");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeBetween(Integer value1, Integer value2) {
            addCriterion("exhi_product_type between", value1, value2, "exhiProductType");
            return (Criteria) this;
        }

        public Criteria andExhiProductTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("exhi_product_type not between", value1, value2, "exhiProductType");
            return (Criteria) this;
        }

        public Criteria andBoothNumIsNull() {
            addCriterion("booth_num is null");
            return (Criteria) this;
        }

        public Criteria andBoothNumIsNotNull() {
            addCriterion("booth_num is not null");
            return (Criteria) this;
        }

        public Criteria andBoothNumEqualTo(Integer value) {
            addCriterion("booth_num =", value, "boothNum");
            return (Criteria) this;
        }

        public Criteria andBoothNumNotEqualTo(Integer value) {
            addCriterion("booth_num <>", value, "boothNum");
            return (Criteria) this;
        }

        public Criteria andBoothNumGreaterThan(Integer value) {
            addCriterion("booth_num >", value, "boothNum");
            return (Criteria) this;
        }

        public Criteria andBoothNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("booth_num >=", value, "boothNum");
            return (Criteria) this;
        }

        public Criteria andBoothNumLessThan(Integer value) {
            addCriterion("booth_num <", value, "boothNum");
            return (Criteria) this;
        }

        public Criteria andBoothNumLessThanOrEqualTo(Integer value) {
            addCriterion("booth_num <=", value, "boothNum");
            return (Criteria) this;
        }

        public Criteria andBoothNumIn(List<Integer> values) {
            addCriterion("booth_num in", values, "boothNum");
            return (Criteria) this;
        }

        public Criteria andBoothNumNotIn(List<Integer> values) {
            addCriterion("booth_num not in", values, "boothNum");
            return (Criteria) this;
        }

        public Criteria andBoothNumBetween(Integer value1, Integer value2) {
            addCriterion("booth_num between", value1, value2, "boothNum");
            return (Criteria) this;
        }

        public Criteria andBoothNumNotBetween(Integer value1, Integer value2) {
            addCriterion("booth_num not between", value1, value2, "boothNum");
            return (Criteria) this;
        }

        public Criteria andHonorIsNull() {
            addCriterion("honor is null");
            return (Criteria) this;
        }

        public Criteria andHonorIsNotNull() {
            addCriterion("honor is not null");
            return (Criteria) this;
        }

        public Criteria andHonorEqualTo(String value) {
            addCriterion("honor =", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorNotEqualTo(String value) {
            addCriterion("honor <>", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorGreaterThan(String value) {
            addCriterion("honor >", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorGreaterThanOrEqualTo(String value) {
            addCriterion("honor >=", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorLessThan(String value) {
            addCriterion("honor <", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorLessThanOrEqualTo(String value) {
            addCriterion("honor <=", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorLike(String value) {
            addCriterion("honor like", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorNotLike(String value) {
            addCriterion("honor not like", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorIn(List<String> values) {
            addCriterion("honor in", values, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorNotIn(List<String> values) {
            addCriterion("honor not in", values, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorBetween(String value1, String value2) {
            addCriterion("honor between", value1, value2, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorNotBetween(String value1, String value2) {
            addCriterion("honor not between", value1, value2, "honor");
            return (Criteria) this;
        }

        public Criteria andEnterDateIsNull() {
            addCriterion("enter_date is null");
            return (Criteria) this;
        }

        public Criteria andEnterDateIsNotNull() {
            addCriterion("enter_date is not null");
            return (Criteria) this;
        }

        public Criteria andEnterDateEqualTo(Date value) {
            addCriterionForJDBCDate("enter_date =", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("enter_date <>", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateGreaterThan(Date value) {
            addCriterionForJDBCDate("enter_date >", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enter_date >=", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateLessThan(Date value) {
            addCriterionForJDBCDate("enter_date <", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enter_date <=", value, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateIn(List<Date> values) {
            addCriterionForJDBCDate("enter_date in", values, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("enter_date not in", values, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enter_date between", value1, value2, "enterDate");
            return (Criteria) this;
        }

        public Criteria andEnterDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enter_date not between", value1, value2, "enterDate");
            return (Criteria) this;
        }

        public Criteria andFeedbackIsNull() {
            addCriterion("feedback is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIsNotNull() {
            addCriterion("feedback is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackEqualTo(String value) {
            addCriterion("feedback =", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotEqualTo(String value) {
            addCriterion("feedback <>", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThan(String value) {
            addCriterion("feedback >", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThanOrEqualTo(String value) {
            addCriterion("feedback >=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThan(String value) {
            addCriterion("feedback <", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThanOrEqualTo(String value) {
            addCriterion("feedback <=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLike(String value) {
            addCriterion("feedback like", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotLike(String value) {
            addCriterion("feedback not like", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackIn(List<String> values) {
            addCriterion("feedback in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotIn(List<String> values) {
            addCriterion("feedback not in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackBetween(String value1, String value2) {
            addCriterion("feedback between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotBetween(String value1, String value2) {
            addCriterion("feedback not between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNull() {
            addCriterion("reg_time is null");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNotNull() {
            addCriterion("reg_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegTimeEqualTo(Date value) {
            addCriterion("reg_time =", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotEqualTo(Date value) {
            addCriterion("reg_time <>", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThan(Date value) {
            addCriterion("reg_time >", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reg_time >=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThan(Date value) {
            addCriterion("reg_time <", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThanOrEqualTo(Date value) {
            addCriterion("reg_time <=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeIn(List<Date> values) {
            addCriterion("reg_time in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotIn(List<Date> values) {
            addCriterion("reg_time not in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeBetween(Date value1, Date value2) {
            addCriterion("reg_time between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotBetween(Date value1, Date value2) {
            addCriterion("reg_time not between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeIsNull() {
            addCriterion("feed_time is null");
            return (Criteria) this;
        }

        public Criteria andFeedTimeIsNotNull() {
            addCriterion("feed_time is not null");
            return (Criteria) this;
        }

        public Criteria andFeedTimeEqualTo(Date value) {
            addCriterion("feed_time =", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeNotEqualTo(Date value) {
            addCriterion("feed_time <>", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeGreaterThan(Date value) {
            addCriterion("feed_time >", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("feed_time >=", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeLessThan(Date value) {
            addCriterion("feed_time <", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeLessThanOrEqualTo(Date value) {
            addCriterion("feed_time <=", value, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeIn(List<Date> values) {
            addCriterion("feed_time in", values, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeNotIn(List<Date> values) {
            addCriterion("feed_time not in", values, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeBetween(Date value1, Date value2) {
            addCriterion("feed_time between", value1, value2, "feedTime");
            return (Criteria) this;
        }

        public Criteria andFeedTimeNotBetween(Date value1, Date value2) {
            addCriterion("feed_time not between", value1, value2, "feedTime");
            return (Criteria) this;
        }

        public Criteria andExhibitionNameLikeInsensitive(String value) {
            addCriterion("upper(exhibition_name) like", value.toUpperCase(), "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andEnterpiseNameLikeInsensitive(String value) {
            addCriterion("upper(enterpise_name) like", value.toUpperCase(), "enterpiseName");
            return (Criteria) this;
        }

        public Criteria andLinkmanLikeInsensitive(String value) {
            addCriterion("upper(linkman) like", value.toUpperCase(), "linkman");
            return (Criteria) this;
        }

        public Criteria andContactLikeInsensitive(String value) {
            addCriterion("upper(contact) like", value.toUpperCase(), "contact");
            return (Criteria) this;
        }

        public Criteria andHonorLikeInsensitive(String value) {
            addCriterion("upper(honor) like", value.toUpperCase(), "honor");
            return (Criteria) this;
        }

        public Criteria andFeedbackLikeInsensitive(String value) {
            addCriterion("upper(feedback) like", value.toUpperCase(), "feedback");
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