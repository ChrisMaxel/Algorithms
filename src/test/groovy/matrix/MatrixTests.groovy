package matrix

import spock.lang.Specification

import static matrix.Matrix.*

/**
 * Created by Petraru on 10-Apr-14.
 */
class MatrixTests extends Specification {
	def 'print transposition'() {
		def matrix = [[1, 1, 1, 1], [2, 2, 2, 2], [3, 3, 3, 3]] as double[][]
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

	def 'multiply invalid matrix'() {
		when:
		def m1 = [[1, 2, 3], [4, 5, 6]] as double[][]
		def m2 = [[7, 8], [9, 10]] as double[][]
		Matrix.multiply(m1, m2)

		then:
		def e = thrown(IllegalArgumentException)
		e.message == 'Rows of the first matrix and columns of the second matrix are not equal'
	}

	def 'multiply matrix'() {
		when:
		def m1 = [[1, 2, 3], [4, 5, 6]] as double[][]
		def m2 = [[7, 8], [9, 10], [11, 12]] as double[][]
		def m3 = [[58, 64], [139, 154]] as double[][]

		then:
		m3 == multiply(m1, m2)
	}
}
