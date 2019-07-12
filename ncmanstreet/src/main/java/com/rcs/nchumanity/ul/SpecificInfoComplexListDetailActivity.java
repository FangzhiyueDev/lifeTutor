package com.rcs.nchumanity.ul;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.adapter.ListViewCommonsAdapter;
import com.rcs.nchumanity.entity.model.SpecificInfo;
import com.rcs.nchumanity.tool.StringTool;

import java.util.ArrayList;


public class SpecificInfoComplexListDetailActivity extends ComplexListDetailActivity<SpecificInfo> {


    @Override
    protected Class<?> getInfoClass() {
        return info.getClass();
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

        barTitle.setText(specificInfo.title);

        /**
         * 设置视频。如果没有的情况下，就去隐藏视频控件的显示
         */

        VideoView videoView = view.findViewById(R.id.video);


        if (TextUtils.isEmpty(specificInfo.imgUrl)) {
            videoView.setVisibility(View.GONE);
        } else {
            /**
             * 解析出视频，这段代码可能会被修改，原因是对video的控制可能会被抽取成一个类
             * 同时，涉及到本地缓存的问题，部分的视频可能会被先缓存到本地去
             * 应该先要去解析本地的数据，不存在的情况下，才去服务器上面拉取数据
             *
             */
            videoView.setVideoURI(Uri.parse(specificInfo.videoUrl));
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

        for (String url : specificInfo.imgUrl.split(StringTool.DELIMITER)) {

            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(this).load(url).into(imageView);
            imgArea.addView(imageView);
        }

        if (!TextUtils.isEmpty(specificInfo.content)) {
            TextView content = view.findViewById(R.id.content);
            content.setText(specificInfo.content);
        }
    }
}
