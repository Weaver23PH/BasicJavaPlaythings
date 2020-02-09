package lab2.java_lab_2_2;

public class Rejestr {
	private int max_dypl = 100;
	private Dyplom[] rejestr_dyplomow = new Dyplom[max_dypl];
	private int liczba_dypl = 0;

	public void dopisz_dyplom(Dyplom dyplom) {
		if (liczba_dypl < max_dypl) 
			rejestr_dyplomow[liczba_dypl++] = dyplom;
		 else {
			Dyplom[] nowy_rejestr_dypl = new Dyplom[max_dypl + 1];
			for (int i = 0; i < max_dypl; i++)
				nowy_rejestr_dypl[i] = rejestr_dyplomow[i];
			nowy_rejestr_dypl[liczba_dypl++] = dyplom;
			rejestr_dyplomow = nowy_rejestr_dypl;
			max_dypl++;
		}
	}
	public String toString() {
		String lista ="";
		for (int i=0; i < liczba_dypl; i++) 
			lista+= rejestr_dyplomow[i].toString() + "\n";
		return lista;
	}
	
	public void wykaz_dyplomow_inz() {
		System.out.println("Dyplomy inzyniera");
		for (int i = 0; i <liczba_dypl; i++)
			if(rejestr_dyplomow[i] instanceof Dyplom_Inzyniera) 
				System.out.println(rejestr_dyplomow[i]);
	}
	
	public void wykaz_dyplomow_uzn() {
		System.out.println("Dyplomy uznania");
		for (int i = 0; i <liczba_dypl; i++)
			if(rejestr_dyplomow[i] instanceof Dyplom_uznania) 
				System.out.println(rejestr_dyplomow[i]);
	}
}
