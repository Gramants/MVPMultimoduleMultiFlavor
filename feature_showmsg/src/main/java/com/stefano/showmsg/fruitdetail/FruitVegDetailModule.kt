package com.stefano.showmsg.fruitdetail

import dagger.Module
import dagger.Provides
import com.stefano.showmsg.fruitdetail.FragmentScope
import com.stefano.showmsg.fruitdetail.FruitVegDetailPresenter


@Module
    class FruitVegDetailModule {
        @FragmentScope
        @Provides
        fun provideFruitVegDetailPresenter() = FruitVegDetailPresenter()

    }
