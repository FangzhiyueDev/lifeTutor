package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  AreaInfo.java
 * Author:  mayn
 * Purpose: Defines the Class AreaInfo
 ***********************************************************************/

import java.util.*;

/** 地区信息 */
public class AreaInfo {
   /** 主键 */
   public long areaId;
   /** 省 */
   public String province;
   /** 市 */
   public String city;
   /** 区 */
   public String district;
   /** 排序 */
   public int sort;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;
   
   public Collection<TrainPointInfo> trainPointInfo;
   
   
   /** @pdGenerated default getter */
   public Collection<TrainPointInfo> getTrainPointInfo() {
      if (trainPointInfo == null)
         trainPointInfo = new HashSet<TrainPointInfo>();
      return trainPointInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorTrainPointInfo() {
      if (trainPointInfo == null)
         trainPointInfo = new HashSet<TrainPointInfo>();
      return trainPointInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTrainPointInfo */
   public void setTrainPointInfo(Collection<TrainPointInfo> newTrainPointInfo) {
      removeAllTrainPointInfo();
      for (Iterator iter = newTrainPointInfo.iterator(); iter.hasNext();)
         addTrainPointInfo((TrainPointInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTrainPointInfo */
   public void addTrainPointInfo(TrainPointInfo newTrainPointInfo) {
      if (newTrainPointInfo == null)
         return;
      if (this.trainPointInfo == null)
         this.trainPointInfo = new HashSet<TrainPointInfo>();
      if (!this.trainPointInfo.contains(newTrainPointInfo))
      {
         this.trainPointInfo.add(newTrainPointInfo);
         newTrainPointInfo.setAreaInfo(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTrainPointInfo */
   public void removeTrainPointInfo(TrainPointInfo oldTrainPointInfo) {
      if (oldTrainPointInfo == null)
         return;
      if (this.trainPointInfo != null)
         if (this.trainPointInfo.contains(oldTrainPointInfo))
         {
            this.trainPointInfo.remove(oldTrainPointInfo);
            oldTrainPointInfo.setAreaInfo((AreaInfo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTrainPointInfo() {
      if (trainPointInfo != null)
      {
         TrainPointInfo oldTrainPointInfo;
         for (Iterator iter = getIteratorTrainPointInfo(); iter.hasNext();)
         {
            oldTrainPointInfo = (TrainPointInfo)iter.next();
            iter.remove();
            oldTrainPointInfo.setAreaInfo((AreaInfo)null);
         }
      }
   }

}