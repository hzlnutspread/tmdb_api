public record Data(int page, Movie[] results, int total_pages, int total_results) {
    public Movie[] getMovies() {
        return results;
    }
    public int getTotal_pages() {
        return total_pages;
    }
}



