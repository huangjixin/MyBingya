package com.jcin.cms.modules.sale.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class StorageCriteria {
    /**
     * 该字段对应数据库表 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    protected Page page;

    /**
     * 该字段对应数据库表 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public StorageCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
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

        public Criteria andBuyIdIsNull() {
            addCriterion("buy_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyIdIsNotNull() {
            addCriterion("buy_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyIdEqualTo(String value) {
            addCriterion("buy_id =", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotEqualTo(String value) {
            addCriterion("buy_id <>", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdGreaterThan(String value) {
            addCriterion("buy_id >", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdGreaterThanOrEqualTo(String value) {
            addCriterion("buy_id >=", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLessThan(String value) {
            addCriterion("buy_id <", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLessThanOrEqualTo(String value) {
            addCriterion("buy_id <=", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLike(String value) {
            addCriterion("buy_id like", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotLike(String value) {
            addCriterion("buy_id not like", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdIn(List<String> values) {
            addCriterion("buy_id in", values, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotIn(List<String> values) {
            addCriterion("buy_id not in", values, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdBetween(String value1, String value2) {
            addCriterion("buy_id between", value1, value2, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotBetween(String value1, String value2) {
            addCriterion("buy_id not between", value1, value2, "buyId");
            return (Criteria) this;
        }

        public Criteria andSaleIdIsNull() {
            addCriterion("sale_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleIdIsNotNull() {
            addCriterion("sale_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleIdEqualTo(String value) {
            addCriterion("sale_id =", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdNotEqualTo(String value) {
            addCriterion("sale_id <>", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdGreaterThan(String value) {
            addCriterion("sale_id >", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdGreaterThanOrEqualTo(String value) {
            addCriterion("sale_id >=", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdLessThan(String value) {
            addCriterion("sale_id <", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdLessThanOrEqualTo(String value) {
            addCriterion("sale_id <=", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdLike(String value) {
            addCriterion("sale_id like", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdNotLike(String value) {
            addCriterion("sale_id not like", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdIn(List<String> values) {
            addCriterion("sale_id in", values, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdNotIn(List<String> values) {
            addCriterion("sale_id not in", values, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdBetween(String value1, String value2) {
            addCriterion("sale_id between", value1, value2, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdNotBetween(String value1, String value2) {
            addCriterion("sale_id not between", value1, value2, "saleId");
            return (Criteria) this;
        }

        public Criteria andProcountIsNull() {
            addCriterion("procount is null");
            return (Criteria) this;
        }

        public Criteria andProcountIsNotNull() {
            addCriterion("procount is not null");
            return (Criteria) this;
        }

        public Criteria andProcountEqualTo(Double value) {
            addCriterion("procount =", value, "procount");
            return (Criteria) this;
        }

        public Criteria andProcountNotEqualTo(Double value) {
            addCriterion("procount <>", value, "procount");
            return (Criteria) this;
        }

        public Criteria andProcountGreaterThan(Double value) {
            addCriterion("procount >", value, "procount");
            return (Criteria) this;
        }

        public Criteria andProcountGreaterThanOrEqualTo(Double value) {
            addCriterion("procount >=", value, "procount");
            return (Criteria) this;
        }

        public Criteria andProcountLessThan(Double value) {
            addCriterion("procount <", value, "procount");
            return (Criteria) this;
        }

        public Criteria andProcountLessThanOrEqualTo(Double value) {
            addCriterion("procount <=", value, "procount");
            return (Criteria) this;
        }

        public Criteria andProcountIn(List<Double> values) {
            addCriterion("procount in", values, "procount");
            return (Criteria) this;
        }

        public Criteria andProcountNotIn(List<Double> values) {
            addCriterion("procount not in", values, "procount");
            return (Criteria) this;
        }

        public Criteria andProcountBetween(Double value1, Double value2) {
            addCriterion("procount between", value1, value2, "procount");
            return (Criteria) this;
        }

        public Criteria andProcountNotBetween(Double value1, Double value2) {
            addCriterion("procount not between", value1, value2, "procount");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andProNameLikeInsensitive(String value) {
            addCriterion("upper(pro_name) like", value.toUpperCase(), "proName");
            return (Criteria) this;
        }

        public Criteria andProIdLikeInsensitive(String value) {
            addCriterion("upper(pro_id) like", value.toUpperCase(), "proId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLikeInsensitive(String value) {
            addCriterion("upper(buy_id) like", value.toUpperCase(), "buyId");
            return (Criteria) this;
        }

        public Criteria andSaleIdLikeInsensitive(String value) {
            addCriterion("upper(sale_id) like", value.toUpperCase(), "saleId");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 tb_storage
     *
     * @mbggenerated do_not_delete_during_merge 2016年03月22日 12时16分55秒 星期二
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 tb_storage
     *
     * @mbggenerated 2016年03月22日 12时16分55秒 星期二
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