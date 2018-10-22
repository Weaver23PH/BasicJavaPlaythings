package task;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		Computation testinAddition = new Addition();// this is fuckin' complicated for a simple algebra!
		Computation testMultiplication = new Multiplication();
		System.out.println(((Addition) testinAddition).compute(a, b));
		System.out.println(((Multiplication) testMultiplication).compute(a, b));
		
		CheckPalindrome kajak = new CheckPalindrome();
		try {
			System.out.println("palindrome? " + kajak.CheckPalindromes("satan oscillate my metallic sonatas"));
		} catch (PalindromeException ex) {
			ex.printStackTrace();
		}
		
		GetMinMax minmaxChecker = new GetMinMax();
		double checkTable[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Double> checkList = new ArrayList<Double>();
		checkList.add(1.0);
		checkList.add(2.0);
		checkList.add(3.0);
		checkList.add(4.0);
		checkList.add(5.0);
		System.out.println("bez stream " + minmaxChecker.getMaxVal(checkTable));
		System.out.println("stream " + minmaxChecker.getMaxValStream(checkList));
		System.out.println("bez stream " + minmaxChecker.getMinVal(checkTable));
		System.out.println("stream " + minmaxChecker.getMinValStream(checkList));
		
		GetDayOfWeek dayChecker = new GetDayOfWeek();
		System.out.println(dayChecker.getWeekDay(b));
		
		typeString(null);
		typeStringWithStream(null);
		
		List<Integer> checkList2 = new ArrayList<Integer>();
		checkList2.add(1);
		checkList2.add(2);
		checkList2.add(3);
		checkList2.add(5);
		checkList2.add(4);
		checkList2.add(7);
		checkList2.add(6);
		checkList2.add(-8);
		checkList2.add(-9);
		checkList2.add(10);
		checkList2.add(12);
		checkList2.add(11);
		LambdaDivisibles lamChecker = new LambdaDivisibles();
		System.out.println("divisible by 3 " + lamChecker.findDivisibleByThree(checkList2));
		System.out.println("divisible by 3 v2 " + lamChecker.findDivisibleByThree2(checkList2));
		System.out.println("sorter 3 stream ");
		lamChecker.sortListStream(checkList2);
		System.out.println("sorter 3 nostream");
		lamChecker.sortList(checkList2);
		
		List<Integer> numbersTest = new ArrayList<Integer>();
		numbersTest.add(-5);
		numbersTest.add(-4);
		numbersTest.add(-3);
		numbersTest.add(-2);
		numbersTest.add(-1);
		numbersTest.addAll(checkList2);
		StreamOperations strChecker = new StreamOperations();
		System.out.println("n of positives in this list = " + strChecker.countPositivesInArray(numbersTest));
		List<Double> checkList3 = new ArrayList<Double>();
		checkList3.addAll(checkList);
		checkList3.add(-5.5);
		checkList3.add(-4.9);
		checkList3.add(-3.8);
		checkList3.add(-2.7);
		checkList3.add(-1.6);
		strChecker.normaliseNumbers(checkList3);
		strChecker.normaliseNumbers2(checkList3);
		
	}
	
	static public void typeString(String string) {
		try {
			System.out.println(string.length());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
	}
	
	static public void typeStringWithStream(String string) {
		try {
			System.out.println(string.chars()
					.count());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
	}
}