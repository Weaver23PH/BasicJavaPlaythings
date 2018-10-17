package Workshop_1;

public class Task_1 {
	
	public static void main(String[] args) {
		
		double number_1 = 99999.99999;
		float number_2 = (float) number_1;
		int number_3 = (int) number_2;
		long number_4 = (long) number_3;
		short number_5 = (short) number_4;
		byte number_6 = (byte) number_5;
		
		System.out.println("num1: " + number_1);
		System.out.println("num2: " + number_2);
		System.out.println("num3: " + number_3);
		System.out.println("num4: " + number_4);
		System.out.println("num5: " + number_5);
		System.out.println("num6: " + number_6);
	}
	
}