package extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

public class RandomIntAnnotationProcessor implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        Field[] declaredFields = testInstance.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(RandomInt.class)) {
                declaredField.setAccessible(true);
                declaredField.set(testInstance, new Random().nextInt());
                break;
            }
        }
    }
}
