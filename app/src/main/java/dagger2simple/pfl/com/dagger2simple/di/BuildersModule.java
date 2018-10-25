package dagger2simple.pfl.com.dagger2simple.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger2simple.pfl.com.dagger2simple.activity.MainActivity;
import dagger2simple.pfl.com.dagger2simple.scope.ActivityScope;

@Module
public abstract class BuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainActivityInjectorFactory();

}