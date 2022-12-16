package com.grad.kata21.singlelinkedlist;

import java.util.Objects;

public class Node {

    String label;
    Node nextNode;

    public Node(String label) {
        this.label = label;
        this.nextNode = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(label, node.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "Node{" +
                "label='" + label + '\'' +
                ", nextNode=" + nextNode +
                '}';
    }
}
