package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.zhsit.common.utils.page.BaseExample;

public class RcuExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RcuExample() {
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
     * t_rcu 
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

        public Criteria andRcuidIsNull() {
            addCriterion("rcuid is null");
            return (Criteria) this;
        }

        public Criteria andRcuidIsNotNull() {
            addCriterion("rcuid is not null");
            return (Criteria) this;
        }

        public Criteria andRcuidEqualTo(String value) {
            addCriterion("rcuid =", value, "rcuid");
            return (Criteria) this;
        }

        public Criteria andRcuidNotEqualTo(String value) {
            addCriterion("rcuid <>", value, "rcuid");
            return (Criteria) this;
        }

        public Criteria andRcuidGreaterThan(String value) {
            addCriterion("rcuid >", value, "rcuid");
            return (Criteria) this;
        }

        public Criteria andRcuidGreaterThanOrEqualTo(String value) {
            addCriterion("rcuid >=", value, "rcuid");
            return (Criteria) this;
        }

        public Criteria andRcuidLessThan(String value) {
            addCriterion("rcuid <", value, "rcuid");
            return (Criteria) this;
        }

        public Criteria andRcuidLessThanOrEqualTo(String value) {
            addCriterion("rcuid <=", value, "rcuid");
            return (Criteria) this;
        }

        public Criteria andRcuidLike(String value) {
            addCriterion("rcuid like", value, "rcuid");
            return (Criteria) this;
        }

        public Criteria andRcuidNotLike(String value) {
            addCriterion("rcuid not like", value, "rcuid");
            return (Criteria) this;
        }

        public Criteria andRcuidIn(List<String> values) {
            addCriterion("rcuid in", values, "rcuid");
            return (Criteria) this;
        }

        public Criteria andRcuidNotIn(List<String> values) {
            addCriterion("rcuid not in", values, "rcuid");
            return (Criteria) this;
        }

        public Criteria andRcuidBetween(String value1, String value2) {
            addCriterion("rcuid between", value1, value2, "rcuid");
            return (Criteria) this;
        }

