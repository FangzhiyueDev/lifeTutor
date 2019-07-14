package com.rcs.nchumanity.entity.model; /***********************************************************************
 * Module:  OfflineExamRecord.java
 * Author:  mayn
 * Purpose: Defines the Class OfflineExamRecord
 ***********************************************************************/

import java.util.*;

/** 线下考核记录表 */
public class OfflineExamRecord {
   /** 主键 */
   public long examId;
   /** 机器编号 */
   public String machineNo;
   /** 绑定标识 */
   public String bindNo;
   /** 考核时间 */
   public Date examTime;
   /** 得分 */
   public int score;
   /** 考核结果详情 */
   public String detail;
   /** 地点 */
   public String position;
   /** 隐藏 */
   public Boolean isDelete;
   /** 备注 */
   public String remark;
   
   public Collection<UserOfflineExamInfo> userOfflineExamInfo;
   public CourseClassification courseClassification;
   
   
   /** @pdGenerated default getter */
   public Collection<UserOfflineExamInfo> getUserOfflineExamInfo() {
      if (userOfflineExamInfo == null)
         userOfflineExamInfo = new HashSet<UserOfflineExamInfo>();
      return userOfflineExamInfo;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator getIteratorUserOfflineExamInfo() {
      if (userOfflineExamInfo == null)
         userOfflineExamInfo = new HashSet<UserOfflineExamInfo>();
      return userOfflineExamInfo.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUserOfflineExamInfo */
   public void setUserOfflineExamInfo(Collection<UserOfflineExamInfo> newUserOfflineExamInfo) {
      removeAllUserOfflineExamInfo();
      for (Iterator iter = newUserOfflineExamInfo.iterator(); iter.hasNext();)
         addUserOfflineExamInfo((UserOfflineExamInfo)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUserOfflineExamInfo */
   public void addUserOfflineExamInfo(UserOfflineExamInfo newUserOfflineExamInfo) {
      if (newUserOfflineExamInfo == null)
         return;
      if (this.userOfflineExamInfo == null)
         this.userOfflineExamInfo = new HashSet<UserOfflineExamInfo>();
      if (!this.userOfflineExamInfo.contains(newUserOfflineExamInfo))
      {
         this.userOfflineExamInfo.add(newUserOfflineExamInfo);
         newUserOfflineExamInfo.setOfflineExamRecord(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUserOfflineExamInfo */
   public void removeUserOfflineExamInfo(UserOfflineExamInfo oldUserOfflineExamInfo) {
      if (oldUserOfflineExamInfo == null)
         return;
      if (this.userOfflineExamInfo != null)
         if (this.userOfflineExamInfo.contains(oldUserOfflineExamInfo))
         {
            this.userOfflineExamInfo.remove(oldUserOfflineExamInfo);
            oldUserOfflineExamInfo.setOfflineExamRecord((OfflineExamRecord)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUserOfflineExamInfo() {
      if (userOfflineExamInfo != null)
      {
         UserOfflineExamInfo oldUserOfflineExamInfo;
         for (Iterator iter = getIteratorUserOfflineExamInfo(); iter.hasNext();)
         {
            oldUserOfflineExamInfo = (UserOfflineExamInfo)iter.next();
            iter.remove();
            oldUserOfflineExamInfo.setOfflineExamRecord((OfflineExamRecord)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public CourseClassification getCourseClassification() {
      return courseClassification;
   }
   
   /** @pdGenerated default parent setter
     * @param newCourseClassification */
   public void setCourseClassification(CourseClassification newCourseClassification) {
      if (this.courseClassification == null || !this.courseClassification.equals(newCourseClassification))
      {
         if (this.courseClassification != null)
         {
            CourseClassification oldCourseClassification = this.courseClassification;
            this.courseClassification = null;
            oldCourseClassification.removeOfflineExamRecord(this);
         }
         if (newCourseClassification != null)
         {
            this.courseClassification = newCourseClassification;
            this.courseClassification.addOfflineExamRecord(this);
         }
      }
   }

}