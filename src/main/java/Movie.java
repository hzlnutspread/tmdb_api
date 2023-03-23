public record Movie(String release_date, String original_title, int vote_count, float vote_average) {

    @Override
    public String toString() {
        return "Movie{" +
                "original_title='" + original_title + '\'' +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                ", release_date=" + release_date +
                '}';
    }


}
