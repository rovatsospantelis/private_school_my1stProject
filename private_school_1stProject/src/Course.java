import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Course extends Validation{

    private static Scanner scanner = new Scanner(System.in);

    private String title;
    private String stream;
    private String type;
    private Date startDate;
    private Date endDate;
    private static int numOfCourses;

    //CONSTRUCTOR CREATION, USED WHEN THE USER CREATES THE OBJECT MANUALLY.



    public Course() {
        System.out.println("Please set the title of the course.");
        title = stringValidation(scanner);

        System.out.println("Please set the stream of the course.");
        stream = stringValidation(scanner);

        System.out.println("Please set the type of the course.");
        type = stringValidation(scanner);


        Calendar calendar = Calendar.getInstance();
        System.out.println("Set the start date and time of the course.");
        System.out.println("Set the year.");
        int year = dateAndTimeValidation(2018, 2020);
        System.out.println("Set the month.");
        int month = dateAndTimeValidation(0, 12);
        month--;
        System.out.println("Set the day.");
        int day = dateAndTimeValidation(0, 31);
        System.out.println("Set the hours (military time).");
        int hours = dateAndTimeValidation(-1, 23);
        System.out.println("Set the minutes.");
        int minutes = dateAndTimeValidation(-1, 59);
        System.out.println("Set the seconds.");
        int second = dateAndTimeValidation(-1, 59);
        calendar.set(year, month, day, hours, minutes, second);
        startDate = calendar.getTime();

        System.out.println("=================");

        System.out.println("Set the end date and time of the course.");
        System.out.println("Set the year.");
        year = dateAndTimeValidation(2018, 2020);
        System.out.println("Set the month.");
        month = dateAndTimeValidation(0, 12);
        month--;
        System.out.println("Set the day.");
        day = dateAndTimeValidation(0, 31);
        System.out.println("Set the hours (military time).");
        hours = dateAndTimeValidation(-1, 23);
        System.out.println("Set the minutes.");
        minutes = dateAndTimeValidation(-1, 59);
        System.out.println("Set the seconds.");
        second = dateAndTimeValidation(-1, 59);
        calendar.set(year, month, day, hours, minutes, second);
        endDate = calendar.getTime();

        numOfCourses++;

        System.out.println("Course object number "+numOfCourses+" was created.");
        System.out.println("Course's title: "+getTitle()+"\nCourse's stream: "+getStream()+"\nCourse's type: "+getType());
        System.out.println("The course starts at "+getStartDate()+" and ends at "+getEndDate());

    }
    //CONSTRUCTOR CREATION, USED FOR THE CREATION OF THE SYNTHETIC DATA OBJECTS.

    public Course(String title, String stream, String type, Date startDate, Date endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        numOfCourses++;
    }

    public String getTitle() {
        return title;
    }

    public String getStream() {
        return stream;
    }

    public String getType() {
        return type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public static int getNumOfCourses() {
        return numOfCourses;
    }

    @Override
    public String toString() {
        return  title;
    }
}
