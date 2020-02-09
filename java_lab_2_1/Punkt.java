package lab2.java_lab_2_1;

public class Punkt {
	double x, y;
	
	public Punkt(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getDistanceFromCentre(Punkt p) {
		double distX = Math.abs(p.x - this.x);
		double distY = Math.abs(p.y - this.y);
		return Math.sqrt(distX * distX + distY * distY);
	}
	
	@Override
	public String toString() {
		return "Punkt [x=" + x + ", y=" + y + "]";
	}
	
}
