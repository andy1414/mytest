package com.mytest.concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by admin on 2016/6/21.
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound){
        this.set = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound);
    }

    public boolean add(T o)throws InterruptedException{
        sem.acquire();
        boolean wasAdded= false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        }finally {
            if(!wasAdded)
                sem.release();
        }
    }

    public boolean remove(Object o){
        boolean wasRomved = set.remove(o);
        if(wasRomved)
            sem.release();
        return wasRomved;
    }
}
