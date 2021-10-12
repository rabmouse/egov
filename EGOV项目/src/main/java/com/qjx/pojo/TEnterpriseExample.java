package com.qjx.pojo;

import java.util.ArrayList;
import java.util.List;

public class TEnterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TEnterpriseExample() {
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

        public Criteria andOrgcodeLike(Integer value) {
            addCriterion("orgcode like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotLike(Integer value) {
            addCriterion("orgcode not like", value, "orgcode");
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

        public Criteria andRegnoIsNull() {
            addCriterion("regno is null");
            return (Criteria) this;
        }

        public Criteria andRegnoIsNotNull() {
            addCriterion("regno is not null");
            return (Criteria) this;
        }

        public Criteria andRegnoEqualTo(String value) {
            addCriterion("regno =", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoNotEqualTo(String value) {
            addCriterion("regno <>", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoGreaterThan(String value) {
            addCriterion("regno >", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoGreaterThanOrEqualTo(String value) {
            addCriterion("regno >=", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoLessThan(String value) {
            addCriterion("regno <", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoLessThanOrEqualTo(String value) {
            addCriterion("regno <=", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoLike(String value) {
            addCriterion("regno like", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoNotLike(String value) {
            addCriterion("regno not like", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoIn(List<String> values) {
            addCriterion("regno in", values, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoNotIn(List<String> values) {
            addCriterion("regno not in", values, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoBetween(String value1, String value2) {
            addCriterion("regno between", value1, value2, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoNotBetween(String value1, String value2) {
            addCriterion("regno not between", value1, value2, "regno");
            return (Criteria) this;
        }

        public Criteria andCnnameIsNull() {
            addCriterion("cnname is null");
            return (Criteria) this;
        }

        public Criteria andCnnameIsNotNull() {
            addCriterion("cnname is not null");
            return (Criteria) this;
        }

        public Criteria andCnnameEqualTo(String value) {
            addCriterion("cnname =", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotEqualTo(String value) {
            addCriterion("cnname <>", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameGreaterThan(String value) {
            addCriterion("cnname >", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameGreaterThanOrEqualTo(String value) {
            addCriterion("cnname >=", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLessThan(String value) {
            addCriterion("cnname <", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLessThanOrEqualTo(String value) {
            addCriterion("cnname <=", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLike(String value) {
            addCriterion("cnname like", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotLike(String value) {
            addCriterion("cnname not like", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameIn(List<String> values) {
            addCriterion("cnname in", values, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotIn(List<String> values) {
            addCriterion("cnname not in", values, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameBetween(String value1, String value2) {
            addCriterion("cnname between", value1, value2, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotBetween(String value1, String value2) {
            addCriterion("cnname not between", value1, value2, "cnname");
            return (Criteria) this;
        }

        public Criteria andEnnameIsNull() {
            addCriterion("enname is null");
            return (Criteria) this;
        }

        public Criteria andEnnameIsNotNull() {
            addCriterion("enname is not null");
            return (Criteria) this;
        }

        public Criteria andEnnameEqualTo(String value) {
            addCriterion("enname =", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotEqualTo(String value) {
            addCriterion("enname <>", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameGreaterThan(String value) {
            addCriterion("enname >", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameGreaterThanOrEqualTo(String value) {
            addCriterion("enname >=", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLessThan(String value) {
            addCriterion("enname <", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLessThanOrEqualTo(String value) {
            addCriterion("enname <=", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameLike(String value) {
            addCriterion("enname like", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotLike(String value) {
            addCriterion("enname not like", value, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameIn(List<String> values) {
            addCriterion("enname in", values, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotIn(List<String> values) {
            addCriterion("enname not in", values, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameBetween(String value1, String value2) {
            addCriterion("enname between", value1, value2, "enname");
            return (Criteria) this;
        }

        public Criteria andEnnameNotBetween(String value1, String value2) {
            addCriterion("enname not between", value1, value2, "enname");
            return (Criteria) this;
        }

        public Criteria andContactmanIsNull() {
            addCriterion("contactman is null");
            return (Criteria) this;
        }

        public Criteria andContactmanIsNotNull() {
            addCriterion("contactman is not null");
            return (Criteria) this;
        }

        public Criteria andContactmanEqualTo(String value) {
            addCriterion("contactman =", value, "contactman");
            return (Criteria) this;
        }

        public Criteria andContactmanNotEqualTo(String value) {
            addCriterion("contactman <>", value, "contactman");
            return (Criteria) this;
        }

        public Criteria andContactmanGreaterThan(String value) {
            addCriterion("contactman >", value, "contactman");
            return (Criteria) this;
        }

        public Criteria andContactmanGreaterThanOrEqualTo(String value) {
            addCriterion("contactman >=", value, "contactman");
            return (Criteria) this;
        }

        public Criteria andContactmanLessThan(String value) {
            addCriterion("contactman <", value, "contactman");
            return (Criteria) this;
        }

        public Criteria andContactmanLessThanOrEqualTo(String value) {
            addCriterion("contactman <=", value, "contactman");
            return (Criteria) this;
        }

        public Criteria andContactmanLike(String value) {
            addCriterion("contactman like", value, "contactman");
            return (Criteria) this;
        }

        public Criteria andContactmanNotLike(String value) {
            addCriterion("contactman not like", value, "contactman");
            return (Criteria) this;
        }

        public Criteria andContactmanIn(List<String> values) {
            addCriterion("contactman in", values, "contactman");
            return (Criteria) this;
        }

        public Criteria andContactmanNotIn(List<String> values) {
            addCriterion("contactman not in", values, "contactman");
            return (Criteria) this;
        }

        public Criteria andContactmanBetween(String value1, String value2) {
            addCriterion("contactman between", value1, value2, "contactman");
            return (Criteria) this;
        }

        public Criteria andContactmanNotBetween(String value1, String value2) {
            addCriterion("contactman not between", value1, value2, "contactman");
            return (Criteria) this;
        }

        public Criteria andContacttelIsNull() {
            addCriterion("contacttel is null");
            return (Criteria) this;
        }

        public Criteria andContacttelIsNotNull() {
            addCriterion("contacttel is not null");
            return (Criteria) this;
        }

        public Criteria andContacttelEqualTo(String value) {
            addCriterion("contacttel =", value, "contacttel");
            return (Criteria) this;
        }

        public Criteria andContacttelNotEqualTo(String value) {
            addCriterion("contacttel <>", value, "contacttel");
            return (Criteria) this;
        }

        public Criteria andContacttelGreaterThan(String value) {
            addCriterion("contacttel >", value, "contacttel");
            return (Criteria) this;
        }

        public Criteria andContacttelGreaterThanOrEqualTo(String value) {
            addCriterion("contacttel >=", value, "contacttel");
            return (Criteria) this;
        }

        public Criteria andContacttelLessThan(String value) {
            addCriterion("contacttel <", value, "contacttel");
            return (Criteria) this;
        }

        public Criteria andContacttelLessThanOrEqualTo(String value) {
            addCriterion("contacttel <=", value, "contacttel");
            return (Criteria) this;
        }

        public Criteria andContacttelLike(String value) {
            addCriterion("contacttel like", value, "contacttel");
            return (Criteria) this;
        }

        public Criteria andContacttelNotLike(String value) {
            addCriterion("contacttel not like", value, "contacttel");
            return (Criteria) this;
        }

        public Criteria andContacttelIn(List<String> values) {
            addCriterion("contacttel in", values, "contacttel");
            return (Criteria) this;
        }

        public Criteria andContacttelNotIn(List<String> values) {
            addCriterion("contacttel not in", values, "contacttel");
            return (Criteria) this;
        }

        public Criteria andContacttelBetween(String value1, String value2) {
            addCriterion("contacttel between", value1, value2, "contacttel");
            return (Criteria) this;
        }

        public Criteria andContacttelNotBetween(String value1, String value2) {
            addCriterion("contacttel not between", value1, value2, "contacttel");
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

        public Criteria andOutregcapIsNull() {
            addCriterion("outregcap is null");
            return (Criteria) this;
        }

        public Criteria andOutregcapIsNotNull() {
            addCriterion("outregcap is not null");
            return (Criteria) this;
        }

        public Criteria andOutregcapEqualTo(Integer value) {
            addCriterion("outregcap =", value, "outregcap");
            return (Criteria) this;
        }

        public Criteria andOutregcapNotEqualTo(Integer value) {
            addCriterion("outregcap <>", value, "outregcap");
            return (Criteria) this;
        }

        public Criteria andOutregcapGreaterThan(Integer value) {
            addCriterion("outregcap >", value, "outregcap");
            return (Criteria) this;
        }

        public Criteria andOutregcapGreaterThanOrEqualTo(Integer value) {
            addCriterion("outregcap >=", value, "outregcap");
            return (Criteria) this;
        }

        public Criteria andOutregcapLessThan(Integer value) {
            addCriterion("outregcap <", value, "outregcap");
            return (Criteria) this;
        }

        public Criteria andOutregcapLessThanOrEqualTo(Integer value) {
            addCriterion("outregcap <=", value, "outregcap");
            return (Criteria) this;
        }

        public Criteria andOutregcapIn(List<Integer> values) {
            addCriterion("outregcap in", values, "outregcap");
            return (Criteria) this;
        }

        public Criteria andOutregcapNotIn(List<Integer> values) {
            addCriterion("outregcap not in", values, "outregcap");
            return (Criteria) this;
        }

        public Criteria andOutregcapBetween(Integer value1, Integer value2) {
            addCriterion("outregcap between", value1, value2, "outregcap");
            return (Criteria) this;
        }

        public Criteria andOutregcapNotBetween(Integer value1, Integer value2) {
            addCriterion("outregcap not between", value1, value2, "outregcap");
            return (Criteria) this;
        }

        public Criteria andRegcryIsNull() {
            addCriterion("regcry is null");
            return (Criteria) this;
        }

        public Criteria andRegcryIsNotNull() {
            addCriterion("regcry is not null");
            return (Criteria) this;
        }

        public Criteria andRegcryEqualTo(String value) {
            addCriterion("regcry =", value, "regcry");
            return (Criteria) this;
        }

        public Criteria andRegcryNotEqualTo(String value) {
            addCriterion("regcry <>", value, "regcry");
            return (Criteria) this;
        }

        public Criteria andRegcryGreaterThan(String value) {
            addCriterion("regcry >", value, "regcry");
            return (Criteria) this;
        }

        public Criteria andRegcryGreaterThanOrEqualTo(String value) {
            addCriterion("regcry >=", value, "regcry");
            return (Criteria) this;
        }

        public Criteria andRegcryLessThan(String value) {
            addCriterion("regcry <", value, "regcry");
            return (Criteria) this;
        }

        public Criteria andRegcryLessThanOrEqualTo(String value) {
            addCriterion("regcry <=", value, "regcry");
            return (Criteria) this;
        }

        public Criteria andRegcryLike(String value) {
            addCriterion("regcry like", value, "regcry");
            return (Criteria) this;
        }

        public Criteria andRegcryNotLike(String value) {
            addCriterion("regcry not like", value, "regcry");
            return (Criteria) this;
        }

        public Criteria andRegcryIn(List<String> values) {
            addCriterion("regcry in", values, "regcry");
            return (Criteria) this;
        }

        public Criteria andRegcryNotIn(List<String> values) {
            addCriterion("regcry not in", values, "regcry");
            return (Criteria) this;
        }

        public Criteria andRegcryBetween(String value1, String value2) {
            addCriterion("regcry between", value1, value2, "regcry");
            return (Criteria) this;
        }

        public Criteria andRegcryNotBetween(String value1, String value2) {
            addCriterion("regcry not between", value1, value2, "regcry");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNull() {
            addCriterion("usercode is null");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNotNull() {
            addCriterion("usercode is not null");
            return (Criteria) this;
        }

        public Criteria andUsercodeEqualTo(String value) {
            addCriterion("usercode =", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotEqualTo(String value) {
            addCriterion("usercode <>", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThan(String value) {
            addCriterion("usercode >", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThanOrEqualTo(String value) {
            addCriterion("usercode >=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThan(String value) {
            addCriterion("usercode <", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThanOrEqualTo(String value) {
            addCriterion("usercode <=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLike(String value) {
            addCriterion("usercode like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotLike(String value) {
            addCriterion("usercode not like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeIn(List<String> values) {
            addCriterion("usercode in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotIn(List<String> values) {
            addCriterion("usercode not in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeBetween(String value1, String value2) {
            addCriterion("usercode between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotBetween(String value1, String value2) {
            addCriterion("usercode not between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andRegdateIsNull() {
            addCriterion("regdate is null");
            return (Criteria) this;
        }

        public Criteria andRegdateIsNotNull() {
            addCriterion("regdate is not null");
            return (Criteria) this;
        }

        public Criteria andRegdateEqualTo(String value) {
            addCriterion("regdate =", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotEqualTo(String value) {
            addCriterion("regdate <>", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateGreaterThan(String value) {
            addCriterion("regdate >", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateGreaterThanOrEqualTo(String value) {
            addCriterion("regdate >=", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLessThan(String value) {
            addCriterion("regdate <", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLessThanOrEqualTo(String value) {
            addCriterion("regdate <=", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLike(String value) {
            addCriterion("regdate like", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotLike(String value) {
            addCriterion("regdate not like", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateIn(List<String> values) {
            addCriterion("regdate in", values, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotIn(List<String> values) {
            addCriterion("regdate not in", values, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateBetween(String value1, String value2) {
            addCriterion("regdate between", value1, value2, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotBetween(String value1, String value2) {
            addCriterion("regdate not between", value1, value2, "regdate");
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