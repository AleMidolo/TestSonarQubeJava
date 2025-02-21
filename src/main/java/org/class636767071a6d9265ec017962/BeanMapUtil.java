package org.class636767071a6d9265ec017962;

import org.apache.commons.beanutils.BeanMap;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanMapUtil {

    /** 
     * Inserisce tutte le proprietà scrivibili dal BeanMap fornito in questo BeanMap. Le proprietà di sola lettura e di sola scrittura verranno ignorate.
     * @param map  il BeanMap le cui proprietà devono essere inserite
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("BeanMap cannot be null");
        }

        for (Object property : map.keySet()) {
            try {
                PropertyDescriptor descriptor = new PropertyDescriptor((String) property, map.getBean().getClass());
                Method writeMethod = descriptor.getWriteMethod();
                if (writeMethod != null) {
                    Object value = map.get(property);
                    writeMethod.invoke(map.getBean(), value);
                }
            } catch (Exception e) {
                // Handle exceptions such as IntrospectionException, IllegalAccessException, InvocationTargetException
                e.printStackTrace();
            }
        }
    }
}