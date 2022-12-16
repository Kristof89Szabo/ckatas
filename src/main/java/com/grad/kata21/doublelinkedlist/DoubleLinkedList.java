package com.grad.kata21.doublelinkedlist;

public class DoubleLinkedList {

    Node head;


    public static void insertNode(DoubleLinkedList list, String value) {

        Node newNode = new Node(value);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node lastNode = list.head;

            while (lastNode.nextNode != null) {
                lastNode = lastNode.nextNode;
            }
            newNode.prevNode = lastNode;
            lastNode.nextNode = newNode;
        }
    }


    public static Node find(DoubleLinkedList list, String searchedValue) {
        Node searchedNode = null;

        if (list.head == null) {
            return null;
        }

        Node actualNode = list.head;
        while (searchedNode == null) {
            if (actualNode.value.equals(searchedValue)) {
                searchedNode = actualNode;
            } else {
                actualNode = actualNode.nextNode;
            }
        }
        return searchedNode;
    }


    public static boolean delete(DoubleLinkedList list, Node node) {
        boolean isNodeDeleted = false;

        Node previousNode = null;
        Node currentNode = list.head;
        Node nextNode = currentNode.nextNode;

        while (!isNodeDeleted) {
            if (currentNode.equals(node) && currentNode.equals(list.head)) {
                list.head = nextNode;
                isNodeDeleted = true;
            } else if (currentNode.equals(node)) {
                previousNode.nextNode = nextNode;
                nextNode.prevNode = previousNode;
                isNodeDeleted = true;
            } else {
                previousNode = currentNode;
                currentNode = nextNode;
                nextNode = nextNode.nextNode;
            }
        }

        return isNodeDeleted;

    }

}
