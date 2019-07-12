package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  UserOfflineExamInfo.java
 * Author:  mayn
 * Purpose: Defines the Class UserOfflineExamInfo
 ***********************************************************************/

import java.util.*;

/** 用户线下考核记录信息表 */
public class UserOfflineExamInfo {
   /** 主键 */
   public long id;
   /** 考核时间 */
   public Date examTime;
   /** 得分 */
   public int score;
   /** 隐藏 */
   public byte isDelete;
   /** 备注 */
   public String remark;
   
   public UserTrainRecord userTrainRecord;
   public CourseClassification courseClassification;
   public OfflineExamRecord offlineExamRecord;
   
   
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
            oldUserTrainRecord.removeUserOfflineExamInfo(this);
         }
         if (newUserTrainRecord != null)
         {
            this.userTrainRecord = newUserTrainRecord;
            this.userTrainRecord.addUserOfflineExamInfo(this);
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
            oldCourseClassification.removeUserOfflineExamInfo(this);
         }
         if (newCourseClassification != null)
         {
            this.courseClassification = newCourseClassification;
            this.courseClassification.addUserOfflineExamInfo(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public OfflineExamRecord getOfflineExamRecord() {
      return offlineExamRecord;
   }
   
   /** @pdGenerated default parent setter
     * @param newOfflineExamRecord */
   public void setOfflineExamRecord(OfflineExamRecord newOfflineExamRecord) {
      if (this.offlineExamRecord == null || !this.offlineExamRecord.equals(newOfflineExamRecord))
      {
         if (this.offlineExamRecord != null)
         {
            OfflineExamRecord oldOfflineExamRecord = this.offlineExamRecord;
            this.offlineExamRecord = null;
            oldOfflineExamRecord.removeUserOfflineExamInfo(this);
         }
         if (newOfflineExamRecord != null)
         {
            this.offlineExamRecord = newOfflineExamRecord;
            this.offlineExamRecord.addUserOfflineExamInfo(this);
         }
      }
   }

}