package fundamentals

class BinarySearch {
	static int binarySearch(key, array) {
		if (key < 0 || !array) {
			return -1
		}
		
		def low = 0
		def high = array.size()
		
		if (high <= low) {
			return -1
		}
		
		while (low <= high) {
			def mid = (low + high).intdiv(2)
			
			if (key > array[mid]) {
				low = mid + 1
			}
			else if (key < array[mid]) {
				high = mid - 1
			}
			else {
				return mid
			}
		}
		return -1		
	}
}