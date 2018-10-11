package com.ziroom.util;


import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Util {
    public static String getMD5Code(String password,String salt,int count){
        Md5Hash code = new Md5Hash(password, salt, count);
        return code.toString();
    }

    public static void main(String[] args) {
        String code = getMD5Code("123456", "abc", 2);
        System.out.println(code);
    }
}
