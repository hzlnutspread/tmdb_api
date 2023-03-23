import java.util.Comparator;

public class MovieComparatorByVoteAverageAndVoteCount implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {
        if (movie1.vote_average() > movie2.vote_average()) {
            return -1;
        } else if (movie1.vote_average() < movie2.vote_average()) {
            return 1;
        } else {
            if (movie1.vote_count() > movie2.vote_count()) {
                return -1;
            } else if (movie1.vote_count() < movie2.vote_count()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
