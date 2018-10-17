package Workshop_1;

public class getAbsouluteValues {
	
	public static int[] returnAbs(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.abs(array[i]);
		}
		return array;
	}
	
	public static void main(String[] args) {
		int arr_1[] = { 1, -2, 3, -4, 5 };
		for (int i : arr_1) {
			System.out.println(returnAbs(arr_1)[i]);
		}
	}
}
