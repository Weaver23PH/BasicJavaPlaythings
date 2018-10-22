package task;

import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {
	public int countPositivesInArray(List<Integer> numbersTest) {
		List<Integer> result = numbersTest.stream()
				.filter(number -> number >= 0)
				.collect(Collectors.toList());
		return result.size();
	}
	
	public void normaliseNumbers(List<Double> numbersTest) {
		numbersTest.stream()
				.map(n -> Math.abs(n))
				.map(n -> {
					if (n - Math.floor(n) < 0.5) {
						return Math.toIntExact((long) Math.floor(n));
					} else {
						return Math.toIntExact((long) Math.ceil(n));
					}
				})
				.forEach(System.out::println);
		System.out.println("z ifem");
	}
	
	public void normaliseNumbers2(List<Double> numbersTest) {
		numbersTest.stream()
				.map(n -> Math.toIntExact(Math.abs(Math.round(n))))
				.forEach(System.out::println);
		System.out.println("bez  ifa");
	}
}