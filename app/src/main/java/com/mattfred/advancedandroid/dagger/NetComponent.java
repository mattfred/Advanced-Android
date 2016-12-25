package com.mattfred.advancedandroid.dagger;

import com.mattfred.advancedandroid.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Net component
 */

@Singleton
@Component(modules = NetModule.class)
public interface NetComponent {
    void inject(MainActivity activity);
}
