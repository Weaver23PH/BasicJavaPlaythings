package washingMachine;

/**
 * @author MCARLO
 */

public abstract class WashingMachine {
	protected int			programme;
	protected float			temperature;
	private int				rotationSpeed;
	protected float			tempStep			= 0.5f;
	protected int			maxProgramme		= 20;
	final private int		maxRotationSpeed	= 1000;
	final protected float	maxTemp				= 90.0f;
	
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
	
	/**
	 * @param programme
	 * @return This setter sets programme and only allows values within the accepted limits
	 */
	public int setProgramme(int programme) {
		if (programme <= maxProgramme) {
			this.programme = programme;
		} else {
			this.programme = 0;
		}
		return this.programme;
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	/**
	 * @param temperature
	 * @return This setter sets temperature, only allows values within the accepted limits, and rounds the value
	 *         according to input
	 */
	public float setTemperature(float temperature) {
		if (temperature <= maxTemp) {
			if (temperature - Math.floor(temperature) < 0.4) {
				this.temperature = (float) Math.floor(temperature);
			} else if (temperature - Math.floor(temperature) > 0.7) {
				this.temperature = (float) Math.ceil(temperature);
			} else {
				this.temperature = (float) (Math.floor(temperature) + 0.5);
			}
		}
		return this.temperature;
	}
	
	public int getRotationSpeed() {
		return rotationSpeed;
	}
	
	/**
	 * @param temperature
	 * @return This setter sets rotation speed, only allows values within the accepted limits, and rounds its value
	 *         according to input
	 */
	public int setRotationSpeed(int rotationSpeed) {
		if (rotationSpeed <= maxRotationSpeed) {
			this.rotationSpeed = (int) ((Math.round(rotationSpeed / 100.0)) * 100);
		} else {
			this.rotationSpeed = 0;
		}
		return this.rotationSpeed;
	}
	
	/**
	 * @return This method increases programme by 1
	 */
	public int nextProgramme() {
		if (this.programme < maxProgramme) {
			this.programme++;
		}
		return this.programme;
	}
	
	/**
	 * @return This method decreases programme by 1
	 */
	public int previousProgramme() {
		if (this.programme > 0) {
			this.programme--;
		}
		return this.programme;
	}
	
	/**
	 * @return This method increases temperature
	 * @throws WashingMachineException
	 */
	public float tempUp() throws WashingMachineException {
		if (this.temperature < maxProgramme) {
			this.temperature += tempStep;
			System.out.println("Current temperature: " + this.temperature + "\u00b0 C");
			return this.temperature;
		} else {
			throw new WashingMachineException("The temperature is already at maximum");
		}
	}
	
	/**
	 * @return This method decreases temperature
	 * @throws WashingMachineException
	 */
	public float tempDown() throws WashingMachineException {
		if (this.temperature > 0) {
			this.temperature -= tempStep;
			System.out.println("Current temperature: " + this.temperature + "\u00b0C");
			return this.temperature;
		} else {
			throw new WashingMachineException("The temperature is already at minimum");
		}
	}
	
	/**
	 * @return This method increases rotation speed by 100
	 */
	public int rotationSpeeedUp() {
		if (this.rotationSpeed < maxRotationSpeed) {
			this.rotationSpeed += 100;
		} else {
			this.rotationSpeed = 0;
		}
		return this.rotationSpeed;
	}
	
	/**
	 * @return This method decreases rotation speed by 100
	 */
	public int rotationSpeedDown() {
		if (this.rotationSpeed > 0) {
			this.rotationSpeed -= 100;
		} else {
			this.rotationSpeed = 1000;
		}
		return this.rotationSpeed;
	}
	
	/**
	 * @return This method prints out the current values for an object of the type WashingMachine
	 */
	public void showStatus() {
		System.out.println("Brand: " + getBrandName() + ", programme : " + this.programme + ", temperature: " + this.temperature + "\u00b0C , speed: " + this.rotationSpeed);
	}
	
	abstract public String getBrandName();
}
