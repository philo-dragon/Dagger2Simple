package dagger2simple.pfl.com.dagger2simple.di;

import dagger.Module;
import dagger.Provides;
import dagger2simple.pfl.com.dagger2simple.bean.Persion;

@Module
public class MainModule {

    @Provides
    Persion provideSchedule() {

        return new Persion("xiaoming",20);
    }
}