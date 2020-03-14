package lab3.lab3_1;

public class TestParkingu {

    public static void main(String[] args) throws PojazdNIeWSpisieException, ParkingPelnyException {

        Parking C13 = new Parking(10, "C13");
        Parking D20 = new Parking(15, "D20");
        Parking Wronskiego = new Parking(5, "Wronskiego");
        Samochod sam1 = new Samochod("DW12345", 4, "Volvo");
        Samochod sam2 = new Samochod("DW67890", 4, "Audi");
        Samochod sam3 = new Samochod("DWABCDE", 4, "VW");
        Samochod sam4 = new Samochod("DWFGHIJ", 4, "Renault");
        Samochod sam5 = new Samochod("DWKLMNO", 4, "Chrysler");
        Samochod sam6 = new Samochod("DW09876", 4, "Fiat");
        Samochod sam7 = new Samochod("DW54321", 4, "Skoda");
        Samochod sam8 = new Samochod("DW1A2BC", 4, "Dacia");
        Motocykl mot1 = new Motocykl("DW0ZX80", "Yamaha");
        Motocykl mot2 = new Motocykl("DW0CC67", "Honda");

        C13.zarejestrujWiele(sam1, sam2, sam3, sam4);
        D20.zarejestrujWiele(sam1, sam2, sam3, sam4, sam5, sam6, mot1, mot2);
        Wronskiego.zarejestrujWiele(sam1, sam2, sam3, sam4, sam5, sam6, sam7, sam8, mot1, mot2);

        try {
            C13.zaparkuj(sam1);
            C13.zaparkuj(sam8);
        } catch (PojazdNIeWSpisieException e) {
            System.out.println(e.getMessage());
        }
        try {
            Wronskiego.zaparkuj(sam1);
            Wronskiego.zaparkuj(sam2);
            Wronskiego.zaparkuj(sam3);
            Wronskiego.zaparkuj(sam4);
            Wronskiego.zaparkuj(sam5);
            Wronskiego.zaparkuj(mot1);
        } catch (ParkingPelnyException e) {
            System.out.println(e.getMessage());
        }
        try {
            D20.zaparkuj(mot1);
            D20.zaparkuj(mot2);
            D20.wyjedz(mot2);
            D20.wyjedz(sam1);
        }catch (PojazdPozaParkingiemException e){
            System.out.println(e.getMessage());
        }


        gdzieZaparkuje(C13, D20, Wronskiego);
    }

    public static boolean czyZaparkujeTu(Parking parking) {
        return parking.czyJesMiejsce();
    }

    public static void gdzieZaparkuje(Parking... parkingi) {
        for (Parking par : parkingi) {
            if (czyZaparkujeTu(par)) {
                System.out.println(par.toString());
            }
        }
    }

}
