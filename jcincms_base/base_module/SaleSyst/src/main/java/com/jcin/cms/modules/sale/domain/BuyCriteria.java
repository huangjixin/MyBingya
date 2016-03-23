package com.jcin.cms.modules.sale.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuyCriteria {
    /**
     * 该字段对应数据库表 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    protected Page page;

    /**
     * 该字段对应数据库表 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public BuyCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
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

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(String value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(String value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(String value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(String value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(String value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLike(String value) {
            addCriterion("pro_id like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotLike(String value) {
            addCriterion("pro_id not like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<String> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<String> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(String value1, String value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(String value1, String value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andBuyNumIsNull() {
            addCriterion("buy_num is null");
            return (Criteria) this;
        }

        public Criteria andBuyNumIsNotNull() {
            addCriterion("buy_num is not null");
            return (Criteria) this;
        }

        public Criteria andBuyNumEqualTo(Double value) {
            addCriterion("buy_num =", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumNotEqualTo(Double value) {
            addCriterion("buy_num <>", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumGreaterThan(Double value) {
            addCriterion("buy_num >", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumGreaterThanOrEqualTo(Double value) {
            addCriterion("buy_num >=", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumLessThan(Double value) {
            addCriterion("buy_num <", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumLessThanOrEqualTo(Double value) {
            addCriterion("buy_num <=", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumIn(List<Double> values) {
            addCriterion("buy_num in", values, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumNotIn(List<Double> values) {
            addCriterion("buy_num not in", values, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumBetween(Double value1, Double value2) {
            addCriterion("buy_num between", value1, value2, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumNotBetween(Double value1, Double value2) {
            addCriterion("buy_num not between", value1, value2, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyAmountIsNull() {
            addCriterion("buy_amount is null");
            return (Criteria) this;
        }

        public Criteria andBuyAmountIsNotNull() {
            addCriterion("buy_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBuyAmountEqualTo(Double value) {
            addCriterion("buy_amount =", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountNotEqualTo(Double value) {
            addCriterion("buy_amount <>", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountGreaterThan(Double value) {
            addCriterion("buy_amount >", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("buy_amount >=", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountLessThan(Double value) {
            addCriterion("buy_amount <", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountLessThanOrEqualTo(Double value) {
            addCriterion("buy_amount <=", value, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountIn(List<Double> values) {
            addCriterion("buy_amount in", values, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountNotIn(List<Double> values) {
            addCriterion("buy_amount not in", values, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountBetween(Double value1, Double value2) {
            addCriterion("buy_amount between", value1, value2, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andBuyAmountNotBetween(Double value1, Double value2) {
            addCriterion("buy_amount not between", value1, value2, "buyAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(Double value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(Double value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(Double value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(Double value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(Double value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<Double> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<Double> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(Double value1, Double value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(Double value1, Double value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andCreateByLikeInsensitive(String value) {
            addCriterion("upper(create_by) like", value.toUpperCase(), "createBy");
            return (Criteria) this;
        }

        public Criteria andProIdLikeInsensitive(String value) {
            addCriterion("upper(pro_id) like", value.toUpperCase(), "proId");
            return (Criteria) this;
        }

        public Criteria andProNameLikeInsensitive(String value) {
            addCriterion("upper(pro_name) like", value.toUpperCase(), "proName");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 tb_buy
     *
     * @mbggenerated do_not_delete_during_merge 2016年03月21日 10时09分54秒 星期一
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 tb_buy
     *
     * @mbggenerated 2016年03月21日 10时09分54秒 星期一
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