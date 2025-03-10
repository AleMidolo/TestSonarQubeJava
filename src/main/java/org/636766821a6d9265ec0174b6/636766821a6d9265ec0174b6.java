import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeResolver {

    public static Class<?>[] resolveArguments(Type genericType, Class<?> targetType) {
        if (!(genericType instanceof ParameterizedType)) {
            return null;
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Class<?>[] resolvedArguments = new Class<?>[actualTypeArguments.length];

        Map<String, Class<?>> typeVariableMap = createTypeVariableMap(targetType);

        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type typeArgument = actualTypeArguments[i];
            if (typeArgument instanceof Class<?>) {
                resolvedArguments[i] = (Class<?>) typeArgument;
            } else if (typeArgument instanceof TypeVariable<?>) {
                TypeVariable<?> typeVariable = (TypeVariable<?>) typeArgument;
                resolvedArguments[i] = typeVariableMap.get(typeVariable.getName());
            } else {
                return null;
            }
        }

        return resolvedArguments;
    }

    private static Map<String, Class<?>> createTypeVariableMap(Class<?> targetType) {
        Map<String, Class<?>> typeVariableMap = new HashMap<>();
        TypeVariable<?>[] typeParameters = targetType.getTypeParameters();

        for (TypeVariable<?> typeParameter : typeParameters) {
            Type[] bounds = typeParameter.getBounds();
            if (bounds.length > 0 && bounds[0] instanceof Class<?>) {
                typeVariableMap.put(typeParameter.getName(), (Class<?>) bounds[0]);
            }
        }

        return typeVariableMap;
    }
}