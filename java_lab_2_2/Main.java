package lab2.java_lab_2_2;

public class Main {

	public static void main(String[] args) {
		Rejestr rejestr = new Rejestr();
		Wlasciciel w1 = new Wlasciciel("Kowalski");
		Dyplom d1 = new Dyplom_uznania("DU/123", w1, "Za zasługi");
		rejestr.dopisz_dyplom(d1);
		rejestr.dopisz_dyplom(new Dyplom_Inzyniera("DI/123", new Wlasciciel("Nowak"), "informatyk"));
		
		System.out.println(rejestr);
		rejestr.wykaz_dyplomow_inz();
		rejestr.wykaz_dyplomow_uzn();
	}

}
