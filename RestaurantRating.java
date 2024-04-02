import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RestaurantRating {
    String name;
    int rating;

    public RestaurantRating(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
}

public class RestaurantRatingAnalyzer {
    public static void main(String[] args) {
        List<RestaurantRating> ratings = new ArrayList<>();
        ratings.add(new RestaurantRating("Restaurant A", 4));
        ratings.add(new RestaurantRating("Restaurant B", 7));
        ratings.add(new RestaurantRating("Restaurant C", 9));
        ratings.add(new RestaurantRating("Restaurant D", 2));
        ratings.add(new RestaurantRating("Restaurant E", 6));

        // Define rating ranges
        int[] ratingRanges = {1, 5, 6, 10};

        // Initialize counters for each rating range
        Map<String, Integer> rangeCounts = new HashMap<>();
        for (int i = 0; i < ratingRanges.length - 1; i++) {
            rangeCounts.put(ratingRanges[i] + "-" + ratingRanges[i + 1], 0);
        }

        // Initialize accumulators for each rating range
        Map<String, Integer> rangeSums = new HashMap<>();
        for (int i = 0; i < ratingRanges.length - 1; i++) {
            rangeSums.put(ratingRanges[i] + "-" + ratingRanges[i + 1], 0);
        }

        // Count restaurants within specific rating ranges and calculate the sum of ratings for each range
        for (RestaurantRating rating : ratings) {
            int score = rating.rating;
            for (int i = 0; i < ratingRanges.length - 1; i++) {
                if (score >= ratingRanges[i] && score <= ratingRanges[i + 1]) {
                    rangeCounts.put(ratingRanges[i] + "-" + ratingRanges[i + 1], rangeCounts.get(ratingRanges[i] + "-" + ratingRanges[i + 1]) + 1);
                    rangeSums.put(ratingRanges[i] + "-" + ratingRanges[i + 1], rangeSums.get(ratingRanges[i] + "-" + ratingRanges[i + 1]) + score);
                    break;
                }
            }
        }

        // Calculate average rating for each range and display results
        System.out.println("Restaurant Ratings Summary:");
        for (String range : rangeCounts.keySet()) {
            int count = rangeCounts.get(range);
            double sum = rangeSums.get(range);
            double average = count == 0 ? 0 : sum / count;
            System.out.println("Rating Range: " + range + ", Number of restaurants: " + count + ", Average rating: " + average);
        }
    }
}
