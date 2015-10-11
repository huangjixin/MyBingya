package com.jcin.cms.modules.syst.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class LogCriteria {
    /**
     * 该字段对应数据库表 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    protected Page page;

    /**
     * 该字段对应数据库表 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public LogCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andRemoteAddrIsNull() {
            addCriterion("remote_addr is null");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrIsNotNull() {
            addCriterion("remote_addr is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrEqualTo(String value) {
            addCriterion("remote_addr =", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotEqualTo(String value) {
            addCriterion("remote_addr <>", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrGreaterThan(String value) {
            addCriterion("remote_addr >", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrGreaterThanOrEqualTo(String value) {
            addCriterion("remote_addr >=", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrLessThan(String value) {
            addCriterion("remote_addr <", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrLessThanOrEqualTo(String value) {
            addCriterion("remote_addr <=", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrLike(String value) {
            addCriterion("remote_addr like", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotLike(String value) {
            addCriterion("remote_addr not like", value, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrIn(List<String> values) {
            addCriterion("remote_addr in", values, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotIn(List<String> values) {
            addCriterion("remote_addr not in", values, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrBetween(String value1, String value2) {
            addCriterion("remote_addr between", value1, value2, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrNotBetween(String value1, String value2) {
            addCriterion("remote_addr not between", value1, value2, "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andUserAgentIsNull() {
            addCriterion("user_agent is null");
            return (Criteria) this;
        }

        public Criteria andUserAgentIsNotNull() {
            addCriterion("user_agent is not null");
            return (Criteria) this;
        }

        public Criteria andUserAgentEqualTo(String value) {
            addCriterion("user_agent =", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotEqualTo(String value) {
            addCriterion("user_agent <>", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentGreaterThan(String value) {
            addCriterion("user_agent >", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentGreaterThanOrEqualTo(String value) {
            addCriterion("user_agent >=", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLessThan(String value) {
            addCriterion("user_agent <", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLessThanOrEqualTo(String value) {
            addCriterion("user_agent <=", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLike(String value) {
            addCriterion("user_agent like", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotLike(String value) {
            addCriterion("user_agent not like", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentIn(List<String> values) {
            addCriterion("user_agent in", values, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotIn(List<String> values) {
            addCriterion("user_agent not in", values, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentBetween(String value1, String value2) {
            addCriterion("user_agent between", value1, value2, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotBetween(String value1, String value2) {
            addCriterion("user_agent not between", value1, value2, "userAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUriIsNull() {
            addCriterion("request_uri is null");
            return (Criteria) this;
        }

        public Criteria andRequestUriIsNotNull() {
            addCriterion("request_uri is not null");
            return (Criteria) this;
        }

        public Criteria andRequestUriEqualTo(String value) {
            addCriterion("request_uri =", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriNotEqualTo(String value) {
            addCriterion("request_uri <>", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriGreaterThan(String value) {
            addCriterion("request_uri >", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriGreaterThanOrEqualTo(String value) {
            addCriterion("request_uri >=", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriLessThan(String value) {
            addCriterion("request_uri <", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriLessThanOrEqualTo(String value) {
            addCriterion("request_uri <=", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriLike(String value) {
            addCriterion("request_uri like", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriNotLike(String value) {
            addCriterion("request_uri not like", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriIn(List<String> values) {
            addCriterion("request_uri in", values, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriNotIn(List<String> values) {
            addCriterion("request_uri not in", values, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriBetween(String value1, String value2) {
            addCriterion("request_uri between", value1, value2, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriNotBetween(String value1, String value2) {
            addCriterion("request_uri not between", value1, value2, "requestUri");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("Method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("Method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("Method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("Method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("Method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("Method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("Method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("Method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("Method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("Method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("Method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("Method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("Method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("Method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andParamsIsNull() {
            addCriterion("params is null");
            return (Criteria) this;
        }

        public Criteria andParamsIsNotNull() {
            addCriterion("params is not null");
            return (Criteria) this;
        }

        public Criteria andParamsEqualTo(String value) {
            addCriterion("params =", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotEqualTo(String value) {
            addCriterion("params <>", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThan(String value) {
            addCriterion("params >", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThanOrEqualTo(String value) {
            addCriterion("params >=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThan(String value) {
            addCriterion("params <", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThanOrEqualTo(String value) {
            addCriterion("params <=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLike(String value) {
            addCriterion("params like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotLike(String value) {
            addCriterion("params not like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsIn(List<String> values) {
            addCriterion("params in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotIn(List<String> values) {
            addCriterion("params not in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsBetween(String value1, String value2) {
            addCriterion("params between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotBetween(String value1, String value2) {
            addCriterion("params not between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andExceptionIsNull() {
            addCriterion("exception is null");
            return (Criteria) this;
        }

        public Criteria andExceptionIsNotNull() {
            addCriterion("exception is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionEqualTo(String value) {
            addCriterion("exception =", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionNotEqualTo(String value) {
            addCriterion("exception <>", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionGreaterThan(String value) {
            addCriterion("exception >", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionGreaterThanOrEqualTo(String value) {
            addCriterion("exception >=", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionLessThan(String value) {
            addCriterion("exception <", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionLessThanOrEqualTo(String value) {
            addCriterion("exception <=", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionLike(String value) {
            addCriterion("exception like", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionNotLike(String value) {
            addCriterion("exception not like", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionIn(List<String> values) {
            addCriterion("exception in", values, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionNotIn(List<String> values) {
            addCriterion("exception not in", values, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionBetween(String value1, String value2) {
            addCriterion("exception between", value1, value2, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionNotBetween(String value1, String value2) {
            addCriterion("exception not between", value1, value2, "exception");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andTypeLikeInsensitive(String value) {
            addCriterion("upper(type) like", value.toUpperCase(), "type");
            return (Criteria) this;
        }

        public Criteria andCreateByLikeInsensitive(String value) {
            addCriterion("upper(create_by) like", value.toUpperCase(), "createBy");
            return (Criteria) this;
        }

        public Criteria andRemoteAddrLikeInsensitive(String value) {
            addCriterion("upper(remote_addr) like", value.toUpperCase(), "remoteAddr");
            return (Criteria) this;
        }

        public Criteria andUserAgentLikeInsensitive(String value) {
            addCriterion("upper(user_agent) like", value.toUpperCase(), "userAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUriLikeInsensitive(String value) {
            addCriterion("upper(request_uri) like", value.toUpperCase(), "requestUri");
            return (Criteria) this;
        }

        public Criteria andMethodLikeInsensitive(String value) {
            addCriterion("upper(Method) like", value.toUpperCase(), "method");
            return (Criteria) this;
        }

        public Criteria andParamsLikeInsensitive(String value) {
            addCriterion("upper(params) like", value.toUpperCase(), "params");
            return (Criteria) this;
        }

        public Criteria andExceptionLikeInsensitive(String value) {
            addCriterion("upper(exception) like", value.toUpperCase(), "exception");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 log
     *
     * @mbggenerated do_not_delete_during_merge 2015年10月09日 16时24分46秒 星期五
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 log
     *
     * @mbggenerated 2015年10月09日 16时24分46秒 星期五
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