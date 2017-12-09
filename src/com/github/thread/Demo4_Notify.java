package com.github.thread;

/**
 * @Author: Gosin
 * @Date: 2017/12/9
 * 等待唤醒机制
 */
public class Demo4_Notify {
    public static void main(String[] args) {
        final Printer p = new Printer();

        new Thread() {
            public void run(){
                while (true) {
                    try {
                        p.print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            public void run(){
                while (true){
                    try {
                        p.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

class Printer {
    private int flag = 1;
    public void print1() throws InterruptedException {
        synchronized (this) {
            if (flag != 1){
                this.wait();
            }
            System.out.print("G");
            System.out.print("i");
            System.out.print("t");
            System.out.print("\r\n");
            flag = 2;
            this.notify();
        }
    }
    public void print2() throws InterruptedException {
        synchronized (this) {
            if (flag != 2) {
                this.wait();
            }
            System.out.print("H");
            System.out.print("u");
            System.out.print("b");
            System.out.print("\r\n");
            flag = 1;
            this.notify();
        }
    }
}