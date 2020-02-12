package com.geely.design.pattern.structural.decorator.f;

import java.io.*;

/**
 * 至此,我们已经学习完了“装饰器模式”。
 * 其实,我们以前学习的jdk中的流,就是一种装饰模式的体现。
 *
 * 自制BufferedReader
 */

class MyBufferedReader extends Reader {

    private Reader in;

    public MyBufferedReader(Reader in) {
        this.in = in;
    }

    public String readLine() throws IOException {

        StringBuilder sb = new StringBuilder();

        int n;
        while (true) {
            n =in.read();

            // 记事本中。\r\n是换行
            if (n == '\r') {
                continue;
            }
            if (n == '\n'||n== -1) {
                break;
            }

            sb.append((char)n);
        }
        if (sb.toString().length()==0) {

            // 中间有空行，返回空
            if (n == '\n') {
                return "";

                // 末尾有空行，返回null
            }else {
                return null;
            }
        } else {
            return sb.toString();

        }
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        // 不实现，空方法体
        return 0;
    }

    @Override
    public void close() throws IOException {

        in.close();
    }
}
public class AppTest {
    public static void main(String[] args) throws Exception{

        Reader in = new FileReader("E:\\1.txt");
        MyBufferedReader mbr = new MyBufferedReader(in);

        String line;
        while ((line = mbr.readLine()) != null) {
            System.out.println(line);
        }
    }
}
