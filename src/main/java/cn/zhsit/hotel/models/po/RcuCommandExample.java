package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.List;

public class RcuCommandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RcuCommandExample() {
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
     * t_rcu_command 
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

        public Criteria andCommandNameIsNull() {
            addCriterion("command_name is null");
            return (Criteria) this;
        }

        public Criteria andCommandNameIsNotNull() {
            addCriterion("command_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommandNameEqualTo(String value) {
            addCriterion("command_name =", value, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandNameNotEqualTo(String value) {
            addCriterion("command_name <>", value, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandNameGreaterThan(String value) {
            addCriterion("command_name >", value, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandNameGreaterThanOrEqualTo(String value) {
            addCriterion("command_name >=", value, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandNameLessThan(String value) {
            addCriterion("command_name <", value, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandNameLessThanOrEqualTo(String value) {
            addCriterion("command_name <=", value, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandNameLike(String value) {
            addCriterion("command_name like", value, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandNameNotLike(String value) {
            addCriterion("command_name not like", value, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandNameIn(List<String> values) {
            addCriterion("command_name in", values, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandNameNotIn(List<String> values) {
            addCriterion("command_name not in", values, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandNameBetween(String value1, String value2) {
            addCriterion("command_name between", value1, value2, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandNameNotBetween(String value1, String value2) {
            addCriterion("command_name not between", value1, value2, "commandName");
            return (Criteria) this;
        }

        public Criteria andCommandIsNull() {
            addCriterion("command is null");
            return (Criteria) this;
        }

        public Criteria andCommandIsNotNull() {
            addCriterion("command is not null");
            return (Criteria) this;
        }

        public Criteria andCommandEqualTo(String value) {
            addCriterion("command =", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotEqualTo(String value) {
            addCriterion("command <>", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandGreaterThan(String value) {
            addCriterion("command >", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandGreaterThanOrEqualTo(String value) {
            addCriterion("command >=", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLessThan(String value) {
            addCriterion("command <", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLessThanOrEqualTo(String value) {
            addCriterion("command <=", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLike(String value) {
            addCriterion("command like", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotLike(String value) {
            addCriterion("command not like", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandIn(List<String> values) {
            addCriterion("command in", values, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotIn(List<String> values) {
            addCriterion("command not in", values, "command");
            return (Criteria) this;
        }

        public Criteria andCommandBetween(String value1, String value2) {
            addCriterion("command between", value1, value2, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotBetween(String value1, String value2) {
            addCriterion("command not between", value1, value2, "command");
            return (Criteria) this;
        }

        public Criteria andCommandTypeIsNull() {
            addCriterion("command_type is null");
            return (Criteria) this;
        }

        public Criteria andCommandTypeIsNotNull() {
            addCriterion("command_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommandTypeEqualTo(String value) {
            addCriterion("command_type =", value, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandTypeNotEqualTo(String value) {
            addCriterion("command_type <>", value, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandTypeGreaterThan(String value) {
            addCriterion("command_type >", value, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandTypeGreaterThanOrEqualTo(String value) {
            addCriterion("command_type >=", value, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandTypeLessThan(String value) {
            addCriterion("command_type <", value, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandTypeLessThanOrEqualTo(String value) {
            addCriterion("command_type <=", value, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandTypeLike(String value) {
            addCriterion("command_type like", value, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandTypeNotLike(String value) {
            addCriterion("command_type not like", value, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandTypeIn(List<String> values) {
            addCriterion("command_type in", values, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandTypeNotIn(List<String> values) {
            addCriterion("command_type not in", values, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandTypeBetween(String value1, String value2) {
            addCriterion("command_type between", value1, value2, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandTypeNotBetween(String value1, String value2) {
            addCriterion("command_type not between", value1, value2, "commandType");
            return (Criteria) this;
        }

        public Criteria andCommandDescIsNull() {
            addCriterion("command_desc is null");
            return (Criteria) this;
        }

        public Criteria andCommandDescIsNotNull() {
            addCriterion("command_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCommandDescEqualTo(String value) {
            addCriterion("command_desc =", value, "commandDesc");
            return (Criteria) this;
        }

        public Criteria andCommandDescNotEqualTo(String value) {
            addCriterion("command_desc <>", value, "commandDesc");
            return (Criteria) this;
        }

        public Criteria andCommandDescGreaterThan(String value) {
            addCriterion("command_desc >", value, "commandDesc");
            return (Criteria) this;
        }

        public Criteria andCommandDescGreaterThanOrEqualTo(String value) {
            addCriterion("command_desc >=", value, "commandDesc");
            return (Criteria) this;
        }

        public Criteria andCommandDescLessThan(String value) {
            addCriterion("command_desc <", value, "commandDesc");
            return (Criteria) this;
        }

        public Criteria andCommandDescLessThanOrEqualTo(String value) {
            addCriterion("command_desc <=", value, "commandDesc");
            return (Criteria) this;
        }

        public Criteria andCommandDescLike(String value) {
            addCriterion("command_desc like", value, "commandDesc");
            return (Criteria) this;
        }

        public Criteria andCommandDescNotLike(String value) {
            addCriterion("command_desc not like", value, "commandDesc");
            return (Criteria) this;
        }

        public Criteria andCommandDescIn(List<String> values) {
            addCriterion("command_desc in", values, "commandDesc");
            return (Criteria) this;
        }

        public Criteria andCommandDescNotIn(List<String> values) {
            addCriterion("command_desc not in", values, "commandDesc");
            return (Criteria) this;
        }

        public Criteria andCommandDescBetween(String value1, String value2) {
            addCriterion("command_desc between", value1, value2, "commandDesc");
            return (Criteria) this;
        }

        public Criteria andCommandDescNotBetween(String value1, String value2) {
            addCriterion("command_desc not between", value1, value2, "commandDesc");
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

        public Criteria andRoomidEqualTo(String value) {
            addCriterion("roomid =", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotEqualTo(String value) {
            addCriterion("roomid <>", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThan(String value) {
            addCriterion("roomid >", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThanOrEqualTo(String value) {
            addCriterion("roomid >=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThan(String value) {
            addCriterion("roomid <", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThanOrEqualTo(String value) {
            addCriterion("roomid <=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLike(String value) {
            addCriterion("roomid like", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotLike(String value) {
            addCriterion("roomid not like", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidIn(List<String> values) {
            addCriterion("roomid in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotIn(List<String> values) {
            addCriterion("roomid not in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidBetween(String value1, String value2) {
            addCriterion("roomid between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotBetween(String value1, String value2) {
            addCriterion("roomid not between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andVersionidIsNull() {
            addCriterion("versionid is null");
            return (Criteria) this;
        }

        public Criteria andVersionidIsNotNull() {
            addCriterion("versionid is not null");
            return (Criteria) this;
        }

        public Criteria andVersionidEqualTo(Integer value) {
            addCriterion("versionid =", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidNotEqualTo(Integer value) {
            addCriterion("versionid <>", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidGreaterThan(Integer value) {
            addCriterion("versionid >", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("versionid >=", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidLessThan(Integer value) {
            addCriterion("versionid <", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidLessThanOrEqualTo(Integer value) {
            addCriterion("versionid <=", value, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidIn(List<Integer> values) {
            addCriterion("versionid in", values, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidNotIn(List<Integer> values) {
            addCriterion("versionid not in", values, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidBetween(Integer value1, Integer value2) {
            addCriterion("versionid between", value1, value2, "versionid");
            return (Criteria) this;
        }

        public Criteria andVersionidNotBetween(Integer value1, Integer value2) {
            addCriterion("versionid not between", value1, value2, "versionid");
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
     * t_rcu_command 
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