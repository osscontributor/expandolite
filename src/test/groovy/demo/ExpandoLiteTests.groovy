package demo

class ExpandoLiteTests extends spock.lang.Specification {
    
    def "assign a value to a non-existent property and retrieve it's value with a GroovyExpandoLite "() {
        when: 
            def expandoLite = new GroovyExpandoLite()
            expandoLite.favoriteFramework = 'Grails'
        then:
            'Grails' == expandoLite.favoriteFramework
    }

    def "assign a closure to a non-existent property and invoke as method on a GroovyExpandoLite"() {
        when:
            def expandoLite = new GroovyExpandoLite()
            expandoLite.addNumbers = { a, b, c ->
                a + b + c
            }
        then:
            100 == expandoLite.addNumbers(30, 20, 50)
    }
    
    def "verify that an exception is thrown when invoking a non-existent method on a GroovyExpandoLite"() {
        when:
            def expandoLite = new GroovyExpandoLite()
            expandoLite.doSomething()
        then:
            thrown MissingMethodException
    }
    
    def "assign a value to a non-existent property and retrieve it's value with a JavaExpandoLite "() {
        when: 
            def expandoLite = new JavaExpandoLite()
            expandoLite.favoriteFramework = 'Grails'
        then:
            'Grails' == expandoLite.favoriteFramework
    }

    def "assign a closure to a non-existent property and invoke as method on a JavaExpandoLite"() {
        when:
            def expandoLite = new JavaExpandoLite()
            expandoLite.addNumbers = { a, b, c ->
                a + b + c
            }
        then:
            100 == expandoLite.addNumbers(30, 20, 50)
    }
    
    def "verify that an exception is thrown when invoking a non-existent method on a JavaExpandoLite"() {
        when:
            def expandoLite = new JavaExpandoLite()
            expandoLite.doSomething()
        then:
            thrown MissingMethodException
    }
}