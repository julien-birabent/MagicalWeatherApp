package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Util.Utils;

/**
 * Created by Julien on 16/10/2016.
 */



public class WeatherHttpClient {


    /**
     * Méthode créant la connection avec l'URL de notre api météo et récupérant les informations
     * sous forme de String en sortie
     * @param place : le lieu où l'on désir connaître la météo.
     * @return les données météo
     */
    public String getWeatherData(String place){
        HttpURLConnection connection;
        InputStream inputStream;
        StringBuffer stringBuffer = new StringBuffer();

        try {
            connection = (HttpURLConnection) (new URL(Utils.BASE_URL + place + Utils.APP_ID)).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoInput(true);
            connection.connect();

            //Read the response

            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\r\n");
            }

            inputStream.close();
            connection.disconnect();


            return stringBuffer.toString();


        } catch (IOException e) {

            e.printStackTrace();
        }
        return stringBuffer.toString();

    }
}
