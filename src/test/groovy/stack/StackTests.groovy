package stack

import spock.lang.Specification

class StackTests extends Specification{

	collection.array.Stack stack = new collection.array.Stack()

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
		stack.push('test')
		stack.clear()

		then:
		stack.isEmpty()
		stack.size() == 0
	}
}