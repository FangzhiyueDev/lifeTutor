package com.rcs.nchumanity.ul;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.tool.StringTool;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Response;

/**
 * 用于实现身份验证的界面
 */
public class IdentityInfoRecordActivity extends AssessLoginActivity {


    @BindView(R.id.name)
    EditText name;

    @BindView(R.id.phoneNumber)
    EditText phoneNumber;

    @BindView(R.id.identityCardNumber)
    EditText identityCarNumber;

    @BindView(R.id.workCompany)
    EditText workCompany;


    @BindView(R.id.six)
    Spinner sixSpinner;

    @BindView(R.id.degEduca)
    Spinner degEducaSpinner;

    @BindView(R.id.workLife)
    EditText workLife;

    @BindView(R.id.officialCapacity)
    EditText officialCapacity;

    @BindView(R.id.homeAddress)
    EditText homeAddress;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity_record);
        ButterKnife.bind(this);


    }


    @OnClick(R.id.submit)
    public void onClick(View view) {

        /**
         * 进行验证
         *1.验证必填数据的合法性
         *2.获得下拉列表的数据
         *3.验证选填数据的合法性
         *4.提交数据
         */
        String value = null;

        value += StringTool.accessLength(String.valueOf(name.getText()), 2) == false ? "请输入合法的姓名\n" : "";

        value += StringTool.accessLength(String.valueOf(phoneNumber.getText()), 11) == false ? "请输入合法的手机号\n" : "";

        value += StringTool.accessLength(String.valueOf(identityCarNumber.getText()), 18) == false
                ? "身份证位数不足18位\n" : StringTool.identityAssess(String.valueOf(phoneNumber.getText())) == false ? "身份证不合法" : "";

        value += StringTool.accessLength(String.valueOf(workCompany.getText()), 2) == false ? "请输入合法的工作单位\n" : "";


        if (value.length() != 0) {
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
            return;
        }


        String sex = (String) sixSpinner.getSelectedItem();

        String educa = (String) degEducaSpinner.getSelectedItem();

        String workLifeI = String.valueOf(workLife.getText());

        String officialCapacityS = officialCapacity.getText().toString();

        String homeAddressS = String.valueOf(homeAddress.getText());


        /**
         * 下面直接提交数据
         */
        loadData(NetConnectionUrl.TRAIN_SIGN_UP, "12", "GET", null);
    }


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);

        String data = backData[0];


    }

}
