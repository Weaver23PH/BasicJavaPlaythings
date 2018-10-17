package task;

public class Main {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		Computation testinAddition = new Addition();// this is fuckin' complicated for a simple algebra!
		Computation testMultiplication = new Multiplication();
		System.out.println(((Addition) testinAddition).compute(a, b));
		System.out.println(((Multiplication) testMultiplication).compute(a, b));
		
		CheckPalindrome kajak = new CheckPalindrome();
		// System.out.println(kajak.CheckPalindromes("rasdddaR"));
		System.out.println(kajak.CheckPalindromes("satan oscillate my metallic sonatas"));
		
		GetMinMax minmaxChecker = new GetMinMax();
		int checkTable[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(minmaxChecker.getMaxVal(checkTable));
		System.out.println(minmaxChecker.getMinVal(checkTable));
		
		GetDayOfWeek dayChecker = new GetDayOfWeek();
		System.out.println(dayChecker.getWeekDay(b));
		
		typeString(null);
	}
	
	static public void typeString(String string) {
		try {
			System.out.println(string.length());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
	}
}