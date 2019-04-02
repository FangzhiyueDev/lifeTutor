package com.example.componentasystemtest.asyncTask;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.widget.Toast;

public class AsyncTask {


    public static void threadProcess(Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }


    public static void handlerThreadProcess(Context context) {

        /**
         *
         * handlerThread内部帮我们维持了一个Looper循环，也就是我们不需要关注是否在主线程或者子线程的Looper问题
         */
        HandlerThread handlerThread = new HandlerThread("handleThread") {

            @Override
            protected void onLooperPrepared() {
                super.onLooperPrepared();
                //该方法执行在执行looper循环之前，运行在主线程中

            }
        };

        handlerThread.start();


        Handler handler = new Handler(handlerThread.getLooper()) {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 20) {
                    Toast.makeText(context, "接受到消息", Toast.LENGTH_SHORT).show();
                }
            }
        };
        handler.sendEmptyMessage(20);

    }

    public static Handler handler;

    public static void handlerThread1Process(Context context) {


        HandlerThread handlerThread = new HandlerThread("handlerThread1") {

            @Override
            protected void onLooperPrepared() {
                super.onLooperPrepared();
                Toast.makeText(context, "打通了looper循环", Toast.LENGTH_SHORT).show();
            }
        };

        handlerThread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                handler = new Handler(handlerThread.getLooper()) {

                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        Toast.makeText(context, "接收到消息", Toast.LENGTH_SHORT).show();
                    }
                };
                handler.sendEmptyMessage(20);
                //如果采用传统的方法 ，那么我们需要自己在handler创建的之前调用 Looper.prepare();
                //在创建之后
            }
        }).start();


    }


    public static void asyncQueryHandlerProcess(Context context) {


        ContentResolver cr = context.getContentResolver();


        AsyncQueryHandler asyncQueryHandler = new AsyncQueryHandler(cr) {
            @Override
            protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
                super.onQueryComplete(token, cookie, cursor);
            }

            @Override
            protected void onInsertComplete(int token, Object cookie, Uri uri) {
                super.onInsertComplete(token, cookie, uri);
            }

            @Override
            protected void onUpdateComplete(int token, Object cookie, int result) {
                super.onUpdateComplete(token, cookie, result);
            }

            @Override
            protected void onDeleteComplete(int token, Object cookie, int result) {
                super.onDeleteComplete(token, cookie, result);
            }
        };

        int token = 20;//消息对象的arg1
        //这里的cookie是对象数据的传递


        asyncQueryHandler.startQuery(token, );

    }


}
