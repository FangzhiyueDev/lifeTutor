package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  UserFirstAiderCertificate.java
 * Author:  mayn
 * Purpose: Defines the Class UserFirstAiderCertificate
 ***********************************************************************/

import java.util.*;

/** 用户救护员证书信息表 */
public class UserFirstAiderCertificate {
   /** 主键 */
   public long id;
   /** 签发日期 */
   public String dateOfIssue;
   /** 签发机关 */
   public String issuedBy;
   /** 邮寄状态 */
   public int postStatus;
   /** 创建时间 */
   public Date createTime;
   /** 过期时间 */
   public Date endTime;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;
   
   public UserAccount userAccount;
   
   
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
            oldUserAccount.removeUserFirstAiderCertificate(this);
         }
         if (newUserAccount != null)
         {
            this.userAccount = newUserAccount;
            this.userAccount.addUserFirstAiderCertificate(this);
         }
      }
   }

}