package lab2.java_lab_2_3;

import java.util.Scanner;

public class Kwadrat extends Prostokat {
    double a;


    public Kwadrat(double a) {
        super(a, a);
        this.a = a;
    }
    @Override
    public String toString() {
        return "Kwadrat{" +
                "bok=" + a +
                '}';
    }
}
