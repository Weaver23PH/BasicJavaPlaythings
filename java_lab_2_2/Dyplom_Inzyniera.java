package lab2.java_lab_2_2;

public class Dyplom_Inzyniera extends Dyplom{
String specjalnosc;
	public Dyplom_Inzyniera(String numer_dyplomu, Wlasciciel wlasciciel, String specjalnosc) {
		super(numer_dyplomu, wlasciciel);
		this.specjalnosc = specjalnosc;
	}
	@Override
	public String toString() {
		return "Dyplom Inzyniera " + super.toString() +  " specjalnosc " + specjalnosc;
	}

}
