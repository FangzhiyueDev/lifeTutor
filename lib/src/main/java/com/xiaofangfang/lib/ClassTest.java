package com.xiaofangfang.lib;

public class ClassTest {


    public static void main(String[] argc) {

//        Class<ClassTest> testClass = ClassTest.class;
//
//        System.out.print(testClass.getTypeName());
//
//        ClassTest c = new ClassTest();
//
//
//        if (c.getClass() == testClass) {
//            System.out.print("相同");
//        } else {
//            System.out.print("不同");
//        }

        String[] value = "safqf&wwqrqww&wewgwe".split("&");
        for (String va : value) {
            System.out.print(va);
        }

        value = "safqfasfa".split("&");
        for (String va : value) {
            System.out.print(va);
        }


    }

    static class My {

    }

}
