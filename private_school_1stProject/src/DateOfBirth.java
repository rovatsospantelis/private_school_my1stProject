import java.util.Scanner;


public class DateOfBirth extends Validation {

    private Scanner scanner = new Scanner(System.in);

    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public DateOfBirth() {
        System.out.println("Set a value for the day.");
        day = dateAndTimeValidation(0, 31);

        System.out.println("Set a value for the month.");
        month = dateAndTimeValidation(0, 12);

        System.out.println("Set a value for the year. Acceptable range: 1980 - 2010.");
        year = dateAndTimeValidation(1979, 2010);

    }
    public DateOfBirth(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

}
