package com.stefano.search.fruitsearch

import com.stefano.base.BasePresenter
import com.stefano.base.BaseView
import net.stefano.fruitveg.model.FruitVeg

interface FruitVegContract {


    interface View : BaseView {
        fun updateFruitVegs(fruitVegs: List<FruitVeg>)
    }

    interface Presenter : BasePresenter<View> {
        fun searchForResults(searchString: String)
    }


}
