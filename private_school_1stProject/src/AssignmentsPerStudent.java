import java.util.ArrayList;


public class AssignmentsPerStudent {

    private String name;
    private ArrayList<Assignment> allTheAssignmentsPerStudent;

    public AssignmentsPerStudent(String name) {
        this.name = name;
        allTheAssignmentsPerStudent = new ArrayList<>();
    }

    public ArrayList<Assignment> getAllTheAssignmentsPerStudent() {
        return allTheAssignmentsPerStudent;
    }

    public String getName() {
        return name;
    }
}
