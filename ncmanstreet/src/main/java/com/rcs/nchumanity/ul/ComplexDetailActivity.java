package com.rcs.nchumanity.ul;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.model.SpecificInfo;

/**
 * 这个界面是用来实现复合列表的详细信息界面
 * <p>
 * 对于
 */
public abstract class ComplexDetailActivity<T> extends ParentActivity {


    private View rootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(rootView = LayoutInflater.from(this).inflate(R.layout.activity_complex_detail, null));
        bundleData();
    }

    protected T info;

    private void bundleData() {
        info = (T) getIntent().getBundleExtra(Bundle.class.getSimpleName()).getSerializable(getInfoClass().getSimpleName());
        if (info == null) {
            throw new RuntimeException("bundle的数据为空");
        }
        bindView(rootView, info);
    }

    protected abstract Class<?> getInfoClass();

    /**
     * 绑定View的数据
     *
     * @param view
     * @param t
     */
    protected abstract void bindView(View view, T t);


}
