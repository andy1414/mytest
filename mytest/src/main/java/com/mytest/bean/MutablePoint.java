package com.mytest.bean;

/**
 * Created by admin on 2016/6/15.
 */
public class MutablePoint {
    public int x,y;

    public MutablePoint(){
        x=0;
        y=0;
    }

    public MutablePoint (MutablePoint p){
        this.x = p.x;
        this.y = p.y;
    }
}
