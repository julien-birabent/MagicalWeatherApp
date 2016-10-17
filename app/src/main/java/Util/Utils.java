package Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Julien on 16/10/2016.
 */

public class Utils {

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String ICON_URL = "http://openweathermap.org/img/w/";
    public static final String APP_ID = "&appid=1f161aac6db187e6c5137c73268f1d79";

    public static JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException {
        JSONObject jObj = jsonObject.getJSONObject(tagName);
        return jObj;
    }


    public static String getString(String tagName, JSONObject jsonObject) throws JSONException{
        return(String) jsonObject.getString(tagName);

    }

    public static float getFloat(String tagName, JSONObject jsonObject) throws JSONException{
        return (float) jsonObject.getDouble(tagName);


    }

    public static double getDouble(String tagName, JSONObject jsonObject) throws JSONException{
        return (double)jsonObject.getDouble(tagName);
    }

    public static int getInt(String tagName, JSONObject jsonObject) throws JSONException{

        return (int) jsonObject.getInt(tagName);
    }
}
