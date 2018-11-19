package net.stefano.fruitveg.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.stefano.showmsg.fruitdetail.FragmentScope
import com.stefano.showmsg.fruitdetail.FruitVegDetailFragment
import com.stefano.showmsg.fruitdetail.FruitVegDetailModule


@Module
abstract class FragmentsModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [(FruitVegDetailModule::class)])
    abstract fun bindSearchDetailFragment (): FruitVegDetailFragment


}
