package dev.michaelkimball.toolnextdoor;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dev.michaelkimball.toolnextdoor.login.AuthModule;
import dev.michaelkimball.toolnextdoor.login.LoginActivity;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthModule.class}
    )
    abstract LoginActivity contributeLoginActivity();
}
