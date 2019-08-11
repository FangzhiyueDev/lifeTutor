package com.rcs.nchumanity.ul.detail;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.model.SpecificInfo;
import com.rcs.nchumanity.tool.StringTool;

/**
 * 特定信息记录
 * <p>
 * 特定信息记录存在两种格式 ，
 * 1.视频等的详情信息的显示，  为了实现对视频功能的简化  ，我们将对视频的相关的代码封装到Fragment中，实现代码的抽离
 * 2.地图显示点的位置
 */
public class SpecificInfoComplexListDetailActivity extends ComplexDetailActivity<SpecificInfo> {


    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_complex_detail;
    }


    /**
     * 用来实现的功能是数据的绑定
     *
     * @param view
     * @param specificInfo
     */
    @Override
    protected void bindView(View view, SpecificInfo specificInfo) {

        /**
         * 设置标题
         */
        TextView barTitle = view.findViewById(R.id.barTitle);

        barTitle.setText(specificInfo.getTitle());


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

        for (String url : specificInfo.getImgUrl().split(StringTool.DELIMITER)) {

            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(this).load(url).into(imageView);
            imgArea.addView(imageView);
        }

        /**
         * 设置视频的播放地址
         */
        if (!TextUtils.isEmpty(specificInfo.getVideoUrl())) {
            videoPlayFragment.setUrl(specificInfo.getVideoUrl());
        } else {
            videoPlayFragment.setVisiblity(View.GONE);
        }

        if (!TextUtils.isEmpty(specificInfo.getContent())) {
            TextView content = view.findViewById(R.id.content);
            content.setText(specificInfo.getContent());
        }
    }
}
