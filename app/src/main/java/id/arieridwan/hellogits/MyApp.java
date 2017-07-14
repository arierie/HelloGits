package id.arieridwan.hellogits;

import android.app.Application;
import com.google.gson.Gson;
import id.arieridwan.hellogits.dagger.Injector;

/**
 * Created by arieridwan on 24/01/2017.
 */

public class MyApp extends Application {

    static Gson sGson = new Gson();

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.initialize(this);
    }

    public static Gson getGson() {
        return sGson;
    }
}
