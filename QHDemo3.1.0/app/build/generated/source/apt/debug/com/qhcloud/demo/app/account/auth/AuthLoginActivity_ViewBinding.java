// Generated code from Butter Knife. Do not modify!
package com.qhcloud.demo.app.account.auth;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.qhcloud.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AuthLoginActivity_ViewBinding implements Unbinder {
  private AuthLoginActivity target;

  private View view2131427425;

  private View view2131427426;

  @UiThread
  public AuthLoginActivity_ViewBinding(AuthLoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AuthLoginActivity_ViewBinding(final AuthLoginActivity target, View source) {
    this.target = target;

    View view;
    target.mUserEt = Utils.findRequiredViewAsType(source, R.id.auth_login_user_et, "field 'mUserEt'", EditText.class);
    target.mAuthCodeEt = Utils.findRequiredViewAsType(source, R.id.auth_login_code_et, "field 'mAuthCodeEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.auth_login_code_btn, "field 'mSmsCodeBtn' and method 'onSmsCode'");
    target.mSmsCodeBtn = Utils.castView(view, R.id.auth_login_code_btn, "field 'mSmsCodeBtn'", Button.class);
    view2131427425 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSmsCode();
      }
    });
    view = Utils.findRequiredView(source, R.id.auth_login_btn, "method 'onLogin'");
    view2131427426 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLogin();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AuthLoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUserEt = null;
    target.mAuthCodeEt = null;
    target.mSmsCodeBtn = null;

    view2131427425.setOnClickListener(null);
    view2131427425 = null;
    view2131427426.setOnClickListener(null);
    view2131427426 = null;
  }
}
