package demo;

import groovy.lang.Closure;
import groovy.lang.GroovyObjectSupport;
import groovy.lang.MissingMethodException;
import java.util.HashMap;
import java.util.Map;

public class JavaExpandoLite extends GroovyObjectSupport {
 
    private Map<String, Object> dynamicProperties = new HashMap<String, Object>();
    
    public Object getProperty(String propertyName) {
        return dynamicProperties.get(propertyName);
    }
    
    public void setProperty(String propertyName, Object propertyValue) {
        dynamicProperties.put(propertyName, propertyValue);
    }
    
    public Object methodMissing(String methodName, Object args) {
        Object property = dynamicProperties.get(methodName);
        if(property instanceof Closure) {
            return ((Closure)property).call((Object[])args);
        }
        throw new MissingMethodException(methodName, JavaExpandoLite.class, (Object[])args);
    }
}