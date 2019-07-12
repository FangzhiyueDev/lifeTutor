package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  CourseClassification.java
 * Author:  mayn
 * Purpose: Defines the Class CourseClassification
 ***********************************************************************/

import java.util.*;

/** 课程分类信息 */
public class CourseClassification {
   /** 课程编号 */
   public long courseNo;
   /** 课程名称 */
   public String courseName;
   /** 必修 */
   public byte required;
   /** 类型 */
   public int type;
   /** 子类型 */
   public int subType;
   /** 隐藏 */
   public byte isDelete;
   /** 备注 */
   public String remark;
   
   public Collection<UserOnlineStudyRecord> userOnlineStudyRecord;
   public Collection<UserOfflineExamInfo> userOfflineExamInfo;
   public Collection<OnlineCourseInfo> onlineCourseInfo;
   public Collection<OfflineTrainClass> offlineTrainClass;
   public Collection<OnlineExamQuestion> onlineExamQuestion;
   public Collection<OfflineExamRecord> offlineExamRecord;
   
   
   /** @pdGenerated default getter */
   public Collection<UserOnlineStudyRecord> getUserOnlineStudyRecord() {
      if (userOnlineStudyRecord == null)
         userOnlineStudyRecord = new HashSet<UserOnlineStudyRecord>();
      return userOnlineStudyRecord;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorUserOnlineStudyRecord() {
      if (userOnlineStudyRecord == null)
         userOnlineStudyRecord = new HashSet<UserOnlineStudyRecord>();
      return userOnlineStudyRecord.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUserOnlineStudyRecord */
   public void setUserOnlineStudyRecord(Collection<UserOnlineStudyRecord> newUserOnlineStudyRecord) {
      removeAllUserOnlineStudyRecord();
      for (Iterator iter = newUserOnlineStudyRecord.iterator(); iter.hasNext();)
         addUserOnlineStudyRecord((UserOnlineStudyRecord)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUserOnlineStudyRecord */
   public void addUserOnlineStudyRecord(UserOnlineStudyRecord newUserOnlineStudyRecord) {
      if (newUserOnlineStudyRecord == null)
         return;
      if (this.userOnlineStudyRecord == null)
         this.userOnlineStudyRecord = new HashSet<UserOnlineStudyRecord>();
      if (!this.userOnlineStudyRecord.contains(newUserOnlineStudyRecord))
      {
         this.userOnlineStudyRecord.add(newUserOnlineStudyRecord);
         newUserOnlineStudyRecord.setCourseClassification(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUserOnlineStudyRecord */
   public void removeUserOnlineStudyRecord(UserOnlineStudyRecord oldUserOnlineStudyRecord) {
      if (oldUserOnlineStudyRecord == null)
         return;
      if (this.userOnlineStudyRecord != null)
         if (this.userOnlineStudyRecord.contains(oldUserOnlineStudyRecord))
         {
            this.userOnlineStudyRecord.remove(oldUserOnlineStudyRecord);
            oldUserOnlineStudyRecord.setCourseClassification((CourseClassification)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUserOnlineStudyRecord() {
      if (userOnlineStudyRecord != null)
      {
         UserOnlineStudyRecord oldUserOnlineStudyRecord;
         for (Iterator iter = getIteratorUserOnlineStudyRecord(); iter.hasNext();)
         {
            oldUserOnlineStudyRecord = (UserOnlineStudyRecord)iter.next();
            iter.remove();
            oldUserOnlineStudyRecord.setCourseClassification((CourseClassification)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<UserOfflineExamInfo> getUserOfflineExamInfo() {
      if (userOfflineExamInfo == null)
         userOfflineExamInfo = new HashSet<UserOfflineExamInfo>();
      return userOfflineExamInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorUserOfflineExamInfo() {
      if (userOfflineExamInfo == null)
         userOfflineExamInfo = new HashSet<UserOfflineExamInfo>();
      return userOfflineExamInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUserOfflineExamInfo */
   public void setUserOfflineExamInfo(Collection<UserOfflineExamInfo> newUserOfflineExamInfo) {
      removeAllUserOfflineExamInfo();
      for (Iterator iter = newUserOfflineExamInfo.iterator(); iter.hasNext();)
         addUserOfflineExamInfo((UserOfflineExamInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUserOfflineExamInfo */
   public void addUserOfflineExamInfo(UserOfflineExamInfo newUserOfflineExamInfo) {
      if (newUserOfflineExamInfo == null)
         return;
      if (this.userOfflineExamInfo == null)
         this.userOfflineExamInfo = new HashSet<UserOfflineExamInfo>();
      if (!this.userOfflineExamInfo.contains(newUserOfflineExamInfo))
      {
         this.userOfflineExamInfo.add(newUserOfflineExamInfo);
         newUserOfflineExamInfo.setCourseClassification(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUserOfflineExamInfo */
   public void removeUserOfflineExamInfo(UserOfflineExamInfo oldUserOfflineExamInfo) {
      if (oldUserOfflineExamInfo == null)
         return;
      if (this.userOfflineExamInfo != null)
         if (this.userOfflineExamInfo.contains(oldUserOfflineExamInfo))
         {
            this.userOfflineExamInfo.remove(oldUserOfflineExamInfo);
            oldUserOfflineExamInfo.setCourseClassification((CourseClassification)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUserOfflineExamInfo() {
      if (userOfflineExamInfo != null)
      {
         UserOfflineExamInfo oldUserOfflineExamInfo;
         for (Iterator iter = getIteratorUserOfflineExamInfo(); iter.hasNext();)
         {
            oldUserOfflineExamInfo = (UserOfflineExamInfo)iter.next();
            iter.remove();
            oldUserOfflineExamInfo.setCourseClassification((CourseClassification)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<OnlineCourseInfo> getOnlineCourseInfo() {
      if (onlineCourseInfo == null)
         onlineCourseInfo = new HashSet<OnlineCourseInfo>();
      return onlineCourseInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorOnlineCourseInfo() {
      if (onlineCourseInfo == null)
         onlineCourseInfo = new HashSet<OnlineCourseInfo>();
      return onlineCourseInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOnlineCourseInfo */
   public void setOnlineCourseInfo(Collection<OnlineCourseInfo> newOnlineCourseInfo) {
      removeAllOnlineCourseInfo();
      for (Iterator iter = newOnlineCourseInfo.iterator(); iter.hasNext();)
         addOnlineCourseInfo((OnlineCourseInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOnlineCourseInfo */
   public void addOnlineCourseInfo(OnlineCourseInfo newOnlineCourseInfo) {
      if (newOnlineCourseInfo == null)
         return;
      if (this.onlineCourseInfo == null)
         this.onlineCourseInfo = new HashSet<OnlineCourseInfo>();
      if (!this.onlineCourseInfo.contains(newOnlineCourseInfo))
      {
         this.onlineCourseInfo.add(newOnlineCourseInfo);
         newOnlineCourseInfo.setCourseClassification(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldOnlineCourseInfo */
   public void removeOnlineCourseInfo(OnlineCourseInfo oldOnlineCourseInfo) {
      if (oldOnlineCourseInfo == null)
         return;
      if (this.onlineCourseInfo != null)
         if (this.onlineCourseInfo.contains(oldOnlineCourseInfo))
         {
            this.onlineCourseInfo.remove(oldOnlineCourseInfo);
            oldOnlineCourseInfo.setCourseClassification((CourseClassification)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOnlineCourseInfo() {
      if (onlineCourseInfo != null)
      {
         OnlineCourseInfo oldOnlineCourseInfo;
         for (Iterator iter = getIteratorOnlineCourseInfo(); iter.hasNext();)
         {
            oldOnlineCourseInfo = (OnlineCourseInfo)iter.next();
            iter.remove();
            oldOnlineCourseInfo.setCourseClassification((CourseClassification)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<OfflineTrainClass> getOfflineTrainClass() {
      if (offlineTrainClass == null)
         offlineTrainClass = new HashSet<OfflineTrainClass>();
      return offlineTrainClass;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorOfflineTrainClass() {
      if (offlineTrainClass == null)
         offlineTrainClass = new HashSet<OfflineTrainClass>();
      return offlineTrainClass.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOfflineTrainClass */
   public void setOfflineTrainClass(Collection<OfflineTrainClass> newOfflineTrainClass) {
      removeAllOfflineTrainClass();
      for (Iterator iter = newOfflineTrainClass.iterator(); iter.hasNext();)
         addOfflineTrainClass((OfflineTrainClass)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOfflineTrainClass */
   public void addOfflineTrainClass(OfflineTrainClass newOfflineTrainClass) {
      if (newOfflineTrainClass == null)
         return;
      if (this.offlineTrainClass == null)
         this.offlineTrainClass = new HashSet<OfflineTrainClass>();
      if (!this.offlineTrainClass.contains(newOfflineTrainClass))
      {
         this.offlineTrainClass.add(newOfflineTrainClass);
         newOfflineTrainClass.setCourseClassification(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldOfflineTrainClass */
   public void removeOfflineTrainClass(OfflineTrainClass oldOfflineTrainClass) {
      if (oldOfflineTrainClass == null)
         return;
      if (this.offlineTrainClass != null)
         if (this.offlineTrainClass.contains(oldOfflineTrainClass))
         {
            this.offlineTrainClass.remove(oldOfflineTrainClass);
            oldOfflineTrainClass.setCourseClassification((CourseClassification)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOfflineTrainClass() {
      if (offlineTrainClass != null)
      {
         OfflineTrainClass oldOfflineTrainClass;
         for (Iterator iter = getIteratorOfflineTrainClass(); iter.hasNext();)
         {
            oldOfflineTrainClass = (OfflineTrainClass)iter.next();
            iter.remove();
            oldOfflineTrainClass.setCourseClassification((CourseClassification)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<OnlineExamQuestion> getOnlineExamQuestion() {
      if (onlineExamQuestion == null)
         onlineExamQuestion = new HashSet<OnlineExamQuestion>();
      return onlineExamQuestion;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorOnlineExamQuestion() {
      if (onlineExamQuestion == null)
         onlineExamQuestion = new HashSet<OnlineExamQuestion>();
      return onlineExamQuestion.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOnlineExamQuestion */
   public void setOnlineExamQuestion(Collection<OnlineExamQuestion> newOnlineExamQuestion) {
      removeAllOnlineExamQuestion();
      for (Iterator iter = newOnlineExamQuestion.iterator(); iter.hasNext();)
         addOnlineExamQuestion((OnlineExamQuestion)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOnlineExamQuestion */
   public void addOnlineExamQuestion(OnlineExamQuestion newOnlineExamQuestion) {
      if (newOnlineExamQuestion == null)
         return;
      if (this.onlineExamQuestion == null)
         this.onlineExamQuestion = new HashSet<OnlineExamQuestion>();
      if (!this.onlineExamQuestion.contains(newOnlineExamQuestion))
      {
         this.onlineExamQuestion.add(newOnlineExamQuestion);
         newOnlineExamQuestion.setCourseClassification(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldOnlineExamQuestion */
   public void removeOnlineExamQuestion(OnlineExamQuestion oldOnlineExamQuestion) {
      if (oldOnlineExamQuestion == null)
         return;
      if (this.onlineExamQuestion != null)
         if (this.onlineExamQuestion.contains(oldOnlineExamQuestion))
         {
            this.onlineExamQuestion.remove(oldOnlineExamQuestion);
            oldOnlineExamQuestion.setCourseClassification((CourseClassification)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOnlineExamQuestion() {
      if (onlineExamQuestion != null)
      {
         OnlineExamQuestion oldOnlineExamQuestion;
         for (Iterator iter = getIteratorOnlineExamQuestion(); iter.hasNext();)
         {
            oldOnlineExamQuestion = (OnlineExamQuestion)iter.next();
            iter.remove();
            oldOnlineExamQuestion.setCourseClassification((CourseClassification)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<OfflineExamRecord> getOfflineExamRecord() {
      if (offlineExamRecord == null)
         offlineExamRecord = new HashSet<OfflineExamRecord>();
      return offlineExamRecord;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorOfflineExamRecord() {
      if (offlineExamRecord == null)
         offlineExamRecord = new HashSet<OfflineExamRecord>();
      return offlineExamRecord.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOfflineExamRecord */
   public void setOfflineExamRecord(Collection<OfflineExamRecord> newOfflineExamRecord) {
      removeAllOfflineExamRecord();
      for (Iterator iter = newOfflineExamRecord.iterator(); iter.hasNext();)
         addOfflineExamRecord((OfflineExamRecord)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOfflineExamRecord */
   public void addOfflineExamRecord(OfflineExamRecord newOfflineExamRecord) {
      if (newOfflineExamRecord == null)
         return;
      if (this.offlineExamRecord == null)
         this.offlineExamRecord = new HashSet<OfflineExamRecord>();
      if (!this.offlineExamRecord.contains(newOfflineExamRecord))
      {
         this.offlineExamRecord.add(newOfflineExamRecord);
         newOfflineExamRecord.setCourseClassification(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldOfflineExamRecord */
   public void removeOfflineExamRecord(OfflineExamRecord oldOfflineExamRecord) {
      if (oldOfflineExamRecord == null)
         return;
      if (this.offlineExamRecord != null)
         if (this.offlineExamRecord.contains(oldOfflineExamRecord))
         {
            this.offlineExamRecord.remove(oldOfflineExamRecord);
            oldOfflineExamRecord.setCourseClassification((CourseClassification)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOfflineExamRecord() {
      if (offlineExamRecord != null)
      {
         OfflineExamRecord oldOfflineExamRecord;
         for (Iterator iter = getIteratorOfflineExamRecord(); iter.hasNext();)
         {
            oldOfflineExamRecord = (OfflineExamRecord)iter.next();
            iter.remove();
            oldOfflineExamRecord.setCourseClassification((CourseClassification)null);
         }
      }
   }

}