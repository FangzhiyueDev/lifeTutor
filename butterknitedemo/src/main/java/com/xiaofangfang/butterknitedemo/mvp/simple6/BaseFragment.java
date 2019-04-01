package com.xiaofangfang.butterknitedemo.mvp.simple6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.xiaofangfang.butterknitedemo.mvp.simple5.base.BasePresenter_5;
import com.xiaofangfang.butterknitedemo.mvp.simple5.ui.BaseView;

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter_5<V>> extends Fragment {


    private V view;
    private P presenter;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (this.presenter == null) {
            this.presenter = createPresenter();
        }
        if (this.view == null) {
            this.view = createView();
        }

        if (this.view != null && this.presenter != null) {
            this.presenter.attacgView(this.view);
        }
    }


    public P getPresenter() {
        return presenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.view != null && this.presenter != null) {
            this.presenter.detachView();
        }

    }

    public abstract P createPresenter();

    public abstract V createView();


}
