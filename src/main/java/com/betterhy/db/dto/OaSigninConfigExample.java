package com.betterhy.db.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaSigninConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OaSigninConfigExample() {
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

        public Criteria andDeptIdIsNull() {
            addCriterion("DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("DEPT_ID =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("DEPT_ID <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("DEPT_ID >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEPT_ID >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("DEPT_ID <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEPT_ID <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("DEPT_ID in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("DEPT_ID not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_ID between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_ID not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("LONGITUDE like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("LONGITUDE not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("LATITUDE like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("LATITUDE not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andSigninRangeIsNull() {
            addCriterion("SIGNIN_RANGE is null");
            return (Criteria) this;
        }

        public Criteria andSigninRangeIsNotNull() {
            addCriterion("SIGNIN_RANGE is not null");
            return (Criteria) this;
        }

        public Criteria andSigninRangeEqualTo(Integer value) {
            addCriterion("SIGNIN_RANGE =", value, "signinRange");
            return (Criteria) this;
        }

        public Criteria andSigninRangeNotEqualTo(Integer value) {
            addCriterion("SIGNIN_RANGE <>", value, "signinRange");
            return (Criteria) this;
        }

        public Criteria andSigninRangeGreaterThan(Integer value) {
            addCriterion("SIGNIN_RANGE >", value, "signinRange");
            return (Criteria) this;
        }

        public Criteria andSigninRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SIGNIN_RANGE >=", value, "signinRange");
            return (Criteria) this;
        }

        public Criteria andSigninRangeLessThan(Integer value) {
            addCriterion("SIGNIN_RANGE <", value, "signinRange");
            return (Criteria) this;
        }

        public Criteria andSigninRangeLessThanOrEqualTo(Integer value) {
            addCriterion("SIGNIN_RANGE <=", value, "signinRange");
            return (Criteria) this;
        }

        public Criteria andSigninRangeIn(List<Integer> values) {
            addCriterion("SIGNIN_RANGE in", values, "signinRange");
            return (Criteria) this;
        }

        public Criteria andSigninRangeNotIn(List<Integer> values) {
            addCriterion("SIGNIN_RANGE not in", values, "signinRange");
            return (Criteria) this;
        }

        public Criteria andSigninRangeBetween(Integer value1, Integer value2) {
            addCriterion("SIGNIN_RANGE between", value1, value2, "signinRange");
            return (Criteria) this;
        }

        public Criteria andSigninRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("SIGNIN_RANGE not between", value1, value2, "signinRange");
            return (Criteria) this;
        }

        public Criteria andOnTimeIsNull() {
            addCriterion("ON_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOnTimeIsNotNull() {
            addCriterion("ON_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOnTimeEqualTo(String value) {
            addCriterion("ON_TIME =", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeNotEqualTo(String value) {
            addCriterion("ON_TIME <>", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeGreaterThan(String value) {
            addCriterion("ON_TIME >", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ON_TIME >=", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeLessThan(String value) {
            addCriterion("ON_TIME <", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeLessThanOrEqualTo(String value) {
            addCriterion("ON_TIME <=", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeLike(String value) {
            addCriterion("ON_TIME like", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeNotLike(String value) {
            addCriterion("ON_TIME not like", value, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeIn(List<String> values) {
            addCriterion("ON_TIME in", values, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeNotIn(List<String> values) {
            addCriterion("ON_TIME not in", values, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeBetween(String value1, String value2) {
            addCriterion("ON_TIME between", value1, value2, "onTime");
            return (Criteria) this;
        }

        public Criteria andOnTimeNotBetween(String value1, String value2) {
            addCriterion("ON_TIME not between", value1, value2, "onTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeIsNull() {
            addCriterion("OFF_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOffTimeIsNotNull() {
            addCriterion("OFF_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOffTimeEqualTo(String value) {
            addCriterion("OFF_TIME =", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeNotEqualTo(String value) {
            addCriterion("OFF_TIME <>", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeGreaterThan(String value) {
            addCriterion("OFF_TIME >", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeGreaterThanOrEqualTo(String value) {
            addCriterion("OFF_TIME >=", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeLessThan(String value) {
            addCriterion("OFF_TIME <", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeLessThanOrEqualTo(String value) {
            addCriterion("OFF_TIME <=", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeLike(String value) {
            addCriterion("OFF_TIME like", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeNotLike(String value) {
            addCriterion("OFF_TIME not like", value, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeIn(List<String> values) {
            addCriterion("OFF_TIME in", values, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeNotIn(List<String> values) {
            addCriterion("OFF_TIME not in", values, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeBetween(String value1, String value2) {
            addCriterion("OFF_TIME between", value1, value2, "offTime");
            return (Criteria) this;
        }

        public Criteria andOffTimeNotBetween(String value1, String value2) {
            addCriterion("OFF_TIME not between", value1, value2, "offTime");
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