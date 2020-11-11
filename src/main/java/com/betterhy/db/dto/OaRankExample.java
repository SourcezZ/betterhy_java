package com.betterhy.db.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaRankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OaRankExample() {
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

        public Criteria andRankIdIsNull() {
            addCriterion("RANK_ID is null");
            return (Criteria) this;
        }

        public Criteria andRankIdIsNotNull() {
            addCriterion("RANK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRankIdEqualTo(Integer value) {
            addCriterion("RANK_ID =", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotEqualTo(Integer value) {
            addCriterion("RANK_ID <>", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdGreaterThan(Integer value) {
            addCriterion("RANK_ID >", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RANK_ID >=", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdLessThan(Integer value) {
            addCriterion("RANK_ID <", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdLessThanOrEqualTo(Integer value) {
            addCriterion("RANK_ID <=", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdIn(List<Integer> values) {
            addCriterion("RANK_ID in", values, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotIn(List<Integer> values) {
            addCriterion("RANK_ID not in", values, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdBetween(Integer value1, Integer value2) {
            addCriterion("RANK_ID between", value1, value2, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RANK_ID not between", value1, value2, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankNameIsNull() {
            addCriterion("RANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRankNameIsNotNull() {
            addCriterion("RANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRankNameEqualTo(String value) {
            addCriterion("RANK_NAME =", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotEqualTo(String value) {
            addCriterion("RANK_NAME <>", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameGreaterThan(String value) {
            addCriterion("RANK_NAME >", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameGreaterThanOrEqualTo(String value) {
            addCriterion("RANK_NAME >=", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLessThan(String value) {
            addCriterion("RANK_NAME <", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLessThanOrEqualTo(String value) {
            addCriterion("RANK_NAME <=", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLike(String value) {
            addCriterion("RANK_NAME like", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotLike(String value) {
            addCriterion("RANK_NAME not like", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameIn(List<String> values) {
            addCriterion("RANK_NAME in", values, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotIn(List<String> values) {
            addCriterion("RANK_NAME not in", values, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameBetween(String value1, String value2) {
            addCriterion("RANK_NAME between", value1, value2, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotBetween(String value1, String value2) {
            addCriterion("RANK_NAME not between", value1, value2, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankLevelIsNull() {
            addCriterion("RANK_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andRankLevelIsNotNull() {
            addCriterion("RANK_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andRankLevelEqualTo(Integer value) {
            addCriterion("RANK_LEVEL =", value, "rankLevel");
            return (Criteria) this;
        }

        public Criteria andRankLevelNotEqualTo(Integer value) {
            addCriterion("RANK_LEVEL <>", value, "rankLevel");
            return (Criteria) this;
        }

        public Criteria andRankLevelGreaterThan(Integer value) {
            addCriterion("RANK_LEVEL >", value, "rankLevel");
            return (Criteria) this;
        }

        public Criteria andRankLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("RANK_LEVEL >=", value, "rankLevel");
            return (Criteria) this;
        }

        public Criteria andRankLevelLessThan(Integer value) {
            addCriterion("RANK_LEVEL <", value, "rankLevel");
            return (Criteria) this;
        }

        public Criteria andRankLevelLessThanOrEqualTo(Integer value) {
            addCriterion("RANK_LEVEL <=", value, "rankLevel");
            return (Criteria) this;
        }

        public Criteria andRankLevelIn(List<Integer> values) {
            addCriterion("RANK_LEVEL in", values, "rankLevel");
            return (Criteria) this;
        }

        public Criteria andRankLevelNotIn(List<Integer> values) {
            addCriterion("RANK_LEVEL not in", values, "rankLevel");
            return (Criteria) this;
        }

        public Criteria andRankLevelBetween(Integer value1, Integer value2) {
            addCriterion("RANK_LEVEL between", value1, value2, "rankLevel");
            return (Criteria) this;
        }

        public Criteria andRankLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("RANK_LEVEL not between", value1, value2, "rankLevel");
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