package com.grad.kata18.withNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

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
        StringBuilder names = new StringBuilder();
        if (!list.isEmpty()) {

            for (Node node : list) {
                names.append(node.name);
                String retDep = printingFunction(node.getNodeList());
                if (names.indexOf(retDep) == -1) {
                    names.append(retDep);
                }
            }
        }
        return names.toString();
    }

    static String removeDuplicate(String str) {
        char[] chars = str.toCharArray();
        Set<Character> s = new TreeSet<>();
        // HashSet doesn't allow repetition of elements
        for (char x : chars) {
            s.add(x);
        }
        return s.toString();
    }

}
