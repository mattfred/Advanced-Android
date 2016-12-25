package com.mattfred.advancedandroid;

import android.app.Application;

import com.mattfred.advancedandroid.dagger.DaggerNetComponent;
import com.mattfred.advancedandroid.dagger.NetComponent;
import com.mattfred.advancedandroid.dagger.NetModule;

import timber.log.Timber;

/**
 * Application Class
 */

public class AndroidApplication extends Application {

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule())
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
