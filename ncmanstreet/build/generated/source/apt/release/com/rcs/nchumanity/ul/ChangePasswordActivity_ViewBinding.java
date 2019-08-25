// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChangePasswordActivity_ViewBinding implements Unbinder {
  private ChangePasswordActivity target;

  private View view7f090188;

  private View view7f0900ae;

  @UiThread
  public ChangePasswordActivity_ViewBinding(ChangePasswordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChangePasswordActivity_ViewBinding(final ChangePasswordActivity target, View source) {
    this.target = target;

    View view;
    target.oldPassword = Utils.findRequiredViewAsType(source, R.id.oldPassword, "field 'oldPassword'", EditText.class);
    target.password = Utils.findRequiredViewAsType(source, R.id.password, "field 'password'", EditText.class);
    target.rePassword = Utils.findRequiredViewAsType(source, R.id.rePassword, "field 'rePassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.submit, "method 'onClick'");
    view7f090188 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.forgetPassword, "method 'onClick'");
    view7f0900ae = view;
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
    ChangePasswordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.oldPassword = null;
    target.password = null;
    target.rePassword = null;

    view7f090188.setOnClickListener(null);
    view7f090188 = null;
    view7f0900ae.setOnClickListener(null);
    view7f0900ae = null;
  }
}
