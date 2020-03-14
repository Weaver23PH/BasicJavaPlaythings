package lab3.lab3_1;

public class Samochod extends Pojazd implements Identyfikacja{
    public Samochod(String numerRejestracyjny, int liczbaMiejsc,  String marka) {
        super(numerRejestracyjny, marka);
        this.liczbaKol=4;
        this.liczbaMiejsc=liczbaMiejsc;
    }
}
