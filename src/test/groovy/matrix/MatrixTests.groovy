package matrix

import spock.lang.Specification

import static matrix.Matrix.*

/**
 * @author Andrei Petraru
 * 10 Apr 2014
 */
class MatrixTests extends Specification {
	def 'print transposition'() {
		def matrix = [[1.0, 1.1, 1.2, 1.3], [2.0, 2.1, 2.2, 2.3], [3.0, 3.1, 3.2, 3.3]] as double[][]
		printMatrix(matrix)
		printTransposition(matrix)

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
		multiply(m1, m2)

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

	def 'transpose'() {
		when:
		def m = [[1, 2, 3], [4, 5, 6]] as double[][]
		def t = transpose m

		then:
		true
		t == [[1, 4], [2, 5], [3, 6]]
	}

	def 'matrix vector product'() {
		def m = [[1, -1, 2], [0, -3, 1]] as double[][]
		def v = [2, 1, 0] as double[]

		expect:
		def res = matrixVectorProduct(m, v)
		print res
	}

	def 'invalid matrix vector product'() {
		when:
		def m = [[1, 2, 3], [4, 5, 6]] as double[][]
		def v = [9, 10] as double[]
		matrixVectorProduct(m, v)

		then:
		def e = thrown(IllegalArgumentException)
		e.message == 'Cannot perform multiplication'
	}
}
