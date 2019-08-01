package com.rcs.nchumanity.entity.model;

public class VrExamData {
    private String id;

    private String stuName;

    private String stuClass;

    private String examDate;

    private Long examDateLong;

    private String examType;

    private Integer score;

    private Boolean isupload;

    private String picpaths;

    private String path;

    private String path2;

    private Boolean isDelete;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass == null ? null : stuClass.trim();
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate == null ? null : examDate.trim();
    }

    public Long getExamDateLong() {
        return examDateLong;
    }

    public void setExamDateLong(Long examDateLong) {
        this.examDateLong = examDateLong;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType == null ? null : examType.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getIsupload() {
        return isupload;
    }

    public void setIsupload(Boolean isupload) {
        this.isupload = isupload;
    }

    public String getPicpaths() {
        return picpaths;
    }

    public void setPicpaths(String picpaths) {
        this.picpaths = picpaths == null ? null : picpaths.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2 == null ? null : path2.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}