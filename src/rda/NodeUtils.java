package rda;


import rda.model.Node;

public class NodeUtils {

    /**
     * @param node
     * @return
     */
    public static Node clone(Node node) {
        Node startNode = node;
        while (node != null) {
            Node newNode = new Node(node.getValue());
            newNode.setNext(node.getNext());
            node.setNext(newNode);
            node = newNode.getNext();
        }
        node = startNode;
        while (node != null) {
            Node newNode = node.getNext();
            newNode.setRandom(node.getRandom().getNext());
            node = newNode.getNext();
        }
        node = startNode;
        Node newHead = node.getNext();
        while (node != null) {
            Node newNode = node.getNext();
            Node oldNode = node;
            node = newNode.getNext();
            oldNode.setNext(node);
            if (node != null) {
                newNode.setNext(node.getNext());
            }
        }

        return newHead;

    }

}
