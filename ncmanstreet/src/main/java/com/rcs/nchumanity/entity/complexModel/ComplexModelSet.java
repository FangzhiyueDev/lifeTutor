package com.rcs.nchumanity.entity.complexModel;

import com.rcs.nchumanity.entity.model.SpecificInfo;
import com.rcs.nchumanity.entity.model.SpecificInfoClassification;

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


}
