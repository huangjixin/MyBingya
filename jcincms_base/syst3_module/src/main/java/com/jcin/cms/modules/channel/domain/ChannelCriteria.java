package com.jcin.cms.modules.channel.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class ChannelCriteria {
    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    protected Page page;

    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public ChannelCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andLinkAddrIsNull() {
            addCriterion("link_addr is null");
            return (Criteria) this;
        }

        public Criteria andLinkAddrIsNotNull() {
            addCriterion("link_addr is not null");
            return (Criteria) this;
        }

        public Criteria andLinkAddrEqualTo(String value) {
            addCriterion("link_addr =", value, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andLinkAddrNotEqualTo(String value) {
            addCriterion("link_addr <>", value, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andLinkAddrGreaterThan(String value) {
            addCriterion("link_addr >", value, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andLinkAddrGreaterThanOrEqualTo(String value) {
            addCriterion("link_addr >=", value, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andLinkAddrLessThan(String value) {
            addCriterion("link_addr <", value, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andLinkAddrLessThanOrEqualTo(String value) {
            addCriterion("link_addr <=", value, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andLinkAddrLike(String value) {
            addCriterion("link_addr like", value, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andLinkAddrNotLike(String value) {
            addCriterion("link_addr not like", value, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andLinkAddrIn(List<String> values) {
            addCriterion("link_addr in", values, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andLinkAddrNotIn(List<String> values) {
            addCriterion("link_addr not in", values, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andLinkAddrBetween(String value1, String value2) {
            addCriterion("link_addr between", value1, value2, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andLinkAddrNotBetween(String value1, String value2) {
            addCriterion("link_addr not between", value1, value2, "linkAddr");
            return (Criteria) this;
        }

        public Criteria andOpenModeIsNull() {
            addCriterion("open_mode is null");
            return (Criteria) this;
        }

        public Criteria andOpenModeIsNotNull() {
            addCriterion("open_mode is not null");
            return (Criteria) this;
        }

        public Criteria andOpenModeEqualTo(String value) {
            addCriterion("open_mode =", value, "openMode");
            return (Criteria) this;
        }

        public Criteria andOpenModeNotEqualTo(String value) {
            addCriterion("open_mode <>", value, "openMode");
            return (Criteria) this;
        }

        public Criteria andOpenModeGreaterThan(String value) {
            addCriterion("open_mode >", value, "openMode");
            return (Criteria) this;
        }

        public Criteria andOpenModeGreaterThanOrEqualTo(String value) {
            addCriterion("open_mode >=", value, "openMode");
            return (Criteria) this;
        }

        public Criteria andOpenModeLessThan(String value) {
            addCriterion("open_mode <", value, "openMode");
            return (Criteria) this;
        }

        public Criteria andOpenModeLessThanOrEqualTo(String value) {
            addCriterion("open_mode <=", value, "openMode");
            return (Criteria) this;
        }

        public Criteria andOpenModeLike(String value) {
            addCriterion("open_mode like", value, "openMode");
            return (Criteria) this;
        }

        public Criteria andOpenModeNotLike(String value) {
            addCriterion("open_mode not like", value, "openMode");
            return (Criteria) this;
        }

        public Criteria andOpenModeIn(List<String> values) {
            addCriterion("open_mode in", values, "openMode");
            return (Criteria) this;
        }

        public Criteria andOpenModeNotIn(List<String> values) {
            addCriterion("open_mode not in", values, "openMode");
            return (Criteria) this;
        }

        public Criteria andOpenModeBetween(String value1, String value2) {
            addCriterion("open_mode between", value1, value2, "openMode");
            return (Criteria) this;
        }

        public Criteria andOpenModeNotBetween(String value1, String value2) {
            addCriterion("open_mode not between", value1, value2, "openMode");
            return (Criteria) this;
        }

        public Criteria andDescritionIsNull() {
            addCriterion("descrition is null");
            return (Criteria) this;
        }

        public Criteria andDescritionIsNotNull() {
            addCriterion("descrition is not null");
            return (Criteria) this;
        }

        public Criteria andDescritionEqualTo(String value) {
            addCriterion("descrition =", value, "descrition");
            return (Criteria) this;
        }

        public Criteria andDescritionNotEqualTo(String value) {
            addCriterion("descrition <>", value, "descrition");
            return (Criteria) this;
        }

        public Criteria andDescritionGreaterThan(String value) {
            addCriterion("descrition >", value, "descrition");
            return (Criteria) this;
        }

        public Criteria andDescritionGreaterThanOrEqualTo(String value) {
            addCriterion("descrition >=", value, "descrition");
            return (Criteria) this;
        }

        public Criteria andDescritionLessThan(String value) {
            addCriterion("descrition <", value, "descrition");
            return (Criteria) this;
        }

        public Criteria andDescritionLessThanOrEqualTo(String value) {
            addCriterion("descrition <=", value, "descrition");
            return (Criteria) this;
        }

        public Criteria andDescritionLike(String value) {
            addCriterion("descrition like", value, "descrition");
            return (Criteria) this;
        }

        public Criteria andDescritionNotLike(String value) {
            addCriterion("descrition not like", value, "descrition");
            return (Criteria) this;
        }

        public Criteria andDescritionIn(List<String> values) {
            addCriterion("descrition in", values, "descrition");
            return (Criteria) this;
        }

        public Criteria andDescritionNotIn(List<String> values) {
            addCriterion("descrition not in", values, "descrition");
            return (Criteria) this;
        }

        public Criteria andDescritionBetween(String value1, String value2) {
            addCriterion("descrition between", value1, value2, "descrition");
            return (Criteria) this;
        }

        public Criteria andDescritionNotBetween(String value1, String value2) {
            addCriterion("descrition not between", value1, value2, "descrition");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
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

        public Criteria andCodeLikeInsensitive(String value) {
            addCriterion("upper(code) like", value.toUpperCase(), "code");
            return (Criteria) this;
        }

        public Criteria andKeywordLikeInsensitive(String value) {
            addCriterion("upper(keyword) like", value.toUpperCase(), "keyword");
            return (Criteria) this;
        }

        public Criteria andLinkAddrLikeInsensitive(String value) {
            addCriterion("upper(link_addr) like", value.toUpperCase(), "linkAddr");
            return (Criteria) this;
        }

        public Criteria andOpenModeLikeInsensitive(String value) {
            addCriterion("upper(open_mode) like", value.toUpperCase(), "openMode");
            return (Criteria) this;
        }

        public Criteria andDescritionLikeInsensitive(String value) {
            addCriterion("upper(descrition) like", value.toUpperCase(), "descrition");
            return (Criteria) this;
        }

        public Criteria andParentIdLikeInsensitive(String value) {
            addCriterion("upper(parent_id) like", value.toUpperCase(), "parentId");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 busi_channel
     *
     * @mbggenerated do_not_delete_during_merge 2015年10月17日 21时07分36秒 星期六
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 busi_channel
     *
     * @mbggenerated 2015年10月17日 21时07分36秒 星期六
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