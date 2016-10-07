package com.mytest.concurrency;

import java.util.Random;

/**
 * Created by admin on 2016/7/5.
 */
public class ReadWriteLock {
    private int readers       = 0;
    private int writers       = 0;
    private int writeRequests = 0;

    public synchronized void lockRead() throws InterruptedException{
        while(writers > 0 || writeRequests > 0){
            wait();
        }
        readers++;
    }

    public synchronized void unlockRead(){
        readers--;
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException{
        writeRequests++;

        while(readers > 0 || writers > 0){
            wait();
        }
        writeRequests--;
        writers++;
    }

    public synchronized void unlockWrite() throws InterruptedException{
        writers--;
        notifyAll();
    }


    public static void main(String args[]) {
        ReadWriteLock rw = new ReadWriteLock();
        Data data = new Data(rw);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"读取到的数据为："+data.get());
                    Thread.sleep(new Random().nextInt(3000));
                    System.out.println(Thread.currentThread().getName()+"读取到的数据为："+data.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

         //10个写线程
              new Thread(new Runnable() {
               @Override
                public void run() {
                   try {
                       data.set("world");
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
                      }).start();



        }


}

class Data {
    private static String name = "hello";
    private ReadWriteLock rwl;
    public Data(ReadWriteLock rwl){
        this.rwl = rwl;
    }

    public String get() throws InterruptedException {
        rwl.lockRead();
        System.out.println(Thread.currentThread().getName() + "--读取数据前：");

        try {
            return name;
        } finally {
            System.out.println(Thread.currentThread().getName() + "--已经读取完");
            rwl.unlockRead();
        }

    }

    public void set(String name) throws InterruptedException {
        rwl.lockWrite();
        try {
            System.out.println(Thread.currentThread().getName() + ">写入数据前");
            this.name = name;
            System.out.println(Thread.currentThread().getName() + ">写完数据");
        } finally {
            rwl.unlockWrite();
        }

    }
}
