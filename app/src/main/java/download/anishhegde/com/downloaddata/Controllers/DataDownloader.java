package download.anishhegde.com.downloaddata.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by anishhegde on 03/05/16.
 */
public class DataDownloader {

    public DataDownloader(){

    }

    public String downloadData(String url) {
        HttpURLConnection connection = null;
        String inStreamString = "";
        try {
            URL apiUrl = new URL(url);
             connection = (HttpURLConnection) apiUrl.openConnection();
            inStreamString = getStringFromStream(connection.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
            return inStreamString ;
    }

    String getStringFromStream(InputStream in){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String nextLine = "";
            while ((nextLine = reader.readLine()) != null) {
                sb.append(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
