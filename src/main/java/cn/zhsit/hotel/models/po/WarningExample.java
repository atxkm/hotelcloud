package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.zhsit.common.utils.page.BaseExample;

public class WarningExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WarningExample() {
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
     * t_warning
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

        public Criteria andWarningidIsNull() {
            addCriterion("warningid is null");
            return (Criteria) this;
        }

        public Criteria andWarningidIsNotNull() {
            addCriterion("warningid is not null");
            return (Criteria) this;
        }

        public Criteria andWarningidEqualTo(String value) {
            addCriterion("warningid =", value, "warningid");
            return (Criteria) this;
        }

        public Criteria andWarningidNotEqualTo(String value) {
            addCriterion("warningid <>", value, "warningid");
            return (Criteria) this;
        }

        public Criteria andWarningidGreaterThan(String value) {
            addCriterion("warningid >", value, "warningid");
            return (Criteria) this;
        }

        public Criteria andWarningidGreaterThanOrEqualTo(String value) {
            addCriterion("warningid >=", value, "warningid");
            return (Criteria) this;
        }

        public Criteria andWarningidLessThan(String value) {
            addCriterion("warningid <", value, "warningid");
            return (Criteria) this;
        }

        public Criteria andWarningidLessThanOrEqualTo(String value) {
            addCriterion("warningid <=", value, "warningid");
            return (Criteria) this;
        }

        public Criteria andWarningidLike(String value) {
            addCriterion("warningid like", value, "warningid");
            return (Criteria) this;
        }

        public Criteria andWarningidNotLike(String value) {
            addCriterion("warningid not like", value, "warningid");
            return (Criteria) this;
        }

        public Criteria andWarningidIn(List<String> values) {
            addCriterion("warningid in", values, "warningid");
            return (Criteria) this;
        }

        public Criteria andWarningidNotIn(List<String> values) {
            addCriterion("warningid not in", values, "warningid");
            return (Criteria) this;
        }

        public Criteria andWarningidBetween(String value1, String value2) {
            addCriterion("warningid between", value1, value2, "warningid");
            return (Criteria) this;
        }

