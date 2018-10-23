package washingMachine;

public class Whirlpool extends WashingMachine {
	private String brandName;
	
	public Whirlpool() {
		this.brandName = WashingMachineNames.WHIRLPOOL.getBrand();
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public Whirlpool(int programme) {
		super();
		if (programme <= 25) {
			this.programme = programme;
		} else {
			this.programme = 0;
		}
	}
	
	@Override
	public void setProgramme(int programme) {
		if (programme <= 25) {
			this.programme = programme;
		} else {
			this.programme = 0;
		}
	}
	
	@Override
	public int nextProgramme() {
		if (this.programme < 25) {
			this.programme++;
		}
		return this.programme;
	}
}
