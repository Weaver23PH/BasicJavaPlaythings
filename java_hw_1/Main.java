package lab1.java_hw_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner readData = new Scanner(System.in);
        System.out.println("podaj współrzędną x punktu");
        double x = readData.nextDouble();
        System.out.println("podaj współrzędną y punktu");
        double y = readData.nextDouble();
        System.out.println("podaj promień koła");
        double r = readData.nextDouble();

        Punkt p = new Punkt(x, y);

        readData.close();
        isPointOutside(p, wheelGroupMaker(r));

    }

    public static List<Kolo> wheelGroupMaker(double radius) {
        List<Kolo> setOfWheels = new ArrayList<Kolo>();
        setOfWheels.add(new Kolo(radius, radius, radius));
        setOfWheels.add(new Kolo(-radius, radius, radius));
        setOfWheels.add(new Kolo(radius, -radius, radius));
        setOfWheels.add(new Kolo(-radius, -radius, radius));
        return setOfWheels;
    }

    public static int isPointIn(Punkt point, List<Kolo> zbiorKol) {
        boolean isPointInAny = false;
        int falseCounter = 0;
        for (Kolo kolo : zbiorKol) {
            isPointInAny = kolo.isPointIn(point);
            if (!isPointInAny) {
                System.out.println(point + " nie należy do koła " + kolo);
                falseCounter++;
            }
            if (isPointInAny) {
                System.out.println(point + " należy do koła " + kolo);
            }
        }
        return falseCounter;
    }

    public static void isPointOutside(Punkt point, List<Kolo> zbiorKol) {
        int innerFalseCounter = isPointIn(point, zbiorKol);
       if ( innerFalseCounter > 0){
           System.out.println("Punkt "+ point + " leży poza obszarem " + innerFalseCounter + " koła/kół.");
       };
    }
}
