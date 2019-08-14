package com.rcs.nchumanity.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.AssessResultActivity;
import com.rcs.nchumanity.ul.ElectronicCertificateActivity;
import com.rcs.nchumanity.ul.EntityCertificateActivity;
import com.rcs.nchumanity.ul.MyCourseActivity;
import com.rcs.nchumanity.ul.RegisterUserActivity;
import com.rcs.nchumanity.ul.SettingActivity;


import org.apache.commons.codec.binary.StringUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * 我的的界面的显示
 */
public class MeFragment extends ParentFragment {


    private static final String TAG = "test";
    @BindView(R.id.picture)
    ImageView photo;//用户头像

    @BindView(R.id.userName)
    TextView userName;


    public static final int REQUEST_CODE_PHOTO = 1;


    @Override
    protected int getCreateView() {
        return R.layout.fragment_me;
    }


    public void updateUserData() {
        String userNameS = PersistenceData.getNickName(getContext());

        if (!PersistenceData.DEF_USER.equals(PersistenceData.getNickName(getContext()))) {
            userName.setText(userNameS);
        }else{
            userName.setText("注册登录");
        }

        String pictureUri = (String) PersistenceData.getPicture(getContext());
        if (!PersistenceData.DEF_VAL.equals(pictureUri)) {
            Glide.with(getContext()).load(NetConnectionUrl.HOST + pictureUri);
        }else {
            Glide.with(getContext()).load(R.drawable.ic_logo);
        }
    }

    @Override
    protected void onLoadData() {
        super.onLoadData();
        updateUserData();
    }


    @OnClick({R.id.meCourse, R.id.picture, R.id.assessResult,
            R.id.elecCertificate, R.id.entityCertificate,
            R.id.setting, R.id.userName})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.meCourse:

                if (!Tool.loginCheck(getActivity())) {
                    return;
                }


                Tool.startActivity(getContext(), MyCourseActivity.class);
                break;

            case R.id.picture:

                if (!Tool.loginCheck(getActivity())) {
                    return;
                }

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_PHOTO);


                break;

            case R.id.assessResult:

                if (!Tool.loginCheck(getActivity())) {
                    return;
                }


                Intent intent1 = new Intent(getActivity(), AssessResultActivity.class);
                startActivity(intent1);

                break;

            case R.id.elecCertificate:

                if (!Tool.loginCheck(getActivity())) {
                    return;
                }

                Tool.startActivity(getActivity(), ElectronicCertificateActivity.class);

                break;

            case R.id.entityCertificate:

                if (!Tool.loginCheck(getActivity())) {
                    return;
                }


                Intent intent2 = new Intent(getActivity(), EntityCertificateActivity.class);
                startActivity(intent2);

                break;

            case R.id.setting:

                Tool.startActivity(getActivity(), SettingActivity.class);

                break;

            case R.id.userName:
                if (!Tool.loginCheck(getActivity())) {
                    return;
                }
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult: " + resultCode);

        switch (requestCode) {
            case REQUEST_CODE_PHOTO:
                if (resultCode == RESULT_OK) {

                    doChangePicture(data);
                } else {
                    Toast.makeText(getActivity(), "修改头像失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * @param data
     */
    private void doChangePicture(Intent data) {

        Uri uri = data.getData();
        try {
            InputStream is = getActivity().getContentResolver().openInputStream(uri);

            Bitmap bitmap = BitmapFactory.decodeStream(is);

            photo.setImageBitmap(bitmap);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }
}
