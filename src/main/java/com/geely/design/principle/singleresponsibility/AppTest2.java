package com.geely.design.principle.singleresponsibility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class AppTest2 {

    public static void main(String[] args) throws IOException {

        //统计一个文本文件中,有多少个单词。
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

        // 以不是英文字母的作为分割符
        String[] words = sb.toString().split("[^a-zA-Z]+");


        System.out.println(words.length);
    }
}
