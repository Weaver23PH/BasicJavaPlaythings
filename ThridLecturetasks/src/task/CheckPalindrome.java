package task;

public class CheckPalindrome {
	
	public boolean CheckPalindromes(String checked) {
		checked = checked.replaceAll(" ", "")
				.toLowerCase();
		String checkedRev = new StringBuilder(checked).reverse()
				.toString();
		if (!checked.equals(checkedRev)) {
			throw new RuntimeException("this is not a palindrome");
		}
		return true;
	}
}
