package net.stefano.fruitveg.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.stefano.search.fruitsearch.ActivityScope
import com.stefano.search.fruitsearch.FruitVegActivity
import com.stefano.search.fruitsearch.FruitVegModule

@Module
abstract class ActivitiesModule {


    @ActivityScope
    @ContributesAndroidInjector(modules = [(FruitVegModule::class)])
    abstract fun bindFruitVegActivity (): FruitVegActivity





}