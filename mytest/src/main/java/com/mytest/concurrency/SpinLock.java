package com.mytest.concurrency;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by admin on 2016/7/4.
 */
public class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock(){
        Thread current  = Thread.currentThread();
        while (!sign.compareAndSet(null,current)){

        }
    }

    public void unlock (){
        Thread current = Thread.currentThread();
        sign .compareAndSet(current, null);
    }

}
