package com.stefano.network

import android.util.Log
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
class TestApiModule {

    @Provides fun provideOkhttp(interceptor: HttpLoggingInterceptor): OkHttpClient {

        return OkHttpClient.Builder()
                .addInterceptor(interceptor).build()
    }

    @Provides fun provideInterceptor() :HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor{
            msg -> Log.d("okhttp",msg)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }


    @Provides
    @Singleton
    fun provideFruitVegApi(retrofit: Retrofit): FruitVegApi {
        return retrofit.create(FruitVegApi::class.java)
    }


    @Provides
    @Singleton
    fun provideTestRetrofitInterface(okHttpClient: OkHttpClient): Retrofit{

        return Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }


}