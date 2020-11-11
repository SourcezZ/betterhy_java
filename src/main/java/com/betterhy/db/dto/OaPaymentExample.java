package com.betterhy.db.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaPaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OaPaymentExample() {
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

        public Criteria andPaymentIdIsNull() {
            addCriterion("PAYMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNotNull() {
            addCriterion("PAYMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdEqualTo(Long value) {
            addCriterion("PAYMENT_ID =", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotEqualTo(Long value) {
            addCriterion("PAYMENT_ID <>", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThan(Long value) {
            addCriterion("PAYMENT_ID >", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PAYMENT_ID >=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThan(Long value) {
            addCriterion("PAYMENT_ID <", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThanOrEqualTo(Long value) {
            addCriterion("PAYMENT_ID <=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIn(List<Long> values) {
            addCriterion("PAYMENT_ID in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotIn(List<Long> values) {
            addCriterion("PAYMENT_ID not in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdBetween(Long value1, Long value2) {
            addCriterion("PAYMENT_ID between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotBetween(Long value1, Long value2) {
            addCriterion("PAYMENT_ID not between", value1, value2, "paymentId");
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

        public Criteria andPaymentTypeIsNull() {
            addCriterion("PAYMENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("PAYMENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(String value) {
            addCriterion("PAYMENT_TYPE =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(String value) {
            addCriterion("PAYMENT_TYPE <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(String value) {
            addCriterion("PAYMENT_TYPE >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_TYPE >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(String value) {
            addCriterion("PAYMENT_TYPE <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_TYPE <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLike(String value) {
            addCriterion("PAYMENT_TYPE like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotLike(String value) {
            addCriterion("PAYMENT_TYPE not like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<String> values) {
            addCriterion("PAYMENT_TYPE in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<String> values) {
            addCriterion("PAYMENT_TYPE not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(String value1, String value2) {
            addCriterion("PAYMENT_TYPE between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_TYPE not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkIsNull() {
            addCriterion("PAYMENT_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkIsNotNull() {
            addCriterion("PAYMENT_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkEqualTo(String value) {
            addCriterion("PAYMENT_REMARK =", value, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkNotEqualTo(String value) {
            addCriterion("PAYMENT_REMARK <>", value, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkGreaterThan(String value) {
            addCriterion("PAYMENT_REMARK >", value, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_REMARK >=", value, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkLessThan(String value) {
            addCriterion("PAYMENT_REMARK <", value, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_REMARK <=", value, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkLike(String value) {
            addCriterion("PAYMENT_REMARK like", value, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkNotLike(String value) {
            addCriterion("PAYMENT_REMARK not like", value, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkIn(List<String> values) {
            addCriterion("PAYMENT_REMARK in", values, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkNotIn(List<String> values) {
            addCriterion("PAYMENT_REMARK not in", values, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkBetween(String value1, String value2) {
            addCriterion("PAYMENT_REMARK between", value1, value2, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andPaymentRemarkNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_REMARK not between", value1, value2, "paymentRemark");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNull() {
            addCriterion("BILL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBillTypeIsNotNull() {
            addCriterion("BILL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBillTypeEqualTo(Integer value) {
            addCriterion("BILL_TYPE =", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotEqualTo(Integer value) {
            addCriterion("BILL_TYPE <>", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThan(Integer value) {
            addCriterion("BILL_TYPE >", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("BILL_TYPE >=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThan(Integer value) {
            addCriterion("BILL_TYPE <", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeLessThanOrEqualTo(Integer value) {
            addCriterion("BILL_TYPE <=", value, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeIn(List<Integer> values) {
            addCriterion("BILL_TYPE in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotIn(List<Integer> values) {
            addCriterion("BILL_TYPE not in", values, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeBetween(Integer value1, Integer value2) {
            addCriterion("BILL_TYPE between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("BILL_TYPE not between", value1, value2, "billType");
            return (Criteria) this;
        }

        public Criteria andBillCodeIsNull() {
            addCriterion("BILL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBillCodeIsNotNull() {
            addCriterion("BILL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBillCodeEqualTo(String value) {
            addCriterion("BILL_CODE =", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeNotEqualTo(String value) {
            addCriterion("BILL_CODE <>", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeGreaterThan(String value) {
            addCriterion("BILL_CODE >", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_CODE >=", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeLessThan(String value) {
            addCriterion("BILL_CODE <", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeLessThanOrEqualTo(String value) {
            addCriterion("BILL_CODE <=", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeLike(String value) {
            addCriterion("BILL_CODE like", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeNotLike(String value) {
            addCriterion("BILL_CODE not like", value, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeIn(List<String> values) {
            addCriterion("BILL_CODE in", values, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeNotIn(List<String> values) {
            addCriterion("BILL_CODE not in", values, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeBetween(String value1, String value2) {
            addCriterion("BILL_CODE between", value1, value2, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillCodeNotBetween(String value1, String value2) {
            addCriterion("BILL_CODE not between", value1, value2, "billCode");
            return (Criteria) this;
        }

        public Criteria andBillNumIsNull() {
            addCriterion("BILL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andBillNumIsNotNull() {
            addCriterion("BILL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andBillNumEqualTo(String value) {
            addCriterion("BILL_NUM =", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumNotEqualTo(String value) {
            addCriterion("BILL_NUM <>", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumGreaterThan(String value) {
            addCriterion("BILL_NUM >", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumGreaterThanOrEqualTo(String value) {
            addCriterion("BILL_NUM >=", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumLessThan(String value) {
            addCriterion("BILL_NUM <", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumLessThanOrEqualTo(String value) {
            addCriterion("BILL_NUM <=", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumLike(String value) {
            addCriterion("BILL_NUM like", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumNotLike(String value) {
            addCriterion("BILL_NUM not like", value, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumIn(List<String> values) {
            addCriterion("BILL_NUM in", values, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumNotIn(List<String> values) {
            addCriterion("BILL_NUM not in", values, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumBetween(String value1, String value2) {
            addCriterion("BILL_NUM between", value1, value2, "billNum");
            return (Criteria) this;
        }

        public Criteria andBillNumNotBetween(String value1, String value2) {
            addCriterion("BILL_NUM not between", value1, value2, "billNum");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIsNull() {
            addCriterion("VEHICLE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIsNotNull() {
            addCriterion("VEHICLE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeEqualTo(String value) {
            addCriterion("VEHICLE_TYPE =", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotEqualTo(String value) {
            addCriterion("VEHICLE_TYPE <>", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThan(String value) {
            addCriterion("VEHICLE_TYPE >", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("VEHICLE_TYPE >=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThan(String value) {
            addCriterion("VEHICLE_TYPE <", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThanOrEqualTo(String value) {
            addCriterion("VEHICLE_TYPE <=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLike(String value) {
            addCriterion("VEHICLE_TYPE like", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotLike(String value) {
            addCriterion("VEHICLE_TYPE not like", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIn(List<String> values) {
            addCriterion("VEHICLE_TYPE in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotIn(List<String> values) {
            addCriterion("VEHICLE_TYPE not in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeBetween(String value1, String value2) {
            addCriterion("VEHICLE_TYPE between", value1, value2, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotBetween(String value1, String value2) {
            addCriterion("VEHICLE_TYPE not between", value1, value2, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIsNull() {
            addCriterion("START_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIsNotNull() {
            addCriterion("START_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andStartPlaceEqualTo(String value) {
            addCriterion("START_PLACE =", value, "startPlace");
            return (Criteria) this;
        }

        public Criteria andStartPlaceNotEqualTo(String value) {
            addCriterion("START_PLACE <>", value, "startPlace");
            return (Criteria) this;
        }

        public Criteria andStartPlaceGreaterThan(String value) {
            addCriterion("START_PLACE >", value, "startPlace");
            return (Criteria) this;
        }

        public Criteria andStartPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("START_PLACE >=", value, "startPlace");
            return (Criteria) this;
        }

        public Criteria andStartPlaceLessThan(String value) {
            addCriterion("START_PLACE <", value, "startPlace");
            return (Criteria) this;
        }

        public Criteria andStartPlaceLessThanOrEqualTo(String value) {
            addCriterion("START_PLACE <=", value, "startPlace");
            return (Criteria) this;
        }

        public Criteria andStartPlaceLike(String value) {
            addCriterion("START_PLACE like", value, "startPlace");
            return (Criteria) this;
        }

        public Criteria andStartPlaceNotLike(String value) {
            addCriterion("START_PLACE not like", value, "startPlace");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIn(List<String> values) {
            addCriterion("START_PLACE in", values, "startPlace");
            return (Criteria) this;
        }

        public Criteria andStartPlaceNotIn(List<String> values) {
            addCriterion("START_PLACE not in", values, "startPlace");
            return (Criteria) this;
        }

        public Criteria andStartPlaceBetween(String value1, String value2) {
            addCriterion("START_PLACE between", value1, value2, "startPlace");
            return (Criteria) this;
        }

        public Criteria andStartPlaceNotBetween(String value1, String value2) {
            addCriterion("START_PLACE not between", value1, value2, "startPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceIsNull() {
            addCriterion("END_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andEndPlaceIsNotNull() {
            addCriterion("END_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andEndPlaceEqualTo(String value) {
            addCriterion("END_PLACE =", value, "endPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceNotEqualTo(String value) {
            addCriterion("END_PLACE <>", value, "endPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceGreaterThan(String value) {
            addCriterion("END_PLACE >", value, "endPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("END_PLACE >=", value, "endPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceLessThan(String value) {
            addCriterion("END_PLACE <", value, "endPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceLessThanOrEqualTo(String value) {
            addCriterion("END_PLACE <=", value, "endPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceLike(String value) {
            addCriterion("END_PLACE like", value, "endPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceNotLike(String value) {
            addCriterion("END_PLACE not like", value, "endPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceIn(List<String> values) {
            addCriterion("END_PLACE in", values, "endPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceNotIn(List<String> values) {
            addCriterion("END_PLACE not in", values, "endPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceBetween(String value1, String value2) {
            addCriterion("END_PLACE between", value1, value2, "endPlace");
            return (Criteria) this;
        }

        public Criteria andEndPlaceNotBetween(String value1, String value2) {
            addCriterion("END_PLACE not between", value1, value2, "endPlace");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIsNull() {
            addCriterion("CHECK_IN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIsNotNull() {
            addCriterion("CHECK_IN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeEqualTo(Date value) {
            addCriterion("CHECK_IN_TIME =", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotEqualTo(Date value) {
            addCriterion("CHECK_IN_TIME <>", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeGreaterThan(Date value) {
            addCriterion("CHECK_IN_TIME >", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_IN_TIME >=", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeLessThan(Date value) {
            addCriterion("CHECK_IN_TIME <", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_IN_TIME <=", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIn(List<Date> values) {
            addCriterion("CHECK_IN_TIME in", values, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotIn(List<Date> values) {
            addCriterion("CHECK_IN_TIME not in", values, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_IN_TIME between", value1, value2, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_IN_TIME not between", value1, value2, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIsNull() {
            addCriterion("LEAVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIsNotNull() {
            addCriterion("LEAVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeEqualTo(Date value) {
            addCriterion("LEAVE_TIME =", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotEqualTo(Date value) {
            addCriterion("LEAVE_TIME <>", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThan(Date value) {
            addCriterion("LEAVE_TIME >", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LEAVE_TIME >=", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThan(Date value) {
            addCriterion("LEAVE_TIME <", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThanOrEqualTo(Date value) {
            addCriterion("LEAVE_TIME <=", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIn(List<Date> values) {
            addCriterion("LEAVE_TIME in", values, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotIn(List<Date> values) {
            addCriterion("LEAVE_TIME not in", values, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeBetween(Date value1, Date value2) {
            addCriterion("LEAVE_TIME between", value1, value2, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotBetween(Date value1, Date value2) {
            addCriterion("LEAVE_TIME not between", value1, value2, "leaveTime");
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

        public Criteria andApplyTimeIsNull() {
            addCriterion("APPLY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("APPLY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("APPLY_TIME =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("APPLY_TIME <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("APPLY_TIME >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_TIME >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("APPLY_TIME <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_TIME <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("APPLY_TIME in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("APPLY_TIME not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("APPLY_TIME between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_TIME not between", value1, value2, "applyTime");
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