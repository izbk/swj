package cn.com.yuanwei.center.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExample() {
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
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

        public Criteria andIndustryTypeIsNull() {
            addCriterion("industry_type is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNotNull() {
            addCriterion("industry_type is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeEqualTo(Integer value) {
            addCriterion("industry_type =", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotEqualTo(Integer value) {
            addCriterion("industry_type <>", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThan(Integer value) {
            addCriterion("industry_type >", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("industry_type >=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThan(Integer value) {
            addCriterion("industry_type <", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThanOrEqualTo(Integer value) {
            addCriterion("industry_type <=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIn(List<Integer> values) {
            addCriterion("industry_type in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotIn(List<Integer> values) {
            addCriterion("industry_type not in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeBetween(Integer value1, Integer value2) {
            addCriterion("industry_type between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("industry_type not between", value1, value2, "industryType");
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

        public Criteria andMianBusinessIsNull() {
            addCriterion("mian_business is null");
            return (Criteria) this;
        }

        public Criteria andMianBusinessIsNotNull() {
            addCriterion("mian_business is not null");
            return (Criteria) this;
        }

        public Criteria andMianBusinessEqualTo(String value) {
            addCriterion("mian_business =", value, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andMianBusinessNotEqualTo(String value) {
            addCriterion("mian_business <>", value, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andMianBusinessGreaterThan(String value) {
            addCriterion("mian_business >", value, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andMianBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("mian_business >=", value, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andMianBusinessLessThan(String value) {
            addCriterion("mian_business <", value, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andMianBusinessLessThanOrEqualTo(String value) {
            addCriterion("mian_business <=", value, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andMianBusinessLike(String value) {
            addCriterion("mian_business like", value, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andMianBusinessNotLike(String value) {
            addCriterion("mian_business not like", value, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andMianBusinessIn(List<String> values) {
            addCriterion("mian_business in", values, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andMianBusinessNotIn(List<String> values) {
            addCriterion("mian_business not in", values, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andMianBusinessBetween(String value1, String value2) {
            addCriterion("mian_business between", value1, value2, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andMianBusinessNotBetween(String value1, String value2) {
            addCriterion("mian_business not between", value1, value2, "mianBusiness");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverIsNull() {
            addCriterion("avg_turnover is null");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverIsNotNull() {
            addCriterion("avg_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverEqualTo(Integer value) {
            addCriterion("avg_turnover =", value, "avgTurnover");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverNotEqualTo(Integer value) {
            addCriterion("avg_turnover <>", value, "avgTurnover");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverGreaterThan(Integer value) {
            addCriterion("avg_turnover >", value, "avgTurnover");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("avg_turnover >=", value, "avgTurnover");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverLessThan(Integer value) {
            addCriterion("avg_turnover <", value, "avgTurnover");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverLessThanOrEqualTo(Integer value) {
            addCriterion("avg_turnover <=", value, "avgTurnover");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverIn(List<Integer> values) {
            addCriterion("avg_turnover in", values, "avgTurnover");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverNotIn(List<Integer> values) {
            addCriterion("avg_turnover not in", values, "avgTurnover");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverBetween(Integer value1, Integer value2) {
            addCriterion("avg_turnover between", value1, value2, "avgTurnover");
            return (Criteria) this;
        }

        public Criteria andAvgTurnoverNotBetween(Integer value1, Integer value2) {
            addCriterion("avg_turnover not between", value1, value2, "avgTurnover");
            return (Criteria) this;
        }

        public Criteria andEmployeesIsNull() {
            addCriterion("employees is null");
            return (Criteria) this;
        }

        public Criteria andEmployeesIsNotNull() {
            addCriterion("employees is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeesEqualTo(Integer value) {
            addCriterion("employees =", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesNotEqualTo(Integer value) {
            addCriterion("employees <>", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesGreaterThan(Integer value) {
            addCriterion("employees >", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesGreaterThanOrEqualTo(Integer value) {
            addCriterion("employees >=", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesLessThan(Integer value) {
            addCriterion("employees <", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesLessThanOrEqualTo(Integer value) {
            addCriterion("employees <=", value, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesIn(List<Integer> values) {
            addCriterion("employees in", values, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesNotIn(List<Integer> values) {
            addCriterion("employees not in", values, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesBetween(Integer value1, Integer value2) {
            addCriterion("employees between", value1, value2, "employees");
            return (Criteria) this;
        }

        public Criteria andEmployeesNotBetween(Integer value1, Integer value2) {
            addCriterion("employees not between", value1, value2, "employees");
            return (Criteria) this;
        }

        public Criteria andIsSeedIsNull() {
            addCriterion("is_seed is null");
            return (Criteria) this;
        }

        public Criteria andIsSeedIsNotNull() {
            addCriterion("is_seed is not null");
            return (Criteria) this;
        }

        public Criteria andIsSeedEqualTo(Integer value) {
            addCriterion("is_seed =", value, "isSeed");
            return (Criteria) this;
        }

        public Criteria andIsSeedNotEqualTo(Integer value) {
            addCriterion("is_seed <>", value, "isSeed");
            return (Criteria) this;
        }

        public Criteria andIsSeedGreaterThan(Integer value) {
            addCriterion("is_seed >", value, "isSeed");
            return (Criteria) this;
        }

        public Criteria andIsSeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_seed >=", value, "isSeed");
            return (Criteria) this;
        }

        public Criteria andIsSeedLessThan(Integer value) {
            addCriterion("is_seed <", value, "isSeed");
            return (Criteria) this;
        }

        public Criteria andIsSeedLessThanOrEqualTo(Integer value) {
            addCriterion("is_seed <=", value, "isSeed");
            return (Criteria) this;
        }

        public Criteria andIsSeedIn(List<Integer> values) {
            addCriterion("is_seed in", values, "isSeed");
            return (Criteria) this;
        }

        public Criteria andIsSeedNotIn(List<Integer> values) {
            addCriterion("is_seed not in", values, "isSeed");
            return (Criteria) this;
        }

        public Criteria andIsSeedBetween(Integer value1, Integer value2) {
            addCriterion("is_seed between", value1, value2, "isSeed");
            return (Criteria) this;
        }

        public Criteria andIsSeedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_seed not between", value1, value2, "isSeed");
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

        public Criteria andCompanyNameLikeInsensitive(String value) {
            addCriterion("upper(company_name) like", value.toUpperCase(), "companyName");
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

        public Criteria andMianBusinessLikeInsensitive(String value) {
            addCriterion("upper(mian_business) like", value.toUpperCase(), "mianBusiness");
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