package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.List;

public class SoftRegExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SoftRegExample() {
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
     * t_soft_reg 
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andMachinenoIsNull() {
            addCriterion("machineno is null");
            return (Criteria) this;
        }

        public Criteria andMachinenoIsNotNull() {
            addCriterion("machineno is not null");
            return (Criteria) this;
        }

        public Criteria andMachinenoEqualTo(String value) {
            addCriterion("machineno =", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoNotEqualTo(String value) {
            addCriterion("machineno <>", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoGreaterThan(String value) {
            addCriterion("machineno >", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoGreaterThanOrEqualTo(String value) {
            addCriterion("machineno >=", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoLessThan(String value) {
            addCriterion("machineno <", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoLessThanOrEqualTo(String value) {
            addCriterion("machineno <=", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoLike(String value) {
            addCriterion("machineno like", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoNotLike(String value) {
            addCriterion("machineno not like", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoIn(List<String> values) {
            addCriterion("machineno in", values, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoNotIn(List<String> values) {
            addCriterion("machineno not in", values, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoBetween(String value1, String value2) {
            addCriterion("machineno between", value1, value2, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoNotBetween(String value1, String value2) {
            addCriterion("machineno not between", value1, value2, "machineno");
            return (Criteria) this;
        }

        public Criteria andRegnumberIsNull() {
            addCriterion("regnumber is null");
            return (Criteria) this;
        }

        public Criteria andRegnumberIsNotNull() {
            addCriterion("regnumber is not null");
            return (Criteria) this;
        }

        public Criteria andRegnumberEqualTo(String value) {
            addCriterion("regnumber =", value, "regnumber");
            return (Criteria) this;
        }

        public Criteria andRegnumberNotEqualTo(String value) {
            addCriterion("regnumber <>", value, "regnumber");
            return (Criteria) this;
        }

        public Criteria andRegnumberGreaterThan(String value) {
            addCriterion("regnumber >", value, "regnumber");
            return (Criteria) this;
        }

        public Criteria andRegnumberGreaterThanOrEqualTo(String value) {
            addCriterion("regnumber >=", value, "regnumber");
            return (Criteria) this;
        }

        public Criteria andRegnumberLessThan(String value) {
            addCriterion("regnumber <", value, "regnumber");
            return (Criteria) this;
        }

        public Criteria andRegnumberLessThanOrEqualTo(String value) {
            addCriterion("regnumber <=", value, "regnumber");
            return (Criteria) this;
        }

        public Criteria andRegnumberLike(String value) {
            addCriterion("regnumber like", value, "regnumber");
            return (Criteria) this;
        }

        public Criteria andRegnumberNotLike(String value) {
            addCriterion("regnumber not like", value, "regnumber");
            return (Criteria) this;
        }

        public Criteria andRegnumberIn(List<String> values) {
            addCriterion("regnumber in", values, "regnumber");
            return (Criteria) this;
        }

        public Criteria andRegnumberNotIn(List<String> values) {
            addCriterion("regnumber not in", values, "regnumber");
            return (Criteria) this;
        }

        public Criteria andRegnumberBetween(String value1, String value2) {
            addCriterion("regnumber between", value1, value2, "regnumber");
            return (Criteria) this;
        }

        public Criteria andRegnumberNotBetween(String value1, String value2) {
            addCriterion("regnumber not between", value1, value2, "regnumber");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNull() {
            addCriterion("startdate is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("startdate is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(String value) {
            addCriterion("startdate =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(String value) {
            addCriterion("startdate <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(String value) {
            addCriterion("startdate >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(String value) {
            addCriterion("startdate >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(String value) {
            addCriterion("startdate <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(String value) {
            addCriterion("startdate <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLike(String value) {
            addCriterion("startdate like", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotLike(String value) {
            addCriterion("startdate not like", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<String> values) {
            addCriterion("startdate in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<String> values) {
            addCriterion("startdate not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(String value1, String value2) {
            addCriterion("startdate between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(String value1, String value2) {
            addCriterion("startdate not between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(String value) {
            addCriterion("enddate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(String value) {
            addCriterion("enddate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(String value) {
            addCriterion("enddate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(String value) {
            addCriterion("enddate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(String value) {
            addCriterion("enddate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(String value) {
            addCriterion("enddate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLike(String value) {
            addCriterion("enddate like", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotLike(String value) {
            addCriterion("enddate not like", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<String> values) {
            addCriterion("enddate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<String> values) {
            addCriterion("enddate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(String value1, String value2) {
            addCriterion("enddate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(String value1, String value2) {
            addCriterion("enddate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andRegstatusIsNull() {
            addCriterion("regstatus is null");
            return (Criteria) this;
        }

        public Criteria andRegstatusIsNotNull() {
            addCriterion("regstatus is not null");
            return (Criteria) this;
        }

        public Criteria andRegstatusEqualTo(String value) {
            addCriterion("regstatus =", value, "regstatus");
            return (Criteria) this;
        }

        public Criteria andRegstatusNotEqualTo(String value) {
            addCriterion("regstatus <>", value, "regstatus");
            return (Criteria) this;
        }

        public Criteria andRegstatusGreaterThan(String value) {
            addCriterion("regstatus >", value, "regstatus");
            return (Criteria) this;
        }

        public Criteria andRegstatusGreaterThanOrEqualTo(String value) {
            addCriterion("regstatus >=", value, "regstatus");
            return (Criteria) this;
        }

        public Criteria andRegstatusLessThan(String value) {
            addCriterion("regstatus <", value, "regstatus");
            return (Criteria) this;
        }

        public Criteria andRegstatusLessThanOrEqualTo(String value) {
            addCriterion("regstatus <=", value, "regstatus");
            return (Criteria) this;
        }

        public Criteria andRegstatusLike(String value) {
            addCriterion("regstatus like", value, "regstatus");
            return (Criteria) this;
        }

        public Criteria andRegstatusNotLike(String value) {
            addCriterion("regstatus not like", value, "regstatus");
            return (Criteria) this;
        }

        public Criteria andRegstatusIn(List<String> values) {
            addCriterion("regstatus in", values, "regstatus");
            return (Criteria) this;
        }

        public Criteria andRegstatusNotIn(List<String> values) {
            addCriterion("regstatus not in", values, "regstatus");
            return (Criteria) this;
        }

        public Criteria andRegstatusBetween(String value1, String value2) {
            addCriterion("regstatus between", value1, value2, "regstatus");
            return (Criteria) this;
        }

        public Criteria andRegstatusNotBetween(String value1, String value2) {
            addCriterion("regstatus not between", value1, value2, "regstatus");
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
     * t_soft_reg 
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