// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul;

import android.view.View;
import android.widget.EditText;
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

public class InputPasswordActivity_ViewBinding implements Unbinder {
  private InputPasswordActivity target;

  private View view7f090188;

  @UiThread
  public InputPasswordActivity_ViewBinding(InputPasswordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InputPasswordActivity_ViewBinding(final InputPasswordActivity target, View source) {
    this.target = target;

    View view;
    target.password = Utils.findRequiredViewAsType(source, R.id.password, "field 'password'", EditText.class);
    target.validateCodeLogin = Utils.findRequiredViewAsType(source, R.id.validateCodeLogin, "field 'validateCodeLogin'", TextView.class);
    target.forgetPassword = Utils.findRequiredViewAsType(source, R.id.forgetPassword, "field 'forgetPassword'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", CommandBar.class);
    view = Utils.findRequiredView(source, R.id.submit, "method 'onClick'");
    view7f090188 = view;
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
    InputPasswordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.password = null;
    target.validateCodeLogin = null;
    target.forgetPassword = null;
    target.toolbar = null;

    view7f090188.setOnClickListener(null);
    view7f090188 = null;
  }
}
