package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.List;

import cn.zhsit.common.utils.page.BaseExample;

public class RcuSetparamExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RcuSetparamExample() {
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
     * t_rcu_setparam 
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

        public Criteria andIpaddrIsNull() {
            addCriterion("ipaddr is null");
            return (Criteria) this;
        }

        public Criteria andIpaddrIsNotNull() {
            addCriterion("ipaddr is not null");
            return (Criteria) this;
        }

        public Criteria andIpaddrEqualTo(String value) {
            addCriterion("ipaddr =", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotEqualTo(String value) {
            addCriterion("ipaddr <>", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrGreaterThan(String value) {
            addCriterion("ipaddr >", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrGreaterThanOrEqualTo(String value) {
            addCriterion("ipaddr >=", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrLessThan(String value) {
            addCriterion("ipaddr <", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrLessThanOrEqualTo(String value) {
            addCriterion("ipaddr <=", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrLike(String value) {
            addCriterion("ipaddr like", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotLike(String value) {
            addCriterion("ipaddr not like", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrIn(List<String> values) {
            addCriterion("ipaddr in", values, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotIn(List<String> values) {
            addCriterion("ipaddr not in", values, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrBetween(String value1, String value2) {
            addCriterion("ipaddr between", value1, value2, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotBetween(String value1, String value2) {
            addCriterion("ipaddr not between", value1, value2, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrIsNull() {
            addCriterion("macaddr is null");
            return (Criteria) this;
        }

        public Criteria andMacaddrIsNotNull() {
            addCriterion("macaddr is not null");
            return (Criteria) this;
        }

        public Criteria andMacaddrEqualTo(String value) {
            addCriterion("macaddr =", value, "macaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrNotEqualTo(String value) {
            addCriterion("macaddr <>", value, "macaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrGreaterThan(String value) {
            addCriterion("macaddr >", value, "macaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrGreaterThanOrEqualTo(String value) {
            addCriterion("macaddr >=", value, "macaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrLessThan(String value) {
            addCriterion("macaddr <", value, "macaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrLessThanOrEqualTo(String value) {
            addCriterion("macaddr <=", value, "macaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrLike(String value) {
            addCriterion("macaddr like", value, "macaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrNotLike(String value) {
            addCriterion("macaddr not like", value, "macaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrIn(List<String> values) {
            addCriterion("macaddr in", values, "macaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrNotIn(List<String> values) {
            addCriterion("macaddr not in", values, "macaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrBetween(String value1, String value2) {
            addCriterion("macaddr between", value1, value2, "macaddr");
            return (Criteria) this;
        }

        public Criteria andMacaddrNotBetween(String value1, String value2) {
            addCriterion("macaddr not between", value1, value2, "macaddr");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("port like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("port not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<String> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<String> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andUpipaddrIsNull() {
            addCriterion("upipaddr is null");
            return (Criteria) this;
        }

        public Criteria andUpipaddrIsNotNull() {
            addCriterion("upipaddr is not null");
            return (Criteria) this;
        }

        public Criteria andUpipaddrEqualTo(String value) {
            addCriterion("upipaddr =", value, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpipaddrNotEqualTo(String value) {
            addCriterion("upipaddr <>", value, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpipaddrGreaterThan(String value) {
            addCriterion("upipaddr >", value, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpipaddrGreaterThanOrEqualTo(String value) {
            addCriterion("upipaddr >=", value, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpipaddrLessThan(String value) {
            addCriterion("upipaddr <", value, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpipaddrLessThanOrEqualTo(String value) {
            addCriterion("upipaddr <=", value, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpipaddrLike(String value) {
            addCriterion("upipaddr like", value, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpipaddrNotLike(String value) {
            addCriterion("upipaddr not like", value, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpipaddrIn(List<String> values) {
            addCriterion("upipaddr in", values, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpipaddrNotIn(List<String> values) {
            addCriterion("upipaddr not in", values, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpipaddrBetween(String value1, String value2) {
            addCriterion("upipaddr between", value1, value2, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpipaddrNotBetween(String value1, String value2) {
            addCriterion("upipaddr not between", value1, value2, "upipaddr");
            return (Criteria) this;
        }

        public Criteria andUpportIsNull() {
            addCriterion("upport is null");
            return (Criteria) this;
        }

        public Criteria andUpportIsNotNull() {
            addCriterion("upport is not null");
            return (Criteria) this;
        }

        public Criteria andUpportEqualTo(String value) {
            addCriterion("upport =", value, "upport");
            return (Criteria) this;
        }

        public Criteria andUpportNotEqualTo(String value) {
            addCriterion("upport <>", value, "upport");
            return (Criteria) this;
        }

        public Criteria andUpportGreaterThan(String value) {
            addCriterion("upport >", value, "upport");
            return (Criteria) this;
        }

        public Criteria andUpportGreaterThanOrEqualTo(String value) {
            addCriterion("upport >=", value, "upport");
            return (Criteria) this;
        }

        public Criteria andUpportLessThan(String value) {
            addCriterion("upport <", value, "upport");
            return (Criteria) this;
        }

        public Criteria andUpportLessThanOrEqualTo(String value) {
            addCriterion("upport <=", value, "upport");
            return (Criteria) this;
        }

        public Criteria andUpportLike(String value) {
            addCriterion("upport like", value, "upport");
            return (Criteria) this;
        }

        public Criteria andUpportNotLike(String value) {
            addCriterion("upport not like", value, "upport");
            return (Criteria) this;
        }

        public Criteria andUpportIn(List<String> values) {
            addCriterion("upport in", values, "upport");
            return (Criteria) this;
        }

        public Criteria andUpportNotIn(List<String> values) {
            addCriterion("upport not in", values, "upport");
            return (Criteria) this;
        }

        public Criteria andUpportBetween(String value1, String value2) {
            addCriterion("upport between", value1, value2, "upport");
            return (Criteria) this;
        }

        public Criteria andUpportNotBetween(String value1, String value2) {
            addCriterion("upport not between", value1, value2, "upport");
            return (Criteria) this;
        }

        public Criteria andMaskcodeIsNull() {
            addCriterion("maskcode is null");
            return (Criteria) this;
        }

        public Criteria andMaskcodeIsNotNull() {
            addCriterion("maskcode is not null");
            return (Criteria) this;
        }

        public Criteria andMaskcodeEqualTo(String value) {
            addCriterion("maskcode =", value, "maskcode");
            return (Criteria) this;
        }

        public Criteria andMaskcodeNotEqualTo(String value) {
            addCriterion("maskcode <>", value, "maskcode");
            return (Criteria) this;
        }

        public Criteria andMaskcodeGreaterThan(String value) {
            addCriterion("maskcode >", value, "maskcode");
            return (Criteria) this;
        }

        public Criteria andMaskcodeGreaterThanOrEqualTo(String value) {
            addCriterion("maskcode >=", value, "maskcode");
            return (Criteria) this;
        }

        public Criteria andMaskcodeLessThan(String value) {
            addCriterion("maskcode <", value, "maskcode");
            return (Criteria) this;
        }

        public Criteria andMaskcodeLessThanOrEqualTo(String value) {
            addCriterion("maskcode <=", value, "maskcode");
            return (Criteria) this;
        }

        public Criteria andMaskcodeLike(String value) {
            addCriterion("maskcode like", value, "maskcode");
            return (Criteria) this;
        }

        public Criteria andMaskcodeNotLike(String value) {
            addCriterion("maskcode not like", value, "maskcode");
            return (Criteria) this;
        }

        public Criteria andMaskcodeIn(List<String> values) {
            addCriterion("maskcode in", values, "maskcode");
            return (Criteria) this;
        }

        public Criteria andMaskcodeNotIn(List<String> values) {
            addCriterion("maskcode not in", values, "maskcode");
            return (Criteria) this;
        }

        public Criteria andMaskcodeBetween(String value1, String value2) {
            addCriterion("maskcode between", value1, value2, "maskcode");
            return (Criteria) this;
        }

        public Criteria andMaskcodeNotBetween(String value1, String value2) {
            addCriterion("maskcode not between", value1, value2, "maskcode");
            return (Criteria) this;
        }

        public Criteria andGatewayIsNull() {
            addCriterion("gateway is null");
            return (Criteria) this;
        }

        public Criteria andGatewayIsNotNull() {
            addCriterion("gateway is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayEqualTo(String value) {
            addCriterion("gateway =", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotEqualTo(String value) {
            addCriterion("gateway <>", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayGreaterThan(String value) {
            addCriterion("gateway >", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayGreaterThanOrEqualTo(String value) {
            addCriterion("gateway >=", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayLessThan(String value) {
            addCriterion("gateway <", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayLessThanOrEqualTo(String value) {
            addCriterion("gateway <=", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayLike(String value) {
            addCriterion("gateway like", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotLike(String value) {
            addCriterion("gateway not like", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayIn(List<String> values) {
            addCriterion("gateway in", values, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotIn(List<String> values) {
            addCriterion("gateway not in", values, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayBetween(String value1, String value2) {
            addCriterion("gateway between", value1, value2, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotBetween(String value1, String value2) {
            addCriterion("gateway not between", value1, value2, "gateway");
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
     * t_rcu_setparam 
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