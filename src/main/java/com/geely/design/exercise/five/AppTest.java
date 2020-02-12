package com.geely.design.exercise.five;

class T implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                for (int i = 1; i <= 10 ; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
                try {

                    this.notifyAll();// 唤醒wait而等待的锁
                    this.wait();// 1.释放cpu 2.释放锁, 3.唤醒等待锁的线程(不会唤醒因为wait而阻塞的线程)
                    count++;
                    if (count >= 50) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }
}

public class AppTest {

    public static void main(String[] args) {
        T t = new T();
        Thread th = new Thread(t);
        th.start();// t.run()

        while (true) {
            synchronized (t) {
                for (int i = 1; i <= 100 ; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }

                try {
                    t.notifyAll();// 唤醒wait而等待的锁
                    t.wait(); // 1.释放cpu 2.释放锁, 3.唤醒等待锁的线程(不会唤醒因为wait而阻塞的线程)

                    if (t.getCount() >= 50) {
                        th.notifyAll();
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
