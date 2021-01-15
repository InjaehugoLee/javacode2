package Heap;

import java.util.Random;

public class Heap2 {

    static int deletemax(int[] arr){
        int max=arr[1];
        int count=arr[0];
        int key = arr[count];
        arr[0]--;
        if(arr[0]==0) return arr[2];
        int d=1;
        int flag=0;
        while(flag==0) {
            if (arr[d * 2] < arr[d * 2 + 1]) {
                if(key>arr[d*2+1]){
                    arr[d]=key;
                }
                else
                {
                    int temp=arr[d*2+1];
                    arr[d*2+1]=key;
                    arr[d]=temp;
                }
                d = d * 2 + 1;
            }
            else {
                if(key>arr[d*2]){
                    arr[d]=key;
                }
                else{
                    int temp=arr[d*2];
                    arr[d*2]=key;
                    arr[d]=temp;
                }
                d = d * 2;
            }
            if(d*2>arr[0]||d*2+1>arr[0]) flag=1;
        }
        return max;
    }

    static int[] sortHeap(int[] arr) {

        int[] result = new int[arr.length];
        int[] temp = new int[arr.length];
        temp = arr;
        result[0] = arr[0];
        int n = arr[0];
        for (int i = n; i >= 1; i--) {
            result[i] = deletemax(temp);
        }
        return result;
    }

        static void printArray(int[] arr){

            int n = arr[0];
            for (int i =1; i <= n; ++i) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
    }

    static void init(int []arr){
        Random random = new Random();
        int s = 15;
        for(int i=1; i<= s; i++){

            arr[i]=random.nextInt(100)+1;
            int k = i;
            //System.out.println("k = " + k);
            while(k>1) {
                if (arr[k] > arr[k / 2]) {
                    int temp = arr[k];
                    arr[k] = arr[k / 2];
                    arr[k / 2] = temp;
                }
                k = k / 2;
            }
        }
        arr[0]= s;
    }

    public static void main(String args[]){
        int []arr= new int[16];
        int []temp;
        //int[] arr={12,12,3,5,8,12,9,4,6,7,11,10,12};
        init(arr);
        printArray(arr);
        //makeHeap(arr);
        //printArray(arr);
        temp = sortHeap(arr);
        printArray(temp);
        //temp = sortHeap(arr);
        //printArray(temp);
    }
}
