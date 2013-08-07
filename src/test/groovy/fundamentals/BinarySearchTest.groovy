package fundamentals

import spock.lang.Specification
import fundamentals.BinarySearch

class BinarySearchTest extends Specification {
	def 'invalid arguments binary search'() {
		BinarySearch.binarySearch(2, null) == -1
		BinarySearch.binarySearch(-2, null) == -1
		BinarySearch.binarySearch(-2, [1, 2, 3]) == -1
	}

	def 'binary search'() {
		expect:
		BinarySearch.binarySearch(1, [1] as int[]) == 0
		BinarySearch.binarySearch(2, [1, 2, 3] as int[]) == 1
		BinarySearch.binarySearch(3, [1, 2, 3] as int[]) == 2
		BinarySearch.binarySearch(2, [] as int[]) == -1
	}

	def 'large array binary search'() {
		when:
		int[] array = (0..10000000) as int[]

		then:
		BinarySearch.binarySearch(0, array) == 0
		BinarySearch.binarySearch(10000000.intdiv(2), array) == 10000000.intdiv(2)
		BinarySearch.binarySearch(10000000.intdiv(2) - 12345, array) == 10000000.intdiv(2) - 12345
		BinarySearch.binarySearch(10000000, array) == 10000000
	}
	
	def 'very large array binary search'() {
		when:
		int[] array = (0..10000000) as int[]

		then:
		BinarySearch.binarySearch(0, array) == 0
		BinarySearch.binarySearch(10000000.intdiv(2), array) == 10000000.intdiv(2)
		BinarySearch.binarySearch(10000000.intdiv(2) - 12345, array) == 10000000.intdiv(2) - 12345
		BinarySearch.binarySearch(10000000, array) == 10000000
	}
}