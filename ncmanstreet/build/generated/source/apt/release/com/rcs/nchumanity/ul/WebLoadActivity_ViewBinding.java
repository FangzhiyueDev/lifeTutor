// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.view.CommandBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebLoadActivity_ViewBinding implements Unbinder {
  private WebLoadActivity target;

  @UiThread
  public WebLoadActivity_ViewBinding(WebLoadActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WebLoadActivity_ViewBinding(WebLoadActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", CommandBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WebLoadActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
  }
}
