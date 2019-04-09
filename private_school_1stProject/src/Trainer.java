import java.util.Scanner;

public class Trainer extends Validation{

    private Scanner scanner = new Scanner(System.in);

    private String fName;
    private String lName;
    private String subject;
    private static int numOfTrainers;

    //CONSTRUCTOR CREATION, USED WHEN THE USER CREATES THE OBJECT MANUALLY.

    public Trainer() {
        System.out.println("Please set the first name of the trainer.");
        fName = stringValidation(scanner);

        System.out.println("Please set the last name of the trainer.");
        lName = stringValidation(scanner);

        System.out.println("Please set the name of the subject that the trainer instructs.");
        subject = stringValidation(scanner);

        numOfTrainers++;

        System.out.println("Trainer object number "+numOfTrainers+" was created.");
        System.out.println("Trainer's name: "+getfName()+" "+getlName()+"\nInstructed subject: "+getSubject());

    }

    //CONSTRUCTOR CREATION, USED FOR THE CREATION OF THE SYNTHETIC DATA OBJECTS.

    public Trainer(String fName, String lName, String subject) {
        this.fName = fName;
        this.lName = lName;
        this.subject = subject;
        numOfTrainers++;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getSubject() {
        return subject;
    }

    public static int getNumOfTrainers() {
        return numOfTrainers;
    }

    @Override
    public String toString() {
        return fName+" "+lName;
    }
}
