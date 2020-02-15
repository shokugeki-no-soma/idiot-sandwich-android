package dev.michaelkimball.toolnextdoor.home;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
    @Provides
    FeedRecyclerAdapter provideAdapter(){
        return new FeedRecyclerAdapter();
    }
}
