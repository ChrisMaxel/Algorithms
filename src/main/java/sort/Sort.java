package sort;

/**
 * @author Andrei Petraru
 * 23 Oct 2014
 */
public class Sort {
	public static void bubbleSort(int[] array) {
		int last = array.length - 1;
		while (last > 0) {
			int l = last;
			last = 0;
			for (int i = 0; i < l; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					last = i;
				}
			}
		}
	}

	public static void insertSort(int[] array) {
		for (int j = 1; j < array.length; j++) {
			int i = j - 1;
			int temp = array[j];
			while ((i >= 0) && (temp < array[i])) {
				array[i + 1] = array[i];
				i--;
			}
			if (i != j - 1) {
				array[i + 1] = temp;
			}
		}
	}

	public static void insertSort2(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j > 0 && array[j - 1] > array[j]) {
				swap(array, j, j - 1);
				j--;
			}
		}
	}

	public static void heapSort(int[] array) {
		int n = array.length;
		// build the heap in array so that largest value is at root
		heapify(array);
		// a[0:end] is a heap and every element beyond end is greater than
		// everything before it (a[end:count] is in sorted order)
		int end = n - 1;
		while (end > 0) {
			swap(array, end, 0);
			end--;
			siftDown(array, 0, end);
		}
	}
	
	public static void quickSort(int[] array) {
		qsort(array, 0, array.length - 1);
	}
	
	public static void qsort(int[] array, int low, int high) {
		int i = low;
		int j = high;
		int pivot = array[low + (high - low) / 2];
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(array, i, j);
				i++;
				j--;
			}
		}
		if (low < j) {
			qsort(array, low, j);
		}
		if (i < high) {
			qsort(array, i, high);
		}
	}

	private static void siftDown(int[] array, int start, int end) {
		int root = start;

		// while the root has at least on child
		while (root * 2 + 1 <= end) {
			int child = root * 2 + 1; // left child
			int swap = root; // keeps track of the child to swap with

			if (array[swap] < array[child]) {
				swap = child;
			}
			// if there is a right child and that child is greater
			if (child + 1 <= end && array[swap] < array[child + 1]) {
				swap = child + 1;
			}
			if (swap != root) {
				swap(array, root, swap);
				root = swap;
			}
			else {
				return;
			}
		}

	}

	// puts elements of array in heap order, in-place
	private static void heapify(int[] array) {
		// start is assigned the index in array of the last parent node
		// the last element in a 0-based array is at index count - 1
		// find the parent of that element
		int start = (array.length - 2) / 2;
		while (start >= 0) {
			// sift down the node at index start to the proper place such
			// that all nodes below the start index are in heap order
			siftDown(array, start, array.length - 1);
			// go to the next parent node
			start--;
		}
		// after sifting down the root all nodes are in heap order
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
