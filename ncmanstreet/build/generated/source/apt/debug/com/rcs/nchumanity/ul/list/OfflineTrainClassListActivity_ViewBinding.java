// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul.list;

import android.view.View;
import android.widget.ListView;
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

public class OfflineTrainClassListActivity_ViewBinding implements Unbinder {
  private OfflineTrainClassListActivity target;

  private View view7f09004d;

  @UiThread
  public OfflineTrainClassListActivity_ViewBinding(OfflineTrainClassListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OfflineTrainClassListActivity_ViewBinding(final OfflineTrainClassListActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.changePosition, "field 'changePosition' and method 'onClick'");
    target.changePosition = Utils.castView(view, R.id.changePosition, "field 'changePosition'", TextView.class);
    view7f09004d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", CommandBar.class);
    target.classList = Utils.findRequiredViewAsType(source, R.id.classList, "field 'classList'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OfflineTrainClassListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.changePosition = null;
    target.toolbar = null;
    target.classList = null;

    view7f09004d.setOnClickListener(null);
    view7f09004d = null;
  }
}
