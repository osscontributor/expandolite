package demo

class ExpandoLiteTests extends GroovyTestCase {
    
    void testGroovyExpandoLitePropertyAccess() {
        def expandoLite = new GroovyExpandoLite()
        expandoLite.favoriteFramework = 'Grails'
        assertEquals 'Grails', expandoLite.favoriteFramework
    }
    
    void testGroovyExpandoLiteMethodAccess() {
        def expandoLite = new GroovyExpandoLite()
        expandoLite.addNumbers = { a, b, c ->
            a + b + c
        }
        assertEquals 100, expandoLite.addNumbers(30, 20, 50)
    }
    
    void testGroovyExpandoLiteInvokingInvalidMethod() {
        def expandoLite = new GroovyExpandoLite()
        shouldFail(MissingMethodException) {
            expandoLite.someMissingMethod()
        }
    }
    
    void testJavaExpandoLitePropertyAccess() {
        def expandoLite = new JavaExpandoLite()
        expandoLite.favoriteFramework = 'Grails'
        assertEquals 'Grails', expandoLite.favoriteFramework
    }
    
    void testJavaExpandoLiteMethodAccess() {
        def expandoLite = new JavaExpandoLite()
        expandoLite.addNumbers = { a, b, c ->
            a + b + c
        }
        assertEquals 100, expandoLite.addNumbers(30, 20, 50)
    }
    
    void testJavaExpandoLiteInvokingInvalidMethod() {
        def expandoLite = new JavaExpandoLite()
        shouldFail(MissingMethodException) {
            expandoLite.someMissingMethod()
        }
    }
}