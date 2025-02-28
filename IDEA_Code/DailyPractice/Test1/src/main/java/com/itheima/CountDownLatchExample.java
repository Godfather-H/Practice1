package com.itheima;

import java.util.concurrent.CountDownLatch;

//运动员线程类
class Athlete implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch finishSignal;
    private final int athleteNumber;

    Athlete(CountDownLatch startSignal, CountDownLatch finishSignal, int athleteNumber) {
        this.startSignal = startSignal;
        this.finishSignal = finishSignal;
        this.athleteNumber = athleteNumber;
    }

    @Override
    public void run() {
        try {
            //等待起跑信号
            startSignal.await();
            System.out.println("运动员 " + athleteNumber + " 开始比赛");
            //模拟运动员比赛所需的时间
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println("运动员 " + athleteNumber + " 完成比赛");
            //运动员比赛
            finishSignal.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class CountDownLatchExample {
    public static void main(String[] args) {
        //运动员数量
        int athleteCount = 5;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch finishSignal = new CountDownLatch(athleteCount);
        for (int i = 0; i < athleteCount; i++) {
            new Thread(new Athlete(startSignal, finishSignal, i)).start();
        }
        System.out.println("裁判准备发令...");
        try {
            //模拟裁判准备时间
            Thread.sleep(2000);
            System.out.println("裁判发令，比赛开始!");
            //起跑信号，计数器减为0，所有运动员开始比赛
            startSignal.countDown();
            //裁判等待搜友运动员完成比赛
            finishSignal.await();
            System.out.println("所有运动员完成比赛，比赛结束!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
