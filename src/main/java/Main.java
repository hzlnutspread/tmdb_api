import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int totalPages = Utils.getNumberOfPages();
        ArrayList<Movie> moviesArrayList = getMoviesArray(totalPages);

        moviesArrayList.sort(new MovieComparatorByVoteAverageAndVoteCount());
        for (Movie movie : moviesArrayList) {
            System.out.println(movie);
        }
    }

    static ArrayList<Movie> getMoviesArray(int totalPages) {
        ArrayList<Movie> moviesArray = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            System.out.println("=== Running request for page: " + i + " ===");
            RunFetch runFetch = new RunFetch();
            Data data = runFetch.getData(i);
            Movie[] movies = data.getMovies();
            for (Movie movie : movies) {
                if (movie.original_title().startsWith("The")) {
                    moviesArray.add(movie);
                }
            }
        }
        System.out.println("YAY! Requests were successful :3");
        return moviesArray;
    }
}
