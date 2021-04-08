public class Node<E> {
    E element;
    Node<E> next;

    // default constructor
    public Node() {
        element = null;
        next = null;
    }

    // contructor with one parameter OR single parameterized constructor
    public Node(E element) {
        this.element = element;
        next = null;
    }

    // double parameterized constructor
    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    public String toString() {
        return element + " -> ";
    }

}