package com.mytest.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2016/6/16.
 */
public class TestHarness {
    public long timeTasks(int nThreads,final Runnable task) throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i <nThreads ; i++) {
            Thread t  = new Thread(){
                public void run(){
                    try{
                     startGate.await();
                        try{
                            task.run();
                        }finally {
                            endGate.countDown();
                        }
                    }catch (InterruptedException ignord){

                    }
                }

            };
            t.start();
        }


        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end-start;


    }
}
