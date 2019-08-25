// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FeedbackActivity_ViewBinding implements Unbinder {
  private FeedbackActivity target;

  private View view7f090188;

  @UiThread
  public FeedbackActivity_ViewBinding(FeedbackActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FeedbackActivity_ViewBinding(final FeedbackActivity target, View source) {
    this.target = target;

    View view;
    target.content = Utils.findRequiredViewAsType(source, R.id.content, "field 'content'", EditText.class);
    target.feedList = Utils.findRequiredViewAsType(source, R.id.feedList, "field 'feedList'", ListView.class);
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
    FeedbackActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.content = null;
    target.feedList = null;

    view7f090188.setOnClickListener(null);
    view7f090188 = null;
  }
}
