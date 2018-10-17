package Workshop_1;

public class Task_6_2 {
	
	public static void main(String[] args) {
		Vehicle zenon = new Vehicle(); // task 5
		zenon.setName("Zenon");
		zenon.setMaxSpeed(125);
		System.out.println(zenon.getName());
		System.out.println(zenon.getMaxSpeed());
		
		MyCar Zdzich = new MyCar("Zdzich", 230, "zielony"); // task 8
		Zdzich.printString("this is the second text");
	}
	
}
