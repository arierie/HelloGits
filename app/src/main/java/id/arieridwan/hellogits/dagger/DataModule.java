package id.arieridwan.hellogits.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by arieridwan on 23/01/2017.
 */
@Module
public class DataModule {

    @Singleton
    @Provides
    SharedPreferences providePref(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
