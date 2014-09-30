package collection.linkedlist;

import java.util.Iterator;

/**
 * A stack-ended queue or steque is a data type that supports push, pop, and enqueue
 * Steque implementation using linked lists that doesn't allow nulls
 *
 * @author Andrei Petraru
 * 29 Sep 2014
 */
public class Steque<T> implements Iterable<T> {
	private Node first;
	private Node last;
	private int size;

	public T push(T item) {
		if (item == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		}
		Node newNode = first;
		first = new Node();
		first.item = item;
		first.next = newNode;
		if (first.next == null) {
			last = first;
		}
		size++;
		return first.item;
	}

	public T pop() {
		if (first == null) {
			return null;
		}
		T item = first.item;
		first = first.next;
		size--;
		return item;
	}

	public T enqueue(T item) {
		if (item == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		}
		Node newNode = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			newNode.next = last;
		}
		size++;
		return last.item;

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void clear() {
		size = 0;
		first = null;
		last = null;
	}

	private class Node {
		T item;
		Node next;
	}

	@Override
	public Iterator<T> iterator() {
		return new StequeIterator();
	}

	private class StequeIterator implements Iterator<T> {
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
	}

}
