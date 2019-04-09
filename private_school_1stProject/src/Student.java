
import java.util.Scanner;

public class Student extends Validation {

    private Scanner scanner = new Scanner(System.in);

    private String fName;
    private String lName;
    private DateOfBirth dOfBirth;
    private double tuitionFees;
    private static int numOfStudents;

    //CONSTRUCTOR CREATION, USED WHEN THE USER CREATES THE OBJECT MANUALLY.

    public Student() {
        System.out.println("Please set the first name of the student.");
        fName = stringValidation(scanner);

        System.out.println("Please set the last name of the student.");
        lName = stringValidation(scanner);

        System.out.println("Please set the date of birth of the student.");
        dOfBirth = new DateOfBirth();

        System.out.println("Please set the tuition fee.");
        tuitionFees = doubleValidation(scanner);


        numOfStudents++;

        System.out.println("Student object number "+numOfStudents+" was created.");
        System.out.println("Student's name: "+fName+" "+lName+"\nStudent's date of birth: "+dOfBirth.getDay()+"/"
        +dOfBirth.getMonth()+"/"+dOfBirth.getYear());

    }
    //CONSTRUCTOR CREATION, USED FOR THE CREATION OF THE SYNTHETIC DATA OBJECTS.

    public Student(String fName, String lName, DateOfBirth dOfBirth, double tuitionFees) {
        this.fName = fName;
        this.lName = lName;
        this.dOfBirth = dOfBirth;
        this.tuitionFees = tuitionFees;
        numOfStudents++;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public DateOfBirth getdOfBirth() {
        return dOfBirth;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public static int getNumOfStudents() {
        return numOfStudents;
    }

    @Override
    public String toString() {
        return fName+" "+lName;
    }
}
