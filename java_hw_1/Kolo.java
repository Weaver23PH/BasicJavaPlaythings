package lab1.java_hw_1;

public class Kolo {
	private Punkt centre;
	private double	r;
	
	public Kolo(Punkt centre, double r) {
		this.centre = centre;
		this.r = r;
	}
	public Kolo(double x, double y,  double r) {
		this.centre = new Punkt(x,y);
		this.r = r;
	}
	
	public boolean isPointIn(Punkt point) {
		return point.getDistanceFromCentre(this.centre) <= this.r;
	}
	
	@Override
	public String toString() {
		return "Kolo [centre=" + centre + ", r=" + r + "]";
	}
	
}
