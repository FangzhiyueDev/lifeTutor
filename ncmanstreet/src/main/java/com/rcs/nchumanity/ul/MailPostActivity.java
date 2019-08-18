package com.rcs.nchumanity.ul;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.tool.Tool;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

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
 * 邮寄的证书
 */
public class MailPostActivity extends ParentActivity {


    @BindView(R.id.realName)
    EditText realName;

    @BindView(R.id.mobilePhone)
    EditText mobilePhone;

    @BindView(R.id.address)
    EditText address;


    public static final String NAME = "name";

    public static final String MOBILE_PHONE = "mobilePhone";

    public static final String ADDRESS = "address";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_post);
        ButterKnife.bind(this);

        Bundle obj = getIntent().getExtras();

        String name = obj.getString("name");
        String mobilePhone = obj.getString("mobilePhone");
        String address = obj.getString("address");

        realName.setText(name);
        this.mobilePhone.setText(mobilePhone);
        this.address.setText(address);

    }

    private boolean isClick = false;

    @OnClick(R.id.mail)
    public void onClick(View view) {
        if (!isClick) {
            Map<String, String> map = new HashMap<>();
            map.put("address", address.getText().toString());
            map.put("mobilephone", mobilePhone.getText().toString());
            map.put("name", mobilePhone.getText().toString());
            loadDataPost(NetConnectionUrl.doUnifiedOrder, "doUnifiedOrder", map);
        }
    }


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        if (br.code == BasicResponse.RESPONSE_SUCCESS) {

            if (what.equals("doUnifiedOrder")) {


//                IWXAPI api = WXAPIFactory.createWXAPI(this, "wx8888888888888888", true);
//                api.registerApp("wx8888888888888888");
//                PayReq req = new PayReq();
//                req.appId = "wx8888888888888888";//你的微信appid
//                req.partnerId = "1900000109";//商户号
//                req.prepayId = "WX1217752501201407033233368018";//预支付交易会话ID
//                req.nonceStr = "5K8264ILTKCH16CQ2502SI8ZNMTM67VS";//随机字符串
//                req.timeStamp = "1412000000";//时间戳
//                req.packageValue = "Sign=WXPay";//扩展字段,这里固定填写Sign=WXPay
//                req.sign = "C380BEC2BFD727A4B6845133519F3AD6";//签名
//                req.extData         = "app data"; // optional
//                // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
//                api.sendReq(req);
                isClick = false;
            }
        }
    }
}
