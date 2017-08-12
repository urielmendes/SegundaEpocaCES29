import static org.junit.Assert.*;
import org.junit.Test;

public class InputValidatorTest {

	String entry;
	
	@Test
	public void inputLengthTest() {
		entry = "abcd";
	
		assertFalse(InputValidator.validate(entry));
		
		entry = "qwertyuio";
		
		assertFalse(InputValidator.validate(entry));
		
		entry = "asdfgtjklo";

		assertTrue(InputValidator.validate(entry));
	
	}
	
	@Test
	public void specialCharacterTest() {
		entry = "nhyujmbgtç";
		
		assertFalse(InputValidator.validate(entry));
		
		entry = "<>,.{}[]=+-_";
		
		assertFalse(InputValidator.validate(entry));
		
		entry = "hgfdertyuóa";
		
		assertFalse(InputValidator.validate(entry));
		
		entry = "vfred678265";
		
		assertTrue(InputValidator.validate(entry));	
		
		entry = "hytgb mmiymi";
		
		assertFalse(InputValidator.validate(entry));
	}
	
	

}
