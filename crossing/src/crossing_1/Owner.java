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
	
	public String getOwnerID() {
		return ownerID;
	}
	
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Set<Vehicle> getOwnedVehicles() {
		return OwnedVehicles;
	}
	
	public void setOwnedVehicles(Set<Vehicle> ownedVehicles) {
		OwnedVehicles = ownedVehicles;
	}
	
}
