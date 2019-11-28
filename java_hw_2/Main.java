package lab1.java_hw_2;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner readData = new Scanner(System.in);
        System.out.println("podaj współrzędną x punktu");
        double x = readData.nextDouble();
        System.out.println("podaj współrzędną y punktu");
        double y = readData.nextDouble();
        System.out.println("podaj współrzędną x pierwszego wierzchołka trójkąta");
        double tx1 = readData.nextDouble();
        System.out.println("podaj współrzędną y pierwszego wierzchołka trójkąta");
        double ty1 = readData.nextDouble();
        System.out.println("podaj współrzędną x drugiego wierzchołka trójkąta");
        double tx2 = readData.nextDouble();
        System.out.println("podaj współrzędną y drugiego wierzchołka trójkąta");
        double ty2 = readData.nextDouble();
        System.out.println("podaj współrzędną x trzeciego wierzchołka trójkąta");
        double tx3 = readData.nextDouble();
        System.out.println("podaj współrzędną y trzeciego wierzchołka trójkąta");
        double ty3 = readData.nextDouble();
        readData.close();

        Punkt p = new Punkt(x, y);
        Trojkat trojkat = new Trojkat(tx1, ty1, tx2, ty2, tx3, ty3);

        isPointInTriangle(trojkat, p);

    }
    private static double rounder(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    public static void isPointInTriangle(Trojkat triangle, Punkt p) {
        double circumference = triangle.getArea(triangle);
        double circumPoint1 = triangle.getArea(new Trojkat(triangle.vertice1, triangle.vertice2, p));
        double circumPoint2 = triangle.getArea(new Trojkat(triangle.vertice1, triangle.vertice3, p));
        double circumPoint3 = triangle.getArea(new Trojkat(triangle.vertice3, triangle.vertice2, p));
        if (rounder(circumference, 2) == rounder(circumPoint1, 2) + rounder(circumPoint2, 2) + rounder(circumPoint3, 2)) {
            System.out.println("Punkt " + p + " należy do trójkąta " + triangle);
        } else {
            System.out.println("Punkt " + p + " nie należy do trójkąta " + triangle);
        }
    }
}
