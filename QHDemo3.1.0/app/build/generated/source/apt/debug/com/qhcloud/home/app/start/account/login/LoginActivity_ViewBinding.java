// Generated code from Butter Knife. Do not modify!
package com.qhcloud.home.app.start.account.login;

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

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131427444;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.mUserEt = Utils.findRequiredViewAsType(source, R.id.login_user_et, "field 'mUserEt'", EditText.class);
    target.mPasswordEt = Utils.findRequiredViewAsType(source, R.id.login_password_et, "field 'mPasswordEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.login_btn, "field 'mLoginBtn' and method 'onLogin'");
    target.mLoginBtn = Utils.castView(view, R.id.login_btn, "field 'mLoginBtn'", Button.class);
    view2131427444 = view;
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
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUserEt = null;
    target.mPasswordEt = null;
    target.mLoginBtn = null;

    view2131427444.setOnClickListener(null);
    view2131427444 = null;
  }
}
