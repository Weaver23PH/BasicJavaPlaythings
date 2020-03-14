package lab3.lab3_1;

import java.util.HashSet;

public class Parking {
    int liczbaMiejsc;
    String adres;
    HashSet<Pojazd> pojazdy = new HashSet<>();
    HashSet<String> spisPojazdow = new HashSet<>();

    public Parking(int liczbaMiejsc, String adres) {
        this.liczbaMiejsc = liczbaMiejsc;
        this.adres = adres;
    }

    public void zaparkuj(Pojazd pojazd) throws ParkingPelnyException, PojazdNIeWSpisieException {
        if (this.czyJesMiejsce() && !this.czyJestNaParkingu(pojazd)) {
            if (this.czyJestWSpisie(pojazd)) {
                this.pojazdy.add(pojazd);
                System.out.println(pojazd.toString() + " wjechał na parking " + this.adres);
            } else {
                throw new PojazdNIeWSpisieException(pojazd);
            }
        } else {
            throw new ParkingPelnyException(pojazd);
        }
    }

    public void wyjedz(Pojazd pojazd) throws PojazdPozaParkingiemException {
        if (this.czyJestNaParkingu(pojazd)) {
            this.pojazdy.remove(pojazd);
            System.out.println(pojazd.toString() + " wyjechał z parkingu " + this.adres);
        } else {
            throw new PojazdPozaParkingiemException(pojazd);
        }
    }


    public void zarejestruj(Pojazd pojazd) {
        this.spisPojazdow.add(pojazd.numerRejestracyjny());
    }

    public void wyrejestruj(Pojazd pojazd) {
        this.spisPojazdow.remove(pojazd.numerRejestracyjny());
    }

    public void zarejestrujWiele(Pojazd... pojazdy) {
        for (Pojazd poj : pojazdy) {
            this.zarejestruj(poj);
        }
    }

    public void wyrejestrujWiele(Pojazd... pojazdy) {
        for (Pojazd poj : pojazdy) {
            this.wyrejestruj(poj);
        }
    }

    public boolean czyJestNaParkingu(Pojazd pojazd) {
        for (Pojazd poj : this.pojazdy) {
            return pojazdy.contains(pojazd);
        }
        return false;
    }

    public boolean czyJesMiejsce() {
        return this.pojazdy.size() < this.liczbaMiejsc;
    }

    public boolean czyJestWSpisie(Pojazd pojazd) {
        return this.spisPojazdow.contains(pojazd.numerRejestracyjny());
    }

    @Override
    public String toString() {
        return "Parking " + adres + " ma jeszcze " + (this.liczbaMiejsc - this.pojazdy.size()) + " miejsc.";
    }
}
