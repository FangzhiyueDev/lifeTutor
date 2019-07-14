package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  UserOnlineExamInfo.java
 * Author:  mayn
 * Purpose: Defines the Class UserOnlineExamInfo
 ***********************************************************************/

import java.util.*;

/** 用户线上考核记录信息表 */
public class UserOnlineExamInfo {
   /** 主键 */
   public long id;
   /** 考核时间 */
   public Date examTime;
   /** 得分 */
   public int score;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;
   
   public UserTrainRecord userTrainRecord;
   
   
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
            oldUserTrainRecord.removeUserOnlineExamInfo(this);
         }
         if (newUserTrainRecord != null)
         {
            this.userTrainRecord = newUserTrainRecord;
            this.userTrainRecord.addUserOnlineExamInfo(this);
         }
      }
   }

}