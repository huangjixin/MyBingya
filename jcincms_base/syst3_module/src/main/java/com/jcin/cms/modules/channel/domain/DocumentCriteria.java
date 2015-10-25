package com.jcin.cms.modules.channel.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class DocumentCriteria {
    /**
     * 该字段对应数据库表 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    protected Page page;

    /**
     * 该字段对应数据库表 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public DocumentCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
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

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(String value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(String value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(String value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(String value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(String value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLike(String value) {
            addCriterion("channel_id like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotLike(String value) {
            addCriterion("channel_id not like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<String> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<String> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(String value1, String value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(String value1, String value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
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

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceAddrIsNull() {
            addCriterion("source_addr is null");
            return (Criteria) this;
        }

        public Criteria andSourceAddrIsNotNull() {
            addCriterion("source_addr is not null");
            return (Criteria) this;
        }

        public Criteria andSourceAddrEqualTo(String value) {
            addCriterion("source_addr =", value, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andSourceAddrNotEqualTo(String value) {
            addCriterion("source_addr <>", value, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andSourceAddrGreaterThan(String value) {
            addCriterion("source_addr >", value, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andSourceAddrGreaterThanOrEqualTo(String value) {
            addCriterion("source_addr >=", value, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andSourceAddrLessThan(String value) {
            addCriterion("source_addr <", value, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andSourceAddrLessThanOrEqualTo(String value) {
            addCriterion("source_addr <=", value, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andSourceAddrLike(String value) {
            addCriterion("source_addr like", value, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andSourceAddrNotLike(String value) {
            addCriterion("source_addr not like", value, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andSourceAddrIn(List<String> values) {
            addCriterion("source_addr in", values, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andSourceAddrNotIn(List<String> values) {
            addCriterion("source_addr not in", values, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andSourceAddrBetween(String value1, String value2) {
            addCriterion("source_addr between", value1, value2, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andSourceAddrNotBetween(String value1, String value2) {
            addCriterion("source_addr not between", value1, value2, "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andTitleImageIsNull() {
            addCriterion("title_image is null");
            return (Criteria) this;
        }

        public Criteria andTitleImageIsNotNull() {
            addCriterion("title_image is not null");
            return (Criteria) this;
        }

        public Criteria andTitleImageEqualTo(String value) {
            addCriterion("title_image =", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageNotEqualTo(String value) {
            addCriterion("title_image <>", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageGreaterThan(String value) {
            addCriterion("title_image >", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageGreaterThanOrEqualTo(String value) {
            addCriterion("title_image >=", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageLessThan(String value) {
            addCriterion("title_image <", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageLessThanOrEqualTo(String value) {
            addCriterion("title_image <=", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageLike(String value) {
            addCriterion("title_image like", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageNotLike(String value) {
            addCriterion("title_image not like", value, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageIn(List<String> values) {
            addCriterion("title_image in", values, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageNotIn(List<String> values) {
            addCriterion("title_image not in", values, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageBetween(String value1, String value2) {
            addCriterion("title_image between", value1, value2, "titleImage");
            return (Criteria) this;
        }

        public Criteria andTitleImageNotBetween(String value1, String value2) {
            addCriterion("title_image not between", value1, value2, "titleImage");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileAddrIsNull() {
            addCriterion("file_addr is null");
            return (Criteria) this;
        }

        public Criteria andFileAddrIsNotNull() {
            addCriterion("file_addr is not null");
            return (Criteria) this;
        }

        public Criteria andFileAddrEqualTo(String value) {
            addCriterion("file_addr =", value, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andFileAddrNotEqualTo(String value) {
            addCriterion("file_addr <>", value, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andFileAddrGreaterThan(String value) {
            addCriterion("file_addr >", value, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andFileAddrGreaterThanOrEqualTo(String value) {
            addCriterion("file_addr >=", value, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andFileAddrLessThan(String value) {
            addCriterion("file_addr <", value, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andFileAddrLessThanOrEqualTo(String value) {
            addCriterion("file_addr <=", value, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andFileAddrLike(String value) {
            addCriterion("file_addr like", value, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andFileAddrNotLike(String value) {
            addCriterion("file_addr not like", value, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andFileAddrIn(List<String> values) {
            addCriterion("file_addr in", values, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andFileAddrNotIn(List<String> values) {
            addCriterion("file_addr not in", values, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andFileAddrBetween(String value1, String value2) {
            addCriterion("file_addr between", value1, value2, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andFileAddrNotBetween(String value1, String value2) {
            addCriterion("file_addr not between", value1, value2, "fileAddr");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Long value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Long value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Long value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Long value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Long value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Long> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Long> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Long value1, Long value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Long value1, Long value2) {
            addCriterion("size not between", value1, value2, "size");
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

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andChannelIdLikeInsensitive(String value) {
            addCriterion("upper(channel_id) like", value.toUpperCase(), "channelId");
            return (Criteria) this;
        }

        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("upper(title) like", value.toUpperCase(), "title");
            return (Criteria) this;
        }

        public Criteria andColorLikeInsensitive(String value) {
            addCriterion("upper(color) like", value.toUpperCase(), "color");
            return (Criteria) this;
        }

        public Criteria andKeywordLikeInsensitive(String value) {
            addCriterion("upper(keyword) like", value.toUpperCase(), "keyword");
            return (Criteria) this;
        }

        public Criteria andDescritionLikeInsensitive(String value) {
            addCriterion("upper(descrition) like", value.toUpperCase(), "descrition");
            return (Criteria) this;
        }

        public Criteria andSourceLikeInsensitive(String value) {
            addCriterion("upper(source) like", value.toUpperCase(), "source");
            return (Criteria) this;
        }

        public Criteria andSourceAddrLikeInsensitive(String value) {
            addCriterion("upper(source_addr) like", value.toUpperCase(), "sourceAddr");
            return (Criteria) this;
        }

        public Criteria andAuthorLikeInsensitive(String value) {
            addCriterion("upper(author) like", value.toUpperCase(), "author");
            return (Criteria) this;
        }

        public Criteria andTitleImageLikeInsensitive(String value) {
            addCriterion("upper(title_image) like", value.toUpperCase(), "titleImage");
            return (Criteria) this;
        }

        public Criteria andFileNameLikeInsensitive(String value) {
            addCriterion("upper(file_name) like", value.toUpperCase(), "fileName");
            return (Criteria) this;
        }

        public Criteria andFileAddrLikeInsensitive(String value) {
            addCriterion("upper(file_addr) like", value.toUpperCase(), "fileAddr");
            return (Criteria) this;
        }

        public Criteria andDocumentTempleteLikeInsensitive(String value) {
            addCriterion("upper(document_templete) like", value.toUpperCase(), "documentTemplete");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 busi_document
     *
     * @mbggenerated do_not_delete_during_merge 2015年10月25日 10时28分23秒 星期日
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 busi_document
     *
     * @mbggenerated 2015年10月25日 10时28分23秒 星期日
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