package com.mytest.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/6/10.
 */
public class Testfengjie {
    public List<Long> result = new ArrayList<Long>();
    private void fengjie(int n)throws Exception{
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                result.add(Long.valueOf(i));
                fengjie(n/i);
            }
        }
        result.add(Long.valueOf(n));
        throw new Exception("end");
    }

    public static void main(String[] args){
        String str="";
        Testfengjie c=new Testfengjie();
        str=javax.swing.JOptionPane.showInputDialog("请输入N的值（输入exit退出）：");
        int N;
        N=0;
        try{
            N=Integer.parseInt(str);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        System.out.print(N+"分解质因数："+N+"=");
        try{
            c.fengjie(N);
        }catch(Exception e){
        }

        for (Long bb : c.result) {
            System.out.println(bb+"*");
        }
    }
}
