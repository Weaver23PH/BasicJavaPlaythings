package washingMachine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WashingMachineTester {
	
	public static void main(String[] args) {
		List<WashingMachine> allAGD = new ArrayList<WashingMachine>();
		Amica amica1 = new Amica();
		Beko beko1 = new Beko();
		Whirlpool whirlpool1 = new Whirlpool();
		
		allAGD.add(whirlpool1);
		allAGD.add(beko1);
		allAGD.add(amica1);
		
		System.out.println(amica1.getBrandName());
		System.out.println(beko1.getBrandName());
		System.out.println(whirlpool1.getBrandName());
		
		amica1.setProgramme(2);
		amica1.previousProgramme();
		amica1.setRotationSpeed(999);
		amica1.rotationSpeeedUp();
		amica1.setTemperature(90.0f);
		amica1.showStatus();
		try {
			amica1.tempUp();
		} catch (WashingMachineException e) {
			System.out.println(e.getMessage());
		}
		whirlpool1.setProgramme(23);
		whirlpool1.nextProgramme();
		whirlpool1.setRotationSpeed(0);
		whirlpool1.rotationSpeedDown();
		whirlpool1.setTemperature(0.0f);
		whirlpool1.showStatus();
		try {
			whirlpool1.tempDown();
		} catch (WashingMachineException e) {
			System.out.println(e.getMessage());
		}
		
		beko1.setProgramme(19);
		beko1.nextProgramme();
		beko1.setRotationSpeed(500);
		beko1.rotationSpeedDown();
		beko1.setTemperature(10.3f);
		beko1.showStatus();
		try {
			beko1.tempDown();
		} catch (WashingMachineException e) {
			System.out.println(e.getMessage());
		}
		
		allAGD.stream()
				.forEach(System.out::println);
		allAGD.stream()
				.sorted(Comparator.comparing(WashingMachine::getBrandName))
				.forEach(System.out::println);
		
	}
	
}
