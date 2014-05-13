package collection.list;

import java.util.Iterator;

/**
 * A generic stack implementation
 * @author Andrei Petraru
 * 11 Aug 2013
 */

public class Stack<T> implements Iterable<T> {
	private Node node;
	private int size;

	/**
	 * Inserts a new item
	 * @param item - item to be inserted
	 * @return item pushed onto stack
	 * @throws IllegalArgumentException on null parameter 
	 */
	public T push(T item) {
		if (item == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		}
		Node newNode = node;
		node = new Node();
		node.item = item;
		node.next = newNode;
		size++;
		return node.item;
	}

	/**
	 * Pops an item from the stack
	 * @return item removed from stack, null if stack is empty
	 */
	public T pop() {
		if (node == null) {
			return null;
		}
		T item = node.item;
		node = node.next;
		size--;
		return item;
	}

	/**
	 * Checks to see if the stack is empty
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return node == null;
	}

	/**
	 * Removes all elements from the stack	
	 */
	public void clear() {
		node = null;
		size = 0;
	}

	/**
	 * Iterator for the stack
	 * @return an iterator for the stack
	 */
	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}

	/**
	 * Size of the stack
	 * @return current size of the stack
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Retrieve the value on the top of the stack without removing it 
	 * @return top of the stack
	 */
	public T peek() {
		if (node == null) {
			return null;
		}
		return node.item;
	}

	private class Node {
		private T item;
		private Node next;
	}

	private class StackIterator implements Iterator<T> {
		private Node iterNode = node;

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

}
