// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ElectronicCertificateActivity_ViewBinding implements Unbinder {
  private ElectronicCertificateActivity target;

  @UiThread
  public ElectronicCertificateActivity_ViewBinding(ElectronicCertificateActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ElectronicCertificateActivity_ViewBinding(ElectronicCertificateActivity target,
      View source) {
    this.target = target;

    target.nameT = Utils.findRequiredViewAsType(source, R.id.name, "field 'nameT'", TextView.class);
    target.date = Utils.findRequiredViewAsType(source, R.id.date, "field 'date'", TextView.class);
    target.code = Utils.findRequiredViewAsType(source, R.id.code, "field 'code'", TextView.class);
    target.idNumber = Utils.findRequiredViewAsType(source, R.id.idNumber, "field 'idNumber'", TextView.class);
    target.sex = Utils.findRequiredViewAsType(source, R.id.sex, "field 'sex'", TextView.class);
    target.zj = Utils.findRequiredViewAsType(source, R.id.zj, "field 'zj'", ImageView.class);
    target.zs = Utils.listFilteringNull(
        Utils.findRequiredViewAsType(source, R.id.z, "field 'zs'", ImageView.class), 
        Utils.findRequiredViewAsType(source, R.id.f, "field 'zs'", ImageView.class), 
        Utils.findRequiredViewAsType(source, R.id.capter, "field 'zs'", ImageView.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    ElectronicCertificateActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nameT = null;
    target.date = null;
    target.code = null;
    target.idNumber = null;
    target.sex = null;
    target.zj = null;
    target.zs = null;
  }
}
