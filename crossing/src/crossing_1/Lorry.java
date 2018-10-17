package crossing_1;

public class Lorry extends MotorCar {
	private double	maxLoad;
	private double	currentLoad;
	
	public Lorry() {
		super();
	}
	
	public Lorry(String license, double capacity, String fuelType, double maxLoad, double currentLoad) {
		super(license, capacity, fuelType);
		this.maxLoad = maxLoad;
		this.setCurrentLoad(currentLoad);
		
	}
	
	public double getMaxLoad() {
		return maxLoad;
	}
	
	public void setMaxLoad(double maxLoad) {
		this.maxLoad = maxLoad;
	}
	
	public boolean canCarry(double currentLoad) {
		if (currentLoad <= maxLoad) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Lorry [license=" + license + ", Owner=" + Owner + ", hasMotor=" + hasMotor + ", capacity=" + capacity + "l" + ", fuelType=" + fuelType + ", maxLoad=" + maxLoad + "kg"
				+ ", currentLoad= " + currentLoad + ", canCarry= " + canCarry(currentLoad) + " ]";
	}
	
	public double getCurrentLoad() {
		return currentLoad;
	}
	
	public void setCurrentLoad(double currentLoad) {
		this.currentLoad = currentLoad;
	}
	
}
