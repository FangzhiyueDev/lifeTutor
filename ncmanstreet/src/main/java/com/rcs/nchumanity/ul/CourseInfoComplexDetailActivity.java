package com.rcs.nchumanity.ul;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.complexModel.ComplexModelSet;
import com.rcs.nchumanity.entity.model.OnlineCourseInfo;
import com.rcs.nchumanity.tool.DensityConvertUtil;
import com.rcs.nchumanity.tool.StringTool;
import com.rcs.nchumanity.view.MyVideoView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 课程信息详情Activity
 * 需要传递
 * #{{@link ComplexModelSet.M_speinf_speinfCla}}过来
 * 这样我们就能拿到 对应的课程想关的信息
 * <p>
 * 子类继承通过传递网络加载不同的数据  选修和必修
 * <p>
 * 这个类可以用于基本的选修的实现
 */
public class CourseInfoComplexDetailActivity extends ComplexDetailActivity<ComplexModelSet.M_onlCour_courCla> {


    //需要竖屏隐藏的音量title
    @BindView(R.id.tv_vol_name)
    TextView mTvVolName;
    //徐奥竖屏隐藏的音量分割线
    @BindView(R.id.v_line)
    View mVLine;
    //最外层的布局
    @BindView(R.id.rl_videolayout)
    RelativeLayout mRlVideolayout;
    //VideoView
    @BindView(R.id.vv_videoView)
    MyVideoView mVvVideoView;
    //进程进度条
    @BindView(R.id.sb_progress_seekbar)
    SeekBar mSbProgressSeekbar;
    //播放 暂停
    @BindView(R.id.bt_start_pause)
    ImageButton mBtStartPause;
    //现在的时间
    @BindView(R.id.tv_time_current)
    TextView mTvTimeCurrent;
    //总共的时间
    @BindView(R.id.tv_time_total)
    TextView mTvTimeTotal;
    //音量进度条
    @BindView(R.id.sb_vol_seekbar)
    SeekBar mSbVolSeekbar;
    //全屏切换开关
    @BindView(R.id.bt_switch)
    ImageButton mBtSwitch;
    //控制区域
    @BindView(R.id.ll_controllerBar_layout)
    LinearLayout mLlControllerBarLayout;
    //控制区域左半边
    @BindView(R.id.ll_left_layout)
    LinearLayout mLlLeftLayout;
    //控制区域右半边
    @BindView(R.id.ll_right_layout)
    LinearLayout mLlRightLayout;
    @BindView(R.id.operation_bg)
    ImageView mOperationBg;
    @BindView(R.id.operation_percent)
    View mOperationPercent;
    @BindView(R.id.fl_content)
    LinearLayout mFlContent;
    //butterknife
    Unbinder mUnbinder;
    //定义两个变量：代表当前屏幕的宽和屏幕的高
    private int screen_width, screen_height;
    //刷新机制的标志
    private static final int UPDATE_UI = 1;
    //初始化音频管理器
    private AudioManager mAudioManager;
    //横竖屏变量
    private boolean isFullScreen = false;
    //是否错误触摸的变量
    private boolean isEMove = false;
    //错误触摸临界值
    private int Num = 5;
    //上次的坐标值
    private float lastX;
    private float lastY;
    //生命一个亮度值
    private float mBrightness;
    //预览图
    @BindView(R.id.review)
    ImageView reView;

    /**
     * 视频播放的url
     */
    private String url;


    /**
     * 定义Handler刷新时间
     * 得到并设置当前视频播放的时间
     * 得到并设置视频播放的总时间
     * 设置SeekBar总进度和当前视频播放的进度
     * 并反复执行Handler刷新时间
     * 指定标识用于关闭Handler
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == UPDATE_UI) {

                int currentPosition = mVvVideoView.getCurrentPosition();
                int totalduration = mVvVideoView.getDuration();

                updateTime(mTvTimeCurrent, currentPosition);
                updateTime(mTvTimeTotal, totalduration);

                mSbProgressSeekbar.setMax(totalduration);
                mSbProgressSeekbar.setProgress(currentPosition);

                mHandler.sendEmptyMessageDelayed(UPDATE_UI, 500);

            }
        }
    };


    @Override
    protected Class<?> getInfoClass() {
        return info.getClass();
    }


    @Override
    protected void bindView(View view, ComplexModelSet.M_onlCour_courCla m_onlCour_courCla) {

        /**
         * 设置标题
         */
        TextView barTitle = view.findViewById(R.id.barTitle);

