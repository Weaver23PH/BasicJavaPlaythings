package washingMachine;

public class Amica extends WashingMachine {
	private String brandName;
	
	public Amica() {
		this.brandName = WashingMachineNames.AMICA.getBrand();
	}
	
	public String getBrandName() {
		return brandName;
	}
	
}
