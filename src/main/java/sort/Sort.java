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
				if (array[i] > array[i+1]) {
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

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
