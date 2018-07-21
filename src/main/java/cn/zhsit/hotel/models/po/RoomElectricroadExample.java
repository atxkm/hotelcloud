package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.List;

public class RoomElectricroadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomElectricroadExample() {
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
     * t_room_electricroad 
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

        public Criteria andRmeleidIsNull() {
            addCriterion("rmeleid is null");
            return (Criteria) this;
        }

        public Criteria andRmeleidIsNotNull() {
            addCriterion("rmeleid is not null");
            return (Criteria) this;
        }

        public Criteria andRmeleidEqualTo(String value) {
            addCriterion("rmeleid =", value, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andRmeleidNotEqualTo(String value) {
            addCriterion("rmeleid <>", value, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andRmeleidGreaterThan(String value) {
            addCriterion("rmeleid >", value, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andRmeleidGreaterThanOrEqualTo(String value) {
            addCriterion("rmeleid >=", value, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andRmeleidLessThan(String value) {
            addCriterion("rmeleid <", value, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andRmeleidLessThanOrEqualTo(String value) {
            addCriterion("rmeleid <=", value, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andRmeleidLike(String value) {
            addCriterion("rmeleid like", value, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andRmeleidNotLike(String value) {
            addCriterion("rmeleid not like", value, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andRmeleidIn(List<String> values) {
            addCriterion("rmeleid in", values, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andRmeleidNotIn(List<String> values) {
            addCriterion("rmeleid not in", values, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andRmeleidBetween(String value1, String value2) {
            addCriterion("rmeleid between", value1, value2, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andRmeleidNotBetween(String value1, String value2) {
            addCriterion("rmeleid not between", value1, value2, "rmeleid");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("typeid is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeid is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(String value) {
            addCriterion("typeid =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(String value) {
            addCriterion("typeid <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(String value) {
            addCriterion("typeid >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(String value) {
            addCriterion("typeid >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(String value) {
            addCriterion("typeid <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(String value) {
            addCriterion("typeid <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLike(String value) {
            addCriterion("typeid like", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotLike(String value) {
            addCriterion("typeid not like", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<String> values) {
            addCriterion("typeid in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<String> values) {
            addCriterion("typeid not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(String value1, String value2) {
            addCriterion("typeid between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(String value1, String value2) {
            addCriterion("typeid not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andElectricIsNull() {
            addCriterion("electric is null");
            return (Criteria) this;
        }

        public Criteria andElectricIsNotNull() {
            addCriterion("electric is not null");
            return (Criteria) this;
        }

        public Criteria andElectricEqualTo(String value) {
            addCriterion("electric =", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricNotEqualTo(String value) {
            addCriterion("electric <>", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricGreaterThan(String value) {
            addCriterion("electric >", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricGreaterThanOrEqualTo(String value) {
            addCriterion("electric >=", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricLessThan(String value) {
            addCriterion("electric <", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricLessThanOrEqualTo(String value) {
            addCriterion("electric <=", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricLike(String value) {
            addCriterion("electric like", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricNotLike(String value) {
            addCriterion("electric not like", value, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricIn(List<String> values) {
            addCriterion("electric in", values, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricNotIn(List<String> values) {
            addCriterion("electric not in", values, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricBetween(String value1, String value2) {
            addCriterion("electric between", value1, value2, "electric");
            return (Criteria) this;
        }

        public Criteria andElectricNotBetween(String value1, String value2) {
            addCriterion("electric not between", value1, value2, "electric");
            return (Criteria) this;
        }

        public Criteria andElenameIsNull() {
            addCriterion("elename is null");
            return (Criteria) this;
        }

        public Criteria andElenameIsNotNull() {
            addCriterion("elename is not null");
            return (Criteria) this;
        }

        public Criteria andElenameEqualTo(String value) {
            addCriterion("elename =", value, "elename");
            return (Criteria) this;
        }

        public Criteria andElenameNotEqualTo(String value) {
            addCriterion("elename <>", value, "elename");
            return (Criteria) this;
        }

        public Criteria andElenameGreaterThan(String value) {
            addCriterion("elename >", value, "elename");
            return (Criteria) this;
        }

        public Criteria andElenameGreaterThanOrEqualTo(String value) {
            addCriterion("elename >=", value, "elename");
            return (Criteria) this;
        }

        public Criteria andElenameLessThan(String value) {
            addCriterion("elename <", value, "elename");
            return (Criteria) this;
        }

        public Criteria andElenameLessThanOrEqualTo(String value) {
            addCriterion("elename <=", value, "elename");
            return (Criteria) this;
        }

        public Criteria andElenameLike(String value) {
            addCriterion("elename like", value, "elename");
            return (Criteria) this;
        }

        public Criteria andElenameNotLike(String value) {
            addCriterion("elename not like", value, "elename");
            return (Criteria) this;
        }

        public Criteria andElenameIn(List<String> values) {
            addCriterion("elename in", values, "elename");
            return (Criteria) this;
        }

        public Criteria andElenameNotIn(List<String> values) {
            addCriterion("elename not in", values, "elename");
            return (Criteria) this;
        }

        public Criteria andElenameBetween(String value1, String value2) {
            addCriterion("elename between", value1, value2, "elename");
            return (Criteria) this;
        }

        public Criteria andElenameNotBetween(String value1, String value2) {
            addCriterion("elename not between", value1, value2, "elename");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_room_electricroad 
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