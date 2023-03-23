import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

public class Utils {

    public static String getApiKey() {
        try (InputStream input = new FileInputStream("src/main/java/api.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("API_KEY");
        } catch (IOException e) {
            return "Error: " + Arrays.toString(e.getStackTrace());
        }
    }

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String SUB_URL = "search/movie";
    private static final String API_KEY = getApiKey();
    private static final String LANGUAGE = "en-US";
    private static final String QUERY = "The";
    private static final String PRIMARY_RELEASE_YEAR = "2023";

    public static URL buildUrl(Integer page) {
        String urlString = BASE_URL + SUB_URL +
                "?api_key=" + API_KEY +
                "&language=" + LANGUAGE +
                "&query=" + QUERY +
                "&page=" + page +
                "&primary_release_year=" + PRIMARY_RELEASE_YEAR;

        try {
            return new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    static int getNumberOfPages() {
        RunFetch runFetch = new RunFetch();
        Data data = runFetch.getData(1);
        return data.getTotal_pages();
    }


}
