package com.jcin.cms.domain.system;

import com.jcin.cms.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class UserGroupRoleCriteria {
    /**
     * 该字段对应数据库表 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    protected String orderByClause;

    /**
     * 该字段对应数据库表 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    protected boolean distinct;

    /**
     * 该字段对应数据库表 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    protected List<Criteria> oredCriteria;

    /**
     * 该字段对应数据库表 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    protected Page page;

    /**
     * 该字段对应数据库表 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    private String dialect = "mysql";

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public UserGroupRoleCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public Page getPage() {
        return page;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public void setDialect(String dialect) {
        this.dialect=dialect;
    }

    /**
     * 该方法由系统生成 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
     */
    public String getDialect() {
        return dialect;
    }

    /**
     * 该类对应于数据库表 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("role_id like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("role_id not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIsNull() {
            addCriterion("user_group_id is null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIsNotNull() {
            addCriterion("user_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdEqualTo(String value) {
            addCriterion("user_group_id =", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotEqualTo(String value) {
            addCriterion("user_group_id <>", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdGreaterThan(String value) {
            addCriterion("user_group_id >", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_group_id >=", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLessThan(String value) {
            addCriterion("user_group_id <", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLessThanOrEqualTo(String value) {
            addCriterion("user_group_id <=", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLike(String value) {
            addCriterion("user_group_id like", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotLike(String value) {
            addCriterion("user_group_id not like", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIn(List<String> values) {
            addCriterion("user_group_id in", values, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotIn(List<String> values) {
            addCriterion("user_group_id not in", values, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdBetween(String value1, String value2) {
            addCriterion("user_group_id between", value1, value2, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotBetween(String value1, String value2) {
            addCriterion("user_group_id not between", value1, value2, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andRoleIdLikeInsensitive(String value) {
            addCriterion("upper(role_id) like", value.toUpperCase(), "roleId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLikeInsensitive(String value) {
            addCriterion("upper(user_group_id) like", value.toUpperCase(), "userGroupId");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应于数据库表 tb_user_group_role
     *
     * @mbggenerated do_not_delete_during_merge 2015年06月26日 11时27分42秒 星期五
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应于数据库表 tb_user_group_role
     *
     * @mbggenerated 2015年06月26日 11时27分42秒 星期五
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