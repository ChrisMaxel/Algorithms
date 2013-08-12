package list.ex

import spock.lang.Specification;

class ParenthesesTests extends Specification{
	def 'balanced'() {
		expect:
		Parentheses.isBalanced('{}[]()[{()}]')
	}
	
	def 'not balanced'() {
		expect:
		!Parentheses.isBalanced('{{{)))')
	}
	
	def 'null input'() {
		expect:
		!Parentheses.isBalanced(null)
	}
	
	def 'other characters'() {
		when:
		Parentheses.isBalanced('{a}')
		
		then:
		thrown IllegalArgumentException
	}
}
