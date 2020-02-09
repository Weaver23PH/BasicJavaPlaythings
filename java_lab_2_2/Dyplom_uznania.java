package lab2.java_lab_2_2;

public class Dyplom_uznania extends Dyplom {
	String tytul;

	public Dyplom_uznania(String numer_dyplomu, Wlasciciel wlasciciel, String tytul) {
		super(numer_dyplomu, wlasciciel);
		this.tytul = tytul;
	}

	@Override
	public String toString() {
		return "Dyplom uznania " +  super.toString() + " Tytuł " +  tytul;
	}

}
