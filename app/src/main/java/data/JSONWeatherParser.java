package data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Util.Utils;
import model.Place;
import model.Weather;

/**
 * Created by Julien on 16/10/2016.
 */

public class JSONWeatherParser {

    public static Weather getWeather(String data){

        Weather weather = new Weather();

        // création d'un objet JSON depuis les données.
        try {
            JSONObject jsonObject = new JSONObject(data);
            Place place = new Place();

            // on récupère l'objet "coord"
            JSONObject coordObj = Utils.getObject("coord", jsonObject);
            // On récupère la lattitude et la longitude du lieu.
            place.setLat(Utils.getFloat("lat", coordObj));
            place.setLon(Utils.getFloat("lon",coordObj));

            // on récupère l'objet "sys"
            JSONObject sysObj = Utils.getObject("sys", jsonObject);
            place.setCountry(Utils.getString("country", sysObj));
            place.setLastUpdate(Utils.getInt("dt",jsonObject));
            place.setSunrise(Utils.getInt("sunrise", sysObj));
            place.setSunset(Utils.getInt("sunset",sysObj));
            place.setCity(Utils.getString("name",jsonObject));

            // On définit les informations météo de notre lieu
            weather.place = place;

            // L'objet JSON weather est un tableau qui contient un seul objet.
            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            // On récupère l'objet JSON contenu dans ce tableau pour en extraire les champs.
            JSONObject jsonWeather = jsonArray.getJSONObject(0);
            weather.currentCondition.setWeatherId(Utils.getInt("id",jsonWeather));
            weather.currentCondition.setDescription(Utils.getString("description",jsonWeather));
            weather.currentCondition.setCondition(Utils.getString("main",jsonWeather));
            weather.currentCondition.setIcon(Utils.getString("icon",jsonWeather));

            JSONObject mainObj = Utils.getObject("main", jsonObject);
            weather.currentCondition.setHumidity(Utils.getInt("humidity",mainObj));
            weather.currentCondition.setPressure(Utils.getInt("pressure", mainObj));
            weather.currentCondition.setMinTemp(Utils.getFloat("temp_min",mainObj));
            weather.currentCondition.setMaxTemp(Utils.getFloat("temp_max",mainObj));
            weather.currentCondition.setTemperature(Utils.getDouble("temp",mainObj));


            JSONObject windObj = Utils.getObject("wind",jsonObject);
            weather.wind.setSpeed(Utils.getFloat("speed",windObj));
            weather.wind.setDeg(Utils.getFloat("deg",windObj));

            JSONObject cloudsObj = Utils.getObject("clouds",jsonObject);
            weather.clouds.setPrecipitation(Utils.getInt("all",cloudsObj));

            return weather;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return weather;
    }
}
