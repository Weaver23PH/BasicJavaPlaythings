package washingMachine;

public class Beko extends WashingMachine {
	private String brandName;
	
	public Beko() {
		this.brandName = WashingMachineNames.BEKO.getBrand();
		this.tempStep = 1.0f;
	}
	
	public Beko(int programme, float temperature, int rotationSpeed) {
		super(programme, temperature, rotationSpeed);
		this.brandName = WashingMachineNames.BEKO.getBrand();
		this.tempStep = 1.0f;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	@Override
	public float setTemperature(float temperature) {
		if (temperature <= MAX_TEMP) {
			this.temperature = Math.round(temperature);
		} else {
			this.temperature = 0;
		}
		return this.temperature;
	}
	
}
