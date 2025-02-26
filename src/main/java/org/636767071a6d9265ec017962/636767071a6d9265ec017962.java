import org.apache.commons.beanutils.BeanMap;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanMapUtil {

    /**
     * दिए गए BeanMap से सभी लिखने योग्य गुणों को इस BeanMap में डालता है। केवल पढ़ने योग्य और केवल लिखने योग्य गुणों को नजरअंदाज किया जाएगा।
     * @param map  वह BeanMap जिसके गुणों को डालना है
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("BeanMap cannot be null");
        }

        Object bean = map.getBean();
        PropertyDescriptor[] propertyDescriptors = java.beans.Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();

        for (PropertyDescriptor descriptor : propertyDescriptors) {
            Method writeMethod = descriptor.getWriteMethod();
            if (writeMethod != null) {
                try {
                    Object value = map.get(descriptor.getName());
                    if (value != null) {
                        writeMethod.invoke(bean, value);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}