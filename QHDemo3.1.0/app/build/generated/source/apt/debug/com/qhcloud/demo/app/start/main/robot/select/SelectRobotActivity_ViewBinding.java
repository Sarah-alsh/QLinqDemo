// Generated code from Butter Knife. Do not modify!
package com.qhcloud.demo.app.start.main.robot.select;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.qhcloud.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectRobotActivity_ViewBinding implements Unbinder {
  private SelectRobotActivity target;

  @UiThread
  public SelectRobotActivity_ViewBinding(SelectRobotActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SelectRobotActivity_ViewBinding(SelectRobotActivity target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.select_robot_rv, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SelectRobotActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
  }
}
