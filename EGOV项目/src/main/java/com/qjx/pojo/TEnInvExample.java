package com.qjx.pojo;

import java.util.ArrayList;
import java.util.List;

public class TEnInvExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TEnInvExample() {
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

        public Criteria andOrgcodeIsNull() {
            addCriterion("orgcode is null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNotNull() {
            addCriterion("orgcode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeEqualTo(Integer value) {
            addCriterion("orgcode =", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotEqualTo(Integer value) {
            addCriterion("orgcode <>", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThan(Integer value) {
            addCriterion("orgcode >", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("orgcode >=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThan(Integer value) {
            addCriterion("orgcode <", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThanOrEqualTo(Integer value) {
            addCriterion("orgcode <=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIn(List<Integer> values) {
            addCriterion("orgcode in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotIn(List<Integer> values) {
            addCriterion("orgcode not in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeBetween(Integer value1, Integer value2) {
            addCriterion("orgcode between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("orgcode not between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andInvregnumIsNull() {
            addCriterion("invregnum is null");
            return (Criteria) this;
        }

        public Criteria andInvregnumIsNotNull() {
            addCriterion("invregnum is not null");
            return (Criteria) this;
        }

        public Criteria andInvregnumEqualTo(Integer value) {
            addCriterion("invregnum =", value, "invregnum");
            return (Criteria) this;
        }

        public Criteria andInvregnumNotEqualTo(Integer value) {
            addCriterion("invregnum <>", value, "invregnum");
            return (Criteria) this;
        }

        public Criteria andInvregnumGreaterThan(Integer value) {
            addCriterion("invregnum >", value, "invregnum");
            return (Criteria) this;
        }

        public Criteria andInvregnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("invregnum >=", value, "invregnum");
            return (Criteria) this;
        }

        public Criteria andInvregnumLessThan(Integer value) {
            addCriterion("invregnum <", value, "invregnum");
            return (Criteria) this;
        }

        public Criteria andInvregnumLessThanOrEqualTo(Integer value) {
            addCriterion("invregnum <=", value, "invregnum");
            return (Criteria) this;
        }

        public Criteria andInvregnumIn(List<Integer> values) {
            addCriterion("invregnum in", values, "invregnum");
            return (Criteria) this;
        }

        public Criteria andInvregnumNotIn(List<Integer> values) {
            addCriterion("invregnum not in", values, "invregnum");
            return (Criteria) this;
        }

        public Criteria andInvregnumBetween(Integer value1, Integer value2) {
            addCriterion("invregnum between", value1, value2, "invregnum");
            return (Criteria) this;
        }

        public Criteria andInvregnumNotBetween(Integer value1, Integer value2) {
            addCriterion("invregnum not between", value1, value2, "invregnum");
            return (Criteria) this;
        }

        public Criteria andRegcapIsNull() {
            addCriterion("regcap is null");
            return (Criteria) this;
        }

        public Criteria andRegcapIsNotNull() {
            addCriterion("regcap is not null");
            return (Criteria) this;
        }

        public Criteria andRegcapEqualTo(Integer value) {
            addCriterion("regcap =", value, "regcap");
            return (Criteria) this;
        }

        public Criteria andRegcapNotEqualTo(Integer value) {
            addCriterion("regcap <>", value, "regcap");
            return (Criteria) this;
        }

        public Criteria andRegcapGreaterThan(Integer value) {
            addCriterion("regcap >", value, "regcap");
            return (Criteria) this;
        }

        public Criteria andRegcapGreaterThanOrEqualTo(Integer value) {
            addCriterion("regcap >=", value, "regcap");
            return (Criteria) this;
        }

        public Criteria andRegcapLessThan(Integer value) {
            addCriterion("regcap <", value, "regcap");
            return (Criteria) this;
        }

        public Criteria andRegcapLessThanOrEqualTo(Integer value) {
            addCriterion("regcap <=", value, "regcap");
            return (Criteria) this;
        }

        public Criteria andRegcapIn(List<Integer> values) {
            addCriterion("regcap in", values, "regcap");
            return (Criteria) this;
        }

        public Criteria andRegcapNotIn(List<Integer> values) {
            addCriterion("regcap not in", values, "regcap");
            return (Criteria) this;
        }

        public Criteria andRegcapBetween(Integer value1, Integer value2) {
            addCriterion("regcap between", value1, value2, "regcap");
            return (Criteria) this;
        }

        public Criteria andRegcapNotBetween(Integer value1, Integer value2) {
            addCriterion("regcap not between", value1, value2, "regcap");
            return (Criteria) this;
        }

        public Criteria andScaleIsNull() {
            addCriterion("scale is null");
            return (Criteria) this;
        }

        public Criteria andScaleIsNotNull() {
            addCriterion("scale is not null");
            return (Criteria) this;
        }

        public Criteria andScaleEqualTo(Integer value) {
            addCriterion("scale =", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotEqualTo(Integer value) {
            addCriterion("scale <>", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThan(Integer value) {
            addCriterion("scale >", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("scale >=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThan(Integer value) {
            addCriterion("scale <", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThanOrEqualTo(Integer value) {
            addCriterion("scale <=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleIn(List<Integer> values) {
            addCriterion("scale in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotIn(List<Integer> values) {
            addCriterion("scale not in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleBetween(Integer value1, Integer value2) {
            addCriterion("scale between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotBetween(Integer value1, Integer value2) {
            addCriterion("scale not between", value1, value2, "scale");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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