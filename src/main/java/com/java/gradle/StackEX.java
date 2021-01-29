package com.java.gradle;

import java.util.Scanner;

interface Stack{
    boolean isEmpty();
    boolean isFull();
    void push(char item);
    char pop();
    char peek();
    void clear();
}

public class StackEX implements Stack{

    private int top;
    private int stackSize;
    private char stackArr[];

    public StackEX(int stackSize){
        top = -1;
        this.stackSize=stackSize;
        stackArr = new char[this.stackSize];
    }

    public boolean isEmpty(){
        return (top ==-1);
    }

    public boolean isFull(){
        return (top == this.stackSize-1);
    }

    public void push(char item){
        if(isFull()){
            System.out.println("Stack is full!");
        } else{
            stackArr[++top]=item;
            System.out.println("Inserted Item : " + item);
        }
    }

    public char pop(){
        if(isEmpty()){
            System.out.println("Deleting fail! Stack is empty!");
            return 0;
        } else {
            System.out.println("Deleted Item : " + stackArr[top]);
            return stackArr[top--];
        }
    }

    public char peek(){
        if(isEmpty()){
            System.out.println("Peeking fail! Stack is empty!");
            return 0;
        } else {
            System.out.println("Peeked Item : " + stackArr[top]);
            return stackArr[top];
        }
    }

    public void clear(){
        if(isEmpty()){
            System.out.println("Stack is already empty!");
        } else {
            top = -1;
            stackArr = new char[this.stackSize];
            System.out.println("Stack is clear!");
        }
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Stack elements : ");
            for(int i =0; i<=top; i++){
                System.out.println(stackArr[i]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int stackSize = 5;
        StackEX s = new StackEX(stackSize);

        s.push('A');
        s.printStack();
        s.pop();
        s.pop();
        s.clear();
        s.printStack();
    }
}
