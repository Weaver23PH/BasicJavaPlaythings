package washingMachine;

public class Whirlpool extends WashingMachine {
	private String brandName;
	
	public Whirlpool() {
		this.brandName = WashingMachineNames.WHIRLPOOL.getBrand();
		this.maxProgramme = 25;
	}
	
	public Whirlpool(int programme, float temperature, int rotationSpeed) {
		super(programme, temperature, rotationSpeed);
		this.brandName = WashingMachineNames.WHIRLPOOL.getBrand();
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public Whirlpool(int programme) {
		super();
		this.programme = this.setProgramme(programme);
	}
	
}
