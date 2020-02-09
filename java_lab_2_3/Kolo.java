package lab2.java_lab_2_3;

import java.util.Scanner;

public class Kolo extends Figura {
    double r;


    public Kolo(double r) {
        this.r = r;
    }

    double getArea() {
        return round(Math.PI * Math.pow(r, 2), 2);
    }


    double getCircumference() {
        return round(2 * Math.PI * r, 2);
    }

    @Override
    public String toString() {
        return "Kolo{" +
                "r=" + r +
                '}';
    }
}
