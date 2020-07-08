public class Node<E> {

    private E item = null;
    private Node<E> next = null;

    public Node(E _item, Node<E> _next) {
        this.item = _item;
        this.next = _next;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public E getItem() {
        return this.item;
    }

    public void setNext(Node<E> _next) {
        this.next = _next;
    }

    public void setItem(E _item) {
        this.item = _item;
    }
}