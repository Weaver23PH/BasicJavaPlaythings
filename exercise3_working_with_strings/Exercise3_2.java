package exercise3_working_with_strings;

public class Exercise3_2 {
	public boolean CheckPalindromes(String checked) {
		checked = checked.replaceAll(" ", "")
				.toLowerCase();
		String checkedRev = new StringBuilder(checked).reverse()
				.toString();
		if (!checked.equals(checkedRev)) {
			return false;
		}
		return true;
	}
	
	public String addToString(String string, int number) {
		StringBuilder returnedString = new StringBuilder(string);
		for (int i = 0; i < number; i++) {
			returnedString.append(i);
		}
		return returnedString.toString();
	}
	
}
