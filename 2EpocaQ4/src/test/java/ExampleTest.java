@SuperTest(
	priority = SuperTest.Priority.MEDIUM,
	createdBy = "Uriel",
	lastModified = "12/08/2017"
)
public class ExampleTest {

	@Test(enabled = true)
	void testA() {
	  if (true)
		throw new RuntimeException("This test always failed");
	}

	@SuppressWarnings("unused")
	@Test(enabled = false)
	void testB() {
	  if (false)
		throw new RuntimeException("This test always passed");
	}

	@Test(enabled = true)
	void testC() {
	  if (10 > 1) {
		// do nothing, this test always passed.
	  }
	}
	
	@Test(enabled = true)
	void testD(){
		if(true){
			//Do nothing, always pass.
		}
	}
	
	@Test(enabled = true)
	void testE(){
		throw new RuntimeException("Always fails");
	}
}