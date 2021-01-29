package com.java.gradle;

import java.util.Stack;

// class
abstract class TwoDimShape{
    protected int x, y;
    public TwoDimShape(int x, int y){
        this.x = x;
        this.y = y;
    }
    public abstract double getArea();
}

class Triangle extends TwoDimShape{
    private int h;
    private int b;
    public Triangle(int x, int y, int h, int b){
        super(x, y);
        this.h = h;
        this.b = b;
    }
    public double getArea(){
        return this.h*this.b/2;
    }
    public void show(){
        System.out.println("[Triangle 정보]"+"x="+x+","+"y="+y+","+"height ="+this.h+"base ="+b);
    }
}

class Circle extends TwoDimShape{
    private int r;
    private double PI = 3.14;
    public Circle(int x, int y, int r){
        super(x, y);
        this.r = r;
    }
    public double getArea(){
        return r*r*PI;
    }
    public void show(){
        System.out.println("[Circle 정보]"+"x="+x+","+"y="+y+","+"radius ="+r);
    }
}

class Rectangle extends TwoDimShape{
    private int width;
    private int length;
    public Rectangle(int x, int y, int width, int length){
        super(x,y);
        this.width=width;
        this.length=length;
    }
    public double getArea(){
        return width*length;
    }
    public void show(){
        System.out.println("[Rectangle 정보]"+"x="+x+","+"y="+y+","+"width ="+width+","+"length ="+length);
    }
}

public class ShapeEx {
    // function

    public static void main(String[] args) {
        Triangle t = new Triangle(20, 40, 2, 3);
        t.show();
        System.out.println(t.getArea());

        Circle c = new Circle(1,2,3);
        c.show();
        System.out.println(c.getArea());

        Rectangle a = new Rectangle(10, 10, 3, 4);
        a.show();
        System.out.println(a.getArea());

//        TwoDimShape[] td = new TwoDimShape[5];
//        td[0]=t;
//        td[1]=c;
//        td[2]=a;
//        //Stack<TwoDimShape> st = new Stack<>();
//        dostack();
    }
}
