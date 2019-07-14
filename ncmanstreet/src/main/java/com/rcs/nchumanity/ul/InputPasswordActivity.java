package com.rcs.nchumanity.ul;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.entity.complexModel.ComplexModelSet;
import com.rcs.nchumanity.entity.model.UserAccount;
import com.rcs.nchumanity.net.NetRequest;
import com.rcs.nchumanity.tool.Tool;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_password);
        ButterKnife.bind(this);

        phoneNumber = PersistenceData.getPhoneNumber(this);
        if (phoneNumber.equalsIgnoreCase(PersistenceData.DEF_PHONE)) {
            throw new RuntimeException("" + InputPasswordActivity.class.getName() + "phone number param error please check param!");
        }
    }


    @OnClick(R.id.submit)
    public void onClick(View view) {

        /**
         * 加载网络
         * 查看当前的账户时候已近注册  ---》注册的情况下  验证密码
         * --->没有注册   填写密码进行注册
         *
         */
        loadData(NetConnectionUrl.REGISTER_STATUS, "registerStatusCheck", "GET", null);

    }


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

                /**
                 * 进行注册
                 * 手机号 密码
                 */
                loginOrRegister(NetConnectionUrl.LOGIN, "register");

            } else if (basicResponse.code == BasicResponse.REGISTED) {


                loginOrRegister(NetConnectionUrl.LOGIN, "login");
            }

        } else if (what.equals("register")) {

            /**
             * 注册结果的回调，注册成功的话，就跳转到主页面去
             */
            ComplexModelSet.M_basResp_useAcc useAcc = new Gson().fromJson(backData[0], ComplexModelSet.M_basResp_useAcc.class);

            if (useAcc.basicResponse.code == BasicResponse.REGISTED_SUCCESS) {

                /**
                 * 返回注册用户的用户信息
                 */
                loginOrRegisterCallback(BasicResponse.REGISTED_SUCCESS, backData[0]);
            }
        } else if (what.equals("login")) {

            /**
             * 注册结果的回调，注册成功的话，就跳转到主页面去
             */
            loginOrRegisterCallback(BasicResponse.LOGIN_SUCCESS, backData[0]);

        }
    }


    /**
     * 登录或则是注册
     *
     * @param url
     * @param what
     */
    public void loginOrRegister(String url, String what) {
        Map<String, String> params = new HashMap<>();
        params.put("mobilephone", phoneNumber);
        params.put("password", String.valueOf(password.getText()));
        loadData(url, what, "POST", params);
    }


    public void loginOrRegisterCallback(int code, String jsonData) {
        ComplexModelSet.M_basResp_useAcc useAcc = new Gson().fromJson(jsonData, ComplexModelSet.M_basResp_useAcc.class);

        if (useAcc.basicResponse.code == code) {

            /**
             * 返回注册用户的用户信息
             */
            String nickname = useAcc.userAccount.nickname;
            String user_id = useAcc.userAccount.userId + "";

            PersistenceData.setUserId(this, user_id);
            PersistenceData.setNickName(this, nickname);

            Tool.startActivity(this, MainActivity.class);
        }
    }


}
