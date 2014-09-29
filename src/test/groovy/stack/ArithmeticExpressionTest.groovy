package stack

import spock.lang.Specification

import static math.ArithmeticExpression.compute
import static math.ArithmeticExpression.isBalanced

class ArithmeticExpressionTest extends Specification {
	def 'balanced'() {
		expect:
		isBalanced('{}[   ]()[{(())}]')
	}

	def 'not balanced'() {
		expect:
		!isBalanced('((([{{{]}}})))')
	}

	def 'expression with numbers'() {
		when:
		isBalanced('( 1 + ( (2 + 3 ) * ( 4 * 5 ) ) )')

		then:
		def e = thrown(IllegalArgumentException)
		e.message == 'Non brace character found'
	}

	def 'null input'() {
		expect:
		!isBalanced(null)
	}

	def 'compute valid expression'() {
		when:
		def result = compute("(1+((2+3)*(  4 * 5 )))")

		then:
		result == 101.0
	}

}
