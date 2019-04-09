import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Assignment extends Validation {

    private Scanner scanner = new Scanner(System.in);

    private String title;
    private String description;
    private String oralMark;
    private String totalMark;
    private Date submissionDate;
    private static int numOfAssignments;

    //CONSTRUCTOR CREATION, USED WHEN THE USER CREATES THE OBJECT MANUALLY.

    public Assignment() {
        System.out.println("Please set the title of the assignment.");
        title = stringValidation(scanner);

        System.out.println("Please write a description of the assignment.");
        description = stringValidation(scanner);

        oralMark = "For the "+getTitle()+" assignment your oral mark will be the 20% of your total mark.";
        totalMark = "For the "+getTitle()+" assignment your total mark will be an aggregate " +
               "of your oral and writing performance.";

        Calendar calendar = Calendar.getInstance();
        System.out.println("Set the due date and time of the assignment.");
        System.out.println("Set the year. Acceptable range: 2019-2020");
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
        submissionDate = calendar.getTime();

        numOfAssignments++;

        System.out.println("Assignment object number "+numOfAssignments+" was created.");
        System.out.println("Assignment's title: "+getTitle()+"\nAssignment's description: "+getDescription());
        System.out.println("Assignment's due date: "+submissionDate);

    }

    //CONSTRUCTOR CREATION, USED FOR THE CREATION OF THE SYNTHETIC DATA OBJECTS.

    public Assignment(String title, String description, String oralMark, String totalMark, Date submissionDate) {
        this.title = title;
        this.description = description;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
        this.submissionDate = submissionDate;
        numOfAssignments++;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getOralMark() {
        return oralMark;
    }

    public String getTotalMark() {
        return totalMark;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public static int getNumOfAssignments() {
        return numOfAssignments;
    }

    @Override
    public String toString() {
        return title;

    }
}













