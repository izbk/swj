package cn.com.yuanwei.center.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpecialtyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecialtyExample() {
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

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNull() {
            addCriterion("subject_type is null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNotNull() {
            addCriterion("subject_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeEqualTo(Integer value) {
            addCriterion("subject_type =", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotEqualTo(Integer value) {
            addCriterion("subject_type <>", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThan(Integer value) {
            addCriterion("subject_type >", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_type >=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThan(Integer value) {
            addCriterion("subject_type <", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThanOrEqualTo(Integer value) {
            addCriterion("subject_type <=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIn(List<Integer> values) {
            addCriterion("subject_type in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotIn(List<Integer> values) {
            addCriterion("subject_type not in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeBetween(Integer value1, Integer value2) {
            addCriterion("subject_type between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_type not between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andIntroIsNull() {
            addCriterion("intro is null");
            return (Criteria) this;
        }

        public Criteria andIntroIsNotNull() {
            addCriterion("intro is not null");
            return (Criteria) this;
        }

        public Criteria andIntroEqualTo(String value) {
            addCriterion("intro =", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotEqualTo(String value) {
            addCriterion("intro <>", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThan(String value) {
            addCriterion("intro >", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThanOrEqualTo(String value) {
            addCriterion("intro >=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThan(String value) {
            addCriterion("intro <", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThanOrEqualTo(String value) {
            addCriterion("intro <=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLike(String value) {
            addCriterion("intro like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotLike(String value) {
            addCriterion("intro not like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroIn(List<String> values) {
            addCriterion("intro in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotIn(List<String> values) {
            addCriterion("intro not in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroBetween(String value1, String value2) {
            addCriterion("intro between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotBetween(String value1, String value2) {
            addCriterion("intro not between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andScaleIsNull() {
            addCriterion("scale is null");
            return (Criteria) this;
        }

        public Criteria andScaleIsNotNull() {
            addCriterion("scale is not null");
            return (Criteria) this;
        }

        public Criteria andScaleEqualTo(String value) {
            addCriterion("scale =", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotEqualTo(String value) {
            addCriterion("scale <>", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThan(String value) {
            addCriterion("scale >", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThanOrEqualTo(String value) {
            addCriterion("scale >=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThan(String value) {
            addCriterion("scale <", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThanOrEqualTo(String value) {
            addCriterion("scale <=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLike(String value) {
            addCriterion("scale like", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotLike(String value) {
            addCriterion("scale not like", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleIn(List<String> values) {
            addCriterion("scale in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotIn(List<String> values) {
            addCriterion("scale not in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleBetween(String value1, String value2) {
            addCriterion("scale between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotBetween(String value1, String value2) {
            addCriterion("scale not between", value1, value2, "scale");
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

        public Criteria andCategoryEqualTo(Integer value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(Integer value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(Integer value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(Integer value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<Integer> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<Integer> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(Integer value1, Integer value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andOriginIsNull() {
            addCriterion("origin is null");
            return (Criteria) this;
        }

        public Criteria andOriginIsNotNull() {
            addCriterion("origin is not null");
            return (Criteria) this;
        }

        public Criteria andOriginEqualTo(String value) {
            addCriterion("origin =", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotEqualTo(String value) {
            addCriterion("origin <>", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThan(String value) {
            addCriterion("origin >", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThanOrEqualTo(String value) {
            addCriterion("origin >=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThan(String value) {
            addCriterion("origin <", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThanOrEqualTo(String value) {
            addCriterion("origin <=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLike(String value) {
            addCriterion("origin like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotLike(String value) {
            addCriterion("origin not like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginIn(List<String> values) {
            addCriterion("origin in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotIn(List<String> values) {
            addCriterion("origin not in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginBetween(String value1, String value2) {
            addCriterion("origin between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotBetween(String value1, String value2) {
            addCriterion("origin not between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andSeasonalIsNull() {
            addCriterion("seasonal is null");
            return (Criteria) this;
        }

        public Criteria andSeasonalIsNotNull() {
            addCriterion("seasonal is not null");
            return (Criteria) this;
        }

        public Criteria andSeasonalEqualTo(String value) {
            addCriterion("seasonal =", value, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSeasonalNotEqualTo(String value) {
            addCriterion("seasonal <>", value, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSeasonalGreaterThan(String value) {
            addCriterion("seasonal >", value, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSeasonalGreaterThanOrEqualTo(String value) {
            addCriterion("seasonal >=", value, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSeasonalLessThan(String value) {
            addCriterion("seasonal <", value, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSeasonalLessThanOrEqualTo(String value) {
            addCriterion("seasonal <=", value, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSeasonalLike(String value) {
            addCriterion("seasonal like", value, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSeasonalNotLike(String value) {
            addCriterion("seasonal not like", value, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSeasonalIn(List<String> values) {
            addCriterion("seasonal in", values, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSeasonalNotIn(List<String> values) {
            addCriterion("seasonal not in", values, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSeasonalBetween(String value1, String value2) {
            addCriterion("seasonal between", value1, value2, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSeasonalNotBetween(String value1, String value2) {
            addCriterion("seasonal not between", value1, value2, "seasonal");
            return (Criteria) this;
        }

        public Criteria andSaleChannelIsNull() {
            addCriterion("sale_channel is null");
            return (Criteria) this;
        }

        public Criteria andSaleChannelIsNotNull() {
            addCriterion("sale_channel is not null");
            return (Criteria) this;
        }

        public Criteria andSaleChannelEqualTo(String value) {
            addCriterion("sale_channel =", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelNotEqualTo(String value) {
            addCriterion("sale_channel <>", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelGreaterThan(String value) {
            addCriterion("sale_channel >", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelGreaterThanOrEqualTo(String value) {
            addCriterion("sale_channel >=", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelLessThan(String value) {
            addCriterion("sale_channel <", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelLessThanOrEqualTo(String value) {
            addCriterion("sale_channel <=", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelLike(String value) {
            addCriterion("sale_channel like", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelNotLike(String value) {
            addCriterion("sale_channel not like", value, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelIn(List<String> values) {
            addCriterion("sale_channel in", values, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelNotIn(List<String> values) {
            addCriterion("sale_channel not in", values, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelBetween(String value1, String value2) {
            addCriterion("sale_channel between", value1, value2, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSaleChannelNotBetween(String value1, String value2) {
            addCriterion("sale_channel not between", value1, value2, "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIsNull() {
            addCriterion("sales_status is null");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIsNotNull() {
            addCriterion("sales_status is not null");
            return (Criteria) this;
        }

        public Criteria andSalesStatusEqualTo(String value) {
            addCriterion("sales_status =", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotEqualTo(String value) {
            addCriterion("sales_status <>", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusGreaterThan(String value) {
            addCriterion("sales_status >", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sales_status >=", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLessThan(String value) {
            addCriterion("sales_status <", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLessThanOrEqualTo(String value) {
            addCriterion("sales_status <=", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLike(String value) {
            addCriterion("sales_status like", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotLike(String value) {
            addCriterion("sales_status not like", value, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusIn(List<String> values) {
            addCriterion("sales_status in", values, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotIn(List<String> values) {
            addCriterion("sales_status not in", values, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusBetween(String value1, String value2) {
            addCriterion("sales_status between", value1, value2, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andSalesStatusNotBetween(String value1, String value2) {
            addCriterion("sales_status not between", value1, value2, "salesStatus");
            return (Criteria) this;
        }

        public Criteria andPriceRangeIsNull() {
            addCriterion("price_range is null");
            return (Criteria) this;
        }

        public Criteria andPriceRangeIsNotNull() {
            addCriterion("price_range is not null");
            return (Criteria) this;
        }

        public Criteria andPriceRangeEqualTo(String value) {
            addCriterion("price_range =", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeNotEqualTo(String value) {
            addCriterion("price_range <>", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeGreaterThan(String value) {
            addCriterion("price_range >", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeGreaterThanOrEqualTo(String value) {
            addCriterion("price_range >=", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeLessThan(String value) {
            addCriterion("price_range <", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeLessThanOrEqualTo(String value) {
            addCriterion("price_range <=", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeLike(String value) {
            addCriterion("price_range like", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeNotLike(String value) {
            addCriterion("price_range not like", value, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeIn(List<String> values) {
            addCriterion("price_range in", values, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeNotIn(List<String> values) {
            addCriterion("price_range not in", values, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeBetween(String value1, String value2) {
            addCriterion("price_range between", value1, value2, "priceRange");
            return (Criteria) this;
        }

        public Criteria andPriceRangeNotBetween(String value1, String value2) {
            addCriterion("price_range not between", value1, value2, "priceRange");
            return (Criteria) this;
        }

        public Criteria andAccreditationIsNull() {
            addCriterion("accreditation is null");
            return (Criteria) this;
        }

        public Criteria andAccreditationIsNotNull() {
            addCriterion("accreditation is not null");
            return (Criteria) this;
        }

        public Criteria andAccreditationEqualTo(String value) {
            addCriterion("accreditation =", value, "accreditation");
            return (Criteria) this;
        }

        public Criteria andAccreditationNotEqualTo(String value) {
            addCriterion("accreditation <>", value, "accreditation");
            return (Criteria) this;
        }

        public Criteria andAccreditationGreaterThan(String value) {
            addCriterion("accreditation >", value, "accreditation");
            return (Criteria) this;
        }

        public Criteria andAccreditationGreaterThanOrEqualTo(String value) {
            addCriterion("accreditation >=", value, "accreditation");
            return (Criteria) this;
        }

        public Criteria andAccreditationLessThan(String value) {
            addCriterion("accreditation <", value, "accreditation");
            return (Criteria) this;
        }

        public Criteria andAccreditationLessThanOrEqualTo(String value) {
            addCriterion("accreditation <=", value, "accreditation");
            return (Criteria) this;
        }

        public Criteria andAccreditationLike(String value) {
            addCriterion("accreditation like", value, "accreditation");
            return (Criteria) this;
        }

        public Criteria andAccreditationNotLike(String value) {
            addCriterion("accreditation not like", value, "accreditation");
            return (Criteria) this;
        }

        public Criteria andAccreditationIn(List<String> values) {
            addCriterion("accreditation in", values, "accreditation");
            return (Criteria) this;
        }

        public Criteria andAccreditationNotIn(List<String> values) {
            addCriterion("accreditation not in", values, "accreditation");
            return (Criteria) this;
        }

        public Criteria andAccreditationBetween(String value1, String value2) {
            addCriterion("accreditation between", value1, value2, "accreditation");
            return (Criteria) this;
        }

        public Criteria andAccreditationNotBetween(String value1, String value2) {
            addCriterion("accreditation not between", value1, value2, "accreditation");
            return (Criteria) this;
        }

        public Criteria andTrademarkIsNull() {
            addCriterion("trademark is null");
            return (Criteria) this;
        }

        public Criteria andTrademarkIsNotNull() {
            addCriterion("trademark is not null");
            return (Criteria) this;
        }

        public Criteria andTrademarkEqualTo(String value) {
            addCriterion("trademark =", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkNotEqualTo(String value) {
            addCriterion("trademark <>", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkGreaterThan(String value) {
            addCriterion("trademark >", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkGreaterThanOrEqualTo(String value) {
            addCriterion("trademark >=", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkLessThan(String value) {
            addCriterion("trademark <", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkLessThanOrEqualTo(String value) {
            addCriterion("trademark <=", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkLike(String value) {
            addCriterion("trademark like", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkNotLike(String value) {
            addCriterion("trademark not like", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkIn(List<String> values) {
            addCriterion("trademark in", values, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkNotIn(List<String> values) {
            addCriterion("trademark not in", values, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkBetween(String value1, String value2) {
            addCriterion("trademark between", value1, value2, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkNotBetween(String value1, String value2) {
            addCriterion("trademark not between", value1, value2, "trademark");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleIsNull() {
            addCriterion("online_sale is null");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleIsNotNull() {
            addCriterion("online_sale is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleEqualTo(String value) {
            addCriterion("online_sale =", value, "onlineSale");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleNotEqualTo(String value) {
            addCriterion("online_sale <>", value, "onlineSale");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleGreaterThan(String value) {
            addCriterion("online_sale >", value, "onlineSale");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleGreaterThanOrEqualTo(String value) {
            addCriterion("online_sale >=", value, "onlineSale");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleLessThan(String value) {
            addCriterion("online_sale <", value, "onlineSale");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleLessThanOrEqualTo(String value) {
            addCriterion("online_sale <=", value, "onlineSale");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleLike(String value) {
            addCriterion("online_sale like", value, "onlineSale");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleNotLike(String value) {
            addCriterion("online_sale not like", value, "onlineSale");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleIn(List<String> values) {
            addCriterion("online_sale in", values, "onlineSale");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleNotIn(List<String> values) {
            addCriterion("online_sale not in", values, "onlineSale");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleBetween(String value1, String value2) {
            addCriterion("online_sale between", value1, value2, "onlineSale");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleNotBetween(String value1, String value2) {
            addCriterion("online_sale not between", value1, value2, "onlineSale");
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

        public Criteria andProductPicIsNull() {
            addCriterion("product_pic is null");
            return (Criteria) this;
        }

        public Criteria andProductPicIsNotNull() {
            addCriterion("product_pic is not null");
            return (Criteria) this;
        }

        public Criteria andProductPicEqualTo(String value) {
            addCriterion("product_pic =", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotEqualTo(String value) {
            addCriterion("product_pic <>", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicGreaterThan(String value) {
            addCriterion("product_pic >", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicGreaterThanOrEqualTo(String value) {
            addCriterion("product_pic >=", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicLessThan(String value) {
            addCriterion("product_pic <", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicLessThanOrEqualTo(String value) {
            addCriterion("product_pic <=", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicLike(String value) {
            addCriterion("product_pic like", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotLike(String value) {
            addCriterion("product_pic not like", value, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicIn(List<String> values) {
            addCriterion("product_pic in", values, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotIn(List<String> values) {
            addCriterion("product_pic not in", values, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicBetween(String value1, String value2) {
            addCriterion("product_pic between", value1, value2, "productPic");
            return (Criteria) this;
        }

        public Criteria andProductPicNotBetween(String value1, String value2) {
            addCriterion("product_pic not between", value1, value2, "productPic");
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

        public Criteria andSubjectLikeInsensitive(String value) {
            addCriterion("upper(subject) like", value.toUpperCase(), "subject");
            return (Criteria) this;
        }

        public Criteria andProductNameLikeInsensitive(String value) {
            addCriterion("upper(product_name) like", value.toUpperCase(), "productName");
            return (Criteria) this;
        }

        public Criteria andIntroLikeInsensitive(String value) {
            addCriterion("upper(intro) like", value.toUpperCase(), "intro");
            return (Criteria) this;
        }

        public Criteria andScaleLikeInsensitive(String value) {
            addCriterion("upper(scale) like", value.toUpperCase(), "scale");
            return (Criteria) this;
        }

        public Criteria andOriginLikeInsensitive(String value) {
            addCriterion("upper(origin) like", value.toUpperCase(), "origin");
            return (Criteria) this;
        }

        public Criteria andSeasonalLikeInsensitive(String value) {
            addCriterion("upper(seasonal) like", value.toUpperCase(), "seasonal");
            return (Criteria) this;
        }

        public Criteria andSaleChannelLikeInsensitive(String value) {
            addCriterion("upper(sale_channel) like", value.toUpperCase(), "saleChannel");
            return (Criteria) this;
        }

        public Criteria andSalesStatusLikeInsensitive(String value) {
            addCriterion("upper(sales_status) like", value.toUpperCase(), "salesStatus");
            return (Criteria) this;
        }

        public Criteria andPriceRangeLikeInsensitive(String value) {
            addCriterion("upper(price_range) like", value.toUpperCase(), "priceRange");
            return (Criteria) this;
        }

        public Criteria andAccreditationLikeInsensitive(String value) {
            addCriterion("upper(accreditation) like", value.toUpperCase(), "accreditation");
            return (Criteria) this;
        }

        public Criteria andTrademarkLikeInsensitive(String value) {
            addCriterion("upper(trademark) like", value.toUpperCase(), "trademark");
            return (Criteria) this;
        }

        public Criteria andOnlineSaleLikeInsensitive(String value) {
            addCriterion("upper(online_sale) like", value.toUpperCase(), "onlineSale");
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

        public Criteria andProposalLikeInsensitive(String value) {
            addCriterion("upper(proposal) like", value.toUpperCase(), "proposal");
            return (Criteria) this;
        }

        public Criteria andProductPicLikeInsensitive(String value) {
            addCriterion("upper(product_pic) like", value.toUpperCase(), "productPic");
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