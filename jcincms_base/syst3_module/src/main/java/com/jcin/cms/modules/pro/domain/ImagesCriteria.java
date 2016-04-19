package com.jcin.cms.modules.pro.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImagesCriteria {
    /**
     * 该字段对应数据库表 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected Page page;

    /**
     * 该字段对应数据库表 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public ImagesCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_images
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
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 pro_images
     *
     * @mbggenerated 2016年04月18日 10时57分01秒 星期一
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 pro_images
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

        public Criteria andSiteIsNull() {
            addCriterion("site is null");
            return (Criteria) this;
        }

        public Criteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (Criteria) this;
        }

        public Criteria andSiteEqualTo(String value) {
            addCriterion("site =", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotEqualTo(String value) {
            addCriterion("site <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(String value) {
            addCriterion("site >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(String value) {
            addCriterion("site >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(String value) {
            addCriterion("site <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(String value) {
            addCriterion("site <=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLike(String value) {
            addCriterion("site like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotLike(String value) {
            addCriterion("site not like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteIn(List<String> values) {
            addCriterion("site in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<String> values) {
            addCriterion("site not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(String value1, String value2) {
            addCriterion("site between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(String value1, String value2) {
            addCriterion("site not between", value1, value2, "site");
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

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andSortidIsNull() {
            addCriterion("sortid is null");
            return (Criteria) this;
        }

        public Criteria andSortidIsNotNull() {
            addCriterion("sortid is not null");
            return (Criteria) this;
        }

        public Criteria andSortidEqualTo(Integer value) {
            addCriterion("sortid =", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotEqualTo(Integer value) {
            addCriterion("sortid <>", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidGreaterThan(Integer value) {
            addCriterion("sortid >", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sortid >=", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidLessThan(Integer value) {
            addCriterion("sortid <", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidLessThanOrEqualTo(Integer value) {
            addCriterion("sortid <=", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidIn(List<Integer> values) {
            addCriterion("sortid in", values, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotIn(List<Integer> values) {
            addCriterion("sortid not in", values, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidBetween(Integer value1, Integer value2) {
            addCriterion("sortid between", value1, value2, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotBetween(Integer value1, Integer value2) {
            addCriterion("sortid not between", value1, value2, "sortid");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicIsNull() {
            addCriterion("ismasterpic is null");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicIsNotNull() {
            addCriterion("ismasterpic is not null");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicEqualTo(Byte value) {
            addCriterion("ismasterpic =", value, "ismasterpic");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicNotEqualTo(Byte value) {
            addCriterion("ismasterpic <>", value, "ismasterpic");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicGreaterThan(Byte value) {
            addCriterion("ismasterpic >", value, "ismasterpic");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicGreaterThanOrEqualTo(Byte value) {
            addCriterion("ismasterpic >=", value, "ismasterpic");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicLessThan(Byte value) {
            addCriterion("ismasterpic <", value, "ismasterpic");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicLessThanOrEqualTo(Byte value) {
            addCriterion("ismasterpic <=", value, "ismasterpic");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicIn(List<Byte> values) {
            addCriterion("ismasterpic in", values, "ismasterpic");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicNotIn(List<Byte> values) {
            addCriterion("ismasterpic not in", values, "ismasterpic");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicBetween(Byte value1, Byte value2) {
            addCriterion("ismasterpic between", value1, value2, "ismasterpic");
            return (Criteria) this;
        }

        public Criteria andIsmasterpicNotBetween(Byte value1, Byte value2) {
            addCriterion("ismasterpic not between", value1, value2, "ismasterpic");
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

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andSiteLikeInsensitive(String value) {
            addCriterion("upper(site) like", value.toUpperCase(), "site");
            return (Criteria) this;
        }

        public Criteria andProProductIdLikeInsensitive(String value) {
            addCriterion("upper(pro_product_id) like", value.toUpperCase(), "proProductId");
            return (Criteria) this;
        }

        public Criteria andPositionLikeInsensitive(String value) {
            addCriterion("upper(position) like", value.toUpperCase(), "position");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 pro_images
     *
     * @mbggenerated do_not_delete_during_merge 2016年04月18日 10时57分01秒 星期一
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 pro_images
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