package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExhibitionRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExhibitionRecordExample() {
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

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNull() {
            addCriterion("organizer is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNotNull() {
            addCriterion("organizer is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerEqualTo(String value) {
            addCriterion("organizer =", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotEqualTo(String value) {
            addCriterion("organizer <>", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThan(String value) {
            addCriterion("organizer >", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThanOrEqualTo(String value) {
            addCriterion("organizer >=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThan(String value) {
            addCriterion("organizer <", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThanOrEqualTo(String value) {
            addCriterion("organizer <=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLike(String value) {
            addCriterion("organizer like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotLike(String value) {
            addCriterion("organizer not like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerIn(List<String> values) {
            addCriterion("organizer in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotIn(List<String> values) {
            addCriterion("organizer not in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerBetween(String value1, String value2) {
            addCriterion("organizer between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotBetween(String value1, String value2) {
            addCriterion("organizer not between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andExhibitorIsNull() {
            addCriterion("exhibitor is null");
            return (Criteria) this;
        }

        public Criteria andExhibitorIsNotNull() {
            addCriterion("exhibitor is not null");
            return (Criteria) this;
        }

        public Criteria andExhibitorEqualTo(String value) {
            addCriterion("exhibitor =", value, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andExhibitorNotEqualTo(String value) {
            addCriterion("exhibitor <>", value, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andExhibitorGreaterThan(String value) {
            addCriterion("exhibitor >", value, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andExhibitorGreaterThanOrEqualTo(String value) {
            addCriterion("exhibitor >=", value, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andExhibitorLessThan(String value) {
            addCriterion("exhibitor <", value, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andExhibitorLessThanOrEqualTo(String value) {
            addCriterion("exhibitor <=", value, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andExhibitorLike(String value) {
            addCriterion("exhibitor like", value, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andExhibitorNotLike(String value) {
            addCriterion("exhibitor not like", value, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andExhibitorIn(List<String> values) {
            addCriterion("exhibitor in", values, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andExhibitorNotIn(List<String> values) {
            addCriterion("exhibitor not in", values, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andExhibitorBetween(String value1, String value2) {
            addCriterion("exhibitor between", value1, value2, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andExhibitorNotBetween(String value1, String value2) {
            addCriterion("exhibitor not between", value1, value2, "exhibitor");
            return (Criteria) this;
        }

        public Criteria andCoorganizerIsNull() {
            addCriterion("coorganizer is null");
            return (Criteria) this;
        }

        public Criteria andCoorganizerIsNotNull() {
            addCriterion("coorganizer is not null");
            return (Criteria) this;
        }

        public Criteria andCoorganizerEqualTo(String value) {
            addCriterion("coorganizer =", value, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andCoorganizerNotEqualTo(String value) {
            addCriterion("coorganizer <>", value, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andCoorganizerGreaterThan(String value) {
            addCriterion("coorganizer >", value, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andCoorganizerGreaterThanOrEqualTo(String value) {
            addCriterion("coorganizer >=", value, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andCoorganizerLessThan(String value) {
            addCriterion("coorganizer <", value, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andCoorganizerLessThanOrEqualTo(String value) {
            addCriterion("coorganizer <=", value, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andCoorganizerLike(String value) {
            addCriterion("coorganizer like", value, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andCoorganizerNotLike(String value) {
            addCriterion("coorganizer not like", value, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andCoorganizerIn(List<String> values) {
            addCriterion("coorganizer in", values, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andCoorganizerNotIn(List<String> values) {
            addCriterion("coorganizer not in", values, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andCoorganizerBetween(String value1, String value2) {
            addCriterion("coorganizer between", value1, value2, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andCoorganizerNotBetween(String value1, String value2) {
            addCriterion("coorganizer not between", value1, value2, "coorganizer");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeIsNull() {
            addCriterion("exhibition_type is null");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeIsNotNull() {
            addCriterion("exhibition_type is not null");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeEqualTo(String value) {
            addCriterion("exhibition_type =", value, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeNotEqualTo(String value) {
            addCriterion("exhibition_type <>", value, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeGreaterThan(String value) {
            addCriterion("exhibition_type >", value, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("exhibition_type >=", value, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeLessThan(String value) {
            addCriterion("exhibition_type <", value, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeLessThanOrEqualTo(String value) {
            addCriterion("exhibition_type <=", value, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeLike(String value) {
            addCriterion("exhibition_type like", value, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeNotLike(String value) {
            addCriterion("exhibition_type not like", value, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeIn(List<String> values) {
            addCriterion("exhibition_type in", values, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeNotIn(List<String> values) {
            addCriterion("exhibition_type not in", values, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeBetween(String value1, String value2) {
            addCriterion("exhibition_type between", value1, value2, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeNotBetween(String value1, String value2) {
            addCriterion("exhibition_type not between", value1, value2, "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andChargeIsNull() {
            addCriterion("charge is null");
            return (Criteria) this;
        }

        public Criteria andChargeIsNotNull() {
            addCriterion("charge is not null");
            return (Criteria) this;
        }

        public Criteria andChargeEqualTo(String value) {
            addCriterion("charge =", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotEqualTo(String value) {
            addCriterion("charge <>", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThan(String value) {
            addCriterion("charge >", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThanOrEqualTo(String value) {
            addCriterion("charge >=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThan(String value) {
            addCriterion("charge <", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThanOrEqualTo(String value) {
            addCriterion("charge <=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLike(String value) {
            addCriterion("charge like", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotLike(String value) {
            addCriterion("charge not like", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeIn(List<String> values) {
            addCriterion("charge in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotIn(List<String> values) {
            addCriterion("charge not in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeBetween(String value1, String value2) {
            addCriterion("charge between", value1, value2, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotBetween(String value1, String value2) {
            addCriterion("charge not between", value1, value2, "charge");
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

        public Criteria andContactMobileIsNull() {
            addCriterion("contact_mobile is null");
            return (Criteria) this;
        }

        public Criteria andContactMobileIsNotNull() {
            addCriterion("contact_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andContactMobileEqualTo(String value) {
            addCriterion("contact_mobile =", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotEqualTo(String value) {
            addCriterion("contact_mobile <>", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThan(String value) {
            addCriterion("contact_mobile >", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThanOrEqualTo(String value) {
            addCriterion("contact_mobile >=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThan(String value) {
            addCriterion("contact_mobile <", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThanOrEqualTo(String value) {
            addCriterion("contact_mobile <=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLike(String value) {
            addCriterion("contact_mobile like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotLike(String value) {
            addCriterion("contact_mobile not like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileIn(List<String> values) {
            addCriterion("contact_mobile in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotIn(List<String> values) {
            addCriterion("contact_mobile not in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileBetween(String value1, String value2) {
            addCriterion("contact_mobile between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotBetween(String value1, String value2) {
            addCriterion("contact_mobile not between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andStandsIsNull() {
            addCriterion("stands is null");
            return (Criteria) this;
        }

        public Criteria andStandsIsNotNull() {
            addCriterion("stands is not null");
            return (Criteria) this;
        }

        public Criteria andStandsEqualTo(Integer value) {
            addCriterion("stands =", value, "stands");
            return (Criteria) this;
        }

        public Criteria andStandsNotEqualTo(Integer value) {
            addCriterion("stands <>", value, "stands");
            return (Criteria) this;
        }

        public Criteria andStandsGreaterThan(Integer value) {
            addCriterion("stands >", value, "stands");
            return (Criteria) this;
        }

        public Criteria andStandsGreaterThanOrEqualTo(Integer value) {
            addCriterion("stands >=", value, "stands");
            return (Criteria) this;
        }

        public Criteria andStandsLessThan(Integer value) {
            addCriterion("stands <", value, "stands");
            return (Criteria) this;
        }

        public Criteria andStandsLessThanOrEqualTo(Integer value) {
            addCriterion("stands <=", value, "stands");
            return (Criteria) this;
        }

        public Criteria andStandsIn(List<Integer> values) {
            addCriterion("stands in", values, "stands");
            return (Criteria) this;
        }

        public Criteria andStandsNotIn(List<Integer> values) {
            addCriterion("stands not in", values, "stands");
            return (Criteria) this;
        }

        public Criteria andStandsBetween(Integer value1, Integer value2) {
            addCriterion("stands between", value1, value2, "stands");
            return (Criteria) this;
        }

        public Criteria andStandsNotBetween(Integer value1, Integer value2) {
            addCriterion("stands not between", value1, value2, "stands");
            return (Criteria) this;
        }

        public Criteria andStandAreaIsNull() {
            addCriterion("stand_area is null");
            return (Criteria) this;
        }

        public Criteria andStandAreaIsNotNull() {
            addCriterion("stand_area is not null");
            return (Criteria) this;
        }

        public Criteria andStandAreaEqualTo(BigDecimal value) {
            addCriterion("stand_area =", value, "standArea");
            return (Criteria) this;
        }

        public Criteria andStandAreaNotEqualTo(BigDecimal value) {
            addCriterion("stand_area <>", value, "standArea");
            return (Criteria) this;
        }

        public Criteria andStandAreaGreaterThan(BigDecimal value) {
            addCriterion("stand_area >", value, "standArea");
            return (Criteria) this;
        }

        public Criteria andStandAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stand_area >=", value, "standArea");
            return (Criteria) this;
        }

        public Criteria andStandAreaLessThan(BigDecimal value) {
            addCriterion("stand_area <", value, "standArea");
            return (Criteria) this;
        }

        public Criteria andStandAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stand_area <=", value, "standArea");
            return (Criteria) this;
        }

        public Criteria andStandAreaIn(List<BigDecimal> values) {
            addCriterion("stand_area in", values, "standArea");
            return (Criteria) this;
        }

        public Criteria andStandAreaNotIn(List<BigDecimal> values) {
            addCriterion("stand_area not in", values, "standArea");
            return (Criteria) this;
        }

        public Criteria andStandAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stand_area between", value1, value2, "standArea");
            return (Criteria) this;
        }

        public Criteria andStandAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stand_area not between", value1, value2, "standArea");
            return (Criteria) this;
        }

        public Criteria andNumbersIsNull() {
            addCriterion("numbers is null");
            return (Criteria) this;
        }

        public Criteria andNumbersIsNotNull() {
            addCriterion("numbers is not null");
            return (Criteria) this;
        }

        public Criteria andNumbersEqualTo(Integer value) {
            addCriterion("numbers =", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersNotEqualTo(Integer value) {
            addCriterion("numbers <>", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersGreaterThan(Integer value) {
            addCriterion("numbers >", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersGreaterThanOrEqualTo(Integer value) {
            addCriterion("numbers >=", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersLessThan(Integer value) {
            addCriterion("numbers <", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersLessThanOrEqualTo(Integer value) {
            addCriterion("numbers <=", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersIn(List<Integer> values) {
            addCriterion("numbers in", values, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersNotIn(List<Integer> values) {
            addCriterion("numbers not in", values, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersBetween(Integer value1, Integer value2) {
            addCriterion("numbers between", value1, value2, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersNotBetween(Integer value1, Integer value2) {
            addCriterion("numbers not between", value1, value2, "numbers");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("apply_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("apply_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("apply_time =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("apply_time <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("apply_time >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_time >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("apply_time <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_time <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("apply_time in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("apply_time not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("apply_time between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_time not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionIsNull() {
            addCriterion("record_opinion is null");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionIsNotNull() {
            addCriterion("record_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionEqualTo(String value) {
            addCriterion("record_opinion =", value, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionNotEqualTo(String value) {
            addCriterion("record_opinion <>", value, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionGreaterThan(String value) {
            addCriterion("record_opinion >", value, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("record_opinion >=", value, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionLessThan(String value) {
            addCriterion("record_opinion <", value, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionLessThanOrEqualTo(String value) {
            addCriterion("record_opinion <=", value, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionLike(String value) {
            addCriterion("record_opinion like", value, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionNotLike(String value) {
            addCriterion("record_opinion not like", value, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionIn(List<String> values) {
            addCriterion("record_opinion in", values, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionNotIn(List<String> values) {
            addCriterion("record_opinion not in", values, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionBetween(String value1, String value2) {
            addCriterion("record_opinion between", value1, value2, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionNotBetween(String value1, String value2) {
            addCriterion("record_opinion not between", value1, value2, "recordOpinion");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Date value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Date value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Date value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Date value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Date value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Date> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Date> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Date value1, Date value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Date value1, Date value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
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

        public Criteria andExhibitionNameLikeInsensitive(String value) {
            addCriterion("upper(exhibition_name) like", value.toUpperCase(), "exhibitionName");
            return (Criteria) this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return (Criteria) this;
        }

        public Criteria andOrganizerLikeInsensitive(String value) {
            addCriterion("upper(organizer) like", value.toUpperCase(), "organizer");
            return (Criteria) this;
        }

        public Criteria andExhibitorLikeInsensitive(String value) {
            addCriterion("upper(exhibitor) like", value.toUpperCase(), "exhibitor");
            return (Criteria) this;
        }

        public Criteria andCoorganizerLikeInsensitive(String value) {
            addCriterion("upper(coorganizer) like", value.toUpperCase(), "coorganizer");
            return (Criteria) this;
        }

        public Criteria andExhibitionTypeLikeInsensitive(String value) {
            addCriterion("upper(exhibition_type) like", value.toUpperCase(), "exhibitionType");
            return (Criteria) this;
        }

        public Criteria andIntroductionLikeInsensitive(String value) {
            addCriterion("upper(introduction) like", value.toUpperCase(), "introduction");
            return (Criteria) this;
        }

        public Criteria andChargeLikeInsensitive(String value) {
            addCriterion("upper(charge) like", value.toUpperCase(), "charge");
            return (Criteria) this;
        }

        public Criteria andChargeMobileLikeInsensitive(String value) {
            addCriterion("upper(charge_mobile) like", value.toUpperCase(), "chargeMobile");
            return (Criteria) this;
        }

        public Criteria andContactLikeInsensitive(String value) {
            addCriterion("upper(contact) like", value.toUpperCase(), "contact");
            return (Criteria) this;
        }

        public Criteria andContactMobileLikeInsensitive(String value) {
            addCriterion("upper(contact_mobile) like", value.toUpperCase(), "contactMobile");
            return (Criteria) this;
        }

        public Criteria andApplicantLikeInsensitive(String value) {
            addCriterion("upper(applicant) like", value.toUpperCase(), "applicant");
            return (Criteria) this;
        }

        public Criteria andRecordOpinionLikeInsensitive(String value) {
            addCriterion("upper(record_opinion) like", value.toUpperCase(), "recordOpinion");
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