package com.jcin.cms.modules.pro.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class ProductValueCriteria {
    /**
     * 该字段对应数据库表 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected Page page;

    /**
     * 该字段对应数据库表 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public ProductValueCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_product_value
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
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 pro_product_value
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 pro_product_value
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

        public Criteria andProProductIdIsNull() {
            addCriterion("pro_product_id is null");
            return (Criteria) this;
        }

        public Criteria andProProductIdIsNotNull() {
            addCriterion("pro_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProProductIdEqualTo(String value) {
            addCriterion("pro_product_id =", value, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProductIdNotEqualTo(String value) {
            addCriterion("pro_product_id <>", value, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProductIdGreaterThan(String value) {
            addCriterion("pro_product_id >", value, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_product_id >=", value, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProductIdLessThan(String value) {
            addCriterion("pro_product_id <", value, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProductIdLessThanOrEqualTo(String value) {
            addCriterion("pro_product_id <=", value, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProductIdLike(String value) {
            addCriterion("pro_product_id like", value, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProductIdNotLike(String value) {
            addCriterion("pro_product_id not like", value, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProductIdIn(List<String> values) {
            addCriterion("pro_product_id in", values, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProductIdNotIn(List<String> values) {
            addCriterion("pro_product_id not in", values, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProductIdBetween(String value1, String value2) {
            addCriterion("pro_product_id between", value1, value2, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProductIdNotBetween(String value1, String value2) {
            addCriterion("pro_product_id not between", value1, value2, "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdIsNull() {
            addCriterion("pro_proerties_id is null");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdIsNotNull() {
            addCriterion("pro_proerties_id is not null");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdEqualTo(String value) {
            addCriterion("pro_proerties_id =", value, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdNotEqualTo(String value) {
            addCriterion("pro_proerties_id <>", value, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdGreaterThan(String value) {
            addCriterion("pro_proerties_id >", value, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_proerties_id >=", value, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdLessThan(String value) {
            addCriterion("pro_proerties_id <", value, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdLessThanOrEqualTo(String value) {
            addCriterion("pro_proerties_id <=", value, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdLike(String value) {
            addCriterion("pro_proerties_id like", value, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdNotLike(String value) {
            addCriterion("pro_proerties_id not like", value, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdIn(List<String> values) {
            addCriterion("pro_proerties_id in", values, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdNotIn(List<String> values) {
            addCriterion("pro_proerties_id not in", values, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdBetween(String value1, String value2) {
            addCriterion("pro_proerties_id between", value1, value2, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdNotBetween(String value1, String value2) {
            addCriterion("pro_proerties_id not between", value1, value2, "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProValueIdIsNull() {
            addCriterion("pro_value_id is null");
            return (Criteria) this;
        }

        public Criteria andProValueIdIsNotNull() {
            addCriterion("pro_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andProValueIdEqualTo(String value) {
            addCriterion("pro_value_id =", value, "proValueId");
            return (Criteria) this;
        }

        public Criteria andProValueIdNotEqualTo(String value) {
            addCriterion("pro_value_id <>", value, "proValueId");
            return (Criteria) this;
        }

        public Criteria andProValueIdGreaterThan(String value) {
            addCriterion("pro_value_id >", value, "proValueId");
            return (Criteria) this;
        }

        public Criteria andProValueIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_value_id >=", value, "proValueId");
            return (Criteria) this;
        }

        public Criteria andProValueIdLessThan(String value) {
            addCriterion("pro_value_id <", value, "proValueId");
            return (Criteria) this;
        }

        public Criteria andProValueIdLessThanOrEqualTo(String value) {
            addCriterion("pro_value_id <=", value, "proValueId");
            return (Criteria) this;
        }

        public Criteria andProValueIdLike(String value) {
            addCriterion("pro_value_id like", value, "proValueId");
            return (Criteria) this;
        }

        public Criteria andProValueIdNotLike(String value) {
            addCriterion("pro_value_id not like", value, "proValueId");
            return (Criteria) this;
        }

        public Criteria andProValueIdIn(List<String> values) {
            addCriterion("pro_value_id in", values, "proValueId");
            return (Criteria) this;
        }

        public Criteria andProValueIdNotIn(List<String> values) {
            addCriterion("pro_value_id not in", values, "proValueId");
            return (Criteria) this;
        }

        public Criteria andProValueIdBetween(String value1, String value2) {
            addCriterion("pro_value_id between", value1, value2, "proValueId");
            return (Criteria) this;
        }

        public Criteria andProValueIdNotBetween(String value1, String value2) {
            addCriterion("pro_value_id not between", value1, value2, "proValueId");
            return (Criteria) this;
        }

        public Criteria andIsSkuIsNull() {
            addCriterion("is_sku is null");
            return (Criteria) this;
        }

        public Criteria andIsSkuIsNotNull() {
            addCriterion("is_sku is not null");
            return (Criteria) this;
        }

        public Criteria andIsSkuEqualTo(Byte value) {
            addCriterion("is_sku =", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuNotEqualTo(Byte value) {
            addCriterion("is_sku <>", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuGreaterThan(Byte value) {
            addCriterion("is_sku >", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_sku >=", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuLessThan(Byte value) {
            addCriterion("is_sku <", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuLessThanOrEqualTo(Byte value) {
            addCriterion("is_sku <=", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuIn(List<Byte> values) {
            addCriterion("is_sku in", values, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuNotIn(List<Byte> values) {
            addCriterion("is_sku not in", values, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuBetween(Byte value1, Byte value2) {
            addCriterion("is_sku between", value1, value2, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuNotBetween(Byte value1, Byte value2) {
            addCriterion("is_sku not between", value1, value2, "isSku");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(String value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(String value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(String value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(String value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(String value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(String value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLike(String value) {
            addCriterion("sku_id like", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotLike(String value) {
            addCriterion("sku_id not like", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<String> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<String> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(String value1, String value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(String value1, String value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andProProductIdLikeInsensitive(String value) {
            addCriterion("upper(pro_product_id) like", value.toUpperCase(), "proProductId");
            return (Criteria) this;
        }

        public Criteria andProProertiesIdLikeInsensitive(String value) {
            addCriterion("upper(pro_proerties_id) like", value.toUpperCase(), "proProertiesId");
            return (Criteria) this;
        }

        public Criteria andProValueIdLikeInsensitive(String value) {
            addCriterion("upper(pro_value_id) like", value.toUpperCase(), "proValueId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLikeInsensitive(String value) {
            addCriterion("upper(sku_id) like", value.toUpperCase(), "skuId");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 pro_product_value
     *
     * @mbggenerated do_not_delete_during_merge 2016年04月18日 10时57分01秒 星期一
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 pro_product_value
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