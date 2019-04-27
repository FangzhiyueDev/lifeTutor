package com.example.momomusic;

import android.content.Context;


import com.example.momomusic.servie.ChineseCharacterUtil;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.runner.AndroidJUnit4;

import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest{
    @Test
    public void useAppContext() {


    }

    @Test
    public void convertLan() {

        String value = ChineseCharacterUtil.convertHanzi2Pinyin("方志月", false);

        assertThat(value, Matchers.is("fzy"));

    }



}
