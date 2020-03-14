package lab3.lab3_1;

public class ParkingPelnyException extends Exception {
    public ParkingPelnyException(Pojazd pojazd){
        super("Nie ma już miejsc na parkingu dla " + pojazd.toString() + " Nie można wjechać!");
}}
