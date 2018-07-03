package com.example.example.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by LI on 2016/8/5.
 */
public class PasswordUtil {

    public static String MD5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // System.out.println("result: " + buf.toString());// 32位的加密
            // System.out.println("result: " + buf.toString().substring(8,
            // 24));// 16位的加密
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final static String PasswordMD5(String s) {
        return MD5(MD5(s + "duohao8888"));
    }
}
