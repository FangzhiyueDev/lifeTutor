package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  AdminAccount.java
 * Author:  mayn
 * Purpose: Defines the Class AdminAccount
 ***********************************************************************/

import java.util.*;

/** 管理系统登录账户信息 */
public class AdminAccount {
   /** 主键 */
   public long adminId;
   /** 账户名 */
   public String adminName;
   /** 密码 */
   public String password;
   /** 手机号 */
   public String phone;
   /** 可用性 */
   public byte available;
   /** 姓名 */
   public String name;
   /** 账户类型 */
   public int type;
   /** 隐藏 */
   public byte isDelete;
   /** 备注 */
   public String remark;
   
   public Collection<TrainPointInfo> trainPointInfo;
   public Collection<FeedbackRecord> feedbackRecord;
   
   
   /** @pdGenerated default getter */
   public Collection<TrainPointInfo> getTrainPointInfo() {
      if (trainPointInfo == null)
         trainPointInfo = new HashSet<TrainPointInfo>();
      return trainPointInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorTrainPointInfo() {
      if (trainPointInfo == null)
         trainPointInfo = new HashSet<TrainPointInfo>();
      return trainPointInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTrainPointInfo */
   public void setTrainPointInfo(Collection<TrainPointInfo> newTrainPointInfo) {
      removeAllTrainPointInfo();
      for (Iterator iter = newTrainPointInfo.iterator(); iter.hasNext();)
         addTrainPointInfo((TrainPointInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTrainPointInfo */
   public void addTrainPointInfo(TrainPointInfo newTrainPointInfo) {
      if (newTrainPointInfo == null)
         return;
      if (this.trainPointInfo == null)
         this.trainPointInfo = new HashSet<TrainPointInfo>();
      if (!this.trainPointInfo.contains(newTrainPointInfo))
      {
         this.trainPointInfo.add(newTrainPointInfo);
         newTrainPointInfo.setAdminAccount(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTrainPointInfo */
   public void removeTrainPointInfo(TrainPointInfo oldTrainPointInfo) {
      if (oldTrainPointInfo == null)
         return;
      if (this.trainPointInfo != null)
         if (this.trainPointInfo.contains(oldTrainPointInfo))
         {
            this.trainPointInfo.remove(oldTrainPointInfo);
            oldTrainPointInfo.setAdminAccount((AdminAccount)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTrainPointInfo() {
      if (trainPointInfo != null)
      {
         TrainPointInfo oldTrainPointInfo;
         for (Iterator iter = getIteratorTrainPointInfo(); iter.hasNext();)
         {
            oldTrainPointInfo = (TrainPointInfo)iter.next();
            iter.remove();
            oldTrainPointInfo.setAdminAccount((AdminAccount)null);
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
         newFeedbackRecord.setAdminAccount(this);      
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
            oldFeedbackRecord.setAdminAccount((AdminAccount)null);
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
            oldFeedbackRecord.setAdminAccount((AdminAccount)null);
         }
      }
   }

}