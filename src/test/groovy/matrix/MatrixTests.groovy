package matrix

import spock.lang.Specification

import static matrix.Matrix.*

/**
 * Created by Petraru on 10-Apr-14.
 */
class MatrixTests extends Specification {
	def 'print transposition'() {
		def matrix = [[1, 1, 1, 1], [2, 2, 2, 2], [3, 3, 3, 3]] as int[][]
		printTransposition(matrix)
		printMatrix(matrix)

		expect:
		true
	}

	def 'create relatively prime matrix'() {
		def matrix = relativePrime(10)

		matrix.each {
			print '['
			it.each {
				print it
				print ' '
			}
			print ']'
			println()
		}

		expect:
		true
	}
}
