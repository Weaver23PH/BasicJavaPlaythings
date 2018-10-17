package crossing_1;

import java.util.HashSet;
import java.util.Set;

abstract public class Vehicle {
	protected String		license;
	protected Set<Owner>	Owner;
	protected boolean		hasMotor;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String license, boolean hasMotor) {
		this.license = license;
		this.Owner = new HashSet<Owner>();
		this.hasMotor = hasMotor;
	}
	
	public boolean isMotor() {
		if (this.hasMotor) {
			return true;
		}
		return false;
	}
	
	public String getLicense() {
		return license;
	}
	
	public void setLicense(String license) {
		this.license = license;
	}
	
	public Set<Owner> getOwner() {
		return Owner;
	}
	
	public void setOwner(Set<Owner> owner) {
		Owner = owner;
	}
	
	public boolean isHasMotor() {
		return hasMotor;
	}
	
	public void setHasMotor(boolean hasMotor) {
		this.hasMotor = hasMotor;
	}
	
	public String showVehicleOwners() {
		return "Vehicle [license =" + license + ", Owner=" + Owner + "]";
	}
	
	public void addOwner(Owner owner) {
		this.Owner.add(owner);
		owner.setVehicle(this);
	}
	
	public void setOwner(Owner owner) {
		this.Owner.add(owner);
	}
	
	@Override
	public String toString() {
		return "Vehicle [license= " + license + ", Owner=" + Owner + ", hasMotor=" + hasMotor + "]";
	}
	
}