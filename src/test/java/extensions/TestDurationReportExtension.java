package extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

import java.lang.reflect.Method;

public class TestDurationReportExtension implements InvocationInterceptor {
    @Override
    public void interceptTestMethod(Invocation<Void> invocation,
                                    ReflectiveInvocationContext<Method> invocationContext,
                                    ExtensionContext extensionContext) throws Throwable {

        long beforeTest = System.currentTimeMillis();
        try {
            invocation.proceed();
        } finally {
            long afterTest = System.currentTimeMillis();
            long duration = afterTest - beforeTest;

            String testClassName = invocationContext.getTargetClass().getSimpleName();
            String testMethodName = invocationContext.getExecutable().getName();
            System.out.printf("%s.%s: %dms%n", testClassName, testMethodName, duration);
        }
    }
}