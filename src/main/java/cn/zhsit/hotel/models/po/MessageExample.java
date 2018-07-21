package cn.zhsit.hotel.models.po;

import cn.zhsit.common.utils.page.BaseExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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
     * t_message 
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

        public Criteria andMessageidIsNull() {
            addCriterion("messageid is null");
            return (Criteria) this;
        }

        public Criteria andMessageidIsNotNull() {
            addCriterion("messageid is not null");
            return (Criteria) this;
        }

        public Criteria andMessageidEqualTo(String value) {
            addCriterion("messageid =", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotEqualTo(String value) {
            addCriterion("messageid <>", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThan(String value) {
            addCriterion("messageid >", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThanOrEqualTo(String value) {
            addCriterion("messageid >=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThan(String value) {
            addCriterion("messageid <", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThanOrEqualTo(String value) {
            addCriterion("messageid <=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLike(String value) {
            addCriterion("messageid like", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotLike(String value) {
            addCriterion("messageid not like", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidIn(List<String> values) {
            addCriterion("messageid in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotIn(List<String> values) {
            addCriterion("messageid not in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidBetween(String value1, String value2) {
            addCriterion("messageid between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotBetween(String value1, String value2) {
            addCriterion("messageid not between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(String value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(String value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(String value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(String value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(String value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(String value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLike(String value) {
            addCriterion("room_id like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotLike(String value) {
            addCriterion("room_id not like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<String> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<String> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(String value1, String value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(String value1, String value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNull() {
            addCriterion("message_type is null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNotNull() {
            addCriterion("message_type is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeEqualTo(Byte value) {
            addCriterion("message_type =", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotEqualTo(Byte value) {
            addCriterion("message_type <>", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThan(Byte value) {
            addCriterion("message_type >", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("message_type >=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThan(Byte value) {
            addCriterion("message_type <", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThanOrEqualTo(Byte value) {
            addCriterion("message_type <=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIn(List<Byte> values) {
            addCriterion("message_type in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotIn(List<Byte> values) {
            addCriterion("message_type not in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeBetween(Byte value1, Byte value2) {
            addCriterion("message_type between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("message_type not between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<String> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("sender is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("sender is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("sender =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("sender <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("sender >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("sender >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("sender <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("sender <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("sender like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("sender not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("sender in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("sender not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("sender between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andPriIsNull() {
            addCriterion("pri is null");
            return (Criteria) this;
        }

        public Criteria andPriIsNotNull() {
            addCriterion("pri is not null");
            return (Criteria) this;
        }

        public Criteria andPriEqualTo(String value) {
            addCriterion("pri =", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotEqualTo(String value) {
            addCriterion("pri <>", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriGreaterThan(String value) {
            addCriterion("pri >", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriGreaterThanOrEqualTo(String value) {
            addCriterion("pri >=", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLessThan(String value) {
            addCriterion("pri <", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLessThanOrEqualTo(String value) {
            addCriterion("pri <=", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLike(String value) {
            addCriterion("pri like", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotLike(String value) {
            addCriterion("pri not like", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriIn(List<String> values) {
            addCriterion("pri in", values, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotIn(List<String> values) {
            addCriterion("pri not in", values, "pri");
            return (Criteria) this;
        }

        public Criteria andPriBetween(String value1, String value2) {
            addCriterion("pri between", value1, value2, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotBetween(String value1, String value2) {
            addCriterion("pri not between", value1, value2, "pri");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNull() {
            addCriterion("person_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("person_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(String value) {
            addCriterion("person_id =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(String value) {
            addCriterion("person_id <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(String value) {
            addCriterion("person_id >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("person_id >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(String value) {
            addCriterion("person_id <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(String value) {
            addCriterion("person_id <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLike(String value) {
            addCriterion("person_id like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotLike(String value) {
            addCriterion("person_id not like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<String> values) {
            addCriterion("person_id in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<String> values) {
            addCriterion("person_id not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(String value1, String value2) {
            addCriterion("person_id between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(String value1, String value2) {
            addCriterion("person_id not between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNull() {
            addCriterion("send_status is null");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNotNull() {
            addCriterion("send_status is not null");
            return (Criteria) this;
        }

        public Criteria andSendStatusEqualTo(Byte value) {
            addCriterion("send_status =", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotEqualTo(Byte value) {
            addCriterion("send_status <>", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThan(Byte value) {
            addCriterion("send_status >", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("send_status >=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThan(Byte value) {
            addCriterion("send_status <", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThanOrEqualTo(Byte value) {
            addCriterion("send_status <=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusIn(List<Byte> values) {
            addCriterion("send_status in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotIn(List<Byte> values) {
            addCriterion("send_status not in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusBetween(Byte value1, Byte value2) {
            addCriterion("send_status between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("send_status not between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeIsNull() {
            addCriterion("send_date_time is null");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeIsNotNull() {
            addCriterion("send_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeEqualTo(Date value) {
            addCriterion("send_date_time =", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeNotEqualTo(Date value) {
            addCriterion("send_date_time <>", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeGreaterThan(Date value) {
            addCriterion("send_date_time >", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_date_time >=", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeLessThan(Date value) {
            addCriterion("send_date_time <", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_date_time <=", value, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeIn(List<Date> values) {
            addCriterion("send_date_time in", values, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeNotIn(List<Date> values) {
            addCriterion("send_date_time not in", values, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeBetween(Date value1, Date value2) {
            addCriterion("send_date_time between", value1, value2, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSendDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_date_time not between", value1, value2, "sendDateTime");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusIsNull() {
            addCriterion("speak_status is null");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusIsNotNull() {
            addCriterion("speak_status is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusEqualTo(Byte value) {
            addCriterion("speak_status =", value, "speakStatus");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusNotEqualTo(Byte value) {
            addCriterion("speak_status <>", value, "speakStatus");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusGreaterThan(Byte value) {
            addCriterion("speak_status >", value, "speakStatus");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("speak_status >=", value, "speakStatus");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusLessThan(Byte value) {
            addCriterion("speak_status <", value, "speakStatus");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusLessThanOrEqualTo(Byte value) {
            addCriterion("speak_status <=", value, "speakStatus");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusIn(List<Byte> values) {
            addCriterion("speak_status in", values, "speakStatus");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusNotIn(List<Byte> values) {
            addCriterion("speak_status not in", values, "speakStatus");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusBetween(Byte value1, Byte value2) {
            addCriterion("speak_status between", value1, value2, "speakStatus");
            return (Criteria) this;
        }

        public Criteria andSpeakStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("speak_status not between", value1, value2, "speakStatus");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeIsNull() {
            addCriterion("speak_date_time is null");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeIsNotNull() {
            addCriterion("speak_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeEqualTo(Date value) {
            addCriterion("speak_date_time =", value, "speakDateTime");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeNotEqualTo(Date value) {
            addCriterion("speak_date_time <>", value, "speakDateTime");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeGreaterThan(Date value) {
            addCriterion("speak_date_time >", value, "speakDateTime");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("speak_date_time >=", value, "speakDateTime");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeLessThan(Date value) {
            addCriterion("speak_date_time <", value, "speakDateTime");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("speak_date_time <=", value, "speakDateTime");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeIn(List<Date> values) {
            addCriterion("speak_date_time in", values, "speakDateTime");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeNotIn(List<Date> values) {
            addCriterion("speak_date_time not in", values, "speakDateTime");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeBetween(Date value1, Date value2) {
            addCriterion("speak_date_time between", value1, value2, "speakDateTime");
            return (Criteria) this;
        }

        public Criteria andSpeakDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("speak_date_time not between", value1, value2, "speakDateTime");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsIsNull() {
            addCriterion("rcu_send_stauts is null");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsIsNotNull() {
            addCriterion("rcu_send_stauts is not null");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsEqualTo(Byte value) {
            addCriterion("rcu_send_stauts =", value, "rcuSendStauts");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsNotEqualTo(Byte value) {
            addCriterion("rcu_send_stauts <>", value, "rcuSendStauts");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsGreaterThan(Byte value) {
            addCriterion("rcu_send_stauts >", value, "rcuSendStauts");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsGreaterThanOrEqualTo(Byte value) {
            addCriterion("rcu_send_stauts >=", value, "rcuSendStauts");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsLessThan(Byte value) {
            addCriterion("rcu_send_stauts <", value, "rcuSendStauts");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsLessThanOrEqualTo(Byte value) {
            addCriterion("rcu_send_stauts <=", value, "rcuSendStauts");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsIn(List<Byte> values) {
            addCriterion("rcu_send_stauts in", values, "rcuSendStauts");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsNotIn(List<Byte> values) {
            addCriterion("rcu_send_stauts not in", values, "rcuSendStauts");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsBetween(Byte value1, Byte value2) {
            addCriterion("rcu_send_stauts between", value1, value2, "rcuSendStauts");
            return (Criteria) this;
        }

        public Criteria andRcuSendStautsNotBetween(Byte value1, Byte value2) {
            addCriterion("rcu_send_stauts not between", value1, value2, "rcuSendStauts");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeIsNull() {
            addCriterion("rcu_send_date_time is null");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeIsNotNull() {
            addCriterion("rcu_send_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeEqualTo(Date value) {
            addCriterion("rcu_send_date_time =", value, "rcuSendDateTime");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeNotEqualTo(Date value) {
            addCriterion("rcu_send_date_time <>", value, "rcuSendDateTime");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeGreaterThan(Date value) {
            addCriterion("rcu_send_date_time >", value, "rcuSendDateTime");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rcu_send_date_time >=", value, "rcuSendDateTime");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeLessThan(Date value) {
            addCriterion("rcu_send_date_time <", value, "rcuSendDateTime");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("rcu_send_date_time <=", value, "rcuSendDateTime");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeIn(List<Date> values) {
            addCriterion("rcu_send_date_time in", values, "rcuSendDateTime");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeNotIn(List<Date> values) {
            addCriterion("rcu_send_date_time not in", values, "rcuSendDateTime");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeBetween(Date value1, Date value2) {
            addCriterion("rcu_send_date_time between", value1, value2, "rcuSendDateTime");
            return (Criteria) this;
        }

        public Criteria andRcuSendDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("rcu_send_date_time not between", value1, value2, "rcuSendDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_message 
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