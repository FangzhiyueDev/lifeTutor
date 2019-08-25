// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul.list;

import android.view.View;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.view.CommandBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ComplexListActivity_ViewBinding implements Unbinder {
  private ComplexListActivity target;

  @UiThread
  public ComplexListActivity_ViewBinding(ComplexListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ComplexListActivity_ViewBinding(ComplexListActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.listView, "field 'listView'", ListView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", CommandBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ComplexListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.toolbar = null;
  }
}
