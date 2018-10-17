package crossing_1;

abstract public class MotorCar extends Vehicle {
	protected double	capacity;
	protected String	fuelType;
	
	public MotorCar() {
		super();
		this.hasMotor = true;
	}
	
	public MotorCar(String license, double capacity, String fuelType) {
		super(license, true);
		this.capacity = capacity;
		this.fuelType = fuelType;
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	public String getFuelType() {
		return fuelType;
	}
	
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	@Override
	public String toString() {
		return "MotorCar [license=" + license + ", Owner=" + Owner + ", capacity=" + capacity + "l" + ", fuelType=" + fuelType + ", hasMotor=" + hasMotor + "]";
	}
	
}