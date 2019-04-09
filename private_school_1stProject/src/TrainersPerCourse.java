import java.util.ArrayList;

public class TrainersPerCourse {

    private ArrayList<Trainer> allTheTrainersPerCourse;
    private String name;

    public TrainersPerCourse(String name) {
        this.name = name;
        allTheTrainersPerCourse = new ArrayList<Trainer>();
    }

    public ArrayList<Trainer> getAllTheTrainersPerCourse() {
        return allTheTrainersPerCourse;
    }

    public String getName() {
        return name;
    }
}
