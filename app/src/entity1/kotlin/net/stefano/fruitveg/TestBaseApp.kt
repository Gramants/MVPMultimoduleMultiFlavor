package net.stefano.fruitveg

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import net.stefano.fruitveg.di.component.DaggerTestApplicationComponent

import javax.inject.Inject

// https://medium.com/@serapbercin001/how-to-use-android-injector-for-activity-and-fragment-objects-through-new-dagger-2-with-kotlin-704eb8a98c43

class TestBaseApp : BaseApp(), HasActivityInjector {


    override fun onCreate() {
        super.onCreate()
        DaggerTestApplicationComponent.builder().application(this).build().inject(this)
    }

}


