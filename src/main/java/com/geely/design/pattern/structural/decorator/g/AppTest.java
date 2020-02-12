package com.geely.design.pattern.structural.decorator.g;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 制作一个字符输入流,能一次读一行且在每一行前面加上行号
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
// ===========================================================================

class MyLineNumberReader extends MyBufferedReader {

    private int lineNumber;
    public MyLineNumberReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        String line = super.readLine();
        if (line != null) {
            lineNumber++;
        }
        return line;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
public class AppTest {
    public static void main(String[] args) throws Exception{

        Reader in = new FileReader("E:\\1.txt");
        MyLineNumberReader mlnr = new MyLineNumberReader(in);
        String line;
        while ((line = mlnr.readLine()) != null) {
            System.out.println(mlnr.getLineNumber() + " :"+line);
        }
    }
}
