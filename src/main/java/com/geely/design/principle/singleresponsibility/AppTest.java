package com.geely.design.principle.singleresponsibility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class AppTest {

    public static void main(String[] args) throws IOException {

        //统计一个文本文件中,有多少个字符。
        //字符流查码表，能读中文；字节流不查码表
        // Reader默认查询的码表是与操作系统一致的码表,我们的操作系统是中文的,所以 Reader就会使用GBK码表
        //而GBK码表一个汉字占2个字节，且汉字的两个字节,都是以1开头的
        // utf-8码表一个汉字占3个字节
        // 读取到记事本中的数字--->gbk--->北---> unicode--->21271
        Reader in = new FileReader("F:\\1.txt");

//        int n = in.read();
//        System.out.println(n + " " + (char)n);

        int n;
        int count = 0;
        while ((n=in.read()) != -1) {
            count++;
        }

        System.out.println(count);
        in.close();




//        String s= "北";
//
//        // 编码:字符--》码表--》数字
//        // 解码:数字--》码表--》字符
//        byte[] bb = s.getBytes("gbk");
//        System.out.println(Arrays.toString(bb));
//
//        byte[] bb2 = s.getBytes("unicode");
//
//        System.out.println(Arrays.toString(bb2));


    }
}
