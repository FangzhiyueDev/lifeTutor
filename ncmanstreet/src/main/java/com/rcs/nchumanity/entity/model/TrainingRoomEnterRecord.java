package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  TrainingRoomEnterRecord.java
 * Author:  mayn
 * Purpose: Defines the Class TrainingRoomEnterRecord
 ***********************************************************************/

import java.util.*;

/** 培训房进入记录表 */
public class TrainingRoomEnterRecord {
   /** 主键 */
   public long id;
   /** 身份证号 */
   public String idNumber;
   /** 进入时间 */
   public Date enterTime;
   /** 隐藏 */
   public byte isDelete;
   /** 备注 */
   public String remark;
   
   public UserAccount userAccount;
   public TrainPointInfo trainPointInfo;
   
   
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
            oldUserAccount.removeTrainingRoomEnterRecord(this);
         }
         if (newUserAccount != null)
         {
            this.userAccount = newUserAccount;
            this.userAccount.addTrainingRoomEnterRecord(this);
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
            oldTrainPointInfo.removeTrainingRoomEnterRecord(this);
         }
         if (newTrainPointInfo != null)
         {
            this.trainPointInfo = newTrainPointInfo;
            this.trainPointInfo.addTrainingRoomEnterRecord(this);
         }
      }
   }

}