
public class MyStack<E> implements Stack<E> {

	private Node_dj<E> top = null;
	private int length = 0;

	@Override
	public void clear() {
		// TODO
		this.top = null;
		this.length = 0; // Idea : like re-construct
	}

	@Override
	public void push(E it) {
		// TODO
		Node_dj<E> oldTop = this.top;
		this.top = new Node_dj<>(it, null);
		top.setNext(oldTop);

		this.length++;
	}

	// TODO
	@Override
	public E pop() {
		if (this.length() == 0) {
			return null;
		}

		E topItem = this.top.getItem();
		this.top = this.top.getNext();
		this.length--;

		return topItem;
	}

	// TODO
	@Override
	public E topValue() {
		return top.getItem();
	}

	// TODO done
	@Override
	public int length() {
		return this.length;
	}

	public String toString() {
		Node_dj<E> cursor = top;
		StringBuffer sb = new StringBuffer("(");
		while (cursor != null) {
			sb.append(cursor.getItem());
			if (cursor.getNext() != null) {
				sb.append(' ');
			}
			cursor = cursor.getNext();
		}
		sb.append(")");

		return sb.toString();
	}

}



//	public String toString() {
//		StringBuilder s = new StringBuilder();
//		for (E item : this) {
//			s.append(item);
//			s.append(' ');
//		}
//
//		return s.toString();
//	}
//
//	public Iterator<E> iterator() {
//		return new ListIterator();
//	}
//
//	private class ListIterator implements Iterator<E> {
//		private Node_dj<E> current = top;
//		public boolean hasNext() {
//			return current != null;
//		}
//
//		public void remove() {
//			throw new UnsupportedOperationException();
//		}
//
//		public E next() {
//			if (!hasNext()) {
//				throw new NoSuchElementException();
//			}
//
//			E item = current.getItem();
//			current = current.getNext();
//			return item;
//		}
//	}
