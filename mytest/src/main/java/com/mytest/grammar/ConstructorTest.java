package com.mytest.grammar;

import java.util.*;

import com.mytest.bean.Employee1;

/**
 * This program demonstrates object construction.
 * @version 1.01 2004-02-19
 * @author Cay Horstmann
 */
public class ConstructorTest
{
   public static void main(String[] args)
   {
      // fill the staff array with three Employee objects
      Employee1[] staff = new Employee1[3];

      staff[0] = new Employee1("Harry", 40000);
      staff[1] = new Employee1(60000);
      staff[2] = new Employee1();

      // print out information about all Employee objects
      for (Employee1 e : staff)
         System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
               + e.getSalary());
   }
}

