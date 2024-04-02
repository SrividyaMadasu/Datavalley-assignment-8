import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Movie {
    String title;
    String rating;
    double ratingValue;

    public Movie(String title, String rating, double ratingValue) {
        this.title = title;
        this.rating = rating;
        this.ratingValue = ratingValue;
    }
}

public class MovieRatings {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie 1", "PG-13", 7.5));
        movies.add(new Movie("Movie 2", "PG", 6.8));
        movies.add(new Movie("Movie 3", "R", 8.2));
        movies.add(new Movie("Movie 4", "PG-13", 7.0));
        movies.add(new Movie("Movie 5", "R", 8.5));

        Map<String, Integer> categoryCounts = new HashMap<>();
        Map<String, Double> categoryRatings = new HashMap<>();

        for (Movie movie : movies) {
            String category = movie.rating;
            double rating = movie.ratingValue;

            categoryCounts.put(category, categoryCounts.getOrDefault(category, 0) + 1);
            categoryRatings.put(category, categoryRatings.getOrDefault(category, 0.0) + rating);
        }

        System.out.println("Movie Ratings Summary:");
        for (String category : categoryCounts.keySet()) {
            int count = categoryCounts.get(category);
            double totalRating = categoryRatings.get(category);
            double averageRating = totalRating / count;
            System.out.println("Category: " + category + ", Number of movies: " + count + ", Average rating: " + averageRating);
        }
    }
}
