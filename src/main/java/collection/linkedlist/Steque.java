package collection.linkedlist;

import java.util.Iterator;

/**
 * @author Andrei Petraru
 * 29 Sep 2014
 */
public class Steque<T> implements Iterable<T> {
	private Node node;
	private int size;

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

	private class Node {
		T item;
		Node next;
		Node previous;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}
}
