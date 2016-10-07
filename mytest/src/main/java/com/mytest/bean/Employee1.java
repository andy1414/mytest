package com.mytest.bean;

import java.util.Random;

public class Employee1
{
    private static int nextId;

    private int id;
    private String name = ""; // instance field initialization
    private double salary;
   
    // static initialization block
    static
    {
       Random generator = new Random();
       // set nextId to a random number between 0 and 9999
       nextId = generator.nextInt(10000);
       System.out.println("static init!");
    }

    // object initialization block
    {
       id = nextId;
       nextId++;
       System.out.println("non-static init!");
    }

    // three overloaded constructors
    public Employee1(String n, double s)
    {
       name = n;
       salary = s;
       System.out.println("three overloaded constructors init!");
    }

    public Employee1(double s)
    {
       // calls the Employee(String, double) constructor
       this("Employee #" + nextId, s);
       System.out.println("Employee(String, double) constructor init!");
    }

    // the default constructor
    public Employee1()
    {
       // name initialized to ""--see above
       // salary not explicitly set--initialized to 0
       // id initialized in initialization block
        System.out.println("default init!");
    }

    public String getName()
    {
       return name;
    }

    public double getSalary()
    {
       return salary;
    }

    public int getId()
    {
       return id;
    }
    
    
}
