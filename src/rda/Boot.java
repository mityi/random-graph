package rda;

import rda.model.Node;

import java.util.ArrayList;
import java.util.Random;

public class Boot {

    public static void main(String[] args) {
        Node<Integer> integerNode = create(32);
        Node clone = NodeUtils.clone(integerNode);
//        Node clone = NodeClone.clone(integerNode);
        while (integerNode != null) {

            assert integerNode.getValue().equals(clone.getValue());
            assert integerNode.getRandom().getValue().equals(clone.getRandom().getValue());

            System.out.println(
                    integerNode.toJsonWithRandomValue() + '/' +
                            clone.toJsonWithRandomValue());

            integerNode = integerNode.getNext();
            clone = clone.getNext();
        }
        if (clone != null) {
            System.err.println("ERROR");
        }
    }


    static Node<Integer> create(int count) {
        ArrayList<Node> nodes = new ArrayList<>(count);
        Node node = new Node(count);
        Node head = node;
        nodes.add(head);
        while (count > 0) {
            count--;
            node.setNext(new Node(count));
            node = node.getNext();
            nodes.add(node);
        }
        Random random = new Random();
        nodes.forEach(n ->
                n.setRandom(
                        nodes.get(
                                random.nextInt(nodes.size()))));
        return head;
    }


}
