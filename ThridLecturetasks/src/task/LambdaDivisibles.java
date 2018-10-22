package task;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaDivisibles {
	public List<Integer> findDivisibleByThree(List<Integer> numbers) {
		List<Integer> result = numbers.stream()
				.filter(this::isDivisibleByThree)
				.collect(Collectors.toList());
		return result;
	}
	
	public List<Integer> findDivisibleByThree2(List<Integer> numbers) {
		List<Integer> result = numbers.stream()
				.filter(n -> n % 3 == 0)
				.collect(Collectors.toList());
		return result;
	}
	
	public boolean isDivisibleByThree(int number) {
		return number % 3 == 0;
	}
	
	public void sortListStream(List<Integer> numbers) {
		numbers.stream()
				.forEach(System.out::print);
		System.out.println(" bez sortowania");
		numbers.stream()
				.sorted()
				.forEach(System.out::print);
		System.out.println(" posortowana");
	}
	
	public void sortList(List<Integer> numbers) {
		numbers.forEach(n -> System.out.println(n));
		numbers.sort((n1, n2) -> n1.compareTo(n2));
		numbers.forEach(n -> System.out.println(n));
	}
}
