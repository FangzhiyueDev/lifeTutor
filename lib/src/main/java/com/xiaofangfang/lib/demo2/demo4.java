package com.xiaofangfang.lib.demo2;

import org.apache.commons.codec.digest.DigestUtils;

public class demo4 {


    public static byte[] encryption(String password) {
        byte[] bytes = DigestUtils.md5(password);
        return bytes;
    }

    public static void main(String[] argc) {
        byte[] bytes = encryption("123456");
        byte[] bytes1 = encryption("123456");

        for(int i=0;i<bytes.length;i++) {
            System.out.println(bytes[i]);
        }


        String s = new String(bytes);
        String s1 = new String(bytes1);
        System.out.print(s.equals(s1));
    }


}
