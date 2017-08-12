import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
public class TestRunner {

  public static void main(String[] args) throws Exception {

	System.out.println("Testing...");

	int passed = 0, failed = 0, count = 0, ignore = 0;

	Class<ExampleTest> obj = ExampleTest.class;

	// Process @SuperTest
	if (obj.isAnnotationPresent(SuperTest.class)) {

		Annotation annotation = obj.getAnnotation(SuperTest.class);
		SuperTest superTest = (SuperTest) annotation;

		System.out.printf("%nPriority :%s", superTest.priority());
		System.out.printf("%nCreatedBy :%s", superTest.createdBy());

		System.out.printf("%nLastModified :%s%n%n", superTest.lastModified());

	}

	// Process @Test
	for (Method method : obj.getDeclaredMethods()) {

		// if method is annotated with @Test
		if (method.isAnnotationPresent(Test.class)) {

			Annotation annotation = method.getAnnotation(Test.class);
			Test test = (Test) annotation;

			// if enabled = true
			if (test.enabled()) {

			  try {
				method.invoke(obj.newInstance());
				System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
				passed++;
			  } catch (Throwable ex) {
				System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
				failed++;
			  }

			} else {
				System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
				ignore++;
			}

		}

	}
	System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);

	}
}