        barTitle.setText(m_onlCour_courCla.classification.courseName);


        OnlineCourseInfo onlineCourseInfo = m_onlCour_courCla.onlineCourseInfos.get(0);

        /**
         * 设置图片的显示，因为图片的显示
         *
         *   <ImageView
         *                     android:layout_width="match_parent"
         *                     android:layout_height="wrap_content"
         *                     android:scaleType="centerCrop"
         *                     android:src="@drawable/banner1" />
         *
         *                     被添加到R.id.imgArea 下面
         *
         */

        ViewGroup imgArea = view.findViewById(R.id.imgArea);

        for (String url : onlineCourseInfo.imgUrl.split(StringTool.DELIMITER)) {

            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(this).load(url).into(imageView);
            imgArea.addView(imageView);
        }

        if (!TextUtils.isEmpty(onlineCourseInfo.writing)) {
            TextView content = view.findViewById(R.id.content);
            content.setText(onlineCourseInfo.writing);
        }


        /**
         * 下面的代码的作用都是用来实现视频播放相关操作的
         * 如果视频的url不存在，对视频播放相关的代码都是
         * 无用的，我们可以不去调用
         */
        if (!TextUtils.isEmpty(info.onlineCourseInfos.get(0).videoUrl)) {
            url = info.onlineCourseInfos.get(0).videoUrl;
            mUnbinder = ButterKnife.bind(this);
            initScreenWidthAndHeight();
            requestSDpermission();
            initAudioManager();
            synchScrollSeekBarAndVol();
            initNetVideoPath();
            initVideoPlay();
            synchScrollSeekBarAndTime();
            initGesture();
        } else {

            /**
             * 对Video播放相关的布局进行Gone
             */
            mRlVideolayout.setVisibility(View.GONE);

        }


    }


    /**
     * 初始化手势
     */
    private void initGesture() {
        mVvVideoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //现在的x,y坐标
                float x = event.getX();
                float y = event.getY();

                switch (event.getAction()) {
                    //手指按下:
                    case MotionEvent.ACTION_DOWN:
                        lastX = x;
                        lastY = y;
                        break;
                    //手指移动:
                    case MotionEvent.ACTION_MOVE:
                        //偏移量
                        float moveX = x - lastX;
                        float moveY = y - lastY;
                        //计算绝对值
                        float absMoveX = Math.abs(moveX);
                        float absMoveY = Math.abs(moveY);
                        //手势合法性的验证
                        if (absMoveX > Num && absMoveY > Num) {
                            if (absMoveX < absMoveY) {
                                isEMove = true;
                            } else {
                                isEMove = false;
                            }
                        } else if (absMoveX < Num && absMoveY > Num) {
                            isEMove = true;
                        } else if (absMoveX > Num && absMoveY < Num) {
                            isEMove = false;
                        }
                        /**
                         * 区分手势合法的情况下，区分是去调节亮度还是去调节声音
                         */
                        if (isEMove) {
                            //手势在左边
                            if (x < screen_width / 2) {
                                /**
                                 * 调节亮度
                                 */
                                if (moveY > 0) {
                                    //降低亮度
                                } else {
                                    //升高亮度
                                }
                                changeBright(-moveY);
                                //手势在右边
                            } else {
                                Log.e("Emove", "onTouch: " + "手势在右边");
                                /**
                                 * 调节音量
                                 */
                                if (moveY > 0) {
                                    //减小音量
                                } else {
                                    //增大音量
                                }
                                changeVolume(-moveY);
                            }
                        }
                        lastX = x;
                        lastY = y;
                        break;
                    //手指抬起:
                    case MotionEvent.ACTION_UP:
                        mFlContent.setVisibility(View.GONE);
                        break;
                }
                return true;
            }
        });
    }


    /**
     * 获取屏幕的宽和屏幕的高
     */
    private void initScreenWidthAndHeight() {
        screen_width = getResources().getDisplayMetrics().widthPixels;
        screen_height = getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 初始化网络路径
     */
    private void initNetVideoPath() {
        mVvVideoView.setVideoURI(Uri.parse(info.onlineCourseInfos.get(0).videoUrl));
    }

    /**
     * 初始化本地路径
     */
    private void initLocalVideoPath() {
        File file = new File(Environment.getExternalStorageDirectory(), "video.mp4");
        mVvVideoView.setVideoPath(file.getPath());
    }

    /**
     * 初始化音频管理器;获取设备最大音量和当前音量并设置
     */
    private void initAudioManager() {
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int streamMaxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int streamVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mSbVolSeekbar.setMax(streamMaxVolume);
        mSbVolSeekbar.setProgress(streamVolume);
    }

    private Bitmap bitmap = null;

    /**
     * 初始化播放以及开始刷新时间机制
     */
    private void initVideoPlay() {
        //设置一个预览图片
        Executors.newSingleThreadExecutor().execute(() -> {
            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            try {
                //这里要用FileProvider获取的Uri
                if (url.contains("http")) {
                    retriever.setDataSource(url, new HashMap<String, String>());
                } else {
                    retriever.setDataSource(url);
                }
                bitmap = retriever.getFrameAtTime();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    retriever.release();
                } catch (RuntimeException ex) {
                    ex.printStackTrace();
                }
            }
            new Handler(Looper.getMainLooper()).post(() -> {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] bytes = baos.toByteArray();
                Glide.with(CourseInfoComplexDetailActivity.this).load(bytes).into(reView);
            });

        });

        //第一个参数是标志，第二个参数是刷新间隔时间
        mHandler.sendEmptyMessageDelayed(UPDATE_UI, 500);
    }

    /**
     * 拖动音量SeekBar同步视频的音量
     */
    private void synchScrollSeekBarAndVol() {
        mSbVolSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //设置当前设备的音量;参数：类型、进程、标志
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * 拖动SeekBar同步SeekBar和Time和VideoView
     */
    private void synchScrollSeekBarAndTime() {
        mSbProgressSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //进步改变的时候同步Time
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTime(mTvTimeCurrent, progress);
            }

            //拖动的时候关闭刷新机制
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mHandler.removeMessages(UPDATE_UI);
            }

            //同步VideoView和拖动停止开启刷新机制
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                mVvVideoView.seekTo(progress);
                mHandler.sendEmptyMessage(UPDATE_UI);
            }
        });
    }


    @OnClick({R.id.bt_start_pause, R.id.bt_switch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //控制视频的播放和暂停
            case R.id.bt_start_pause:
                if (mVvVideoView.isPlaying()) {
                    mBtStartPause.setImageResource(R.drawable.ic_bofang3);
                    mVvVideoView.pause();
                    //停止刷新UI
                    mHandler.removeMessages(UPDATE_UI);
                } else {
                    mBtStartPause.setImageResource(R.drawable.ic_pause);
                    mVvVideoView.start();
                    //开启刷新UI
                    mHandler.sendEmptyMessage(UPDATE_UI);
                    //如果预览图没有被隐藏，就去隐藏
                    if (reView.getVisibility() == View.VISIBLE) {
                        reView.setVisibility(View.GONE);
                    }

                }
                break;
            //手动横竖屏切换
            case R.id.bt_switch:
                if (isFullScreen) {
                    //切换为竖屏
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else {
                    //切换为横屏
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
                break;
        }
    }

    /**
     * 监听屏幕方向的改变,横竖屏的时候分别做处理
     *
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //当屏幕方向是横屏的时候,我们应该对VideoView以及包裹VideoView的布局（也就是对整体）进行拉伸
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {


            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);


            //横屏的时候显示
            mTvVolName.setVisibility(View.VISIBLE);
            mVLine.setVisibility(View.VISIBLE);
            mSbVolSeekbar.setVisibility(View.VISIBLE);
            //横屏的时候为true
            isFullScreen = true;
            //主动取消半屏，该设置为全屏
            getWindow().clearFlags((WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN));
            getWindow().addFlags((WindowManager.LayoutParams.FLAG_FULLSCREEN));

        }
        //当屏幕方向是竖屏的时候，竖屏的时候的高我们需要把dp转为px
        else {
            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT, DensityConvertUtil.dp2px(this, 240));
            //竖屏的时候吟唱
            mTvVolName.setVisibility(View.GONE);
            mVLine.setVisibility(View.GONE);
            mSbVolSeekbar.setVisibility(View.GONE);
            //竖屏的时候为
            isFullScreen = false;
            //主动取消全屏，该设置为半屏
            getWindow().clearFlags((WindowManager.LayoutParams.FLAG_FULLSCREEN));
            getWindow().addFlags((WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN));
        }
    }

    /**
     * 设置VideoView和最外层相对布局的宽和高
     *
     * @param width  : 像素的单位
     * @param height : 像素的单位
     */
    private void setVideoViewScale(int width, int height) {
        //获取VideoView宽和高
        ViewGroup.LayoutParams layoutParams = mVvVideoView.getLayoutParams();
        //赋值给VideoView的宽和高
        layoutParams.width = width;
        if (height == -1) {
            height = getResources().getDisplayMetrics().heightPixels;
        }
        layoutParams.height = height - DensityConvertUtil.dp2px(CourseInfoComplexDetailActivity.this, 40);

        //设置VideoView的宽和高
        mVvVideoView.setLayoutParams(layoutParams);
        //定义预览图的布局
        reView.setLayoutParams(layoutParams);


        //同上
        ViewGroup.LayoutParams layoutParams1 = mRlVideolayout.getLayoutParams();
        layoutParams1.width = width;
        layoutParams1.height = height;
        mRlVideolayout.setLayoutParams(layoutParams1);
    }

    /**
     * 调节音量:偏移量和音量值的换算
     */
    private void changeVolume(float moveY) {
        int max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int current = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int index = (int) (moveY / screen_height * max * 3);
        int volume = Math.max(current + index, 0);
        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
        if (mFlContent.getVisibility() == View.GONE) mFlContent.setVisibility(View.VISIBLE);
        mOperationBg.setImageResource(R.mipmap.ic_vol);
        ViewGroup.LayoutParams layoutParams = mOperationPercent.getLayoutParams();
        layoutParams.width = (int) (DensityConvertUtil.dp2px(this, 94) * (float) volume / max);
        mOperationPercent.setLayoutParams(layoutParams);
        mSbVolSeekbar.setProgress(volume);
    }

    /**
     * 调节亮度:
     */
    private void changeBright(float moveY) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        mBrightness = attributes.screenBrightness;
        float index = moveY / screen_height / 3;
        mBrightness += index;
        //做临界值的判断
        if (mBrightness > 1.0f) {
            mBrightness = 1.0f;
        }
        if (mBrightness < 0.01) {
            mBrightness = 0.01f;
        }
        attributes.screenBrightness = mBrightness;
        if (mFlContent.getVisibility() == View.GONE) mFlContent.setVisibility(View.VISIBLE);
        mOperationBg.setImageResource(R.mipmap.bright);
        ViewGroup.LayoutParams layoutParams = mOperationPercent.getLayoutParams();
        layoutParams.width = (int) (DensityConvertUtil.dp2px(this, 94) * mBrightness);
        mOperationPercent.setLayoutParams(layoutParams);
        getWindow().setAttributes(attributes);
    }

    /**
     * 时间的格式化并更新时间
     *
     * @param textView
     * @param millisecond
     */
    public void updateTime(TextView textView, int millisecond) {
        int second = millisecond / 1000; //总共换算的秒
        int hh = second / 3600;  //小时
        int mm = second % 3600 / 60; //分钟
        int ss = second % 60; //时分秒中的秒的得数

        String str = null;
        if (hh != 0) {
            //如果是个位数的话，前面可以加0  时分秒
            str = String.format("%02d:%02d:%02d", hh, mm, ss);
        } else {
            str = String.format("%02d:%02d", mm, ss);
        }
        textView.setText(str);
    }


    /**
     * 请求读取SD卡权限
     */
    private void requestSDpermission() {
        if (ContextCompat.checkSelfPermission(CourseInfoComplexDetailActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(CourseInfoComplexDetailActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initLocalVideoPath();
        }
    }

    /**
     * 读取权限的操作回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initLocalVideoPath();
                } else {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //停止刷新UI
        mHandler.removeMessages(UPDATE_UI);
    }


    /**
     * 释放资源
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        if (mVvVideoView != null) {
            mVvVideoView.suspend();
        }
    }


}
