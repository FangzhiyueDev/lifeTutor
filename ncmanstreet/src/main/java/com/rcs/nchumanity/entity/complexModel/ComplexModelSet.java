package com.rcs.nchumanity.entity.complexModel;

import com.rcs.nchumanity.entity.model.OnlineCourseInfo;
import com.rcs.nchumanity.entity.model.OnlineCourseInfoExample;
import com.rcs.nchumanity.entity.model.OnlineExamQuestion;
import com.rcs.nchumanity.entity.model.SpecificInfo;
import com.rcs.nchumanity.entity.model.SpecificInfoClassification;
import com.rcs.nchumanity.entity.model.SpecificPicture;
import com.rcs.nchumanity.entity.model.UserOnlineStudyRecord;
import com.rcs.nchumanity.entity.model.train.CourseClassification;

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
     * 课程映射多条学习记录
     */
    public static class M_couClas_usOnStuRec {

        public CourseClassification classification;

        public List<UserOnlineStudyRecord> records;

        public M_couClas_usOnStuRec(CourseClassification classification, List<UserOnlineStudyRecord> records) {
            this.classification = classification;
            this.records = records;
        }
    }


    /**
     * 首页数据的信息封装
     * <p>
     * 包括了3-5个banner列表 存放在@{{@link com.rcs.nchumanity.entity.model.SpecificPicture}}表中
     * 包括了特定信息分类 查询的是父类为<span>培训相关</span>和<span>捐款捐献</span>  存放在@{{@link SpecificInfoClassification}}表中
     * 包括了 特定信息分类，以及信息分类对应的特定信息记录表（1--->多） 查询的是<span>认识红十字</span>和<span>资讯</span>的各3条数据
     *
     * 更多的参数设置，请参考
     *
     *
     *
     */
    public static class M_IndexPageInfo {

        /**
         * 存放的是Banner的img的包装
         */
        public List<SpecificPicture> banners;
        /**
         * 存放的是主页的各个分类的数据
         * 类中的remark属性存放的是图片的url
         * <p>
         * 需要的元素字段 1.typeId，title ,remark
         */
        public List<SpecificInfoClassification> modules;

        /**
         * 存放的是特定信息分类，以及分类的相关 特定信息记录 加载所有数据
         */
        public List<M_speinf_speinfCla> news;
    }


    /**
     * 在线视频课程以及对应的试题的相关的内容
     */
    public static class M__speinf_speinfCla_onLiExamQues {
        M_speinf_speinfCla m_speinf_speinfCla;
        List<OnlineExamQuestion> examQuestions;
    }


}
