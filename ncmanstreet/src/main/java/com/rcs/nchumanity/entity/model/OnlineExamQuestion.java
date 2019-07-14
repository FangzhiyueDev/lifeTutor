package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  OnlineExamQuestion.java
 * Author:  mayn
 * Purpose: Defines the Class OnlineExamQuestion
 ***********************************************************************/

import java.util.*;

/** 在线考核题目信息表 */
public class OnlineExamQuestion {
   /** 主键 */
   public long id;
   /** 问题 */
   public String question;
   /** 选项 */
   public String options;
   /** 答案 */
   public String answer;
   /** 试卷类型 */
   public int type;
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
            oldCourseClassification.removeOnlineExamQuestion(this);
         }
         if (newCourseClassification != null)
         {
            this.courseClassification = newCourseClassification;
            this.courseClassification.addOnlineExamQuestion(this);
         }
      }
   }

}