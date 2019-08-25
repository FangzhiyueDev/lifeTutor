// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.view.BannerFlip;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainFragment_ViewBinding implements Unbinder {
  private MainFragment target;

  private View view7f0900de;

  private View view7f09001e;

  private View view7f0900dd;

  private View view7f0900b9;

  @UiThread
  public MainFragment_ViewBinding(final MainFragment target, View source) {
    this.target = target;

    View view;
    target.banner = Utils.findRequiredViewAsType(source, R.id.banner, "field 'banner'", BannerFlip.class);
    target.funcArea = Utils.findRequiredViewAsType(source, R.id.funcArea, "field 'funcArea'", LinearLayout.class);
    target.basicInfoArea = Utils.findRequiredViewAsType(source, R.id.basicInfoArea, "field 'basicInfoArea'", LinearLayout.class);
    target.total = Utils.findRequiredViewAsType(source, R.id.total, "field 'total'", TextView.class);
    view = Utils.findRequiredView(source, R.id.jhypx, "method 'onClick'");
    view7f0900de = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.aedfb, "method 'onClick'");
    view7f09001e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.jhyjy, "method 'onClick'");
    view7f0900dd = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.hjjhy, "method 'onClick'");
    view7f0900b9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.banner = null;
    target.funcArea = null;
    target.basicInfoArea = null;
    target.total = null;

    view7f0900de.setOnClickListener(null);
    view7f0900de = null;
    view7f09001e.setOnClickListener(null);
    view7f09001e = null;
    view7f0900dd.setOnClickListener(null);
    view7f0900dd = null;
    view7f0900b9.setOnClickListener(null);
    view7f0900b9 = null;
  }
}
