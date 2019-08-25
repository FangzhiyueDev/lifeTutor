// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.view.CommandBar;
import com.rcs.nchumanity.view.MyViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view7f0900fd;

  private View view7f0901eb;

  private View view7f0900dc;

  private View view7f090102;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", CommandBar.class);
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.viewPager, "field 'viewPager'", MyViewPager.class);
    view = Utils.findRequiredView(source, R.id.main, "method 'onClick'");
    view7f0900fd = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.zyjy, "method 'onClick'");
    view7f0901eb = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.jhpx, "method 'onClick'");
    view7f0900dc = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.me, "method 'onClick'");
    view7f090102 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.downBtns = Utils.listFilteringNull(
        Utils.findRequiredViewAsType(source, R.id.main, "field 'downBtns'", Button.class), 
        Utils.findRequiredViewAsType(source, R.id.jhpx, "field 'downBtns'", Button.class), 
        Utils.findRequiredViewAsType(source, R.id.zyjy, "field 'downBtns'", Button.class), 
        Utils.findRequiredViewAsType(source, R.id.me, "field 'downBtns'", Button.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.viewPager = null;
    target.downBtns = null;

    view7f0900fd.setOnClickListener(null);
    view7f0900fd = null;
    view7f0901eb.setOnClickListener(null);
    view7f0901eb = null;
    view7f0900dc.setOnClickListener(null);
    view7f0900dc = null;
    view7f090102.setOnClickListener(null);
    view7f090102 = null;
  }
}
