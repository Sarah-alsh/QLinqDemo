// Generated code from Butter Knife. Do not modify!
package com.qhcloud.demo.app.start;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.qhcloud.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StartActivity_ViewBinding implements Unbinder {
  private StartActivity target;

  private View view2131427466;

  private View view2131427467;

  private View view2131427468;

  @UiThread
  public StartActivity_ViewBinding(StartActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StartActivity_ViewBinding(final StartActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.start_login_btn, "method 'onLogin'");
    view2131427466 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLogin();
      }
    });
    view = Utils.findRequiredView(source, R.id.start_register_btn, "method 'onRegister'");
    view2131427467 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRegister();
      }
    });
    view = Utils.findRequiredView(source, R.id.start_forgot_password_btn, "method 'onForgot'");
    view2131427468 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onForgot();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131427466.setOnClickListener(null);
    view2131427466 = null;
    view2131427467.setOnClickListener(null);
    view2131427467 = null;
    view2131427468.setOnClickListener(null);
    view2131427468 = null;
  }
}
