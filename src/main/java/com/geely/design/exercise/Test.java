package com.geely.design.exercise;

class Foo {
    public int x = 1;
}

class T implements Runnable {

    private Foo foo;

    public T(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        synchronized (foo) {
            for (int i = 1; i <= 52; i++) {
                while (foo.x != 1) {
                    try {
                            //唤醒对方
                            foo.notifyAll();
                            //自己睡
                            foo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);

                if (i%2==0) {
                    foo.x = 2;
                }
            }
        }
    }
}

class S implements Runnable {
    private Foo foo;

    public S(Foo foo) {
        this.foo = foo;
    }
    @Override
    public void run() {
        synchronized (foo) {
            for (int i = 'A'; i <= 'Z'; i++) {

                while (foo.x != 2) {
                    try {
                        //唤醒对方
                        foo.notifyAll();
                        //自己睡
                        foo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println((char) i);
                foo.x=1;
            }
        }
    }
}


public class Test {

    public static void main(String[] args) {

        Foo foo = new Foo();
        T t = new T(foo);
        S s = new S(foo);

        Thread th = new Thread(t);
        Thread th2 = new Thread(s);

        th.start();
        th2.start();
    }
}
