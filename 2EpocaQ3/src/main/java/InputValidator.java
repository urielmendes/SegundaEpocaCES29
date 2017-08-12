import java.util.regex.Pattern;

public class InputValidator {
	
	private InputValidator(){
	}
	
	private static final Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{10,}$");
	
	public static boolean validate(String entry){
		if(!pattern.matcher(entry).matches())
			return false;
		else
			return true;
	}
}
