package com.mytest.concurrency.chapter5;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by admin on 2016/6/23.
 */
public class Memoizer<A,V> implements Computable<A,V> {
    private final Map<A, Future<V>> cache
            = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }


    @Override
    public V compute(A arg) throws InterruptedException {
        return null;
    }
}

interface Computable<A,V>{
    V compute(A arg) throws InterruptedException;
}
