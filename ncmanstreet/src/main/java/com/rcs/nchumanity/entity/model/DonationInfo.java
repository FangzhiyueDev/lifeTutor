package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  DonationInfo.java
 * Author:  mayn
 * Purpose: Defines the Class DonationInfo
 ***********************************************************************/

import java.util.*;

/** 捐款捐献信息 */
public class DonationInfo {
   /** 主键 */
   public long id;
   /** 类型 */
   public Boolean type;
   /** 经度 */
   public float longitude;
   /** 纬度 */
   public float latitude;
   /** 详细信息 */
   public String detail;
   /** 图片 */
   public String imgUrl;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;

}