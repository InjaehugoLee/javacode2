package com.java.gradle;

import java.util.Random;

class Listnode{
    private int coef;
    private int expo;
    Listnode next;

    public Listnode(){next = null;}
    public Listnode(int coef, int expo){
        this.coef = coef;
        this.expo = expo;
        next = null;
    }

    public Listnode(int coef, int expo, Listnode next){
        this.coef = coef;
        this.expo = expo;
        this.next =next;
    }

    public int getCoef(){
        return this.coef;
    }
    public void setCoef(int a){
        this.coef += a;
    }

    public int getExpo(){
        return this.expo;
    }
}

public class Polynomial {
    Listnode first;

    public void insert(int coef, int expo){
        Listnode b = new Listnode(coef, expo);
        Listnode p = first;
        Listnode pf = p;

        if(p==null) {first = b; return;}
        if(expo>first.getExpo()){
            b.next = first;
            first = b;
            return;
        }
        while(p!=null){
            if(p.getExpo()< expo){
                pf.next = b;
                b.next=p;
                return;
            }
            else if(p.getExpo()==expo) {
                p.setCoef(p.getCoef() + coef);
                return;
            }
            pf = p;
            p = p.next;
        }
        pf.next = b;
    }
//
//    public Polynomial insertPoly(Polynomial B){
//        Listnode a = this.p;
//        Listnode b = B.p;
//        Polynomial C = new Polynomial();
//
//        while(a!=null && b!=null){
//            if(a.getExpo()< b.getExpo()){
//                C.insert(b.getCoef(), b.getExpo());
//                b = b.next;
//            }
//            else if(a.getExpo()>b.getExpo()){
//                C.insert(a.getCoef(), a.getExpo());
//                a = a.next;
//            }
//            else{
//                C.insert(a.getCoef()+b.getCoef(), a.getExpo());
//                a=a.next;
//                b=b.next;
//            }
//        }
//
//        while(a!=null){
//            C.insert(a.getCoef(), a.getExpo());
//            a=a.next;
//        }
//        while(b!=null){
//            C.insert(b.getCoef(), b.getExpo());
//            b=b.next;
//        }
//        return C;
//    }

    public void show(){
        if(first==null){
            System.out.println("출력할 노드가 없습니다.");
        }else{
            Listnode current = first;
            while(current.next!=null){
                System.out.print(current.getCoef() + "x^"+current.getExpo() + " + ");
                current = current.next;
            }
            System.out.print(current.getCoef()+"x^"+ current.getExpo());
            System.out.println();
        }
    }

    public static Polynomial Add(Polynomial A, Polynomial B){
        Listnode a = A.first;
        Listnode b = B.first;
        Polynomial C = new Polynomial();

        while(a!=null && b!=null){
            if(a.getExpo()< b.getExpo()){
                C.insert(b.getCoef(), b.getExpo());
                b = b.next;
            }
            else if(a.getExpo()>b.getExpo()){
                C.insert(a.getCoef(), a.getExpo());
                a = a.next;
            }
            else{
                C.insert(a.getCoef()+b.getCoef(), a.getExpo());
                a=a.next;
                b=b.next;
            }
        }

        while(a!=null){
            C.insert(a.getCoef(), a.getExpo());
            a=a.next;
        }
        while(b!=null){
            C.insert(b.getCoef(), b.getExpo());
            b=b.next;
        }
        return C;
    }
    static void makePolynomial(Polynomial A){
        Random r = new Random();
        int coef, expo;
        for(int i =0; i< 5; i++){
            coef = r.nextInt(22);
            expo = r.nextInt(10);
            A.insert(coef, expo);
        }

    }
    public static void main(String[] args) {
        Polynomial A = new Polynomial();
        makePolynomial(A);
        A.show();

        Polynomial B = new Polynomial();
        makePolynomial(B);
        B.show();

        Polynomial C = Add(A, B);
        C.show();
    }
}
