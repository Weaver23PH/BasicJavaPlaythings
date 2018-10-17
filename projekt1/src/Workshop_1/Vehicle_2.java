package Workshop_1;

public class Vehicle_2 {
	private String	name;
	private double	maxSpeed;
	
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Vehicle_2() {
		
	}
	
	public Vehicle_2(String name, double maxSpeed) {
		this.name = name;
		this.maxSpeed = maxSpeed;
		
		System.out.println(this.name);
		System.out.println(this.maxSpeed);
	}
	
	public void printString(String text) {
		System.out.println(text);
	}
}
