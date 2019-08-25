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

public class IdentitySelectActivity_ViewBinding implements Unbinder {
  private IdentitySelectActivity target;

  private View view7f0900c5;

  private View view7f0900c6;

  @UiThread
  public IdentitySelectActivity_ViewBinding(IdentitySelectActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public IdentitySelectActivity_ViewBinding(final IdentitySelectActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.identity_1, "method 'onClick'");
    view7f0900c5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.identity_2, "method 'onClick'");
    view7f0900c6 = view;
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


    view7f0900c5.setOnClickListener(null);
    view7f0900c5 = null;
    view7f0900c6.setOnClickListener(null);
    view7f0900c6 = null;
  }
}
