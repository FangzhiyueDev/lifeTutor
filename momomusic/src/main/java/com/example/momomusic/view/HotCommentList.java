package com.example.momomusic.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.momomusic.R;
import com.example.momomusic.dialog.DialogSet;
import com.example.momomusic.dialog.DialogTool;
import com.example.momomusic.tool.ResourceUtil;
import com.example.momomusic.tool.Tools;
import com.orhanobut.logger.Logger;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

import androidx.core.widget.TextViewCompat;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * 用户评论列表
 */
public class HotCommentList extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public HotCommentList(Context context) {
        this(context, null);
    }

    public HotCommentList(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HotCommentList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOrientation(LinearLayout.VERTICAL);
        initView();

    }


    private int imageHeight = 350;

    private int padding = 20;

    private int txId = 2242, nameId = 2243, dateId = 2244, zanId = 2245, huifuId = 2246, contentId = 2247, lineId = 2248, shuLineId = 2249, btnId = 2250;


    /**
     * TextView是支持\n换行的
     */
    private void initView(List<Comment> comments) {

        imageHeight = Tools.px2dp(imageHeight, getContext());

        for (int i = 0; i < 5; i++) {

            RelativeLayout rlC = new RelativeLayout(getContext());
            rlC.setClickable(true);
            rlC.setBackgroundResource(R.drawable.button_ripple_no_corner);
            rlC.setOnTouchListener(this);

            CircleImageView tx = new CircleImageView(getContext());
            tx.setId(txId);
            tx.setImageResource(R.drawable.gedan4);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(imageHeight, imageHeight);
            lp.setMargins(20, 20, 0, 0);
            tx.setLayoutParams(lp);
            rlC.addView(tx);


            TextView name = new TextView(getContext());
            name.setId(nameId);
            name.setText("恋家...");
            name.setTextSize(12);
            lp = new RelativeLayout.LayoutParams(-2, -2);
            lp.addRule(RelativeLayout.RIGHT_OF, txId);
            lp.addRule(RelativeLayout.ALIGN_TOP, txId);
            lp.setMargins(20, 0, 0, 0);
            name.setLayoutParams(lp);
            rlC.addView(name);


            TextView date = new TextView(getContext());
            date.setId(dateId);
            date.setTextSize(10);
            date.setText("1月31日");
            lp = new RelativeLayout.LayoutParams(-2, -2);
            lp.addRule(RelativeLayout.BELOW, nameId);
            lp.addRule(RelativeLayout.ALIGN_LEFT, nameId);
            date.setLayoutParams(lp);
            rlC.addView(date);


            TextView huifu = new TextView(getContext());
            huifu.setOnClickListener(this);


            huifu.setText("回复");
            huifu.setTextSize(13);
            huifu.setId(huifuId);
            lp = new RelativeLayout.LayoutParams(-2, -2);
            lp.addRule(RelativeLayout.CENTER_VERTICAL);
            lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            lp.setMargins(0, 0, 20, 0);
            huifu.setLayoutParams(lp);
            rlC.addView(huifu);


            View shuLine = new View(getContext());
            shuLine.setBackgroundResource(R.color.splitLine);
            shuLine.setId(shuLineId);
            lp = new RelativeLayout.LayoutParams(1, 60);
            lp.setMargins(30, 0, 30, 0);
            lp.addRule(RelativeLayout.CENTER_VERTICAL);
            lp.addRule(RelativeLayout.LEFT_OF, huifuId);
            shuLine.setLayoutParams(lp);
            rlC.addView(shuLine);

/**
 *
 * 这个代码的作用是用来实现对drawable的更改颜色，同事设置到textView的右边
 */
            TextView zan = new TextView(getContext());
            zan.setOnClickListener(this);

            zan.setText("345");
            zan.setTextSize(12);
            zan.setId(zanId);
            zan.setCompoundDrawablePadding(10);
            zan.setGravity(Gravity.CENTER_VERTICAL);
            Tools.drawableChangeRight(R.drawable.ic_icon_good, getContext(), zan);
            lp = new RelativeLayout.LayoutParams(-2, -2);
            lp.addRule(RelativeLayout.CENTER_VERTICAL);
            lp.addRule(RelativeLayout.LEFT_OF, shuLineId);
            zan.setLayoutParams(lp);
            rlC.addView(zan);


            TextView content = new TextView(getContext());
            content.setId(contentId);
            content.setText(R.string.comment);
            lp = new RelativeLayout.LayoutParams(-1, -2);
            lp.addRule(RelativeLayout.ALIGN_LEFT, dateId);
            lp.addRule(RelativeLayout.BELOW, txId);
            lp.setMargins(0, 20, 10, 10);
            content.setLayoutParams(lp);
            rlC.addView(content);

            View line = new View(getContext());
            lp = new RelativeLayout.LayoutParams(-1, 1);
            lp.setMargins(10, 0, 10, 20);
            line.setBackgroundResource(R.color.splitLine);
            line.setLayoutParams(lp);
            lp.addRule(RelativeLayout.ABOVE, contentId);

            this.addView(rlC, -1, -2);

        }
    }


    /**
     * 每一个评论的点击事件的处理
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

        Logger.d("当前的view" + v.getClass().getSimpleName() + "\t" + v.getId());


        Rect rect = new Rect();

        v.getGlobalVisibleRect(rect);

        Logger.d("bottom=" + rect.bottom + "\t" + rect.left + "\t" + rect.bottom + "\t" + rect.top);


        if (v instanceof Button && v.getId() == btnId) {//代表的的是每一项的点击事件的处理


//            return;
        }

        if (v instanceof TextView && v.getId() == huifuId) {//回复的处理


//            return;
        }
        if (v instanceof TextView && v.getId() == zanId) {//赞的处理


//            return;
        }
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //遍历里面的child  获得  点赞和  回复的rect的区域
        getZhiViewRect(this);

    }


    private List<Rect> data = new ArrayList<>();


    private void getZhiViewRect(View view) {

        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                getZhiViewRect(((ViewGroup) view).getChildAt(i));
            }
        } else {

            if (view instanceof TextView && (view.getId() == huifuId || view.getId() == zanId)) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                Logger.d("bottom=" + rect.bottom + "\t" + rect.left + "\t" + rect.bottom + "\t" + rect.top);
                data.add(rect);
            }
        }
        return;
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        for (Rect rect : data) {
            if (rect.contains(x, y)) {
                return true;
            }
        }


        //在这里我们需要 做的是 获得当前的用户的name

        DialogTool<String> dialogTool = new DialogTool<String>() {
            @Override
            public void bindView(DialogTool<String> d, Dialog dialog, String... t) {

            }
        };

        String name = null;
        for (int i = 0; i < ((ViewGroup) v).getChildCount(); i++) {

            View view = ((ViewGroup) v).getChildAt(i);

            if (view.getId() == nameId && view instanceof TextView) {
                name = (String) ((TextView) view).getText();
                break;
            }
        }


        dialogTool.getDialog(getContext(), R.layout.dialog_comment, name);


        return false;
    }


}
