package com.java.gradle;

import java.util.Random;

class Node {
    private int data;
    Node next;


    public Node(){
        this.data = 0;
        this.next = null;
    }
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public Node getNext(){
        return this.next;
    }
    public int getData(){
        return data;
    }
}

class List {
    private Node first;
    public List(){
        this.first = null;
    }
    public Node getFirst() { return first; }
    public int count() {
        int count = 0;
        Node p = this.first;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public List Split(List b){
        //if(first == null) return new List();
        // 갯수
        // 반 나누기
        List c = new List();
        int count =0;
        Node temp = first;
        while(temp!=null){
            temp=temp.getNext();
            count++;
        }
        Node p = first;
        if(count>2){
            int mid = (int)Math.ceil(count/2.0);
            for (int i = 0; i < mid - 1; i++) {
                p = p.getNext();
            }
        }
        // 리스트 b에 기존의 리스트를 나눈 것 중에 2번째 부분을 넣음
        // p.next 는 나눈 리스트의 2번째
        b.first = p.next;
        // 리스트 c에는 제일 첫번째를 넣음.
        c.first = this.first;
        p.next = null;
        this.first = null;
        return c;
    };

    public List merge(List l){
        List c = new List();
        Node p = this.first;
        Node q = l.first;
        Node r = c.first;

        while(p!=null && q!=null){
            if(p.getData()<q.getData()){
                if(p.next.getData()<q.getData()){
                    c.first = p;
                    p = p.next;
                    continue;
                } else{
                    c.first = p;
                    p = q;
                    continue;
                }
            } else{
                if(q.next.getData()<p.getData()){
                    c.first = q;
                    q = q.next;
                    continue;
                }else{
                    c.first = q;
                    q = p;
                    continue;
                }
            }
        }
        return c;
    };

    public void insert(int n){
        Node x = new Node(n);
        Node p = getFirst();
        Node q = p;
        if(p==null) this.first = x;
        else {
            while (p != null) {
                q = p;
                p = p.getNext();
            }
            q.next = x;
        }
    }

    public void delete(int n){
        Node p = getFirst();
        Node q = p;
        if(p.getData()==n) this.first = p.next;
        while(p!=null) {
            if (p.getData() == n) {
                q.next = p.next;
            }
            q = p;
            p = p.next;

        }
    }
    public void show(){
        Node p = getFirst();
        while(p!=null){
            System.out.print(p.getData()+" ");
            p = p.getNext();
        }
        System.out.println();
    }
}

public class StudyList {
    static void getData(List l, int Size){
        Random r = new Random();
        for(int i =0; i<Size; i++){
            int n = r.nextInt(20);
            l.insert(n);
        }
    }

    static boolean check(int []a){
        for(int i =1; i<a.length; i++){
            if(a[i]>1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // init
        int Size=10;
        List [] l = new List[Size*4];
        for (int i = 0; i<l.length; i++){
            l[i] = new List();
        }
        getData(l[0], Size);
        int k =0;
        l[0].show();
        List temp = new List();
        temp = l[0];
        l[1]= temp;
        int flag=0;
        int count[] = new int[l.length];
        count[1]= l[1].count();
        count[0]=l[0].count();
        // split
        int i = 1;
        while(flag!=1){
           l[2 * i + 1] = l[i].Split(l[2 * i]);
           count[2*i]=l[2*i].count();
           count[2*i+1]=l[2*i+1].count();
           count[i]=0;
           if(check(count)) flag=1;
           i++;
        }

        // show
        for (int j = 0; j<Size*4; j++){
            if(l[j].getFirst() == null) continue;
            else {
                System.out.print("l["+j+"]" + " ");
                l[j].show();
            }
        }

//
//        int p = 2 * a;
//        int q = p;
//        while (p-- > 0)
//        {
//            l[p].count
//        }
    }
}
