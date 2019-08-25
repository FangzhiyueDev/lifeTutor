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

public class EntityCertificateActivity_ViewBinding implements Unbinder {
  private EntityCertificateActivity target;

  private View view7f0901e9;

  private View view7f0901e7;

  @UiThread
  public EntityCertificateActivity_ViewBinding(EntityCertificateActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EntityCertificateActivity_ViewBinding(final EntityCertificateActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ziqu, "method 'onClick'");
    view7f0901e9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.youji, "method 'onClick'");
    view7f0901e7 = view;
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


    view7f0901e9.setOnClickListener(null);
    view7f0901e9 = null;
    view7f0901e7.setOnClickListener(null);
    view7f0901e7 = null;
  }
}
