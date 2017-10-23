package com.miso.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wushiyi on 2017-10-20.
 */
public class MyLink implements Cloneable{

    Node head;
    Node current;


    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 实现增加
     * @param data
     */
    public void add(int data){
        if(head == null){
            head = new Node(data);
            current = head;
        }else {
            current.next = new Node(data);
            current = current.next;
        }

    }

    public void printAll(){
        if(head == null){
            System.out.println("链表无数据");
        }
        current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }


    public int getLength(){
        if(head == null) return 0;

        int count = 0;
        current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty(){
        return head==null;
    }



    public static void main(String[] args) {
        MyLink myLink = new MyLink();
        for (int i = 0;i<10;i++){
            myLink.add(i);
        }
        myLink.printAll();
    }

}
