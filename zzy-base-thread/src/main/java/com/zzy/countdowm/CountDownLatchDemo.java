package com.zzy.countdowm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo implements Runnable {

    static final CountDownLatch latch = new CountDownLatch(100);

    @Override
    public void run() {
        // 模拟检查任务
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //计数减一
            //放在finally避免任务执行过程出现异常，导致countDown()不能被执行
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        final CountDownLatch countDownLatch = new CountDownLatch(list.size());

        for (Integer i : list) {
            final int a = i;
            executorService.execute(() -> {
                System.err.println(a);
                countDownLatch.countDown();
            });
        }

        // 等待检查
        countDownLatch.await(10, TimeUnit.SECONDS);

        // 发射火箭
        System.out.println("Fire!");
        // 关闭线程池
        executorService.shutdown();
    }
}
