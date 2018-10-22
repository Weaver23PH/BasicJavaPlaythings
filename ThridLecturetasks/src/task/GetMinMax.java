package task;

import java.util.List;

public class GetMinMax {
	public double getMaxVal(double tab[]) {
		double max = 0;
		for (double elem : tab) {
			if (elem > max) {
				max = elem;
			}
		}
		return max;
	}
	
	public double getMinVal(double tab[]) {
		double min = Double.POSITIVE_INFINITY; // whoa there!!!
		for (double elem : tab) {
			if (elem < min) {
				min = elem;
			}
		}
		return min;
	}
	
	public double getMaxValStream(List<Double> checkList) {
		return checkList.stream()
				.max(Double::compare)
				.get();
	}
	
	public double getMinValStream(List<Double> checkList) {
		return checkList.stream()
				.min(Double::compare)
				.get();
	}
}
