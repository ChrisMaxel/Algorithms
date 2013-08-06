import spock.lang.Specification;

class FirstTest extends Specification {
	
	def test() {
		when:
		def a = 3
		then:
		a == 3
	}
}