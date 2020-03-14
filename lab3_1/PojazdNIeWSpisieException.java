package lab3.lab3_1;

public class PojazdNIeWSpisieException extends Exception{
    public PojazdNIeWSpisieException(Pojazd pojazd) {
        super(pojazd.toString() + " - ten Pojazd nie znajduje się w spisie pojazdów z pozwoleniem na wjazd!");
    }
}
