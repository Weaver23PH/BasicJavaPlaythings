package crossing_1;

public class Bicycle extends Vehicle {
	private enum BikeType {
		turystyczny,
		górski,
		kolażówka
	}
	
	String type;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Bicycle() {
		super();
		this.hasMotor = false;
	}
	
	public boolean contains(String typeTest) {
		for (BikeType Type : BikeType.values()) {
			if (Type.name()
					.equals(typeTest)) {
				return true;
			}
		}
		return false;
	}
	
	public Bicycle(String license, String type) {
		super(license, false);
		
		if (contains(type)) {
			this.type = type;
		} else {
			this.type = "turystyczny";
		}
	}
	
	@Override
	public String toString() {
		return "Bicycle [license=" + license + ", Owner=" + Owner + ", type=" + type + ", hasMotor=" + hasMotor + "]";
	}
	
}
