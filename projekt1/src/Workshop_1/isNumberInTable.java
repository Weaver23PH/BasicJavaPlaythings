package Workshop_1;

public class isNumberInTable {
 
	public static boolean isIntInTable(int array[], int element) {
		for (int i=0;i<array.length;i++) {
			if (array[i] == element) {
				return true;
			}		
		}
		return false;
	}
	public static void main(String[] args) {
		int array_1[] = {1,2,3,4,5};
		int elem_1 = 5;
		System.out.println(isIntInTable(array_1, elem_1));
		
	}
	
}
