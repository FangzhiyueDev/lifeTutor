package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  SpecificPicture.java
 * Author:  mayn
 * Purpose: Defines the Class SpecificPicture
 ***********************************************************************/

import java.util.*;

/** 特定图片信息 */
public class SpecificPicture {
   /** 主键 */
   public long id;
   /** 特定编号 */
   public int specificNo;
   /** 标题 */
   public String title;
   /** 地址 */
   public String url;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;

}