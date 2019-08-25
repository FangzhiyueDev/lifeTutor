// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterUserActivity_ViewBinding implements Unbinder {
  private RegisterUserActivity target;

  private View view7f09013e;

  private View view7f090133;

  private View view7f0901d4;

  @UiThread
  public RegisterUserActivity_ViewBinding(RegisterUserActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterUserActivity_ViewBinding(final RegisterUserActivity target, View source) {
    this.target = target;

    View view;
    target.phoneNumber = Utils.findRequiredViewAsType(source, R.id.phoneNumber, "field 'phoneNumber'", EditText.class);
    view = Utils.findRequiredView(source, R.id.registerSubmit, "field 'registerSubmit' and method 'registerSubmit'");
    target.registerSubmit = Utils.castView(view, R.id.registerSubmit, "field 'registerSubmit'", Button.class);
    view7f09013e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.registerSubmit(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.privacyClause, "method 'registerSubmit'");
    view7f090133 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.registerSubmit(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.userProtocol, "method 'registerSubmit'");
    view7f0901d4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.registerSubmit(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterUserActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.phoneNumber = null;
    target.registerSubmit = null;

    view7f09013e.setOnClickListener(null);
    view7f09013e = null;
    view7f090133.setOnClickListener(null);
    view7f090133 = null;
    view7f0901d4.setOnClickListener(null);
    view7f0901d4 = null;
  }
}
