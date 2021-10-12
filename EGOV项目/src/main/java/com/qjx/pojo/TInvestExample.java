package com.qjx.pojo;

import java.util.ArrayList;
import java.util.List;

public class TInvestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TInvestExample() {
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

        public Criteria andInvnameIsNull() {
            addCriterion("invname is null");
            return (Criteria) this;
        }

        public Criteria andInvnameIsNotNull() {
            addCriterion("invname is not null");
            return (Criteria) this;
        }

        public Criteria andInvnameEqualTo(String value) {
            addCriterion("invname =", value, "invname");
            return (Criteria) this;
        }

        public Criteria andInvnameNotEqualTo(String value) {
            addCriterion("invname <>", value, "invname");
            return (Criteria) this;
        }

        public Criteria andInvnameGreaterThan(String value) {
            addCriterion("invname >", value, "invname");
            return (Criteria) this;
        }

        public Criteria andInvnameGreaterThanOrEqualTo(String value) {
            addCriterion("invname >=", value, "invname");
            return (Criteria) this;
        }

        public Criteria andInvnameLessThan(String value) {
            addCriterion("invname <", value, "invname");
            return (Criteria) this;
        }

        public Criteria andInvnameLessThanOrEqualTo(String value) {
            addCriterion("invname <=", value, "invname");
            return (Criteria) this;
        }

        public Criteria andInvnameLike(String value) {
            addCriterion("invname like", value, "invname");
            return (Criteria) this;
        }

        public Criteria andInvnameNotLike(String value) {
            addCriterion("invname not like", value, "invname");
            return (Criteria) this;
        }

        public Criteria andInvnameIn(List<String> values) {
            addCriterion("invname in", values, "invname");
            return (Criteria) this;
        }

        public Criteria andInvnameNotIn(List<String> values) {
            addCriterion("invname not in", values, "invname");
            return (Criteria) this;
        }

        public Criteria andInvnameBetween(String value1, String value2) {
            addCriterion("invname between", value1, value2, "invname");
            return (Criteria) this;
        }

        public Criteria andInvnameNotBetween(String value1, String value2) {
            addCriterion("invname not between", value1, value2, "invname");
            return (Criteria) this;
        }

        public Criteria andCtyIsNull() {
            addCriterion("cty is null");
            return (Criteria) this;
        }

        public Criteria andCtyIsNotNull() {
            addCriterion("cty is not null");
            return (Criteria) this;
        }

        public Criteria andCtyEqualTo(String value) {
            addCriterion("cty =", value, "cty");
            return (Criteria) this;
        }

        public Criteria andCtyNotEqualTo(String value) {
            addCriterion("cty <>", value, "cty");
            return (Criteria) this;
        }

        public Criteria andCtyGreaterThan(String value) {
            addCriterion("cty >", value, "cty");
            return (Criteria) this;
        }

        public Criteria andCtyGreaterThanOrEqualTo(String value) {
            addCriterion("cty >=", value, "cty");
            return (Criteria) this;
        }

        public Criteria andCtyLessThan(String value) {
            addCriterion("cty <", value, "cty");
            return (Criteria) this;
        }

        public Criteria andCtyLessThanOrEqualTo(String value) {
            addCriterion("cty <=", value, "cty");
            return (Criteria) this;
        }

        public Criteria andCtyLike(String value) {
            addCriterion("cty like", value, "cty");
            return (Criteria) this;
        }

        public Criteria andCtyNotLike(String value) {
            addCriterion("cty not like", value, "cty");
            return (Criteria) this;
        }

        public Criteria andCtyIn(List<String> values) {
            addCriterion("cty in", values, "cty");
            return (Criteria) this;
        }

        public Criteria andCtyNotIn(List<String> values) {
            addCriterion("cty not in", values, "cty");
            return (Criteria) this;
        }

        public Criteria andCtyBetween(String value1, String value2) {
            addCriterion("cty between", value1, value2, "cty");
            return (Criteria) this;
        }

        public Criteria andCtyNotBetween(String value1, String value2) {
            addCriterion("cty not between", value1, value2, "cty");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNull() {
            addCriterion("orgcode is null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNotNull() {
            addCriterion("orgcode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeEqualTo(String value) {
            addCriterion("orgcode =", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotEqualTo(String value) {
            addCriterion("orgcode <>", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThan(String value) {
            addCriterion("orgcode >", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("orgcode >=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThan(String value) {
            addCriterion("orgcode <", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThanOrEqualTo(String value) {
            addCriterion("orgcode <=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLike(String value) {
            addCriterion("orgcode like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotLike(String value) {
            addCriterion("orgcode not like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIn(List<String> values) {
            addCriterion("orgcode in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotIn(List<String> values) {
            addCriterion("orgcode not in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeBetween(String value1, String value2) {
            addCriterion("orgcode between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotBetween(String value1, String value2) {
            addCriterion("orgcode not between", value1, value2, "orgcode");
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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