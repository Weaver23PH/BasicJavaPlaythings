package Workshop_1;

/**
 * @author MCARLO
 * @whatsit ? this is a javadoc
 */
public class Pojazd {
	
	private String	nazwa;
	private double	maxSpeed;
	
	public double printSpeed() {
		return maxSpeed;
	}
	
	public String printName() {
		return nazwa;
	}
	
	public static void main(String[] args) {
		Pojazd samochod = new Pojazd();
		samochod.nazwa = "Artur";
		samochod.maxSpeed = 102;
		System.out.println(samochod.printName());
		System.out.println(samochod.printSpeed());
	}
}
