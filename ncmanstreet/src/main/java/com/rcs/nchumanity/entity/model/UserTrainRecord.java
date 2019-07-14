package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  UserTrainRecord.java
 * Author:  mayn
 * Purpose: Defines the Class UserTrainRecord
 ***********************************************************************/

import java.util.*;

/** 用户单次报名记录信息表 */
public class UserTrainRecord {
   /** 主键 */
   public long trainId;
   /** 开始时间 */
   public Date startTime;
   /** 总体分数 */
   public int totalScore;
   /** 学习状态 */
   public int studyStatus;
   /** 类型 */
   public int type;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;
   
   public Collection<UserOnlineStudyRecord> userOnlineStudyRecord;
   public Collection<UserOnlineExamInfo> userOnlineExamInfo;
   public Collection<UserOfflineStudyRecord> userOfflineStudyRecord;
   public Collection<UserOfflineExamInfo> userOfflineExamInfo;
   public UserAccount userAccount;
   
   
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
         newUserOnlineStudyRecord.setUserTrainRecord(this);      
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
            oldUserOnlineStudyRecord.setUserTrainRecord((UserTrainRecord)null);
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
            oldUserOnlineStudyRecord.setUserTrainRecord((UserTrainRecord)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<UserOnlineExamInfo> getUserOnlineExamInfo() {
      if (userOnlineExamInfo == null)
         userOnlineExamInfo = new HashSet<UserOnlineExamInfo>();
      return userOnlineExamInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorUserOnlineExamInfo() {
      if (userOnlineExamInfo == null)
         userOnlineExamInfo = new HashSet<UserOnlineExamInfo>();
      return userOnlineExamInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUserOnlineExamInfo */
   public void setUserOnlineExamInfo(Collection<UserOnlineExamInfo> newUserOnlineExamInfo) {
      removeAllUserOnlineExamInfo();
      for (Iterator iter = newUserOnlineExamInfo.iterator(); iter.hasNext();)
         addUserOnlineExamInfo((UserOnlineExamInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUserOnlineExamInfo */
   public void addUserOnlineExamInfo(UserOnlineExamInfo newUserOnlineExamInfo) {
      if (newUserOnlineExamInfo == null)
         return;
      if (this.userOnlineExamInfo == null)
         this.userOnlineExamInfo = new HashSet<UserOnlineExamInfo>();
      if (!this.userOnlineExamInfo.contains(newUserOnlineExamInfo))
      {
         this.userOnlineExamInfo.add(newUserOnlineExamInfo);
         newUserOnlineExamInfo.setUserTrainRecord(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUserOnlineExamInfo */
   public void removeUserOnlineExamInfo(UserOnlineExamInfo oldUserOnlineExamInfo) {
      if (oldUserOnlineExamInfo == null)
         return;
      if (this.userOnlineExamInfo != null)
         if (this.userOnlineExamInfo.contains(oldUserOnlineExamInfo))
         {
            this.userOnlineExamInfo.remove(oldUserOnlineExamInfo);
            oldUserOnlineExamInfo.setUserTrainRecord((UserTrainRecord)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUserOnlineExamInfo() {
      if (userOnlineExamInfo != null)
      {
         UserOnlineExamInfo oldUserOnlineExamInfo;
         for (Iterator iter = getIteratorUserOnlineExamInfo(); iter.hasNext();)
         {
            oldUserOnlineExamInfo = (UserOnlineExamInfo)iter.next();
            iter.remove();
            oldUserOnlineExamInfo.setUserTrainRecord((UserTrainRecord)null);
         }
      }
   }
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
         newUserOfflineStudyRecord.setUserTrainRecord(this);      
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
            oldUserOfflineStudyRecord.setUserTrainRecord((UserTrainRecord)null);
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
            oldUserOfflineStudyRecord.setUserTrainRecord((UserTrainRecord)null);
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
         newUserOfflineExamInfo.setUserTrainRecord(this);      
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
            oldUserOfflineExamInfo.setUserTrainRecord((UserTrainRecord)null);
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
            oldUserOfflineExamInfo.setUserTrainRecord((UserTrainRecord)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public UserAccount getUserAccount() {
      return userAccount;
   }
   
   /** @pdGenerated default parent setter
     * @param newUserAccount */
   public void setUserAccount(UserAccount newUserAccount) {
      if (this.userAccount == null || !this.userAccount.equals(newUserAccount))
      {
         if (this.userAccount != null)
         {
            UserAccount oldUserAccount = this.userAccount;
            this.userAccount = null;
            oldUserAccount.removeUserTrainRecord(this);
         }
         if (newUserAccount != null)
         {
            this.userAccount = newUserAccount;
            this.userAccount.addUserTrainRecord(this);
         }
      }
   }

}