package lab2.java_lab_2_3;

public abstract class Figura {

    abstract double getArea();

    abstract double getCircumference();

    double getCutPrice(double price){
        double cutPrice = round((getCircumference() * price),2);
        return cutPrice;
    }

    double getMaterialPrice(double price){
        double matPrice = round((getArea() * price), 2);
        return matPrice;
    }

    double getTotalPrice(double cutPrice, double matPrice){
        double totalPrice = round((getCutPrice(cutPrice) + getMaterialPrice(matPrice)), 2);
        return totalPrice;
    }
    //metody pomocnicze
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
