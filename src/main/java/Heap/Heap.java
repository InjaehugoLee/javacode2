package Heap;

import java.util.Scanner;

public class Heap {
    public static int[] init(){
        int[] array = new int[10];
        for(int i=1; i<array.length; i++){
            array[i]=(int)(Math.random()*100)+1;
            int j = i;
            while(j/2!=0){
                if(array[j]>array[j/2]){
                    swap(array, j, j/2);
                }
                j=j/2;
            }
        }
        array[0]=9;
        return array;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static int deletemax(int[] array){
        int max=array[1];
        array[0]--;
        int x = array[array[0]];
        int i = 1;
        while(i*2<array[0]){
            if(i*2==array[0]){
                if(array[i*2]>x){
                    array[i]=array[i*2];
                    array[i*2]=x;
                    return max;
                }
                array[i]=x;
                return max;
            }
            if(x>array[i*2] && x > array[i*2+1]){
                array[i]=x;
                return max;
            }
            if(x<array[i*2] && array[i*2] > array[i*2+1]){
                array[i]=array[i*2];
                i=i*2;
            }
            if(x<array[i*2+1] && array[i*2] < array[i*2+1]){
                array[i]=array[i*2+1];
                i=i*2+1;
            }
        }
        array[i]=x;
        return max;
    }
    public static void show(int[] temp){
        int[] temp2 = new int[10];
        temp2 = temp;
        for(int i=1; i<temp2.length; i++){
            System.out.print(temp2[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] temp = new int[10];
        //int[] result = new int[10];
        temp=init();
        show(temp);
        int a = deletemax((temp));
        System.out.println(a);
        while(temp[0]==0) {
            int result = deletemax(temp);
            System.out.println(result);
        }
    }
}
