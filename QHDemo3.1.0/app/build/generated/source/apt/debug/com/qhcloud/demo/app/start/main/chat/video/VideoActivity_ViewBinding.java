// Generated code from Butter Knife. Do not modify!
package com.qhcloud.demo.app.start.main.chat.video;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.qhcloud.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VideoActivity_ViewBinding implements Unbinder {
  private VideoActivity target;

  private View view2131427471;

  private View view2131427472;

  private View view2131427473;

  private View view2131427474;

  @UiThread
  public VideoActivity_ViewBinding(VideoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public VideoActivity_ViewBinding(final VideoActivity target, View source) {
    this.target = target;

    View view;
    target.mLayout = Utils.findRequiredViewAsType(source, R.id.video_layout, "field 'mLayout'", FrameLayout.class);
    target.mTextView = Utils.findRequiredViewAsType(source, R.id.video_text_tv, "field 'mTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.video_reject_btn, "field 'mRejectBtn' and method 'onReject'");
    target.mRejectBtn = Utils.castView(view, R.id.video_reject_btn, "field 'mRejectBtn'", Button.class);
    view2131427471 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onReject(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.video_cancel_btn, "field 'mCancelBtn' and method 'onCancel'");
    target.mCancelBtn = Utils.castView(view, R.id.video_cancel_btn, "field 'mCancelBtn'", Button.class);
    view2131427472 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCancel(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.video_confirm_btn, "field 'mConfirmBtn' and method 'onConfirm'");
    target.mConfirmBtn = Utils.castView(view, R.id.video_confirm_btn, "field 'mConfirmBtn'", Button.class);
    view2131427473 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onConfirm(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.video_switch_btn, "method 'onSwitch'");
    view2131427474 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSwitch(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    VideoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLayout = null;
    target.mTextView = null;
    target.mRejectBtn = null;
    target.mCancelBtn = null;
    target.mConfirmBtn = null;

    view2131427471.setOnClickListener(null);
    view2131427471 = null;
    view2131427472.setOnClickListener(null);
    view2131427472 = null;
    view2131427473.setOnClickListener(null);
    view2131427473 = null;
    view2131427474.setOnClickListener(null);
    view2131427474 = null;
  }
}
