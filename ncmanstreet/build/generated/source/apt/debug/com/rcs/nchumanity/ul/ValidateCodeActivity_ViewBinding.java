// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul;

import android.view.View;
import android.widget.Button;
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

public class ValidateCodeActivity_ViewBinding implements Unbinder {
  private ValidateCodeActivity target;

  private View view7f09013c;

  @UiThread
  public ValidateCodeActivity_ViewBinding(ValidateCodeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ValidateCodeActivity_ViewBinding(final ValidateCodeActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.reSend, "field 'reSend' and method 'onClick'");
    target.reSend = Utils.castView(view, R.id.reSend, "field 'reSend'", Button.class);
    view7f09013c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", CommandBar.class);
    target.phone = Utils.findRequiredViewAsType(source, R.id.phone, "field 'phone'", TextView.class);
    target.codes = Utils.listFilteringNull(
        Utils.findRequiredViewAsType(source, R.id.code1, "field 'codes'", EditText.class), 
        Utils.findRequiredViewAsType(source, R.id.code2, "field 'codes'", EditText.class), 
        Utils.findRequiredViewAsType(source, R.id.code3, "field 'codes'", EditText.class), 
        Utils.findRequiredViewAsType(source, R.id.code4, "field 'codes'", EditText.class), 
        Utils.findRequiredViewAsType(source, R.id.code5, "field 'codes'", EditText.class), 
        Utils.findRequiredViewAsType(source, R.id.code6, "field 'codes'", EditText.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    ValidateCodeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.reSend = null;
    target.toolbar = null;
    target.phone = null;
    target.codes = null;

    view7f09013c.setOnClickListener(null);
    view7f09013c = null;
  }
}
