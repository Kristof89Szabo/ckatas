package com.grad.kata21.doublelinkedlist;


public class Main {

    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();

        DoubleLinkedList.insertNode(list, "A");
        DoubleLinkedList.insertNode(list, "B");
        DoubleLinkedList.insertNode(list, "C");
        DoubleLinkedList.insertNode(list, "D");

        Node s = new Node("B");
        DoubleLinkedList.delete(list, s);
        System.out.println("Yes");

    }
}
