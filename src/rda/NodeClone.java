package rda;

import rda.model.Node;

import java.util.HashMap;
import java.util.Map;

public class NodeClone {

    /**
     * Put to buffer Only random data
     *
     * @param node
     * @return clone node
     */
    public static Node clone(Node node) {
        Map<Node, Node> buffer = new HashMap<>();

        Node newNode = create(node, buffer);
        node = node.getNext();
        Node newHead = newNode;

        while (node != null) {
            newNode.setNext(create(node, buffer));
            newNode = newNode.getNext();
            node = node.getNext();
        }
        return newHead;

    }

    private static Node create(Node node, Map<Node, Node> buffer) {
        Node newRandom = createNode(node.getRandom(), buffer, true);
        Node newNode = createNode(node, buffer, false);
        newNode.setRandom(newRandom);
        return newNode;
    }

    private static Node createNode(Node node, Map<Node, Node> buffer, boolean isRandom) {
        Node newNode;
        if (buffer.containsKey(node)) {
            newNode = buffer.get(node);
        } else {
            newNode = new Node(node.getValue());
            if (isRandom) buffer.put(node, newNode);
        }
        return newNode;
    }
}
