package list

import spock.lang.Specification

class QueueTests extends Specification{

	collection.list.Queue queue = new collection.list.Queue()

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

	def 'find key'() {
		when:
		['a','b','c'].each { queue.enqueue(it) }

		then:
		queue.find('c')
	}

	def 'find non existing key'() {
		when:
		queue.enqueue('a')

		then:
		!queue.find('b')
	}

	def 'find null key'() {
		when:
		queue.enqueue('a')

		then:
		!queue.find(null)
	}

	def 'remove index'() {
		setup:
		[1, 2, 3, 4, 5].each { queue.enqueue(it) }

		expect:
		queue.remove(index) == item

		where:
		index | item 
		  0   |  1    
		  4   |  5
		  2   |  3
	}
	
	def 'remove invalid index'() {
		setup:
		[1, 2, 3, 4, 5].each { queue.enqueue(it) }

		when:
		queue.remove(-2)
		
		then:
		thrown IllegalArgumentException
	}
	
	def 'remove item'() {
		setup:
		['a', 'b', 'c', 'd', 'e'].each { queue.enqueue(it) }
		
		expect:
		queue.remove(removeItem) == item

		where:
		removeItem   | item
		 'a'  		 | 'a'
		 'e'  		 | 'e'
		 'c'  		 | 'c'
		 'f'  		 | null
		 null 		 | null
	}
	
	def 'resizing after removal'() {
		setup:
		[1, 2, 3, 4, 5].each { queue.enqueue(it) }
		
		when:
		queue.remove(3)
		
		then:
		queue.size() == 4
	}
	
	def 'remove from empty list'() {
		expect:
		queue.remove('string') == null
	}
}