package com.rcs.nchumanity.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.tool.ActivityStackManager;
import com.rcs.nchumanity.ul.MainActivity;
import com.rcs.nchumanity.view.CommandBar;

import java.io.File;
import java.lang.reflect.Field;

import butterknife.BindView;

/**
 * 志愿救援的信息的显示
 */
public class ZYJYFragment extends ParentFragment {


    private static final String TAG = "test";
    @BindView(R.id.toolbar)
    public CommandBar commandBar;

    private String title = "救护员救援";


    @Override
    protected int getCreateView() {
        return R.layout.zyjy;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        commandBar.setTitle(title);

        ActivityStackManager asm = ActivityStackManager.getInstance(getContext());


        String packName = getContext().getPackageName() + File.separator + MainActivity.class.getName();

        Log.d(TAG, "onViewCreated: " + packName);

//        if (asm.getStackSize() == 1 && asm.getTopStackPackageName().equals(packName)) {
//            commandBar.hiddenBack();
//        }

        if(getMyActivity() instanceof MainActivity){
            commandBar.hiddenBack();
        }



        commandBar.setBackGroundColor1(android.R.color.transparent);
        commandBar.setMenu(R.drawable.ic_30, (view1 -> {

        }));
    }

    public void setToolbarOffsetY(int dimensionPixel) {
        commandBar.setTranslationY(dimensionPixel);
    }
}
