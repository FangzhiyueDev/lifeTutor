package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  UserAccount.java
 * Author:  mayn
 * Purpose: Defines the Class UserAccount
 ***********************************************************************/

import java.util.*;

/** 用户账户信息表 */
public class UserAccount {
   /** 主键 */
   public long userId;
   /** 手机号 */
   public String mobilephone;
   /** 密码 */
   public String password;
   /** 微信Id */
   public String wechatId;
   /** 可用性 */
   public Boolean available;
   /** 用户昵称 */
   public String nickname;
   /** 用户头像 */
   public String picUrl;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;
   
   public Collection<UserBasicInfo> userBasicInfo;
   public Collection<UserTrainRecord> userTrainRecord;
   public Collection<UserFirstAiderCertificate> userFirstAiderCertificate;
   public Collection<TrainingRoomEnterRecord> trainingRoomEnterRecord;
   public Collection<ExpressOrderInfo> expressOrderInfo;
   public Collection<FeedbackRecord> feedbackRecord;
   
   
   /** @pdGenerated default getter */
   public Collection<UserBasicInfo> getUserBasicInfo() {
      if (userBasicInfo == null)
         userBasicInfo = new HashSet<UserBasicInfo>();
      return userBasicInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorUserBasicInfo() {
      if (userBasicInfo == null)
         userBasicInfo = new HashSet<UserBasicInfo>();
      return userBasicInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUserBasicInfo */
   public void setUserBasicInfo(Collection<UserBasicInfo> newUserBasicInfo) {
      removeAllUserBasicInfo();
      for (Iterator iter = newUserBasicInfo.iterator(); iter.hasNext();)
         addUserBasicInfo((UserBasicInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUserBasicInfo */
   public void addUserBasicInfo(UserBasicInfo newUserBasicInfo) {
      if (newUserBasicInfo == null)
         return;
      if (this.userBasicInfo == null)
         this.userBasicInfo = new HashSet<UserBasicInfo>();
      if (!this.userBasicInfo.contains(newUserBasicInfo))
      {
         this.userBasicInfo.add(newUserBasicInfo);
         newUserBasicInfo.setUserAccount(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUserBasicInfo */
   public void removeUserBasicInfo(UserBasicInfo oldUserBasicInfo) {
      if (oldUserBasicInfo == null)
         return;
      if (this.userBasicInfo != null)
         if (this.userBasicInfo.contains(oldUserBasicInfo))
         {
            this.userBasicInfo.remove(oldUserBasicInfo);
            oldUserBasicInfo.setUserAccount((UserAccount)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUserBasicInfo() {
      if (userBasicInfo != null)
      {
         UserBasicInfo oldUserBasicInfo;
         for (Iterator iter = getIteratorUserBasicInfo(); iter.hasNext();)
         {
            oldUserBasicInfo = (UserBasicInfo)iter.next();
            iter.remove();
            oldUserBasicInfo.setUserAccount((UserAccount)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<UserTrainRecord> getUserTrainRecord() {
      if (userTrainRecord == null)
         userTrainRecord = new HashSet<UserTrainRecord>();
      return userTrainRecord;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorUserTrainRecord() {
      if (userTrainRecord == null)
         userTrainRecord = new HashSet<UserTrainRecord>();
      return userTrainRecord.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUserTrainRecord */
   public void setUserTrainRecord(Collection<UserTrainRecord> newUserTrainRecord) {
      removeAllUserTrainRecord();
      for (Iterator iter = newUserTrainRecord.iterator(); iter.hasNext();)
         addUserTrainRecord((UserTrainRecord)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUserTrainRecord */
   public void addUserTrainRecord(UserTrainRecord newUserTrainRecord) {
      if (newUserTrainRecord == null)
         return;
      if (this.userTrainRecord == null)
         this.userTrainRecord = new HashSet<UserTrainRecord>();
      if (!this.userTrainRecord.contains(newUserTrainRecord))
      {
         this.userTrainRecord.add(newUserTrainRecord);
         newUserTrainRecord.setUserAccount(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUserTrainRecord */
   public void removeUserTrainRecord(UserTrainRecord oldUserTrainRecord) {
      if (oldUserTrainRecord == null)
         return;
      if (this.userTrainRecord != null)
         if (this.userTrainRecord.contains(oldUserTrainRecord))
         {
            this.userTrainRecord.remove(oldUserTrainRecord);
            oldUserTrainRecord.setUserAccount((UserAccount)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUserTrainRecord() {
      if (userTrainRecord != null)
      {
         UserTrainRecord oldUserTrainRecord;
         for (Iterator iter = getIteratorUserTrainRecord(); iter.hasNext();)
         {
            oldUserTrainRecord = (UserTrainRecord)iter.next();
            iter.remove();
            oldUserTrainRecord.setUserAccount((UserAccount)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<UserFirstAiderCertificate> getUserFirstAiderCertificate() {
      if (userFirstAiderCertificate == null)
         userFirstAiderCertificate = new HashSet<UserFirstAiderCertificate>();
      return userFirstAiderCertificate;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorUserFirstAiderCertificate() {
      if (userFirstAiderCertificate == null)
         userFirstAiderCertificate = new HashSet<UserFirstAiderCertificate>();
      return userFirstAiderCertificate.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUserFirstAiderCertificate */
   public void setUserFirstAiderCertificate(Collection<UserFirstAiderCertificate> newUserFirstAiderCertificate) {
      removeAllUserFirstAiderCertificate();
      for (Iterator iter = newUserFirstAiderCertificate.iterator(); iter.hasNext();)
         addUserFirstAiderCertificate((UserFirstAiderCertificate)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUserFirstAiderCertificate */
   public void addUserFirstAiderCertificate(UserFirstAiderCertificate newUserFirstAiderCertificate) {
      if (newUserFirstAiderCertificate == null)
         return;
      if (this.userFirstAiderCertificate == null)
         this.userFirstAiderCertificate = new HashSet<UserFirstAiderCertificate>();
      if (!this.userFirstAiderCertificate.contains(newUserFirstAiderCertificate))
      {
         this.userFirstAiderCertificate.add(newUserFirstAiderCertificate);
         newUserFirstAiderCertificate.setUserAccount(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUserFirstAiderCertificate */
   public void removeUserFirstAiderCertificate(UserFirstAiderCertificate oldUserFirstAiderCertificate) {
      if (oldUserFirstAiderCertificate == null)
         return;
      if (this.userFirstAiderCertificate != null)
         if (this.userFirstAiderCertificate.contains(oldUserFirstAiderCertificate))
         {
            this.userFirstAiderCertificate.remove(oldUserFirstAiderCertificate);
            oldUserFirstAiderCertificate.setUserAccount((UserAccount)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUserFirstAiderCertificate() {
      if (userFirstAiderCertificate != null)
      {
         UserFirstAiderCertificate oldUserFirstAiderCertificate;
         for (Iterator iter = getIteratorUserFirstAiderCertificate(); iter.hasNext();)
         {
            oldUserFirstAiderCertificate = (UserFirstAiderCertificate)iter.next();
            iter.remove();
            oldUserFirstAiderCertificate.setUserAccount((UserAccount)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<TrainingRoomEnterRecord> getTrainingRoomEnterRecord() {
      if (trainingRoomEnterRecord == null)
         trainingRoomEnterRecord = new HashSet<TrainingRoomEnterRecord>();
      return trainingRoomEnterRecord;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorTrainingRoomEnterRecord() {
      if (trainingRoomEnterRecord == null)
         trainingRoomEnterRecord = new HashSet<TrainingRoomEnterRecord>();
      return trainingRoomEnterRecord.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTrainingRoomEnterRecord */
   public void setTrainingRoomEnterRecord(Collection<TrainingRoomEnterRecord> newTrainingRoomEnterRecord) {
      removeAllTrainingRoomEnterRecord();
      for (Iterator iter = newTrainingRoomEnterRecord.iterator(); iter.hasNext();)
         addTrainingRoomEnterRecord((TrainingRoomEnterRecord)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTrainingRoomEnterRecord */
   public void addTrainingRoomEnterRecord(TrainingRoomEnterRecord newTrainingRoomEnterRecord) {
      if (newTrainingRoomEnterRecord == null)
         return;
      if (this.trainingRoomEnterRecord == null)
         this.trainingRoomEnterRecord = new HashSet<TrainingRoomEnterRecord>();
      if (!this.trainingRoomEnterRecord.contains(newTrainingRoomEnterRecord))
      {
         this.trainingRoomEnterRecord.add(newTrainingRoomEnterRecord);
         newTrainingRoomEnterRecord.setUserAccount(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTrainingRoomEnterRecord */
   public void removeTrainingRoomEnterRecord(TrainingRoomEnterRecord oldTrainingRoomEnterRecord) {
      if (oldTrainingRoomEnterRecord == null)
         return;
      if (this.trainingRoomEnterRecord != null)
         if (this.trainingRoomEnterRecord.contains(oldTrainingRoomEnterRecord))
         {
            this.trainingRoomEnterRecord.remove(oldTrainingRoomEnterRecord);
            oldTrainingRoomEnterRecord.setUserAccount((UserAccount)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTrainingRoomEnterRecord() {
      if (trainingRoomEnterRecord != null)
      {
         TrainingRoomEnterRecord oldTrainingRoomEnterRecord;
         for (Iterator iter = getIteratorTrainingRoomEnterRecord(); iter.hasNext();)
         {
            oldTrainingRoomEnterRecord = (TrainingRoomEnterRecord)iter.next();
            iter.remove();
            oldTrainingRoomEnterRecord.setUserAccount((UserAccount)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<ExpressOrderInfo> getExpressOrderInfo() {
      if (expressOrderInfo == null)
         expressOrderInfo = new HashSet<ExpressOrderInfo>();
      return expressOrderInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorExpressOrderInfo() {
      if (expressOrderInfo == null)
         expressOrderInfo = new HashSet<ExpressOrderInfo>();
      return expressOrderInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newExpressOrderInfo */
   public void setExpressOrderInfo(Collection<ExpressOrderInfo> newExpressOrderInfo) {
      removeAllExpressOrderInfo();
      for (Iterator iter = newExpressOrderInfo.iterator(); iter.hasNext();)
         addExpressOrderInfo((ExpressOrderInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newExpressOrderInfo */
   public void addExpressOrderInfo(ExpressOrderInfo newExpressOrderInfo) {
      if (newExpressOrderInfo == null)
         return;
      if (this.expressOrderInfo == null)
         this.expressOrderInfo = new HashSet<ExpressOrderInfo>();
      if (!this.expressOrderInfo.contains(newExpressOrderInfo))
      {
         this.expressOrderInfo.add(newExpressOrderInfo);
         newExpressOrderInfo.setUserAccount(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldExpressOrderInfo */
   public void removeExpressOrderInfo(ExpressOrderInfo oldExpressOrderInfo) {
      if (oldExpressOrderInfo == null)
         return;
      if (this.expressOrderInfo != null)
         if (this.expressOrderInfo.contains(oldExpressOrderInfo))
         {
            this.expressOrderInfo.remove(oldExpressOrderInfo);
            oldExpressOrderInfo.setUserAccount((UserAccount)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllExpressOrderInfo() {
      if (expressOrderInfo != null)
      {
         ExpressOrderInfo oldExpressOrderInfo;
         for (Iterator iter = getIteratorExpressOrderInfo(); iter.hasNext();)
         {
            oldExpressOrderInfo = (ExpressOrderInfo)iter.next();
            iter.remove();
            oldExpressOrderInfo.setUserAccount((UserAccount)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<FeedbackRecord> getFeedbackRecord() {
      if (feedbackRecord == null)
         feedbackRecord = new HashSet<FeedbackRecord>();
      return feedbackRecord;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorFeedbackRecord() {
      if (feedbackRecord == null)
         feedbackRecord = new HashSet<FeedbackRecord>();
      return feedbackRecord.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newFeedbackRecord */
   public void setFeedbackRecord(Collection<FeedbackRecord> newFeedbackRecord) {
      removeAllFeedbackRecord();
      for (Iterator iter = newFeedbackRecord.iterator(); iter.hasNext();)
         addFeedbackRecord((FeedbackRecord)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newFeedbackRecord */
   public void addFeedbackRecord(FeedbackRecord newFeedbackRecord) {
      if (newFeedbackRecord == null)
         return;
      if (this.feedbackRecord == null)
         this.feedbackRecord = new HashSet<FeedbackRecord>();
      if (!this.feedbackRecord.contains(newFeedbackRecord))
      {
         this.feedbackRecord.add(newFeedbackRecord);
         newFeedbackRecord.setUserAccount(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldFeedbackRecord */
   public void removeFeedbackRecord(FeedbackRecord oldFeedbackRecord) {
      if (oldFeedbackRecord == null)
         return;
      if (this.feedbackRecord != null)
         if (this.feedbackRecord.contains(oldFeedbackRecord))
         {
            this.feedbackRecord.remove(oldFeedbackRecord);
            oldFeedbackRecord.setUserAccount((UserAccount)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllFeedbackRecord() {
      if (feedbackRecord != null)
      {
         FeedbackRecord oldFeedbackRecord;
         for (Iterator iter = getIteratorFeedbackRecord(); iter.hasNext();)
         {
            oldFeedbackRecord = (FeedbackRecord)iter.next();
            iter.remove();
            oldFeedbackRecord.setUserAccount((UserAccount)null);
         }
      }
   }

}