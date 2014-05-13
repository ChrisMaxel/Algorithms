package list

import spock.lang.Specification;
import collection.list.Stack;

class StackTests extends Specification {

	Stack stack = new Stack()

	def 'push'() {
		expect:
		stack.push('string') == 'string'
	}
	
	def 'push null'() {
		when:
		stack.push(null)
		
		then:
		thrown IllegalArgumentException
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
	
	def 'peek'() {
		when:
		stack.push('string')
		
		then:
		stack.peek() == 'string'
		stack.size() == 1
	}
	
	def 'null peek'() {
		expect:
		stack.peek() == null
	}
}