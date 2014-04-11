package array

import spock.lang.Specification

import static array.Array.*

/**
 * @author Andrei Petraru 
 * 10 Apr 2014
 */
class ArrayTests extends Specification {
	def 'test histogram with [0..m-1] values in array'() {
		def array = [1, 2, 3, 3, 3, 3, 4] as int[]
		def result = histogram(array, 6)
		def arraySum = 0
		result.each {
			print it
			arraySum += it
		}
		println()

		expect:
		arraySum == array.length
	}

	def 'test histogram with larger values in array'() {
		def array = [1, 12, 3, 2, 7, 3, 4] as int[]
		def result = histogram(array, 0)
		def arraySum = 0
		result.each {
			print it
			arraySum += it
		}
		println()

		expect:
		arraySum != array.length
	}

	def 'test histogram with negative M'() {
		when:
		histogram([1, 2, 3] as int[], -1)

		then:
		def e = thrown(IllegalArgumentException)
		e.message == 'Cannot have an array with negative length'
	}
}
