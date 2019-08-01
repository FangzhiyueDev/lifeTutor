package com.rcs.nchumanity.ul;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.service.thirdParty.ValidateCodeServler;
import com.rcs.nchumanity.tool.LoadProgress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import cn.smssdk.SMSSDK;


public class ValidateCodeActivity extends ParentActivity {


    @BindViews({R.id.code1, R.id.code2, R.id.code3, R.id.code4})
    List<EditText> codes;

    @OnClick(R.id.reSend)
    public void onClick(View view) {

        //点击操作之后，我们禁用该控件

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_code);


        ValidateCodeServler.registerProgress(new MyHandlerCallback());


    }

    /**
     * 加载进度条
     */
    private ProgressBar progressBar;


    /**
     * 实现短信验证的处理类
     * ,该类执行在主线程,可以操作ui
     */
    class MyHandlerCallback implements Handler.Callback {

        @Override
        public boolean handleMessage(Message msg) {

            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;
            if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理成功得到验证码的结果
                    // 请注意，此时只是完成了发送验证码的请求，验证码短信还需要几秒钟之后才送达
                    sucessfulSendVerification();

                } else {
                    // TODO 处理错误的结果
                    ((Throwable) data).printStackTrace();
                }
            } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理验证码验证通过的结果
                    submitVerificationComplete();
                } else {
                    submitVerficationError();
                    // TODO 处理错误的结果
                    ((Throwable) data).printStackTrace();
                }
            }
            // TODO 其他接口的返回结果也类似，根据event判断当前数据属于哪个接口
            return false;
        }
    }


    /**
     * 提交验证码完成
     */
    private void submitVerificationComplete() {
        //代表的事死
    }


    /**
     * 成功发送了验证码
     * 不做处理
     */
    private void sucessfulSendVerification() {

    }

    /**
     * 提交验证码出错
     */
    private void submitVerficationError() {
        Toast.makeText(this, "验证码不正确", Toast.LENGTH_SHORT).show();
        LoadProgress.removeLoadProgress(ValidateCodeActivity.this, progressBar);
    }


}
