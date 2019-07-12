package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  UserOfflineStudyRecord.java
 * Author:  mayn
 * Purpose: Defines the Class UserOfflineStudyRecord
 ***********************************************************************/

import java.util.*;

/** 用户线下学习记录信息表 */
public class UserOfflineStudyRecord {
   /** 主键 */
   public long id;
   /** 签到时间 */
   public Date startTime;
   /** 签退时间 */
   public Date endTime;
   /** 隐藏 */
   public byte isDelete;
   /** 备注 */
   public String remark;
   
   public UserTrainRecord userTrainRecord;
   public OfflineTrainClass offlineTrainClass;
   
   
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
            oldUserTrainRecord.removeUserOfflineStudyRecord(this);
         }
         if (newUserTrainRecord != null)
         {
            this.userTrainRecord = newUserTrainRecord;
            this.userTrainRecord.addUserOfflineStudyRecord(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public OfflineTrainClass getOfflineTrainClass() {
      return offlineTrainClass;
   }
   
   /** @pdGenerated default parent setter
     * @param newOfflineTrainClass */
   public void setOfflineTrainClass(OfflineTrainClass newOfflineTrainClass) {
      if (this.offlineTrainClass == null || !this.offlineTrainClass.equals(newOfflineTrainClass))
      {
         if (this.offlineTrainClass != null)
         {
            OfflineTrainClass oldOfflineTrainClass = this.offlineTrainClass;
            this.offlineTrainClass = null;
            oldOfflineTrainClass.removeUserOfflineStudyRecord(this);
         }
         if (newOfflineTrainClass != null)
         {
            this.offlineTrainClass = newOfflineTrainClass;
            this.offlineTrainClass.addUserOfflineStudyRecord(this);
         }
      }
   }

}