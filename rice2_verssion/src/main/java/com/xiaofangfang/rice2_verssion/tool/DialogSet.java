package com.xiaofangfang.rice2_verssion.tool;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.view.View;

public interface DialogSet {

    void setText(@IdRes int id, String text);

    void setClickListener(@IdRes int id, View.OnClickListener click);

    void setAsyncImage(@IdRes int id, @DrawableRes int res);
}
