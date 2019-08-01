package com.rcs.nchumanity.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.AssessResultActivity;
import com.rcs.nchumanity.ul.EntityCertificateActivity;
import com.rcs.nchumanity.ul.MyCourseActivity;
import com.rcs.nchumanity.ul.SettingActivity;


import java.io.FileNotFoundException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的的界面的显示
 */
public class MeFragment extends ParentFragment {


    @BindView(R.id.picture)
    ImageView photo;//用户头像

    public static final int REQUEST_CODE_PHOTO = 1;


    @Override
    protected int getCreateView() {
        return R.layout.fragment_me;
    }


    @OnClick({R.id.meCourse, R.id.picture, R.id.assessResult, R.id.elecCertificate, R.id.entityCertificate, R.id.setting})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.meCourse:
                Tool.startActivity(getContext(), MyCourseActivity.class);
                break;

            case R.id.picture:

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_PHOTO);
                break;

            case R.id.assessResult:

                Intent intent1 = new Intent(getActivity(), AssessResultActivity.class);
                startActivity(intent1);

                break;

            case R.id.elecCertificate:

                Intent intent3 = new Intent();
                startActivity(intent3);


                break;

            case R.id.entityCertificate:


                Intent intent2 = new Intent(getActivity(), EntityCertificateActivity.class);
                startActivity(intent2);

                break;

            case R.id.setting:

                Tool.startActivity(getActivity(), SettingActivity.class);

                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_PHOTO:

                if (requestCode == getActivity().RESULT_OK) {
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
}
