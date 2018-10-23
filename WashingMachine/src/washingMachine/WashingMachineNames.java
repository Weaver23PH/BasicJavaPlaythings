package washingMachine;

public enum WashingMachineNames {
	AMICA("Amica"),
	WHIRLPOOL("Whirlpool"),
	BEKO("Beko");
	
	private final String brand;
	
	WashingMachineNames(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return this.brand;
	}
}
