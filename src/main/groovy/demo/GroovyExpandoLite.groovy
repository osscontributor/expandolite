package demo

class GroovyExpandoLite {
    
    private dynamicProperties = [:]
    
    def getProperty(String propertyName) {
        dynamicProperties[propertyName]
    }
    
    void setProperty(String propertyName, propertyValue) {
        dynamicProperties[propertyName] = propertyValue
    }
    
    def methodMissing(String methodName, args) {
        def property = dynamicProperties[methodName]
        if(property instanceof Closure) {
            return property(*args)
        }
        throw new MissingMethodException(methodName, GroovyExpandoLite, args)
    }
}