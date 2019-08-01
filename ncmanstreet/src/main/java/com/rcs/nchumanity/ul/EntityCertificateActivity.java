package com.rcs.nchumanity.ul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 实体证书
 */
public class EntityCertificateActivity extends ParentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entity_certificate);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ziqu, R.id.youji})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ziqu:
                Intent intent = new Intent(this, SelfTakeActivity.class);
                startActivity(intent);
                break;
            case R.id.youji:
                Intent intent1 = new Intent(this, MailPostActivity.class);
                startActivity(intent1);

                break;
        }
    }


}
