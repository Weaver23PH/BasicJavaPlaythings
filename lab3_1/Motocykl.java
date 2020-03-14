package lab3.lab3_1;

public class Motocykl extends Pojazd implements Identyfikacja{
    public Motocykl(String numerRejestracyjny, String marka) {
        super(numerRejestracyjny, marka);
        this.liczbaKol = 2;
        this.liczbaMiejsc = 1;
    }
}
