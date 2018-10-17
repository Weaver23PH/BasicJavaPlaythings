package crossing_1;

public class PassengerCar extends MotorCar {
	private int	maxPassengers;
	private int	currentPassengers;
	
	public PassengerCar() {
		super();
	}
	
	public PassengerCar(String license, double capacity, String fuelType, int maxPassengers, int currentPassengers) {
		super(license, capacity, fuelType);
		this.maxPassengers = maxPassengers;
		this.setCurrentPassengers(currentPassengers);
	}
	
	public int getMaxPassengers() {
		return maxPassengers;
	}
	
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
	
	public boolean canDrive(int currentPassengers) {
		return (currentPassengers <= maxPassengers);
	}
	
	@Override
	public String toString() {
		return "PassengerCar [ license=" + license + ", Owner=" + Owner + ", hasMotor=" + hasMotor + ", capacity=" + capacity + "l" + ", fuelType=" + fuelType + ", maxPassengers="
				+ maxPassengers + ", currentPassengers= " + currentPassengers + ", canDrive= " + canDrive(currentPassengers) + " ]";
	}
	
	public int getCurrentPassengers() {
		return currentPassengers;
	}
	
	public void setCurrentPassengers(int currentPassengers) {
		this.currentPassengers = currentPassengers;
	}
	
}
