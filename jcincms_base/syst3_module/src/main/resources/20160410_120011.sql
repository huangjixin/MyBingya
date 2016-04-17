public Criteria andMemberLebelIdIsNull() {
            addCriterion("member_bebel_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdIsNotNull() {
            addCriterion("member_bebel_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdEqualTo(String value) {
            addCriterion("member_bebel_id =", value, "memberLebelId");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdNotEqualTo(String value) {
            addCriterion("member_bebel_id <>", value, "memberLebelId");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdGreaterThan(String value) {
            addCriterion("member_bebel_id >", value, "memberLebelId");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdGreaterThanOrEqualTo(String value) {
            addCriterion("member_bebel_id >=", value, "memberLebelId");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdLessThan(String value) {
            addCriterion("member_bebel_id <", value, "memberLebelId");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdLessThanOrEqualTo(String value) {
            addCriterion("member_bebel_id <=", value, "memberLebelId");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdLike(String value) {
            addCriterion("member_bebel_id like", value, "memberLebelId");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdNotLike(String value) {
            addCriterion("member_bebel_id not like", value, "memberLebelId");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdIn(List<String> values) {
            addCriterion("member_bebel_id in", values, "memberLebelId");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdNotIn(List<String> values) {
            addCriterion("member_bebel_id not in", values, "memberLebelId");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdBetween(String value1, String value2) {
            addCriterion("member_bebel_id between", value1, value2, "memberLebelId");
            return (Criteria) this;
        }

        public Criteria andMemberLebelIdNotBetween(String value1, String value2) {
            addCriterion("member_bebel_id not between", value1, value2, "memberLebelId");
            return (Criteria) this;
        }