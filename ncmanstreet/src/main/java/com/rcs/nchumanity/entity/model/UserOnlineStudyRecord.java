package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  UserOnlineStudyRecord.java
 * Author:  mayn
 * Purpose: Defines the Class UserOnlineStudyRecord
 ***********************************************************************/

import java.util.*;

/** 用户线上学习记录信息表 */
public class UserOnlineStudyRecord {
   /** 主键 */
   public long id;
   /** 开始时间 */
   public Date startTime;
   /** 学习时间 */
   public int totalTime;
   /** 隐藏 */
   public byte isDelete;
   /** 备注 */
   public String remark;
   
   public UserTrainRecord userTrainRecord;
   public CourseClassification courseClassification;
   
   
   /** @pdGenerated default parent getter */
   public UserTrainRecord getUserTrainRecord() {
      return userTrainRecord;
   }
   
   /** @pdGenerated default parent setter
     * @param newUserTrainRecord */
   public void setUserTrainRecord(UserTrainRecord newUserTrainRecord) {
      if (this.userTrainRecord == null || !this.userTrainRecord.equals(newUserTrainRecord))
      {
         if (this.userTrainRecord != null)
         {
            UserTrainRecord oldUserTrainRecord = this.userTrainRecord;
            this.userTrainRecord = null;
            oldUserTrainRecord.removeUserOnlineStudyRecord(this);
         }
         if (newUserTrainRecord != null)
         {
            this.userTrainRecord = newUserTrainRecord;
            this.userTrainRecord.addUserOnlineStudyRecord(this);
         }
      }
   }
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
            oldCourseClassification.removeUserOnlineStudyRecord(this);
         }
         if (newCourseClassification != null)
         {
            this.courseClassification = newCourseClassification;
            this.courseClassification.addUserOnlineStudyRecord(this);
         }
      }
   }

}