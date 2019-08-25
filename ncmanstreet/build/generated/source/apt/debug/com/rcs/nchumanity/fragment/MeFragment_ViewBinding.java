// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MeFragment_ViewBinding implements Unbinder {
  private MeFragment target;

  private View view7f09012d;

  private View view7f0901d3;

  private View view7f090103;

  private View view7f090023;

  private View view7f09008d;

  private View view7f090093;

  private View view7f09016a;

  @UiThread
  public MeFragment_ViewBinding(final MeFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.picture, "field 'photo' and method 'onClick'");
    target.photo = Utils.castView(view, R.id.picture, "field 'photo'", ImageView.class);
    view7f09012d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.userName, "field 'userName' and method 'onClick'");
    target.userName = Utils.castView(view, R.id.userName, "field 'userName'", TextView.class);
    view7f0901d3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.meCourse, "method 'onClick'");
    view7f090103 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.assessResult, "method 'onClick'");
    view7f090023 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.elecCertificate, "method 'onClick'");
    view7f09008d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.entityCertificate, "method 'onClick'");
    view7f090093 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.setting, "method 'onClick'");
    view7f09016a = view;
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
    MeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.photo = null;
    target.userName = null;

    view7f09012d.setOnClickListener(null);
    view7f09012d = null;
    view7f0901d3.setOnClickListener(null);
    view7f0901d3 = null;
    view7f090103.setOnClickListener(null);
    view7f090103 = null;
    view7f090023.setOnClickListener(null);
    view7f090023 = null;
    view7f09008d.setOnClickListener(null);
    view7f09008d = null;
    view7f090093.setOnClickListener(null);
    view7f090093 = null;
    view7f09016a.setOnClickListener(null);
    view7f09016a = null;
  }
}
