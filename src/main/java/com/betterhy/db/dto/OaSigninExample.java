package com.betterhy.db.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OaSigninExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OaSigninExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSigninIdIsNull() {
            addCriterion("SIGNIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andSigninIdIsNotNull() {
            addCriterion("SIGNIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSigninIdEqualTo(Long value) {
            addCriterion("SIGNIN_ID =", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdNotEqualTo(Long value) {
            addCriterion("SIGNIN_ID <>", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdGreaterThan(Long value) {
            addCriterion("SIGNIN_ID >", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SIGNIN_ID >=", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdLessThan(Long value) {
            addCriterion("SIGNIN_ID <", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdLessThanOrEqualTo(Long value) {
            addCriterion("SIGNIN_ID <=", value, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdIn(List<Long> values) {
            addCriterion("SIGNIN_ID in", values, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdNotIn(List<Long> values) {
            addCriterion("SIGNIN_ID not in", values, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdBetween(Long value1, Long value2) {
            addCriterion("SIGNIN_ID between", value1, value2, "signinId");
            return (Criteria) this;
        }

        public Criteria andSigninIdNotBetween(Long value1, Long value2) {
            addCriterion("SIGNIN_ID not between", value1, value2, "signinId");
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

        public Criteria andSigninPlaceIsNull() {
            addCriterion("SIGNIN_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceIsNotNull() {
            addCriterion("SIGNIN_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceEqualTo(String value) {
            addCriterion("SIGNIN_PLACE =", value, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceNotEqualTo(String value) {
            addCriterion("SIGNIN_PLACE <>", value, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceGreaterThan(String value) {
            addCriterion("SIGNIN_PLACE >", value, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("SIGNIN_PLACE >=", value, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceLessThan(String value) {
            addCriterion("SIGNIN_PLACE <", value, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceLessThanOrEqualTo(String value) {
            addCriterion("SIGNIN_PLACE <=", value, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceLike(String value) {
            addCriterion("SIGNIN_PLACE like", value, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceNotLike(String value) {
            addCriterion("SIGNIN_PLACE not like", value, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceIn(List<String> values) {
            addCriterion("SIGNIN_PLACE in", values, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceNotIn(List<String> values) {
            addCriterion("SIGNIN_PLACE not in", values, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceBetween(String value1, String value2) {
            addCriterion("SIGNIN_PLACE between", value1, value2, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninPlaceNotBetween(String value1, String value2) {
            addCriterion("SIGNIN_PLACE not between", value1, value2, "signinPlace");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIsNull() {
            addCriterion("SIGNIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIsNotNull() {
            addCriterion("SIGNIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSigninTimeEqualTo(Date value) {
            addCriterion("SIGNIN_TIME =", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotEqualTo(Date value) {
            addCriterion("SIGNIN_TIME <>", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThan(Date value) {
            addCriterion("SIGNIN_TIME >", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SIGNIN_TIME >=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThan(Date value) {
            addCriterion("SIGNIN_TIME <", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThanOrEqualTo(Date value) {
            addCriterion("SIGNIN_TIME <=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIn(List<Date> values) {
            addCriterion("SIGNIN_TIME in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotIn(List<Date> values) {
            addCriterion("SIGNIN_TIME not in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeBetween(Date value1, Date value2) {
            addCriterion("SIGNIN_TIME between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotBetween(Date value1, Date value2) {
            addCriterion("SIGNIN_TIME not between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninStatusIsNull() {
            addCriterion("SIGNIN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSigninStatusIsNotNull() {
            addCriterion("SIGNIN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSigninStatusEqualTo(Integer value) {
            addCriterion("SIGNIN_STATUS =", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusNotEqualTo(Integer value) {
            addCriterion("SIGNIN_STATUS <>", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusGreaterThan(Integer value) {
            addCriterion("SIGNIN_STATUS >", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("SIGNIN_STATUS >=", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusLessThan(Integer value) {
            addCriterion("SIGNIN_STATUS <", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusLessThanOrEqualTo(Integer value) {
            addCriterion("SIGNIN_STATUS <=", value, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusIn(List<Integer> values) {
            addCriterion("SIGNIN_STATUS in", values, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusNotIn(List<Integer> values) {
            addCriterion("SIGNIN_STATUS not in", values, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusBetween(Integer value1, Integer value2) {
            addCriterion("SIGNIN_STATUS between", value1, value2, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("SIGNIN_STATUS not between", value1, value2, "signinStatus");
            return (Criteria) this;
        }

        public Criteria andSigninTypeIsNull() {
            addCriterion("SIGNIN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSigninTypeIsNotNull() {
            addCriterion("SIGNIN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSigninTypeEqualTo(Integer value) {
            addCriterion("SIGNIN_TYPE =", value, "signinType");
            return (Criteria) this;
        }

        public Criteria andSigninTypeNotEqualTo(Integer value) {
            addCriterion("SIGNIN_TYPE <>", value, "signinType");
            return (Criteria) this;
        }

        public Criteria andSigninTypeGreaterThan(Integer value) {
            addCriterion("SIGNIN_TYPE >", value, "signinType");
            return (Criteria) this;
        }

        public Criteria andSigninTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SIGNIN_TYPE >=", value, "signinType");
            return (Criteria) this;
        }

        public Criteria andSigninTypeLessThan(Integer value) {
            addCriterion("SIGNIN_TYPE <", value, "signinType");
            return (Criteria) this;
        }

        public Criteria andSigninTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SIGNIN_TYPE <=", value, "signinType");
            return (Criteria) this;
        }

        public Criteria andSigninTypeIn(List<Integer> values) {
            addCriterion("SIGNIN_TYPE in", values, "signinType");
            return (Criteria) this;
        }

        public Criteria andSigninTypeNotIn(List<Integer> values) {
            addCriterion("SIGNIN_TYPE not in", values, "signinType");
            return (Criteria) this;
        }

        public Criteria andSigninTypeBetween(Integer value1, Integer value2) {
            addCriterion("SIGNIN_TYPE between", value1, value2, "signinType");
            return (Criteria) this;
        }

        public Criteria andSigninTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SIGNIN_TYPE not between", value1, value2, "signinType");
            return (Criteria) this;
        }

        public Criteria andSigninDateIsNull() {
            addCriterion("SIGNIN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSigninDateIsNotNull() {
            addCriterion("SIGNIN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSigninDateEqualTo(Date value) {
            addCriterionForJDBCDate("SIGNIN_DATE =", value, "signinDate");
            return (Criteria) this;
        }

        public Criteria andSigninDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SIGNIN_DATE <>", value, "signinDate");
            return (Criteria) this;
        }

        public Criteria andSigninDateGreaterThan(Date value) {
            addCriterionForJDBCDate("SIGNIN_DATE >", value, "signinDate");
            return (Criteria) this;
        }

        public Criteria andSigninDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SIGNIN_DATE >=", value, "signinDate");
            return (Criteria) this;
        }

        public Criteria andSigninDateLessThan(Date value) {
            addCriterionForJDBCDate("SIGNIN_DATE <", value, "signinDate");
            return (Criteria) this;
        }

        public Criteria andSigninDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SIGNIN_DATE <=", value, "signinDate");
            return (Criteria) this;
        }

        public Criteria andSigninDateIn(List<Date> values) {
            addCriterionForJDBCDate("SIGNIN_DATE in", values, "signinDate");
            return (Criteria) this;
        }

        public Criteria andSigninDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SIGNIN_DATE not in", values, "signinDate");
            return (Criteria) this;
        }

        public Criteria andSigninDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SIGNIN_DATE between", value1, value2, "signinDate");
            return (Criteria) this;
        }

        public Criteria andSigninDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SIGNIN_DATE not between", value1, value2, "signinDate");
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