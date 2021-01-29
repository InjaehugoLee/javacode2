package com.java.gradle;

import java.util.Scanner;
import java.util.Stack;

class Person{
    private String name;
    private int age;
    private String address;

    public Person(){}
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void show(){
        System.out.println("Name is " + name);
        System.out.println("Age is " + age);
        System.out.println("Address is " + address);
    }
}

class Student extends Person {
    private String ID;
    private String grade;
    public Student(String name, int age, String address, String ID, String grade) {
        super(name, age, address);
        this.ID = ID;
        this.grade = grade;
    }

    @Override
    public void show(){
        super.show();
        System.out.println("ID is "+ ID);
        System.out.println("grade is "+ grade);
    }
}

public class ObjectArrayEx {
    static void init(Person []px) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.println("number of objects::");
        n = scan.nextInt();
        for (int i = 0; i<n; i++) {
            px[i] = new Person("홍"+i, i, "김해"+i);
        }
    }

    static void display(Person []px){
        for(int i=0; i<px.length; i++){
            px[i].show();
        }
    }

    static Person[] dostack(Person []px){
        Stack <Person> stack = new Stack<>();
        Person []pp = new Person[10];
        for(int i=0; i<px.length; i++){
            stack.push(px[i]);
        }
        for(int i=0; i<px.length; i++){
             pp[i] = stack.pop();
             //stack.pop().show();
        }
        return pp;
    }

    public static void main(String[] args) {
        int []  a;
        Person []p = new Person[10];
        Person [] result;
        init(p);
        display(p);
        System.out.println("============");
        result = dostack(p);
        //dostack(p);
        display(result);
    }
}
