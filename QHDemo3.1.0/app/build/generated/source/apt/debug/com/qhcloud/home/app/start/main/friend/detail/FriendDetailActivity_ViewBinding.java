// Generated code from Butter Knife. Do not modify!
package com.qhcloud.home.app.start.main.friend.detail;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.qhcloud.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FriendDetailActivity_ViewBinding implements Unbinder {
  private FriendDetailActivity target;

  private View view2131427440;

  @UiThread
  public FriendDetailActivity_ViewBinding(FriendDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FriendDetailActivity_ViewBinding(final FriendDetailActivity target, View source) {
    this.target = target;

    View view;
    target.mRemarkEt = Utils.findRequiredViewAsType(source, R.id.friend_detail_remark_et, "field 'mRemarkEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.friend_detail_update_btn, "field 'mUpdateBtn' and method 'setRemark'");
    target.mUpdateBtn = Utils.castView(view, R.id.friend_detail_update_btn, "field 'mUpdateBtn'", Button.class);
    view2131427440 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setRemark();
      }
    });
    target.mTextView = Utils.findRequiredViewAsType(source, R.id.friend_detail_tv, "field 'mTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FriendDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRemarkEt = null;
    target.mUpdateBtn = null;
    target.mTextView = null;

    view2131427440.setOnClickListener(null);
    view2131427440 = null;
  }
}
