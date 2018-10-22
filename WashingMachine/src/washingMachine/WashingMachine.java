package washingMachine;

public abstract class WashingMachine {
	private int	programme;
	float		temperature;
	int			rotationSpeed;
	
	public WashingMachine() {
	}
	
	public WashingMachine(int programme, float temperature, int rotationSpeed) {
		this.programme = programme;
		this.temperature = temperature;
		this.rotationSpeed = rotationSpeed;
	}
	
	public int getProgramme() {
		return programme;
	}
	
	public void setProgramme(int programme) {
		this.programme = programme;
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
		this.rotationSpeed = rotationSpeed;
	}
	
	public int nextProgramme(int programme) {
		if (programme < 20) {
			programme++;
		}
		return programme;
	}
	
	public int previousProgramme(int programme) {
		if (programme > 0) {
			programme--;
		}
		return programme;
	}
	
	public float tempUp(float temperature) throws WashingMachineException {
		if (temperature < 90) {
			temperature += 0.5;
			System.out.println("Current temperature: " + temperature + "\u00b0 C");
			return temperature;
		} else {
			throw new WashingMachineException("The temperature is already at maximum");
		}
	}
	
	public float tempDown(float temperature) throws WashingMachineException {
		if (temperature > 0) {
			temperature += 0.5;
			System.out.println("Current temperature: " + temperature + "\u00b0C");
			return temperature;
		} else {
			throw new WashingMachineException("The temperature is already at minimum");
		}
	}
	
	public int rotationSpeeedUp(int speed) {
		if (speed < 1000) {
			speed += 100;
		} else {
			speed = 0;
		}
		return speed;
	}
	
	public int rotationSpeedDown(int speed) {
		if (speed > 0) {
			speed -= 100;
		} else {
			speed = 1000;
		}
		return speed;
	}
	
	public void showStatus() {
		System.out.println("Programme : " + this.programme + ", temperature: " + this.temperature + "\u00b0C , speed: " + this.rotationSpeed);
	}
	
}
