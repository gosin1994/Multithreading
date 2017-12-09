package com.github.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: Gosin
 * @Date: 2017/12/9
 */
public class Demo3_Timer {
    public static void main(String[] args) throws InterruptedException {
        Timer t = new Timer();
        //在指定时间安排指定任务
        //第一个参数：要执行的任务；第二个参数：执行的时间；第三个参数：过多久后再重复执行
        t.schedule(new MyTimeTask(),new Date(117,11,9,21,05),3000);
        while(true) {
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }

}

/**
 * 时间任务类
 */
class MyTimeTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("该起床了...");
    }
}