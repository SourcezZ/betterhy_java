package com.betterhy.db.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaAuthJnlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OaAuthJnlExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andAuthIdIsNull() {
            addCriterion("AUTH_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthIdIsNotNull() {
            addCriterion("AUTH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthIdEqualTo(Long value) {
            addCriterion("AUTH_ID =", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotEqualTo(Long value) {
            addCriterion("AUTH_ID <>", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThan(Long value) {
            addCriterion("AUTH_ID >", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThanOrEqualTo(Long value) {
            addCriterion("AUTH_ID >=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThan(Long value) {
            addCriterion("AUTH_ID <", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThanOrEqualTo(Long value) {
            addCriterion("AUTH_ID <=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdIn(List<Long> values) {
            addCriterion("AUTH_ID in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotIn(List<Long> values) {
            addCriterion("AUTH_ID not in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdBetween(Long value1, Long value2) {
            addCriterion("AUTH_ID between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotBetween(Long value1, Long value2) {
            addCriterion("AUTH_ID not between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNull() {
            addCriterion("APPLY_ID is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("APPLY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(Long value) {
            addCriterion("APPLY_ID =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(Long value) {
            addCriterion("APPLY_ID <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(Long value) {
            addCriterion("APPLY_ID >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("APPLY_ID >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(Long value) {
            addCriterion("APPLY_ID <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Long value) {
            addCriterion("APPLY_ID <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<Long> values) {
            addCriterion("APPLY_ID in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<Long> values) {
            addCriterion("APPLY_ID not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(Long value1, Long value2) {
            addCriterion("APPLY_ID between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(Long value1, Long value2) {
            addCriterion("APPLY_ID not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNull() {
            addCriterion("APPLY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNotNull() {
            addCriterion("APPLY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeEqualTo(Integer value) {
            addCriterion("APPLY_TYPE =", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotEqualTo(Integer value) {
            addCriterion("APPLY_TYPE <>", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThan(Integer value) {
            addCriterion("APPLY_TYPE >", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("APPLY_TYPE >=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThan(Integer value) {
            addCriterion("APPLY_TYPE <", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("APPLY_TYPE <=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIn(List<Integer> values) {
            addCriterion("APPLY_TYPE in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotIn(List<Integer> values) {
            addCriterion("APPLY_TYPE not in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeBetween(Integer value1, Integer value2) {
            addCriterion("APPLY_TYPE between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("APPLY_TYPE not between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdIsNull() {
            addCriterion("AUTH_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdIsNotNull() {
            addCriterion("AUTH_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdEqualTo(Integer value) {
            addCriterion("AUTH_USER_ID =", value, "authUserId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdNotEqualTo(Integer value) {
            addCriterion("AUTH_USER_ID <>", value, "authUserId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdGreaterThan(Integer value) {
            addCriterion("AUTH_USER_ID >", value, "authUserId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTH_USER_ID >=", value, "authUserId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdLessThan(Integer value) {
            addCriterion("AUTH_USER_ID <", value, "authUserId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("AUTH_USER_ID <=", value, "authUserId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdIn(List<Integer> values) {
            addCriterion("AUTH_USER_ID in", values, "authUserId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdNotIn(List<Integer> values) {
            addCriterion("AUTH_USER_ID not in", values, "authUserId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdBetween(Integer value1, Integer value2) {
            addCriterion("AUTH_USER_ID between", value1, value2, "authUserId");
            return (Criteria) this;
        }

        public Criteria andAuthUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTH_USER_ID not between", value1, value2, "authUserId");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameIsNull() {
            addCriterion("AUTH_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameIsNotNull() {
            addCriterion("AUTH_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameEqualTo(String value) {
            addCriterion("AUTH_USERNAME =", value, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameNotEqualTo(String value) {
            addCriterion("AUTH_USERNAME <>", value, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameGreaterThan(String value) {
            addCriterion("AUTH_USERNAME >", value, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_USERNAME >=", value, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameLessThan(String value) {
            addCriterion("AUTH_USERNAME <", value, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameLessThanOrEqualTo(String value) {
            addCriterion("AUTH_USERNAME <=", value, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameLike(String value) {
            addCriterion("AUTH_USERNAME like", value, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameNotLike(String value) {
            addCriterion("AUTH_USERNAME not like", value, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameIn(List<String> values) {
            addCriterion("AUTH_USERNAME in", values, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameNotIn(List<String> values) {
            addCriterion("AUTH_USERNAME not in", values, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameBetween(String value1, String value2) {
            addCriterion("AUTH_USERNAME between", value1, value2, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthUsernameNotBetween(String value1, String value2) {
            addCriterion("AUTH_USERNAME not between", value1, value2, "authUsername");
            return (Criteria) this;
        }

        public Criteria andAuthStatusIsNull() {
            addCriterion("AUTH_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAuthStatusIsNotNull() {
            addCriterion("AUTH_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAuthStatusEqualTo(Integer value) {
            addCriterion("AUTH_STATUS =", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusNotEqualTo(Integer value) {
            addCriterion("AUTH_STATUS <>", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusGreaterThan(Integer value) {
            addCriterion("AUTH_STATUS >", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTH_STATUS >=", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusLessThan(Integer value) {
            addCriterion("AUTH_STATUS <", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusLessThanOrEqualTo(Integer value) {
            addCriterion("AUTH_STATUS <=", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusIn(List<Integer> values) {
            addCriterion("AUTH_STATUS in", values, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusNotIn(List<Integer> values) {
            addCriterion("AUTH_STATUS not in", values, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusBetween(Integer value1, Integer value2) {
            addCriterion("AUTH_STATUS between", value1, value2, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTH_STATUS not between", value1, value2, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkIsNull() {
            addCriterion("AUTH_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkIsNotNull() {
            addCriterion("AUTH_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkEqualTo(String value) {
            addCriterion("AUTH_REMARK =", value, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkNotEqualTo(String value) {
            addCriterion("AUTH_REMARK <>", value, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkGreaterThan(String value) {
            addCriterion("AUTH_REMARK >", value, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_REMARK >=", value, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkLessThan(String value) {
            addCriterion("AUTH_REMARK <", value, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkLessThanOrEqualTo(String value) {
            addCriterion("AUTH_REMARK <=", value, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkLike(String value) {
            addCriterion("AUTH_REMARK like", value, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkNotLike(String value) {
            addCriterion("AUTH_REMARK not like", value, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkIn(List<String> values) {
            addCriterion("AUTH_REMARK in", values, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkNotIn(List<String> values) {
            addCriterion("AUTH_REMARK not in", values, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkBetween(String value1, String value2) {
            addCriterion("AUTH_REMARK between", value1, value2, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthRemarkNotBetween(String value1, String value2) {
            addCriterion("AUTH_REMARK not between", value1, value2, "authRemark");
            return (Criteria) this;
        }

        public Criteria andAuthDateIsNull() {
            addCriterion("AUTH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAuthDateIsNotNull() {
            addCriterion("AUTH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAuthDateEqualTo(Date value) {
            addCriterion("AUTH_DATE =", value, "authDate");
            return (Criteria) this;
        }

        public Criteria andAuthDateNotEqualTo(Date value) {
            addCriterion("AUTH_DATE <>", value, "authDate");
            return (Criteria) this;
        }

        public Criteria andAuthDateGreaterThan(Date value) {
            addCriterion("AUTH_DATE >", value, "authDate");
            return (Criteria) this;
        }

        public Criteria andAuthDateGreaterThanOrEqualTo(Date value) {
            addCriterion("AUTH_DATE >=", value, "authDate");
            return (Criteria) this;
        }

        public Criteria andAuthDateLessThan(Date value) {
            addCriterion("AUTH_DATE <", value, "authDate");
            return (Criteria) this;
        }

        public Criteria andAuthDateLessThanOrEqualTo(Date value) {
            addCriterion("AUTH_DATE <=", value, "authDate");
            return (Criteria) this;
        }

        public Criteria andAuthDateIn(List<Date> values) {
            addCriterion("AUTH_DATE in", values, "authDate");
            return (Criteria) this;
        }

        public Criteria andAuthDateNotIn(List<Date> values) {
            addCriterion("AUTH_DATE not in", values, "authDate");
            return (Criteria) this;
        }

        public Criteria andAuthDateBetween(Date value1, Date value2) {
            addCriterion("AUTH_DATE between", value1, value2, "authDate");
            return (Criteria) this;
        }

        public Criteria andAuthDateNotBetween(Date value1, Date value2) {
            addCriterion("AUTH_DATE not between", value1, value2, "authDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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