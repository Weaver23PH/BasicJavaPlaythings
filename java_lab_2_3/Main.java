package lab2.java_lab_2_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner getInfo = new Scanner(System.in);
        System.out.println("podaj cenę materiału");
        double matPrice = getInfo.nextDouble();
        System.out.println("podaj cenę cięcia");
        double cutPrice = getInfo.nextDouble();
        System.out.println("podaj bok kwadratu");
        double sideAsq = getInfo.nextDouble();
        System.out.println("podaj promień koła");
        double radius =  getInfo.nextDouble();
        System.out.println("podaj bok A prostokąta");
        double sideA = getInfo.nextDouble();
        System.out.println("podaj bok B prostokąta");
        double sideB = getInfo.nextDouble();
        getInfo.close();
        zamowienie(cutPrice, matPrice, new Kolo(radius), new Kwadrat(sideAsq), new Prostokat(sideA, sideB));
    }


    public static void zamowienie(double cutPrice, double matPrice, Figura... figury) {
        double cenaMaterialu = 0;
        double cenaCiecia = 0;
        double cenaCalkow = 0;
        for (Figura fig : figury) {
            cenaMaterialu += fig.getMaterialPrice(matPrice);
            System.out.println("Cena materiału dla: " + fig.toString() + " to " + fig.getMaterialPrice(matPrice) + " zł");
            cenaCiecia += fig.getCutPrice(cutPrice);
            System.out.println("Cena cięcia dla: " + fig.toString() + " to " +fig.getCutPrice(cutPrice)  + " zł");
            cenaCalkow+= fig.getTotalPrice(cutPrice, matPrice);
            System.out.println("Cena całkowita dla: " + fig.toString() + " to " + fig.getTotalPrice(cutPrice, matPrice)  + " zł");
        }
        System.out.println("Cena materiału: " + cenaMaterialu + " zł");
        System.out.println("Cena cięcia: " + cenaCiecia + " zł");
        System.out.println("Cena całkowita: " + cenaCalkow + " zł");
    }

}
