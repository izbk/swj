package cn.com.yuanwei.center.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IncubationParkRegisterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IncubationParkRegisterExample() {
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

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andMobileLikeInsensitive(String value) {
            addCriterion("upper(mobile) like", value.toUpperCase(), "mobile");
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