package rda.model;


public class Node<T> {

    private final T value;

    protected Node<T> next;

    protected Node<T> random;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getRandom() {
        return random;
    }

    public void setRandom(Node<T> random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public String toJsonWithRandomValue() {
        String v = random == null ? "" : random.value.toString();
        return "{ " +
                "'value':'" + value +
                "', 'random':'" + v +
                "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;
        if (value == null) return false;
        return value.equals(node.value);

    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        return result;
    }
}
