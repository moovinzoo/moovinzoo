// Making Node<E> tutorial
public class Node_dj<E> {

    private E item = null;
    private Node_dj<E> next = null;

    public Node_dj(E _item, Node_dj<E> _next) {
        this.item = _item;
        this.next = _next;
    }

    public Node_dj<E> getNext() { return this.next; }

    public E getItem() { return this.item; }

    public void setNext(Node_dj<E> _next) { this.next = _next; }

    public void setItem(E _item) { this.item = _item; }

}
