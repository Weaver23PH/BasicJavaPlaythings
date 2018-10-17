package task;

public class Multiplication extends Computation implements Calculation {
	
	public Multiplication() {
		super();
		
	}
	
	public Multiplication(int arg1, int arg2) {
		super(arg1, arg2);
		
	}
	
	@Override
	public double compute(double arg1, double arg2) {
		return arg1 * arg2;
	}
	
}
