package com.grad.kata21.singlelinkedlist;

public class LinkedList {

    Node head;

    public static void insertNode(LinkedList list, String value) {
        Node newNode = new Node(value);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.nextNode != null) {
                last = last.nextNode;
            }
            last.nextNode = newNode;
        }
    }

    public static Node find(LinkedList list, String searchedValue) {
        Node searchedNode = null;

        if (list.head == null) {
            return null;
        }

        Node actualNode = list.head;
        while (searchedNode == null) {
            if (actualNode.label.equals(searchedValue)) {
                searchedNode = actualNode;
            } else {
                actualNode = actualNode.nextNode;
            }
        }
        return searchedNode;
    }

    public static boolean delete(LinkedList list, Node node) {
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
                isNodeDeleted = true;
            } else {
                previousNode = currentNode;
                currentNode = nextNode;
                nextNode = nextNode.nextNode;
            }
        }

        return isNodeDeleted;

    }

    public static String[] returnValuesInArray(LinkedList list) {
        StringBuilder stringBuilder = new StringBuilder();

        Node n = list.head;
        while (n != null) {
            stringBuilder.append(n.label)
                    .append(" ");
            n = n.nextNode;

        }
        return stringBuilder.toString().split(" ");
    }

    public static void printList(LinkedList list) {
        Node currentNode = list.head;
        System.out.println("LinkedList: ");
        while (currentNode != null) {
            System.out.println(currentNode.label + " ");
            currentNode = currentNode.nextNode;
        }
    }

}
