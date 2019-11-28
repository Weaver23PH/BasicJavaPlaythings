package lab1.java_hw_2;

public class Trojkat {
    Punkt vertice1, vertice2, vertice3;


    public Trojkat(Punkt p1, Punkt p2, Punkt p3) {
        this.vertice1 = p1;
        this.vertice2 = p2;
        this.vertice3 = p3;

    }

    public Trojkat(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.vertice1 = new Punkt(x1, y1);
        this.vertice2 = new Punkt(x2, y2);
        this.vertice3 = new Punkt(x3, y3);
    }

    private double getSideLength(Punkt p1, Punkt p2) {
        return p1.getDistanceFrom(p2);
    }

    private double getCircumference(Trojkat triangle) {
        double sideLength1 = getSideLength(triangle.vertice1, triangle.vertice2);
        double sideLength2 = getSideLength(triangle.vertice1, triangle.vertice3);
        double sideLength3 = getSideLength(triangle.vertice3, triangle.vertice2);
        return (sideLength1 + sideLength2 + sideLength3) / 2;
    }

    private double getCircumference(Punkt vertice1, Punkt vertice2, Punkt vertice3) {
        double sideLength1 = getSideLength(vertice1, vertice2);
        double sideLength2 = getSideLength(vertice1, vertice3);
        double sideLength3 = getSideLength(vertice3, vertice2);
        return (sideLength1 + sideLength2 + sideLength3) / 2;
    }

    public double getArea(Trojkat triangle) {
        double side1 = getSideLength(triangle.vertice1, triangle.vertice2);
        double side2 = getSideLength(triangle.vertice1, triangle.vertice3);
        double side3 = getSideLength(triangle.vertice3, triangle.vertice2);
        double circumf = getCircumference(triangle);
        return Math.sqrt(circumf * (circumf - side1) * (circumf - side2) * (circumf - side3));
    }

    @Override
    public String toString() {
        return "Trojkat {" +
                "wierzchołek 1=[" + vertice1.x + "," + vertice1.y +
                "], wierzchołek 2=[" + vertice2.x + "," + vertice2.y +
                "], wierzchołek 3=[" + vertice3.x + "," + vertice3.y + "]}";
    }
}
