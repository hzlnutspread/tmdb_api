import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.gson.Gson;


public class RunFetch {
    public Data getData(Integer pageNumber) {
        try {
            URL url = Utils.buildUrl(pageNumber);

            assert url != null;
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = inputReader.readLine()) != null) {
                response.append(inputLine);
            }
            inputReader.close();

            Gson gson = new Gson();
            return gson.fromJson(response.toString(), Data.class);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
