package washingMachine;

public class Beko extends WashingMachine {
	private String brandName;
	
	public Beko() {
		this.brandName = WashingMachineNames.BEKO.getBrand();
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	@Override
	public float tempUp() throws WashingMachineException {
		if (this.temperature < 90) {
			this.temperature += 1;
			System.out.println("Current temperature: " + this.temperature + "\u00b0 C");
			return this.temperature;
		} else {
			throw new WashingMachineException("The temperature is already at maximum");
		}
	}
	
	@Override
	public float tempDown() throws WashingMachineException {
		if (this.temperature > 0) {
			this.temperature -= 1;
			System.out.println("Current temperature: " + this.temperature + "\u00b0C");
			return this.temperature;
		} else {
			throw new WashingMachineException("The temperature is already at minimum");
		}
	}
	
}
