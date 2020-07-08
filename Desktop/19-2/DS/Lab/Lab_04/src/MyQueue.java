
public class MyQueue<E> implements Queue<E> {

	private Node<E> first = null;
	private Node<E> last = null;
	private int size = 0;

	@Override
	public void enqueue(E item) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node<E>(item, null);

		if (this.size == 0) {
			this.first = newNode;
			this.last = newNode;
		} else {
			this.last.setNext(newNode);
			this.last = newNode;
		}
		this.size++;
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if (this.size > 0) {
			Node<E> tmp = first;
			this.first = this.first.getNext();
			this.size--;

			return tmp.getItem();
		}
		return null;
	}

	@Override
	public E pop() {

		// TODO Auto-generated method stub
		if (size==0)
			return null;
		if (size==1)
		{}
		Node<E> curr = first;
		while(curr.getNext() != last){
			curr = curr.getNext();
		}
		if (this.size > 0) {
			Node<E> tmp = first;
		    for (int i = 0; i < this.size - 2; i++) {
				tmp = tmp.getNext();
			}
			E tmpItem = last.getItem();

		    this.last = tmp;
		    this.last.setNext(null);
			this.size--;

		    return tmpItem;
		}

		return null;
	}

	@Override
	public void clear() {
	    this.first = null;
	    this.last = null;
	    this.size = 0;

	}


	@Override
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public String toString() {
		Node<E> cursor = first;
		StringBuffer sb = new StringBuffer("(");
		while (cursor != null) {
			sb.append(cursor.getItem());
			if (cursor != last) {
				sb.append(' ');
			}
			cursor = cursor.getNext();
		}
		sb.append(")");
		return sb.toString();
	}

}
