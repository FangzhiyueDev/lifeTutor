package com.rcs.nchumanity.ul.detail;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.complexModel.ComplexModelSet;
import com.rcs.nchumanity.entity.model.OnlineCourseInfo;
import com.rcs.nchumanity.tool.StringTool;

import java.util.ArrayList;

/**
 * 课程信息详情Activity
 * 需要传递
 * #{{@link ComplexModelSet.M_speinf_speinfCla}}过来
 * 这样我们就能拿到 对应的课程想关的信息
 * <p>
 * 子类继承通过传递网络加载不同的数据  选修
 * <p>
 * 这个类可以用于基本的选修的实现
 */
public class ElectiveCourseInfoComplexDetailActivity extends ComplexDetailActivity<ComplexModelSet.M_onlCour_courCla> {



    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_complex_detail;
    }

    @Override
    protected Class<?> getInfoClass() {
        return info.getClass();
    }


    @Override
    protected void bindView(View view, ComplexModelSet.M_onlCour_courCla obj) {

        /**
         * 设置标题
         */
        TextView barTitle = view.findViewById(R.id.barTitle);

        barTitle.setText(obj.classification.getCourseName());

        OnlineCourseInfo onlineCourseInfo = new ArrayList<>(obj.onlineCourseInfos).get(0);

        if (onlineCourseInfo == null) {
            return;
        }

        /**
         * 设置图片的显示，因为图片的显示
         *
         *   <ImageView
         *                     android:layout_width="match_parent"
         *                     android:layout_height="wrap_content"
         *                     android:scaleType="centerCrop"
         *                     android:src="@drawable/banner1" />
         *
         *                     被添加到R.id.imgArea 下面
         *
         */

        ViewGroup imgArea = view.findViewById(R.id.imgArea);

        for (String url : onlineCourseInfo.getImgUrl().split(StringTool.DELIMITER)) {

            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(this).load(url).into(imageView);
            imgArea.addView(imageView);
        }


        /**
         * 设置视频的播放地址
         */
        if (!TextUtils.isEmpty(onlineCourseInfo.getVideoUrl())) {
            videoPlayFragment.setUrl(onlineCourseInfo.getVideoUrl());
        } else {
            videoPlayFragment.setVisiblity(View.GONE);
        }


        if (!TextUtils.isEmpty(onlineCourseInfo.getWriting())) {
            TextView content = view.findViewById(R.id.content);
            content.setText(onlineCourseInfo.getWriting());
        }
    }

}
