package com.geely.design.principle.singleresponsibility;

import java.io.*;

public class AppTest4 {

    public static String loadFile(String path) throws IOException {

        Reader in = new FileReader(path);

        BufferedReader br = new BufferedReader(in);

        String line = null;
        StringBuffer sb = new StringBuffer("");

        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append(" ");
        }

        // 关闭，只关上层流
        br.close();

        return sb.toString();
    }


    public static String[] words(String string) {
        // 以不是英文字母的作为分割符
        String[] words = string.split("[^a-zA-Z]+");
        return words;
    }

    /**
     * 现在的代码就符合单一职责了,优点如下:
     * 1.代码重用性提高了
     * 2.代码可读性性提高了,此时的代码就像一个大纲一样的。
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        //统计一个文本文件中,有多少个单词。
        String str = loadFile("E:\\infos.txt");


        String[] words = words(str);

        System.out.println(words.length);

    }
}
