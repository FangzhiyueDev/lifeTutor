package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  AedDistributionInfo.java
 * Author:  mayn
 * Purpose: Defines the Class AedDistributionInfo
 ***********************************************************************/

import java.util.*;

/** AED分布信息 */
public class AedDistributionInfo {
   /** 主键 */
   public long id;
   /** 经度 */
   public float longitude;
   /** 纬度 */
   public float latitude;
   /** 详细信息 */
   public String detail;
   /** 隐藏 */
   public byte isDelete;
   /** 备注 */
   public String remark;

}