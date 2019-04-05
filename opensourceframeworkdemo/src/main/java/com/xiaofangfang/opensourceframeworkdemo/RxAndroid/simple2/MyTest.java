package com.xiaofangfang.opensourceframeworkdemo.RxAndroid.simple2;

public class MyTest {

    public static void main(String[] argc) {

        SimpleObservable simpleObservable = new SimpleObservable();
        SimpleObserver observer = new SimpleObserver(simpleObservable);

        simpleObservable.setData(1);
        simpleObservable.setData(2);
        simpleObservable.setData(2);
        simpleObservable.setData(4);
        simpleObservable.setData(5);



    }


}
