package dagger2simple.pfl.com.dagger2simple.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger2simple.pfl.com.dagger2simple.App;

@Singleton
@Component(modules = {
        AppModule.class,
        BuildersModule.class,
        AndroidSupportInjectionModule.class
})
interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }

}