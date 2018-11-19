package com.stefano.search.fruitsearch

import dagger.Module
import dagger.Provides
import com.stefano.network.FruitVegApi

@Module
class FruitVegModule2 {
    @ActivityScope
    @Provides
    fun provideFruitVegPresenter(fruitVegsApi: FruitVegApi) = FruitVegPresenter(fruitVegsApi)

}
