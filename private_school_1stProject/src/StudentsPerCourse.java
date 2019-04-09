import java.util.ArrayList;



public class StudentsPerCourse {

    private ArrayList<Student> allTheStudentsOfTheCourse;
    private String name;

    public StudentsPerCourse(String name){
        this.allTheStudentsOfTheCourse = new ArrayList<>();
        this.name = name;
    }

    public ArrayList<Student> getAllTheStudentsOfTheCourse() {
        return allTheStudentsOfTheCourse;
    }

    public String getName() {
        return name;
    }


}
