package task;

public class GetMinMax {
	public double getMaxVal(int tab[]) {
		double max = 0;
		for (int elem : tab) {
			if (elem > max) {
				max = elem;
			}
		}
		return max;
	}
	
	public double getMinVal(int tab[]) {
		double min = Double.POSITIVE_INFINITY; // whoa there!!!
		for (int elem : tab) {
			if (elem < min) {
				min = elem;
			}
		}
		return min;
	}
	
}
