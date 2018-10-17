package crossing_1;

import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		Set<Vehicle> allVehicles = new HashSet<Vehicle>();
		Set<Owner> allOwners = new HashSet<Owner>();
		Bicycle stefek = new Bicycle("Stefek666", "kolażówka");
		PassengerCar krzysiu = new PassengerCar("Krzysiu123", 2.0, "e98", 5, 5);
		PassengerCar tomek = new PassengerCar("Tomek789", 1.3, "e98", 3, 4);
		Lorry bohdan = new Lorry("Bohdan456", 3.0, "diesel", 200, 150);
		Owner benek = new Owner("1", "Benek", "Nowak", 55);
		Owner tadek = new Owner("2", "Tadek", "Nowak", 65);
		allVehicles.add(bohdan);
		allVehicles.add(tomek);
		allVehicles.add(krzysiu);
		allVehicles.add(stefek);
		allOwners.add(tadek);
		allOwners.add(benek);
		
		stefek.addOwner(tadek);
		krzysiu.addOwner(tadek);
		
		benek.addVehicle(bohdan);
		benek.addVehicle(tomek);
		benek.addVehicle(krzysiu);
		
		// System.out.println(tadek.showOwnedVehicles());
		// System.out.println(benek.showOwnedVehicles());
		// System.out.println(benek.returnAverageCapacity());
		// System.out.println(tadek.returnAverageCapacity());
		// System.out.println(stefek.showVehicleOwners());
		// System.out.println(returnAllOwners(allVehicles));
		// System.out.println(findByLicense("Bohdan456", allVehicles));
		// System.out.println(findMaxPassengers(allVehicles));
		// System.out.println(returnAverageCapacity(allVehicles));
		// System.out.println(returnBothCarAndBicycleOwner(allOwners));
		System.out.println(returnVehicleCoOwners(allVehicles));
	}
	
	static public String returnAllOwners(Set<Vehicle> allVehicles) {
		String currOwners = null;
		for (Vehicle vehicle : allVehicles) {
			if (currOwners != (vehicle.getOwner()
					.toString())) {
				currOwners = vehicle.getOwner()
						.toString();
			}
			if (currOwners.length() < vehicle.getOwner()
					.toString()
					.length()) {
				return vehicle.getOwner()
						.toString();
			} else {
				return currOwners;
			}
		}
		return "nobody owns anything";
	}
	
	static public String findMaxPassengers(Set<Vehicle> allVehicles) {
		int max = 0;
		String tempLicense = null;
		for (Vehicle car : allVehicles) {
			if (car instanceof PassengerCar) {
				if (((PassengerCar) car).getMaxPassengers() > max) {
					max = ((PassengerCar) car).getMaxPassengers();
					tempLicense = car.license;
				}
			}
		}
		return tempLicense;
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
	
	static public String returnBothCarAndBicycleOwner(Set<Owner> allOwners) {
		for (Owner owner : allOwners) {
			if (owner.OwnedVehicles.toString()
					.contains("Bicycle")
					&& (owner.OwnedVehicles.toString()
							.contains("hasMotor=true"))) {
				return owner.toString();
			}
		}
		return "No such owner";
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
