package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.List;

public class FloorHotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FloorHotelExample() {
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
     * t_floor_hotel 
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

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(String value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(String value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(String value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(String value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(String value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(String value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLike(String value) {
            addCriterion("building_id like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotLike(String value) {
            addCriterion("building_id not like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<String> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<String> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(String value1, String value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(String value1, String value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(Integer value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(Integer value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(Integer value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(Integer value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(Integer value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<Integer> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<Integer> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(Integer value1, Integer value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloornameIsNull() {
            addCriterion("floorname is null");
            return (Criteria) this;
        }

        public Criteria andFloornameIsNotNull() {
            addCriterion("floorname is not null");
            return (Criteria) this;
        }

        public Criteria andFloornameEqualTo(String value) {
            addCriterion("floorname =", value, "floorname");
            return (Criteria) this;
        }

        public Criteria andFloornameNotEqualTo(String value) {
            addCriterion("floorname <>", value, "floorname");
            return (Criteria) this;
        }

        public Criteria andFloornameGreaterThan(String value) {
            addCriterion("floorname >", value, "floorname");
            return (Criteria) this;
        }

        public Criteria andFloornameGreaterThanOrEqualTo(String value) {
            addCriterion("floorname >=", value, "floorname");
            return (Criteria) this;
        }

        public Criteria andFloornameLessThan(String value) {
            addCriterion("floorname <", value, "floorname");
            return (Criteria) this;
        }

        public Criteria andFloornameLessThanOrEqualTo(String value) {
            addCriterion("floorname <=", value, "floorname");
            return (Criteria) this;
        }

        public Criteria andFloornameLike(String value) {
            addCriterion("floorname like", value, "floorname");
            return (Criteria) this;
        }

        public Criteria andFloornameNotLike(String value) {
            addCriterion("floorname not like", value, "floorname");
            return (Criteria) this;
        }

        public Criteria andFloornameIn(List<String> values) {
            addCriterion("floorname in", values, "floorname");
            return (Criteria) this;
        }

        public Criteria andFloornameNotIn(List<String> values) {
            addCriterion("floorname not in", values, "floorname");
            return (Criteria) this;
        }

        public Criteria andFloornameBetween(String value1, String value2) {
            addCriterion("floorname between", value1, value2, "floorname");
            return (Criteria) this;
        }

        public Criteria andFloornameNotBetween(String value1, String value2) {
            addCriterion("floorname not between", value1, value2, "floorname");
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

        public Criteria andRoomnumEqualTo(Integer value) {
            addCriterion("roomnum =", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotEqualTo(Integer value) {
            addCriterion("roomnum <>", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumGreaterThan(Integer value) {
            addCriterion("roomnum >", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomnum >=", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumLessThan(Integer value) {
            addCriterion("roomnum <", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumLessThanOrEqualTo(Integer value) {
            addCriterion("roomnum <=", value, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumIn(List<Integer> values) {
            addCriterion("roomnum in", values, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotIn(List<Integer> values) {
            addCriterion("roomnum not in", values, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumBetween(Integer value1, Integer value2) {
            addCriterion("roomnum between", value1, value2, "roomnum");
            return (Criteria) this;
        }

        public Criteria andRoomnumNotBetween(Integer value1, Integer value2) {
            addCriterion("roomnum not between", value1, value2, "roomnum");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNull() {
            addCriterion("building_name is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNotNull() {
            addCriterion("building_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameEqualTo(String value) {
            addCriterion("building_name =", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotEqualTo(String value) {
            addCriterion("building_name <>", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThan(String value) {
            addCriterion("building_name >", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThanOrEqualTo(String value) {
            addCriterion("building_name >=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThan(String value) {
            addCriterion("building_name <", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThanOrEqualTo(String value) {
            addCriterion("building_name <=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLike(String value) {
            addCriterion("building_name like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotLike(String value) {
            addCriterion("building_name not like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIn(List<String> values) {
            addCriterion("building_name in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotIn(List<String> values) {
            addCriterion("building_name not in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameBetween(String value1, String value2) {
            addCriterion("building_name between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotBetween(String value1, String value2) {
            addCriterion("building_name not between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andFloorstatusIsNull() {
            addCriterion("floorstatus is null");
            return (Criteria) this;
        }

        public Criteria andFloorstatusIsNotNull() {
            addCriterion("floorstatus is not null");
            return (Criteria) this;
        }

        public Criteria andFloorstatusEqualTo(String value) {
            addCriterion("floorstatus =", value, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorstatusNotEqualTo(String value) {
            addCriterion("floorstatus <>", value, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorstatusGreaterThan(String value) {
            addCriterion("floorstatus >", value, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorstatusGreaterThanOrEqualTo(String value) {
            addCriterion("floorstatus >=", value, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorstatusLessThan(String value) {
            addCriterion("floorstatus <", value, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorstatusLessThanOrEqualTo(String value) {
            addCriterion("floorstatus <=", value, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorstatusLike(String value) {
            addCriterion("floorstatus like", value, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorstatusNotLike(String value) {
            addCriterion("floorstatus not like", value, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorstatusIn(List<String> values) {
            addCriterion("floorstatus in", values, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorstatusNotIn(List<String> values) {
            addCriterion("floorstatus not in", values, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorstatusBetween(String value1, String value2) {
            addCriterion("floorstatus between", value1, value2, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorstatusNotBetween(String value1, String value2) {
            addCriterion("floorstatus not between", value1, value2, "floorstatus");
            return (Criteria) this;
        }

        public Criteria andFloorbelongIsNull() {
            addCriterion("floorbelong is null");
            return (Criteria) this;
        }

        public Criteria andFloorbelongIsNotNull() {
            addCriterion("floorbelong is not null");
            return (Criteria) this;
        }

        public Criteria andFloorbelongEqualTo(String value) {
            addCriterion("floorbelong =", value, "floorbelong");
            return (Criteria) this;
        }

        public Criteria andFloorbelongNotEqualTo(String value) {
            addCriterion("floorbelong <>", value, "floorbelong");
            return (Criteria) this;
        }

        public Criteria andFloorbelongGreaterThan(String value) {
            addCriterion("floorbelong >", value, "floorbelong");
            return (Criteria) this;
        }

        public Criteria andFloorbelongGreaterThanOrEqualTo(String value) {
            addCriterion("floorbelong >=", value, "floorbelong");
            return (Criteria) this;
        }

        public Criteria andFloorbelongLessThan(String value) {
            addCriterion("floorbelong <", value, "floorbelong");
            return (Criteria) this;
        }

        public Criteria andFloorbelongLessThanOrEqualTo(String value) {
            addCriterion("floorbelong <=", value, "floorbelong");
            return (Criteria) this;
        }

        public Criteria andFloorbelongLike(String value) {
            addCriterion("floorbelong like", value, "floorbelong");
            return (Criteria) this;
        }

        public Criteria andFloorbelongNotLike(String value) {
            addCriterion("floorbelong not like", value, "floorbelong");
            return (Criteria) this;
        }

        public Criteria andFloorbelongIn(List<String> values) {
            addCriterion("floorbelong in", values, "floorbelong");
            return (Criteria) this;
        }

        public Criteria andFloorbelongNotIn(List<String> values) {
            addCriterion("floorbelong not in", values, "floorbelong");
            return (Criteria) this;
        }

        public Criteria andFloorbelongBetween(String value1, String value2) {
            addCriterion("floorbelong between", value1, value2, "floorbelong");
            return (Criteria) this;
        }

        public Criteria andFloorbelongNotBetween(String value1, String value2) {
            addCriterion("floorbelong not between", value1, value2, "floorbelong");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_floor_hotel 
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