package com.java.gradle;

import java.util.Arrays;
import java.util.Random;

public class MergesortEx {
    static void split(int[][] a, int n){
        int count = n;
        int[] c = new int[20];
        int i = 0;
        int top = 0;
        c[0] =count;
        while (c[i]>1) {
            int mid = count/2;
            for (int k = 0; k < mid; k++) {
                a[i + 1][k] = a[i][k];
            }
            c[i+1]=mid;
            for (int k = 0; k < count - mid; k++) {
                a[i + 2][k] = a[i][mid + k];
            }
            c[i+2]=count-mid;
            i++;
        }
    }
    static int init(int[][] a){
        // 몇 개 입력
        Random r = new Random();
        int num = 7;
        for(int i =0; i< num; i++){
            a[0][i]=r.nextInt(29)+1;
        }
        return num;
    }
    static void print(int[][] a){
        for (int j = 0; j < a.length; j++) {
            System.out.print("a["+j+"] = ");
            for (int i = 0; i < a[0].length; i++) {
                System.out.print(a[j][i] + " > ");
            }
            System.out.println();
        }
    }
    static void merge(int[][] a, int l, int m, int r){

    }

    public static void main(String[] args) {
        int[][] arr= new int[20][20];
        int n = init(arr);
        print(arr);
        System.out.println("After split::");
        split(arr, n);
        print(arr);
        System.out.println("After Merge::");
        //merge(arr, , m, r);
        //print(arr);

    }
}
