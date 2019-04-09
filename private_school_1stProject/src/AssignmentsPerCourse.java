import java.util.ArrayList;


public class AssignmentsPerCourse {

    private ArrayList<Assignment> allTheAssignmentsPerCourse;
    private String name;

    public AssignmentsPerCourse(String name) {
        allTheAssignmentsPerCourse = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Assignment> getAllTheAssignmentsPerCourse() {
        return allTheAssignmentsPerCourse;
    }
}
