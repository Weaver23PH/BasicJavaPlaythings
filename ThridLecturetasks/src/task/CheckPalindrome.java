package task;

public class CheckPalindrome {
	
	public boolean CheckPalindromes(String checked) throws PalindromeException {
		checked = checked.replaceAll(" ", "")
				.toLowerCase();
		String checkedRev = new StringBuilder(checked).reverse()
				.toString();
		if (!checked.equals(checkedRev)) {
			throw new PalindromeException();
		}
		return true;
	}
}