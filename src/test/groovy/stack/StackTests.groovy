package stack

import spock.lang.Specification

class StackTests extends Specification{

	collection.stack.Stack stack = new collection.stack.Stack()

	def 'push'() {
		expect:
		stack.push('string') == 'string'
	}

	def 'pop'() {
		when:
		stack.push('string')

		then:
		stack.pop() == 'string'
		stack.pop() == null
	}

	def 'size'() {
		when:
		stack.push('string')

		then:
		stack.size() == 1
	}

	def 'clear'() {
		when:
		stack.clear()

		then:
		stack.isEmpty()
	}
}