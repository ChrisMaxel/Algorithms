package fundamentals

import spock.lang.Specification
import fundamentals.BinarySearch

class BinarySearchTest extends Specification {
	def 'invalid arguments binary search'() {
		expect:
		BinarySearch.binarySearch(key, array) == position
		
		where:
		key | array   | position
		 2	| null	  | -1
		-2	| null	  | -1
		-2	| [1,2,3] | -1		
	}

	def 'binary search'() {
		expect:
		BinarySearch.binarySearch(key, array) == position
		
		where:
		key | array   			 | position
		 1	| [1] as int[] 		 |  0
		 2	| [1, 2, 3] as int[] |  1
		 3	| [1, 2, 3] as int[] |  2
		 2	| [] as int[] 		 | -1
	}

	def 'large array binary search'() {
		def array = (0..10000000) as int[]

		expect:
		BinarySearch.binarySearch(0, array) == 0
		BinarySearch.binarySearch(10000000.intdiv(2), array) == 10000000.intdiv(2)
		BinarySearch.binarySearch(10000000.intdiv(2) - 12345, array) == 10000000.intdiv(2) - 12345
		BinarySearch.binarySearch(10000000, array) == 10000000
	}
	
	def 'very large array binary search'() {
		when:
		def array = (0..10000000) as int[]

		then:
		BinarySearch.binarySearch(0, array) == 0
		BinarySearch.binarySearch(10000000.intdiv(2), array) == 10000000.intdiv(2)
		BinarySearch.binarySearch(10000000.intdiv(2) - 12345, array) == 10000000.intdiv(2) - 12345
		BinarySearch.binarySearch(10000000, array) == 10000000
	}
}