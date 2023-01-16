package com.grad.kata18.withNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    private String name;
    private List<Node> nodeList;


    public Node(String name) {
        this.name = name;
        this.nodeList = new ArrayList<>();
    }

    public void addDependencyToNode(Node node) {
        nodeList.add(node);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + printingFunction(nodeList);
    }

    private String printingFunction(List<Node> list) {
        if (!list.isEmpty()) {
            StringBuilder names = new StringBuilder();

            for (Node node : list) {
                names.append(" ").append(node.name);
                printingFunction(node.getNodeList());
            }
            return names.toString();
        }
        return "";
    }
}
