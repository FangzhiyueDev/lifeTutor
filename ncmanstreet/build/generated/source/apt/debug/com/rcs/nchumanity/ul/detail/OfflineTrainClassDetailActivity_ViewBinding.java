// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.view.CommandBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OfflineTrainClassDetailActivity_ViewBinding implements Unbinder {
  private OfflineTrainClassDetailActivity target;

  private View view7f090189;

  @UiThread
  public OfflineTrainClassDetailActivity_ViewBinding(OfflineTrainClassDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OfflineTrainClassDetailActivity_ViewBinding(final OfflineTrainClassDetailActivity target,
      View source) {
    this.target = target;

    View view;
    target.detailImg = Utils.findRequiredViewAsType(source, R.id.detailImg, "field 'detailImg'", ImageView.class);
    target.pxzx = Utils.findRequiredViewAsType(source, R.id.pxzx, "field 'pxzx'", TextView.class);
    target.trainer = Utils.findRequiredViewAsType(source, R.id.trainer, "field 'trainer'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", CommandBar.class);
    view = Utils.findRequiredView(source, R.id.submitSignUp, "method 'onClick'");
    view7f090189 = view;
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
    OfflineTrainClassDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.detailImg = null;
    target.pxzx = null;
    target.trainer = null;
    target.toolbar = null;

    view7f090189.setOnClickListener(null);
    view7f090189 = null;
  }
}
