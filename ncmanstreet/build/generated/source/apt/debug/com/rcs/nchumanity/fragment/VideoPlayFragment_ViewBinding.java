// Generated code from Butter Knife. Do not modify!
package com.rcs.nchumanity.fragment;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.view.MyVideoView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VideoPlayFragment_ViewBinding implements Unbinder {
  private VideoPlayFragment target;

  private View view7f090033;

  private View view7f090035;

  @UiThread
  public VideoPlayFragment_ViewBinding(final VideoPlayFragment target, View source) {
    this.target = target;

    View view;
    target.mTvVolName = Utils.findRequiredViewAsType(source, R.id.tv_vol_name, "field 'mTvVolName'", TextView.class);
    target.mVLine = Utils.findRequiredView(source, R.id.v_line, "field 'mVLine'");
    target.mRlVideolayout = Utils.findRequiredViewAsType(source, R.id.rl_videolayout, "field 'mRlVideolayout'", RelativeLayout.class);
    target.mVvVideoView = Utils.findRequiredViewAsType(source, R.id.vv_videoView, "field 'mVvVideoView'", MyVideoView.class);
    target.mSbProgressSeekbar = Utils.findRequiredViewAsType(source, R.id.sb_progress_seekbar, "field 'mSbProgressSeekbar'", SeekBar.class);
    view = Utils.findRequiredView(source, R.id.bt_start_pause, "field 'mBtStartPause' and method 'onViewClicked'");
    target.mBtStartPause = Utils.castView(view, R.id.bt_start_pause, "field 'mBtStartPause'", ImageButton.class);
    view7f090033 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mTvTimeCurrent = Utils.findRequiredViewAsType(source, R.id.tv_time_current, "field 'mTvTimeCurrent'", TextView.class);
    target.mTvTimeTotal = Utils.findRequiredViewAsType(source, R.id.tv_time_total, "field 'mTvTimeTotal'", TextView.class);
    target.mSbVolSeekbar = Utils.findRequiredViewAsType(source, R.id.sb_vol_seekbar, "field 'mSbVolSeekbar'", SeekBar.class);
    view = Utils.findRequiredView(source, R.id.bt_switch, "field 'mBtSwitch' and method 'onViewClicked'");
    target.mBtSwitch = Utils.castView(view, R.id.bt_switch, "field 'mBtSwitch'", ImageButton.class);
    view7f090035 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mLlControllerBarLayout = Utils.findRequiredViewAsType(source, R.id.ll_controllerBar_layout, "field 'mLlControllerBarLayout'", LinearLayout.class);
    target.mLlLeftLayout = Utils.findRequiredViewAsType(source, R.id.ll_left_layout, "field 'mLlLeftLayout'", LinearLayout.class);
    target.mLlRightLayout = Utils.findRequiredViewAsType(source, R.id.ll_right_layout, "field 'mLlRightLayout'", LinearLayout.class);
    target.mOperationBg = Utils.findRequiredViewAsType(source, R.id.operation_bg, "field 'mOperationBg'", ImageView.class);
    target.mOperationPercent = Utils.findRequiredView(source, R.id.operation_percent, "field 'mOperationPercent'");
    target.mFlContent = Utils.findRequiredViewAsType(source, R.id.fl_content, "field 'mFlContent'", LinearLayout.class);
    target.reView = Utils.findRequiredViewAsType(source, R.id.review, "field 'reView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VideoPlayFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvVolName = null;
    target.mVLine = null;
    target.mRlVideolayout = null;
    target.mVvVideoView = null;
    target.mSbProgressSeekbar = null;
    target.mBtStartPause = null;
    target.mTvTimeCurrent = null;
    target.mTvTimeTotal = null;
    target.mSbVolSeekbar = null;
    target.mBtSwitch = null;
    target.mLlControllerBarLayout = null;
    target.mLlLeftLayout = null;
    target.mLlRightLayout = null;
    target.mOperationBg = null;
    target.mOperationPercent = null;
    target.mFlContent = null;
    target.reView = null;

    view7f090033.setOnClickListener(null);
    view7f090033 = null;
    view7f090035.setOnClickListener(null);
    view7f090035 = null;
  }
}
