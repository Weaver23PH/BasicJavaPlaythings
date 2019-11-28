package lab1.java_hw_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MojaData {
    private int day, month, year;
    private LocalDate data;
    private DateTimeFormatter formatDaty = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public MojaData() {
    }

    public MojaData(int day, int month, int year) {
        setDate(day, month, year);
    }

    public void readDate() {
        Scanner readData = new Scanner(System.in);
        System.out.println("podaj numer dnia w miesiącu");
        int day = readData.nextInt();
        System.out.println("podaj numer miesiąca w roku");
        int month = readData.nextInt();
        System.out.println("podaj rok");
        int year = readData.nextInt();
        setDate(day, month, year);
    }

    private void setDate(int day, int month, int year) {
        if (year <= 0) {
            this.year = 1;
        } else {
            this.year = year;
        }
        if (month <= 0) {
            this.month = 1;
        } else if (month > 12) {
            this.month = 12;
        } else {
            this.month = month;
        }
        if (day <= 0) {
            this.day = 1;
        } else {
            switch (this.month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day > 31) {
                        this.day = 31;
                    } else {
                        this.day = day;
                    }
                    break;
                case 2:
                    if (((year % 4 == 0) &&
                            (year % 100 != 0)) || (year % 400 == 0)) {
                        if (day > 29) {
                            this.day = 29;
                        } else {
                            this.day = day;
                        }
                    } else {
                        if (day > 28) {
                            this.day = 28;
                        } else {
                            this.day = day;
                        }
                    }
                    break;
                default:
                    if (day > 30) {
                        this.day = 30;
                    } else {
                        this.day = day;
                    }
            }
        }

        String textDate = String.format("%02d", this.day) + "-" + String.format("%02d", this.month) + "-" + String.format("%04d", (long) this.year);
        this.data = LocalDate.from(formatDaty.parse(textDate));
    }


    public int getNumberOfDaysInMonth() {
        return this.data.lengthOfMonth();
    }

    public boolean isLeapYear() {
        int year = this.data.getYear();
        boolean isLeap = (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
        if (isLeap) {
            System.out.println("Rok " + this.data.getYear() + " to rok przestępny");
        } else {
            System.out.println("Rok " + this.data.getYear() + " to nie rok przestępny");
        }
        return isLeap;
    }

    public void compareDates(MojaData data) {
        Long differenceInDays = getDaysDifference(data);
        if (this.data.isAfter(data.data)) {
            System.out.println(this.toString() + " jest pózńiej niż " + data.toString() + " o " + differenceInDays + " dni");
        } else if (this.data.isBefore(data.data)) {
            System.out.println(this.toString() + " jest wcześniej niż " + data.toString() + " o " + differenceInDays + " dni");
        }
    }

    public Long getDaysDifference(MojaData data) {
        Long daysBetween = Math.abs(ChronoUnit.DAYS.between(this.data, data.data));
        System.out.println("Pomiędzy " + this.data.toString() + " i " + data.data.toString() + " jest " + daysBetween + " dni różnicy");
        return daysBetween;
    }

    public void setDateLaterByDays(int later) {
        System.out.println("Data o " + later + " dni później niż  " + this.data.toString() + " to " + this.data.plusDays(later).toString());
    }

    public void setDateEarlierByDays(int earlier) {
        System.out.println("Data o " + earlier + " dni wcześniej niż  " + this.data.toString() + " to " + this.data.minusDays(earlier).toString());
    }

    public int getDayOfYear() {
        int daysOfYear = this.data.getDayOfYear();
        System.out.println(this.data.toString() + " to " + daysOfYear + " dzień roku");
        return daysOfYear;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dzień=" + day +
                ", miesiąc=" + month +
                ", rok=" + year +
                '}';
    }
}
