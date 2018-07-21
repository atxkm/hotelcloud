package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquipmentHotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentHotelExample() {
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

    /**
     * t_equipment_hotel 
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

        public Criteria andEquipmentnameIsNull() {
            addCriterion("equipmentname is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameIsNotNull() {
            addCriterion("equipmentname is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameEqualTo(String value) {
            addCriterion("equipmentname =", value, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameNotEqualTo(String value) {
            addCriterion("equipmentname <>", value, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameGreaterThan(String value) {
            addCriterion("equipmentname >", value, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameGreaterThanOrEqualTo(String value) {
            addCriterion("equipmentname >=", value, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameLessThan(String value) {
            addCriterion("equipmentname <", value, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameLessThanOrEqualTo(String value) {
            addCriterion("equipmentname <=", value, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameLike(String value) {
            addCriterion("equipmentname like", value, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameNotLike(String value) {
            addCriterion("equipmentname not like", value, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameIn(List<String> values) {
            addCriterion("equipmentname in", values, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameNotIn(List<String> values) {
            addCriterion("equipmentname not in", values, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameBetween(String value1, String value2) {
            addCriterion("equipmentname between", value1, value2, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquipmentnameNotBetween(String value1, String value2) {
            addCriterion("equipmentname not between", value1, value2, "equipmentname");
            return (Criteria) this;
        }

        public Criteria andEquBrandIsNull() {
            addCriterion("equ_brand is null");
            return (Criteria) this;
        }

        public Criteria andEquBrandIsNotNull() {
            addCriterion("equ_brand is not null");
            return (Criteria) this;
        }

        public Criteria andEquBrandEqualTo(String value) {
            addCriterion("equ_brand =", value, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquBrandNotEqualTo(String value) {
            addCriterion("equ_brand <>", value, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquBrandGreaterThan(String value) {
            addCriterion("equ_brand >", value, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquBrandGreaterThanOrEqualTo(String value) {
            addCriterion("equ_brand >=", value, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquBrandLessThan(String value) {
            addCriterion("equ_brand <", value, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquBrandLessThanOrEqualTo(String value) {
            addCriterion("equ_brand <=", value, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquBrandLike(String value) {
            addCriterion("equ_brand like", value, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquBrandNotLike(String value) {
            addCriterion("equ_brand not like", value, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquBrandIn(List<String> values) {
            addCriterion("equ_brand in", values, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquBrandNotIn(List<String> values) {
            addCriterion("equ_brand not in", values, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquBrandBetween(String value1, String value2) {
            addCriterion("equ_brand between", value1, value2, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquBrandNotBetween(String value1, String value2) {
            addCriterion("equ_brand not between", value1, value2, "equBrand");
            return (Criteria) this;
        }

        public Criteria andEquTypeIsNull() {
            addCriterion("equ_type is null");
            return (Criteria) this;
        }

        public Criteria andEquTypeIsNotNull() {
            addCriterion("equ_type is not null");
            return (Criteria) this;
        }

        public Criteria andEquTypeEqualTo(String value) {
            addCriterion("equ_type =", value, "equType");
            return (Criteria) this;
        }

        public Criteria andEquTypeNotEqualTo(String value) {
            addCriterion("equ_type <>", value, "equType");
            return (Criteria) this;
        }

        public Criteria andEquTypeGreaterThan(String value) {
            addCriterion("equ_type >", value, "equType");
            return (Criteria) this;
        }

        public Criteria andEquTypeGreaterThanOrEqualTo(String value) {
            addCriterion("equ_type >=", value, "equType");
            return (Criteria) this;
        }

        public Criteria andEquTypeLessThan(String value) {
            addCriterion("equ_type <", value, "equType");
            return (Criteria) this;
        }

        public Criteria andEquTypeLessThanOrEqualTo(String value) {
            addCriterion("equ_type <=", value, "equType");
            return (Criteria) this;
        }

        public Criteria andEquTypeLike(String value) {
            addCriterion("equ_type like", value, "equType");
            return (Criteria) this;
        }

        public Criteria andEquTypeNotLike(String value) {
            addCriterion("equ_type not like", value, "equType");
            return (Criteria) this;
        }

        public Criteria andEquTypeIn(List<String> values) {
            addCriterion("equ_type in", values, "equType");
            return (Criteria) this;
        }

        public Criteria andEquTypeNotIn(List<String> values) {
            addCriterion("equ_type not in", values, "equType");
            return (Criteria) this;
        }

        public Criteria andEquTypeBetween(String value1, String value2) {
            addCriterion("equ_type between", value1, value2, "equType");
            return (Criteria) this;
        }

        public Criteria andEquTypeNotBetween(String value1, String value2) {
            addCriterion("equ_type not between", value1, value2, "equType");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIsNull() {
            addCriterion("buy_time is null");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIsNotNull() {
            addCriterion("buy_time is not null");
            return (Criteria) this;
        }

        public Criteria andBuyTimeEqualTo(Date value) {
            addCriterion("buy_time =", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotEqualTo(Date value) {
            addCriterion("buy_time <>", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeGreaterThan(Date value) {
            addCriterion("buy_time >", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("buy_time >=", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeLessThan(Date value) {
            addCriterion("buy_time <", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeLessThanOrEqualTo(Date value) {
            addCriterion("buy_time <=", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIn(List<Date> values) {
            addCriterion("buy_time in", values, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotIn(List<Date> values) {
            addCriterion("buy_time not in", values, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeBetween(Date value1, Date value2) {
            addCriterion("buy_time between", value1, value2, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotBetween(Date value1, Date value2) {
            addCriterion("buy_time not between", value1, value2, "buyTime");
            return (Criteria) this;
        }

        public Criteria andOptidIsNull() {
            addCriterion("optid is null");
            return (Criteria) this;
        }

        public Criteria andOptidIsNotNull() {
            addCriterion("optid is not null");
            return (Criteria) this;
        }

        public Criteria andOptidEqualTo(String value) {
            addCriterion("optid =", value, "optid");
            return (Criteria) this;
        }

        public Criteria andOptidNotEqualTo(String value) {
            addCriterion("optid <>", value, "optid");
            return (Criteria) this;
        }

        public Criteria andOptidGreaterThan(String value) {
            addCriterion("optid >", value, "optid");
            return (Criteria) this;
        }

        public Criteria andOptidGreaterThanOrEqualTo(String value) {
            addCriterion("optid >=", value, "optid");
            return (Criteria) this;
        }

        public Criteria andOptidLessThan(String value) {
            addCriterion("optid <", value, "optid");
            return (Criteria) this;
        }

        public Criteria andOptidLessThanOrEqualTo(String value) {
            addCriterion("optid <=", value, "optid");
            return (Criteria) this;
        }

        public Criteria andOptidLike(String value) {
            addCriterion("optid like", value, "optid");
            return (Criteria) this;
        }

        public Criteria andOptidNotLike(String value) {
            addCriterion("optid not like", value, "optid");
            return (Criteria) this;
        }

        public Criteria andOptidIn(List<String> values) {
            addCriterion("optid in", values, "optid");
            return (Criteria) this;
        }

        public Criteria andOptidNotIn(List<String> values) {
            addCriterion("optid not in", values, "optid");
            return (Criteria) this;
        }

        public Criteria andOptidBetween(String value1, String value2) {
            addCriterion("optid between", value1, value2, "optid");
            return (Criteria) this;
        }

        public Criteria andOptidNotBetween(String value1, String value2) {
            addCriterion("optid not between", value1, value2, "optid");
            return (Criteria) this;
        }

        public Criteria andOpttimeIsNull() {
            addCriterion("opttime is null");
            return (Criteria) this;
        }

        public Criteria andOpttimeIsNotNull() {
            addCriterion("opttime is not null");
            return (Criteria) this;
        }

        public Criteria andOpttimeEqualTo(Date value) {
            addCriterion("opttime =", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeNotEqualTo(Date value) {
            addCriterion("opttime <>", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeGreaterThan(Date value) {
            addCriterion("opttime >", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("opttime >=", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeLessThan(Date value) {
            addCriterion("opttime <", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeLessThanOrEqualTo(Date value) {
            addCriterion("opttime <=", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeIn(List<Date> values) {
            addCriterion("opttime in", values, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeNotIn(List<Date> values) {
            addCriterion("opttime not in", values, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeBetween(Date value1, Date value2) {
            addCriterion("opttime between", value1, value2, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeNotBetween(Date value1, Date value2) {
            addCriterion("opttime not between", value1, value2, "opttime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNull() {
            addCriterion("roomid is null");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNotNull() {
            addCriterion("roomid is not null");
            return (Criteria) this;
        }

        public Criteria andRoomidEqualTo(Integer value) {
            addCriterion("roomid =", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotEqualTo(Integer value) {
            addCriterion("roomid <>", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThan(Integer value) {
            addCriterion("roomid >", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomid >=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThan(Integer value) {
            addCriterion("roomid <", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThanOrEqualTo(Integer value) {
            addCriterion("roomid <=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidIn(List<Integer> values) {
            addCriterion("roomid in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotIn(List<Integer> values) {
            addCriterion("roomid not in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidBetween(Integer value1, Integer value2) {
            addCriterion("roomid between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotBetween(Integer value1, Integer value2) {
            addCriterion("roomid not between", value1, value2, "roomid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_equipment_hotel 
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