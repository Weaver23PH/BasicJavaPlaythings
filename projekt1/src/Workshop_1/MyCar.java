package Workshop_1;

public class MyCar extends Vehicle_2 {
	private String colour;
	
	public MyCar() {
		
	}
	public MyCar(String name, double maxSpeed, String colour) {
		super(name, maxSpeed);
		this.colour = colour;
	}
	
	public void printString(String text_2) {
		super.printString("this is the first text");
		System.out.println(text_2);
	}
}
