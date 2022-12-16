package com.grad.kata21.singlelinkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        LinkedList.insertNode(list, "A");
        LinkedList.insertNode(list, "B");
        LinkedList.insertNode(list, "C");
        LinkedList.insertNode(list, "D");

        String[] nodes = LinkedList.returnValuesInArray(list);

        for (String str : nodes) {
            System.out.println(str);
        }

        LinkedList.printList(list);

    }

}
