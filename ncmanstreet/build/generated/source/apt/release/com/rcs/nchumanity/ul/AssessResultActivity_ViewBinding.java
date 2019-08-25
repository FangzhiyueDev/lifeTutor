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

public class AssessResultActivity_ViewBinding implements Unbinder {
  private AssessResultActivity target;

  @UiThread
  public AssessResultActivity_ViewBinding(AssessResultActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AssessResultActivity_ViewBinding(AssessResultActivity target, View source) {
    this.target = target;

    target.totalScoreT = Utils.findRequiredViewAsType(source, R.id.totalScore, "field 'totalScoreT'", TextView.class);
    target.one = Utils.findRequiredViewAsType(source, R.id.one, "field 'one'", TextView.class);
    target.two = Utils.findRequiredViewAsType(source, R.id.two, "field 'two'", TextView.class);
    target.three = Utils.findRequiredViewAsType(source, R.id.three, "field 'three'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AssessResultActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.totalScoreT = null;
    target.one = null;
    target.two = null;
    target.three = null;
  }
}
