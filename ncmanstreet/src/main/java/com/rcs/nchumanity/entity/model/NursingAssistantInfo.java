package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  NursingAssistantInfo.java
 * Author:  mayn
 * Purpose: Defines the Class NursingAssistantInfo
 ***********************************************************************/

import java.util.*;

/** 护理员信息 */
public class NursingAssistantInfo {
   /** 主键 */
   public long id;
   /** 视频Id */
   public String videoId;
   /** 视频地址 */
   public String videoUrl;
   /** 图片地址 */
   public String imgUrl;
   /** 文本 */
   public String writing;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;

}