package Workshop_1;

public class Task_4 {
	
	public static void main(String[] args) {
		int array_1[] = new int[4];
		int array_2[] = new int[4];
		for (int i = 0; i < 4; i++) {
			array_1[i] = (int) (Math.random() * 10);
			
			System.out.println(array_1[i]);
		}
		for (int i = array_1.length - 1; i >= 0; i--) {
			System.out.println(array_1[i]);
			array_2[array_1.length - (i + 1)] = array_1[i];
			
		}
		for (int i = 0; i < array_1.length; i++) {
			System.out.println("array1: " + array_1[i] + " array2: " + array_2[i]);
		}
	}
	
}
