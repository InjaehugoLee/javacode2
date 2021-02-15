package com.java.gradle;

import java.util.*;

class Node3{
    int data;
    Node3 left, right;
    public Node3(int x){
        data = x;
        left = null;
        right = null;
    }
    public Node3(){
        left = null;
        right = null;
    }
}

public class BinaryTreeEx {
    Node3 root;
    public BinaryTreeEx(){
        root = null;
    }
    public BinaryTreeEx(int x){
        root = new Node3(x);
    }

    public void insert(int x){
        Node3 p = new Node3(x);
        Node3 n = root;
        Node3 q = n;
        if(root==null) {root = new Node3(x); return;}
        else {
            while (n != null) {
                if (n.data > x) {
                    q = n;
                    n = n.left;
                } else {
                    q = n;
                    n = n.right;
                }
            }
            if (q.data > x) {
                q.left = p;
            } else {
                q.right = p;
            }
        }
    }

//    public void delete(int x){ root = deleteRec(root, x);}
//
//    Node3 deleteRec(Node3 root, int x)
//    {
//        if(root==null) return root;
//
//        if(x < root.data)
//            root.left = deleteRec(root.left, x);
//        else if(x > root.data)
//            root.right = deleteRec(root.right, x);
//
//        else{
//            if(root.left ==null) return root.right;
//            else if (root.right == null) return root.left;
//
//            root.data = minValue(root.right);
//
//            root.right = deleteRec(root.right, root.data);
//        }
//        return root;
//    }

    public void delete(int x){
        Node3 remov = root;
        Node3 parentofremov = null;

        while(remov.data!= x){
            parentofremov = remov;

            if(remov.data > x){
                remov = remov.left;
            } else{
                remov = remov.right;
            }
            if(remov ==null) return;
        }

        if(remov.left == null && remov.right == null){
            if(remov == root){
                root = null;
            } else if (remov == parentofremov.right){
                parentofremov.right = null;
            } else {
                parentofremov.left = null;
            }
        }

        else if (remov.left == null){
            if(remov == root){
                root = remov.right;
            } else if(remov == parentofremov.right){
                parentofremov.right = remov.right;
            } else{
                parentofremov.left = remov.right;
            }
        }

        else if (remov.right == null){
            if(remov == root){
                root = remov.left;
            } else if(remov == parentofremov.right){
                parentofremov.right = remov.left;
            } else{
                parentofremov.left = remov.left;
            }
        }

        else{
            Node3 temp = remov;
            Node3 temprepl = temp.right;

            while(temprepl.left !=null){
                temp = temprepl;
                temprepl = temprepl.left;
            }

            if(temprepl!=remov.right){
                temp.left = temprepl.right;
                temprepl.right = remov.right;
            }

            if(remov==root){
                root = temprepl;
            }else if (remov == temp.right){
                temp.right = temprepl;
            }else{
                temp.left = temprepl;
            }
            temprepl.left = remov.left;
        }

    }

    int minValue(Node3 root){
        int minv = root.data;
        while(root.left !=null){
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public void init(BinaryTreeEx t){
        Random r = new Random();
        for(int i=0; i<15; i++){
            int k = r.nextInt(43);
            t.insert(k);
        }
    }

//    public void Split(int i, BinaryTreeEx l, BinaryTreeEx r, Node3 x){
//        if(root == null){
//            l.root = r.root = null;
//            return;
//        }
//
//        Node3 Y = new Node3();
//        Node3 L = Y;
//        Node3 Z = new Node3();
//        Node3 R = Z;
//        Node3 t = root;
//        while(t!=null){
//            if(i==t.data){
//                L.right = t.left;
//                R.left = t.right;
//                x.data = t.data;
//                l.root = Y.right; delete(Y.data);
//                r.root = Z.left; delete(Z.data);
//                return x.data;
//            }
//        }
    public int ldfsSearch(Node3 currentNode) {
        int cnt = 0;
        Node3 pointer = root;
        while (pointer.left != null) {
            cnt++;
            pointer = pointer.left;
        }
        return cnt;
    }

    public int rdfsSearch(Node3 currentNode) {
        int cnt = 0;
        Node3 pointer = root;
        while (pointer.right!= null) {
            cnt++;
            pointer = pointer.right;
        }
        return cnt;
    }

    public void Split(){
        Node3 temp = root;
        Node3 temp2 = root;
        Node3 nroot = root;
        Node3 oroot = root;
        int ld = 0;
        int rd = 0;
        System.out.println(root.data);

        if(root==null) return;
        ld = ldfsSearch(root.left);
        rd = rdfsSearch(root.right);
        System.out.println(ld + "/" + rd);
        int com = (ld-rd)/2 ;
        // 왼쪽이 더 길때
        if(ld-rd>0){
            for(int i =0; i<com; i++){
                temp = nroot;
                nroot= nroot.left;
            }
            temp.left=null;
            root = nroot;
            root.right = oroot;
            System.out.println("이후에"+root.data);
        }
        else{
            for(int i =0; i<com;i++){
                temp = nroot;
                nroot = nroot.left;
            }
            temp.left = null;
            root = nroot;
            root.right = oroot;
            System.out.println("이후에" + root.data);
        }

    }

    public void inshow(Node3 no){
        if(no!=null){
            inshow(no.left);
            System.out.print(no.data + " ");
            inshow(no.right);
        }
        else {
            return;
        }
    }

    public void preshow(Node3 no){
        if(no == null) return;
        System.out.print(no.data + " ");
        preshow(no.left);
        preshow(no.right);
    }

    static void deleteany(BinaryTreeEx t) {
        for (int i = 0; i <15; i++)
            t.delete(i);
    }



    public static void main(String[] args) {
        BinaryTreeEx t = new BinaryTreeEx();
//        t.init(t);
//        t.inshow(t.root);
//        deleteany(t);
//        System.out.println("이후의 값은 ");
//        t.inshow(t.root);
        t.root = new Node3(10);
        t.root.left = new Node3(8);
        t.root.left.left = new Node3(7);
        t.root.left.left.left = new Node3(6);
        t.root.left.left.left.left = new Node3(5);
        t.preshow(t.root);
        System.out.println("이후의 값은 ");

        //t.inshow(t.root);
        //System.out.println("이후의 값은 ");
        t.Split();
        //t.preshow(t.root);
        //System.out.println("이후의 값은 ");

        t.inshow(t.root);


    }
}
