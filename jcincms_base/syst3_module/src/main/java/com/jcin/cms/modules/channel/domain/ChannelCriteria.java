package com.jcin.cms.modules.channel.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChannelCriteria {
    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    protected Page page;

    /**
     * 该字段对应数据库表 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public ChannelCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
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
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
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

        public Criteria andChannelTempleteIsNull() {
            addCriterion("channel_templete is null");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteIsNotNull() {
            addCriterion("channel_templete is not null");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteEqualTo(String value) {
            addCriterion("channel_templete =", value, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteNotEqualTo(String value) {
            addCriterion("channel_templete <>", value, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteGreaterThan(String value) {
            addCriterion("channel_templete >", value, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteGreaterThanOrEqualTo(String value) {
            addCriterion("channel_templete >=", value, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteLessThan(String value) {
            addCriterion("channel_templete <", value, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteLessThanOrEqualTo(String value) {
            addCriterion("channel_templete <=", value, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteLike(String value) {
            addCriterion("channel_templete like", value, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteNotLike(String value) {
            addCriterion("channel_templete not like", value, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteIn(List<String> values) {
            addCriterion("channel_templete in", values, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteNotIn(List<String> values) {
            addCriterion("channel_templete not in", values, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteBetween(String value1, String value2) {
            addCriterion("channel_templete between", value1, value2, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andChannelTempleteNotBetween(String value1, String value2) {
            addCriterion("channel_templete not between", value1, value2, "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteIsNull() {
            addCriterion("document_templete is null");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteIsNotNull() {
            addCriterion("document_templete is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteEqualTo(String value) {
            addCriterion("document_templete =", value, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteNotEqualTo(String value) {
            addCriterion("document_templete <>", value, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteGreaterThan(String value) {
            addCriterion("document_templete >", value, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteGreaterThanOrEqualTo(String value) {
            addCriterion("document_templete >=", value, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteLessThan(String value) {
            addCriterion("document_templete <", value, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteLessThanOrEqualTo(String value) {
            addCriterion("document_templete <=", value, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteLike(String value) {
            addCriterion("document_templete like", value, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteNotLike(String value) {
            addCriterion("document_templete not like", value, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteIn(List<String> values) {
            addCriterion("document_templete in", values, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteNotIn(List<String> values) {
            addCriterion("document_templete not in", values, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteBetween(String value1, String value2) {
            addCriterion("document_templete between", value1, value2, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteNotBetween(String value1, String value2) {
            addCriterion("document_templete not between", value1, value2, "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andHiddenIsNull() {
            addCriterion("hidden is null");
            return (Criteria) this;
        }

        public Criteria andHiddenIsNotNull() {
            addCriterion("hidden is not null");
            return (Criteria) this;
        }

        public Criteria andHiddenEqualTo(Boolean value) {
            addCriterion("hidden =", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotEqualTo(Boolean value) {
            addCriterion("hidden <>", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenGreaterThan(Boolean value) {
            addCriterion("hidden >", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hidden >=", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLessThan(Boolean value) {
            addCriterion("hidden <", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLessThanOrEqualTo(Boolean value) {
            addCriterion("hidden <=", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenIn(List<Boolean> values) {
            addCriterion("hidden in", values, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotIn(List<Boolean> values) {
            addCriterion("hidden not in", values, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenBetween(Boolean value1, Boolean value2) {
            addCriterion("hidden between", value1, value2, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hidden not between", value1, value2, "hidden");
            return (Criteria) this;
        }

        public Criteria andAsdocumentIsNull() {
            addCriterion("asdocument is null");
            return (Criteria) this;
        }

        public Criteria andAsdocumentIsNotNull() {
            addCriterion("asdocument is not null");
            return (Criteria) this;
        }

        public Criteria andAsdocumentEqualTo(Boolean value) {
            addCriterion("asdocument =", value, "asdocument");
            return (Criteria) this;
        }

        public Criteria andAsdocumentNotEqualTo(Boolean value) {
            addCriterion("asdocument <>", value, "asdocument");
            return (Criteria) this;
        }

        public Criteria andAsdocumentGreaterThan(Boolean value) {
            addCriterion("asdocument >", value, "asdocument");
            return (Criteria) this;
        }

        public Criteria andAsdocumentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("asdocument >=", value, "asdocument");
            return (Criteria) this;
        }

        public Criteria andAsdocumentLessThan(Boolean value) {
            addCriterion("asdocument <", value, "asdocument");
            return (Criteria) this;
        }

        public Criteria andAsdocumentLessThanOrEqualTo(Boolean value) {
            addCriterion("asdocument <=", value, "asdocument");
            return (Criteria) this;
        }

        public Criteria andAsdocumentIn(List<Boolean> values) {
            addCriterion("asdocument in", values, "asdocument");
            return (Criteria) this;
        }

        public Criteria andAsdocumentNotIn(List<Boolean> values) {
            addCriterion("asdocument not in", values, "asdocument");
            return (Criteria) this;
        }

        public Criteria andAsdocumentBetween(Boolean value1, Boolean value2) {
            addCriterion("asdocument between", value1, value2, "asdocument");
            return (Criteria) this;
        }

        public Criteria andAsdocumentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("asdocument not between", value1, value2, "asdocument");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIsNull() {
            addCriterion("document_id is null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIsNotNull() {
            addCriterion("document_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdEqualTo(String value) {
            addCriterion("document_id =", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotEqualTo(String value) {
            addCriterion("document_id <>", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThan(String value) {
            addCriterion("document_id >", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThanOrEqualTo(String value) {
            addCriterion("document_id >=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThan(String value) {
            addCriterion("document_id <", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThanOrEqualTo(String value) {
            addCriterion("document_id <=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLike(String value) {
            addCriterion("document_id like", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotLike(String value) {
            addCriterion("document_id not like", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIn(List<String> values) {
            addCriterion("document_id in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotIn(List<String> values) {
            addCriterion("document_id not in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdBetween(String value1, String value2) {
            addCriterion("document_id between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotBetween(String value1, String value2) {
            addCriterion("document_id not between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andParentIdsIsNull() {
            addCriterion("parent_ids is null");
            return (Criteria) this;
        }

        public Criteria andParentIdsIsNotNull() {
            addCriterion("parent_ids is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdsEqualTo(String value) {
            addCriterion("parent_ids =", value, "parentIds");
            return (Criteria) this;
        }

        public Criteria andParentIdsNotEqualTo(String value) {
            addCriterion("parent_ids <>", value, "parentIds");
            return (Criteria) this;
        }

        public Criteria andParentIdsGreaterThan(String value) {
            addCriterion("parent_ids >", value, "parentIds");
            return (Criteria) this;
        }

        public Criteria andParentIdsGreaterThanOrEqualTo(String value) {
            addCriterion("parent_ids >=", value, "parentIds");
            return (Criteria) this;
        }

        public Criteria andParentIdsLessThan(String value) {
            addCriterion("parent_ids <", value, "parentIds");
            return (Criteria) this;
        }

        public Criteria andParentIdsLessThanOrEqualTo(String value) {
            addCriterion("parent_ids <=", value, "parentIds");
            return (Criteria) this;
        }

        public Criteria andParentIdsLike(String value) {
            addCriterion("parent_ids like", value, "parentIds");
            return (Criteria) this;
        }

        public Criteria andParentIdsNotLike(String value) {
            addCriterion("parent_ids not like", value, "parentIds");
            return (Criteria) this;
        }

        public Criteria andParentIdsIn(List<String> values) {
            addCriterion("parent_ids in", values, "parentIds");
            return (Criteria) this;
        }

        public Criteria andParentIdsNotIn(List<String> values) {
            addCriterion("parent_ids not in", values, "parentIds");
            return (Criteria) this;
        }

        public Criteria andParentIdsBetween(String value1, String value2) {
            addCriterion("parent_ids between", value1, value2, "parentIds");
            return (Criteria) this;
        }

        public Criteria andParentIdsNotBetween(String value1, String value2) {
            addCriterion("parent_ids not between", value1, value2, "parentIds");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhIsNull() {
            addCriterion("link_addr_zh is null");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhIsNotNull() {
            addCriterion("link_addr_zh is not null");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhEqualTo(String value) {
            addCriterion("link_addr_zh =", value, "linkAddrZh");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhNotEqualTo(String value) {
            addCriterion("link_addr_zh <>", value, "linkAddrZh");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhGreaterThan(String value) {
            addCriterion("link_addr_zh >", value, "linkAddrZh");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhGreaterThanOrEqualTo(String value) {
            addCriterion("link_addr_zh >=", value, "linkAddrZh");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhLessThan(String value) {
            addCriterion("link_addr_zh <", value, "linkAddrZh");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhLessThanOrEqualTo(String value) {
            addCriterion("link_addr_zh <=", value, "linkAddrZh");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhLike(String value) {
            addCriterion("link_addr_zh like", value, "linkAddrZh");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhNotLike(String value) {
            addCriterion("link_addr_zh not like", value, "linkAddrZh");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhIn(List<String> values) {
            addCriterion("link_addr_zh in", values, "linkAddrZh");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhNotIn(List<String> values) {
            addCriterion("link_addr_zh not in", values, "linkAddrZh");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhBetween(String value1, String value2) {
            addCriterion("link_addr_zh between", value1, value2, "linkAddrZh");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhNotBetween(String value1, String value2) {
            addCriterion("link_addr_zh not between", value1, value2, "linkAddrZh");
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

        public Criteria andGeneTemplateIsNull() {
            addCriterion("gene_template is null");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateIsNotNull() {
            addCriterion("gene_template is not null");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateEqualTo(String value) {
            addCriterion("gene_template =", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateNotEqualTo(String value) {
            addCriterion("gene_template <>", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateGreaterThan(String value) {
            addCriterion("gene_template >", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("gene_template >=", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateLessThan(String value) {
            addCriterion("gene_template <", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateLessThanOrEqualTo(String value) {
            addCriterion("gene_template <=", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateLike(String value) {
            addCriterion("gene_template like", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateNotLike(String value) {
            addCriterion("gene_template not like", value, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateIn(List<String> values) {
            addCriterion("gene_template in", values, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateNotIn(List<String> values) {
            addCriterion("gene_template not in", values, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateBetween(String value1, String value2) {
            addCriterion("gene_template between", value1, value2, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andGeneTemplateNotBetween(String value1, String value2) {
            addCriterion("gene_template not between", value1, value2, "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
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

        public Criteria andChannelTempleteLikeInsensitive(String value) {
            addCriterion("upper(channel_templete) like", value.toUpperCase(), "channelTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteLikeInsensitive(String value) {
            addCriterion("upper(document_templete) like", value.toUpperCase(), "documentTemplete");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLikeInsensitive(String value) {
            addCriterion("upper(document_id) like", value.toUpperCase(), "documentId");
            return (Criteria) this;
        }

        public Criteria andParentIdsLikeInsensitive(String value) {
            addCriterion("upper(parent_ids) like", value.toUpperCase(), "parentIds");
            return (Criteria) this;
        }

        public Criteria andLinkAddrZhLikeInsensitive(String value) {
            addCriterion("upper(link_addr_zh) like", value.toUpperCase(), "linkAddrZh");
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

        public Criteria andGeneTemplateLikeInsensitive(String value) {
            addCriterion("upper(gene_template) like", value.toUpperCase(), "geneTemplate");
            return (Criteria) this;
        }

        public Criteria andImageLikeInsensitive(String value) {
            addCriterion("upper(image) like", value.toUpperCase(), "image");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 busi_channel
     *
     * @mbggenerated do_not_delete_during_merge 2015年12月31日 16时41分47秒 星期四
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 busi_channel
     *
     * @mbggenerated 2015年12月31日 16时41分47秒 星期四
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