package com.java.gradle;

import java.util.Scanner;

class Person{
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void show(){
        System.out.println("Name is" + name);
        System.out.println("Age is" + age);
        System.out.println("Address is" + address);
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

    public void show(){
        super.show();
        System.out.println("ID is "+ ID);
        System.out.println("grade is "+ grade);
    }
}

public class ObjectArrayEx {
    public static void init(Person[] p) {
        System.out.println("몇 개의 배열을 만들까요?");
        Scanner sc = new Scanner(System.in);
        String name;
        int age;

        for (int i = 0; i < p.length; i++) {
            System.out.println("이름, 나이, 주소를 입력하세요.");
            if()
            p[i] = new Person()
            p[i] =  new Student()
        }
    }

    public void show(Person[] p){
        for(int i=0; i<2; i++){
            p[i].show();
        }
    }

    public static void main(String[] args) {
        Person[] p = new Person[10];
        init(p);

    }
}