        public Criteria andWarningidNotBetween(String value1, String value2) {
            addCriterion("warningid not between", value1, value2, "warningid");
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

        public Criteria andWarntitleIsNull() {
            addCriterion("warntitle is null");
            return (Criteria) this;
        }

        public Criteria andWarntitleIsNotNull() {
            addCriterion("warntitle is not null");
            return (Criteria) this;
        }

        public Criteria andWarntitleEqualTo(String value) {
            addCriterion("warntitle =", value, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntitleNotEqualTo(String value) {
            addCriterion("warntitle <>", value, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntitleGreaterThan(String value) {
            addCriterion("warntitle >", value, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntitleGreaterThanOrEqualTo(String value) {
            addCriterion("warntitle >=", value, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntitleLessThan(String value) {
            addCriterion("warntitle <", value, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntitleLessThanOrEqualTo(String value) {
            addCriterion("warntitle <=", value, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntitleLike(String value) {
            addCriterion("warntitle like", value, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntitleNotLike(String value) {
            addCriterion("warntitle not like", value, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntitleIn(List<String> values) {
            addCriterion("warntitle in", values, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntitleNotIn(List<String> values) {
            addCriterion("warntitle not in", values, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntitleBetween(String value1, String value2) {
            addCriterion("warntitle between", value1, value2, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntitleNotBetween(String value1, String value2) {
            addCriterion("warntitle not between", value1, value2, "warntitle");
            return (Criteria) this;
        }

        public Criteria andWarntypeIsNull() {
            addCriterion("warntype is null");
            return (Criteria) this;
        }

        public Criteria andWarntypeIsNotNull() {
            addCriterion("warntype is not null");
            return (Criteria) this;
        }

        public Criteria andWarntypeEqualTo(String value) {
            addCriterion("warntype =", value, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntypeNotEqualTo(String value) {
            addCriterion("warntype <>", value, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntypeGreaterThan(String value) {
            addCriterion("warntype >", value, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntypeGreaterThanOrEqualTo(String value) {
            addCriterion("warntype >=", value, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntypeLessThan(String value) {
            addCriterion("warntype <", value, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntypeLessThanOrEqualTo(String value) {
            addCriterion("warntype <=", value, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntypeLike(String value) {
            addCriterion("warntype like", value, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntypeNotLike(String value) {
            addCriterion("warntype not like", value, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntypeIn(List<String> values) {
            addCriterion("warntype in", values, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntypeNotIn(List<String> values) {
            addCriterion("warntype not in", values, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntypeBetween(String value1, String value2) {
            addCriterion("warntype between", value1, value2, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntypeNotBetween(String value1, String value2) {
            addCriterion("warntype not between", value1, value2, "warntype");
            return (Criteria) this;
        }

        public Criteria andWarntimeIsNull() {
            addCriterion("warntime is null");
            return (Criteria) this;
        }

        public Criteria andWarntimeIsNotNull() {
            addCriterion("warntime is not null");
            return (Criteria) this;
        }

        public Criteria andWarntimeEqualTo(Date value) {
            addCriterion("warntime =", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeNotEqualTo(Date value) {
            addCriterion("warntime <>", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeGreaterThan(Date value) {
            addCriterion("warntime >", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("warntime >=", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeLessThan(Date value) {
            addCriterion("warntime <", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeLessThanOrEqualTo(Date value) {
            addCriterion("warntime <=", value, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeIn(List<Date> values) {
            addCriterion("warntime in", values, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeNotIn(List<Date> values) {
            addCriterion("warntime not in", values, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeBetween(Date value1, Date value2) {
            addCriterion("warntime between", value1, value2, "warntime");
            return (Criteria) this;
        }

        public Criteria andWarntimeNotBetween(Date value1, Date value2) {
            addCriterion("warntime not between", value1, value2, "warntime");
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

        public Criteria andWarningtypeIsNull() {
            addCriterion("warningtype is null");
            return (Criteria) this;
        }

        public Criteria andWarningtypeIsNotNull() {
            addCriterion("warningtype is not null");
            return (Criteria) this;
        }

        public Criteria andWarningtypeEqualTo(String value) {
            addCriterion("warningtype =", value, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarningtypeNotEqualTo(String value) {
            addCriterion("warningtype <>", value, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarningtypeGreaterThan(String value) {
            addCriterion("warningtype >", value, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarningtypeGreaterThanOrEqualTo(String value) {
            addCriterion("warningtype >=", value, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarningtypeLessThan(String value) {
            addCriterion("warningtype <", value, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarningtypeLessThanOrEqualTo(String value) {
            addCriterion("warningtype <=", value, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarningtypeLike(String value) {
            addCriterion("warningtype like", value, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarningtypeNotLike(String value) {
            addCriterion("warningtype not like", value, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarningtypeIn(List<String> values) {
            addCriterion("warningtype in", values, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarningtypeNotIn(List<String> values) {
            addCriterion("warningtype not in", values, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarningtypeBetween(String value1, String value2) {
            addCriterion("warningtype between", value1, value2, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarningtypeNotBetween(String value1, String value2) {
            addCriterion("warningtype not between", value1, value2, "warningtype");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeIsNull() {
            addCriterion("warn_describe is null");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeIsNotNull() {
            addCriterion("warn_describe is not null");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeEqualTo(String value) {
            addCriterion("warn_describe =", value, "warnDescribe");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeNotEqualTo(String value) {
            addCriterion("warn_describe <>", value, "warnDescribe");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeGreaterThan(String value) {
            addCriterion("warn_describe >", value, "warnDescribe");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("warn_describe >=", value, "warnDescribe");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeLessThan(String value) {
            addCriterion("warn_describe <", value, "warnDescribe");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeLessThanOrEqualTo(String value) {
            addCriterion("warn_describe <=", value, "warnDescribe");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeLike(String value) {
            addCriterion("warn_describe like", value, "warnDescribe");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeNotLike(String value) {
            addCriterion("warn_describe not like", value, "warnDescribe");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeIn(List<String> values) {
            addCriterion("warn_describe in", values, "warnDescribe");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeNotIn(List<String> values) {
            addCriterion("warn_describe not in", values, "warnDescribe");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeBetween(String value1, String value2) {
            addCriterion("warn_describe between", value1, value2, "warnDescribe");
            return (Criteria) this;
        }

        public Criteria andWarnDescribeNotBetween(String value1, String value2) {
            addCriterion("warn_describe not between", value1, value2, "warnDescribe");
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
     * t_warning
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