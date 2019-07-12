package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  PushInfo.java
 * Author:  mayn
 * Purpose: Defines the Class PushInfo
 ***********************************************************************/

import java.util.*;

/** 急救信息推送记录 */
public class PushInfo {
   /** 主键 */
   public long id;
   /** 创建时间 */
   public Date createTime;
   /** 标题 */
   public String title;
   /** 内容 */
   public String content;
   /** 已读次数 */
   public int readCount;
   /** 隐藏 */
   public byte isDelete;
   /** 备注 */
   public String remark;

}