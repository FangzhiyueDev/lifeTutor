package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  SpecificInfo.java
 * Author:  mayn
 * Purpose: Defines the Class SpecificInfo
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

/**
 * 特定信息记录表
 */
public class SpecificInfo implements Serializable {
    /**
     * 主键
     */
    public long id;
    /**
     * 特定编号
     */
    public int specificNo;
    /**
     * 标题
     */
    public String title;
    /**
     * 内容
     */
    public String content;
    /**
     * 图标
     */
    public String icon;
    /**
     * 图片
     */
    public String imgUrl;
    /**
     * 视频
     */
    public String videoUrl;
    /**
     * 地址
     */
    public String location;
    /**
     * 隐藏
     */
    public Boolean isDelete;
    /**
     * 备注
     */
    public String remark;

    public SpecificInfoClassification specificInfoClassification;


    /**
     * @pdGenerated default parent getter
     */
    public SpecificInfoClassification getSpecificInfoClassification() {
        return specificInfoClassification;
    }

    /**
     * @param newSpecificInfoClassification
     * @pdGenerated default parent setter
     */
    public void setSpecificInfoClassification(SpecificInfoClassification newSpecificInfoClassification) {
        if (this.specificInfoClassification == null || !this.specificInfoClassification.equals(newSpecificInfoClassification)) {
            if (this.specificInfoClassification != null) {
                SpecificInfoClassification oldSpecificInfoClassification = this.specificInfoClassification;
                this.specificInfoClassification = null;
                oldSpecificInfoClassification.removeSpecificInfo(this);
            }
            if (newSpecificInfoClassification != null) {
                this.specificInfoClassification = newSpecificInfoClassification;
                this.specificInfoClassification.addSpecificInfo(this);
            }
        }
    }

}