package com.jcin.cms.modules.pro.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCriteria {
    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    protected Page page;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public ProductCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
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

        public Criteria andProBrandIdIsNull() {
            addCriterion("pro_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andProBrandIdIsNotNull() {
            addCriterion("pro_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andProBrandIdEqualTo(String value) {
            addCriterion("pro_brand_id =", value, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andProBrandIdNotEqualTo(String value) {
            addCriterion("pro_brand_id <>", value, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andProBrandIdGreaterThan(String value) {
            addCriterion("pro_brand_id >", value, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andProBrandIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_brand_id >=", value, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andProBrandIdLessThan(String value) {
            addCriterion("pro_brand_id <", value, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andProBrandIdLessThanOrEqualTo(String value) {
            addCriterion("pro_brand_id <=", value, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andProBrandIdLike(String value) {
            addCriterion("pro_brand_id like", value, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andProBrandIdNotLike(String value) {
            addCriterion("pro_brand_id not like", value, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andProBrandIdIn(List<String> values) {
            addCriterion("pro_brand_id in", values, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andProBrandIdNotIn(List<String> values) {
            addCriterion("pro_brand_id not in", values, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andProBrandIdBetween(String value1, String value2) {
            addCriterion("pro_brand_id between", value1, value2, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andProBrandIdNotBetween(String value1, String value2) {
            addCriterion("pro_brand_id not between", value1, value2, "proBrandId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andAssetsIsNull() {
            addCriterion("assets is null");
            return (Criteria) this;
        }

        public Criteria andAssetsIsNotNull() {
            addCriterion("assets is not null");
            return (Criteria) this;
        }

        public Criteria andAssetsEqualTo(String value) {
            addCriterion("assets =", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsNotEqualTo(String value) {
            addCriterion("assets <>", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsGreaterThan(String value) {
            addCriterion("assets >", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsGreaterThanOrEqualTo(String value) {
            addCriterion("assets >=", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsLessThan(String value) {
            addCriterion("assets <", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsLessThanOrEqualTo(String value) {
            addCriterion("assets <=", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsLike(String value) {
            addCriterion("assets like", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsNotLike(String value) {
            addCriterion("assets not like", value, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsIn(List<String> values) {
            addCriterion("assets in", values, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsNotIn(List<String> values) {
            addCriterion("assets not in", values, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsBetween(String value1, String value2) {
            addCriterion("assets between", value1, value2, "assets");
            return (Criteria) this;
        }

        public Criteria andAssetsNotBetween(String value1, String value2) {
            addCriterion("assets not between", value1, value2, "assets");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
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

        public Criteria andContentKeywordsIsNull() {
            addCriterion("content_keywords is null");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsIsNotNull() {
            addCriterion("content_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsEqualTo(String value) {
            addCriterion("content_keywords =", value, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsNotEqualTo(String value) {
            addCriterion("content_keywords <>", value, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsGreaterThan(String value) {
            addCriterion("content_keywords >", value, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("content_keywords >=", value, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsLessThan(String value) {
            addCriterion("content_keywords <", value, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsLessThanOrEqualTo(String value) {
            addCriterion("content_keywords <=", value, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsLike(String value) {
            addCriterion("content_keywords like", value, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsNotLike(String value) {
            addCriterion("content_keywords not like", value, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsIn(List<String> values) {
            addCriterion("content_keywords in", values, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsNotIn(List<String> values) {
            addCriterion("content_keywords not in", values, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsBetween(String value1, String value2) {
            addCriterion("content_keywords between", value1, value2, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsNotBetween(String value1, String value2) {
            addCriterion("content_keywords not between", value1, value2, "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("tags like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("tags not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("tags not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTitleImageIsNull() {
            addCriterion("title_image is null");
            return (Criteria) this;
        }

        public Criteria andTitleImageIsNotNull() {
            addCriterion("title_image is not null");
            return (Criteria) this;
        }

        public Criteria andTitleImageEqualTo(String value) {
            addCriterion("title_image =", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageNotEqualTo(String value) {
            addCriterion("title_image <>", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageGreaterThan(String value) {
            addCriterion("title_image >", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageGreaterThanOrEqualTo(String value) {
            addCriterion("title_image >=", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageLessThan(String value) {
            addCriterion("title_image <", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageLessThanOrEqualTo(String value) {
            addCriterion("title_image <=", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageLike(String value) {
            addCriterion("title_image like", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageNotLike(String value) {
            addCriterion("title_image not like", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageIn(List<String> values) {
            addCriterion("title_image in", values, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageNotIn(List<String> values) {
            addCriterion("title_image not in", values, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageBetween(String value1, String value2) {
            addCriterion("title_image between", value1, value2, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageNotBetween(String value1, String value2) {
            addCriterion("title_image not between", value1, value2, "titleImage");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateIsNull() {
            addCriterion("gene_template is null");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateIsNotNull() {
            addCriterion("gene_template is not null");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateEqualTo(String value) {
            addCriterion("gene_template =", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateNotEqualTo(String value) {
            addCriterion("gene_template <>", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateGreaterThan(String value) {
            addCriterion("gene_template >", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("gene_template >=", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateLessThan(String value) {
            addCriterion("gene_template <", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateLessThanOrEqualTo(String value) {
            addCriterion("gene_template <=", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateLike(String value) {
            addCriterion("gene_template like", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateNotLike(String value) {
            addCriterion("gene_template not like", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateIn(List<String> values) {
            addCriterion("gene_template in", values, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateNotIn(List<String> values) {
            addCriterion("gene_template not in", values, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateBetween(String value1, String value2) {
            addCriterion("gene_template between", value1, value2, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateNotBetween(String value1, String value2) {
            addCriterion("gene_template not between", value1, value2, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateIsNull() {
            addCriterion("m_gene_template is null");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateIsNotNull() {
            addCriterion("m_gene_template is not null");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateEqualTo(String value) {
            addCriterion("m_gene_template =", value, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateNotEqualTo(String value) {
            addCriterion("m_gene_template <>", value, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateGreaterThan(String value) {
            addCriterion("m_gene_template >", value, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("m_gene_template >=", value, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateLessThan(String value) {
            addCriterion("m_gene_template <", value, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateLessThanOrEqualTo(String value) {
            addCriterion("m_gene_template <=", value, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateLike(String value) {
            addCriterion("m_gene_template like", value, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateNotLike(String value) {
            addCriterion("m_gene_template not like", value, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateIn(List<String> values) {
            addCriterion("m_gene_template in", values, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateNotIn(List<String> values) {
            addCriterion("m_gene_template not in", values, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateBetween(String value1, String value2) {
            addCriterion("m_gene_template between", value1, value2, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateNotBetween(String value1, String value2) {
            addCriterion("m_gene_template not between", value1, value2, "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andMeasureIsNull() {
            addCriterion("measure is null");
            return (Criteria) this;
        }

        public Criteria andMeasureIsNotNull() {
            addCriterion("measure is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureEqualTo(String value) {
            addCriterion("measure =", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureNotEqualTo(String value) {
            addCriterion("measure <>", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureGreaterThan(String value) {
            addCriterion("measure >", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureGreaterThanOrEqualTo(String value) {
            addCriterion("measure >=", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureLessThan(String value) {
            addCriterion("measure <", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureLessThanOrEqualTo(String value) {
            addCriterion("measure <=", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureLike(String value) {
            addCriterion("measure like", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureNotLike(String value) {
            addCriterion("measure not like", value, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureIn(List<String> values) {
            addCriterion("measure in", values, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureNotIn(List<String> values) {
            addCriterion("measure not in", values, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureBetween(String value1, String value2) {
            addCriterion("measure between", value1, value2, "measure");
            return (Criteria) this;
        }

        public Criteria andMeasureNotBetween(String value1, String value2) {
            addCriterion("measure not between", value1, value2, "measure");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andProBrandIdLikeInsensitive(String value) {
            addCriterion("upper(pro_brand_id) like", value.toUpperCase(), "proBrandId");
            return (Criteria) this;
        }

        public Criteria andAssetsLikeInsensitive(String value) {
            addCriterion("upper(assets) like", value.toUpperCase(), "assets");
            return (Criteria) this;
        }

        public Criteria andUseridLikeInsensitive(String value) {
            addCriterion("upper(userid) like", value.toUpperCase(), "userid");
            return (Criteria) this;
        }

        public Criteria andKeywordsLikeInsensitive(String value) {
            addCriterion("upper(keywords) like", value.toUpperCase(), "keywords");
            return (Criteria) this;
        }

        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("upper(title) like", value.toUpperCase(), "title");
            return (Criteria) this;
        }

        public Criteria andContentKeywordsLikeInsensitive(String value) {
            addCriterion("upper(content_keywords) like", value.toUpperCase(), "contentKeywords");
            return (Criteria) this;
        }

        public Criteria andTagsLikeInsensitive(String value) {
            addCriterion("upper(tags) like", value.toUpperCase(), "tags");
            return (Criteria) this;
        }

        public Criteria andTitleImageLikeInsensitive(String value) {
            addCriterion("upper(title_image) like", value.toUpperCase(), "titleImage");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateLikeInsensitive(String value) {
            addCriterion("upper(gene_template) like", value.toUpperCase(), "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andMGeneTemplateLikeInsensitive(String value) {
            addCriterion("upper(m_gene_template) like", value.toUpperCase(), "mGeneTemplate");
            return (Criteria) this;
        }

        public Criteria andPriceLikeInsensitive(String value) {
            addCriterion("upper(price) like", value.toUpperCase(), "price");
            return (Criteria) this;
        }

        public Criteria andMeasureLikeInsensitive(String value) {
            addCriterion("upper(measure) like", value.toUpperCase(), "measure");
            return (Criteria) this;
        }

        public Criteria andBrandNameLikeInsensitive(String value) {
            addCriterion("upper(brand_name) like", value.toUpperCase(), "brandName");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 pro_product
     *
     * @mbggenerated do_not_delete_during_merge 2016年05月08日 21时36分09秒 星期日
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 pro_product
     *
     * @mbggenerated 2016年05月08日 21时36分09秒 星期日
     */
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