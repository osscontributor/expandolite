package demo

class GroovyExpandoLiteTests extends spock.lang.Specification {

    def expandoLite

    def setup() {
        expandoLite = new GroovyExpandoLite()
    }

    def "assign a value to a non-existent property and retrieve it's value"() {
        when: 
        expandoLite.favoriteFramework = 'Grails'
        
        then:
        'Grails' == expandoLite.favoriteFramework
    }

    def "assign a closure to a non-existent property and invoke as method"() {
        when:
        expandoLite.addNumbers = { a, b, c ->
            a + b + c
        }
        
        then:
        100 == expandoLite.addNumbers(30, 20, 50)
    }

    def "verify that an exception is thrown when invoking a non-existent method"() {
        when:
        expandoLite.doSomething()
        
        then:
        thrown MissingMethodException
    }
}