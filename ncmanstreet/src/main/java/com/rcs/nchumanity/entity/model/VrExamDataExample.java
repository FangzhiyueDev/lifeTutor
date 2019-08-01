package com.rcs.nchumanity.entity.model;

import java.util.ArrayList;
import java.util.List;

public class VrExamDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VrExamDataExample() {
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

        public Criteria andStuNameIsNull() {
            addCriterion("stu_name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_name not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuClassIsNull() {
            addCriterion("stu_class is null");
            return (Criteria) this;
        }

        public Criteria andStuClassIsNotNull() {
            addCriterion("stu_class is not null");
            return (Criteria) this;
        }

        public Criteria andStuClassEqualTo(String value) {
            addCriterion("stu_class =", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotEqualTo(String value) {
            addCriterion("stu_class <>", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassGreaterThan(String value) {
            addCriterion("stu_class >", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassGreaterThanOrEqualTo(String value) {
            addCriterion("stu_class >=", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassLessThan(String value) {
            addCriterion("stu_class <", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassLessThanOrEqualTo(String value) {
            addCriterion("stu_class <=", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassLike(String value) {
            addCriterion("stu_class like", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotLike(String value) {
            addCriterion("stu_class not like", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassIn(List<String> values) {
            addCriterion("stu_class in", values, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotIn(List<String> values) {
            addCriterion("stu_class not in", values, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassBetween(String value1, String value2) {
            addCriterion("stu_class between", value1, value2, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotBetween(String value1, String value2) {
            addCriterion("stu_class not between", value1, value2, "stuClass");
            return (Criteria) this;
        }

        public Criteria andExamDateIsNull() {
            addCriterion("exam_date is null");
            return (Criteria) this;
        }

        public Criteria andExamDateIsNotNull() {
            addCriterion("exam_date is not null");
            return (Criteria) this;
        }

        public Criteria andExamDateEqualTo(String value) {
            addCriterion("exam_date =", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateNotEqualTo(String value) {
            addCriterion("exam_date <>", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateGreaterThan(String value) {
            addCriterion("exam_date >", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateGreaterThanOrEqualTo(String value) {
            addCriterion("exam_date >=", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateLessThan(String value) {
            addCriterion("exam_date <", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateLessThanOrEqualTo(String value) {
            addCriterion("exam_date <=", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateLike(String value) {
            addCriterion("exam_date like", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateNotLike(String value) {
            addCriterion("exam_date not like", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateIn(List<String> values) {
            addCriterion("exam_date in", values, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateNotIn(List<String> values) {
            addCriterion("exam_date not in", values, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateBetween(String value1, String value2) {
            addCriterion("exam_date between", value1, value2, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateNotBetween(String value1, String value2) {
            addCriterion("exam_date not between", value1, value2, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateLongIsNull() {
            addCriterion("exam_date_long is null");
            return (Criteria) this;
        }

        public Criteria andExamDateLongIsNotNull() {
            addCriterion("exam_date_long is not null");
            return (Criteria) this;
        }

        public Criteria andExamDateLongEqualTo(Long value) {
            addCriterion("exam_date_long =", value, "examDateLong");
            return (Criteria) this;
        }

        public Criteria andExamDateLongNotEqualTo(Long value) {
            addCriterion("exam_date_long <>", value, "examDateLong");
            return (Criteria) this;
        }

        public Criteria andExamDateLongGreaterThan(Long value) {
            addCriterion("exam_date_long >", value, "examDateLong");
            return (Criteria) this;
        }

        public Criteria andExamDateLongGreaterThanOrEqualTo(Long value) {
            addCriterion("exam_date_long >=", value, "examDateLong");
            return (Criteria) this;
        }

        public Criteria andExamDateLongLessThan(Long value) {
            addCriterion("exam_date_long <", value, "examDateLong");
            return (Criteria) this;
        }

        public Criteria andExamDateLongLessThanOrEqualTo(Long value) {
            addCriterion("exam_date_long <=", value, "examDateLong");
            return (Criteria) this;
        }

        public Criteria andExamDateLongIn(List<Long> values) {
            addCriterion("exam_date_long in", values, "examDateLong");
            return (Criteria) this;
        }

        public Criteria andExamDateLongNotIn(List<Long> values) {
            addCriterion("exam_date_long not in", values, "examDateLong");
            return (Criteria) this;
        }

        public Criteria andExamDateLongBetween(Long value1, Long value2) {
            addCriterion("exam_date_long between", value1, value2, "examDateLong");
            return (Criteria) this;
        }

        public Criteria andExamDateLongNotBetween(Long value1, Long value2) {
            addCriterion("exam_date_long not between", value1, value2, "examDateLong");
            return (Criteria) this;
        }

        public Criteria andExamTypeIsNull() {
            addCriterion("exam_type is null");
            return (Criteria) this;
        }

        public Criteria andExamTypeIsNotNull() {
            addCriterion("exam_type is not null");
            return (Criteria) this;
        }

        public Criteria andExamTypeEqualTo(String value) {
            addCriterion("exam_type =", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotEqualTo(String value) {
            addCriterion("exam_type <>", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThan(String value) {
            addCriterion("exam_type >", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("exam_type >=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThan(String value) {
            addCriterion("exam_type <", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThanOrEqualTo(String value) {
            addCriterion("exam_type <=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLike(String value) {
            addCriterion("exam_type like", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotLike(String value) {
            addCriterion("exam_type not like", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeIn(List<String> values) {
            addCriterion("exam_type in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotIn(List<String> values) {
            addCriterion("exam_type not in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeBetween(String value1, String value2) {
            addCriterion("exam_type between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotBetween(String value1, String value2) {
            addCriterion("exam_type not between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andIsuploadIsNull() {
            addCriterion("isUpload is null");
            return (Criteria) this;
        }

        public Criteria andIsuploadIsNotNull() {
            addCriterion("isUpload is not null");
            return (Criteria) this;
        }

        public Criteria andIsuploadEqualTo(Boolean value) {
            addCriterion("isUpload =", value, "isupload");
            return (Criteria) this;
        }

        public Criteria andIsuploadNotEqualTo(Boolean value) {
            addCriterion("isUpload <>", value, "isupload");
            return (Criteria) this;
        }

        public Criteria andIsuploadGreaterThan(Boolean value) {
            addCriterion("isUpload >", value, "isupload");
            return (Criteria) this;
        }

        public Criteria andIsuploadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isUpload >=", value, "isupload");
            return (Criteria) this;
        }

        public Criteria andIsuploadLessThan(Boolean value) {
            addCriterion("isUpload <", value, "isupload");
            return (Criteria) this;
        }

        public Criteria andIsuploadLessThanOrEqualTo(Boolean value) {
            addCriterion("isUpload <=", value, "isupload");
            return (Criteria) this;
        }

        public Criteria andIsuploadIn(List<Boolean> values) {
            addCriterion("isUpload in", values, "isupload");
            return (Criteria) this;
        }

        public Criteria andIsuploadNotIn(List<Boolean> values) {
            addCriterion("isUpload not in", values, "isupload");
            return (Criteria) this;
        }

        public Criteria andIsuploadBetween(Boolean value1, Boolean value2) {
            addCriterion("isUpload between", value1, value2, "isupload");
            return (Criteria) this;
        }

        public Criteria andIsuploadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isUpload not between", value1, value2, "isupload");
            return (Criteria) this;
        }

        public Criteria andPicpathsIsNull() {
            addCriterion("picPaths is null");
            return (Criteria) this;
        }

        public Criteria andPicpathsIsNotNull() {
            addCriterion("picPaths is not null");
            return (Criteria) this;
        }

        public Criteria andPicpathsEqualTo(String value) {
            addCriterion("picPaths =", value, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPicpathsNotEqualTo(String value) {
            addCriterion("picPaths <>", value, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPicpathsGreaterThan(String value) {
            addCriterion("picPaths >", value, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPicpathsGreaterThanOrEqualTo(String value) {
            addCriterion("picPaths >=", value, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPicpathsLessThan(String value) {
            addCriterion("picPaths <", value, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPicpathsLessThanOrEqualTo(String value) {
            addCriterion("picPaths <=", value, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPicpathsLike(String value) {
            addCriterion("picPaths like", value, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPicpathsNotLike(String value) {
            addCriterion("picPaths not like", value, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPicpathsIn(List<String> values) {
            addCriterion("picPaths in", values, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPicpathsNotIn(List<String> values) {
            addCriterion("picPaths not in", values, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPicpathsBetween(String value1, String value2) {
            addCriterion("picPaths between", value1, value2, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPicpathsNotBetween(String value1, String value2) {
            addCriterion("picPaths not between", value1, value2, "picpaths");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPath2IsNull() {
            addCriterion("path2 is null");
            return (Criteria) this;
        }

        public Criteria andPath2IsNotNull() {
            addCriterion("path2 is not null");
            return (Criteria) this;
        }

        public Criteria andPath2EqualTo(String value) {
            addCriterion("path2 =", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotEqualTo(String value) {
            addCriterion("path2 <>", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2GreaterThan(String value) {
            addCriterion("path2 >", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2GreaterThanOrEqualTo(String value) {
            addCriterion("path2 >=", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2LessThan(String value) {
            addCriterion("path2 <", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2LessThanOrEqualTo(String value) {
            addCriterion("path2 <=", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2Like(String value) {
            addCriterion("path2 like", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotLike(String value) {
            addCriterion("path2 not like", value, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2In(List<String> values) {
            addCriterion("path2 in", values, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotIn(List<String> values) {
            addCriterion("path2 not in", values, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2Between(String value1, String value2) {
            addCriterion("path2 between", value1, value2, "path2");
            return (Criteria) this;
        }

        public Criteria andPath2NotBetween(String value1, String value2) {
            addCriterion("path2 not between", value1, value2, "path2");
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