package dev.michaelkimball.toolnextdoor;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    String test(){
        return "hi";
    }
}
