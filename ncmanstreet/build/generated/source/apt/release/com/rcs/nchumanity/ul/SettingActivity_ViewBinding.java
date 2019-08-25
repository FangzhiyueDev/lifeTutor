// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingActivity_ViewBinding implements Unbinder {
  private SettingActivity target;

  private View view7f090029;

  private View view7f09017b;

  private View view7f090007;

  private View view7f090044;

  private View view7f0900b8;

  private View view7f0900a2;

  private View view7f09004c;

  @UiThread
  public SettingActivity_ViewBinding(SettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SettingActivity_ViewBinding(final SettingActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.backLogin, "method 'onClick'");
    view7f090029 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.softwareUpdate, "method 'onClick'");
    view7f09017b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.aboutWe, "method 'onClick'");
    view7f090007 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.cancelSignup, "method 'onClick'");
    view7f090044 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.helpCenter, "method 'onClick'");
    view7f0900b8 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.feedback, "method 'onClick'");
    view7f0900a2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.changePassword, "method 'onClick'");
    view7f09004c = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f090029.setOnClickListener(null);
    view7f090029 = null;
    view7f09017b.setOnClickListener(null);
    view7f09017b = null;
    view7f090007.setOnClickListener(null);
    view7f090007 = null;
    view7f090044.setOnClickListener(null);
    view7f090044 = null;
    view7f0900b8.setOnClickListener(null);
    view7f0900b8 = null;
    view7f0900a2.setOnClickListener(null);
    view7f0900a2 = null;
    view7f09004c.setOnClickListener(null);
    view7f09004c = null;
  }
}
