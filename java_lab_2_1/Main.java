package lab2.java_lab_2_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner readData = new Scanner(System.in);
        System.out.println("Podaj ilość kół");
        int n = readData.nextInt();
        readData.close();
        Punkt checkP = new Punkt(5, 5);
        isPointIn(checkP, randomWheelSetMaker(n));
    }

    public static List<Kolo> randomWheelSetMaker(int n) {
        List<Kolo> setOfWheels = new ArrayList<Kolo>();
        for (int i = 1; i <= n; i++) {
            setOfWheels.add(new Kolo(new Punkt(Math.round(Math.random() * 100) / 10d, Math.round(Math.random() * 100) / 10d), Math.random() + 1));
        }
        return setOfWheels;
    }

    public static void isPointIn(Punkt point, List<Kolo> zbiorKol) {
        List<Kolo> setOfCorrectWheels = new ArrayList<Kolo>();
        boolean isPointInAny = false;
        for (Kolo kolo : zbiorKol) {
            isPointInAny = kolo.isPointIn(point);
            if (isPointInAny) {
                setOfCorrectWheels.add(kolo);
            }
        }
        for (Kolo kolo : setOfCorrectWheels) {
            System.out.println(point + " należy do koła " + kolo);
        }
        System.out.println(point +  " należy do " + setOfCorrectWheels.size() +  " z " + zbiorKol.size() + " kół");
    }
}
