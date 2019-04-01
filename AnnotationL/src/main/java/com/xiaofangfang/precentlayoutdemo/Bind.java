package com.xiaofangfang.precentlayoutdemo;


import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface Bind {
    @LayoutRes
    int bindContent() default -1;

    @IdRes
    int bindView() default -1;

    @IdRes
    int[] onCLick() default -1;

}
