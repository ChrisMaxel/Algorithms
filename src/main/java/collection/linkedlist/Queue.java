package collection.linkedlist;

import java.util.Iterator;

/**
 * A generic queue implementation
 * @author Andrei Petraru
 * 11 Aug 2013
 */
public class Queue<T> implements Iterable<T> {
	private Node first;
	private Node last;
	private int size;

	/**
	 * Adds an item to the queue
	 * @param item - item added to the queue
	 * @return item added to the queue
	 * @throws IllegalArgumentException on null parameter
	 */
	public T enqueue(T item) {
		if (item == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		}
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
		return last.item;
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
		}
		else {
			return null;
		}
	}

	/**
	 * Finds a key in a queue
	 * @param key - key to be found in the queue
	 * @return true if found, false otherwise
	 */
	public boolean find(T key) {
		if (key == null) {
			return false;
		}
		Node node = first;
		while (node != null) {
			if (node.item.equals(key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	/**
	 * Removes the link at the specified index 
	 * @param index - index of link to be removed
	 * @return removed link
	 * @throws IllegalArgumentException if index is invalid
	 */
	public T remove(int index) {
		if (isEmpty()) {
			return null;
		}
		if (size <= index || index < 0) {
			throw new IllegalArgumentException("Position not in list");
		}

		Node current = first;
		Node previous = first;
		for (int i = 0; i < index; i++) {
			previous = current;
			current = current.next;
		}

		return deleteNode(current, previous);
	}

	/**
	 * Removes the specified link if it exists 
	 * @param item - link to be removed
	 * @return removed link
	 */
	public T remove(T item) {
		if (isEmpty() || item == null) {
			return null;
		}

		Node current = first;
		Node previous = first;

		while (current.item != item) {
			if (current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}

		return deleteNode(current, previous);
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
	public Iterator<T> iterator(){
		return new QueueIterator();
	}

	private T deleteNode(Node current, Node previous) {
		if (current == first) {
			first = first.next;
		}
		else {
			previous.next = current.next;
		}
		size--;
		return current.item;
	}

	private class Node {
		private T item;
		private Node next;
	}

	private class QueueIterator implements Iterator<T> {
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
