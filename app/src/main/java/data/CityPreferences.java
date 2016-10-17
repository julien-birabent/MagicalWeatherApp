package data;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Julien on 16/10/2016.
 */

public class CityPreferences{

    SharedPreferences prefs;
    private final String DEFAULT_CITY = "Montreal,CA";

    public CityPreferences(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }
    public String getCity(){
        return prefs.getString("city", DEFAULT_CITY);
    }

    public void setCity(String city){
        prefs.edit().putString("city",city).commit();

    }
}
