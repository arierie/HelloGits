package id.arieridwan.hellogits.dagger;

import android.app.Application;
import android.content.Context;
import com.google.gson.Gson;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by arieridwan on 23/01/2017.
 */
@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Singleton
    @Provides
    Context provideContext(){
        return mApplication;
    }

    @Singleton
    @Provides
    Gson provideGson(){
        return new Gson();
    }

}
