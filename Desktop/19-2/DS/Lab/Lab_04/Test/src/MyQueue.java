public class MyQueue<E> implements Queue<E>{

    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;

    @Override
    public void enqueue(E _item) {
        Node<E> newNode = new Node<>(_item, null);

        if (size == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = last.getNext();
        }

        size++;
    }

    @Override
    public E dequeue(){

        if (size == 0) return null;

        Node<E> tmp = first;
        first = first.getNext();
        size--;

        return tmp.getItem();
    }

    @Override
    public E pop(){

        if (size == 0) return null;

        Node<E> curr = first;
        if (size == 1) {
            clear();
            return curr.getItem();
        }

        while (curr.getNext() != last) {
            curr = curr.getNext();
        }

        E item = last.getItem();
        last = curr;
        last.setNext(null);
        size--;

        return item;
    }

    @Override
    public void clear(){
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("("); // Initialization
        Node<E> cursor = first;
        while (cursor != null) {
            sb.append(cursor.getItem());
            if(cursor != this.last) {
                sb.append(" ");
            }
            cursor = cursor.getNext();
        }

        sb.append(")");
        return sb.toString();
    }
}
