package lab3.lab3_1;

public abstract class Pojazd implements Identyfikacja {
    String numerRejestracyjny;
    int liczbaKol;
    int liczbaMiejsc;
    String marka;

    public Pojazd(String numerRejestracyjny, String marka) {
        this.numerRejestracyjny = numerRejestracyjny;
        this.marka = marka;
    }

    @Override
    public String numerRejestracyjny() {
        return this.numerRejestracyjny;
    }

    @Override
    public String toString() {
        return "Pojazd{" +
                "numerRejestracyjny='" + numerRejestracyjny + '\'' +
                ", marka='" + marka + '\'' +
                '}';
    }
}
