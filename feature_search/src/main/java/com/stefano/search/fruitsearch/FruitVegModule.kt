package com.stefano.search.fruitsearch

import dagger.Module
import dagger.Provides
import com.stefano.search.fruitsearch.ActivityScope
import com.stefano.search.fruitsearch.FruitVegPresenter
import com.stefano.network.FruitVegApi

@Module
class FruitVegModule {
    @ActivityScope
    @Provides
    fun provideFruitVegPresenter(fruitVegsApi: FruitVegApi) = FruitVegPresenter(fruitVegsApi)

}
