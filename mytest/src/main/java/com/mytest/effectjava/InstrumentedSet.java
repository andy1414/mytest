package com.mytest.effectjava;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class InstrumentedSet<E> extends ForwardingSet<E> {

    private int addCount = 0;

    public InstrumentedSet(Set<E> ss) {
        super(ss);
    }

    public boolean add(E ee) {
        addCount++;
        System.out.println(addCount);
        return super.add(ee);
    }

    public boolean addAll(Collection<? extends E> cc) {
        addCount += cc.size();
        return super.addAll(cc);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        Set<Date> ss = new InstrumentedSet<Date>(new HashSet<Date>());

        ss.add(new Date());
    }

}