        public Criteria andRcuidNotBetween(String value1, String value2) {
            addCriterion("rcuid not between", value1, value2, "rcuid");
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

        public Criteria andRoomtypeIsNull() {
            addCriterion("roomtype is null");
            return (Criteria) this;
        }

        public Criteria andRoomtypeIsNotNull() {
            addCriterion("roomtype is not null");
            return (Criteria) this;
        }

        public Criteria andRoomtypeEqualTo(String value) {
            addCriterion("roomtype =", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotEqualTo(String value) {
            addCriterion("roomtype <>", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeGreaterThan(String value) {
            addCriterion("roomtype >", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeGreaterThanOrEqualTo(String value) {
            addCriterion("roomtype >=", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeLessThan(String value) {
            addCriterion("roomtype <", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeLessThanOrEqualTo(String value) {
            addCriterion("roomtype <=", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeLike(String value) {
            addCriterion("roomtype like", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotLike(String value) {
            addCriterion("roomtype not like", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeIn(List<String> values) {
            addCriterion("roomtype in", values, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotIn(List<String> values) {
            addCriterion("roomtype not in", values, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeBetween(String value1, String value2) {
            addCriterion("roomtype between", value1, value2, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotBetween(String value1, String value2) {
            addCriterion("roomtype not between", value1, value2, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomconnectIsNull() {
            addCriterion("roomconnect is null");
            return (Criteria) this;
        }

        public Criteria andRoomconnectIsNotNull() {
            addCriterion("roomconnect is not null");
            return (Criteria) this;
        }

        public Criteria andRoomconnectEqualTo(String value) {
            addCriterion("roomconnect =", value, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andRoomconnectNotEqualTo(String value) {
            addCriterion("roomconnect <>", value, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andRoomconnectGreaterThan(String value) {
            addCriterion("roomconnect >", value, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andRoomconnectGreaterThanOrEqualTo(String value) {
            addCriterion("roomconnect >=", value, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andRoomconnectLessThan(String value) {
            addCriterion("roomconnect <", value, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andRoomconnectLessThanOrEqualTo(String value) {
            addCriterion("roomconnect <=", value, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andRoomconnectLike(String value) {
            addCriterion("roomconnect like", value, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andRoomconnectNotLike(String value) {
            addCriterion("roomconnect not like", value, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andRoomconnectIn(List<String> values) {
            addCriterion("roomconnect in", values, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andRoomconnectNotIn(List<String> values) {
            addCriterion("roomconnect not in", values, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andRoomconnectBetween(String value1, String value2) {
            addCriterion("roomconnect between", value1, value2, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andRoomconnectNotBetween(String value1, String value2) {
            addCriterion("roomconnect not between", value1, value2, "roomconnect");
            return (Criteria) this;
        }

        public Criteria andCommonVersionIsNull() {
            addCriterion("common_version is null");
            return (Criteria) this;
        }

        public Criteria andCommonVersionIsNotNull() {
            addCriterion("common_version is not null");
            return (Criteria) this;
        }

        public Criteria andCommonVersionEqualTo(String value) {
            addCriterion("common_version =", value, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andCommonVersionNotEqualTo(String value) {
            addCriterion("common_version <>", value, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andCommonVersionGreaterThan(String value) {
            addCriterion("common_version >", value, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andCommonVersionGreaterThanOrEqualTo(String value) {
            addCriterion("common_version >=", value, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andCommonVersionLessThan(String value) {
            addCriterion("common_version <", value, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andCommonVersionLessThanOrEqualTo(String value) {
            addCriterion("common_version <=", value, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andCommonVersionLike(String value) {
            addCriterion("common_version like", value, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andCommonVersionNotLike(String value) {
            addCriterion("common_version not like", value, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andCommonVersionIn(List<String> values) {
            addCriterion("common_version in", values, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andCommonVersionNotIn(List<String> values) {
            addCriterion("common_version not in", values, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andCommonVersionBetween(String value1, String value2) {
            addCriterion("common_version between", value1, value2, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andCommonVersionNotBetween(String value1, String value2) {
            addCriterion("common_version not between", value1, value2, "commonVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionIsNull() {
            addCriterion("config_version is null");
            return (Criteria) this;
        }

        public Criteria andConfigVersionIsNotNull() {
            addCriterion("config_version is not null");
            return (Criteria) this;
        }

        public Criteria andConfigVersionEqualTo(String value) {
            addCriterion("config_version =", value, "configVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionNotEqualTo(String value) {
            addCriterion("config_version <>", value, "configVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionGreaterThan(String value) {
            addCriterion("config_version >", value, "configVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionGreaterThanOrEqualTo(String value) {
            addCriterion("config_version >=", value, "configVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionLessThan(String value) {
            addCriterion("config_version <", value, "configVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionLessThanOrEqualTo(String value) {
            addCriterion("config_version <=", value, "configVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionLike(String value) {
            addCriterion("config_version like", value, "configVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionNotLike(String value) {
            addCriterion("config_version not like", value, "configVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionIn(List<String> values) {
            addCriterion("config_version in", values, "configVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionNotIn(List<String> values) {
            addCriterion("config_version not in", values, "configVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionBetween(String value1, String value2) {
            addCriterion("config_version between", value1, value2, "configVersion");
            return (Criteria) this;
        }

        public Criteria andConfigVersionNotBetween(String value1, String value2) {
            addCriterion("config_version not between", value1, value2, "configVersion");
            return (Criteria) this;
        }

        public Criteria andEngiNumIsNull() {
            addCriterion("engi_num is null");
            return (Criteria) this;
        }

        public Criteria andEngiNumIsNotNull() {
            addCriterion("engi_num is not null");
            return (Criteria) this;
        }

        public Criteria andEngiNumEqualTo(String value) {
            addCriterion("engi_num =", value, "engiNum");
            return (Criteria) this;
        }

        public Criteria andEngiNumNotEqualTo(String value) {
            addCriterion("engi_num <>", value, "engiNum");
            return (Criteria) this;
        }

        public Criteria andEngiNumGreaterThan(String value) {
            addCriterion("engi_num >", value, "engiNum");
            return (Criteria) this;
        }

        public Criteria andEngiNumGreaterThanOrEqualTo(String value) {
            addCriterion("engi_num >=", value, "engiNum");
            return (Criteria) this;
        }

        public Criteria andEngiNumLessThan(String value) {
            addCriterion("engi_num <", value, "engiNum");
            return (Criteria) this;
        }

        public Criteria andEngiNumLessThanOrEqualTo(String value) {
            addCriterion("engi_num <=", value, "engiNum");
            return (Criteria) this;
        }

        public Criteria andEngiNumLike(String value) {
            addCriterion("engi_num like", value, "engiNum");
            return (Criteria) this;
        }

        public Criteria andEngiNumNotLike(String value) {
            addCriterion("engi_num not like", value, "engiNum");
            return (Criteria) this;
        }

        public Criteria andEngiNumIn(List<String> values) {
            addCriterion("engi_num in", values, "engiNum");
            return (Criteria) this;
        }

        public Criteria andEngiNumNotIn(List<String> values) {
            addCriterion("engi_num not in", values, "engiNum");
            return (Criteria) this;
        }

        public Criteria andEngiNumBetween(String value1, String value2) {
            addCriterion("engi_num between", value1, value2, "engiNum");
            return (Criteria) this;
        }

        public Criteria andEngiNumNotBetween(String value1, String value2) {
            addCriterion("engi_num not between", value1, value2, "engiNum");
            return (Criteria) this;
        }

        public Criteria andSetnumberIsNull() {
            addCriterion("setnumber is null");
            return (Criteria) this;
        }

        public Criteria andSetnumberIsNotNull() {
            addCriterion("setnumber is not null");
            return (Criteria) this;
        }

        public Criteria andSetnumberEqualTo(Integer value) {
            addCriterion("setnumber =", value, "setnumber");
            return (Criteria) this;
        }

        public Criteria andSetnumberNotEqualTo(Integer value) {
            addCriterion("setnumber <>", value, "setnumber");
            return (Criteria) this;
        }

        public Criteria andSetnumberGreaterThan(Integer value) {
            addCriterion("setnumber >", value, "setnumber");
            return (Criteria) this;
        }

        public Criteria andSetnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("setnumber >=", value, "setnumber");
            return (Criteria) this;
        }

        public Criteria andSetnumberLessThan(Integer value) {
            addCriterion("setnumber <", value, "setnumber");
            return (Criteria) this;
        }

        public Criteria andSetnumberLessThanOrEqualTo(Integer value) {
            addCriterion("setnumber <=", value, "setnumber");
            return (Criteria) this;
        }

        public Criteria andSetnumberIn(List<Integer> values) {
            addCriterion("setnumber in", values, "setnumber");
            return (Criteria) this;
        }

        public Criteria andSetnumberNotIn(List<Integer> values) {
            addCriterion("setnumber not in", values, "setnumber");
            return (Criteria) this;
        }

        public Criteria andSetnumberBetween(Integer value1, Integer value2) {
            addCriterion("setnumber between", value1, value2, "setnumber");
            return (Criteria) this;
        }

        public Criteria andSetnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("setnumber not between", value1, value2, "setnumber");
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
     * t_rcu 
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