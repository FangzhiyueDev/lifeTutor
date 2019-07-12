package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  OfflineTrainClass.java
 * Author:  mayn
 * Purpose: Defines the Class OfflineTrainClass
 ***********************************************************************/

import java.util.*;

/** 线下培训班信息表 */
public class OfflineTrainClass {
   /** 主键 */
   public long classId;
   /** 培训班名 */
   public String className;
   /** 开始时间 */
   public Date startTime;
   /** 结束时间 */
   public Date endTime;
   /** 简介 */
   public String intro;
   /** 图片地址 */
   public String imgUrl;
   /** vr课程 */
   public byte isVr;
   /** 当前人数 */
   public int currentNum;
   /** 最大人数 */
   public int maxNum;
   /** 特殊文本 */
   public String specialText;
   /** 备用文本 */
   public String backupText;
   /** 隐藏 */
   public byte isDelete;
   /** 备注 */
   public String remark;
   
   public Collection<UserOfflineStudyRecord> userOfflineStudyRecord;
   public CourseClassification courseClassification;
   public TrainPointInfo trainPointInfo;
   public TrainerInfo trainerInfo;
   
   
   /** @pdGenerated default getter */
   public Collection<UserOfflineStudyRecord> getUserOfflineStudyRecord() {
      if (userOfflineStudyRecord == null)
         userOfflineStudyRecord = new HashSet<UserOfflineStudyRecord>();
      return userOfflineStudyRecord;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorUserOfflineStudyRecord() {
      if (userOfflineStudyRecord == null)
         userOfflineStudyRecord = new HashSet<UserOfflineStudyRecord>();
      return userOfflineStudyRecord.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUserOfflineStudyRecord */
   public void setUserOfflineStudyRecord(Collection<UserOfflineStudyRecord> newUserOfflineStudyRecord) {
      removeAllUserOfflineStudyRecord();
      for (Iterator iter = newUserOfflineStudyRecord.iterator(); iter.hasNext();)
         addUserOfflineStudyRecord((UserOfflineStudyRecord)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUserOfflineStudyRecord */
   public void addUserOfflineStudyRecord(UserOfflineStudyRecord newUserOfflineStudyRecord) {
      if (newUserOfflineStudyRecord == null)
         return;
      if (this.userOfflineStudyRecord == null)
         this.userOfflineStudyRecord = new HashSet<UserOfflineStudyRecord>();
      if (!this.userOfflineStudyRecord.contains(newUserOfflineStudyRecord))
      {
         this.userOfflineStudyRecord.add(newUserOfflineStudyRecord);
         newUserOfflineStudyRecord.setOfflineTrainClass(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUserOfflineStudyRecord */
   public void removeUserOfflineStudyRecord(UserOfflineStudyRecord oldUserOfflineStudyRecord) {
      if (oldUserOfflineStudyRecord == null)
         return;
      if (this.userOfflineStudyRecord != null)
         if (this.userOfflineStudyRecord.contains(oldUserOfflineStudyRecord))
         {
            this.userOfflineStudyRecord.remove(oldUserOfflineStudyRecord);
            oldUserOfflineStudyRecord.setOfflineTrainClass((OfflineTrainClass)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUserOfflineStudyRecord() {
      if (userOfflineStudyRecord != null)
      {
         UserOfflineStudyRecord oldUserOfflineStudyRecord;
         for (Iterator iter = getIteratorUserOfflineStudyRecord(); iter.hasNext();)
         {
            oldUserOfflineStudyRecord = (UserOfflineStudyRecord)iter.next();
            iter.remove();
            oldUserOfflineStudyRecord.setOfflineTrainClass((OfflineTrainClass)null);
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
            oldCourseClassification.removeOfflineTrainClass(this);
         }
         if (newCourseClassification != null)
         {
            this.courseClassification = newCourseClassification;
            this.courseClassification.addOfflineTrainClass(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TrainPointInfo getTrainPointInfo() {
      return trainPointInfo;
   }
   
   /** @pdGenerated default parent setter
     * @param newTrainPointInfo */
   public void setTrainPointInfo(TrainPointInfo newTrainPointInfo) {
      if (this.trainPointInfo == null || !this.trainPointInfo.equals(newTrainPointInfo))
      {
         if (this.trainPointInfo != null)
         {
            TrainPointInfo oldTrainPointInfo = this.trainPointInfo;
            this.trainPointInfo = null;
            oldTrainPointInfo.removeOfflineTrainClass(this);
         }
         if (newTrainPointInfo != null)
         {
            this.trainPointInfo = newTrainPointInfo;
            this.trainPointInfo.addOfflineTrainClass(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TrainerInfo getTrainerInfo() {
      return trainerInfo;
   }
   
   /** @pdGenerated default parent setter
     * @param newTrainerInfo */
   public void setTrainerInfo(TrainerInfo newTrainerInfo) {
      if (this.trainerInfo == null || !this.trainerInfo.equals(newTrainerInfo))
      {
         if (this.trainerInfo != null)
         {
            TrainerInfo oldTrainerInfo = this.trainerInfo;
            this.trainerInfo = null;
            oldTrainerInfo.removeOfflineTrainClass(this);
         }
         if (newTrainerInfo != null)
         {
            this.trainerInfo = newTrainerInfo;
            this.trainerInfo.addOfflineTrainClass(this);
         }
      }
   }

}