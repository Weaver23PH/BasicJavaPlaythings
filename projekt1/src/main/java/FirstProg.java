package main.java;

abstract public class FirstProg { // zakomentowane działa bez abstract
	
	// public static void main(String[] args) {
	// byte b = 127;
	// System.out.println(b);
	// b++;
	// System.out.println(b);
	//
	// short i = 32767;
	// System.out.println(i);
	// i++;
	// System.out.println(i);
	//
	// int c = 23;
	// int d = 93;
	// double e;
	// System.out.println(e = d / c); // wychodzi double ale zaokrąglony(bo dwa inty).
	//
	// int f = 23;
	// double g = 93;
	// double h;
	// double result = (double) g / f; // jawne rzutowanie na double.
	// System.out.println(h = g / f); // wychodzi prawidłowy double.
	// System.out.println(result);
	//
	// System.out.println(245 % 7);// 235 dniem roku zaczynającego się od poniedziałku jest poniedziałek;
	//
	// char j = 'a';
	// System.out.println(j + 10); // autokonwersja char na number
	// System.out.println((char) (j + 10)); // ponowne rzutowanie na char
	// System.out.println((char) (j - 32)); // z małej na dużą, reverse dodać 32
	// System.out.println();
	//
	// int tab2[] = null; // int [] tab 2
	// int tab1[] = { 1, 2 };
	// int tab3[] = {};
	// System.out.println(tab2); // tab2.length = = tablica bez długości - error
	// System.out.println(tab1.length);
	// System.out.println(tab3); //[I@7852e922 pusta tablica
	//
	
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
