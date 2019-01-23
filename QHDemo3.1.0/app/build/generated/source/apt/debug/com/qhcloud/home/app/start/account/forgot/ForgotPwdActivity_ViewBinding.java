// Generated code from Butter Knife. Do not modify!
package com.qhcloud.home.app.start.account.forgot;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.qhcloud.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ForgotPwdActivity_ViewBinding implements Unbinder {
  private ForgotPwdActivity target;

  private View view2131427435;

  private View view2131427436;

  @UiThread
  public ForgotPwdActivity_ViewBinding(ForgotPwdActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ForgotPwdActivity_ViewBinding(final ForgotPwdActivity target, View source) {
    this.target = target;

    View view;
    target.mUserEt = Utils.findRequiredViewAsType(source, R.id.forgot_user_et, "field 'mUserEt'", EditText.class);
    target.mPasswordEt = Utils.findRequiredViewAsType(source, R.id.forgot_password_et, "field 'mPasswordEt'", EditText.class);
    target.mCodeEt = Utils.findRequiredViewAsType(source, R.id.forgot_code_et, "field 'mCodeEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.forgot_code_btn, "method 'onGetCode'");
    view2131427435 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onGetCode();
      }
    });
    view = Utils.findRequiredView(source, R.id.forgot_btn, "method 'onRegister'");
    view2131427436 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRegister();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ForgotPwdActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUserEt = null;
    target.mPasswordEt = null;
    target.mCodeEt = null;

    view2131427435.setOnClickListener(null);
    view2131427435 = null;
    view2131427436.setOnClickListener(null);
    view2131427436 = null;
  }
}
