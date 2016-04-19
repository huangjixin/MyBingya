package com.jcin.cms.modules.pro.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrandCriteria {
    /**
     * 该字段对应数据库表 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected Page page;

    /**
     * 该字段对应数据库表 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public BrandCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
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

        public Criteria andProCategoryIdIsNull() {
            addCriterion("pro_category_id is null");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdIsNotNull() {
            addCriterion("pro_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdEqualTo(String value) {
            addCriterion("pro_category_id =", value, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdNotEqualTo(String value) {
            addCriterion("pro_category_id <>", value, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdGreaterThan(String value) {
            addCriterion("pro_category_id >", value, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_category_id >=", value, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdLessThan(String value) {
            addCriterion("pro_category_id <", value, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("pro_category_id <=", value, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdLike(String value) {
            addCriterion("pro_category_id like", value, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdNotLike(String value) {
            addCriterion("pro_category_id not like", value, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdIn(List<String> values) {
            addCriterion("pro_category_id in", values, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdNotIn(List<String> values) {
            addCriterion("pro_category_id not in", values, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdBetween(String value1, String value2) {
            addCriterion("pro_category_id between", value1, value2, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdNotBetween(String value1, String value2) {
            addCriterion("pro_category_id not between", value1, value2, "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andZhNameIsNull() {
            addCriterion("zh_name is null");
            return (Criteria) this;
        }

        public Criteria andZhNameIsNotNull() {
            addCriterion("zh_name is not null");
            return (Criteria) this;
        }

        public Criteria andZhNameEqualTo(String value) {
            addCriterion("zh_name =", value, "zhName");
            return (Criteria) this;
        }

        public Criteria andZhNameNotEqualTo(String value) {
            addCriterion("zh_name <>", value, "zhName");
            return (Criteria) this;
        }

        public Criteria andZhNameGreaterThan(String value) {
            addCriterion("zh_name >", value, "zhName");
            return (Criteria) this;
        }

        public Criteria andZhNameGreaterThanOrEqualTo(String value) {
            addCriterion("zh_name >=", value, "zhName");
            return (Criteria) this;
        }

        public Criteria andZhNameLessThan(String value) {
            addCriterion("zh_name <", value, "zhName");
            return (Criteria) this;
        }

        public Criteria andZhNameLessThanOrEqualTo(String value) {
            addCriterion("zh_name <=", value, "zhName");
            return (Criteria) this;
        }

        public Criteria andZhNameLike(String value) {
            addCriterion("zh_name like", value, "zhName");
            return (Criteria) this;
        }

        public Criteria andZhNameNotLike(String value) {
            addCriterion("zh_name not like", value, "zhName");
            return (Criteria) this;
        }

        public Criteria andZhNameIn(List<String> values) {
            addCriterion("zh_name in", values, "zhName");
            return (Criteria) this;
        }

        public Criteria andZhNameNotIn(List<String> values) {
            addCriterion("zh_name not in", values, "zhName");
            return (Criteria) this;
        }

        public Criteria andZhNameBetween(String value1, String value2) {
            addCriterion("zh_name between", value1, value2, "zhName");
            return (Criteria) this;
        }

        public Criteria andZhNameNotBetween(String value1, String value2) {
            addCriterion("zh_name not between", value1, value2, "zhName");
            return (Criteria) this;
        }

        public Criteria andEnNameIsNull() {
            addCriterion("en_name is null");
            return (Criteria) this;
        }

        public Criteria andEnNameIsNotNull() {
            addCriterion("en_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnNameEqualTo(String value) {
            addCriterion("en_name =", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotEqualTo(String value) {
            addCriterion("en_name <>", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameGreaterThan(String value) {
            addCriterion("en_name >", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameGreaterThanOrEqualTo(String value) {
            addCriterion("en_name >=", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLessThan(String value) {
            addCriterion("en_name <", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLessThanOrEqualTo(String value) {
            addCriterion("en_name <=", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLike(String value) {
            addCriterion("en_name like", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotLike(String value) {
            addCriterion("en_name not like", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameIn(List<String> values) {
            addCriterion("en_name in", values, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotIn(List<String> values) {
            addCriterion("en_name not in", values, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameBetween(String value1, String value2) {
            addCriterion("en_name between", value1, value2, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotBetween(String value1, String value2) {
            addCriterion("en_name not between", value1, value2, "enName");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("website =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("website <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("website >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("website >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("website <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("website <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("website like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("website not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("website in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("website not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("website between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("website not between", value1, value2, "website");
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

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andProCategoryIdLikeInsensitive(String value) {
            addCriterion("upper(pro_category_id) like", value.toUpperCase(), "proCategoryId");
            return (Criteria) this;
        }

        public Criteria andZhNameLikeInsensitive(String value) {
            addCriterion("upper(zh_name) like", value.toUpperCase(), "zhName");
            return (Criteria) this;
        }

        public Criteria andEnNameLikeInsensitive(String value) {
            addCriterion("upper(en_name) like", value.toUpperCase(), "enName");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(status) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }

        public Criteria andWebsiteLikeInsensitive(String value) {
            addCriterion("upper(website) like", value.toUpperCase(), "website");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 pro_brand
     *
     * @mbggenerated do_not_delete_during_merge 2016年04月18日 10时57分01秒 星期一
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 pro_brand
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
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