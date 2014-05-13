package collection.stack;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Andrei Petraru
 * 11 Aug 2013
 */

/**
 * A simple generic stack backed up by an array
 */
public class Stack<T> implements Iterable<T> {
	private int size;
	private T[] array;
	private static final int DEFAULT_SIZE = 2;

	public Stack() {
		clear();
	}

	/**
	 * Checks to see if the stack is empty
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Push an item onto the stack
	 * @param item - item pushed onto the stack
	 * @return item pushed onto stack
	 */
	public T push(T item) {
		if (size == array.length) {
			array = Arrays.copyOf(array, size * 2);
		}
		return array[size++] = item;
	}

	/**
	 * Pops an item from the stack
	 * @return item removed from stack
	 */
	public T pop() {
		if (!isEmpty()) {
			return array[--size];
		}
		return null;
	}

	/**
	 * Size of the stack
	 * @return current size of the stack
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all elements from the stack	
	 */
	@SuppressWarnings("unchecked")
	public void clear() {
		array = (T[]) new Object[DEFAULT_SIZE];
	}

	/**
	 * Iterator for the stack
	 * @return an iterator for the stack
	 */
	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<T> {
		private int iterSize = size;

		@Override
		public boolean hasNext() {
			return iterSize > 0;
		}

		@Override
		public T next() {
			return array[--iterSize];
		}

		@Override
		public void remove() {
		}
	}

}
