// Generated code from Butter Knife. Do not modify!
package com.qhcloud.home.app.start.main.chat;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.qhcloud.demo.R;
import com.qhcloud.home.view.pullrefreshlayout.PullRefreshLayout;
import com.qhcloud.home.view.pullrefreshlayout.XRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChatActivity_ViewBinding implements Unbinder {
  private ChatActivity target;

  private View view2131427431;

  private View view2131427429;

  private View view2131427523;

  @UiThread
  public ChatActivity_ViewBinding(ChatActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChatActivity_ViewBinding(final ChatActivity target, View source) {
    this.target = target;

    View view;
    target.mRefreshLayout = Utils.findRequiredViewAsType(source, R.id.chat_refresh_layout, "field 'mRefreshLayout'", PullRefreshLayout.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.chat_refresh_rv, "field 'mRecyclerView'", XRecyclerView.class);
    target.mContentEt = Utils.findRequiredViewAsType(source, R.id.chat_content_et, "field 'mContentEt'", EditText.class);
    target.mMoreLayout = Utils.findRequiredViewAsType(source, R.id.tab_chat_more_layout, "field 'mMoreLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.chat_send_btn, "method 'onSend'");
    view2131427431 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSend(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.chat_send_more_btn, "method 'onMore'");
    view2131427429 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onMore(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tab_chat_more_picture_btn, "method 'onPicture'");
    view2131427523 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPicture(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ChatActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRefreshLayout = null;
    target.mRecyclerView = null;
    target.mContentEt = null;
    target.mMoreLayout = null;

    view2131427431.setOnClickListener(null);
    view2131427431 = null;
    view2131427429.setOnClickListener(null);
    view2131427429 = null;
    view2131427523.setOnClickListener(null);
    view2131427523 = null;
  }
}
