package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.List;

import cn.zhsit.common.utils.page.BaseExample;

public class RcuSettimeExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RcuSettimeExample() {
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
     * t_rcu_settime 
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

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("link =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("link <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("link >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("link >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("link <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("link <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("link like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("link not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("link in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("link not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("link between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("link not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andMillisecondthIsNull() {
            addCriterion("millisecondth is null");
            return (Criteria) this;
        }

        public Criteria andMillisecondthIsNotNull() {
            addCriterion("millisecondth is not null");
            return (Criteria) this;
        }

        public Criteria andMillisecondthEqualTo(String value) {
            addCriterion("millisecondth =", value, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondthNotEqualTo(String value) {
            addCriterion("millisecondth <>", value, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondthGreaterThan(String value) {
            addCriterion("millisecondth >", value, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondthGreaterThanOrEqualTo(String value) {
            addCriterion("millisecondth >=", value, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondthLessThan(String value) {
            addCriterion("millisecondth <", value, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondthLessThanOrEqualTo(String value) {
            addCriterion("millisecondth <=", value, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondthLike(String value) {
            addCriterion("millisecondth like", value, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondthNotLike(String value) {
            addCriterion("millisecondth not like", value, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondthIn(List<String> values) {
            addCriterion("millisecondth in", values, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondthNotIn(List<String> values) {
            addCriterion("millisecondth not in", values, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondthBetween(String value1, String value2) {
            addCriterion("millisecondth between", value1, value2, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondthNotBetween(String value1, String value2) {
            addCriterion("millisecondth not between", value1, value2, "millisecondth");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwIsNull() {
            addCriterion("millisecondtw is null");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwIsNotNull() {
            addCriterion("millisecondtw is not null");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwEqualTo(String value) {
            addCriterion("millisecondtw =", value, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwNotEqualTo(String value) {
            addCriterion("millisecondtw <>", value, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwGreaterThan(String value) {
            addCriterion("millisecondtw >", value, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwGreaterThanOrEqualTo(String value) {
            addCriterion("millisecondtw >=", value, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwLessThan(String value) {
            addCriterion("millisecondtw <", value, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwLessThanOrEqualTo(String value) {
            addCriterion("millisecondtw <=", value, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwLike(String value) {
            addCriterion("millisecondtw like", value, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwNotLike(String value) {
            addCriterion("millisecondtw not like", value, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwIn(List<String> values) {
            addCriterion("millisecondtw in", values, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwNotIn(List<String> values) {
            addCriterion("millisecondtw not in", values, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwBetween(String value1, String value2) {
            addCriterion("millisecondtw between", value1, value2, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andMillisecondtwNotBetween(String value1, String value2) {
            addCriterion("millisecondtw not between", value1, value2, "millisecondtw");
            return (Criteria) this;
        }

        public Criteria andSecondIsNull() {
            addCriterion("second is null");
            return (Criteria) this;
        }

        public Criteria andSecondIsNotNull() {
            addCriterion("second is not null");
            return (Criteria) this;
        }

        public Criteria andSecondEqualTo(String value) {
            addCriterion("second =", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotEqualTo(String value) {
            addCriterion("second <>", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondGreaterThan(String value) {
            addCriterion("second >", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondGreaterThanOrEqualTo(String value) {
            addCriterion("second >=", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondLessThan(String value) {
            addCriterion("second <", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondLessThanOrEqualTo(String value) {
            addCriterion("second <=", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondLike(String value) {
            addCriterion("second like", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotLike(String value) {
            addCriterion("second not like", value, "second");
            return (Criteria) this;
        }

        public Criteria andSecondIn(List<String> values) {
            addCriterion("second in", values, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotIn(List<String> values) {
            addCriterion("second not in", values, "second");
            return (Criteria) this;
        }

        public Criteria andSecondBetween(String value1, String value2) {
            addCriterion("second between", value1, value2, "second");
            return (Criteria) this;
        }

        public Criteria andSecondNotBetween(String value1, String value2) {
            addCriterion("second not between", value1, value2, "second");
            return (Criteria) this;
        }

        public Criteria andMinutesIsNull() {
            addCriterion("minutes is null");
            return (Criteria) this;
        }

        public Criteria andMinutesIsNotNull() {
            addCriterion("minutes is not null");
            return (Criteria) this;
        }

        public Criteria andMinutesEqualTo(String value) {
            addCriterion("minutes =", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesNotEqualTo(String value) {
            addCriterion("minutes <>", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesGreaterThan(String value) {
            addCriterion("minutes >", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesGreaterThanOrEqualTo(String value) {
            addCriterion("minutes >=", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesLessThan(String value) {
            addCriterion("minutes <", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesLessThanOrEqualTo(String value) {
            addCriterion("minutes <=", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesLike(String value) {
            addCriterion("minutes like", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesNotLike(String value) {
            addCriterion("minutes not like", value, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesIn(List<String> values) {
            addCriterion("minutes in", values, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesNotIn(List<String> values) {
            addCriterion("minutes not in", values, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesBetween(String value1, String value2) {
            addCriterion("minutes between", value1, value2, "minutes");
            return (Criteria) this;
        }

        public Criteria andMinutesNotBetween(String value1, String value2) {
            addCriterion("minutes not between", value1, value2, "minutes");
            return (Criteria) this;
        }

        public Criteria andHourIsNull() {
            addCriterion("hour is null");
            return (Criteria) this;
        }

        public Criteria andHourIsNotNull() {
            addCriterion("hour is not null");
            return (Criteria) this;
        }

        public Criteria andHourEqualTo(String value) {
            addCriterion("hour =", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotEqualTo(String value) {
            addCriterion("hour <>", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThan(String value) {
            addCriterion("hour >", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThanOrEqualTo(String value) {
            addCriterion("hour >=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThan(String value) {
            addCriterion("hour <", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThanOrEqualTo(String value) {
            addCriterion("hour <=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLike(String value) {
            addCriterion("hour like", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotLike(String value) {
            addCriterion("hour not like", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourIn(List<String> values) {
            addCriterion("hour in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotIn(List<String> values) {
            addCriterion("hour not in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourBetween(String value1, String value2) {
            addCriterion("hour between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotBetween(String value1, String value2) {
            addCriterion("hour not between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andToreviseIsNull() {
            addCriterion("torevise is null");
            return (Criteria) this;
        }

        public Criteria andToreviseIsNotNull() {
            addCriterion("torevise is not null");
            return (Criteria) this;
        }

        public Criteria andToreviseEqualTo(String value) {
            addCriterion("torevise =", value, "torevise");
            return (Criteria) this;
        }

        public Criteria andToreviseNotEqualTo(String value) {
            addCriterion("torevise <>", value, "torevise");
            return (Criteria) this;
        }

        public Criteria andToreviseGreaterThan(String value) {
            addCriterion("torevise >", value, "torevise");
            return (Criteria) this;
        }

        public Criteria andToreviseGreaterThanOrEqualTo(String value) {
            addCriterion("torevise >=", value, "torevise");
            return (Criteria) this;
        }

        public Criteria andToreviseLessThan(String value) {
            addCriterion("torevise <", value, "torevise");
            return (Criteria) this;
        }

        public Criteria andToreviseLessThanOrEqualTo(String value) {
            addCriterion("torevise <=", value, "torevise");
            return (Criteria) this;
        }

        public Criteria andToreviseLike(String value) {
            addCriterion("torevise like", value, "torevise");
            return (Criteria) this;
        }

        public Criteria andToreviseNotLike(String value) {
            addCriterion("torevise not like", value, "torevise");
            return (Criteria) this;
        }

        public Criteria andToreviseIn(List<String> values) {
            addCriterion("torevise in", values, "torevise");
            return (Criteria) this;
        }

        public Criteria andToreviseNotIn(List<String> values) {
            addCriterion("torevise not in", values, "torevise");
            return (Criteria) this;
        }

        public Criteria andToreviseBetween(String value1, String value2) {
            addCriterion("torevise between", value1, value2, "torevise");
            return (Criteria) this;
        }

        public Criteria andToreviseNotBetween(String value1, String value2) {
            addCriterion("torevise not between", value1, value2, "torevise");
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
     * t_rcu_settime 
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