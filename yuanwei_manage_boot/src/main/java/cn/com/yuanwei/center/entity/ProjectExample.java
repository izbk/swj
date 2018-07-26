package cn.com.yuanwei.center.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
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

        public Criteria andPlannedStartDateIsNull() {
            addCriterion("planned_start_date is null");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateIsNotNull() {
            addCriterion("planned_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("planned_start_date =", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("planned_start_date <>", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("planned_start_date >", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planned_start_date >=", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateLessThan(Date value) {
            addCriterionForJDBCDate("planned_start_date <", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planned_start_date <=", value, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("planned_start_date in", values, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("planned_start_date not in", values, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planned_start_date between", value1, value2, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planned_start_date not between", value1, value2, "plannedStartDate");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeIsNull() {
            addCriterion("planned_completion_time is null");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeIsNotNull() {
            addCriterion("planned_completion_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeEqualTo(Date value) {
            addCriterionForJDBCDate("planned_completion_time =", value, "plannedCompletionTime");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("planned_completion_time <>", value, "plannedCompletionTime");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("planned_completion_time >", value, "plannedCompletionTime");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planned_completion_time >=", value, "plannedCompletionTime");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeLessThan(Date value) {
            addCriterionForJDBCDate("planned_completion_time <", value, "plannedCompletionTime");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planned_completion_time <=", value, "plannedCompletionTime");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeIn(List<Date> values) {
            addCriterionForJDBCDate("planned_completion_time in", values, "plannedCompletionTime");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("planned_completion_time not in", values, "plannedCompletionTime");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planned_completion_time between", value1, value2, "plannedCompletionTime");
            return (Criteria) this;
        }

        public Criteria andPlannedCompletionTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planned_completion_time not between", value1, value2, "plannedCompletionTime");
            return (Criteria) this;
        }

        public Criteria andLandAreaIsNull() {
            addCriterion("land_area is null");
            return (Criteria) this;
        }

        public Criteria andLandAreaIsNotNull() {
            addCriterion("land_area is not null");
            return (Criteria) this;
        }

        public Criteria andLandAreaEqualTo(BigDecimal value) {
            addCriterion("land_area =", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaNotEqualTo(BigDecimal value) {
            addCriterion("land_area <>", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaGreaterThan(BigDecimal value) {
            addCriterion("land_area >", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("land_area >=", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaLessThan(BigDecimal value) {
            addCriterion("land_area <", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("land_area <=", value, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaIn(List<BigDecimal> values) {
            addCriterion("land_area in", values, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaNotIn(List<BigDecimal> values) {
            addCriterion("land_area not in", values, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("land_area between", value1, value2, "landArea");
            return (Criteria) this;
        }

        public Criteria andLandAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("land_area not between", value1, value2, "landArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaIsNull() {
            addCriterion("building_area is null");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaIsNotNull() {
            addCriterion("building_area is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaEqualTo(BigDecimal value) {
            addCriterion("building_area =", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaNotEqualTo(BigDecimal value) {
            addCriterion("building_area <>", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaGreaterThan(BigDecimal value) {
            addCriterion("building_area >", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("building_area >=", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaLessThan(BigDecimal value) {
            addCriterion("building_area <", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("building_area <=", value, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaIn(List<BigDecimal> values) {
            addCriterion("building_area in", values, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaNotIn(List<BigDecimal> values) {
            addCriterion("building_area not in", values, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("building_area between", value1, value2, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBuildingAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("building_area not between", value1, value2, "buildingArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaIsNull() {
            addCriterion("business_area is null");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaIsNotNull() {
            addCriterion("business_area is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaEqualTo(BigDecimal value) {
            addCriterion("business_area =", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaNotEqualTo(BigDecimal value) {
            addCriterion("business_area <>", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaGreaterThan(BigDecimal value) {
            addCriterion("business_area >", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("business_area >=", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaLessThan(BigDecimal value) {
            addCriterion("business_area <", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("business_area <=", value, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaIn(List<BigDecimal> values) {
            addCriterion("business_area in", values, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaNotIn(List<BigDecimal> values) {
            addCriterion("business_area not in", values, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("business_area between", value1, value2, "businessArea");
            return (Criteria) this;
        }

        public Criteria andBusinessAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("business_area not between", value1, value2, "businessArea");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNull() {
            addCriterion("is_use is null");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNotNull() {
            addCriterion("is_use is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseEqualTo(Integer value) {
            addCriterion("is_use =", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotEqualTo(Integer value) {
            addCriterion("is_use <>", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThan(Integer value) {
            addCriterion("is_use >", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_use >=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThan(Integer value) {
            addCriterion("is_use <", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThanOrEqualTo(Integer value) {
            addCriterion("is_use <=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseIn(List<Integer> values) {
            addCriterion("is_use in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotIn(List<Integer> values) {
            addCriterion("is_use not in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseBetween(Integer value1, Integer value2) {
            addCriterion("is_use between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_use not between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsStageIsNull() {
            addCriterion("is_stage is null");
            return (Criteria) this;
        }

        public Criteria andIsStageIsNotNull() {
            addCriterion("is_stage is not null");
            return (Criteria) this;
        }

        public Criteria andIsStageEqualTo(Integer value) {
            addCriterion("is_stage =", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageNotEqualTo(Integer value) {
            addCriterion("is_stage <>", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageGreaterThan(Integer value) {
            addCriterion("is_stage >", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_stage >=", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageLessThan(Integer value) {
            addCriterion("is_stage <", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageLessThanOrEqualTo(Integer value) {
            addCriterion("is_stage <=", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageIn(List<Integer> values) {
            addCriterion("is_stage in", values, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageNotIn(List<Integer> values) {
            addCriterion("is_stage not in", values, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageBetween(Integer value1, Integer value2) {
            addCriterion("is_stage between", value1, value2, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageNotBetween(Integer value1, Integer value2) {
            addCriterion("is_stage not between", value1, value2, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearIsNull() {
            addCriterion("is_beyond_year is null");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearIsNotNull() {
            addCriterion("is_beyond_year is not null");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearEqualTo(Integer value) {
            addCriterion("is_beyond_year =", value, "isBeyondYear");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearNotEqualTo(Integer value) {
            addCriterion("is_beyond_year <>", value, "isBeyondYear");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearGreaterThan(Integer value) {
            addCriterion("is_beyond_year >", value, "isBeyondYear");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_beyond_year >=", value, "isBeyondYear");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearLessThan(Integer value) {
            addCriterion("is_beyond_year <", value, "isBeyondYear");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearLessThanOrEqualTo(Integer value) {
            addCriterion("is_beyond_year <=", value, "isBeyondYear");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearIn(List<Integer> values) {
            addCriterion("is_beyond_year in", values, "isBeyondYear");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearNotIn(List<Integer> values) {
            addCriterion("is_beyond_year not in", values, "isBeyondYear");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearBetween(Integer value1, Integer value2) {
            addCriterion("is_beyond_year between", value1, value2, "isBeyondYear");
            return (Criteria) this;
        }

        public Criteria andIsBeyondYearNotBetween(Integer value1, Integer value2) {
            addCriterion("is_beyond_year not between", value1, value2, "isBeyondYear");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(Integer value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(Integer value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(Integer value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(Integer value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<Integer> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<Integer> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(Integer value1, Integer value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
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

        public Criteria andRecordNumIsNull() {
            addCriterion("record_num is null");
            return (Criteria) this;
        }

        public Criteria andRecordNumIsNotNull() {
            addCriterion("record_num is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNumEqualTo(String value) {
            addCriterion("record_num =", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumNotEqualTo(String value) {
            addCriterion("record_num <>", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumGreaterThan(String value) {
            addCriterion("record_num >", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumGreaterThanOrEqualTo(String value) {
            addCriterion("record_num >=", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumLessThan(String value) {
            addCriterion("record_num <", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumLessThanOrEqualTo(String value) {
            addCriterion("record_num <=", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumLike(String value) {
            addCriterion("record_num like", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumNotLike(String value) {
            addCriterion("record_num not like", value, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumIn(List<String> values) {
            addCriterion("record_num in", values, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumNotIn(List<String> values) {
            addCriterion("record_num not in", values, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumBetween(String value1, String value2) {
            addCriterion("record_num between", value1, value2, "recordNum");
            return (Criteria) this;
        }

        public Criteria andRecordNumNotBetween(String value1, String value2) {
            addCriterion("record_num not between", value1, value2, "recordNum");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentIsNull() {
            addCriterion("approve_investment is null");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentIsNotNull() {
            addCriterion("approve_investment is not null");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentEqualTo(BigDecimal value) {
            addCriterion("approve_investment =", value, "approveInvestment");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentNotEqualTo(BigDecimal value) {
            addCriterion("approve_investment <>", value, "approveInvestment");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentGreaterThan(BigDecimal value) {
            addCriterion("approve_investment >", value, "approveInvestment");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("approve_investment >=", value, "approveInvestment");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentLessThan(BigDecimal value) {
            addCriterion("approve_investment <", value, "approveInvestment");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("approve_investment <=", value, "approveInvestment");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentIn(List<BigDecimal> values) {
            addCriterion("approve_investment in", values, "approveInvestment");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentNotIn(List<BigDecimal> values) {
            addCriterion("approve_investment not in", values, "approveInvestment");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("approve_investment between", value1, value2, "approveInvestment");
            return (Criteria) this;
        }

        public Criteria andApproveInvestmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("approve_investment not between", value1, value2, "approveInvestment");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentIsNull() {
            addCriterion("program_investment is null");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentIsNotNull() {
            addCriterion("program_investment is not null");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentEqualTo(BigDecimal value) {
            addCriterion("program_investment =", value, "programInvestment");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentNotEqualTo(BigDecimal value) {
            addCriterion("program_investment <>", value, "programInvestment");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentGreaterThan(BigDecimal value) {
            addCriterion("program_investment >", value, "programInvestment");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("program_investment >=", value, "programInvestment");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentLessThan(BigDecimal value) {
            addCriterion("program_investment <", value, "programInvestment");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("program_investment <=", value, "programInvestment");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentIn(List<BigDecimal> values) {
            addCriterion("program_investment in", values, "programInvestment");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentNotIn(List<BigDecimal> values) {
            addCriterion("program_investment not in", values, "programInvestment");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("program_investment between", value1, value2, "programInvestment");
            return (Criteria) this;
        }

        public Criteria andProgramInvestmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("program_investment not between", value1, value2, "programInvestment");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentIsNull() {
            addCriterion("plan_investment is null");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentIsNotNull() {
            addCriterion("plan_investment is not null");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentEqualTo(BigDecimal value) {
            addCriterion("plan_investment =", value, "planInvestment");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentNotEqualTo(BigDecimal value) {
            addCriterion("plan_investment <>", value, "planInvestment");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentGreaterThan(BigDecimal value) {
            addCriterion("plan_investment >", value, "planInvestment");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_investment >=", value, "planInvestment");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentLessThan(BigDecimal value) {
            addCriterion("plan_investment <", value, "planInvestment");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_investment <=", value, "planInvestment");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentIn(List<BigDecimal> values) {
            addCriterion("plan_investment in", values, "planInvestment");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentNotIn(List<BigDecimal> values) {
            addCriterion("plan_investment not in", values, "planInvestment");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_investment between", value1, value2, "planInvestment");
            return (Criteria) this;
        }

        public Criteria andPlanInvestmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_investment not between", value1, value2, "planInvestment");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentIsNull() {
            addCriterion("real_investment is null");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentIsNotNull() {
            addCriterion("real_investment is not null");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentEqualTo(BigDecimal value) {
            addCriterion("real_investment =", value, "realInvestment");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentNotEqualTo(BigDecimal value) {
            addCriterion("real_investment <>", value, "realInvestment");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentGreaterThan(BigDecimal value) {
            addCriterion("real_investment >", value, "realInvestment");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_investment >=", value, "realInvestment");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentLessThan(BigDecimal value) {
            addCriterion("real_investment <", value, "realInvestment");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_investment <=", value, "realInvestment");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentIn(List<BigDecimal> values) {
            addCriterion("real_investment in", values, "realInvestment");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentNotIn(List<BigDecimal> values) {
            addCriterion("real_investment not in", values, "realInvestment");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_investment between", value1, value2, "realInvestment");
            return (Criteria) this;
        }

        public Criteria andRealInvestmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_investment not between", value1, value2, "realInvestment");
            return (Criteria) this;
        }

        public Criteria andRaiseIsNull() {
            addCriterion("raise is null");
            return (Criteria) this;
        }

        public Criteria andRaiseIsNotNull() {
            addCriterion("raise is not null");
            return (Criteria) this;
        }

        public Criteria andRaiseEqualTo(BigDecimal value) {
            addCriterion("raise =", value, "raise");
            return (Criteria) this;
        }

        public Criteria andRaiseNotEqualTo(BigDecimal value) {
            addCriterion("raise <>", value, "raise");
            return (Criteria) this;
        }

        public Criteria andRaiseGreaterThan(BigDecimal value) {
            addCriterion("raise >", value, "raise");
            return (Criteria) this;
        }

        public Criteria andRaiseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("raise >=", value, "raise");
            return (Criteria) this;
        }

        public Criteria andRaiseLessThan(BigDecimal value) {
            addCriterion("raise <", value, "raise");
            return (Criteria) this;
        }

        public Criteria andRaiseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("raise <=", value, "raise");
            return (Criteria) this;
        }

        public Criteria andRaiseIn(List<BigDecimal> values) {
            addCriterion("raise in", values, "raise");
            return (Criteria) this;
        }

        public Criteria andRaiseNotIn(List<BigDecimal> values) {
            addCriterion("raise not in", values, "raise");
            return (Criteria) this;
        }

        public Criteria andRaiseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("raise between", value1, value2, "raise");
            return (Criteria) this;
        }

        public Criteria andRaiseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("raise not between", value1, value2, "raise");
            return (Criteria) this;
        }

        public Criteria andLoanIsNull() {
            addCriterion("loan is null");
            return (Criteria) this;
        }

        public Criteria andLoanIsNotNull() {
            addCriterion("loan is not null");
            return (Criteria) this;
        }

        public Criteria andLoanEqualTo(BigDecimal value) {
            addCriterion("loan =", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanNotEqualTo(BigDecimal value) {
            addCriterion("loan <>", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanGreaterThan(BigDecimal value) {
            addCriterion("loan >", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan >=", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanLessThan(BigDecimal value) {
            addCriterion("loan <", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan <=", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanIn(List<BigDecimal> values) {
            addCriterion("loan in", values, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanNotIn(List<BigDecimal> values) {
            addCriterion("loan not in", values, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan between", value1, value2, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan not between", value1, value2, "loan");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(BigDecimal value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(BigDecimal value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(BigDecimal value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(BigDecimal value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<BigDecimal> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<BigDecimal> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andBuildStatusIsNull() {
            addCriterion("build_status is null");
            return (Criteria) this;
        }

        public Criteria andBuildStatusIsNotNull() {
            addCriterion("build_status is not null");
            return (Criteria) this;
        }

        public Criteria andBuildStatusEqualTo(Integer value) {
            addCriterion("build_status =", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusNotEqualTo(Integer value) {
            addCriterion("build_status <>", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusGreaterThan(Integer value) {
            addCriterion("build_status >", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("build_status >=", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusLessThan(Integer value) {
            addCriterion("build_status <", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusLessThanOrEqualTo(Integer value) {
            addCriterion("build_status <=", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusIn(List<Integer> values) {
            addCriterion("build_status in", values, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusNotIn(List<Integer> values) {
            addCriterion("build_status not in", values, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusBetween(Integer value1, Integer value2) {
            addCriterion("build_status between", value1, value2, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("build_status not between", value1, value2, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andConstructionContentIsNull() {
            addCriterion("construction_content is null");
            return (Criteria) this;
        }

        public Criteria andConstructionContentIsNotNull() {
            addCriterion("construction_content is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionContentEqualTo(String value) {
            addCriterion("construction_content =", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentNotEqualTo(String value) {
            addCriterion("construction_content <>", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentGreaterThan(String value) {
            addCriterion("construction_content >", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentGreaterThanOrEqualTo(String value) {
            addCriterion("construction_content >=", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentLessThan(String value) {
            addCriterion("construction_content <", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentLessThanOrEqualTo(String value) {
            addCriterion("construction_content <=", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentLike(String value) {
            addCriterion("construction_content like", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentNotLike(String value) {
            addCriterion("construction_content not like", value, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentIn(List<String> values) {
            addCriterion("construction_content in", values, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentNotIn(List<String> values) {
            addCriterion("construction_content not in", values, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentBetween(String value1, String value2) {
            addCriterion("construction_content between", value1, value2, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andConstructionContentNotBetween(String value1, String value2) {
            addCriterion("construction_content not between", value1, value2, "constructionContent");
            return (Criteria) this;
        }

        public Criteria andProposalIsNull() {
            addCriterion("proposal is null");
            return (Criteria) this;
        }

        public Criteria andProposalIsNotNull() {
            addCriterion("proposal is not null");
            return (Criteria) this;
        }

        public Criteria andProposalEqualTo(String value) {
            addCriterion("proposal =", value, "proposal");
            return (Criteria) this;
        }

        public Criteria andProposalNotEqualTo(String value) {
            addCriterion("proposal <>", value, "proposal");
            return (Criteria) this;
        }

        public Criteria andProposalGreaterThan(String value) {
            addCriterion("proposal >", value, "proposal");
            return (Criteria) this;
        }

        public Criteria andProposalGreaterThanOrEqualTo(String value) {
            addCriterion("proposal >=", value, "proposal");
            return (Criteria) this;
        }

        public Criteria andProposalLessThan(String value) {
            addCriterion("proposal <", value, "proposal");
            return (Criteria) this;
        }

        public Criteria andProposalLessThanOrEqualTo(String value) {
            addCriterion("proposal <=", value, "proposal");
            return (Criteria) this;
        }

        public Criteria andProposalLike(String value) {
            addCriterion("proposal like", value, "proposal");
            return (Criteria) this;
        }

        public Criteria andProposalNotLike(String value) {
            addCriterion("proposal not like", value, "proposal");
            return (Criteria) this;
        }

        public Criteria andProposalIn(List<String> values) {
            addCriterion("proposal in", values, "proposal");
            return (Criteria) this;
        }

        public Criteria andProposalNotIn(List<String> values) {
            addCriterion("proposal not in", values, "proposal");
            return (Criteria) this;
        }

        public Criteria andProposalBetween(String value1, String value2) {
            addCriterion("proposal between", value1, value2, "proposal");
            return (Criteria) this;
        }

        public Criteria andProposalNotBetween(String value1, String value2) {
            addCriterion("proposal not between", value1, value2, "proposal");
            return (Criteria) this;
        }

        public Criteria andAssessmentIsNull() {
            addCriterion("assessment is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentIsNotNull() {
            addCriterion("assessment is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentEqualTo(String value) {
            addCriterion("assessment =", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentNotEqualTo(String value) {
            addCriterion("assessment <>", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentGreaterThan(String value) {
            addCriterion("assessment >", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentGreaterThanOrEqualTo(String value) {
            addCriterion("assessment >=", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentLessThan(String value) {
            addCriterion("assessment <", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentLessThanOrEqualTo(String value) {
            addCriterion("assessment <=", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentLike(String value) {
            addCriterion("assessment like", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentNotLike(String value) {
            addCriterion("assessment not like", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentIn(List<String> values) {
            addCriterion("assessment in", values, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentNotIn(List<String> values) {
            addCriterion("assessment not in", values, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentBetween(String value1, String value2) {
            addCriterion("assessment between", value1, value2, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentNotBetween(String value1, String value2) {
            addCriterion("assessment not between", value1, value2, "assessment");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
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

        public Criteria andProjectNameLikeInsensitive(String value) {
            addCriterion("upper(project_name) like", value.toUpperCase(), "projectName");
            return (Criteria) this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return (Criteria) this;
        }

        public Criteria andOwnerLikeInsensitive(String value) {
            addCriterion("upper(owner) like", value.toUpperCase(), "owner");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLikeInsensitive(String value) {
            addCriterion("upper(legal_person) like", value.toUpperCase(), "legalPerson");
            return (Criteria) this;
        }

        public Criteria andContactLikeInsensitive(String value) {
            addCriterion("upper(contact) like", value.toUpperCase(), "contact");
            return (Criteria) this;
        }

        public Criteria andRecordNumLikeInsensitive(String value) {
            addCriterion("upper(record_num) like", value.toUpperCase(), "recordNum");
            return (Criteria) this;
        }

        public Criteria andConstructionContentLikeInsensitive(String value) {
            addCriterion("upper(construction_content) like", value.toUpperCase(), "constructionContent");
            return (Criteria) this;
        }

        public Criteria andProposalLikeInsensitive(String value) {
            addCriterion("upper(proposal) like", value.toUpperCase(), "proposal");
            return (Criteria) this;
        }

        public Criteria andAssessmentLikeInsensitive(String value) {
            addCriterion("upper(assessment) like", value.toUpperCase(), "assessment");
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