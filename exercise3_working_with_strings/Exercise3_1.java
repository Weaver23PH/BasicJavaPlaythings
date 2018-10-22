package exercise3_working_with_strings;

public class Exercise3_1 {
	public static void main(String[] args) {
		String newString = "Hello World!";
		String newString2 = new String("Hello World!");
		
		System.out.println(newString + newString2);
		System.out.println(addUpperCase(newString2));
		System.out.println(findLetter(newString, 'o'));
		
		Exercise3_2 checker = new Exercise3_2();
		
		System.out.println(checker.CheckPalindromes("satan oscillate my metallic sonatas"));
		System.out.println(checker.addToString("test string", 5));
		
	}
	
	public static String addUpperCase(String string) {
		return string + string.toUpperCase();
	}
	
	public static String findLetter(String string, char letter) {
		return string.substring(string.indexOf(letter));
	}
	
}
