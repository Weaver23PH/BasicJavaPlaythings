package lab2.java_lab_2_3;

import java.util.Scanner;

public class Prostokat extends Figura {
    double a;
    double b;


    public Prostokat(double a, double b) {
        this.a = a;
        this.b = b;
    }


    public double getArea() {
        return this.a * this.b;
    }

    public double getCircumference() {
        return 2 * this.a + 2 * this.b;
    }

    @Override
    public String toString() {
        return "Prostokat{" +
                "bok a=" + a +
                ", bok b=" + b +
                '}';
    }
}
