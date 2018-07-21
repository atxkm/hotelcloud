package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.tools.doclets.internal.toolkit.taglets.BasePropertyTaglet;

import cn.zhsit.common.utils.page.BaseExample;

public class EquipmentDefaultvalExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentDefaultvalExample() {
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
     * t_equipment_defaultval 
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

        public Criteria andModelidIsNull() {
            addCriterion("modelid is null");
            return (Criteria) this;
        }

        public Criteria andModelidIsNotNull() {
            addCriterion("modelid is not null");
            return (Criteria) this;
        }

        public Criteria andModelidEqualTo(String value) {
            addCriterion("modelid =", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidNotEqualTo(String value) {
            addCriterion("modelid <>", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidGreaterThan(String value) {
            addCriterion("modelid >", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidGreaterThanOrEqualTo(String value) {
            addCriterion("modelid >=", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidLessThan(String value) {
            addCriterion("modelid <", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidLessThanOrEqualTo(String value) {
            addCriterion("modelid <=", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidLike(String value) {
            addCriterion("modelid like", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidNotLike(String value) {
            addCriterion("modelid not like", value, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidIn(List<String> values) {
            addCriterion("modelid in", values, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidNotIn(List<String> values) {
            addCriterion("modelid not in", values, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidBetween(String value1, String value2) {
            addCriterion("modelid between", value1, value2, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelidNotBetween(String value1, String value2) {
            addCriterion("modelid not between", value1, value2, "modelid");
            return (Criteria) this;
        }

        public Criteria andModelnameIsNull() {
            addCriterion("modelname is null");
            return (Criteria) this;
        }

        public Criteria andModelnameIsNotNull() {
            addCriterion("modelname is not null");
            return (Criteria) this;
        }

        public Criteria andModelnameEqualTo(String value) {
            addCriterion("modelname =", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotEqualTo(String value) {
            addCriterion("modelname <>", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameGreaterThan(String value) {
            addCriterion("modelname >", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameGreaterThanOrEqualTo(String value) {
            addCriterion("modelname >=", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLessThan(String value) {
            addCriterion("modelname <", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLessThanOrEqualTo(String value) {
            addCriterion("modelname <=", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameLike(String value) {
            addCriterion("modelname like", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotLike(String value) {
            addCriterion("modelname not like", value, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameIn(List<String> values) {
            addCriterion("modelname in", values, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotIn(List<String> values) {
            addCriterion("modelname not in", values, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameBetween(String value1, String value2) {
            addCriterion("modelname between", value1, value2, "modelname");
            return (Criteria) this;
        }

        public Criteria andModelnameNotBetween(String value1, String value2) {
            addCriterion("modelname not between", value1, value2, "modelname");
            return (Criteria) this;
        }

        public Criteria andModeltypeIsNull() {
            addCriterion("modeltype is null");
            return (Criteria) this;
        }

        public Criteria andModeltypeIsNotNull() {
            addCriterion("modeltype is not null");
            return (Criteria) this;
        }

        public Criteria andModeltypeEqualTo(String value) {
            addCriterion("modeltype =", value, "modeltype");
            return (Criteria) this;
        }

        public Criteria andModeltypeNotEqualTo(String value) {
            addCriterion("modeltype <>", value, "modeltype");
            return (Criteria) this;
        }

        public Criteria andModeltypeGreaterThan(String value) {
            addCriterion("modeltype >", value, "modeltype");
            return (Criteria) this;
        }

        public Criteria andModeltypeGreaterThanOrEqualTo(String value) {
            addCriterion("modeltype >=", value, "modeltype");
            return (Criteria) this;
        }

        public Criteria andModeltypeLessThan(String value) {
            addCriterion("modeltype <", value, "modeltype");
            return (Criteria) this;
        }

        public Criteria andModeltypeLessThanOrEqualTo(String value) {
            addCriterion("modeltype <=", value, "modeltype");
            return (Criteria) this;
        }

        public Criteria andModeltypeLike(String value) {
            addCriterion("modeltype like", value, "modeltype");
            return (Criteria) this;
        }

        public Criteria andModeltypeNotLike(String value) {
            addCriterion("modeltype not like", value, "modeltype");
            return (Criteria) this;
        }

        public Criteria andModeltypeIn(List<String> values) {
            addCriterion("modeltype in", values, "modeltype");
            return (Criteria) this;
        }

        public Criteria andModeltypeNotIn(List<String> values) {
            addCriterion("modeltype not in", values, "modeltype");
            return (Criteria) this;
        }

        public Criteria andModeltypeBetween(String value1, String value2) {
            addCriterion("modeltype between", value1, value2, "modeltype");
            return (Criteria) this;
        }

        public Criteria andModeltypeNotBetween(String value1, String value2) {
            addCriterion("modeltype not between", value1, value2, "modeltype");
            return (Criteria) this;
        }

        public Criteria andEquipmentIsNull() {
            addCriterion("equipment is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIsNotNull() {
            addCriterion("equipment is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentEqualTo(String value) {
            addCriterion("equipment =", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotEqualTo(String value) {
            addCriterion("equipment <>", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentGreaterThan(String value) {
            addCriterion("equipment >", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentGreaterThanOrEqualTo(String value) {
            addCriterion("equipment >=", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentLessThan(String value) {
            addCriterion("equipment <", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentLessThanOrEqualTo(String value) {
            addCriterion("equipment <=", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentLike(String value) {
            addCriterion("equipment like", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotLike(String value) {
            addCriterion("equipment not like", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentIn(List<String> values) {
            addCriterion("equipment in", values, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotIn(List<String> values) {
            addCriterion("equipment not in", values, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentBetween(String value1, String value2) {
            addCriterion("equipment between", value1, value2, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotBetween(String value1, String value2) {
            addCriterion("equipment not between", value1, value2, "equipment");
            return (Criteria) this;
        }

        public Criteria andModelvalIsNull() {
            addCriterion("modelval is null");
            return (Criteria) this;
        }

        public Criteria andModelvalIsNotNull() {
            addCriterion("modelval is not null");
            return (Criteria) this;
        }

        public Criteria andModelvalEqualTo(String value) {
            addCriterion("modelval =", value, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelvalNotEqualTo(String value) {
            addCriterion("modelval <>", value, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelvalGreaterThan(String value) {
            addCriterion("modelval >", value, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelvalGreaterThanOrEqualTo(String value) {
            addCriterion("modelval >=", value, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelvalLessThan(String value) {
            addCriterion("modelval <", value, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelvalLessThanOrEqualTo(String value) {
            addCriterion("modelval <=", value, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelvalLike(String value) {
            addCriterion("modelval like", value, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelvalNotLike(String value) {
            addCriterion("modelval not like", value, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelvalIn(List<String> values) {
            addCriterion("modelval in", values, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelvalNotIn(List<String> values) {
            addCriterion("modelval not in", values, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelvalBetween(String value1, String value2) {
            addCriterion("modelval between", value1, value2, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelvalNotBetween(String value1, String value2) {
            addCriterion("modelval not between", value1, value2, "modelval");
            return (Criteria) this;
        }

        public Criteria andModelsettimeIsNull() {
            addCriterion("modelsettime is null");
            return (Criteria) this;
        }

        public Criteria andModelsettimeIsNotNull() {
            addCriterion("modelsettime is not null");
            return (Criteria) this;
        }

        public Criteria andModelsettimeEqualTo(String value) {
            addCriterion("modelsettime =", value, "modelsettime");
            return (Criteria) this;
        }

        public Criteria andModelsettimeNotEqualTo(String value) {
            addCriterion("modelsettime <>", value, "modelsettime");
            return (Criteria) this;
        }

        public Criteria andModelsettimeGreaterThan(String value) {
            addCriterion("modelsettime >", value, "modelsettime");
            return (Criteria) this;
        }

        public Criteria andModelsettimeGreaterThanOrEqualTo(String value) {
            addCriterion("modelsettime >=", value, "modelsettime");
            return (Criteria) this;
        }

        public Criteria andModelsettimeLessThan(String value) {
            addCriterion("modelsettime <", value, "modelsettime");
            return (Criteria) this;
        }

        public Criteria andModelsettimeLessThanOrEqualTo(String value) {
            addCriterion("modelsettime <=", value, "modelsettime");
            return (Criteria) this;
        }

        public Criteria andModelsettimeLike(String value) {
            addCriterion("modelsettime like", value, "modelsettime");
            return (Criteria) this;
        }

        public Criteria andModelsettimeNotLike(String value) {
            addCriterion("modelsettime not like", value, "modelsettime");
            return (Criteria) this;
        }

        public Criteria andModelsettimeIn(List<String> values) {
            addCriterion("modelsettime in", values, "modelsettime");
            return (Criteria) this;
        }

        public Criteria andModelsettimeNotIn(List<String> values) {
            addCriterion("modelsettime not in", values, "modelsettime");
            return (Criteria) this;
        }

        public Criteria andModelsettimeBetween(String value1, String value2) {
            addCriterion("modelsettime between", value1, value2, "modelsettime");
            return (Criteria) this;
        }

        public Criteria andModelsettimeNotBetween(String value1, String value2) {
            addCriterion("modelsettime not between", value1, value2, "modelsettime");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_equipment_defaultval 
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