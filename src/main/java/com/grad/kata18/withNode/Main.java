package com.grad.kata18.withNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //        Path path = Path.of("src/main/resources/input");
        Path path = Path.of("src/main/resources/input2");
        Map<Node, Set<Node>> data = getDependencyLinks(path);
        printDepencencyLinks(data);
    }

    private static void printDepencencyLinks(Map<Node, Set<Node>> data) {
        for (Map.Entry<Node, Set<Node>> entry : data.entrySet()) {
            System.out.println(entry.getKey().getName() + entry.getValue());

        }
    }


    private static Map<Node, Set<Node>> getDependencyLinks(Path path) {
        Map<Node, Set<Node>> hMap = new HashMap<>();
        List<Node> keyNodes = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<Node> nodes = convertToNodes(line);
                createLinkBetweenNodes(nodes);
                keyNodes.add(nodes.get(0));
                uploadHasMapWithNode(nodes, hMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finalizeDependencyMap(keyNodes, hMap);
        return hMap;
    }

    private static void finalizeDependencyMap(List<Node> keyNodes, Map<Node, Set<Node>> hMap) {
        for (Map.Entry<Node, Set<Node>> entry : hMap.entrySet()) {
            for (Node node : entry.getValue()) {
                for (Node keyNode : keyNodes) {
                    if (node.getName().equals(keyNode.getName())) {
                        node.setNodeList(keyNode.getNodeList());
                        break;
                    }
                }
            }
        }
    }

    private static void uploadHasMapWithNode(List<Node> nodes, Map<Node, Set<Node>> hMap) {
        Node firstNode = nodes.get(0);
        nodes.remove(0);
        Set<Node> set = hMap.getOrDefault(firstNode, new HashSet<>());
        set.addAll(nodes);
        hMap.put(firstNode, set);
    }

    private static List<Node> convertToNodes(String line) {
        String[] strArr = line.split(" ");
        List<Node> nodes = new ArrayList<>();
        for (String s : strArr) {
            nodes.add(new Node(s));
        }
        return nodes;

    }

    private static void createLinkBetweenNodes(List<Node> nodes) {
        Node node = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            node.addDependencyToNode(nodes.get(i));
        }
    }
}
