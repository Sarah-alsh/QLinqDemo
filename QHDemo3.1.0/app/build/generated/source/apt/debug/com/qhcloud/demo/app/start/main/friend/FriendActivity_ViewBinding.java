// Generated code from Butter Knife. Do not modify!
package com.qhcloud.demo.app.start.main.friend;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.qhcloud.demo.R;
import com.qhcloud.demo.view.pullrefreshlayout.PullRefreshLayout;
import com.qhcloud.demo.view.pullrefreshlayout.XRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FriendActivity_ViewBinding implements Unbinder {
  private FriendActivity target;

  @UiThread
  public FriendActivity_ViewBinding(FriendActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FriendActivity_ViewBinding(FriendActivity target, View source) {
    this.target = target;

    target.mRefreshLayout = Utils.findRequiredViewAsType(source, R.id.friend_refresh_layout, "field 'mRefreshLayout'", PullRefreshLayout.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.friend_refresh_rv, "field 'mRecyclerView'", XRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FriendActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRefreshLayout = null;
    target.mRecyclerView = null;
  }
}
