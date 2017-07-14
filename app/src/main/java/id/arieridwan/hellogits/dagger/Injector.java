package id.arieridwan.hellogits.dagger;

import android.app.Application;

/**
 * Created by arieridwan on 23/01/2017.
 */

public class Injector {

    public static DiComponent component;

    public static DiComponent initialize(Application application) {
        component = DaggerDiComponent.builder()
                .appModule(new AppModule(application))
                .netModule(new NetModule())
                .build();
        return component;
    }
}
