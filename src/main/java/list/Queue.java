package list;

import java.util.Iterator;

/**
 * @author Andrei Petraru
 * Aug 11, 2013
 */
public class Queue<T> implements Iterable<T> {
	private Node first;
	private Node last;
	private int size;

	/**
	 * Adds an item to the queue
	 * @param item - item added to the queue
	 */
	public void enqueue(T item) {
		Node newLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}
		else {
			newLast.next = last;
		}
		size++;
	}

	/**
	 * Removes an item from the queue
	 * @return removed item
	 */
	public T dequeue() {
		if (!isEmpty()) {
			T item = first.item;
			first = first.next;
			size--;
			return item;
		} else {
			return null;
		}
		
	}

	/**
	 * Size of the queue
	 * @return current size of the queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Checks to see if the queue is empty
	 * @return true if the queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Removes all elements from the queue	
	 */
	public void clear() {
		first = null;
		last = null;
	}

	/**
	 * Queue iterator
	 * @return an iterator for the queue
	 */
	@Override
	public Iterator<T> iterator() {
		return new QueueInterator();
	}

	private class Node {
		private T item;
		private Node next;
	}

	private class QueueInterator implements Iterator<T> {
		private Node iterNode = first;

		@Override
		public boolean hasNext() {
			return iterNode != null;
		}

		@Override
		public T next() {
			T item = iterNode.item;
			iterNode = iterNode.next;
			return item;
		}

		@Override
		public void remove() {
		}
	}

	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		q.enqueue("vasile");
		q.enqueue("gigi");
		q.enqueue("ion");
		for (String s : q) {
			System.out.println(s);
			System.out.println(q.dequeue());
		}
	}
}
