package washingMachine;

public abstract class WashingMachine {
	protected int	programme;
	protected float	temperature;
	protected int	rotationSpeed;
	
	public WashingMachine() {
		this.programme = 0;
		this.temperature = 0f;
		this.rotationSpeed = 0;
	}
	
	public WashingMachine(int programme, float temperature, int rotationSpeed) {
		if (rotationSpeed <= 1000) {
			this.rotationSpeed = (int) ((Math.round(rotationSpeed / 100.0)) * 100);
		} else {
			this.rotationSpeed = 0;
		}
		if (temperature <= 90) {
			this.temperature = temperature;
		} else {
			this.temperature = 0;
		}
		if (programme <= 20) {
			this.programme = programme;
		} else {
			this.programme = 0;
		}
		
	}
	
	public int getProgramme() {
		return programme;
	}
	
	public void setProgramme(int programme) {
		if (programme <= 20) {
			this.programme = programme;
		} else {
			this.programme = 0;
		}
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public void setTemperature(float temperature) {
		if (temperature - Math.floor(temperature) < 0.4) {
			this.temperature = (float) Math.floor(temperature);
		} else if (temperature - Math.floor(temperature) > 0.7) {
			this.temperature = (float) Math.ceil(temperature);
		} else {
			this.temperature = (float) (Math.floor(temperature) + 0.5);
		}
	}
	
	public int getRotationSpeed() {
		return rotationSpeed;
	}
	
	public void setRotationSpeed(int rotationSpeed) {
		if (rotationSpeed <= 1000) {
			this.rotationSpeed = (int) ((Math.round(rotationSpeed / 100.0)) * 100);
		} else {
			this.rotationSpeed = 0;
		}
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
			this.temperature += 0.5;
			System.out.println("Current temperature: " + this.temperature + "\u00b0 C");
			return this.temperature;
		} else {
			throw new WashingMachineException("The temperature is already at maximum");
		}
	}
	
	public float tempDown() throws WashingMachineException {
		if (this.temperature > 0) {
			this.temperature -= 0.5;
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
		System.out.println("Programme : " + this.programme + ", temperature: " + this.temperature + "\u00b0C , speed: " + this.rotationSpeed);
	}
	
	abstract public String getBrandName();
}
