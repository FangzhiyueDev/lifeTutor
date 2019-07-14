package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  SpecificInfoClassification.java
 * Author:  mayn
 * Purpose: Defines the Class SpecificInfoClassification
 ***********************************************************************/

import java.util.*;

/** 特定信息分类表 */
public class SpecificInfoClassification {
   /** 主键 */
   public long typeId;
   /** 分类标题 */
   public String title;
   /** 父类 */
   public String parent;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;
   
   public Collection<SpecificInfo> specificInfo;
   
   
   /** @pdGenerated default getter */
   public Collection<SpecificInfo> getSpecificInfo() {
      if (specificInfo == null)
         specificInfo = new HashSet<SpecificInfo>();
      return specificInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorSpecificInfo() {
      if (specificInfo == null)
         specificInfo = new HashSet<SpecificInfo>();
      return specificInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSpecificInfo */
   public void setSpecificInfo(Collection<SpecificInfo> newSpecificInfo) {
      removeAllSpecificInfo();
      for (Iterator iter = newSpecificInfo.iterator(); iter.hasNext();)
         addSpecificInfo((SpecificInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSpecificInfo */
   public void addSpecificInfo(SpecificInfo newSpecificInfo) {
      if (newSpecificInfo == null)
         return;
      if (this.specificInfo == null)
         this.specificInfo = new HashSet<SpecificInfo>();
      if (!this.specificInfo.contains(newSpecificInfo))
      {
         this.specificInfo.add(newSpecificInfo);
         newSpecificInfo.setSpecificInfoClassification(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldSpecificInfo */
   public void removeSpecificInfo(SpecificInfo oldSpecificInfo) {
      if (oldSpecificInfo == null)
         return;
      if (this.specificInfo != null)
         if (this.specificInfo.contains(oldSpecificInfo))
         {
            this.specificInfo.remove(oldSpecificInfo);
            oldSpecificInfo.setSpecificInfoClassification((SpecificInfoClassification)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSpecificInfo() {
      if (specificInfo != null)
      {
         SpecificInfo oldSpecificInfo;
         for (Iterator iter = getIteratorSpecificInfo(); iter.hasNext();)
         {
            oldSpecificInfo = (SpecificInfo)iter.next();
            iter.remove();
            oldSpecificInfo.setSpecificInfoClassification((SpecificInfoClassification)null);
         }
      }
   }

}