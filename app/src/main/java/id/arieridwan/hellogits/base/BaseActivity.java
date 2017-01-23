package id.arieridwan.hellogits.base;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import id.arieridwan.hellogits.R;
import id.gits.mvvmcore.activity.GitsActivity;
import id.gits.mvvmcore.viewmodel.GitsVM;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by ASUS on 06/10/2016.
 */

public abstract class BaseActivity <VM extends GitsVM, B extends ViewDataBinding> extends GitsActivity<VM, B> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/lato_light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.finishSubscriber();
    }
}
