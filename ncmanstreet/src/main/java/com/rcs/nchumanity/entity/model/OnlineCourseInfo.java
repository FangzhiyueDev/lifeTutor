package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  OnlineCourseInfo.java
 * Author:  mayn
 * Purpose: Defines the Class OnlineCourseInfo
 ***********************************************************************/

import java.util.*;

/** 在线课程内容信息 */
public class OnlineCourseInfo {
   /** 主键 */
   public long id;
   /** 视频Id */
   public String videoId;
   /** 视频地址 */
   public String videoUrl;
   /** 图片地址 */
   public String imgUrl;
   /** 文本 */
   public String writing;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;
   
   public CourseClassification courseClassification;
   
   
   /** @pdGenerated default parent getter */
   public CourseClassification getCourseClassification() {
      return courseClassification;
   }
   
   /** @pdGenerated default parent setter
     * @param newCourseClassification */
   public void setCourseClassification(CourseClassification newCourseClassification) {
      if (this.courseClassification == null || !this.courseClassification.equals(newCourseClassification))
      {
         if (this.courseClassification != null)
         {
            CourseClassification oldCourseClassification = this.courseClassification;
            this.courseClassification = null;
            oldCourseClassification.removeOnlineCourseInfo(this);
         }
         if (newCourseClassification != null)
         {
            this.courseClassification = newCourseClassification;
            this.courseClassification.addOnlineCourseInfo(this);
         }
      }
   }

}