package com.rcs.nchumanity.ul;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.dialog.DialogCollect;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.PersistenceData;

import com.rcs.nchumanity.entity.model.sys.UserAccount;
import com.rcs.nchumanity.net.NetRequest;
import com.rcs.nchumanity.service.thirdParty.ValidateCodeServler;
import com.rcs.nchumanity.tool.Md5Utils;
import com.rcs.nchumanity.tool.Tool;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Response;

/**
 * 输入密码的界面的实现
 * 可以获得用户的手机号码
 * <p>
 * 原因是  我们第一次注册，进入到验证码验证界面  ，点击确定之后，验证成功的时候，就会将密码存放到sp中
 * <p>
 * <p>
 * 考虑当前的界面为什么没有使用Bundle进行参数的传递
 * 当前界面的主要功能是输入密码。对密码进行验证 ，接受参数，将会对具体的参数耦合在一起，
 * 遵循类内部功能的单一性
 */
public class InputPasswordActivity extends ParentActivity {


    private String phoneNumber;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.validateCodeLogin)
    TextView validateCodeLogin;

    @BindView(R.id.forgetPassword)
    TextView forgetPassword;


    public static final String FUNC = "func";

    /**
     * 设置密码
     */
    public static final String FUNC_SET_PASSWORD = "func_setPassword";
    /**
     * 输入密码
     */
    public static final String FUNC_INPUT_PASSWORD = "func_inputPassword";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_password);
        ButterKnife.bind(this);

        /**
         * 加载网络
         * 查看当前的账户时候已近注册  ---》注册的情况下  验证密码
         * --->没有注册   填写密码进行注册
         *
         */


        phoneNumber = PersistenceData.getPhoneNumber(this);
        if (phoneNumber.equalsIgnoreCase(PersistenceData.DEF_PHONE)) {
            throw new RuntimeException("" + InputPasswordActivity.class.getName() + "phone number param error please check param!");
        }

        String param=String.format(NetConnectionUrl.REGISTER_STATUS,phoneNumber);
        loadDataGet(param, "registerStatusCheck");
    }


    @OnClick(R.id.submit)
    public void onClick(View view) {

        if (registerStatus) {

            String param = String.format(NetConnectionUrl.LOGIN, phoneNumber, Md5Utils.encode(password.getText().toString()));

            loadDataGet(param, "login");
        } else {
            String param = String.format(NetConnectionUrl.REGISTER, phoneNumber, Md5Utils.encode(password.getText().toString()));

            loadDataGet(param, "register");
        }
    }


    private boolean registerStatus = false;


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);
        if (what.equals("registerStatusCheck")) {
            /**
             *
             * 验证密码
             * 或注册用户
             */
            BasicResponse basicResponse = new Gson().fromJson(backData[0], BasicResponse.class);
            if (basicResponse.code == BasicResponse.NOT_REGISTER) {
                registerStatus = false;
                //设置密码页面的显示
            } else if (basicResponse.code == BasicResponse.REGISTED) {
                registerStatus = true;
            }

            resetPageStyle(registerStatus);


        } else if (what.equals("register")) {

            /**
             * 注册结果的回调，注册成功的话，就跳转到主页面去
             */
            BasicResponse basicResponse = new Gson().fromJson(backData[0], BasicResponse.class);

            if (basicResponse.code == BasicResponse.REGISTED_SUCCESS) {
                /**
                 * 返回注册用户的用户信息
                 */
                loginOrRegisterCallback(backData[0]);
            }
        } else if (what.equals("login")) {
            /**
             * 注册结果的回调，注册成功的话，就跳转到主页面去
             */
            loginOrRegisterCallback(backData[0]);

        }
    }

    /**
     * 重新设置页面风格
     *
     * @param registerStatus
     */
    private void resetPageStyle(boolean registerStatus) {

        if (registerStatus) {

            password.setHint("输入密码");

            forgetPassword.setVisibility(View.VISIBLE);
            validateCodeLogin.setVisibility(View.VISIBLE);

            forgetPassword.setOnClickListener((v)->{

                //发送验证码到该手机上
                ValidateCodeServler.sendValidateCode("86", phoneNumber);
                /**
                 * 根据返回数据的结果，动态的跳转相应的界面
                 */
                Bundle bundle = new Bundle();
                bundle.putString(ValidateCodeActivity.MOBILE_PHONE, phoneNumber);
                Tool.startActivity(this,ValidateCodeActivity.class,bundle);

            });

            validateCodeLogin.setOnClickListener((v)->{

                //发送验证码到该手机上
                ValidateCodeServler.sendValidateCode("86", phoneNumber);
                /**
                 * 根据返回数据的结果，动态的跳转相应的界面
                 */
                Bundle bundle = new Bundle();
                bundle.putString(ValidateCodeActivity.MOBILE_PHONE, phoneNumber);
                Tool.startActivity(this,ValidateCodeActivity.class,bundle);
            });


        } else {
            password.setHint("设置密码");
            forgetPassword.setVisibility(View.INVISIBLE);
            validateCodeLogin.setVisibility(View.INVISIBLE);
        }

    }


    public void loginOrRegisterCallback(String jsonData) {
        BasicResponse basicResponse = new Gson().fromJson(jsonData, BasicResponse.class);

        if (basicResponse.code == BasicResponse.LOGIN_SUCCESS) {

            /**
             * 返回注册用户的用户信息
             */
            UserAccount userAccount = (UserAccount) basicResponse.data;
            String user_id = userAccount.getUserId() + "";

            String picture = userAccount.getPicUrl();

            //用户头像pictureUrl   用户id  userid  用户nickname
            PersistenceData.setUserPicture(this, picture);
            PersistenceData.setUserId(this, user_id);
            PersistenceData.setNickName(this, userAccount.getNickname());

            Tool.startActivity(this, MainActivity.class);
        } else if (basicResponse.code == BasicResponse.REGISTED_SUCCESS) {

            Dialog dialog=DialogCollect.showWarnDialog("提示", "注册成功", this, new DialogCollect.EnterProgress() {
                @Override
                public void onProgre(DialogInterface dialog, AlertDialog.Builder builder) {
                    //对确认的操作
                    //进入输入密码界面进行登录
                    Tool.startActivity(InputPasswordActivity.this, InputPasswordActivity.class);
                }
            });
            dialog.show();


        }
    }


}
