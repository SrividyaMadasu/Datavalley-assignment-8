import java.util.ArrayList;
import java.util.List;

class StudentProject {
    String name;
    int daysToComplete;

    public StudentProject(String name, int daysToComplete) {
        this.name = name;
        this.daysToComplete = daysToComplete;
    }
}

public class ProjectTracker {
    public static void main(String[] args) {
        List<StudentProject> projects = new ArrayList<>();
        projects.add(new StudentProject("Alice", 5));
        projects.add(new StudentProject("Bob", 3));
        projects.add(new StudentProject("Charlie", 8));

        int onTime = 0;
        int late = 0;
        int early = 0;
        int totalDays = 0;

        for (StudentProject project : projects) {
            if (project.daysToComplete == 7) {
                onTime++;
            } else if (project.daysToComplete < 7) {
                early++;
            } else {
                late++;
            }
            totalDays += project.daysToComplete;
        }

        double averageDays = (double) totalDays / projects.size();

        System.out.println("Projects completed on time: " + onTime);
        System.out.println("Projects completed early: " + early);
        System.out.println("Projects completed late: " + late);
        System.out.println("Average time to complete projects: " + averageDays + " days");
    }
}
