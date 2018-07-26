package cn.com.yuanwei.center.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticleTypeIsNull() {
            addCriterion("article_type is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIsNotNull() {
            addCriterion("article_type is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeEqualTo(Integer value) {
            addCriterion("article_type =", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotEqualTo(Integer value) {
            addCriterion("article_type <>", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThan(Integer value) {
            addCriterion("article_type >", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_type >=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThan(Integer value) {
            addCriterion("article_type <", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("article_type <=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIn(List<Integer> values) {
            addCriterion("article_type in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotIn(List<Integer> values) {
            addCriterion("article_type not in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeBetween(Integer value1, Integer value2) {
            addCriterion("article_type between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("article_type not between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryIsNull() {
            addCriterion("article_category is null");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryIsNotNull() {
            addCriterion("article_category is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryEqualTo(Integer value) {
            addCriterion("article_category =", value, "articleCategory");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryNotEqualTo(Integer value) {
            addCriterion("article_category <>", value, "articleCategory");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryGreaterThan(Integer value) {
            addCriterion("article_category >", value, "articleCategory");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_category >=", value, "articleCategory");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryLessThan(Integer value) {
            addCriterion("article_category <", value, "articleCategory");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("article_category <=", value, "articleCategory");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryIn(List<Integer> values) {
            addCriterion("article_category in", values, "articleCategory");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryNotIn(List<Integer> values) {
            addCriterion("article_category not in", values, "articleCategory");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryBetween(Integer value1, Integer value2) {
            addCriterion("article_category between", value1, value2, "articleCategory");
            return (Criteria) this;
        }

        public Criteria andArticleCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("article_category not between", value1, value2, "articleCategory");
            return (Criteria) this;
        }

        public Criteria andBreifIsNull() {
            addCriterion("breif is null");
            return (Criteria) this;
        }

        public Criteria andBreifIsNotNull() {
            addCriterion("breif is not null");
            return (Criteria) this;
        }

        public Criteria andBreifEqualTo(String value) {
            addCriterion("breif =", value, "breif");
            return (Criteria) this;
        }

        public Criteria andBreifNotEqualTo(String value) {
            addCriterion("breif <>", value, "breif");
            return (Criteria) this;
        }

        public Criteria andBreifGreaterThan(String value) {
            addCriterion("breif >", value, "breif");
            return (Criteria) this;
        }

        public Criteria andBreifGreaterThanOrEqualTo(String value) {
            addCriterion("breif >=", value, "breif");
            return (Criteria) this;
        }

        public Criteria andBreifLessThan(String value) {
            addCriterion("breif <", value, "breif");
            return (Criteria) this;
        }

        public Criteria andBreifLessThanOrEqualTo(String value) {
            addCriterion("breif <=", value, "breif");
            return (Criteria) this;
        }

        public Criteria andBreifLike(String value) {
            addCriterion("breif like", value, "breif");
            return (Criteria) this;
        }

        public Criteria andBreifNotLike(String value) {
            addCriterion("breif not like", value, "breif");
            return (Criteria) this;
        }

        public Criteria andBreifIn(List<String> values) {
            addCriterion("breif in", values, "breif");
            return (Criteria) this;
        }

        public Criteria andBreifNotIn(List<String> values) {
            addCriterion("breif not in", values, "breif");
            return (Criteria) this;
        }

        public Criteria andBreifBetween(String value1, String value2) {
            addCriterion("breif between", value1, value2, "breif");
            return (Criteria) this;
        }

        public Criteria andBreifNotBetween(String value1, String value2) {
            addCriterion("breif not between", value1, value2, "breif");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceUrlIsNull() {
            addCriterion("source_url is null");
            return (Criteria) this;
        }

        public Criteria andSourceUrlIsNotNull() {
            addCriterion("source_url is not null");
            return (Criteria) this;
        }

        public Criteria andSourceUrlEqualTo(String value) {
            addCriterion("source_url =", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlNotEqualTo(String value) {
            addCriterion("source_url <>", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlGreaterThan(String value) {
            addCriterion("source_url >", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("source_url >=", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlLessThan(String value) {
            addCriterion("source_url <", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlLessThanOrEqualTo(String value) {
            addCriterion("source_url <=", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlLike(String value) {
            addCriterion("source_url like", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlNotLike(String value) {
            addCriterion("source_url not like", value, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlIn(List<String> values) {
            addCriterion("source_url in", values, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlNotIn(List<String> values) {
            addCriterion("source_url not in", values, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlBetween(String value1, String value2) {
            addCriterion("source_url between", value1, value2, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceUrlNotBetween(String value1, String value2) {
            addCriterion("source_url not between", value1, value2, "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNull() {
            addCriterion("click_num is null");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNotNull() {
            addCriterion("click_num is not null");
            return (Criteria) this;
        }

        public Criteria andClickNumEqualTo(Integer value) {
            addCriterion("click_num =", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotEqualTo(Integer value) {
            addCriterion("click_num <>", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThan(Integer value) {
            addCriterion("click_num >", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_num >=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThan(Integer value) {
            addCriterion("click_num <", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThanOrEqualTo(Integer value) {
            addCriterion("click_num <=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumIn(List<Integer> values) {
            addCriterion("click_num in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotIn(List<Integer> values) {
            addCriterion("click_num not in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumBetween(Integer value1, Integer value2) {
            addCriterion("click_num between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotBetween(Integer value1, Integer value2) {
            addCriterion("click_num not between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNull() {
            addCriterion("comment_num is null");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNotNull() {
            addCriterion("comment_num is not null");
            return (Criteria) this;
        }

        public Criteria andCommentNumEqualTo(Integer value) {
            addCriterion("comment_num =", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotEqualTo(Integer value) {
            addCriterion("comment_num <>", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThan(Integer value) {
            addCriterion("comment_num >", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_num >=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThan(Integer value) {
            addCriterion("comment_num <", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThanOrEqualTo(Integer value) {
            addCriterion("comment_num <=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumIn(List<Integer> values) {
            addCriterion("comment_num in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotIn(List<Integer> values) {
            addCriterion("comment_num not in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumBetween(Integer value1, Integer value2) {
            addCriterion("comment_num between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_num not between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andContentKeywordIsNull() {
            addCriterion("content_keyword is null");
            return (Criteria) this;
        }

        public Criteria andContentKeywordIsNotNull() {
            addCriterion("content_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andContentKeywordEqualTo(String value) {
            addCriterion("content_keyword =", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordNotEqualTo(String value) {
            addCriterion("content_keyword <>", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordGreaterThan(String value) {
            addCriterion("content_keyword >", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("content_keyword >=", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordLessThan(String value) {
            addCriterion("content_keyword <", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordLessThanOrEqualTo(String value) {
            addCriterion("content_keyword <=", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordLike(String value) {
            addCriterion("content_keyword like", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordNotLike(String value) {
            addCriterion("content_keyword not like", value, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordIn(List<String> values) {
            addCriterion("content_keyword in", values, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordNotIn(List<String> values) {
            addCriterion("content_keyword not in", values, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordBetween(String value1, String value2) {
            addCriterion("content_keyword between", value1, value2, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andContentKeywordNotBetween(String value1, String value2) {
            addCriterion("content_keyword not between", value1, value2, "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andTopLevelIsNull() {
            addCriterion("top_level is null");
            return (Criteria) this;
        }

        public Criteria andTopLevelIsNotNull() {
            addCriterion("top_level is not null");
            return (Criteria) this;
        }

        public Criteria andTopLevelEqualTo(Integer value) {
            addCriterion("top_level =", value, "topLevel");
            return (Criteria) this;
        }

        public Criteria andTopLevelNotEqualTo(Integer value) {
            addCriterion("top_level <>", value, "topLevel");
            return (Criteria) this;
        }

        public Criteria andTopLevelGreaterThan(Integer value) {
            addCriterion("top_level >", value, "topLevel");
            return (Criteria) this;
        }

        public Criteria andTopLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("top_level >=", value, "topLevel");
            return (Criteria) this;
        }

        public Criteria andTopLevelLessThan(Integer value) {
            addCriterion("top_level <", value, "topLevel");
            return (Criteria) this;
        }

        public Criteria andTopLevelLessThanOrEqualTo(Integer value) {
            addCriterion("top_level <=", value, "topLevel");
            return (Criteria) this;
        }

        public Criteria andTopLevelIn(List<Integer> values) {
            addCriterion("top_level in", values, "topLevel");
            return (Criteria) this;
        }

        public Criteria andTopLevelNotIn(List<Integer> values) {
            addCriterion("top_level not in", values, "topLevel");
            return (Criteria) this;
        }

        public Criteria andTopLevelBetween(Integer value1, Integer value2) {
            addCriterion("top_level between", value1, value2, "topLevel");
            return (Criteria) this;
        }

        public Criteria andTopLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("top_level not between", value1, value2, "topLevel");
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

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andDepartIdsIsNull() {
            addCriterion("depart_ids is null");
            return (Criteria) this;
        }

        public Criteria andDepartIdsIsNotNull() {
            addCriterion("depart_ids is not null");
            return (Criteria) this;
        }

        public Criteria andDepartIdsEqualTo(String value) {
            addCriterion("depart_ids =", value, "departIds");
            return (Criteria) this;
        }

        public Criteria andDepartIdsNotEqualTo(String value) {
            addCriterion("depart_ids <>", value, "departIds");
            return (Criteria) this;
        }

        public Criteria andDepartIdsGreaterThan(String value) {
            addCriterion("depart_ids >", value, "departIds");
            return (Criteria) this;
        }

        public Criteria andDepartIdsGreaterThanOrEqualTo(String value) {
            addCriterion("depart_ids >=", value, "departIds");
            return (Criteria) this;
        }

        public Criteria andDepartIdsLessThan(String value) {
            addCriterion("depart_ids <", value, "departIds");
            return (Criteria) this;
        }

        public Criteria andDepartIdsLessThanOrEqualTo(String value) {
            addCriterion("depart_ids <=", value, "departIds");
            return (Criteria) this;
        }

        public Criteria andDepartIdsLike(String value) {
            addCriterion("depart_ids like", value, "departIds");
            return (Criteria) this;
        }

        public Criteria andDepartIdsNotLike(String value) {
            addCriterion("depart_ids not like", value, "departIds");
            return (Criteria) this;
        }

        public Criteria andDepartIdsIn(List<String> values) {
            addCriterion("depart_ids in", values, "departIds");
            return (Criteria) this;
        }

        public Criteria andDepartIdsNotIn(List<String> values) {
            addCriterion("depart_ids not in", values, "departIds");
            return (Criteria) this;
        }

        public Criteria andDepartIdsBetween(String value1, String value2) {
            addCriterion("depart_ids between", value1, value2, "departIds");
            return (Criteria) this;
        }

        public Criteria andDepartIdsNotBetween(String value1, String value2) {
            addCriterion("depart_ids not between", value1, value2, "departIds");
            return (Criteria) this;
        }

        public Criteria andIsPublicIsNull() {
            addCriterion("is_public is null");
            return (Criteria) this;
        }

        public Criteria andIsPublicIsNotNull() {
            addCriterion("is_public is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublicEqualTo(Integer value) {
            addCriterion("is_public =", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicNotEqualTo(Integer value) {
            addCriterion("is_public <>", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicGreaterThan(Integer value) {
            addCriterion("is_public >", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_public >=", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicLessThan(Integer value) {
            addCriterion("is_public <", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicLessThanOrEqualTo(Integer value) {
            addCriterion("is_public <=", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicIn(List<Integer> values) {
            addCriterion("is_public in", values, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicNotIn(List<Integer> values) {
            addCriterion("is_public not in", values, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicBetween(Integer value1, Integer value2) {
            addCriterion("is_public between", value1, value2, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicNotBetween(Integer value1, Integer value2) {
            addCriterion("is_public not between", value1, value2, "isPublic");
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

        public Criteria andBreifLikeInsensitive(String value) {
            addCriterion("upper(breif) like", value.toUpperCase(), "breif");
            return (Criteria) this;
        }

        public Criteria andSourceLikeInsensitive(String value) {
            addCriterion("upper(source) like", value.toUpperCase(), "source");
            return (Criteria) this;
        }

        public Criteria andSourceUrlLikeInsensitive(String value) {
            addCriterion("upper(source_url) like", value.toUpperCase(), "sourceUrl");
            return (Criteria) this;
        }

        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("upper(title) like", value.toUpperCase(), "title");
            return (Criteria) this;
        }

        public Criteria andAuthorLikeInsensitive(String value) {
            addCriterion("upper(author) like", value.toUpperCase(), "author");
            return (Criteria) this;
        }

        public Criteria andPicLikeInsensitive(String value) {
            addCriterion("upper(pic) like", value.toUpperCase(), "pic");
            return (Criteria) this;
        }

        public Criteria andContentKeywordLikeInsensitive(String value) {
            addCriterion("upper(content_keyword) like", value.toUpperCase(), "contentKeyword");
            return (Criteria) this;
        }

        public Criteria andDepartIdsLikeInsensitive(String value) {
            addCriterion("upper(depart_ids) like", value.toUpperCase(), "departIds");
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