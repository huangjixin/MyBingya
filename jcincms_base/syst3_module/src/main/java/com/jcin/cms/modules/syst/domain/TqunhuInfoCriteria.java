package com.jcin.cms.modules.syst.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class TqunhuInfoCriteria {
    /**
     * 该字段对应数据库表 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    protected Page page;

    /**
     * 该字段对应数据库表 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public TqunhuInfoCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
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

        public Criteria andCreateNameIsNull() {
            addCriterion("create_Name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_Name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_Name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_Name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_Name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_Name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_Name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_Name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_Name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_Name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_Name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_Name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_Name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_Name not between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("table_Name is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("table_Name is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("table_Name =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("table_Name <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("table_Name >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_Name >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("table_Name <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("table_Name <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("table_Name like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("table_Name not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("table_Name in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("table_Name not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("table_Name between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("table_Name not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTimesIsNull() {
            addCriterion("times is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("times is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(String value) {
            addCriterion("times =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(String value) {
            addCriterion("times <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(String value) {
            addCriterion("times >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(String value) {
            addCriterion("times >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(String value) {
            addCriterion("times <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(String value) {
            addCriterion("times <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLike(String value) {
            addCriterion("times like", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotLike(String value) {
            addCriterion("times not like", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<String> values) {
            addCriterion("times in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<String> values) {
            addCriterion("times not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(String value1, String value2) {
            addCriterion("times between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(String value1, String value2) {
            addCriterion("times not between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andCallbsIsNull() {
            addCriterion("callbs is null");
            return (Criteria) this;
        }

        public Criteria andCallbsIsNotNull() {
            addCriterion("callbs is not null");
            return (Criteria) this;
        }

        public Criteria andCallbsEqualTo(String value) {
            addCriterion("callbs =", value, "callbs");
            return (Criteria) this;
        }

        public Criteria andCallbsNotEqualTo(String value) {
            addCriterion("callbs <>", value, "callbs");
            return (Criteria) this;
        }

        public Criteria andCallbsGreaterThan(String value) {
            addCriterion("callbs >", value, "callbs");
            return (Criteria) this;
        }

        public Criteria andCallbsGreaterThanOrEqualTo(String value) {
            addCriterion("callbs >=", value, "callbs");
            return (Criteria) this;
        }

        public Criteria andCallbsLessThan(String value) {
            addCriterion("callbs <", value, "callbs");
            return (Criteria) this;
        }

        public Criteria andCallbsLessThanOrEqualTo(String value) {
            addCriterion("callbs <=", value, "callbs");
            return (Criteria) this;
        }

        public Criteria andCallbsLike(String value) {
            addCriterion("callbs like", value, "callbs");
            return (Criteria) this;
        }

        public Criteria andCallbsNotLike(String value) {
            addCriterion("callbs not like", value, "callbs");
            return (Criteria) this;
        }

        public Criteria andCallbsIn(List<String> values) {
            addCriterion("callbs in", values, "callbs");
            return (Criteria) this;
        }

        public Criteria andCallbsNotIn(List<String> values) {
            addCriterion("callbs not in", values, "callbs");
            return (Criteria) this;
        }

        public Criteria andCallbsBetween(String value1, String value2) {
            addCriterion("callbs between", value1, value2, "callbs");
            return (Criteria) this;
        }

        public Criteria andCallbsNotBetween(String value1, String value2) {
            addCriterion("callbs not between", value1, value2, "callbs");
            return (Criteria) this;
        }

        public Criteria andCountbIsNull() {
            addCriterion("countB is null");
            return (Criteria) this;
        }

        public Criteria andCountbIsNotNull() {
            addCriterion("countB is not null");
            return (Criteria) this;
        }

        public Criteria andCountbEqualTo(Integer value) {
            addCriterion("countB =", value, "countb");
            return (Criteria) this;
        }

        public Criteria andCountbNotEqualTo(Integer value) {
            addCriterion("countB <>", value, "countb");
            return (Criteria) this;
        }

        public Criteria andCountbGreaterThan(Integer value) {
            addCriterion("countB >", value, "countb");
            return (Criteria) this;
        }

        public Criteria andCountbGreaterThanOrEqualTo(Integer value) {
            addCriterion("countB >=", value, "countb");
            return (Criteria) this;
        }

        public Criteria andCountbLessThan(Integer value) {
            addCriterion("countB <", value, "countb");
            return (Criteria) this;
        }

        public Criteria andCountbLessThanOrEqualTo(Integer value) {
            addCriterion("countB <=", value, "countb");
            return (Criteria) this;
        }

        public Criteria andCountbIn(List<Integer> values) {
            addCriterion("countB in", values, "countb");
            return (Criteria) this;
        }

        public Criteria andCountbNotIn(List<Integer> values) {
            addCriterion("countB not in", values, "countb");
            return (Criteria) this;
        }

        public Criteria andCountbBetween(Integer value1, Integer value2) {
            addCriterion("countB between", value1, value2, "countb");
            return (Criteria) this;
        }

        public Criteria andCountbNotBetween(Integer value1, Integer value2) {
            addCriterion("countB not between", value1, value2, "countb");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andLeixingIsNull() {
            addCriterion("leixing is null");
            return (Criteria) this;
        }

        public Criteria andLeixingIsNotNull() {
            addCriterion("leixing is not null");
            return (Criteria) this;
        }

        public Criteria andLeixingEqualTo(Integer value) {
            addCriterion("leixing =", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotEqualTo(Integer value) {
            addCriterion("leixing <>", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingGreaterThan(Integer value) {
            addCriterion("leixing >", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingGreaterThanOrEqualTo(Integer value) {
            addCriterion("leixing >=", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLessThan(Integer value) {
            addCriterion("leixing <", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLessThanOrEqualTo(Integer value) {
            addCriterion("leixing <=", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingIn(List<Integer> values) {
            addCriterion("leixing in", values, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotIn(List<Integer> values) {
            addCriterion("leixing not in", values, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingBetween(Integer value1, Integer value2) {
            addCriterion("leixing between", value1, value2, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotBetween(Integer value1, Integer value2) {
            addCriterion("leixing not between", value1, value2, "leixing");
            return (Criteria) this;
        }

        public Criteria andCreateNameLikeInsensitive(String value) {
            addCriterion("upper(create_Name) like", value.toUpperCase(), "createName");
            return (Criteria) this;
        }

        public Criteria andTableNameLikeInsensitive(String value) {
            addCriterion("upper(table_Name) like", value.toUpperCase(), "tableName");
            return (Criteria) this;
        }

        public Criteria andTimesLikeInsensitive(String value) {
            addCriterion("upper(times) like", value.toUpperCase(), "times");
            return (Criteria) this;
        }

        public Criteria andCallbsLikeInsensitive(String value) {
            addCriterion("upper(callbs) like", value.toUpperCase(), "callbs");
            return (Criteria) this;
        }

        public Criteria andFilenameLikeInsensitive(String value) {
            addCriterion("upper(filename) like", value.toUpperCase(), "filename");
            return (Criteria) this;
        }

        public Criteria andIpLikeInsensitive(String value) {
            addCriterion("upper(ip) like", value.toUpperCase(), "ip");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 t_qunhu_info
     *
     * @mbggenerated do_not_delete_during_merge 2015年10月06日 15时46分58秒 星期二
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 t_qunhu_info
     *
     * @mbggenerated 2015年10月06日 15时46分58秒 星期二
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