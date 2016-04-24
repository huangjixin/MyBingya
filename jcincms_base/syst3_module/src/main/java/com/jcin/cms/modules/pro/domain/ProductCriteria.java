package com.jcin.cms.modules.pro.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCriteria {
    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    protected Page page;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public ProductCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
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
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
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
    }

    /**
     * 该类对应于数据库表 pro_product
     *
     * @mbggenerated do_not_delete_during_merge 2016年04月24日 22时08分17秒 星期日
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 pro_product
     *
     * @mbggenerated 2016年04月24日 22时08分17秒 星期日
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