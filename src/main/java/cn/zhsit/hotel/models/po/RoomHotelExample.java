package cn.zhsit.hotel.models.po;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.zhsit.common.utils.page.BaseExample;

public class RoomHotelExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomHotelExample() {
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
     * t_room_hotel 
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

        public Criteria andRoomnameIsNull() {
            addCriterion("roomname is null");
            return (Criteria) this;
        }

        public Criteria andRoomnameIsNotNull() {
            addCriterion("roomname is not null");
            return (Criteria) this;
        }

        public Criteria andRoomnameEqualTo(String value) {
            addCriterion("roomname =", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotEqualTo(String value) {
            addCriterion("roomname <>", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameGreaterThan(String value) {
            addCriterion("roomname >", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameGreaterThanOrEqualTo(String value) {
            addCriterion("roomname >=", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLessThan(String value) {
            addCriterion("roomname <", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLessThanOrEqualTo(String value) {
            addCriterion("roomname <=", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLike(String value) {
            addCriterion("roomname like", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotLike(String value) {
            addCriterion("roomname not like", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameIn(List<String> values) {
            addCriterion("roomname in", values, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotIn(List<String> values) {
            addCriterion("roomname not in", values, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameBetween(String value1, String value2) {
            addCriterion("roomname between", value1, value2, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotBetween(String value1, String value2) {
            addCriterion("roomname not between", value1, value2, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnumIsNull() {
            addCriterion("roomnum is null");
            return (Criteria) this;
        }

        public Criteria andRoomnumIsNotNull() {
            addCriterion("roomnum is not null");
            return (Criteria) this;
        }

        public Criteria andRoomnumEqualTo(String value) {
            addCriterion("roomnum =", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotEqualTo(String value) {
            addCriterion("roomnum <>", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumGreaterThan(String value) {
            addCriterion("roomnum >", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumGreaterThanOrEqualTo(String value) {
            addCriterion("roomnum >=", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumLessThan(String value) {
            addCriterion("roomnum <", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumLessThanOrEqualTo(String value) {
            addCriterion("roomnum <=", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumLike(String value) {
            addCriterion("roomnum like", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotLike(String value) {
            addCriterion("roomnum not like", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumIn(List<String> values) {
            addCriterion("roomnum in", values, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotIn(List<String> values) {
            addCriterion("roomnum not in", values, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumBetween(String value1, String value2) {
            addCriterion("roomnum between", value1, value2, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotBetween(String value1, String value2) {
            addCriterion("roomnum not between", value1, value2, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomipIsNull() {
            addCriterion("roomip is null");
            return (Criteria) this;
        }

        public Criteria andRoomipIsNotNull() {
            addCriterion("roomip is not null");
            return (Criteria) this;
        }

        public Criteria andRoomipEqualTo(String value) {
            addCriterion("roomip =", value, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomipNotEqualTo(String value) {
            addCriterion("roomip <>", value, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomipGreaterThan(String value) {
            addCriterion("roomip >", value, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomipGreaterThanOrEqualTo(String value) {
            addCriterion("roomip >=", value, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomipLessThan(String value) {
            addCriterion("roomip <", value, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomipLessThanOrEqualTo(String value) {
            addCriterion("roomip <=", value, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomipLike(String value) {
            addCriterion("roomip like", value, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomipNotLike(String value) {
            addCriterion("roomip not like", value, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomipIn(List<String> values) {
            addCriterion("roomip in", values, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomipNotIn(List<String> values) {
            addCriterion("roomip not in", values, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomipBetween(String value1, String value2) {
            addCriterion("roomip between", value1, value2, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomipNotBetween(String value1, String value2) {
            addCriterion("roomip not between", value1, value2, "roomip");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidIsNull() {
            addCriterion("roomtypeid is null");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidIsNotNull() {
            addCriterion("roomtypeid is not null");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidEqualTo(String value) {
            addCriterion("roomtypeid =", value, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidNotEqualTo(String value) {
            addCriterion("roomtypeid <>", value, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidGreaterThan(String value) {
            addCriterion("roomtypeid >", value, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidGreaterThanOrEqualTo(String value) {
            addCriterion("roomtypeid >=", value, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidLessThan(String value) {
            addCriterion("roomtypeid <", value, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidLessThanOrEqualTo(String value) {
            addCriterion("roomtypeid <=", value, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidLike(String value) {
            addCriterion("roomtypeid like", value, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidNotLike(String value) {
            addCriterion("roomtypeid not like", value, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidIn(List<String> values) {
            addCriterion("roomtypeid in", values, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidNotIn(List<String> values) {
            addCriterion("roomtypeid not in", values, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidBetween(String value1, String value2) {
            addCriterion("roomtypeid between", value1, value2, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomtypeidNotBetween(String value1, String value2) {
            addCriterion("roomtypeid not between", value1, value2, "roomtypeid");
            return (Criteria) this;
        }

        public Criteria andRoomnoIsNull() {
            addCriterion("roomno is null");
            return (Criteria) this;
        }

        public Criteria andRoomnoIsNotNull() {
            addCriterion("roomno is not null");
            return (Criteria) this;
        }

        public Criteria andRoomnoEqualTo(String value) {
            addCriterion("roomno =", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoNotEqualTo(String value) {
            addCriterion("roomno <>", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoGreaterThan(String value) {
            addCriterion("roomno >", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoGreaterThanOrEqualTo(String value) {
            addCriterion("roomno >=", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoLessThan(String value) {
            addCriterion("roomno <", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoLessThanOrEqualTo(String value) {
            addCriterion("roomno <=", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoLike(String value) {
            addCriterion("roomno like", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoNotLike(String value) {
            addCriterion("roomno not like", value, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoIn(List<String> values) {
            addCriterion("roomno in", values, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoNotIn(List<String> values) {
            addCriterion("roomno not in", values, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoBetween(String value1, String value2) {
            addCriterion("roomno between", value1, value2, "roomno");
            return (Criteria) this;
        }

        public Criteria andRoomnoNotBetween(String value1, String value2) {
            addCriterion("roomno not between", value1, value2, "roomno");
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

        public Criteria andFlooridIsNull() {
            addCriterion("floorid is null");
            return (Criteria) this;
        }

        public Criteria andFlooridIsNotNull() {
            addCriterion("floorid is not null");
            return (Criteria) this;
        }

        public Criteria andFlooridEqualTo(String value) {
            addCriterion("floorid =", value, "floorid");
            return (Criteria) this;
        }

        public Criteria andFlooridNotEqualTo(String value) {
            addCriterion("floorid <>", value, "floorid");
            return (Criteria) this;
        }

        public Criteria andFlooridGreaterThan(String value) {
            addCriterion("floorid >", value, "floorid");
            return (Criteria) this;
        }

        public Criteria andFlooridGreaterThanOrEqualTo(String value) {
            addCriterion("floorid >=", value, "floorid");
            return (Criteria) this;
        }

        public Criteria andFlooridLessThan(String value) {
            addCriterion("floorid <", value, "floorid");
            return (Criteria) this;
        }

        public Criteria andFlooridLessThanOrEqualTo(String value) {
            addCriterion("floorid <=", value, "floorid");
            return (Criteria) this;
        }

        public Criteria andFlooridLike(String value) {
            addCriterion("floorid like", value, "floorid");
            return (Criteria) this;
        }

        public Criteria andFlooridNotLike(String value) {
            addCriterion("floorid not like", value, "floorid");
            return (Criteria) this;
        }

        public Criteria andFlooridIn(List<String> values) {
            addCriterion("floorid in", values, "floorid");
            return (Criteria) this;
        }

        public Criteria andFlooridNotIn(List<String> values) {
            addCriterion("floorid not in", values, "floorid");
            return (Criteria) this;
        }

        public Criteria andFlooridBetween(String value1, String value2) {
            addCriterion("floorid between", value1, value2, "floorid");
            return (Criteria) this;
        }

        public Criteria andFlooridNotBetween(String value1, String value2) {
            addCriterion("floorid not between", value1, value2, "floorid");
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

        public Criteria andRmtypenameIsNull() {
            addCriterion("rmtypename is null");
            return (Criteria) this;
        }

        public Criteria andRmtypenameIsNotNull() {
            addCriterion("rmtypename is not null");
            return (Criteria) this;
        }

        public Criteria andRmtypenameEqualTo(String value) {
            addCriterion("rmtypename =", value, "rmtypename");
            return (Criteria) this;
        }

        public Criteria andRmtypenameNotEqualTo(String value) {
            addCriterion("rmtypename <>", value, "rmtypename");
            return (Criteria) this;
        }

        public Criteria andRmtypenameGreaterThan(String value) {
            addCriterion("rmtypename >", value, "rmtypename");
            return (Criteria) this;
        }

        public Criteria andRmtypenameGreaterThanOrEqualTo(String value) {
            addCriterion("rmtypename >=", value, "rmtypename");
            return (Criteria) this;
        }

        public Criteria andRmtypenameLessThan(String value) {
            addCriterion("rmtypename <", value, "rmtypename");
            return (Criteria) this;
        }

        public Criteria andRmtypenameLessThanOrEqualTo(String value) {
            addCriterion("rmtypename <=", value, "rmtypename");
            return (Criteria) this;
        }

        public Criteria andRmtypenameLike(String value) {
            addCriterion("rmtypename like", value, "rmtypename");
            return (Criteria) this;
        }

        public Criteria andRmtypenameNotLike(String value) {
            addCriterion("rmtypename not like", value, "rmtypename");
            return (Criteria) this;
        }

        public Criteria andRmtypenameIn(List<String> values) {
            addCriterion("rmtypename in", values, "rmtypename");
            return (Criteria) this;
        }

        public Criteria andRmtypenameNotIn(List<String> values) {
            addCriterion("rmtypename not in", values, "rmtypename");
            return (Criteria) this;
        }

        public Criteria andRmtypenameBetween(String value1, String value2) {
            addCriterion("rmtypename between", value1, value2, "rmtypename");
            return (Criteria) this;
        }

        public Criteria andRmtypenameNotBetween(String value1, String value2) {
            addCriterion("rmtypename not between", value1, value2, "rmtypename");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_room_hotel 
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