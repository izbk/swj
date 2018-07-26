package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IncubationParkAssessmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IncubationParkAssessmentExample() {
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

        public Criteria andIpcompanyIdIsNull() {
            addCriterion("ipcompany_id is null");
            return (Criteria) this;
        }

        public Criteria andIpcompanyIdIsNotNull() {
            addCriterion("ipcompany_id is not null");
            return (Criteria) this;
        }

        public Criteria andIpcompanyIdEqualTo(Integer value) {
            addCriterion("ipcompany_id =", value, "ipcompanyId");
            return (Criteria) this;
        }

        public Criteria andIpcompanyIdNotEqualTo(Integer value) {
            addCriterion("ipcompany_id <>", value, "ipcompanyId");
            return (Criteria) this;
        }

        public Criteria andIpcompanyIdGreaterThan(Integer value) {
            addCriterion("ipcompany_id >", value, "ipcompanyId");
            return (Criteria) this;
        }

        public Criteria andIpcompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ipcompany_id >=", value, "ipcompanyId");
            return (Criteria) this;
        }

        public Criteria andIpcompanyIdLessThan(Integer value) {
            addCriterion("ipcompany_id <", value, "ipcompanyId");
            return (Criteria) this;
        }

        public Criteria andIpcompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("ipcompany_id <=", value, "ipcompanyId");
            return (Criteria) this;
        }

        public Criteria andIpcompanyIdIn(List<Integer> values) {
            addCriterion("ipcompany_id in", values, "ipcompanyId");
            return (Criteria) this;
        }

        public Criteria andIpcompanyIdNotIn(List<Integer> values) {
            addCriterion("ipcompany_id not in", values, "ipcompanyId");
            return (Criteria) this;
        }

        public Criteria andIpcompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("ipcompany_id between", value1, value2, "ipcompanyId");
            return (Criteria) this;
        }

        public Criteria andIpcompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ipcompany_id not between", value1, value2, "ipcompanyId");
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

        public Criteria andAssessDateIsNull() {
            addCriterion("assess_date is null");
            return (Criteria) this;
        }

        public Criteria andAssessDateIsNotNull() {
            addCriterion("assess_date is not null");
            return (Criteria) this;
        }

        public Criteria andAssessDateEqualTo(Date value) {
            addCriterionForJDBCDate("assess_date =", value, "assessDate");
            return (Criteria) this;
        }

        public Criteria andAssessDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("assess_date <>", value, "assessDate");
            return (Criteria) this;
        }

        public Criteria andAssessDateGreaterThan(Date value) {
            addCriterionForJDBCDate("assess_date >", value, "assessDate");
            return (Criteria) this;
        }

        public Criteria andAssessDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("assess_date >=", value, "assessDate");
            return (Criteria) this;
        }

        public Criteria andAssessDateLessThan(Date value) {
            addCriterionForJDBCDate("assess_date <", value, "assessDate");
            return (Criteria) this;
        }

        public Criteria andAssessDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("assess_date <=", value, "assessDate");
            return (Criteria) this;
        }

        public Criteria andAssessDateIn(List<Date> values) {
            addCriterionForJDBCDate("assess_date in", values, "assessDate");
            return (Criteria) this;
        }

        public Criteria andAssessDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("assess_date not in", values, "assessDate");
            return (Criteria) this;
        }

        public Criteria andAssessDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("assess_date between", value1, value2, "assessDate");
            return (Criteria) this;
        }

        public Criteria andAssessDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("assess_date not between", value1, value2, "assessDate");
            return (Criteria) this;
        }

        public Criteria andYcqtsIsNull() {
            addCriterion("ycqts is null");
            return (Criteria) this;
        }

        public Criteria andYcqtsIsNotNull() {
            addCriterion("ycqts is not null");
            return (Criteria) this;
        }

        public Criteria andYcqtsEqualTo(BigDecimal value) {
            addCriterion("ycqts =", value, "ycqts");
            return (Criteria) this;
        }

        public Criteria andYcqtsNotEqualTo(BigDecimal value) {
            addCriterion("ycqts <>", value, "ycqts");
            return (Criteria) this;
        }

        public Criteria andYcqtsGreaterThan(BigDecimal value) {
            addCriterion("ycqts >", value, "ycqts");
            return (Criteria) this;
        }

        public Criteria andYcqtsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ycqts >=", value, "ycqts");
            return (Criteria) this;
        }

        public Criteria andYcqtsLessThan(BigDecimal value) {
            addCriterion("ycqts <", value, "ycqts");
            return (Criteria) this;
        }

        public Criteria andYcqtsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ycqts <=", value, "ycqts");
            return (Criteria) this;
        }

        public Criteria andYcqtsIn(List<BigDecimal> values) {
            addCriterion("ycqts in", values, "ycqts");
            return (Criteria) this;
        }

        public Criteria andYcqtsNotIn(List<BigDecimal> values) {
            addCriterion("ycqts not in", values, "ycqts");
            return (Criteria) this;
        }

        public Criteria andYcqtsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ycqts between", value1, value2, "ycqts");
            return (Criteria) this;
        }

        public Criteria andYcqtsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ycqts not between", value1, value2, "ycqts");
            return (Criteria) this;
        }

        public Criteria andAttendanceIsNull() {
            addCriterion("attendance is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceIsNotNull() {
            addCriterion("attendance is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceEqualTo(String value) {
            addCriterion("attendance =", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotEqualTo(String value) {
            addCriterion("attendance <>", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceGreaterThan(String value) {
            addCriterion("attendance >", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceGreaterThanOrEqualTo(String value) {
            addCriterion("attendance >=", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceLessThan(String value) {
            addCriterion("attendance <", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceLessThanOrEqualTo(String value) {
            addCriterion("attendance <=", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceLike(String value) {
            addCriterion("attendance like", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotLike(String value) {
            addCriterion("attendance not like", value, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceIn(List<String> values) {
            addCriterion("attendance in", values, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotIn(List<String> values) {
            addCriterion("attendance not in", values, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceBetween(String value1, String value2) {
            addCriterion("attendance between", value1, value2, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendanceNotBetween(String value1, String value2) {
            addCriterion("attendance not between", value1, value2, "attendance");
            return (Criteria) this;
        }

        public Criteria andAttendPointIsNull() {
            addCriterion("attend_point is null");
            return (Criteria) this;
        }

        public Criteria andAttendPointIsNotNull() {
            addCriterion("attend_point is not null");
            return (Criteria) this;
        }

        public Criteria andAttendPointEqualTo(Integer value) {
            addCriterion("attend_point =", value, "attendPoint");
            return (Criteria) this;
        }

        public Criteria andAttendPointNotEqualTo(Integer value) {
            addCriterion("attend_point <>", value, "attendPoint");
            return (Criteria) this;
        }

        public Criteria andAttendPointGreaterThan(Integer value) {
            addCriterion("attend_point >", value, "attendPoint");
            return (Criteria) this;
        }

        public Criteria andAttendPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_point >=", value, "attendPoint");
            return (Criteria) this;
        }

        public Criteria andAttendPointLessThan(Integer value) {
            addCriterion("attend_point <", value, "attendPoint");
            return (Criteria) this;
        }

        public Criteria andAttendPointLessThanOrEqualTo(Integer value) {
            addCriterion("attend_point <=", value, "attendPoint");
            return (Criteria) this;
        }

        public Criteria andAttendPointIn(List<Integer> values) {
            addCriterion("attend_point in", values, "attendPoint");
            return (Criteria) this;
        }

        public Criteria andAttendPointNotIn(List<Integer> values) {
            addCriterion("attend_point not in", values, "attendPoint");
            return (Criteria) this;
        }

        public Criteria andAttendPointBetween(Integer value1, Integer value2) {
            addCriterion("attend_point between", value1, value2, "attendPoint");
            return (Criteria) this;
        }

        public Criteria andAttendPointNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_point not between", value1, value2, "attendPoint");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumIsNull() {
            addCriterion("avg_team_num is null");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumIsNotNull() {
            addCriterion("avg_team_num is not null");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumEqualTo(BigDecimal value) {
            addCriterion("avg_team_num =", value, "avgTeamNum");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumNotEqualTo(BigDecimal value) {
            addCriterion("avg_team_num <>", value, "avgTeamNum");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumGreaterThan(BigDecimal value) {
            addCriterion("avg_team_num >", value, "avgTeamNum");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("avg_team_num >=", value, "avgTeamNum");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumLessThan(BigDecimal value) {
            addCriterion("avg_team_num <", value, "avgTeamNum");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("avg_team_num <=", value, "avgTeamNum");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumIn(List<BigDecimal> values) {
            addCriterion("avg_team_num in", values, "avgTeamNum");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumNotIn(List<BigDecimal> values) {
            addCriterion("avg_team_num not in", values, "avgTeamNum");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg_team_num between", value1, value2, "avgTeamNum");
            return (Criteria) this;
        }

        public Criteria andAvgTeamNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg_team_num not between", value1, value2, "avgTeamNum");
            return (Criteria) this;
        }

        public Criteria andTeamPointIsNull() {
            addCriterion("team_point is null");
            return (Criteria) this;
        }

        public Criteria andTeamPointIsNotNull() {
            addCriterion("team_point is not null");
            return (Criteria) this;
        }

        public Criteria andTeamPointEqualTo(Integer value) {
            addCriterion("team_point =", value, "teamPoint");
            return (Criteria) this;
        }

        public Criteria andTeamPointNotEqualTo(Integer value) {
            addCriterion("team_point <>", value, "teamPoint");
            return (Criteria) this;
        }

        public Criteria andTeamPointGreaterThan(Integer value) {
            addCriterion("team_point >", value, "teamPoint");
            return (Criteria) this;
        }

        public Criteria andTeamPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_point >=", value, "teamPoint");
            return (Criteria) this;
        }

        public Criteria andTeamPointLessThan(Integer value) {
            addCriterion("team_point <", value, "teamPoint");
            return (Criteria) this;
        }

        public Criteria andTeamPointLessThanOrEqualTo(Integer value) {
            addCriterion("team_point <=", value, "teamPoint");
            return (Criteria) this;
        }

        public Criteria andTeamPointIn(List<Integer> values) {
            addCriterion("team_point in", values, "teamPoint");
            return (Criteria) this;
        }

        public Criteria andTeamPointNotIn(List<Integer> values) {
            addCriterion("team_point not in", values, "teamPoint");
            return (Criteria) this;
        }

        public Criteria andTeamPointBetween(Integer value1, Integer value2) {
            addCriterion("team_point between", value1, value2, "teamPoint");
            return (Criteria) this;
        }

        public Criteria andTeamPointNotBetween(Integer value1, Integer value2) {
            addCriterion("team_point not between", value1, value2, "teamPoint");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNull() {
            addCriterion("evaluate is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNotNull() {
            addCriterion("evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateEqualTo(String value) {
            addCriterion("evaluate =", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotEqualTo(String value) {
            addCriterion("evaluate <>", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThan(String value) {
            addCriterion("evaluate >", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate >=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThan(String value) {
            addCriterion("evaluate <", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThanOrEqualTo(String value) {
            addCriterion("evaluate <=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLike(String value) {
            addCriterion("evaluate like", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotLike(String value) {
            addCriterion("evaluate not like", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateIn(List<String> values) {
            addCriterion("evaluate in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotIn(List<String> values) {
            addCriterion("evaluate not in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateBetween(String value1, String value2) {
            addCriterion("evaluate between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotBetween(String value1, String value2) {
            addCriterion("evaluate not between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andPerformPointIsNull() {
            addCriterion("perform_point is null");
            return (Criteria) this;
        }

        public Criteria andPerformPointIsNotNull() {
            addCriterion("perform_point is not null");
            return (Criteria) this;
        }

        public Criteria andPerformPointEqualTo(Integer value) {
            addCriterion("perform_point =", value, "performPoint");
            return (Criteria) this;
        }

        public Criteria andPerformPointNotEqualTo(Integer value) {
            addCriterion("perform_point <>", value, "performPoint");
            return (Criteria) this;
        }

        public Criteria andPerformPointGreaterThan(Integer value) {
            addCriterion("perform_point >", value, "performPoint");
            return (Criteria) this;
        }

        public Criteria andPerformPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("perform_point >=", value, "performPoint");
            return (Criteria) this;
        }

        public Criteria andPerformPointLessThan(Integer value) {
            addCriterion("perform_point <", value, "performPoint");
            return (Criteria) this;
        }

        public Criteria andPerformPointLessThanOrEqualTo(Integer value) {
            addCriterion("perform_point <=", value, "performPoint");
            return (Criteria) this;
        }

        public Criteria andPerformPointIn(List<Integer> values) {
            addCriterion("perform_point in", values, "performPoint");
            return (Criteria) this;
        }

        public Criteria andPerformPointNotIn(List<Integer> values) {
            addCriterion("perform_point not in", values, "performPoint");
            return (Criteria) this;
        }

        public Criteria andPerformPointBetween(Integer value1, Integer value2) {
            addCriterion("perform_point between", value1, value2, "performPoint");
            return (Criteria) this;
        }

        public Criteria andPerformPointNotBetween(Integer value1, Integer value2) {
            addCriterion("perform_point not between", value1, value2, "performPoint");
            return (Criteria) this;
        }

        public Criteria andDeductReasonIsNull() {
            addCriterion("deduct_reason is null");
            return (Criteria) this;
        }

        public Criteria andDeductReasonIsNotNull() {
            addCriterion("deduct_reason is not null");
            return (Criteria) this;
        }

        public Criteria andDeductReasonEqualTo(String value) {
            addCriterion("deduct_reason =", value, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductReasonNotEqualTo(String value) {
            addCriterion("deduct_reason <>", value, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductReasonGreaterThan(String value) {
            addCriterion("deduct_reason >", value, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductReasonGreaterThanOrEqualTo(String value) {
            addCriterion("deduct_reason >=", value, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductReasonLessThan(String value) {
            addCriterion("deduct_reason <", value, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductReasonLessThanOrEqualTo(String value) {
            addCriterion("deduct_reason <=", value, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductReasonLike(String value) {
            addCriterion("deduct_reason like", value, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductReasonNotLike(String value) {
            addCriterion("deduct_reason not like", value, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductReasonIn(List<String> values) {
            addCriterion("deduct_reason in", values, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductReasonNotIn(List<String> values) {
            addCriterion("deduct_reason not in", values, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductReasonBetween(String value1, String value2) {
            addCriterion("deduct_reason between", value1, value2, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductReasonNotBetween(String value1, String value2) {
            addCriterion("deduct_reason not between", value1, value2, "deductReason");
            return (Criteria) this;
        }

        public Criteria andDeductPointIsNull() {
            addCriterion("deduct_point is null");
            return (Criteria) this;
        }

        public Criteria andDeductPointIsNotNull() {
            addCriterion("deduct_point is not null");
            return (Criteria) this;
        }

        public Criteria andDeductPointEqualTo(Integer value) {
            addCriterion("deduct_point =", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointNotEqualTo(Integer value) {
            addCriterion("deduct_point <>", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointGreaterThan(Integer value) {
            addCriterion("deduct_point >", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("deduct_point >=", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointLessThan(Integer value) {
            addCriterion("deduct_point <", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointLessThanOrEqualTo(Integer value) {
            addCriterion("deduct_point <=", value, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointIn(List<Integer> values) {
            addCriterion("deduct_point in", values, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointNotIn(List<Integer> values) {
            addCriterion("deduct_point not in", values, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointBetween(Integer value1, Integer value2) {
            addCriterion("deduct_point between", value1, value2, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andDeductPointNotBetween(Integer value1, Integer value2) {
            addCriterion("deduct_point not between", value1, value2, "deductPoint");
            return (Criteria) this;
        }

        public Criteria andPlusReasonIsNull() {
            addCriterion("plus_reason is null");
            return (Criteria) this;
        }

        public Criteria andPlusReasonIsNotNull() {
            addCriterion("plus_reason is not null");
            return (Criteria) this;
        }

        public Criteria andPlusReasonEqualTo(String value) {
            addCriterion("plus_reason =", value, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonNotEqualTo(String value) {
            addCriterion("plus_reason <>", value, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonGreaterThan(String value) {
            addCriterion("plus_reason >", value, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonGreaterThanOrEqualTo(String value) {
            addCriterion("plus_reason >=", value, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonLessThan(String value) {
            addCriterion("plus_reason <", value, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonLessThanOrEqualTo(String value) {
            addCriterion("plus_reason <=", value, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonLike(String value) {
            addCriterion("plus_reason like", value, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonNotLike(String value) {
            addCriterion("plus_reason not like", value, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonIn(List<String> values) {
            addCriterion("plus_reason in", values, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonNotIn(List<String> values) {
            addCriterion("plus_reason not in", values, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonBetween(String value1, String value2) {
            addCriterion("plus_reason between", value1, value2, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonNotBetween(String value1, String value2) {
            addCriterion("plus_reason not between", value1, value2, "plusReason");
            return (Criteria) this;
        }

        public Criteria andPlusPointIsNull() {
            addCriterion("plus_point is null");
            return (Criteria) this;
        }

        public Criteria andPlusPointIsNotNull() {
            addCriterion("plus_point is not null");
            return (Criteria) this;
        }

        public Criteria andPlusPointEqualTo(Integer value) {
            addCriterion("plus_point =", value, "plusPoint");
            return (Criteria) this;
        }

        public Criteria andPlusPointNotEqualTo(Integer value) {
            addCriterion("plus_point <>", value, "plusPoint");
            return (Criteria) this;
        }

        public Criteria andPlusPointGreaterThan(Integer value) {
            addCriterion("plus_point >", value, "plusPoint");
            return (Criteria) this;
        }

        public Criteria andPlusPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("plus_point >=", value, "plusPoint");
            return (Criteria) this;
        }

        public Criteria andPlusPointLessThan(Integer value) {
            addCriterion("plus_point <", value, "plusPoint");
            return (Criteria) this;
        }

        public Criteria andPlusPointLessThanOrEqualTo(Integer value) {
            addCriterion("plus_point <=", value, "plusPoint");
            return (Criteria) this;
        }

        public Criteria andPlusPointIn(List<Integer> values) {
            addCriterion("plus_point in", values, "plusPoint");
            return (Criteria) this;
        }

        public Criteria andPlusPointNotIn(List<Integer> values) {
            addCriterion("plus_point not in", values, "plusPoint");
            return (Criteria) this;
        }

        public Criteria andPlusPointBetween(Integer value1, Integer value2) {
            addCriterion("plus_point between", value1, value2, "plusPoint");
            return (Criteria) this;
        }

        public Criteria andPlusPointNotBetween(Integer value1, Integer value2) {
            addCriterion("plus_point not between", value1, value2, "plusPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointIsNull() {
            addCriterion("total_point is null");
            return (Criteria) this;
        }

        public Criteria andTotalPointIsNotNull() {
            addCriterion("total_point is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPointEqualTo(Integer value) {
            addCriterion("total_point =", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointNotEqualTo(Integer value) {
            addCriterion("total_point <>", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointGreaterThan(Integer value) {
            addCriterion("total_point >", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_point >=", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointLessThan(Integer value) {
            addCriterion("total_point <", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointLessThanOrEqualTo(Integer value) {
            addCriterion("total_point <=", value, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointIn(List<Integer> values) {
            addCriterion("total_point in", values, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointNotIn(List<Integer> values) {
            addCriterion("total_point not in", values, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointBetween(Integer value1, Integer value2) {
            addCriterion("total_point between", value1, value2, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andTotalPointNotBetween(Integer value1, Integer value2) {
            addCriterion("total_point not between", value1, value2, "totalPoint");
            return (Criteria) this;
        }

        public Criteria andReamrkIsNull() {
            addCriterion("reamrk is null");
            return (Criteria) this;
        }

        public Criteria andReamrkIsNotNull() {
            addCriterion("reamrk is not null");
            return (Criteria) this;
        }

        public Criteria andReamrkEqualTo(String value) {
            addCriterion("reamrk =", value, "reamrk");
            return (Criteria) this;
        }

        public Criteria andReamrkNotEqualTo(String value) {
            addCriterion("reamrk <>", value, "reamrk");
            return (Criteria) this;
        }

        public Criteria andReamrkGreaterThan(String value) {
            addCriterion("reamrk >", value, "reamrk");
            return (Criteria) this;
        }

        public Criteria andReamrkGreaterThanOrEqualTo(String value) {
            addCriterion("reamrk >=", value, "reamrk");
            return (Criteria) this;
        }

        public Criteria andReamrkLessThan(String value) {
            addCriterion("reamrk <", value, "reamrk");
            return (Criteria) this;
        }

        public Criteria andReamrkLessThanOrEqualTo(String value) {
            addCriterion("reamrk <=", value, "reamrk");
            return (Criteria) this;
        }

        public Criteria andReamrkLike(String value) {
            addCriterion("reamrk like", value, "reamrk");
            return (Criteria) this;
        }

        public Criteria andReamrkNotLike(String value) {
            addCriterion("reamrk not like", value, "reamrk");
            return (Criteria) this;
        }

        public Criteria andReamrkIn(List<String> values) {
            addCriterion("reamrk in", values, "reamrk");
            return (Criteria) this;
        }

        public Criteria andReamrkNotIn(List<String> values) {
            addCriterion("reamrk not in", values, "reamrk");
            return (Criteria) this;
        }

        public Criteria andReamrkBetween(String value1, String value2) {
            addCriterion("reamrk between", value1, value2, "reamrk");
            return (Criteria) this;
        }

        public Criteria andReamrkNotBetween(String value1, String value2) {
            addCriterion("reamrk not between", value1, value2, "reamrk");
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

        public Criteria andBusinessSubjectLikeInsensitive(String value) {
            addCriterion("upper(business_subject) like", value.toUpperCase(), "businessSubject");
            return (Criteria) this;
        }

        public Criteria andAttendanceLikeInsensitive(String value) {
            addCriterion("upper(attendance) like", value.toUpperCase(), "attendance");
            return (Criteria) this;
        }

        public Criteria andEvaluateLikeInsensitive(String value) {
            addCriterion("upper(evaluate) like", value.toUpperCase(), "evaluate");
            return (Criteria) this;
        }

        public Criteria andDeductReasonLikeInsensitive(String value) {
            addCriterion("upper(deduct_reason) like", value.toUpperCase(), "deductReason");
            return (Criteria) this;
        }

        public Criteria andPlusReasonLikeInsensitive(String value) {
            addCriterion("upper(plus_reason) like", value.toUpperCase(), "plusReason");
            return (Criteria) this;
        }

        public Criteria andReamrkLikeInsensitive(String value) {
            addCriterion("upper(reamrk) like", value.toUpperCase(), "reamrk");
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