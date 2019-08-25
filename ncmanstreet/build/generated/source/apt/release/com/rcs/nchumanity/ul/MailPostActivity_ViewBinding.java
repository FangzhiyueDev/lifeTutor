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

public class MailPostActivity_ViewBinding implements Unbinder {
  private MailPostActivity target;

  private View view7f0900fc;

  @UiThread
  public MailPostActivity_ViewBinding(MailPostActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MailPostActivity_ViewBinding(final MailPostActivity target, View source) {
    this.target = target;

    View view;
    target.realName = Utils.findRequiredViewAsType(source, R.id.realName, "field 'realName'", EditText.class);
    target.mobilePhone = Utils.findRequiredViewAsType(source, R.id.mobilePhone, "field 'mobilePhone'", EditText.class);
    target.address = Utils.findRequiredViewAsType(source, R.id.address, "field 'address'", EditText.class);
    view = Utils.findRequiredView(source, R.id.mail, "method 'onClick'");
    view7f0900fc = view;
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
    MailPostActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.realName = null;
    target.mobilePhone = null;
    target.address = null;

    view7f0900fc.setOnClickListener(null);
    view7f0900fc = null;
  }
}
