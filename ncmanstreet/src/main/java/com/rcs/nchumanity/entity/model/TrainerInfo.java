package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  TrainerInfo.java
 * Author:  mayn
 * Purpose: Defines the Class TrainerInfo
 ***********************************************************************/

import java.util.*;

/** 培训员信息 */
public class TrainerInfo {
   /** 主键 */
   public long trainerId;
   /** 姓名 */
   public String name;
   /** 隐藏 */
   public byte isDelete;
   /** 备注 */
   public String remark;
   
   public Collection<OfflineTrainClass> offlineTrainClass;
   public TrainPointInfo trainPointInfo;
   
   
   /** @pdGenerated default getter */
   public Collection<OfflineTrainClass> getOfflineTrainClass() {
      if (offlineTrainClass == null)
         offlineTrainClass = new HashSet<OfflineTrainClass>();
      return offlineTrainClass;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorOfflineTrainClass() {
      if (offlineTrainClass == null)
         offlineTrainClass = new HashSet<OfflineTrainClass>();
      return offlineTrainClass.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOfflineTrainClass */
   public void setOfflineTrainClass(Collection<OfflineTrainClass> newOfflineTrainClass) {
      removeAllOfflineTrainClass();
      for (Iterator iter = newOfflineTrainClass.iterator(); iter.hasNext();)
         addOfflineTrainClass((OfflineTrainClass)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOfflineTrainClass */
   public void addOfflineTrainClass(OfflineTrainClass newOfflineTrainClass) {
      if (newOfflineTrainClass == null)
         return;
      if (this.offlineTrainClass == null)
         this.offlineTrainClass = new HashSet<OfflineTrainClass>();
      if (!this.offlineTrainClass.contains(newOfflineTrainClass))
      {
         this.offlineTrainClass.add(newOfflineTrainClass);
         newOfflineTrainClass.setTrainerInfo(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldOfflineTrainClass */
   public void removeOfflineTrainClass(OfflineTrainClass oldOfflineTrainClass) {
      if (oldOfflineTrainClass == null)
         return;
      if (this.offlineTrainClass != null)
         if (this.offlineTrainClass.contains(oldOfflineTrainClass))
         {
            this.offlineTrainClass.remove(oldOfflineTrainClass);
            oldOfflineTrainClass.setTrainerInfo((TrainerInfo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOfflineTrainClass() {
      if (offlineTrainClass != null)
      {
         OfflineTrainClass oldOfflineTrainClass;
         for (Iterator iter = getIteratorOfflineTrainClass(); iter.hasNext();)
         {
            oldOfflineTrainClass = (OfflineTrainClass)iter.next();
            iter.remove();
            oldOfflineTrainClass.setTrainerInfo((TrainerInfo)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TrainPointInfo getTrainPointInfo() {
      return trainPointInfo;
   }
   
   /** @pdGenerated default parent setter
     * @param newTrainPointInfo */
   public void setTrainPointInfo(TrainPointInfo newTrainPointInfo) {
      if (this.trainPointInfo == null || !this.trainPointInfo.equals(newTrainPointInfo))
      {
         if (this.trainPointInfo != null)
         {
            TrainPointInfo oldTrainPointInfo = this.trainPointInfo;
            this.trainPointInfo = null;
            oldTrainPointInfo.removeTrainerInfo(this);
         }
         if (newTrainPointInfo != null)
         {
            this.trainPointInfo = newTrainPointInfo;
            this.trainPointInfo.addTrainerInfo(this);
         }
      }
   }

}