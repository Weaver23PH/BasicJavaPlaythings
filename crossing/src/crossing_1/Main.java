package crossing_1;

import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		Set<Vehicle> allVehicles = new HashSet<Vehicle>();
		Set<Owner> allOwners = new HashSet<Owner>();
		Bicycle stefek = new Bicycle("Stefek666", "kolażówka");
		PassengerCar krzysiu = new PassengerCar("Krzysiu123", 2.0, "diesel", 5, 5);
		PassengerCar tomek = new PassengerCar("Tomek789", 0.9, "e98", 3, 4);
		PassengerCar edek = new PassengerCar("Edek902", 1.5, "e98", 5, 4);
		Lorry bohdan = new Lorry("Bohdan456", 3.0, "diesel", 200, 150);
		Owner benek = new Owner("1", "Benek", "Nowak", 55);
		Owner tadek = new Owner("2", "Tadek", "Nowak", 65);
		allVehicles.add(bohdan);
		allVehicles.add(tomek);
		allVehicles.add(krzysiu);
		allVehicles.add(stefek);
		allVehicles.add(edek);
		allOwners.add(tadek);
		allOwners.add(benek);
		
		stefek.addOwner(tadek);
		krzysiu.addOwner(tadek);
		edek.addOwner(tadek);
		
		benek.addVehicle(bohdan);
		benek.addVehicle(tomek);
		benek.addVehicle(krzysiu);
		
		System.out.println(returnAllOwners(allVehicles));
		System.out.println(findByLicense("Bohdan456", allVehicles));
		System.out.println(findMaxPassengers(allVehicles));
		System.out.println(returnAverageCapacity(allVehicles));
		System.out.println(returnBothCarAndBicycleOwner2(allOwners));
		System.out.println(returnVehicleCoOwners(allVehicles));
		
	}
	
	static public String returnAllOwners(Set<Vehicle> allVehicles) {
		Set<Owner> owners = new HashSet<Owner>();
		for (Vehicle vehicle : allVehicles) {
			for (Owner owner : vehicle.getOwner()) {
				owners.add(owner);
			}
		}
		return owners.toString();
	}
	
	static public String findMaxPassengers(Set<Vehicle> allVehicles) {
		int max = 0;
		String tempLicense = null;
		Set<String> allLicenses = new HashSet<String>();
		for (Vehicle car : allVehicles) {
			if (car instanceof PassengerCar) {
				if (((PassengerCar) car).getMaxPassengers() >= max) {
					max = ((PassengerCar) car).getMaxPassengers();
					tempLicense = car.license;
					allLicenses.add(tempLicense);
				}
			}
		}
		return allLicenses.toString();
	}
	
	static public String findByLicense(String license, Set<Vehicle> allVehicles) {
		for (Vehicle car : allVehicles) {
			if (car.isMotor()) {
				if (car.license == license) {
					return "Vehicle [  Owner=" + car.getOwner() + ", capacity=" + ((MotorCar) car).getCapacity() + "l" + ", fuelType=" + ((MotorCar) car).getFuelType() + " ] ";
				}
			}
		}
		return "no such vehicle";
	}
	
	static public double returnAverageCapacity(Set<Vehicle> allVehicles) {
		double avgCapacity = 0;
		int counter = 0;
		for (Vehicle car : allVehicles) {
			if (car.isMotor()) {
				counter++;
				avgCapacity += (((MotorCar) car).getCapacity());
			}
		}
		return avgCapacity / counter;
	}
	
	static public String returnBothCarAndBicycleOwner2(Set<Owner> allOwners) {
		Set<Owner> selectedOwner = new HashSet<Owner>();
		for (Owner owner : allOwners) {
			int bikeCounter = 0;
			int carCounter = 0;
			if (owner.getOwnedVehicles()
					.size() > 1) {
				for (Vehicle vehicle : owner.getOwnedVehicles()) {
					if (vehicle instanceof Bicycle) {
						bikeCounter++;
					} else if (vehicle instanceof PassengerCar) {
						carCounter++;
					}
				}
			}
			if (bikeCounter >= 1 && carCounter >= 1) {
				selectedOwner.add(owner);
			}
		}
		return selectedOwner.toString();
	}
	
	static public String returnVehicleCoOwners(Set<Vehicle> allVehicles) {
		
		for (Vehicle vehicle : allVehicles) {
			if (vehicle.getOwner()
					.size() > 1)
			
			{
				return vehicle.getOwner()
						.toString();
			}
		}
		return "no co-owned vehicles";
	}
}
