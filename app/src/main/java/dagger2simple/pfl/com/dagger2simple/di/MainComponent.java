package dagger2simple.pfl.com.dagger2simple.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger2simple.pfl.com.dagger2simple.activity.MainActivity;
import dagger2simple.pfl.com.dagger2simple.scope.ActivityScope;

@ActivityScope
@Subcomponent(modules = {MainModule.class})
public interface MainComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}

}