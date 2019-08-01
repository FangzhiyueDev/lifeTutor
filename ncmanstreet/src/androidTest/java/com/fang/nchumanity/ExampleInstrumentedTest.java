package com.fang.nchumanity;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.rcs.nchumanity.tool.ActivityStackManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();


        ActivityStackManager asm = ActivityStackManager.getInstance(appContext);

        System.out.print("当前activity的name=" + asm.getTopStackPackageName());
        
//        assertEquals("com.fang.ncmanstreet", appContext.getPackageName());
    }
}
