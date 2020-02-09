package lab2.java_lab_2_2;

public abstract class Dyplom {
	protected String numer_dyplomu;
	protected Wlasciciel wlasciciel;

	public Dyplom(String numer_dyplomu, Wlasciciel wlasciciel) {
		this.numer_dyplomu = numer_dyplomu;
		this.wlasciciel = wlasciciel;
	}

	public String toString() {
		return "numer dyplomu= " + numer_dyplomu + ", " + wlasciciel ;
	}

	
}