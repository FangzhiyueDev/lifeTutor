package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  TrainPointInfo.java
 * Author:  mayn
 * Purpose: Defines the Class TrainPointInfo
 ***********************************************************************/

import java.util.*;

/** 培训点信息 */
public class TrainPointInfo {
   /** 主键 */
   public long pointId;
   /** 名称 */
   public String name;
   /** 地点 */
   public String position;
   /** 经度 */
   public float longitude;
   /** 纬度 */
   public float latitude;
   /** 半径 */
   public float radius;
   /** 是否VR */
   public Boolean isVr;
   /** 是否临时 */
   public Boolean isTemp;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;
   
   public Collection<OfflineTrainClass> offlineTrainClass;
   public Collection<TrainerInfo> trainerInfo;
   public Collection<TrainingRoomEnterRecord> trainingRoomEnterRecord;
   public AdminAccount adminAccount;
   public AreaInfo areaInfo;
   
   
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
         newOfflineTrainClass.setTrainPointInfo(this);      
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
            oldOfflineTrainClass.setTrainPointInfo((TrainPointInfo)null);
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
            oldOfflineTrainClass.setTrainPointInfo((TrainPointInfo)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<TrainerInfo> getTrainerInfo() {
      if (trainerInfo == null)
         trainerInfo = new HashSet<TrainerInfo>();
      return trainerInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorTrainerInfo() {
      if (trainerInfo == null)
         trainerInfo = new HashSet<TrainerInfo>();
      return trainerInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTrainerInfo */
   public void setTrainerInfo(Collection<TrainerInfo> newTrainerInfo) {
      removeAllTrainerInfo();
      for (Iterator iter = newTrainerInfo.iterator(); iter.hasNext();)
         addTrainerInfo((TrainerInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTrainerInfo */
   public void addTrainerInfo(TrainerInfo newTrainerInfo) {
      if (newTrainerInfo == null)
         return;
      if (this.trainerInfo == null)
         this.trainerInfo = new HashSet<TrainerInfo>();
      if (!this.trainerInfo.contains(newTrainerInfo))
      {
         this.trainerInfo.add(newTrainerInfo);
         newTrainerInfo.setTrainPointInfo(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTrainerInfo */
   public void removeTrainerInfo(TrainerInfo oldTrainerInfo) {
      if (oldTrainerInfo == null)
         return;
      if (this.trainerInfo != null)
         if (this.trainerInfo.contains(oldTrainerInfo))
         {
            this.trainerInfo.remove(oldTrainerInfo);
            oldTrainerInfo.setTrainPointInfo((TrainPointInfo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTrainerInfo() {
      if (trainerInfo != null)
      {
         TrainerInfo oldTrainerInfo;
         for (Iterator iter = getIteratorTrainerInfo(); iter.hasNext();)
         {
            oldTrainerInfo = (TrainerInfo)iter.next();
            iter.remove();
            oldTrainerInfo.setTrainPointInfo((TrainPointInfo)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public Collection<TrainingRoomEnterRecord> getTrainingRoomEnterRecord() {
      if (trainingRoomEnterRecord == null)
         trainingRoomEnterRecord = new HashSet<TrainingRoomEnterRecord>();
      return trainingRoomEnterRecord;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorTrainingRoomEnterRecord() {
      if (trainingRoomEnterRecord == null)
         trainingRoomEnterRecord = new HashSet<TrainingRoomEnterRecord>();
      return trainingRoomEnterRecord.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTrainingRoomEnterRecord */
   public void setTrainingRoomEnterRecord(Collection<TrainingRoomEnterRecord> newTrainingRoomEnterRecord) {
      removeAllTrainingRoomEnterRecord();
      for (Iterator iter = newTrainingRoomEnterRecord.iterator(); iter.hasNext();)
         addTrainingRoomEnterRecord((TrainingRoomEnterRecord)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTrainingRoomEnterRecord */
   public void addTrainingRoomEnterRecord(TrainingRoomEnterRecord newTrainingRoomEnterRecord) {
      if (newTrainingRoomEnterRecord == null)
         return;
      if (this.trainingRoomEnterRecord == null)
         this.trainingRoomEnterRecord = new HashSet<TrainingRoomEnterRecord>();
      if (!this.trainingRoomEnterRecord.contains(newTrainingRoomEnterRecord))
      {
         this.trainingRoomEnterRecord.add(newTrainingRoomEnterRecord);
         newTrainingRoomEnterRecord.setTrainPointInfo(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldTrainingRoomEnterRecord */
   public void removeTrainingRoomEnterRecord(TrainingRoomEnterRecord oldTrainingRoomEnterRecord) {
      if (oldTrainingRoomEnterRecord == null)
         return;
      if (this.trainingRoomEnterRecord != null)
         if (this.trainingRoomEnterRecord.contains(oldTrainingRoomEnterRecord))
         {
            this.trainingRoomEnterRecord.remove(oldTrainingRoomEnterRecord);
            oldTrainingRoomEnterRecord.setTrainPointInfo((TrainPointInfo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTrainingRoomEnterRecord() {
      if (trainingRoomEnterRecord != null)
      {
         TrainingRoomEnterRecord oldTrainingRoomEnterRecord;
         for (Iterator iter = getIteratorTrainingRoomEnterRecord(); iter.hasNext();)
         {
            oldTrainingRoomEnterRecord = (TrainingRoomEnterRecord)iter.next();
            iter.remove();
            oldTrainingRoomEnterRecord.setTrainPointInfo((TrainPointInfo)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public AdminAccount getAdminAccount() {
      return adminAccount;
   }
   
   /** @pdGenerated default parent setter
     * @param newAdminAccount */
   public void setAdminAccount(AdminAccount newAdminAccount) {
      if (this.adminAccount == null || !this.adminAccount.equals(newAdminAccount))
      {
         if (this.adminAccount != null)
         {
            AdminAccount oldAdminAccount = this.adminAccount;
            this.adminAccount = null;
            oldAdminAccount.removeTrainPointInfo(this);
         }
         if (newAdminAccount != null)
         {
            this.adminAccount = newAdminAccount;
            this.adminAccount.addTrainPointInfo(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public AreaInfo getAreaInfo() {
      return areaInfo;
   }
   
   /** @pdGenerated default parent setter
     * @param newAreaInfo */
   public void setAreaInfo(AreaInfo newAreaInfo) {
      if (this.areaInfo == null || !this.areaInfo.equals(newAreaInfo))
      {
         if (this.areaInfo != null)
         {
            AreaInfo oldAreaInfo = this.areaInfo;
            this.areaInfo = null;
            oldAreaInfo.removeTrainPointInfo(this);
         }
         if (newAreaInfo != null)
         {
            this.areaInfo = newAreaInfo;
            this.areaInfo.addTrainPointInfo(this);
         }
      }
   }

}