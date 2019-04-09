import java.util.Scanner;

//ΔΗΜΙΟΥΡΓΙΑ ΚΛΑΣΗΣ ΓΙΑ ΤΗΝ ΕΠΙΚΥΡΩΣΗ ΤΩΝ ΔΕΔΟΜΕΝΩΝ ΠΟΥ ΘΑ ΕΙΣΑΓΕΙ Ο ΧΡΗΣΤΗΣ ΑΠΟ ΤΟ ΠΛΗΚΤΡΟΛΟΓΙΟ.

public class Validation {

    private static Scanner scanner = new Scanner(System.in);

    public String stringValidation(Scanner scanner) {                   //CHECKS IF THE INPUT IS A STRING
        String string = null;
        boolean test = true;
        while (test) {
            if (scanner.hasNextInt()) {
                System.out.println("Invalid entry, try again");
                scanner.nextLine();
            } else {
                string = scanner.nextLine();
                test = false;
            }
        }return string;
    }

    public double doubleValidation(Scanner scanner) {                 //CHECKS IF HE INPUT IS A DOUBLE
        double anyDouble = 0;
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid entry, try again");
            scanner.next();
        }
        anyDouble = scanner.nextDouble();
        return anyDouble;
    }

    public static int dateAndTimeValidation(int min, int max) {     //CHECKS IF THE INPUT IS AN INTEGER
        int variable = 0;                                           //AND IF IT BELONGS TO A CERTAIN RANGE
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid entry, try again");
                scanner.next();
            }
            variable = scanner.nextInt();
        } while ( variable<= min || variable > max);
        return variable;
    }

    public static int intValidation(Scanner scanner) {             //CHECKS IF THE INPUT IS AN INTEGER
        int anyInt = 0;
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid entry, try again");
            scanner.next();
        }
        anyInt = scanner.nextInt();
        return anyInt;
    }
}
