
import java.util.*;

public class Main extends Validation {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Trainer> trainers = new ArrayList<>();
    private static ArrayList<Assignment> assignments = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<StudentsPerCourse> sPc = new ArrayList<>();
    private static ArrayList<TrainersPerCourse> tPc = new ArrayList<>();
    private static ArrayList<AssignmentsPerCourse> aPc = new ArrayList<>();
    private static ArrayList<AssignmentsPerStudent> aPs = new ArrayList<>();

    public static void main(String[] args) {

        //WHEN THE PROGRAM STARTS THE USER IS ASKED IF HE WANT TO CREATE THE ENTITIES OF THE PRIVATE SCHOOL MANUALLY, OR IF HE WANTS TO USE THE SYNTHETIC DATA

        System.out.println("Welcome to the menu, User!\nIf you want to manually set up your private school press -1-\n" +
                "Otherwise press -2- for synthetic data.");
        int initialChoice = intValidation(scanner);
        scanner.nextLine();                              //VALIDATION METHODS ARE IMPLEMENTED INSIDE THE VALIDATION CLASS
        boolean test = true;
        while (test) {
            switch (initialChoice) {
                case 1:
                    manualInputs();                     //THIS METHOD IS IMPLEMENTED AT THIS PAGE, SOME LINES BELOW
                    test = false;
                    break;
                case 2:
                    System.out.println("Welcome to HOGWARTS, the school of witchcraft and wizardry!!!\nYour" +
                            " objects have already been created. Feel free to browse.");
                    autoStudents();
                    autoTrainers();      //THESE METHODS ARE EXECUTED TO CREATE THE SYNTHETIC DATA FOR THE STUDENTS,TRAINERS,ASSIGNMENTS AND COURSES
                    autoAssignments();
                    autoCourses();
                    test = false;
                    break;
                default:
                    System.out.println("Invalid entry, please select between 1 and 2.");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
            }
        }

        if (initialChoice == 1) {
            System.out.println("Next step is to make the assignments of the objects you have created.\nJust follow " +
                    "the instructions and everything will be set automatically.");
            returnStudentsPerCourse();
            returnTrainersPerCourse();
            returnAssignmentsPerCourse();
            returnAssignmentsPerStudent();
        }

        if (initialChoice == 2) {
            System.out.println("Your assignments will be automatically executed...");
            autoAssignTheStudentsPerCourse();
            autoAssignTheTrainersPerCourse();
            autoAssignTheAssignmentsPerCourse();
            autoAssignTheAssignmentsPerStudent();
        }

        //AT THIS POINT THE USER CAN BROWSE, THE PRIVATE SCHOOL IS SET

        listsMenu();
        initialChoice = intValidation(scanner);
        scanner.nextLine();
        test = true;
        while (test) {
            switch (initialChoice) {
                case 1:
                    System.out.println("STUDENTS");
                    System.out.println("---------------");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(students.get(i).getfName()+" "+students.get(i).getlName());
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Waiting for your next selection");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("TRAINERS");
                    System.out.println("---------------");
                    for (int i = 0; i < trainers.size(); i++) {
                        System.out.println(trainers.get(i).getfName()+" "+trainers.get(i).getlName());
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Waiting for your next selection");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("ASSIGNMENTS");
                    System.out.println("---------------");
                    for (int i = 0; i < assignments.size(); i++) {
                        System.out.println(assignments.get(i).getTitle());
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Waiting for your next selection");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("COURSES");
                    System.out.println("---------------");
                    for (int i = 0; i < courses.size(); i++) {
                        System.out.println(courses.get(i).getTitle());
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Waiting for your next selection");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("STUDENTS PER COURSE");
                    System.out.println("---------------");
                    for (int j = 0; j < Course.getNumOfCourses(); j++) {
                        System.out.println(sPc.get(j).getName());
                        System.out.println("*****************");
                        for (int i = 0; i < sPc.get(j).getAllTheStudentsOfTheCourse().size(); i++) {
                            System.out.println(sPc.get(j).getAllTheStudentsOfTheCourse().get(i).getfName() +
                                    " " + sPc.get(j).getAllTheStudentsOfTheCourse().get(i).getlName());
                        }
                        System.out.println("=================");
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Waiting for your next selection");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("TRAINERS PER COURSE");
                    System.out.println("---------------");
                    for (int j = 0; j < Course.getNumOfCourses(); j++) {
                        System.out.println(tPc.get(j).getName());
                        System.out.println("*****************");
                        for (int i = 0; i < tPc.get(j).getAllTheTrainersPerCourse().size(); i++) {
                            System.out.println(tPc.get(j).getAllTheTrainersPerCourse().get(i).getfName() +
                                    " " + tPc.get(j).getAllTheTrainersPerCourse().get(i).getlName());
                        }
                        System.out.println("=================");
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Waiting for your next selection");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.println("ASSIGNMENTS PER COURSE");
                    System.out.println("---------------");
                    for (int j = 0; j < Course.getNumOfCourses(); j++) {
                        System.out.println(aPc.get(j).getName());
                        System.out.println("*****************");
                        for (int i = 0; i < aPc.get(j).getAllTheAssignmentsPerCourse().size(); i++) {
                            System.out.println(aPc.get(j).getAllTheAssignmentsPerCourse().get(i).getTitle());
                        }
                        System.out.println("=================");
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Waiting for your next selection");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 8:
                    System.out.println("ASSIGNMENTS PER STUDENT");
                    System.out.println("---------------");
                    for (int j = 0; j < Student.getNumOfStudents(); j++) {
                        System.out.println(aPs.get(j).getName());
                        System.out.println("*****************");
                        for (int i = 0; i < aPs.get(j).getAllTheAssignmentsPerStudent().size(); i++) {
                            System.out.println(aPs.get(j).getAllTheAssignmentsPerStudent().get(i).getTitle());
                        }
                        System.out.println("=================");
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Waiting for your next selection");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 9:
                    System.out.println("STUDENTS THAT ATTEND MORE THAN ONE COURSES");
                    System.out.println("---------------");
                    moreThanOneCourse();
                    System.out.println();
                    System.out.println();
                    System.out.println("Waiting for your next selection");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 10:
                    checkDeliveryDates();
                    System.out.println();
                    System.out.println();
                    System.out.println("Waiting for your next selection");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 0:
                    System.out.println("You left the menu.");
                    System.out.println("=================");
                    test = false;
                    break;
                default:
                    System.out.println("Invalid entry. Please enter a number between 0-9.");
                    initialChoice = intValidation(scanner);
                    scanner.nextLine();
                    break;
            }
        }
    }

    //TΗE METHOD FOR THE INTRO MENU
    private static void autoMenu() {
        System.out.println("Through this menu you can select and create objects to build your school");
        System.out.println("Select -1- to create a new student \nSelect -2- to create a new trainer\nSelect -3- to " +
                "create a new assignment\nSelect -4- to create a new course\nSelect -5- to exit the menu");
        System.out.println();
    }
    //SECOND MENU
    private static void listsMenu() {
        System.out.println("Through this menu you can print the lists of the created objects and " +
                "get valuable information about your school.");
        System.out.println("Select -1- to print a list of all the students.\nSelect -2- to print a list of all" +
                "the trainers.\nSelect -3- to print a list of all the assignments.\nSelect -4- to print " +
                "a list of all the courses.\nSelect -5- to print all the students per course.\nSelect -6- " +
                "to print all the trainers per course.\nSelect -7- to print all the assignments per course." +
                "\nSelect -8- to print all the assignments per student.\nSelect -9- to print a list of students that" +
                " belong to more than one courses.\nSelect -10- to check the delivery dates of the " +
                "assignments.\nSelect -0- if you want to exit the menu.");
        System.out.println("=================");
        System.out.println();
    }

    //SYNTHETIC DATA
    private static void autoStudents() {
        DateOfBirth dateOfBirth1 = new DateOfBirth(20, 4, 2010);
        Student student1 = new Student("Harry", "Potter", dateOfBirth1, 3000);
        students.add(student1);
        DateOfBirth dateOfBirth2 = new DateOfBirth(31, 11, 2009);
        Student student2 = new Student("Hermione", "Granger", dateOfBirth2, 0);
        students.add(student2);
        DateOfBirth dateOfBirth3 = new DateOfBirth(8, 3, 2009);
        Student student3 = new Student("Ron", "Weasly", dateOfBirth3, 3000);
        students.add(student3);
        DateOfBirth dateOfBirth4 = new DateOfBirth(29, 4, 2010);
        Student student4 = new Student("Luna", "Lovegood", dateOfBirth4, 3000);
        students.add(student4);
        DateOfBirth dateOfBirth5 = new DateOfBirth(7, 7, 1980);
        Student student5 = new Student("Tom", "Riddle", dateOfBirth5, 0);
        students.add(student5);
    }

    //SYNTHETIC DATA
    private static void autoTrainers() {
        Trainer trainer1 = new Trainer("Albus", "Dumbledore", "Defense against the dark arts");
        trainers.add(trainer1);
        Trainer trainer2 = new Trainer("Severus", "Snape", "Potions");
        trainers.add(trainer2);
        Trainer trainer3 = new Trainer("Minerva", "McGonagall", "Tranfiguration");
        trainers.add(trainer3);
    }

    //SYNTHETIC DATA
    private static void autoAssignments() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 5, 5, 23, 59, 59);
        Assignment assignment1 = new Assignment("Early Assignment", "First assignment of the semester", "20% of the " +
                "total Mark", "Oral and writing performance", calendar.getTime());
        assignments.add(assignment1);
        calendar.set(2019, 7, 7, 23, 59, 59);
        Assignment assignment2 = new Assignment("Final assignment", "Dissertation", "%20 of the total Mark", "Oral " +
                "and writing performance", calendar.getTime());
        assignments.add(assignment2);
    }

    //SYNTHETIC DATA
    private static void autoCourses() {
        Date startDate;
        Date endDate;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 2, 25, 9, 0, 0);
        startDate = calendar.getTime();
        calendar.set(2019, 6, 28, 15, 0, 0);
        endDate = calendar.getTime();
        Course course1 = new Course("Defence against the dark arts", "Dark magic", "Defensive", startDate, endDate);
        courses.add(course1);
        Course course2 = new Course("Potions", "Craft", "Miscellaneous", startDate, endDate);
        courses.add(course2);
        Course course3 = new Course("Tranfiguration", "Neutral magic", "Animagus", startDate, endDate);
        courses.add(course3);
    }

    //PRINTS THE STUDENTS PER COURSE
    private static void returnStudentsPerCourse() {
        for (int i = 0; i < Course.getNumOfCourses(); i++) {
            StudentsPerCourse studentsPerCourse = new StudentsPerCourse(courses.get(i).getTitle());
            sPc.add(studentsPerCourse);
            System.out.println("Please assign the students for the course: " + courses.get(i).getTitle());
            System.out.println("You have created " + Student.getNumOfStudents() + " student/students.");
            for (int j = 0; j < Student.getNumOfStudents(); j++) {
                System.out.println("If you want to add " + students.get(j).getfName() + " " + students.get(j).getlName()
                        + " to this course please press -1- , otherwise press any other number.");
                switch (intValidation(scanner)) {
                    case 1:
                        studentsPerCourse.getAllTheStudentsOfTheCourse().add(students.get(j));
                        break;
                    default:
                        break;
                }
            }
        }
    }
    //PRINTS THE TRAINERS PER COURSE
    private static void returnTrainersPerCourse() {
        for (int i = 0; i < Course.getNumOfCourses(); i++) {
            TrainersPerCourse trainersPerCourse = new TrainersPerCourse(courses.get(i).getTitle());
            tPc.add(trainersPerCourse);
            System.out.println("Please assign the trainers for the course: " + courses.get(i).getTitle());
            System.out.println("You have created " + Trainer.getNumOfTrainers() + " trainer/trainers.");
            for (int j = 0; j < Trainer.getNumOfTrainers(); j++) {
                System.out.println("If you want to add " + trainers.get(j).getfName() + " " + trainers.get(j).getlName()
                        + " to this course please press -1- , otherwise press any other number.");
                switch (intValidation(scanner)) {
                    case 1:
                        trainersPerCourse.getAllTheTrainersPerCourse().add(trainers.get(j));
                        break;
                    default:
                        break;
                }
            }
        }
    }
    //PRINTS THE ASSIGNMENTS PER COURSE
    private static void returnAssignmentsPerCourse() {
        for (int i = 0; i < Course.getNumOfCourses(); i++) {
            AssignmentsPerCourse assignmentsPerCourse = new AssignmentsPerCourse(courses.get(i).getTitle());
            aPc.add(assignmentsPerCourse);
            System.out.println("Please set the assignments for the course: " + courses.get(i).getTitle());
            System.out.println("You have created " + Assignment.getNumOfAssignments() + " assignment/assignments.");
            for (int j = 0; j < Assignment.getNumOfAssignments(); j++) {
                System.out.println("If you want to add the " + assignments.get(j).getTitle()
                        + " to this course please press -1- , otherwise press any other number.");
                switch (intValidation(scanner)) {
                    case 1:
                        assignmentsPerCourse.getAllTheAssignmentsPerCourse().add(assignments.get(j));
                        break;
                    default:
                        break;
                }
            }
        }
    }
    //PRINTS THE ASSIGNMENTS PER STUDENT
    private static void returnAssignmentsPerStudent() {
        for (int i = 0; i < Student.getNumOfStudents(); i++) {
            AssignmentsPerStudent assignmentsPerStudent = new AssignmentsPerStudent(students.get(i).getfName()
                    + " " + students.get(i).getlName());
            aPs.add(assignmentsPerStudent);
            System.out.println("Please set the assignments for the student " + students.get(i).getfName()
                    + " " + students.get(i).getlName());
            System.out.println("You have created " + Assignment.getNumOfAssignments() + " assignment/assignments.");
            for (int j = 0; j < Assignment.getNumOfAssignments(); j++) {
                System.out.println("If you want to add the " + assignments.get(j).getTitle()
                        + " to this student please press -1- , otherwise press any other number.");
                switch (intValidation(scanner)) {
                    case 1:
                        assignmentsPerStudent.getAllTheAssignmentsPerStudent().add(assignments.get(j));
                        break;
                    default:
                        break;
                }
            }
        }
    }
    //FINDS THE STUDENTS THAT ATTEND MORE THAN ONE COURSES
    private static void moreThanOneCourse() {
        System.out.println("These are the students that belong to more than one courses.");
        int counter;
        int counter1 = 0;
        for (int i = 0; i < students.size(); i++) {
            counter = 0;
            for (int j = 0; j < sPc.size(); j++) {
                for (int k = 0; k < sPc.get(j).getAllTheStudentsOfTheCourse().size(); k++) {
                    if (students.get(i).getlName().equals(sPc.get(j).getAllTheStudentsOfTheCourse().get(k).getlName())) {
                        counter++;
                        counter1++;
                    }
                }
            }
            if (counter > 1) {
                System.out.println(students.get(i).getfName() + " " + students.get(i).getlName());
            }
        }
        if (counter1 == 0) {
            System.out.println("There is no student that attends more than 1 courses.");
        }
        System.out.println("=================");
    }

    //SYNTHETIC DATA
    private static void autoAssignTheStudentsPerCourse() {
        StudentsPerCourse studentsPerCourse = new StudentsPerCourse("Defence against the dark arts");
        sPc.add(studentsPerCourse);
        studentsPerCourse.getAllTheStudentsOfTheCourse().add(students.get(0));
        studentsPerCourse.getAllTheStudentsOfTheCourse().add(students.get(1));
        studentsPerCourse.getAllTheStudentsOfTheCourse().add(students.get(2));
        studentsPerCourse.getAllTheStudentsOfTheCourse().add(students.get(3));
        StudentsPerCourse studentsPerCourse1 = new StudentsPerCourse("Potions");
        sPc.add(studentsPerCourse1);
        studentsPerCourse1.getAllTheStudentsOfTheCourse().add(students.get(0));
        studentsPerCourse1.getAllTheStudentsOfTheCourse().add(students.get(1));
        studentsPerCourse1.getAllTheStudentsOfTheCourse().add(students.get(3));
        StudentsPerCourse studentsPerCourse2 = new StudentsPerCourse("Tranfiguration");
        sPc.add(studentsPerCourse2);
        studentsPerCourse2.getAllTheStudentsOfTheCourse().add(students.get(0));
        studentsPerCourse2.getAllTheStudentsOfTheCourse().add(students.get(1));
        studentsPerCourse2.getAllTheStudentsOfTheCourse().add(students.get(2));
        studentsPerCourse2.getAllTheStudentsOfTheCourse().add(students.get(4));
    }

    //SYNTHETIC DATA
    private static void autoAssignTheTrainersPerCourse() {
        TrainersPerCourse trainersPerCourse = new TrainersPerCourse("Defence against the dark arts");
        tPc.add(trainersPerCourse);
        trainersPerCourse.getAllTheTrainersPerCourse().add(trainers.get(0));
        trainersPerCourse.getAllTheTrainersPerCourse().add(trainers.get(1));
        TrainersPerCourse trainersPerCourse1 = new TrainersPerCourse("Potions");
        tPc.add(trainersPerCourse1);
        trainersPerCourse1.getAllTheTrainersPerCourse().add(trainers.get(1));
        TrainersPerCourse trainersPerCourse2 = new TrainersPerCourse("Tranfiguration");
        tPc.add(trainersPerCourse2);
        trainersPerCourse2.getAllTheTrainersPerCourse().add(trainers.get(2));
    }

    //SYNTHETIC DATA
    private static void autoAssignTheAssignmentsPerCourse() {
        AssignmentsPerCourse assignmentsPerCourse = new AssignmentsPerCourse("Defence against the dark arts");
        aPc.add(assignmentsPerCourse);
        assignmentsPerCourse.getAllTheAssignmentsPerCourse().add(assignments.get(0));
        assignmentsPerCourse.getAllTheAssignmentsPerCourse().add(assignments.get(1));
        AssignmentsPerCourse assignmentsPerCourse1 = new AssignmentsPerCourse("Potions");
        aPc.add(assignmentsPerCourse1);
        assignmentsPerCourse1.getAllTheAssignmentsPerCourse().add(assignments.get(1));
        AssignmentsPerCourse assignmentsPerCourse2 = new AssignmentsPerCourse("Tranfiguration");
        aPc.add(assignmentsPerCourse2);
        assignmentsPerCourse2.getAllTheAssignmentsPerCourse().add(assignments.get(0));
    }

    //SYNTHETIC DATA
    private static void autoAssignTheAssignmentsPerStudent() {
        AssignmentsPerStudent assignmentsPerStudent = new AssignmentsPerStudent("Potter");
        aPs.add(assignmentsPerStudent);
        assignmentsPerStudent.getAllTheAssignmentsPerStudent().add(assignments.get(0));
        assignmentsPerStudent.getAllTheAssignmentsPerStudent().add(assignments.get(1));
        assignmentsPerStudent.getAllTheAssignmentsPerStudent().add(assignments.get(1));
        assignmentsPerStudent.getAllTheAssignmentsPerStudent().add(assignments.get(0));
        AssignmentsPerStudent assignmentsPerStudent1 = new AssignmentsPerStudent("Granger");
        aPs.add(assignmentsPerStudent1);
        assignmentsPerStudent1.getAllTheAssignmentsPerStudent().add(assignments.get(0));
        assignmentsPerStudent1.getAllTheAssignmentsPerStudent().add(assignments.get(1));
        assignmentsPerStudent1.getAllTheAssignmentsPerStudent().add(assignments.get(1));
        assignmentsPerStudent1.getAllTheAssignmentsPerStudent().add(assignments.get(0));
        AssignmentsPerStudent assignmentsPerStudent2 = new AssignmentsPerStudent("Weasly");
        aPs.add(assignmentsPerStudent2);
        assignmentsPerStudent2.getAllTheAssignmentsPerStudent().add(assignments.get(0));
        assignmentsPerStudent2.getAllTheAssignmentsPerStudent().add(assignments.get(1));
        assignmentsPerStudent2.getAllTheAssignmentsPerStudent().add(assignments.get(0));
        AssignmentsPerStudent assignmentsPerStudent3 = new AssignmentsPerStudent("Lovegood");
        aPs.add(assignmentsPerStudent3);
        assignmentsPerStudent3.getAllTheAssignmentsPerStudent().add(assignments.get(0));
        assignmentsPerStudent3.getAllTheAssignmentsPerStudent().add(assignments.get(1));
        assignmentsPerStudent3.getAllTheAssignmentsPerStudent().add(assignments.get(1));
        AssignmentsPerStudent assignmentsPerStudent4 = new AssignmentsPerStudent("Riddle");
        aPs.add(assignmentsPerStudent4);
        assignmentsPerStudent4.getAllTheAssignmentsPerStudent().add(assignments.get(0));
    }

    //METHOD FOR THE INITIAL CHOICE OF THE USER TO CREATE THE OBJECTS OF THE SCHOOL MANUALLY
    private static void manualInputs() {
        autoMenu();
        System.out.println("Please choose a number between 1-5");
        int choice = intValidation(scanner);
        scanner.nextLine();

        boolean test = true;

        while (test) {
            switch (choice) {
                case 1:
                    Student student = new Student();
                    students.add(student);
                    System.out.println("=================");
                    System.out.println("Waiting for your next selection...");
                    choice = intValidation(scanner);
                    scanner.nextLine();
                    break;

                case 2:
                    Trainer trainer = new Trainer();
                    trainers.add(trainer);
                    System.out.println("=================");
                    System.out.println("Waiting for your next selection...");
                    choice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 3:
                    Assignment assignment = new Assignment();
                    assignments.add(assignment);
                    System.out.println("=================");
                    System.out.println("Waiting for your next selection...");
                    choice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 4:
                    Course course = new Course();
                    courses.add(course);
                    System.out.println("=================");
                    System.out.println("Waiting for your next selection...");
                    choice = intValidation(scanner);
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("You left the menu.");
                    System.out.println("=================");
                    test = false;
                    break;
                default:
                    System.out.println("Invalid entry. Please check the menu");
                    autoMenu();
                    choice = intValidation(scanner);
                    scanner.nextLine();
                    break;
            }
        }
    }
    //CHECKS IF THERE IS ANY ASSIGNMENT DELIVERY DURING THE INPUT DATE FROM THE USER
    private static void checkDeliveryDates() {
        Date date;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 3, 2, 0, 0, 0);
        date = calendar.getTime();

        Date date1;
        calendar.set(2019,2, 28,0,0,0 );
        date1 = calendar.getTime();

        Date date2;
        calendar.set(2019, 3,15,0,0,0);
        date2 = calendar.getTime();

        Date date3;
        calendar.set(2019, 3,4,0,0,0);
        date3 = calendar.getTime();

        Date date4;
        calendar.set(2019, 2,19,0,0,0);
        date4 = calendar.getTime();

        System.out.println("-----!!(This part of the project works only with synthetic data)!!-----");
        System.out.println("All the students have set a date for the delivery of their Early Assignment.\nPlease follow " +
                        "the orders to check if they will deliver during the week of the date you will select.\nFor your " +
                "convenience check the weeks around the due date: April 05 2019.");

        Date userInputDate;
        System.out.println();
        System.out.println("Set the year.");
        int year =  dateAndTimeValidation(2017, 2020);
        System.out.println("Set the month.");
        int month = dateAndTimeValidation(0, 12);
        month = month - 1;
        System.out.println("Set the day.");
        int day = dateAndTimeValidation(0, 31);
        int hours = 0;
        int minutes = 0;
        int second = 0;
        calendar.set(year, month, day, hours, minutes, second);
        userInputDate = calendar.getTime();

        calendar.setTime(userInputDate);
        System.out.println("You chose the date: "+userInputDate);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date start = calendar.getTime();

        for (int i = 0; i < 4; i++) {
            calendar.add(Calendar.DATE, 1);
        }
        Date end = calendar.getTime();

        HashMap<String, Date> hashMap = new HashMap<>();
        hashMap.put("Harry Potter", date);                        
        hashMap.put("Hermione Granger", date1);
        hashMap.put("Ron Weasly", date2);
        hashMap.put("Luna Lovegood", date3);
        hashMap.put("Tom Riddle", date4);

        for (String key: hashMap.keySet()) {
            if (hashMap.get(key).after(start) && hashMap.get(key).before(end)) {
                System.out.println(key+" will deliver their Early Assignment during" +
                        " the week of: "+start+" ---> "+end);
            }
        }
    }
}





