package task;

import java.util.List;

public class PluralSorter {
	public static void pluralCheck(List<Integer> list) throws PluralException{
		
		Sorter s = new Sorter(new C) {
			public List<Integer> sorter(List<Integer> numbers){
				numbers.stream().sorted();
			}
		}
		
	}
}
