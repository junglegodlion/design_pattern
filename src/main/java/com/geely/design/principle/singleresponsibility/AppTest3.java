package com.geely.design.principle.singleresponsibility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 这个程序就做了两件事
 *  1.读取文件
 *  2.统计操作
 */
public class AppTest3 {

    public static void main(String[] args) throws IOException {

        //统计一个文本文件中,有多少个句子。
        Reader in = new FileReader("E:\\infos.txt");

        BufferedReader br = new BufferedReader(in);

        String line = null;
        StringBuffer sb = new StringBuffer("");

        while ((line = br.readLine()) != null) {

            sb.append(line);
            sb.append(" ");


        }

        // 关闭，只关上层流
        br.close();




        // 以.!?。的作为分割符
        String[] words = sb.toString().split("[\\.!?。]+");


        System.out.println(words.length);


    }
}
