package stack

class Stack {
	int size
	int iter
	def entries
	final static DEFAULT_SIZE = 16

	Stack() {
		clear()
	}

	/**
	 * Push an item onto the stack
	 * @param item - item pushed onto the stack
	 * @return item added to stack
	 */
	def push(item) {
		if (size == entries.size()) {
			grow()
		}
		entries[size++] = item
	}

	/**
	 * Pops an item from the stack
	 * @return item removed from stack
	 */
	def pop() {
		if (!isEmpty()) {
			return entries[--size]
		}
	}

	/**
	 * Checks if the stack is empty
	 * @return true if the stack is empty, false otherwise
	 */
	def isEmpty() {
		size == 0
	}

	/**
	 * Size of the stack
	 * @return size of the stack
	 */
	def size() {
		size
	}
	
	/**
	 * Removes all the elements from the stack
	 */
	void clear() {
		entries = new Object[DEFAULT_SIZE]
	}
	
	private def grow() {
		entries = Arrays.copyOf(entries, size * 2)
	}
	
}

