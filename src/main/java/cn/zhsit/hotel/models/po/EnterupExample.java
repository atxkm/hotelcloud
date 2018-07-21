package cn.zhsit.hotel.models.po;

import cn.zhsit.common.utils.page.BaseExample;

import java.util.ArrayList;
import java.util.List;

public class EnterupExample extends BaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterupExample() {
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
     * t_enterup
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

        public Criteria andEnteridIsNull() {
            addCriterion("enterid is null");
            return (Criteria) this;
        }

        public Criteria andEnteridIsNotNull() {
            addCriterion("enterid is not null");
            return (Criteria) this;
        }

        public Criteria andEnteridEqualTo(String value) {
            addCriterion("enterid =", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridNotEqualTo(String value) {
            addCriterion("enterid <>", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridGreaterThan(String value) {
            addCriterion("enterid >", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridGreaterThanOrEqualTo(String value) {
            addCriterion("enterid >=", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridLessThan(String value) {
            addCriterion("enterid <", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridLessThanOrEqualTo(String value) {
            addCriterion("enterid <=", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridLike(String value) {
            addCriterion("enterid like", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridNotLike(String value) {
            addCriterion("enterid not like", value, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridIn(List<String> values) {
            addCriterion("enterid in", values, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridNotIn(List<String> values) {
            addCriterion("enterid not in", values, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridBetween(String value1, String value2) {
            addCriterion("enterid between", value1, value2, "enterid");
            return (Criteria) this;
        }

        public Criteria andEnteridNotBetween(String value1, String value2) {
            addCriterion("enterid not between", value1, value2, "enterid");
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

        public Criteria andGuestnameIsNull() {
            addCriterion("guestname is null");
            return (Criteria) this;
        }

        public Criteria andGuestnameIsNotNull() {
            addCriterion("guestname is not null");
            return (Criteria) this;
        }

        public Criteria andGuestnameEqualTo(String value) {
            addCriterion("guestname =", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameNotEqualTo(String value) {
            addCriterion("guestname <>", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameGreaterThan(String value) {
            addCriterion("guestname >", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameGreaterThanOrEqualTo(String value) {
            addCriterion("guestname >=", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameLessThan(String value) {
            addCriterion("guestname <", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameLessThanOrEqualTo(String value) {
            addCriterion("guestname <=", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameLike(String value) {
            addCriterion("guestname like", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameNotLike(String value) {
            addCriterion("guestname not like", value, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameIn(List<String> values) {
            addCriterion("guestname in", values, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameNotIn(List<String> values) {
            addCriterion("guestname not in", values, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameBetween(String value1, String value2) {
            addCriterion("guestname between", value1, value2, "guestname");
            return (Criteria) this;
        }

        public Criteria andGuestnameNotBetween(String value1, String value2) {
            addCriterion("guestname not between", value1, value2, "guestname");
            return (Criteria) this;
        }

        public Criteria andCardnoIsNull() {
            addCriterion("cardno is null");
            return (Criteria) this;
        }

        public Criteria andCardnoIsNotNull() {
            addCriterion("cardno is not null");
            return (Criteria) this;
        }

        public Criteria andCardnoEqualTo(String value) {
            addCriterion("cardno =", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotEqualTo(String value) {
            addCriterion("cardno <>", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoGreaterThan(String value) {
            addCriterion("cardno >", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoGreaterThanOrEqualTo(String value) {
            addCriterion("cardno >=", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLessThan(String value) {
            addCriterion("cardno <", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLessThanOrEqualTo(String value) {
            addCriterion("cardno <=", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLike(String value) {
            addCriterion("cardno like", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotLike(String value) {
            addCriterion("cardno not like", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoIn(List<String> values) {
            addCriterion("cardno in", values, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotIn(List<String> values) {
            addCriterion("cardno not in", values, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoBetween(String value1, String value2) {
            addCriterion("cardno between", value1, value2, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotBetween(String value1, String value2) {
            addCriterion("cardno not between", value1, value2, "cardno");
            return (Criteria) this;
        }

        public Criteria andEntertimeIsNull() {
            addCriterion("entertime is null");
            return (Criteria) this;
        }

        public Criteria andEntertimeIsNotNull() {
            addCriterion("entertime is not null");
            return (Criteria) this;
        }

        public Criteria andEntertimeEqualTo(String value) {
            addCriterion("entertime =", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotEqualTo(String value) {
            addCriterion("entertime <>", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeGreaterThan(String value) {
            addCriterion("entertime >", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeGreaterThanOrEqualTo(String value) {
            addCriterion("entertime >=", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeLessThan(String value) {
            addCriterion("entertime <", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeLessThanOrEqualTo(String value) {
            addCriterion("entertime <=", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeLike(String value) {
            addCriterion("entertime like", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotLike(String value) {
            addCriterion("entertime not like", value, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeIn(List<String> values) {
            addCriterion("entertime in", values, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotIn(List<String> values) {
            addCriterion("entertime not in", values, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeBetween(String value1, String value2) {
            addCriterion("entertime between", value1, value2, "entertime");
            return (Criteria) this;
        }

        public Criteria andEntertimeNotBetween(String value1, String value2) {
            addCriterion("entertime not between", value1, value2, "entertime");
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

        public Criteria andOpttimeEqualTo(String value) {
            addCriterion("opttime =", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeNotEqualTo(String value) {
            addCriterion("opttime <>", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeGreaterThan(String value) {
            addCriterion("opttime >", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeGreaterThanOrEqualTo(String value) {
            addCriterion("opttime >=", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeLessThan(String value) {
            addCriterion("opttime <", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeLessThanOrEqualTo(String value) {
            addCriterion("opttime <=", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeLike(String value) {
            addCriterion("opttime like", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeNotLike(String value) {
            addCriterion("opttime not like", value, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeIn(List<String> values) {
            addCriterion("opttime in", values, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeNotIn(List<String> values) {
            addCriterion("opttime not in", values, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeBetween(String value1, String value2) {
            addCriterion("opttime between", value1, value2, "opttime");
            return (Criteria) this;
        }

        public Criteria andOpttimeNotBetween(String value1, String value2) {
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

        public Criteria andGuestmobileIsNull() {
            addCriterion("guestmobile is null");
            return (Criteria) this;
        }

        public Criteria andGuestmobileIsNotNull() {
            addCriterion("guestmobile is not null");
            return (Criteria) this;
        }

        public Criteria andGuestmobileEqualTo(String value) {
            addCriterion("guestmobile =", value, "guestmobile");
            return (Criteria) this;
        }

        public Criteria andGuestmobileNotEqualTo(String value) {
            addCriterion("guestmobile <>", value, "guestmobile");
            return (Criteria) this;
        }

        public Criteria andGuestmobileGreaterThan(String value) {
            addCriterion("guestmobile >", value, "guestmobile");
            return (Criteria) this;
        }

        public Criteria andGuestmobileGreaterThanOrEqualTo(String value) {
            addCriterion("guestmobile >=", value, "guestmobile");
            return (Criteria) this;
        }

        public Criteria andGuestmobileLessThan(String value) {
            addCriterion("guestmobile <", value, "guestmobile");
            return (Criteria) this;
        }

        public Criteria andGuestmobileLessThanOrEqualTo(String value) {
            addCriterion("guestmobile <=", value, "guestmobile");
            return (Criteria) this;
        }

        public Criteria andGuestmobileLike(String value) {
            addCriterion("guestmobile like", value, "guestmobile");
            return (Criteria) this;
        }

        public Criteria andGuestmobileNotLike(String value) {
            addCriterion("guestmobile not like", value, "guestmobile");
            return (Criteria) this;
        }

        public Criteria andGuestmobileIn(List<String> values) {
            addCriterion("guestmobile in", values, "guestmobile");
            return (Criteria) this;
        }

        public Criteria andGuestmobileNotIn(List<String> values) {
            addCriterion("guestmobile not in", values, "guestmobile");
            return (Criteria) this;
        }

        public Criteria andGuestmobileBetween(String value1, String value2) {
            addCriterion("guestmobile between", value1, value2, "guestmobile");
            return (Criteria) this;
        }

        public Criteria andGuestmobileNotBetween(String value1, String value2) {
            addCriterion("guestmobile not between", value1, value2, "guestmobile");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_enterup
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