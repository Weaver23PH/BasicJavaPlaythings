package lab1.java_hw_3;

public class Main {

    public static void main(String[] args) {

        MojaData data1 = new MojaData();
        MojaData data2 = new MojaData();

        data1.readDate();
        data2.readDate();

        data1.getDayOfYear();
        data1.isLeapYear();
        data1.setDateEarlierByDays(2);
        data1.setDateLaterByDays(5);

        data2.getDayOfYear();
        data2.isLeapYear();
        data2.setDateEarlierByDays(3);
        data2.setDateLaterByDays(7);

        data1.getDaysDifference(data2);
        data1.compareDates(data2);

    }
}
