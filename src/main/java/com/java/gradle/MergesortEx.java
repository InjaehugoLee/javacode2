package com.java.gradle;

 import java.util.Scanner;

 class Node2{
     private int data;
     private Node2 next;

     Node2(){
         this.data = 0;
         this.next = null;
     }

     Node2(int data){
         this.data = data;
         this.next = null;
     }

     void Setnext(Node2 nextnode){
         this.next = nextnode;
     }

     Node2 Getnext(){
         return this.next;
     }

     void Setdata(int data){
         this.data = data;
     }

     int Getdata(){
         return this.data;
     }
 }

 class LinkedList{
     private Node2 head;

     LinkedList(){
         this.head = null;
     }

     void Insert_data(int data){
         if(head == null){
             this.head = new Node2(data);
         }
         else{
             Node2 temp;
             temp = this.head;
             while(temp.Getnext() != null){
                 temp = temp.Getnext();
             }
             temp.Setnext(new Node2(data));
         }
     }

     void Show_Linked(){
         if(this.head == null){
             System.out.print("Empty ");
             return;
         }
         Node2 temp;
         temp = this.head;
         while(temp != null){
             System.out.print(temp.Getdata() + " ");
             temp = temp.Getnext();
         }
         //System.out.println();
     }

     void Sethead(Node2 L_node){
         this.head = L_node;
     }

     Node2 Gethead(){
         return this.head;
     }
 }

 public class MergesortEx {

     static LinkedList[] MakeArr(){
         Scanner scanner = new Scanner(System.in);

         int data;
         int cnt = 0;
         LinkedList dummy = new LinkedList();

         System.out.print("Input an integer(exit input 0) >> ");
         while( 0 < (data = scanner.nextInt())){
             dummy.Insert_data(data);
             cnt++;
         }

         System.out.println(" List-Size : " + cnt);

         LinkedList[] ret = new LinkedList[cnt*2-1];

         for(int i = 0; i < ret.length; i++){
             ret[i] = new LinkedList();
         }

         ret[0].Sethead(dummy.Gethead());

         dummy.Sethead(null);

         System.out.println("Array-Size : " + ret.length);

         scanner.close();

         return ret;
     }

     static void split(LinkedList[] Link){
         int[] N = new int[Link.length];

         N[0] = (Link.length+1)/2; // 전체 노드의 개수를 넣어준다

         for(int i =0; i < Link.length/2; i++){

             // Complete binary tree를 맹글어 보자
             int L = 0;

             // 2ⁿ< N < 2ⁿ＋¹
             for(int j = 0 ; ;j++){
                 if(Math.pow(2,j) > N[i]){
                     // N = 2ⁿ + 2ⁿ－¹ + a
                     int a = N[i] - (int)Math.pow(2,j-1) - (int)Math.pow(2,j-2);

                     if(a > 0){
                         L = N[i] - ((int)Math.pow(2,j-2)+a);
                     }
                     else
                     {
                         L = (int)Math.pow(2,j-1) + a;
                     }

                     N[i*2+1] = L;   // i번째 왼쪽의 노드 개수

                     N[i*2+2] = N[i]-L; //       오른쪽의 노드의 개수

                     break;
                 }
             }

             Node2 temp = Link[i].Gethead();

             for(int j = 1 ; j < L; j++){
                 temp = temp.Getnext();
             }

             Link[2*i+2].Sethead(temp.Getnext());     // 오른쪽의 노드의 시작점 설정

             temp.Setnext(null);                      // 노드의 연결을 끊는다

             Link[2*i+1].Sethead(Link[i].Gethead());  // 왼쪽의 노드의 시작점 설정


             Link[i].Sethead(null);                   // 현재 배열의 head를 null로 초기화

         }
     }

     static void merge(LinkedList[] Link) {
         for (int i = Link.length - 1; i > 0; i -= 2) {
             Node2 left = Link[i - 1].Gethead(); // 왼쪽 노드
             Node2 right = Link[i].Gethead();    // 오른쪽 노드
             Node2 P = Link[(i - 2) / 2].Gethead(); // 부모 노드

             while (left != null || right != null) {
                 if (left == null) {     // 자식 노드들 중 하나의 노드가 null이 되면 다른 노드를 뒤에 붙여준다
                     P.Setnext(right);
                     break;
                 }
                 else if (right == null) {
                     P.Setnext(left);
                     break;
                 }
                 else if (left.Getdata() < right.Getdata()) {
                     if (Link[(i - 2) / 2].Gethead() == null) {
                         P = left;
                         Link[(i - 2) / 2].Sethead(P);
                         left = left.Getnext();
                     } else {
                         P.Setnext(left);
                         P = P.Getnext();
                         left = left.Getnext();
                     }
                 }
                 else{
                     if (Link[(i - 2) / 2].Gethead() == null) {
                         P = right;
                         Link[(i - 2) / 2].Sethead(P);
                         right = right.Getnext();
                     } else {
                         P.Setnext(right);
                         P = P.Getnext();
                         right = right.Getnext();
                     }
                 }
             }

             Link[i].Sethead(null);
             Link[i - 1].Sethead(null);
         }
     }

     static void showLink( LinkedList[] Link ){
         for(int i = 0; i < Link.length; i++){
             System.out.print("Link[" + i + "] = ");
             Link[i].Show_Linked();
             System.out.println();
         }
     }

     public static void main(String[] args){

         LinkedList[] Link = MakeArr();

         split(Link);

         showLink(Link);

          merge(Link);

         showLink(Link);

     }
 }
