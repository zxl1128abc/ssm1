package com.ziroom.util;

import java.util.Random;

//随机码工具类
public class UserMessageCodeUtil {

    public static String getCode(int c){//参数传递的是验证码的位数
        //定义一个字典
        String a="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        //定义一个随机数
        Random random=new Random();
        //定义一个char数组
        char[] b=new char[c];
        for (int i = 0; i <b.length; i++) {
            b[i]=a.charAt(random.nextInt(a.length()));
        }
        return new String(b);
    }

   /* //测试验证码是否生成
    public static void main(String[] args){
        String code = getCode(4);
        System.out.println(code);
    }*/
}
