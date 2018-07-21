package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquipmentSetvalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentSetvalExample() {
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
     * t_equipment_setval 
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

        public Criteria andParamnameIsNull() {
            addCriterion("paramname is null");
            return (Criteria) this;
        }

        public Criteria andParamnameIsNotNull() {
            addCriterion("paramname is not null");
            return (Criteria) this;
        }

        public Criteria andParamnameEqualTo(String value) {
            addCriterion("paramname =", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotEqualTo(String value) {
            addCriterion("paramname <>", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameGreaterThan(String value) {
            addCriterion("paramname >", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameGreaterThanOrEqualTo(String value) {
            addCriterion("paramname >=", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLessThan(String value) {
            addCriterion("paramname <", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLessThanOrEqualTo(String value) {
            addCriterion("paramname <=", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLike(String value) {
            addCriterion("paramname like", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotLike(String value) {
            addCriterion("paramname not like", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameIn(List<String> values) {
            addCriterion("paramname in", values, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotIn(List<String> values) {
            addCriterion("paramname not in", values, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameBetween(String value1, String value2) {
            addCriterion("paramname between", value1, value2, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotBetween(String value1, String value2) {
            addCriterion("paramname not between", value1, value2, "paramname");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeIsNull() {
            addCriterion("topparamtype is null");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeIsNotNull() {
            addCriterion("topparamtype is not null");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeEqualTo(String value) {
            addCriterion("topparamtype =", value, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeNotEqualTo(String value) {
            addCriterion("topparamtype <>", value, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeGreaterThan(String value) {
            addCriterion("topparamtype >", value, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeGreaterThanOrEqualTo(String value) {
            addCriterion("topparamtype >=", value, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeLessThan(String value) {
            addCriterion("topparamtype <", value, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeLessThanOrEqualTo(String value) {
            addCriterion("topparamtype <=", value, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeLike(String value) {
            addCriterion("topparamtype like", value, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeNotLike(String value) {
            addCriterion("topparamtype not like", value, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeIn(List<String> values) {
            addCriterion("topparamtype in", values, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeNotIn(List<String> values) {
            addCriterion("topparamtype not in", values, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeBetween(String value1, String value2) {
            addCriterion("topparamtype between", value1, value2, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andTopparamtypeNotBetween(String value1, String value2) {
            addCriterion("topparamtype not between", value1, value2, "topparamtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeIsNull() {
            addCriterion("parambelongtype is null");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeIsNotNull() {
            addCriterion("parambelongtype is not null");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeEqualTo(String value) {
            addCriterion("parambelongtype =", value, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeNotEqualTo(String value) {
            addCriterion("parambelongtype <>", value, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeGreaterThan(String value) {
            addCriterion("parambelongtype >", value, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeGreaterThanOrEqualTo(String value) {
            addCriterion("parambelongtype >=", value, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeLessThan(String value) {
            addCriterion("parambelongtype <", value, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeLessThanOrEqualTo(String value) {
            addCriterion("parambelongtype <=", value, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeLike(String value) {
            addCriterion("parambelongtype like", value, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeNotLike(String value) {
            addCriterion("parambelongtype not like", value, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeIn(List<String> values) {
            addCriterion("parambelongtype in", values, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeNotIn(List<String> values) {
            addCriterion("parambelongtype not in", values, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeBetween(String value1, String value2) {
            addCriterion("parambelongtype between", value1, value2, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParambelongtypeNotBetween(String value1, String value2) {
            addCriterion("parambelongtype not between", value1, value2, "parambelongtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeIsNull() {
            addCriterion("paramtype is null");
            return (Criteria) this;
        }

        public Criteria andParamtypeIsNotNull() {
            addCriterion("paramtype is not null");
            return (Criteria) this;
        }

        public Criteria andParamtypeEqualTo(String value) {
            addCriterion("paramtype =", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotEqualTo(String value) {
            addCriterion("paramtype <>", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeGreaterThan(String value) {
            addCriterion("paramtype >", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeGreaterThanOrEqualTo(String value) {
            addCriterion("paramtype >=", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeLessThan(String value) {
            addCriterion("paramtype <", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeLessThanOrEqualTo(String value) {
            addCriterion("paramtype <=", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeLike(String value) {
            addCriterion("paramtype like", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotLike(String value) {
            addCriterion("paramtype not like", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeIn(List<String> values) {
            addCriterion("paramtype in", values, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotIn(List<String> values) {
            addCriterion("paramtype not in", values, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeBetween(String value1, String value2) {
            addCriterion("paramtype between", value1, value2, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotBetween(String value1, String value2) {
            addCriterion("paramtype not between", value1, value2, "paramtype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeIsNull() {
            addCriterion("setvaltype is null");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeIsNotNull() {
            addCriterion("setvaltype is not null");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeEqualTo(String value) {
            addCriterion("setvaltype =", value, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeNotEqualTo(String value) {
            addCriterion("setvaltype <>", value, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeGreaterThan(String value) {
            addCriterion("setvaltype >", value, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeGreaterThanOrEqualTo(String value) {
            addCriterion("setvaltype >=", value, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeLessThan(String value) {
            addCriterion("setvaltype <", value, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeLessThanOrEqualTo(String value) {
            addCriterion("setvaltype <=", value, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeLike(String value) {
            addCriterion("setvaltype like", value, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeNotLike(String value) {
            addCriterion("setvaltype not like", value, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeIn(List<String> values) {
            addCriterion("setvaltype in", values, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeNotIn(List<String> values) {
            addCriterion("setvaltype not in", values, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeBetween(String value1, String value2) {
            addCriterion("setvaltype between", value1, value2, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvaltypeNotBetween(String value1, String value2) {
            addCriterion("setvaltype not between", value1, value2, "setvaltype");
            return (Criteria) this;
        }

        public Criteria andSetvalIsNull() {
            addCriterion("setval is null");
            return (Criteria) this;
        }

        public Criteria andSetvalIsNotNull() {
            addCriterion("setval is not null");
            return (Criteria) this;
        }

        public Criteria andSetvalEqualTo(String value) {
            addCriterion("setval =", value, "setval");
            return (Criteria) this;
        }

        public Criteria andSetvalNotEqualTo(String value) {
            addCriterion("setval <>", value, "setval");
            return (Criteria) this;
        }

        public Criteria andSetvalGreaterThan(String value) {
            addCriterion("setval >", value, "setval");
            return (Criteria) this;
        }

        public Criteria andSetvalGreaterThanOrEqualTo(String value) {
            addCriterion("setval >=", value, "setval");
            return (Criteria) this;
        }

        public Criteria andSetvalLessThan(String value) {
            addCriterion("setval <", value, "setval");
            return (Criteria) this;
        }

        public Criteria andSetvalLessThanOrEqualTo(String value) {
            addCriterion("setval <=", value, "setval");
            return (Criteria) this;
        }

        public Criteria andSetvalLike(String value) {
            addCriterion("setval like", value, "setval");
            return (Criteria) this;
        }

        public Criteria andSetvalNotLike(String value) {
            addCriterion("setval not like", value, "setval");
            return (Criteria) this;
        }

        public Criteria andSetvalIn(List<String> values) {
            addCriterion("setval in", values, "setval");
            return (Criteria) this;
        }

        public Criteria andSetvalNotIn(List<String> values) {
            addCriterion("setval not in", values, "setval");
            return (Criteria) this;
        }

        public Criteria andSetvalBetween(String value1, String value2) {
            addCriterion("setval between", value1, value2, "setval");
            return (Criteria) this;
        }

        public Criteria andSetvalNotBetween(String value1, String value2) {
            addCriterion("setval not between", value1, value2, "setval");
            return (Criteria) this;
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
     * t_equipment_setval 
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