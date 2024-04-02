import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestScoreAnalyzer {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>();
        scores.add(85);
        scores.add(72);
        scores.add(90);
        scores.add(65);
        scores.add(80);
        scores.add(95);
        scores.add(78);

        
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = sum / scores.size();

        
        Collections.sort(scores);
        int median;
        if (scores.size() % 2 == 0) {
            median = (scores.get(scores.size() / 2 - 1) + scores.get(scores.size() / 2)) / 2;
        } else {
            median = scores.get(scores.size() / 2);
        }

      
        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;

        for (int score : scores) {
            if (score > average) {
                aboveAverageCount++;
            } else if (score == average) {
                atAverageCount++;
            } else {
                belowAverageCount++;
            }
        }

        
        System.out.println("Test Score Analysis:");
        System.out.println("Average score: " + average);
        System.out.println("Median score: " + median);
        System.out.println("Number of students scoring above average: " + aboveAverageCount + ", Median score: " + median);
        System.out.println("Number of students scoring at average: " + atAverageCount + ", Median score: " + median);
        System.out.println("Number of students scoring below average: " + belowAverageCount + ", Median score: " + median);
    }
}
