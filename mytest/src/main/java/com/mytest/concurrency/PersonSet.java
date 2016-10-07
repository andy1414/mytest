package com.mytest.concurrency.chapter4;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2016/6/15.
 */
public class PersonSet {
    private final Set<Person> myset = new HashSet<Person>();

    public synchronized void addPerson(Person p){
        myset.add(p);
    }

    public synchronized boolean containsPerson(Person person){
        return myset.contains(person);
    }

    public static void main(String[] str){
        PersonSet ps = new PersonSet();
        ps.addPerson(new Person() {
            @Override
            public String toString() {
                return super.toString();
            }
        });
        ps.addPerson(new Person() {
            @Override
            public String toString() {
                return super.toString();
            }
        });

        System.out.println(ps.myset.size());
    }
}

interface Person{

}
