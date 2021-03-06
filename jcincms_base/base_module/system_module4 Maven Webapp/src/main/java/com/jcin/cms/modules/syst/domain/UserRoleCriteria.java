package com.jcin.cms.modules.syst.domain;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class UserRoleCriteria {
    /**
     * 该字段对应数据库表 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    protected Page page;

    /**
     * 该字段对应数据库表 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public UserRoleCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
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

        public Criteria andTbRoleIdIsNull() {
            addCriterion("tb_role_id is null");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdIsNotNull() {
            addCriterion("tb_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdEqualTo(String value) {
            addCriterion("tb_role_id =", value, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdNotEqualTo(String value) {
            addCriterion("tb_role_id <>", value, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdGreaterThan(String value) {
            addCriterion("tb_role_id >", value, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("tb_role_id >=", value, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdLessThan(String value) {
            addCriterion("tb_role_id <", value, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdLessThanOrEqualTo(String value) {
            addCriterion("tb_role_id <=", value, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdLike(String value) {
            addCriterion("tb_role_id like", value, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdNotLike(String value) {
            addCriterion("tb_role_id not like", value, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdIn(List<String> values) {
            addCriterion("tb_role_id in", values, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdNotIn(List<String> values) {
            addCriterion("tb_role_id not in", values, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdBetween(String value1, String value2) {
            addCriterion("tb_role_id between", value1, value2, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdNotBetween(String value1, String value2) {
            addCriterion("tb_role_id not between", value1, value2, "tbRoleId");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andUserIdLikeInsensitive(String value) {
            addCriterion("upper(user_id) like", value.toUpperCase(), "userId");
            return (Criteria) this;
        }

        public Criteria andTbRoleIdLikeInsensitive(String value) {
            addCriterion("upper(tb_role_id) like", value.toUpperCase(), "tbRoleId");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 tb_user_role
     *
     * @mbggenerated do_not_delete_during_merge 2015年09月28日 15时16分35秒 星期一
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 tb_user_role
     *
     * @mbggenerated 2015年09月28日 15时16分35秒 星期一
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