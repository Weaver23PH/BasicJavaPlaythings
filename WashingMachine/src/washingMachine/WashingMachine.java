package washingMachine;

public abstract class WashingMachine {
	protected int	programme;
	protected float	temperature;
	private int		rotationSpeed;
	protected float	tempStep	= 0.5f;
	
	public WashingMachine() {
		
	}
	
	public WashingMachine(int programme, float temperature, int rotationSpeed) {
		this.rotationSpeed = this.setRotationSpeed(rotationSpeed);
		this.temperature = this.setTemperature(temperature);
		this.programme = this.setProgramme(programme);
	}
	
	public int getProgramme() {
		return programme;
	}
	
	public int setProgramme(int programme) {
		if (programme <= 20) {
			this.programme = programme;
		} else {
			this.programme = 0;
		}
		return this.programme;
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float setTemperature(float temperature) {
		if (temperature - Math.floor(temperature) < 0.4) {
			this.temperature = (float) Math.floor(temperature);
		} else if (temperature - Math.floor(temperature) > 0.7) {
			this.temperature = (float) Math.ceil(temperature);
		} else {
			this.temperature = (float) (Math.floor(temperature) + 0.5);
		}
		return this.temperature;
	}
	
	public int getRotationSpeed() {
		return rotationSpeed;
	}
	
	public int setRotationSpeed(int rotationSpeed) {
		if (rotationSpeed <= 1000) {
			this.rotationSpeed = (int) ((Math.round(rotationSpeed / 100.0)) * 100);
		} else {
			this.rotationSpeed = 0;
		}
		return this.rotationSpeed;
	}
	
	public int nextProgramme() {
		if (this.programme < 20) {
			this.programme++;
		}
		return this.programme;
	}
	
	public int previousProgramme() {
		if (this.programme > 0) {
			this.programme--;
		}
		return this.programme;
	}
	
	public float tempUp() throws WashingMachineException {
		if (this.temperature < 90) {
			this.temperature += tempStep;
			System.out.println("Current temperature: " + this.temperature + "\u00b0 C");
			return this.temperature;
		} else {
			throw new WashingMachineException("The temperature is already at maximum");
		}
	}
	
	public float tempDown() throws WashingMachineException {
		if (this.temperature > 0) {
			this.temperature -= tempStep;
			System.out.println("Current temperature: " + this.temperature + "\u00b0C");
			return this.temperature;
		} else {
			throw new WashingMachineException("The temperature is already at minimum");
		}
	}
	
	public int rotationSpeeedUp() {
		if (this.rotationSpeed < 1000) {
			this.rotationSpeed += 100;
		} else {
			this.rotationSpeed = 0;
		}
		return this.rotationSpeed;
	}
	
	public int rotationSpeedDown() {
		if (this.rotationSpeed > 0) {
			this.rotationSpeed -= 100;
		} else {
			this.rotationSpeed = 1000;
		}
		return this.rotationSpeed;
	}
	
	public void showStatus() {
		System.out.println("Brand: " + getBrandName() + ", programme : " + this.programme + ", temperature: " + this.temperature + "\u00b0C , speed: " + this.rotationSpeed);
	}
	
	abstract public String getBrandName();
}
