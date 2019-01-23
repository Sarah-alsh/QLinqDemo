// Generated code from Butter Knife. Do not modify!
package com.qhcloud.demo.app.start.main.robot;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.qhcloud.demo.R;
import com.qhcloud.demo.view.ControlView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RobotActivity_ViewBinding implements Unbinder {
  private RobotActivity target;

  private View view2131427456;

  private View view2131427458;

  @UiThread
  public RobotActivity_ViewBinding(RobotActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RobotActivity_ViewBinding(final RobotActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.robot_select_btn, "field 'mSelectBtn' and method 'onSelect'");
    target.mSelectBtn = Utils.castView(view, R.id.robot_select_btn, "field 'mSelectBtn'", Button.class);
    view2131427456 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSelect();
      }
    });
    view = Utils.findRequiredView(source, R.id.robot_player_btn, "field 'mPlayerBtn' and method 'onPlayer'");
    target.mPlayerBtn = Utils.castView(view, R.id.robot_player_btn, "field 'mPlayerBtn'", Button.class);
    view2131427458 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPlayer(p0);
      }
    });
    target.mBodyRG = Utils.findRequiredViewAsType(source, R.id.robot_body_rg, "field 'mBodyRG'", RadioGroup.class);
    target.mSurfaceView = Utils.findRequiredViewAsType(source, R.id.robot_video_sv, "field 'mSurfaceView'", SurfaceView.class);
    target.mControlView = Utils.findRequiredViewAsType(source, R.id.robot_control_cv, "field 'mControlView'", ControlView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RobotActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSelectBtn = null;
    target.mPlayerBtn = null;
    target.mBodyRG = null;
    target.mSurfaceView = null;
    target.mControlView = null;

    view2131427456.setOnClickListener(null);
    view2131427456 = null;
    view2131427458.setOnClickListener(null);
    view2131427458 = null;
  }
}
