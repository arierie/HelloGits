package id.arieridwan.hellogits.dagger;

import javax.inject.Singleton;

import dagger.Component;
import id.arieridwan.hellogits.mvvm.main.MainActivityRequest;
import id.arieridwan.hellogits.mvvm.main.MainActivityVM;

/**
 * Created by arieridwan on 23/01/2017.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        DataModule.class,
        NetModule.class})
public interface DiComponent {
    void inject(MainActivityVM mainActivityVM);
}
