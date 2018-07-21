package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomtypeEquipmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomtypeEquipmentExample() {
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
     * t_roomtype_equipment 
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

        public Criteria andEquidIsNull() {
            addCriterion("equid is null");
            return (Criteria) this;
        }

        public Criteria andEquidIsNotNull() {
            addCriterion("equid is not null");
            return (Criteria) this;
        }

        public Criteria andEquidEqualTo(String value) {
            addCriterion("equid =", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidNotEqualTo(String value) {
            addCriterion("equid <>", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidGreaterThan(String value) {
            addCriterion("equid >", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidGreaterThanOrEqualTo(String value) {
            addCriterion("equid >=", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidLessThan(String value) {
            addCriterion("equid <", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidLessThanOrEqualTo(String value) {
            addCriterion("equid <=", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidLike(String value) {
            addCriterion("equid like", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidNotLike(String value) {
            addCriterion("equid not like", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidIn(List<String> values) {
            addCriterion("equid in", values, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidNotIn(List<String> values) {
            addCriterion("equid not in", values, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidBetween(String value1, String value2) {
            addCriterion("equid between", value1, value2, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidNotBetween(String value1, String value2) {
            addCriterion("equid not between", value1, value2, "equid");
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

        public Criteria andElecroadIsNull() {
            addCriterion("elecroad is null");
            return (Criteria) this;
        }

        public Criteria andElecroadIsNotNull() {
            addCriterion("elecroad is not null");
            return (Criteria) this;
        }

        public Criteria andElecroadEqualTo(String value) {
            addCriterion("elecroad =", value, "elecroad");
            return (Criteria) this;
        }

        public Criteria andElecroadNotEqualTo(String value) {
            addCriterion("elecroad <>", value, "elecroad");
            return (Criteria) this;
        }

        public Criteria andElecroadGreaterThan(String value) {
            addCriterion("elecroad >", value, "elecroad");
            return (Criteria) this;
        }

        public Criteria andElecroadGreaterThanOrEqualTo(String value) {
            addCriterion("elecroad >=", value, "elecroad");
            return (Criteria) this;
        }

        public Criteria andElecroadLessThan(String value) {
            addCriterion("elecroad <", value, "elecroad");
            return (Criteria) this;
        }

        public Criteria andElecroadLessThanOrEqualTo(String value) {
            addCriterion("elecroad <=", value, "elecroad");
            return (Criteria) this;
        }

        public Criteria andElecroadLike(String value) {
            addCriterion("elecroad like", value, "elecroad");
            return (Criteria) this;
        }

        public Criteria andElecroadNotLike(String value) {
            addCriterion("elecroad not like", value, "elecroad");
            return (Criteria) this;
        }

        public Criteria andElecroadIn(List<String> values) {
            addCriterion("elecroad in", values, "elecroad");
            return (Criteria) this;
        }

        public Criteria andElecroadNotIn(List<String> values) {
            addCriterion("elecroad not in", values, "elecroad");
            return (Criteria) this;
        }

        public Criteria andElecroadBetween(String value1, String value2) {
            addCriterion("elecroad between", value1, value2, "elecroad");
            return (Criteria) this;
        }

        public Criteria andElecroadNotBetween(String value1, String value2) {
            addCriterion("elecroad not between", value1, value2, "elecroad");
            return (Criteria) this;
        }

        public Criteria andEqutypeIsNull() {
            addCriterion("equtype is null");
            return (Criteria) this;
        }

        public Criteria andEqutypeIsNotNull() {
            addCriterion("equtype is not null");
            return (Criteria) this;
        }

        public Criteria andEqutypeEqualTo(String value) {
            addCriterion("equtype =", value, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqutypeNotEqualTo(String value) {
            addCriterion("equtype <>", value, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqutypeGreaterThan(String value) {
            addCriterion("equtype >", value, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqutypeGreaterThanOrEqualTo(String value) {
            addCriterion("equtype >=", value, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqutypeLessThan(String value) {
            addCriterion("equtype <", value, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqutypeLessThanOrEqualTo(String value) {
            addCriterion("equtype <=", value, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqutypeLike(String value) {
            addCriterion("equtype like", value, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqutypeNotLike(String value) {
            addCriterion("equtype not like", value, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqutypeIn(List<String> values) {
            addCriterion("equtype in", values, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqutypeNotIn(List<String> values) {
            addCriterion("equtype not in", values, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqutypeBetween(String value1, String value2) {
            addCriterion("equtype between", value1, value2, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqutypeNotBetween(String value1, String value2) {
            addCriterion("equtype not between", value1, value2, "equtype");
            return (Criteria) this;
        }

        public Criteria andEqunameIsNull() {
            addCriterion("equname is null");
            return (Criteria) this;
        }

        public Criteria andEqunameIsNotNull() {
            addCriterion("equname is not null");
            return (Criteria) this;
        }

        public Criteria andEqunameEqualTo(String value) {
            addCriterion("equname =", value, "equname");
            return (Criteria) this;
        }

        public Criteria andEqunameNotEqualTo(String value) {
            addCriterion("equname <>", value, "equname");
            return (Criteria) this;
        }

        public Criteria andEqunameGreaterThan(String value) {
            addCriterion("equname >", value, "equname");
            return (Criteria) this;
        }

        public Criteria andEqunameGreaterThanOrEqualTo(String value) {
            addCriterion("equname >=", value, "equname");
            return (Criteria) this;
        }

        public Criteria andEqunameLessThan(String value) {
            addCriterion("equname <", value, "equname");
            return (Criteria) this;
        }

        public Criteria andEqunameLessThanOrEqualTo(String value) {
            addCriterion("equname <=", value, "equname");
            return (Criteria) this;
        }

        public Criteria andEqunameLike(String value) {
            addCriterion("equname like", value, "equname");
            return (Criteria) this;
        }

        public Criteria andEqunameNotLike(String value) {
            addCriterion("equname not like", value, "equname");
            return (Criteria) this;
        }

        public Criteria andEqunameIn(List<String> values) {
            addCriterion("equname in", values, "equname");
            return (Criteria) this;
        }

        public Criteria andEqunameNotIn(List<String> values) {
            addCriterion("equname not in", values, "equname");
            return (Criteria) this;
        }

        public Criteria andEqunameBetween(String value1, String value2) {
            addCriterion("equname between", value1, value2, "equname");
            return (Criteria) this;
        }

        public Criteria andEqunameNotBetween(String value1, String value2) {
            addCriterion("equname not between", value1, value2, "equname");
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
     * t_roomtype_equipment 
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