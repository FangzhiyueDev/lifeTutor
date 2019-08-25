// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class JYPXFragment_ViewBinding implements Unbinder {
  private JYPXFragment target;

  private View view7f09011d;

  private View view7f0901cb;

  private View view7f090199;

  private View view7f0900af;

  private View view7f0900aa;

  private View view7f0900a9;

  private View view7f0900a8;

  private View view7f090174;

  private View view7f090172;

  private View view7f090171;

  @UiThread
  public JYPXFragment_ViewBinding(final JYPXFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.one, "method 'onClick'");
    view7f09011d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.two, "method 'onClick'");
    view7f0901cb = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.three, "method 'onClick'");
    view7f090199 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.four, "method 'onClick'");
    view7f0900af = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.five_signUp, "method 'onClick'");
    view7f0900aa = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.five_signIn, "method 'onClick'");
    view7f0900a9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.five_query, "method 'onClick'");
    view7f0900a8 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.six_signUp, "method 'onClick'");
    view7f090174 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sixSignIn, "method 'onClick'");
    view7f090172 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.sixQuery, "method 'onClick'");
    view7f090171 = view;
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


    view7f09011d.setOnClickListener(null);
    view7f09011d = null;
    view7f0901cb.setOnClickListener(null);
    view7f0901cb = null;
    view7f090199.setOnClickListener(null);
    view7f090199 = null;
    view7f0900af.setOnClickListener(null);
    view7f0900af = null;
    view7f0900aa.setOnClickListener(null);
    view7f0900aa = null;
    view7f0900a9.setOnClickListener(null);
    view7f0900a9 = null;
    view7f0900a8.setOnClickListener(null);
    view7f0900a8 = null;
    view7f090174.setOnClickListener(null);
    view7f090174 = null;
    view7f090172.setOnClickListener(null);
    view7f090172 = null;
    view7f090171.setOnClickListener(null);
    view7f090171 = null;
  }
}
