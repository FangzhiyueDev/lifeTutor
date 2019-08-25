// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.ul;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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

public class IdentityInfoRecordActivity_ViewBinding implements Unbinder {
  private IdentityInfoRecordActivity target;

  private View view7f0900bc;

  private View view7f090046;

  private View view7f090189;

  @UiThread
  public IdentityInfoRecordActivity_ViewBinding(IdentityInfoRecordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public IdentityInfoRecordActivity_ViewBinding(final IdentityInfoRecordActivity target,
      View source) {
    this.target = target;

    View view;
    target.name = Utils.findRequiredViewAsType(source, R.id.name, "field 'name'", EditText.class);
    target.phoneNumber = Utils.findRequiredViewAsType(source, R.id.phoneNumber, "field 'phoneNumber'", EditText.class);
    target.identityCarNumber = Utils.findRequiredViewAsType(source, R.id.identityCardNumber, "field 'identityCarNumber'", EditText.class);
    target.workCompany = Utils.findRequiredViewAsType(source, R.id.workCompany, "field 'workCompany'", EditText.class);
    target.sixSpinner = Utils.findRequiredViewAsType(source, R.id.six, "field 'sixSpinner'", Spinner.class);
    target.degEducaSpinner = Utils.findRequiredViewAsType(source, R.id.degEduca, "field 'degEducaSpinner'", Spinner.class);
    target.workLife = Utils.findRequiredViewAsType(source, R.id.workLife, "field 'workLife'", Spinner.class);
    target.officialCapacity = Utils.findRequiredViewAsType(source, R.id.officialCapacity, "field 'officialCapacity'", EditText.class);
    target.homeAddress = Utils.findRequiredViewAsType(source, R.id.homeAddress, "field 'homeAddress'", EditText.class);
    view = Utils.findRequiredView(source, R.id.homeAddressTag, "field 'homeAddressTag' and method 'onClick'");
    target.homeAddressTag = Utils.castView(view, R.id.homeAddressTag, "field 'homeAddressTag'", TextView.class);
    view7f0900bc = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.capture, "field 'capture' and method 'onClick'");
    target.capture = Utils.castView(view, R.id.capture, "field 'capture'", ImageView.class);
    view7f090046 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", CommandBar.class);
    target.userImg = Utils.findRequiredViewAsType(source, R.id.userImg, "field 'userImg'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.submitSignUp, "method 'onClick'");
    view7f090189 = view;
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
    IdentityInfoRecordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.name = null;
    target.phoneNumber = null;
    target.identityCarNumber = null;
    target.workCompany = null;
    target.sixSpinner = null;
    target.degEducaSpinner = null;
    target.workLife = null;
    target.officialCapacity = null;
    target.homeAddress = null;
    target.homeAddressTag = null;
    target.capture = null;
    target.toolbar = null;
    target.userImg = null;

    view7f0900bc.setOnClickListener(null);
    view7f0900bc = null;
    view7f090046.setOnClickListener(null);
    view7f090046 = null;
    view7f090189.setOnClickListener(null);
    view7f090189 = null;
  }
}
