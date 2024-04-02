import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookReview {
    String title;
    int rating;

    public BookReview(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }
}

public class BookReviewAnalyzer {
    public static void main(String[] args) {
        List<BookReview> reviews = new ArrayList<>();
        reviews.add(new BookReview("Book 1", 4));
        reviews.add(new BookReview("Book 2", 7));
        reviews.add(new BookReview("Book 3", 9));
        reviews.add(new BookReview("Book 4", 2));
        reviews.add(new BookReview("Book 5", 6));

        // Count of books within specified rating ranges
        int[] ratingRanges = {1, 5, 6, 10};
        Map<String, Integer> ratingRangeCounts = new HashMap<>();
        for (int i = 0; i < ratingRanges.length - 1; i++) {
            ratingRangeCounts.put(ratingRanges[i] + "-" + ratingRanges[i + 1] + " stars", 0);
        }

        // Count of books with positive, neutral, and negative reviews
        int positiveCount = 0;
        int neutralCount = 0;
        int negativeCount = 0;

        for (BookReview review : reviews) {
            // Count books within specified rating ranges
            for (int i = 0; i < ratingRanges.length - 1; i++) {
                if (review.rating >= ratingRanges[i] && review.rating <= ratingRanges[i + 1]) {
                    ratingRangeCounts.put(ratingRanges[i] + "-" + ratingRanges[i + 1] + " stars",
                            ratingRangeCounts.getOrDefault(ratingRanges[i] + "-" + ratingRanges[i + 1] + " stars", 0) + 1);
                    break;
                }
            }

            // Count positive, neutral, and negative reviews
            if (review.rating >= 8) {
                positiveCount++;
            } else if (review.rating >= 4 && review.rating <= 7) {
                neutralCount++;
            } else {
                negativeCount++;
            }
        }

        System.out.println("Books Reviewed Summary:");
        for (String range : ratingRangeCounts.keySet()) {
            System.out.println("Rating Range: " + range + ", Number of books: " + ratingRangeCounts.get(range));
        }
        System.out.println("Positive reviews: " + positiveCount);
        System.out.println("Neutral reviews: " + neutralCount);
        System.out.println("Negative reviews: " + negativeCount);
    }
}
