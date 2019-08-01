package com.rcs.nchumanity.entity.model;

import java.util.ArrayList;
import java.util.List;

public class CprExamRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CprExamRuleExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuIsNull() {
            addCriterion("flowYiwu is null");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuIsNotNull() {
            addCriterion("flowYiwu is not null");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuEqualTo(Integer value) {
            addCriterion("flowYiwu =", value, "flowyiwu");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuNotEqualTo(Integer value) {
            addCriterion("flowYiwu <>", value, "flowyiwu");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuGreaterThan(Integer value) {
            addCriterion("flowYiwu >", value, "flowyiwu");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuGreaterThanOrEqualTo(Integer value) {
            addCriterion("flowYiwu >=", value, "flowyiwu");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuLessThan(Integer value) {
            addCriterion("flowYiwu <", value, "flowyiwu");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuLessThanOrEqualTo(Integer value) {
            addCriterion("flowYiwu <=", value, "flowyiwu");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuIn(List<Integer> values) {
            addCriterion("flowYiwu in", values, "flowyiwu");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuNotIn(List<Integer> values) {
            addCriterion("flowYiwu not in", values, "flowyiwu");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuBetween(Integer value1, Integer value2) {
            addCriterion("flowYiwu between", value1, value2, "flowyiwu");
            return (Criteria) this;
        }

        public Criteria andFlowyiwuNotBetween(Integer value1, Integer value2) {
            addCriterion("flowYiwu not between", value1, value2, "flowyiwu");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboIsNull() {
            addCriterion("flowMaibo is null");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboIsNotNull() {
            addCriterion("flowMaibo is not null");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboEqualTo(Integer value) {
            addCriterion("flowMaibo =", value, "flowmaibo");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboNotEqualTo(Integer value) {
            addCriterion("flowMaibo <>", value, "flowmaibo");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboGreaterThan(Integer value) {
            addCriterion("flowMaibo >", value, "flowmaibo");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboGreaterThanOrEqualTo(Integer value) {
            addCriterion("flowMaibo >=", value, "flowmaibo");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboLessThan(Integer value) {
            addCriterion("flowMaibo <", value, "flowmaibo");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboLessThanOrEqualTo(Integer value) {
            addCriterion("flowMaibo <=", value, "flowmaibo");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboIn(List<Integer> values) {
            addCriterion("flowMaibo in", values, "flowmaibo");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboNotIn(List<Integer> values) {
            addCriterion("flowMaibo not in", values, "flowmaibo");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboBetween(Integer value1, Integer value2) {
            addCriterion("flowMaibo between", value1, value2, "flowmaibo");
            return (Criteria) this;
        }

        public Criteria andFlowmaiboNotBetween(Integer value1, Integer value2) {
            addCriterion("flowMaibo not between", value1, value2, "flowmaibo");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoIsNull() {
            addCriterion("flowHujiao is null");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoIsNotNull() {
            addCriterion("flowHujiao is not null");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoEqualTo(Integer value) {
            addCriterion("flowHujiao =", value, "flowhujiao");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoNotEqualTo(Integer value) {
            addCriterion("flowHujiao <>", value, "flowhujiao");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoGreaterThan(Integer value) {
            addCriterion("flowHujiao >", value, "flowhujiao");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoGreaterThanOrEqualTo(Integer value) {
            addCriterion("flowHujiao >=", value, "flowhujiao");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoLessThan(Integer value) {
            addCriterion("flowHujiao <", value, "flowhujiao");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoLessThanOrEqualTo(Integer value) {
            addCriterion("flowHujiao <=", value, "flowhujiao");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoIn(List<Integer> values) {
            addCriterion("flowHujiao in", values, "flowhujiao");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoNotIn(List<Integer> values) {
            addCriterion("flowHujiao not in", values, "flowhujiao");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoBetween(Integer value1, Integer value2) {
            addCriterion("flowHujiao between", value1, value2, "flowhujiao");
            return (Criteria) this;
        }

        public Criteria andFlowhujiaoNotBetween(Integer value1, Integer value2) {
            addCriterion("flowHujiao not between", value1, value2, "flowhujiao");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiIsNull() {
            addCriterion("flowHuxi is null");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiIsNotNull() {
            addCriterion("flowHuxi is not null");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiEqualTo(Integer value) {
            addCriterion("flowHuxi =", value, "flowhuxi");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiNotEqualTo(Integer value) {
            addCriterion("flowHuxi <>", value, "flowhuxi");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiGreaterThan(Integer value) {
            addCriterion("flowHuxi >", value, "flowhuxi");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiGreaterThanOrEqualTo(Integer value) {
            addCriterion("flowHuxi >=", value, "flowhuxi");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiLessThan(Integer value) {
            addCriterion("flowHuxi <", value, "flowhuxi");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiLessThanOrEqualTo(Integer value) {
            addCriterion("flowHuxi <=", value, "flowhuxi");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiIn(List<Integer> values) {
            addCriterion("flowHuxi in", values, "flowhuxi");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiNotIn(List<Integer> values) {
            addCriterion("flowHuxi not in", values, "flowhuxi");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiBetween(Integer value1, Integer value2) {
            addCriterion("flowHuxi between", value1, value2, "flowhuxi");
            return (Criteria) this;
        }

        public Criteria andFlowhuxiNotBetween(Integer value1, Integer value2) {
            addCriterion("flowHuxi not between", value1, value2, "flowhuxi");
            return (Criteria) this;
        }

        public Criteria andFlowyishiIsNull() {
            addCriterion("flowYishi is null");
            return (Criteria) this;
        }

        public Criteria andFlowyishiIsNotNull() {
            addCriterion("flowYishi is not null");
            return (Criteria) this;
        }

        public Criteria andFlowyishiEqualTo(Integer value) {
            addCriterion("flowYishi =", value, "flowyishi");
            return (Criteria) this;
        }

        public Criteria andFlowyishiNotEqualTo(Integer value) {
            addCriterion("flowYishi <>", value, "flowyishi");
            return (Criteria) this;
        }

        public Criteria andFlowyishiGreaterThan(Integer value) {
            addCriterion("flowYishi >", value, "flowyishi");
            return (Criteria) this;
        }

        public Criteria andFlowyishiGreaterThanOrEqualTo(Integer value) {
            addCriterion("flowYishi >=", value, "flowyishi");
            return (Criteria) this;
        }

        public Criteria andFlowyishiLessThan(Integer value) {
            addCriterion("flowYishi <", value, "flowyishi");
            return (Criteria) this;
        }

        public Criteria andFlowyishiLessThanOrEqualTo(Integer value) {
            addCriterion("flowYishi <=", value, "flowyishi");
            return (Criteria) this;
        }

        public Criteria andFlowyishiIn(List<Integer> values) {
            addCriterion("flowYishi in", values, "flowyishi");
            return (Criteria) this;
        }

        public Criteria andFlowyishiNotIn(List<Integer> values) {
            addCriterion("flowYishi not in", values, "flowyishi");
            return (Criteria) this;
        }

        public Criteria andFlowyishiBetween(Integer value1, Integer value2) {
            addCriterion("flowYishi between", value1, value2, "flowyishi");
            return (Criteria) this;
        }

        public Criteria andFlowyishiNotBetween(Integer value1, Integer value2) {
            addCriterion("flowYishi not between", value1, value2, "flowyishi");
            return (Criteria) this;
        }

        public Criteria andFlowcprIsNull() {
            addCriterion("flowCPR is null");
            return (Criteria) this;
        }

        public Criteria andFlowcprIsNotNull() {
            addCriterion("flowCPR is not null");
            return (Criteria) this;
        }

        public Criteria andFlowcprEqualTo(Integer value) {
            addCriterion("flowCPR =", value, "flowcpr");
            return (Criteria) this;
        }

        public Criteria andFlowcprNotEqualTo(Integer value) {
            addCriterion("flowCPR <>", value, "flowcpr");
            return (Criteria) this;
        }

        public Criteria andFlowcprGreaterThan(Integer value) {
            addCriterion("flowCPR >", value, "flowcpr");
            return (Criteria) this;
        }

        public Criteria andFlowcprGreaterThanOrEqualTo(Integer value) {
            addCriterion("flowCPR >=", value, "flowcpr");
            return (Criteria) this;
        }

        public Criteria andFlowcprLessThan(Integer value) {
            addCriterion("flowCPR <", value, "flowcpr");
            return (Criteria) this;
        }

        public Criteria andFlowcprLessThanOrEqualTo(Integer value) {
            addCriterion("flowCPR <=", value, "flowcpr");
            return (Criteria) this;
        }

        public Criteria andFlowcprIn(List<Integer> values) {
            addCriterion("flowCPR in", values, "flowcpr");
            return (Criteria) this;
        }

        public Criteria andFlowcprNotIn(List<Integer> values) {
            addCriterion("flowCPR not in", values, "flowcpr");
            return (Criteria) this;
        }

        public Criteria andFlowcprBetween(Integer value1, Integer value2) {
            addCriterion("flowCPR between", value1, value2, "flowcpr");
            return (Criteria) this;
        }

        public Criteria andFlowcprNotBetween(Integer value1, Integer value2) {
            addCriterion("flowCPR not between", value1, value2, "flowcpr");
            return (Criteria) this;
        }

        public Criteria andAnyacishuIsNull() {
            addCriterion("anyacishu is null");
            return (Criteria) this;
        }

        public Criteria andAnyacishuIsNotNull() {
            addCriterion("anyacishu is not null");
            return (Criteria) this;
        }

        public Criteria andAnyacishuEqualTo(Integer value) {
            addCriterion("anyacishu =", value, "anyacishu");
            return (Criteria) this;
        }

        public Criteria andAnyacishuNotEqualTo(Integer value) {
            addCriterion("anyacishu <>", value, "anyacishu");
            return (Criteria) this;
        }

        public Criteria andAnyacishuGreaterThan(Integer value) {
            addCriterion("anyacishu >", value, "anyacishu");
            return (Criteria) this;
        }

        public Criteria andAnyacishuGreaterThanOrEqualTo(Integer value) {
            addCriterion("anyacishu >=", value, "anyacishu");
            return (Criteria) this;
        }

        public Criteria andAnyacishuLessThan(Integer value) {
            addCriterion("anyacishu <", value, "anyacishu");
            return (Criteria) this;
        }

        public Criteria andAnyacishuLessThanOrEqualTo(Integer value) {
            addCriterion("anyacishu <=", value, "anyacishu");
            return (Criteria) this;
        }

        public Criteria andAnyacishuIn(List<Integer> values) {
            addCriterion("anyacishu in", values, "anyacishu");
            return (Criteria) this;
        }

        public Criteria andAnyacishuNotIn(List<Integer> values) {
            addCriterion("anyacishu not in", values, "anyacishu");
            return (Criteria) this;
        }

        public Criteria andAnyacishuBetween(Integer value1, Integer value2) {
            addCriterion("anyacishu between", value1, value2, "anyacishu");
            return (Criteria) this;
        }

        public Criteria andAnyacishuNotBetween(Integer value1, Integer value2) {
            addCriterion("anyacishu not between", value1, value2, "anyacishu");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuIsNull() {
            addCriterion("chuiqicishu is null");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuIsNotNull() {
            addCriterion("chuiqicishu is not null");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuEqualTo(Integer value) {
            addCriterion("chuiqicishu =", value, "chuiqicishu");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuNotEqualTo(Integer value) {
            addCriterion("chuiqicishu <>", value, "chuiqicishu");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuGreaterThan(Integer value) {
            addCriterion("chuiqicishu >", value, "chuiqicishu");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuGreaterThanOrEqualTo(Integer value) {
            addCriterion("chuiqicishu >=", value, "chuiqicishu");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuLessThan(Integer value) {
            addCriterion("chuiqicishu <", value, "chuiqicishu");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuLessThanOrEqualTo(Integer value) {
            addCriterion("chuiqicishu <=", value, "chuiqicishu");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuIn(List<Integer> values) {
            addCriterion("chuiqicishu in", values, "chuiqicishu");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuNotIn(List<Integer> values) {
            addCriterion("chuiqicishu not in", values, "chuiqicishu");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuBetween(Integer value1, Integer value2) {
            addCriterion("chuiqicishu between", value1, value2, "chuiqicishu");
            return (Criteria) this;
        }

        public Criteria andChuiqicishuNotBetween(Integer value1, Integer value2) {
            addCriterion("chuiqicishu not between", value1, value2, "chuiqicishu");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvIsNull() {
            addCriterion("anyahegelv is null");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvIsNotNull() {
            addCriterion("anyahegelv is not null");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvEqualTo(Integer value) {
            addCriterion("anyahegelv =", value, "anyahegelv");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvNotEqualTo(Integer value) {
            addCriterion("anyahegelv <>", value, "anyahegelv");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvGreaterThan(Integer value) {
            addCriterion("anyahegelv >", value, "anyahegelv");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvGreaterThanOrEqualTo(Integer value) {
            addCriterion("anyahegelv >=", value, "anyahegelv");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvLessThan(Integer value) {
            addCriterion("anyahegelv <", value, "anyahegelv");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvLessThanOrEqualTo(Integer value) {
            addCriterion("anyahegelv <=", value, "anyahegelv");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvIn(List<Integer> values) {
            addCriterion("anyahegelv in", values, "anyahegelv");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvNotIn(List<Integer> values) {
            addCriterion("anyahegelv not in", values, "anyahegelv");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvBetween(Integer value1, Integer value2) {
            addCriterion("anyahegelv between", value1, value2, "anyahegelv");
            return (Criteria) this;
        }

        public Criteria andAnyahegelvNotBetween(Integer value1, Integer value2) {
            addCriterion("anyahegelv not between", value1, value2, "anyahegelv");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxIsNull() {
            addCriterion("anyapinlvMax is null");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxIsNotNull() {
            addCriterion("anyapinlvMax is not null");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxEqualTo(Integer value) {
            addCriterion("anyapinlvMax =", value, "anyapinlvmax");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxNotEqualTo(Integer value) {
            addCriterion("anyapinlvMax <>", value, "anyapinlvmax");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxGreaterThan(Integer value) {
            addCriterion("anyapinlvMax >", value, "anyapinlvmax");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("anyapinlvMax >=", value, "anyapinlvmax");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxLessThan(Integer value) {
            addCriterion("anyapinlvMax <", value, "anyapinlvmax");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxLessThanOrEqualTo(Integer value) {
            addCriterion("anyapinlvMax <=", value, "anyapinlvmax");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxIn(List<Integer> values) {
            addCriterion("anyapinlvMax in", values, "anyapinlvmax");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxNotIn(List<Integer> values) {
            addCriterion("anyapinlvMax not in", values, "anyapinlvmax");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxBetween(Integer value1, Integer value2) {
            addCriterion("anyapinlvMax between", value1, value2, "anyapinlvmax");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvmaxNotBetween(Integer value1, Integer value2) {
            addCriterion("anyapinlvMax not between", value1, value2, "anyapinlvmax");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminIsNull() {
            addCriterion("anyapinlvMin is null");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminIsNotNull() {
            addCriterion("anyapinlvMin is not null");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminEqualTo(Integer value) {
            addCriterion("anyapinlvMin =", value, "anyapinlvmin");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminNotEqualTo(Integer value) {
            addCriterion("anyapinlvMin <>", value, "anyapinlvmin");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminGreaterThan(Integer value) {
            addCriterion("anyapinlvMin >", value, "anyapinlvmin");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminGreaterThanOrEqualTo(Integer value) {
            addCriterion("anyapinlvMin >=", value, "anyapinlvmin");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminLessThan(Integer value) {
            addCriterion("anyapinlvMin <", value, "anyapinlvmin");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminLessThanOrEqualTo(Integer value) {
            addCriterion("anyapinlvMin <=", value, "anyapinlvmin");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminIn(List<Integer> values) {
            addCriterion("anyapinlvMin in", values, "anyapinlvmin");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminNotIn(List<Integer> values) {
            addCriterion("anyapinlvMin not in", values, "anyapinlvmin");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminBetween(Integer value1, Integer value2) {
            addCriterion("anyapinlvMin between", value1, value2, "anyapinlvmin");
            return (Criteria) this;
        }

        public Criteria andAnyapinlvminNotBetween(Integer value1, Integer value2) {
            addCriterion("anyapinlvMin not between", value1, value2, "anyapinlvmin");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxIsNull() {
            addCriterion("anyashenduMax is null");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxIsNotNull() {
            addCriterion("anyashenduMax is not null");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxEqualTo(Integer value) {
            addCriterion("anyashenduMax =", value, "anyashendumax");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxNotEqualTo(Integer value) {
            addCriterion("anyashenduMax <>", value, "anyashendumax");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxGreaterThan(Integer value) {
            addCriterion("anyashenduMax >", value, "anyashendumax");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("anyashenduMax >=", value, "anyashendumax");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxLessThan(Integer value) {
            addCriterion("anyashenduMax <", value, "anyashendumax");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxLessThanOrEqualTo(Integer value) {
            addCriterion("anyashenduMax <=", value, "anyashendumax");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxIn(List<Integer> values) {
            addCriterion("anyashenduMax in", values, "anyashendumax");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxNotIn(List<Integer> values) {
            addCriterion("anyashenduMax not in", values, "anyashendumax");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxBetween(Integer value1, Integer value2) {
            addCriterion("anyashenduMax between", value1, value2, "anyashendumax");
            return (Criteria) this;
        }

        public Criteria andAnyashendumaxNotBetween(Integer value1, Integer value2) {
            addCriterion("anyashenduMax not between", value1, value2, "anyashendumax");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminIsNull() {
            addCriterion("anyashenduMin is null");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminIsNotNull() {
            addCriterion("anyashenduMin is not null");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminEqualTo(Integer value) {
            addCriterion("anyashenduMin =", value, "anyashendumin");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminNotEqualTo(Integer value) {
            addCriterion("anyashenduMin <>", value, "anyashendumin");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminGreaterThan(Integer value) {
            addCriterion("anyashenduMin >", value, "anyashendumin");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminGreaterThanOrEqualTo(Integer value) {
            addCriterion("anyashenduMin >=", value, "anyashendumin");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminLessThan(Integer value) {
            addCriterion("anyashenduMin <", value, "anyashendumin");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminLessThanOrEqualTo(Integer value) {
            addCriterion("anyashenduMin <=", value, "anyashendumin");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminIn(List<Integer> values) {
            addCriterion("anyashenduMin in", values, "anyashendumin");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminNotIn(List<Integer> values) {
            addCriterion("anyashenduMin not in", values, "anyashendumin");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminBetween(Integer value1, Integer value2) {
            addCriterion("anyashenduMin between", value1, value2, "anyashendumin");
            return (Criteria) this;
        }

        public Criteria andAnyashenduminNotBetween(Integer value1, Integer value2) {
            addCriterion("anyashenduMin not between", value1, value2, "anyashendumin");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvIsNull() {
            addCriterion("chuiqihegelv is null");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvIsNotNull() {
            addCriterion("chuiqihegelv is not null");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvEqualTo(Integer value) {
            addCriterion("chuiqihegelv =", value, "chuiqihegelv");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvNotEqualTo(Integer value) {
            addCriterion("chuiqihegelv <>", value, "chuiqihegelv");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvGreaterThan(Integer value) {
            addCriterion("chuiqihegelv >", value, "chuiqihegelv");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvGreaterThanOrEqualTo(Integer value) {
            addCriterion("chuiqihegelv >=", value, "chuiqihegelv");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvLessThan(Integer value) {
            addCriterion("chuiqihegelv <", value, "chuiqihegelv");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvLessThanOrEqualTo(Integer value) {
            addCriterion("chuiqihegelv <=", value, "chuiqihegelv");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvIn(List<Integer> values) {
            addCriterion("chuiqihegelv in", values, "chuiqihegelv");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvNotIn(List<Integer> values) {
            addCriterion("chuiqihegelv not in", values, "chuiqihegelv");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvBetween(Integer value1, Integer value2) {
            addCriterion("chuiqihegelv between", value1, value2, "chuiqihegelv");
            return (Criteria) this;
        }

        public Criteria andChuiqihegelvNotBetween(Integer value1, Integer value2) {
            addCriterion("chuiqihegelv not between", value1, value2, "chuiqihegelv");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxIsNull() {
            addCriterion("chuiqiliangMax is null");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxIsNotNull() {
            addCriterion("chuiqiliangMax is not null");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxEqualTo(Integer value) {
            addCriterion("chuiqiliangMax =", value, "chuiqiliangmax");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxNotEqualTo(Integer value) {
            addCriterion("chuiqiliangMax <>", value, "chuiqiliangmax");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxGreaterThan(Integer value) {
            addCriterion("chuiqiliangMax >", value, "chuiqiliangmax");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("chuiqiliangMax >=", value, "chuiqiliangmax");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxLessThan(Integer value) {
            addCriterion("chuiqiliangMax <", value, "chuiqiliangmax");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxLessThanOrEqualTo(Integer value) {
            addCriterion("chuiqiliangMax <=", value, "chuiqiliangmax");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxIn(List<Integer> values) {
            addCriterion("chuiqiliangMax in", values, "chuiqiliangmax");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxNotIn(List<Integer> values) {
            addCriterion("chuiqiliangMax not in", values, "chuiqiliangmax");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxBetween(Integer value1, Integer value2) {
            addCriterion("chuiqiliangMax between", value1, value2, "chuiqiliangmax");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangmaxNotBetween(Integer value1, Integer value2) {
            addCriterion("chuiqiliangMax not between", value1, value2, "chuiqiliangmax");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminIsNull() {
            addCriterion("chuiqiliangMin is null");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminIsNotNull() {
            addCriterion("chuiqiliangMin is not null");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminEqualTo(Integer value) {
            addCriterion("chuiqiliangMin =", value, "chuiqiliangmin");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminNotEqualTo(Integer value) {
            addCriterion("chuiqiliangMin <>", value, "chuiqiliangmin");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminGreaterThan(Integer value) {
            addCriterion("chuiqiliangMin >", value, "chuiqiliangmin");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminGreaterThanOrEqualTo(Integer value) {
            addCriterion("chuiqiliangMin >=", value, "chuiqiliangmin");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminLessThan(Integer value) {
            addCriterion("chuiqiliangMin <", value, "chuiqiliangmin");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminLessThanOrEqualTo(Integer value) {
            addCriterion("chuiqiliangMin <=", value, "chuiqiliangmin");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminIn(List<Integer> values) {
            addCriterion("chuiqiliangMin in", values, "chuiqiliangmin");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminNotIn(List<Integer> values) {
            addCriterion("chuiqiliangMin not in", values, "chuiqiliangmin");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminBetween(Integer value1, Integer value2) {
            addCriterion("chuiqiliangMin between", value1, value2, "chuiqiliangmin");
            return (Criteria) this;
        }

        public Criteria andChuiqiliangminNotBetween(Integer value1, Integer value2) {
            addCriterion("chuiqiliangMin not between", value1, value2, "chuiqiliangmin");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Integer value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Integer value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Integer value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Integer value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Integer value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Integer> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Integer> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Integer value1, Integer value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuIsNull() {
            addCriterion("xunhuancishu is null");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuIsNotNull() {
            addCriterion("xunhuancishu is not null");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuEqualTo(Integer value) {
            addCriterion("xunhuancishu =", value, "xunhuancishu");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuNotEqualTo(Integer value) {
            addCriterion("xunhuancishu <>", value, "xunhuancishu");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuGreaterThan(Integer value) {
            addCriterion("xunhuancishu >", value, "xunhuancishu");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuGreaterThanOrEqualTo(Integer value) {
            addCriterion("xunhuancishu >=", value, "xunhuancishu");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuLessThan(Integer value) {
            addCriterion("xunhuancishu <", value, "xunhuancishu");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuLessThanOrEqualTo(Integer value) {
            addCriterion("xunhuancishu <=", value, "xunhuancishu");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuIn(List<Integer> values) {
            addCriterion("xunhuancishu in", values, "xunhuancishu");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuNotIn(List<Integer> values) {
            addCriterion("xunhuancishu not in", values, "xunhuancishu");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuBetween(Integer value1, Integer value2) {
            addCriterion("xunhuancishu between", value1, value2, "xunhuancishu");
            return (Criteria) this;
        }

        public Criteria andXunhuancishuNotBetween(Integer value1, Integer value2) {
            addCriterion("xunhuancishu not between", value1, value2, "xunhuancishu");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuIsNull() {
            addCriterion("anchuishunxu is null");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuIsNotNull() {
            addCriterion("anchuishunxu is not null");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuEqualTo(Integer value) {
            addCriterion("anchuishunxu =", value, "anchuishunxu");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuNotEqualTo(Integer value) {
            addCriterion("anchuishunxu <>", value, "anchuishunxu");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuGreaterThan(Integer value) {
            addCriterion("anchuishunxu >", value, "anchuishunxu");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuGreaterThanOrEqualTo(Integer value) {
            addCriterion("anchuishunxu >=", value, "anchuishunxu");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuLessThan(Integer value) {
            addCriterion("anchuishunxu <", value, "anchuishunxu");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuLessThanOrEqualTo(Integer value) {
            addCriterion("anchuishunxu <=", value, "anchuishunxu");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuIn(List<Integer> values) {
            addCriterion("anchuishunxu in", values, "anchuishunxu");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuNotIn(List<Integer> values) {
            addCriterion("anchuishunxu not in", values, "anchuishunxu");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuBetween(Integer value1, Integer value2) {
            addCriterion("anchuishunxu between", value1, value2, "anchuishunxu");
            return (Criteria) this;
        }

        public Criteria andAnchuishunxuNotBetween(Integer value1, Integer value2) {
            addCriterion("anchuishunxu not between", value1, value2, "anchuishunxu");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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