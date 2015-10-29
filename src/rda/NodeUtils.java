package rda;


import rda.model.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NodeUtils {

    public static Node clone(Node node) {
        Map<Node, List<Node>> bufferContains = new HashMap<>();
        Map<Node, Node> buffer = new HashMap<>();

        Node newNode = new Node(node.getValue());
        putToBuffers(node, newNode, bufferContains, buffer);
        node = node.getNext();

        Node newHead = newNode;

        while (node != null) {
            newNode.setNext(new Node(node.getValue()));
            newNode = newNode.getNext();
            putToBuffers(node, newNode, bufferContains, buffer);
            node = node.getNext();
        }

        buffer.keySet().forEach(origin -> {
            Node copy = buffer.get(origin);
            List<Node> randomContains = bufferContains.get(origin);
            if (randomContains != null) {
                randomContains.forEach(contains -> contains.setRandom(copy));
            }
        });
        return newHead;

    }

    private static void putToBuffers(Node node, Node newNode,
                                     Map<Node, List<Node>> bufferContains, Map<Node, Node> buffer) {
        if (node.getRandom() != null) {
            if (!bufferContains.containsKey(node.getRandom())) {
                bufferContains.put(node.getRandom(), new LinkedList<>());
            }
            bufferContains.get(node.getRandom()).add(newNode);
        }

        buffer.put(node, newNode);
    }
}
