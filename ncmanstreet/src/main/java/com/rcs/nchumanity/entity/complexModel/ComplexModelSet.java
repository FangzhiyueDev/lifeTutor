package com.rcs.nchumanity.entity.complexModel;

import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.model.CourseClassification;
import com.rcs.nchumanity.entity.model.OnlineCourseInfo;
import com.rcs.nchumanity.entity.model.SpecificInfo;
import com.rcs.nchumanity.entity.model.SpecificInfoClassification;
import com.rcs.nchumanity.entity.model.UserAccount;
import com.rcs.nchumanity.entity.model.UserOnlineStudyRecord;

import java.util.List;

/**
 * 这个表存放的是复合的数据的模型数据
 * 用来实现当一个表无法实现数据展示的情况下，进行的多表相连
 */
public class ComplexModelSet {

    /**
     * 关联的是 特定信息记录表和 特定信息分类表 specific_info_classification
     * 由于关系是一对多
     */
    public static class M_speinf_speinfCla {

        public SpecificInfoClassification specificInfoClassification;

        public List<SpecificInfo> specificInfos;

        public M_speinf_speinfCla(SpecificInfoClassification specificInfoClassification, List<SpecificInfo> specificInfos) {
            this.specificInfoClassification = specificInfoClassification;
            this.specificInfos = specificInfos;
        }
    }


    /**
     * 关联的是 在线课程分类信息 和 在线课程内容信息表
     * curse_classification 和  online_course_classification
     * 关系为
     */
    public static class M_onlCour_courCla {
        public CourseClassification classification;
        public List<OnlineCourseInfo> onlineCourseInfos;

        public M_onlCour_courCla(CourseClassification classification, List<OnlineCourseInfo> onlineCourseInfos) {
            this.classification = classification;
            this.onlineCourseInfos = onlineCourseInfos;
        }
    }

    /**
     * 返回的注册的接口
     * 如果注册成功的话，返回注册的basicResponse和用户信息
     */
    public static class M_basResp_useAcc {
        public BasicResponse basicResponse;
        public UserAccount userAccount;

        public M_basResp_useAcc(BasicResponse basicResponse, UserAccount userAccount) {
            this.basicResponse = basicResponse;
            this.userAccount = userAccount;
        }
    }

    /**
     * 用户线上学习记录表和课程分类表的连接
     * 用于实现的功能是连接查询  ，
     * 两者的表关系为 一对多的关系
     */
    public static class M_courCla_onliStudReco {

        public CourseClassification classification;
        public List<UserOnlineStudyRecord> records;

        public M_courCla_onliStudReco(CourseClassification classification, List<UserOnlineStudyRecord> records) {
            this.classification = classification;
            this.records = records;
        }
    }


}
