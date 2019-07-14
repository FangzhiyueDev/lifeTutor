package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  FeedbackRecord.java
 * Author:  mayn
 * Purpose: Defines the Class FeedbackRecord
 ***********************************************************************/

import java.util.*;

/** 留言反馈信息 */
public class FeedbackRecord {
   /** 主键 */
   public long id;
   /** 留言 */
   public String message;
   /** 留言时间 */
   public Date createTime;
   /** 回复 */
   public String reply;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;
   
   public UserAccount userAccount;
   public AdminAccount adminAccount;
   
   
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
            oldUserAccount.removeFeedbackRecord(this);
         }
         if (newUserAccount != null)
         {
            this.userAccount = newUserAccount;
            this.userAccount.addFeedbackRecord(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public AdminAccount getAdminAccount() {
      return adminAccount;
   }
   
   /** @pdGenerated default parent setter
     * @param newAdminAccount */
   public void setAdminAccount(AdminAccount newAdminAccount) {
      if (this.adminAccount == null || !this.adminAccount.equals(newAdminAccount))
      {
         if (this.adminAccount != null)
         {
            AdminAccount oldAdminAccount = this.adminAccount;
            this.adminAccount = null;
            oldAdminAccount.removeFeedbackRecord(this);
         }
         if (newAdminAccount != null)
         {
            this.adminAccount = newAdminAccount;
            this.adminAccount.addFeedbackRecord(this);
         }
      }
   }

}