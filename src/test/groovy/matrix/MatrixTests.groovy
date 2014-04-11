package matrix

import spock.lang.Specification

/**
 * Created by Petraru on 10-Apr-14.
 */
class MatrixTests extends Specification {
	def 'print transposition'() {
		def matrix = [[1, 1, 1, 1], [2, 2, 2, 2], [3, 3, 3, 3]] as int[][]
		Matrix.printTransposition(matrix)
		Matrix.print(matrix)

		expect:
		true
	}
}
