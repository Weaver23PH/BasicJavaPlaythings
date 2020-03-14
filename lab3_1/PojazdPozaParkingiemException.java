package lab3.lab3_1;

public class PojazdPozaParkingiemException extends Exception{
    public PojazdPozaParkingiemException(Pojazd pojazd){
        super(pojazd.toString() + " - tego pojazdu nie ma na parkingu! Nie można wyjechać!");
    }
}
