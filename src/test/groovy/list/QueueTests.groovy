package list

import spock.lang.Specification

class QueueTests extends Specification{

	Queue queue = new Queue()

	def 'enqueue'() {
		expect:
		queue.enqueue('string') == 'string'
	}

	def 'enqueu null'() {
		when:
		queue.enqueue(null)

		then:
		thrown IllegalArgumentException
	}

	def 'dequeue'() {
		when:
		queue.enqueue('string')

		then:
		queue.dequeue() == 'string'
		queue.dequeue() == null
	}

	def 'size'() {
		when:
		queue.enqueue('string')

		then:
		queue.size() == 1
	}

	def 'clear'() {
		when:
		queue.clear()

		then:
		queue.isEmpty()
	}
}