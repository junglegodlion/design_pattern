package com.geely.design.pattern.structural.decorator.e;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 至此,我们已经学习完了“装饰器模式”。
 * 其实,我们以前学习的jdk中的流,就是一种装饰模式的体现。
 */
public class AppTest {
    public static void main(String[] args) throws Exception{

        InputStream in = new FileInputStream("E:\\1.txt");

        // 加缓冲区
        // 积攒数据的地方
        // 不是读一个字节就从硬盘存到内存，而是读一批然后一起存到内存
        BufferedInputStream ris = new BufferedInputStream(in);
        // 字节流转字符流
        InputStreamReader isr = new InputStreamReader(ris,"utf-8");

        isr.close();
    }
}
