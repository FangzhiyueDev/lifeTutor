// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MailPostStatusActivity_ViewBinding implements Unbinder {
  private MailPostStatusActivity target;

  @UiThread
  public MailPostStatusActivity_ViewBinding(MailPostStatusActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MailPostStatusActivity_ViewBinding(MailPostStatusActivity target, View source) {
    this.target = target;

    target.name = Utils.findRequiredViewAsType(source, R.id.name, "field 'name'", TextView.class);
    target.mobilePhone = Utils.findRequiredViewAsType(source, R.id.mobilePhone, "field 'mobilePhone'", TextView.class);
    target.address = Utils.findRequiredViewAsType(source, R.id.address, "field 'address'", TextView.class);
    target.expressNo = Utils.findRequiredViewAsType(source, R.id.expressNo, "field 'expressNo'", TextView.class);
    target.expressCompany = Utils.findRequiredViewAsType(source, R.id.expressCompany, "field 'expressCompany'", TextView.class);
    target.expressStauts = Utils.findRequiredViewAsType(source, R.id.expressStatus, "field 'expressStauts'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MailPostStatusActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.name = null;
    target.mobilePhone = null;
    target.address = null;
    target.expressNo = null;
    target.expressCompany = null;
    target.expressStauts = null;
  }
}
