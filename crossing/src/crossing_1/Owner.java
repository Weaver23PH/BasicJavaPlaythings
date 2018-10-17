package crossing_1;

import java.util.HashSet;
import java.util.Set;

public class Owner {
	private String			ownerID;
	private String			firstName;
	private String			lastName;
	private int				age;
	protected Set<Vehicle>	OwnedVehicles;
	
	public Owner() {
		
	}
	
	public Owner(String ownerID, String firstName, String lastName, int age) {
		this.ownerID = ownerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.OwnedVehicles = new HashSet<Vehicle>();
	}
	
	@Override
	public String toString() {
		return "Owner [ID =" + ownerID + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	public String showOwnedVehicles() {
		return "Owner [ID =" + ownerID + ", OwnedVehicles" + OwnedVehicles + "]";
	}
	
	public void addVehicle(Vehicle vehicle) {
		this.OwnedVehicles.add(vehicle);
		vehicle.setOwner(this);
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.OwnedVehicles.add(vehicle);
	}
	
	public double returnAverageCapacity() {
		double avgCapacity = 0;
		int counter = 0;
		for (Vehicle car : OwnedVehicles) {
			if (car.isMotor()) {
				counter++;
				avgCapacity += (((MotorCar) car).getCapacity());
			}
		}
		return avgCapacity / counter;
	}
	
	public String findByLicense(String license) {
		for (Vehicle car : OwnedVehicles) {
			if (car.isMotor()) {
				if (car.license == license) {
					return "Vehicle [  Owner=" + car.getOwner() + ", capacity=" + ((MotorCar) car).getCapacity() + "l" + ", fuelType=" + ((MotorCar) car).getFuelType() + " ] ";
				}
			}
		}
		return "no such vehicle";
	}
	
}
