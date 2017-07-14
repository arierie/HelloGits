package id.arieridwan.hellogits.dagger;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import id.arieridwan.ApiClient;
import id.arieridwan.hellogits.mvvm.main.MainActivityImpl;
import id.arieridwan.hellogits.mvvm.main.MainActivityRequest;

/**
 * Created by arieridwan on 23/01/2017.
 */
@Module
public class NetModule {

    @Singleton
    @Provides
    ApiClient provideApiClient(){
        return new ApiClient();
    }

    @Singleton
    @Provides
    MainActivityRequest provideMainReq(ApiClient apiClient){
        return new MainActivityImpl(apiClient);
    }

}
