package cn.zhsit.hotel.models.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BuildingHotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingHotelExample() {
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
     * t_building_hotel 
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSubFloorIsNull() {
            addCriterion("sub_floor is null");
            return (Criteria) this;
        }

        public Criteria andSubFloorIsNotNull() {
            addCriterion("sub_floor is not null");
            return (Criteria) this;
        }

        public Criteria andSubFloorEqualTo(Integer value) {
            addCriterion("sub_floor =", value, "subFloor");
            return (Criteria) this;
        }

        public Criteria andSubFloorNotEqualTo(Integer value) {
            addCriterion("sub_floor <>", value, "subFloor");
            return (Criteria) this;
        }

        public Criteria andSubFloorGreaterThan(Integer value) {
            addCriterion("sub_floor >", value, "subFloor");
            return (Criteria) this;
        }

        public Criteria andSubFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_floor >=", value, "subFloor");
            return (Criteria) this;
        }

        public Criteria andSubFloorLessThan(Integer value) {
            addCriterion("sub_floor <", value, "subFloor");
            return (Criteria) this;
        }

        public Criteria andSubFloorLessThanOrEqualTo(Integer value) {
            addCriterion("sub_floor <=", value, "subFloor");
            return (Criteria) this;
        }

        public Criteria andSubFloorIn(List<Integer> values) {
            addCriterion("sub_floor in", values, "subFloor");
            return (Criteria) this;
        }

        public Criteria andSubFloorNotIn(List<Integer> values) {
            addCriterion("sub_floor not in", values, "subFloor");
            return (Criteria) this;
        }

        public Criteria andSubFloorBetween(Integer value1, Integer value2) {
            addCriterion("sub_floor between", value1, value2, "subFloor");
            return (Criteria) this;
        }

        public Criteria andSubFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_floor not between", value1, value2, "subFloor");
            return (Criteria) this;
        }

        public Criteria andManageridIsNull() {
            addCriterion("managerid is null");
            return (Criteria) this;
        }

        public Criteria andManageridIsNotNull() {
            addCriterion("managerid is not null");
            return (Criteria) this;
        }

        public Criteria andManageridEqualTo(Integer value) {
            addCriterion("managerid =", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotEqualTo(Integer value) {
            addCriterion("managerid <>", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThan(Integer value) {
            addCriterion("managerid >", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridGreaterThanOrEqualTo(Integer value) {
            addCriterion("managerid >=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThan(Integer value) {
            addCriterion("managerid <", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridLessThanOrEqualTo(Integer value) {
            addCriterion("managerid <=", value, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridIn(List<Integer> values) {
            addCriterion("managerid in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotIn(List<Integer> values) {
            addCriterion("managerid not in", values, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridBetween(Integer value1, Integer value2) {
            addCriterion("managerid between", value1, value2, "managerid");
            return (Criteria) this;
        }

        public Criteria andManageridNotBetween(Integer value1, Integer value2) {
            addCriterion("managerid not between", value1, value2, "managerid");
            return (Criteria) this;
        }

        public Criteria andBldManagerIsNull() {
            addCriterion("bld_manager is null");
            return (Criteria) this;
        }

        public Criteria andBldManagerIsNotNull() {
            addCriterion("bld_manager is not null");
            return (Criteria) this;
        }

        public Criteria andBldManagerEqualTo(String value) {
            addCriterion("bld_manager =", value, "bldManager");
            return (Criteria) this;
        }

        public Criteria andBldManagerNotEqualTo(String value) {
            addCriterion("bld_manager <>", value, "bldManager");
            return (Criteria) this;
        }

        public Criteria andBldManagerGreaterThan(String value) {
            addCriterion("bld_manager >", value, "bldManager");
            return (Criteria) this;
        }

        public Criteria andBldManagerGreaterThanOrEqualTo(String value) {
            addCriterion("bld_manager >=", value, "bldManager");
            return (Criteria) this;
        }

        public Criteria andBldManagerLessThan(String value) {
            addCriterion("bld_manager <", value, "bldManager");
            return (Criteria) this;
        }

        public Criteria andBldManagerLessThanOrEqualTo(String value) {
            addCriterion("bld_manager <=", value, "bldManager");
            return (Criteria) this;
        }

        public Criteria andBldManagerLike(String value) {
            addCriterion("bld_manager like", value, "bldManager");
            return (Criteria) this;
        }

        public Criteria andBldManagerNotLike(String value) {
            addCriterion("bld_manager not like", value, "bldManager");
            return (Criteria) this;
        }

        public Criteria andBldManagerIn(List<String> values) {
            addCriterion("bld_manager in", values, "bldManager");
            return (Criteria) this;
        }

        public Criteria andBldManagerNotIn(List<String> values) {
            addCriterion("bld_manager not in", values, "bldManager");
            return (Criteria) this;
        }

        public Criteria andBldManagerBetween(String value1, String value2) {
            addCriterion("bld_manager between", value1, value2, "bldManager");
            return (Criteria) this;
        }

        public Criteria andBldManagerNotBetween(String value1, String value2) {
            addCriterion("bld_manager not between", value1, value2, "bldManager");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andBuildyearIsNull() {
            addCriterion("buildyear is null");
            return (Criteria) this;
        }

        public Criteria andBuildyearIsNotNull() {
            addCriterion("buildyear is not null");
            return (Criteria) this;
        }

        public Criteria andBuildyearEqualTo(Date value) {
            addCriterionForJDBCDate("buildyear =", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearNotEqualTo(Date value) {
            addCriterionForJDBCDate("buildyear <>", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearGreaterThan(Date value) {
            addCriterionForJDBCDate("buildyear >", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buildyear >=", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearLessThan(Date value) {
            addCriterionForJDBCDate("buildyear <", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buildyear <=", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearIn(List<Date> values) {
            addCriterionForJDBCDate("buildyear in", values, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearNotIn(List<Date> values) {
            addCriterionForJDBCDate("buildyear not in", values, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buildyear between", value1, value2, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buildyear not between", value1, value2, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBldimageIsNull() {
            addCriterion("bldimage is null");
            return (Criteria) this;
        }

        public Criteria andBldimageIsNotNull() {
            addCriterion("bldimage is not null");
            return (Criteria) this;
        }

        public Criteria andBldimageEqualTo(String value) {
            addCriterion("bldimage =", value, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldimageNotEqualTo(String value) {
            addCriterion("bldimage <>", value, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldimageGreaterThan(String value) {
            addCriterion("bldimage >", value, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldimageGreaterThanOrEqualTo(String value) {
            addCriterion("bldimage >=", value, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldimageLessThan(String value) {
            addCriterion("bldimage <", value, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldimageLessThanOrEqualTo(String value) {
            addCriterion("bldimage <=", value, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldimageLike(String value) {
            addCriterion("bldimage like", value, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldimageNotLike(String value) {
            addCriterion("bldimage not like", value, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldimageIn(List<String> values) {
            addCriterion("bldimage in", values, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldimageNotIn(List<String> values) {
            addCriterion("bldimage not in", values, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldimageBetween(String value1, String value2) {
            addCriterion("bldimage between", value1, value2, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldimageNotBetween(String value1, String value2) {
            addCriterion("bldimage not between", value1, value2, "bldimage");
            return (Criteria) this;
        }

        public Criteria andBldareaIsNull() {
            addCriterion("bldarea is null");
            return (Criteria) this;
        }

        public Criteria andBldareaIsNotNull() {
            addCriterion("bldarea is not null");
            return (Criteria) this;
        }

        public Criteria andBldareaEqualTo(String value) {
            addCriterion("bldarea =", value, "bldarea");
            return (Criteria) this;
        }

        public Criteria andBldareaNotEqualTo(String value) {
            addCriterion("bldarea <>", value, "bldarea");
            return (Criteria) this;
        }

        public Criteria andBldareaGreaterThan(String value) {
            addCriterion("bldarea >", value, "bldarea");
            return (Criteria) this;
        }

        public Criteria andBldareaGreaterThanOrEqualTo(String value) {
            addCriterion("bldarea >=", value, "bldarea");
            return (Criteria) this;
        }

        public Criteria andBldareaLessThan(String value) {
            addCriterion("bldarea <", value, "bldarea");
            return (Criteria) this;
        }

        public Criteria andBldareaLessThanOrEqualTo(String value) {
            addCriterion("bldarea <=", value, "bldarea");
            return (Criteria) this;
        }

        public Criteria andBldareaLike(String value) {
            addCriterion("bldarea like", value, "bldarea");
            return (Criteria) this;
        }

        public Criteria andBldareaNotLike(String value) {
            addCriterion("bldarea not like", value, "bldarea");
            return (Criteria) this;
        }

        public Criteria andBldareaIn(List<String> values) {
            addCriterion("bldarea in", values, "bldarea");
            return (Criteria) this;
        }

        public Criteria andBldareaNotIn(List<String> values) {
            addCriterion("bldarea not in", values, "bldarea");
            return (Criteria) this;
        }

        public Criteria andBldareaBetween(String value1, String value2) {
            addCriterion("bldarea between", value1, value2, "bldarea");
            return (Criteria) this;
        }

        public Criteria andBldareaNotBetween(String value1, String value2) {
            addCriterion("bldarea not between", value1, value2, "bldarea");
            return (Criteria) this;
        }

        public Criteria andUnitnumIsNull() {
            addCriterion("unitnum is null");
            return (Criteria) this;
        }

        public Criteria andUnitnumIsNotNull() {
            addCriterion("unitnum is not null");
            return (Criteria) this;
        }

        public Criteria andUnitnumEqualTo(Integer value) {
            addCriterion("unitnum =", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumNotEqualTo(Integer value) {
            addCriterion("unitnum <>", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumGreaterThan(Integer value) {
            addCriterion("unitnum >", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("unitnum >=", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumLessThan(Integer value) {
            addCriterion("unitnum <", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumLessThanOrEqualTo(Integer value) {
            addCriterion("unitnum <=", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumIn(List<Integer> values) {
            addCriterion("unitnum in", values, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumNotIn(List<Integer> values) {
            addCriterion("unitnum not in", values, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumBetween(Integer value1, Integer value2) {
            addCriterion("unitnum between", value1, value2, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumNotBetween(Integer value1, Integer value2) {
            addCriterion("unitnum not between", value1, value2, "unitnum");
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

        public Criteria andIptpersonIsNull() {
            addCriterion("iptperson is null");
            return (Criteria) this;
        }

        public Criteria andIptpersonIsNotNull() {
            addCriterion("iptperson is not null");
            return (Criteria) this;
        }

        public Criteria andIptpersonEqualTo(String value) {
            addCriterion("iptperson =", value, "iptperson");
            return (Criteria) this;
        }

        public Criteria andIptpersonNotEqualTo(String value) {
            addCriterion("iptperson <>", value, "iptperson");
            return (Criteria) this;
        }

        public Criteria andIptpersonGreaterThan(String value) {
            addCriterion("iptperson >", value, "iptperson");
            return (Criteria) this;
        }

        public Criteria andIptpersonGreaterThanOrEqualTo(String value) {
            addCriterion("iptperson >=", value, "iptperson");
            return (Criteria) this;
        }

        public Criteria andIptpersonLessThan(String value) {
            addCriterion("iptperson <", value, "iptperson");
            return (Criteria) this;
        }

        public Criteria andIptpersonLessThanOrEqualTo(String value) {
            addCriterion("iptperson <=", value, "iptperson");
            return (Criteria) this;
        }

        public Criteria andIptpersonLike(String value) {
            addCriterion("iptperson like", value, "iptperson");
            return (Criteria) this;
        }

        public Criteria andIptpersonNotLike(String value) {
            addCriterion("iptperson not like", value, "iptperson");
            return (Criteria) this;
        }

        public Criteria andIptpersonIn(List<String> values) {
            addCriterion("iptperson in", values, "iptperson");
            return (Criteria) this;
        }

        public Criteria andIptpersonNotIn(List<String> values) {
            addCriterion("iptperson not in", values, "iptperson");
            return (Criteria) this;
        }

        public Criteria andIptpersonBetween(String value1, String value2) {
            addCriterion("iptperson between", value1, value2, "iptperson");
            return (Criteria) this;
        }

        public Criteria andIptpersonNotBetween(String value1, String value2) {
            addCriterion("iptperson not between", value1, value2, "iptperson");
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

        public Criteria andExtfloorIsNull() {
            addCriterion("extfloor is null");
            return (Criteria) this;
        }

        public Criteria andExtfloorIsNotNull() {
            addCriterion("extfloor is not null");
            return (Criteria) this;
        }

        public Criteria andExtfloorEqualTo(String value) {
            addCriterion("extfloor =", value, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtfloorNotEqualTo(String value) {
            addCriterion("extfloor <>", value, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtfloorGreaterThan(String value) {
            addCriterion("extfloor >", value, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtfloorGreaterThanOrEqualTo(String value) {
            addCriterion("extfloor >=", value, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtfloorLessThan(String value) {
            addCriterion("extfloor <", value, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtfloorLessThanOrEqualTo(String value) {
            addCriterion("extfloor <=", value, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtfloorLike(String value) {
            addCriterion("extfloor like", value, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtfloorNotLike(String value) {
            addCriterion("extfloor not like", value, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtfloorIn(List<String> values) {
            addCriterion("extfloor in", values, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtfloorNotIn(List<String> values) {
            addCriterion("extfloor not in", values, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtfloorBetween(String value1, String value2) {
            addCriterion("extfloor between", value1, value2, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtfloorNotBetween(String value1, String value2) {
            addCriterion("extfloor not between", value1, value2, "extfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorIsNull() {
            addCriterion("extsubfloor is null");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorIsNotNull() {
            addCriterion("extsubfloor is not null");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorEqualTo(String value) {
            addCriterion("extsubfloor =", value, "extsubfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorNotEqualTo(String value) {
            addCriterion("extsubfloor <>", value, "extsubfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorGreaterThan(String value) {
            addCriterion("extsubfloor >", value, "extsubfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorGreaterThanOrEqualTo(String value) {
            addCriterion("extsubfloor >=", value, "extsubfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorLessThan(String value) {
            addCriterion("extsubfloor <", value, "extsubfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorLessThanOrEqualTo(String value) {
            addCriterion("extsubfloor <=", value, "extsubfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorLike(String value) {
            addCriterion("extsubfloor like", value, "extsubfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorNotLike(String value) {
            addCriterion("extsubfloor not like", value, "extsubfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorIn(List<String> values) {
            addCriterion("extsubfloor in", values, "extsubfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorNotIn(List<String> values) {
            addCriterion("extsubfloor not in", values, "extsubfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorBetween(String value1, String value2) {
            addCriterion("extsubfloor between", value1, value2, "extsubfloor");
            return (Criteria) this;
        }

        public Criteria andExtsubfloorNotBetween(String value1, String value2) {
            addCriterion("extsubfloor not between", value1, value2, "extsubfloor");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * t_building_hotel 
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