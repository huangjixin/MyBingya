package com.jcin.cms.modules.bet.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FruitBetresultHistoryCriteria {
    /**
     * 该字段对应数据库表 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    protected Page page;

    /**
     * 该字段对应数据库表 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public FruitBetresultHistoryCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
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

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andDaIsNull() {
            addCriterion("da is null");
            return (Criteria) this;
        }

        public Criteria andDaIsNotNull() {
            addCriterion("da is not null");
            return (Criteria) this;
        }

        public Criteria andDaEqualTo(Double value) {
            addCriterion("da =", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaNotEqualTo(Double value) {
            addCriterion("da <>", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaGreaterThan(Double value) {
            addCriterion("da >", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaGreaterThanOrEqualTo(Double value) {
            addCriterion("da >=", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaLessThan(Double value) {
            addCriterion("da <", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaLessThanOrEqualTo(Double value) {
            addCriterion("da <=", value, "da");
            return (Criteria) this;
        }

        public Criteria andDaIn(List<Double> values) {
            addCriterion("da in", values, "da");
            return (Criteria) this;
        }

        public Criteria andDaNotIn(List<Double> values) {
            addCriterion("da not in", values, "da");
            return (Criteria) this;
        }

        public Criteria andDaBetween(Double value1, Double value2) {
            addCriterion("da between", value1, value2, "da");
            return (Criteria) this;
        }

        public Criteria andDaNotBetween(Double value1, Double value2) {
            addCriterion("da not between", value1, value2, "da");
            return (Criteria) this;
        }

        public Criteria andXiaoIsNull() {
            addCriterion("xiao is null");
            return (Criteria) this;
        }

        public Criteria andXiaoIsNotNull() {
            addCriterion("xiao is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoEqualTo(Double value) {
            addCriterion("xiao =", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoNotEqualTo(Double value) {
            addCriterion("xiao <>", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoGreaterThan(Double value) {
            addCriterion("xiao >", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoGreaterThanOrEqualTo(Double value) {
            addCriterion("xiao >=", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoLessThan(Double value) {
            addCriterion("xiao <", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoLessThanOrEqualTo(Double value) {
            addCriterion("xiao <=", value, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoIn(List<Double> values) {
            addCriterion("xiao in", values, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoNotIn(List<Double> values) {
            addCriterion("xiao not in", values, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoBetween(Double value1, Double value2) {
            addCriterion("xiao between", value1, value2, "xiao");
            return (Criteria) this;
        }

        public Criteria andXiaoNotBetween(Double value1, Double value2) {
            addCriterion("xiao not between", value1, value2, "xiao");
            return (Criteria) this;
        }

        public Criteria andDanIsNull() {
            addCriterion("dan is null");
            return (Criteria) this;
        }

        public Criteria andDanIsNotNull() {
            addCriterion("dan is not null");
            return (Criteria) this;
        }

        public Criteria andDanEqualTo(Double value) {
            addCriterion("dan =", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanNotEqualTo(Double value) {
            addCriterion("dan <>", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanGreaterThan(Double value) {
            addCriterion("dan >", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanGreaterThanOrEqualTo(Double value) {
            addCriterion("dan >=", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanLessThan(Double value) {
            addCriterion("dan <", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanLessThanOrEqualTo(Double value) {
            addCriterion("dan <=", value, "dan");
            return (Criteria) this;
        }

        public Criteria andDanIn(List<Double> values) {
            addCriterion("dan in", values, "dan");
            return (Criteria) this;
        }

        public Criteria andDanNotIn(List<Double> values) {
            addCriterion("dan not in", values, "dan");
            return (Criteria) this;
        }

        public Criteria andDanBetween(Double value1, Double value2) {
            addCriterion("dan between", value1, value2, "dan");
            return (Criteria) this;
        }

        public Criteria andDanNotBetween(Double value1, Double value2) {
            addCriterion("dan not between", value1, value2, "dan");
            return (Criteria) this;
        }

        public Criteria andShuangIsNull() {
            addCriterion("shuang is null");
            return (Criteria) this;
        }

        public Criteria andShuangIsNotNull() {
            addCriterion("shuang is not null");
            return (Criteria) this;
        }

        public Criteria andShuangEqualTo(Double value) {
            addCriterion("shuang =", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangNotEqualTo(Double value) {
            addCriterion("shuang <>", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangGreaterThan(Double value) {
            addCriterion("shuang >", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangGreaterThanOrEqualTo(Double value) {
            addCriterion("shuang >=", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangLessThan(Double value) {
            addCriterion("shuang <", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangLessThanOrEqualTo(Double value) {
            addCriterion("shuang <=", value, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangIn(List<Double> values) {
            addCriterion("shuang in", values, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangNotIn(List<Double> values) {
            addCriterion("shuang not in", values, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangBetween(Double value1, Double value2) {
            addCriterion("shuang between", value1, value2, "shuang");
            return (Criteria) this;
        }

        public Criteria andShuangNotBetween(Double value1, Double value2) {
            addCriterion("shuang not between", value1, value2, "shuang");
            return (Criteria) this;
        }

        public Criteria andPingguoIsNull() {
            addCriterion("pingguo is null");
            return (Criteria) this;
        }

        public Criteria andPingguoIsNotNull() {
            addCriterion("pingguo is not null");
            return (Criteria) this;
        }

        public Criteria andPingguoEqualTo(Double value) {
            addCriterion("pingguo =", value, "pingguo");
            return (Criteria) this;
        }

        public Criteria andPingguoNotEqualTo(Double value) {
            addCriterion("pingguo <>", value, "pingguo");
            return (Criteria) this;
        }

        public Criteria andPingguoGreaterThan(Double value) {
            addCriterion("pingguo >", value, "pingguo");
            return (Criteria) this;
        }

        public Criteria andPingguoGreaterThanOrEqualTo(Double value) {
            addCriterion("pingguo >=", value, "pingguo");
            return (Criteria) this;
        }

        public Criteria andPingguoLessThan(Double value) {
            addCriterion("pingguo <", value, "pingguo");
            return (Criteria) this;
        }

        public Criteria andPingguoLessThanOrEqualTo(Double value) {
            addCriterion("pingguo <=", value, "pingguo");
            return (Criteria) this;
        }

        public Criteria andPingguoIn(List<Double> values) {
            addCriterion("pingguo in", values, "pingguo");
            return (Criteria) this;
        }

        public Criteria andPingguoNotIn(List<Double> values) {
            addCriterion("pingguo not in", values, "pingguo");
            return (Criteria) this;
        }

        public Criteria andPingguoBetween(Double value1, Double value2) {
            addCriterion("pingguo between", value1, value2, "pingguo");
            return (Criteria) this;
        }

        public Criteria andPingguoNotBetween(Double value1, Double value2) {
            addCriterion("pingguo not between", value1, value2, "pingguo");
            return (Criteria) this;
        }

        public Criteria andPutaoIsNull() {
            addCriterion("putao is null");
            return (Criteria) this;
        }

        public Criteria andPutaoIsNotNull() {
            addCriterion("putao is not null");
            return (Criteria) this;
        }

        public Criteria andPutaoEqualTo(Double value) {
            addCriterion("putao =", value, "putao");
            return (Criteria) this;
        }

        public Criteria andPutaoNotEqualTo(Double value) {
            addCriterion("putao <>", value, "putao");
            return (Criteria) this;
        }

        public Criteria andPutaoGreaterThan(Double value) {
            addCriterion("putao >", value, "putao");
            return (Criteria) this;
        }

        public Criteria andPutaoGreaterThanOrEqualTo(Double value) {
            addCriterion("putao >=", value, "putao");
            return (Criteria) this;
        }

        public Criteria andPutaoLessThan(Double value) {
            addCriterion("putao <", value, "putao");
            return (Criteria) this;
        }

        public Criteria andPutaoLessThanOrEqualTo(Double value) {
            addCriterion("putao <=", value, "putao");
            return (Criteria) this;
        }

        public Criteria andPutaoIn(List<Double> values) {
            addCriterion("putao in", values, "putao");
            return (Criteria) this;
        }

        public Criteria andPutaoNotIn(List<Double> values) {
            addCriterion("putao not in", values, "putao");
            return (Criteria) this;
        }

        public Criteria andPutaoBetween(Double value1, Double value2) {
            addCriterion("putao between", value1, value2, "putao");
            return (Criteria) this;
        }

        public Criteria andPutaoNotBetween(Double value1, Double value2) {
            addCriterion("putao not between", value1, value2, "putao");
            return (Criteria) this;
        }

        public Criteria andBoluoIsNull() {
            addCriterion("boluo is null");
            return (Criteria) this;
        }

        public Criteria andBoluoIsNotNull() {
            addCriterion("boluo is not null");
            return (Criteria) this;
        }

        public Criteria andBoluoEqualTo(Double value) {
            addCriterion("boluo =", value, "boluo");
            return (Criteria) this;
        }

        public Criteria andBoluoNotEqualTo(Double value) {
            addCriterion("boluo <>", value, "boluo");
            return (Criteria) this;
        }

        public Criteria andBoluoGreaterThan(Double value) {
            addCriterion("boluo >", value, "boluo");
            return (Criteria) this;
        }

        public Criteria andBoluoGreaterThanOrEqualTo(Double value) {
            addCriterion("boluo >=", value, "boluo");
            return (Criteria) this;
        }

        public Criteria andBoluoLessThan(Double value) {
            addCriterion("boluo <", value, "boluo");
            return (Criteria) this;
        }

        public Criteria andBoluoLessThanOrEqualTo(Double value) {
            addCriterion("boluo <=", value, "boluo");
            return (Criteria) this;
        }

        public Criteria andBoluoIn(List<Double> values) {
            addCriterion("boluo in", values, "boluo");
            return (Criteria) this;
        }

        public Criteria andBoluoNotIn(List<Double> values) {
            addCriterion("boluo not in", values, "boluo");
            return (Criteria) this;
        }

        public Criteria andBoluoBetween(Double value1, Double value2) {
            addCriterion("boluo between", value1, value2, "boluo");
            return (Criteria) this;
        }

        public Criteria andBoluoNotBetween(Double value1, Double value2) {
            addCriterion("boluo not between", value1, value2, "boluo");
            return (Criteria) this;
        }

        public Criteria andCaomeiIsNull() {
            addCriterion("caomei is null");
            return (Criteria) this;
        }

        public Criteria andCaomeiIsNotNull() {
            addCriterion("caomei is not null");
            return (Criteria) this;
        }

        public Criteria andCaomeiEqualTo(Double value) {
            addCriterion("caomei =", value, "caomei");
            return (Criteria) this;
        }

        public Criteria andCaomeiNotEqualTo(Double value) {
            addCriterion("caomei <>", value, "caomei");
            return (Criteria) this;
        }

        public Criteria andCaomeiGreaterThan(Double value) {
            addCriterion("caomei >", value, "caomei");
            return (Criteria) this;
        }

        public Criteria andCaomeiGreaterThanOrEqualTo(Double value) {
            addCriterion("caomei >=", value, "caomei");
            return (Criteria) this;
        }

        public Criteria andCaomeiLessThan(Double value) {
            addCriterion("caomei <", value, "caomei");
            return (Criteria) this;
        }

        public Criteria andCaomeiLessThanOrEqualTo(Double value) {
            addCriterion("caomei <=", value, "caomei");
            return (Criteria) this;
        }

        public Criteria andCaomeiIn(List<Double> values) {
            addCriterion("caomei in", values, "caomei");
            return (Criteria) this;
        }

        public Criteria andCaomeiNotIn(List<Double> values) {
            addCriterion("caomei not in", values, "caomei");
            return (Criteria) this;
        }

        public Criteria andCaomeiBetween(Double value1, Double value2) {
            addCriterion("caomei between", value1, value2, "caomei");
            return (Criteria) this;
        }

        public Criteria andCaomeiNotBetween(Double value1, Double value2) {
            addCriterion("caomei not between", value1, value2, "caomei");
            return (Criteria) this;
        }

        public Criteria andXiguaIsNull() {
            addCriterion("xigua is null");
            return (Criteria) this;
        }

        public Criteria andXiguaIsNotNull() {
            addCriterion("xigua is not null");
            return (Criteria) this;
        }

        public Criteria andXiguaEqualTo(Double value) {
            addCriterion("xigua =", value, "xigua");
            return (Criteria) this;
        }

        public Criteria andXiguaNotEqualTo(Double value) {
            addCriterion("xigua <>", value, "xigua");
            return (Criteria) this;
        }

        public Criteria andXiguaGreaterThan(Double value) {
            addCriterion("xigua >", value, "xigua");
            return (Criteria) this;
        }

        public Criteria andXiguaGreaterThanOrEqualTo(Double value) {
            addCriterion("xigua >=", value, "xigua");
            return (Criteria) this;
        }

        public Criteria andXiguaLessThan(Double value) {
            addCriterion("xigua <", value, "xigua");
            return (Criteria) this;
        }

        public Criteria andXiguaLessThanOrEqualTo(Double value) {
            addCriterion("xigua <=", value, "xigua");
            return (Criteria) this;
        }

        public Criteria andXiguaIn(List<Double> values) {
            addCriterion("xigua in", values, "xigua");
            return (Criteria) this;
        }

        public Criteria andXiguaNotIn(List<Double> values) {
            addCriterion("xigua not in", values, "xigua");
            return (Criteria) this;
        }

        public Criteria andXiguaBetween(Double value1, Double value2) {
            addCriterion("xigua between", value1, value2, "xigua");
            return (Criteria) this;
        }

        public Criteria andXiguaNotBetween(Double value1, Double value2) {
            addCriterion("xigua not between", value1, value2, "xigua");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoIsNull() {
            addCriterion("xiangjiao is null");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoIsNotNull() {
            addCriterion("xiangjiao is not null");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoEqualTo(Double value) {
            addCriterion("xiangjiao =", value, "xiangjiao");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoNotEqualTo(Double value) {
            addCriterion("xiangjiao <>", value, "xiangjiao");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoGreaterThan(Double value) {
            addCriterion("xiangjiao >", value, "xiangjiao");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoGreaterThanOrEqualTo(Double value) {
            addCriterion("xiangjiao >=", value, "xiangjiao");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoLessThan(Double value) {
            addCriterion("xiangjiao <", value, "xiangjiao");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoLessThanOrEqualTo(Double value) {
            addCriterion("xiangjiao <=", value, "xiangjiao");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoIn(List<Double> values) {
            addCriterion("xiangjiao in", values, "xiangjiao");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoNotIn(List<Double> values) {
            addCriterion("xiangjiao not in", values, "xiangjiao");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoBetween(Double value1, Double value2) {
            addCriterion("xiangjiao between", value1, value2, "xiangjiao");
            return (Criteria) this;
        }

        public Criteria andXiangjiaoNotBetween(Double value1, Double value2) {
            addCriterion("xiangjiao not between", value1, value2, "xiangjiao");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andUpdateByLikeInsensitive(String value) {
            addCriterion("upper(update_by) like", value.toUpperCase(), "updateBy");
            return (Criteria) this;
        }

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(description) like", value.toUpperCase(), "description");
            return (Criteria) this;
        }

        public Criteria andUsernameLikeInsensitive(String value) {
            addCriterion("upper(username) like", value.toUpperCase(), "username");
            return (Criteria) this;
        }

        public Criteria andUserIdLikeInsensitive(String value) {
            addCriterion("upper(user_id) like", value.toUpperCase(), "userId");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 tb_fruit_betresult_history
     *
     * @mbggenerated do_not_delete_during_merge 2016年03月20日 11时25分56秒 星期日
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 tb_fruit_betresult_history
     *
     * @mbggenerated 2016年03月20日 11时25分56秒 星期日
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