package washingMachine;

public class Amica extends WashingMachine {
	private String brandName;
	
	public Amica() {
		this.brandName = WashingMachineNames.AMICA.getBrand();
	}
	
	public Amica(int programme, float temperature, int rotationSpeed) {
		super(programme, temperature, rotationSpeed);
		this.brandName = WashingMachineNames.AMICA.getBrand();
	}
	
	public String getBrandName() {
		return brandName;
	}
	
}
