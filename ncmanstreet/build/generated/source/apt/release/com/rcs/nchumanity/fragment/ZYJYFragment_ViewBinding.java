// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.fragment;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.view.CommandBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ZYJYFragment_ViewBinding implements Unbinder {
  private ZYJYFragment target;

  private View view7f090169;

  @UiThread
  public ZYJYFragment_ViewBinding(final ZYJYFragment target, View source) {
    this.target = target;

    View view;
    target.commandBar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'commandBar'", CommandBar.class);
    view = Utils.findRequiredView(source, R.id.sendHelp, "field 'sendHelp' and method 'onClick'");
    target.sendHelp = Utils.castView(view, R.id.sendHelp, "field 'sendHelp'", ImageButton.class);
    view7f090169 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.rootHelpView = Utils.findRequiredViewAsType(source, R.id.rootHelpView, "field 'rootHelpView'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ZYJYFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.commandBar = null;
    target.sendHelp = null;
    target.rootHelpView = null;

    view7f090169.setOnClickListener(null);
    view7f090169 = null;
  }
}
