package list

import collection.linkedlist.Steque
import spock.lang.Specification

/**
 * @author Andrei Petraru 
 * 30 Sep 2014
 */
class StequeTest extends Specification {

	Steque steque = new Steque()

	def 'push'() {
		expect:
		steque.push('string') == 'string'
		steque.size() == 1
	}

	def 'push null'() {
		when:
		steque.push(null)

		then:
		thrown IllegalArgumentException
	}

	def 'pop'() {
		when:
		steque.push('string')

		then:
		steque.pop() == 'string'
	}

	def 'clear'() {
		when:
		steque.push('string')
		steque.clear()

		then:
		steque.isEmpty()
	}

	def 'enqueue'() {
		when:
		steque.enqueue('string') == 'string'

		then:
		steque.size() == 1
	}

	def 'enqueue null'() {
		when:
		steque.enqueue(null)

		then:
		thrown IllegalArgumentException
	}

	def 'push enqueue pop'() {
		when:
		steque.enqueue('1')
		steque.push('2')

		then:
		steque.size() == 2
		steque.pop() == '2'
		steque.pop() == '1'
	}
}
