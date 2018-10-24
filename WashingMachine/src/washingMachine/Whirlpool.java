package washingMachine;

public class Whirlpool extends WashingMachine {
	private String brandName;
	
	public Whirlpool() {
		this.brandName = WashingMachineNames.WHIRLPOOL.getBrand();
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
	
	@Override
	public int setProgramme(int programme) {
		if (programme <= 25) {
			this.programme = programme;
		} else {
			this.programme = 0;
		}
		return this.programme;
	}
	
	@Override
	public int nextProgramme() {
		if (this.programme < 25) {
			this.programme++;
		}
		return this.programme;
	}
}
