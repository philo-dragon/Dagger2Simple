package dagger2simple.pfl.com.dagger2simple.di;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger2simple.pfl.com.dagger2simple.App;
import okhttp3.OkHttpClient;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(App application) {
        return application;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient
                .Builder()
                .connectTimeout(60, TimeUnit.MILLISECONDS)
                .readTimeout(60, TimeUnit.MILLISECONDS)
                .writeTimeout(60, TimeUnit.MILLISECONDS)
                .build();
    }

}