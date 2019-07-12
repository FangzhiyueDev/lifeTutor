package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  UserBasicInfo.java
 * Author:  mayn
 * Purpose: Defines the Class UserBasicInfo
 ***********************************************************************/

import java.util.*;

/** 用户个人基本信息表 */
public class UserBasicInfo {
   /** 姓名 */
   public String name;
   /** 性别 */
   public String gender;
   /** 工作单位 */
   public String employer;
   /** 身份证号 */
   public String idNumber;
   /** 救护员证编号 */
   public String licenseNo;
   /** 照片Url */
   public String photoUrl;
   /** 训练状态 */
   public int trainStatus;
   /** 证书过期时间 */
   public Date overdueTime;
   /** 文化程度 */
   public String degreeOfEducation;
   /** 工作年限 */
   public String yearsOfWorking;
   /** 签发日期 */
   public String signDate;
   /** 职称职务 */
   public String duty;
   /** 家庭住址 */
   public String address;
   /** 隐藏 */
   public byte isDelete;
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
            oldUserAccount.removeUserBasicInfo(this);
         }
         if (newUserAccount != null)
         {
            this.userAccount = newUserAccount;
            this.userAccount.addUserBasicInfo(this);
         }
      }
   }

}