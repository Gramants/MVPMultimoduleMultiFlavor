package net.stefano.fruitveg.di.module

import com.stefano.search.fruitsearch.ActivityScope
import com.stefano.search.fruitsearch.FruitVegActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector



import com.stefano.search.fruitsearch.FruitVegModule2

@Module
abstract class NiceFeatureModule {


    @ActivityScope
    @ContributesAndroidInjector(modules = [(FruitVegModule2::class)])
    abstract fun bindFruitVegActivity (): FruitVegActivity



}