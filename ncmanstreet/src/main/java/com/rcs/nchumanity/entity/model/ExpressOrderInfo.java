package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  ExpressOrderInfo.java
 * Author:  mayn
 * Purpose: Defines the Class ExpressOrderInfo
 ***********************************************************************/

import java.util.*;

/** 邮寄下单信息表 */
public class ExpressOrderInfo {
   /** 主键 */
   public long id;
   /** 姓名 */
   public String name;
   /** 电话 */
   public String mobilephone;
   /** 地址 */
   public String address;
   /** 快递单号 */
   public String expressNo;
   /** 快递公司 */
   public String expressCompany;
   /** 邮寄状态 */
   public int expressStatus;
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
            oldUserAccount.removeExpressOrderInfo(this);
         }
         if (newUserAccount != null)
         {
            this.userAccount = newUserAccount;
            this.userAccount.addExpressOrderInfo(this);
         }
      }
   }

}