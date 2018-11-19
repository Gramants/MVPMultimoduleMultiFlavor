package com.stefano.search.fruitsearch

import com.stefano.base.BasePresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import com.stefano.network.FruitVegApi


class FruitVegPresenter(val fruitVegsApi: FruitVegApi) : BasePresenterImpl<FruitVegContract.View>(), FruitVegContract.Presenter {

    override fun detachView() {
        super<BasePresenterImpl>.detachView()
        subscription?.dispose()
    }

    private var subscription: Disposable? = null


    override fun searchForResults(searchString: String) {
        loadFruitVegs(searchString)
    }

    fun loadFruitVegs(searchstring: String) {
        view?.showLoading()
        subscription = fruitVegsApi
                .getFruitVegs(searchstring)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map { it.results }
                .subscribe(
                        { fruitVegList ->
                            view?.apply {
                                updateFruitVegs(fruitVegList)
                                hideLoading()
                            }
                        },
                        {
                            view?.apply {
                                showToast(it.message)
                                hideLoading()
                            }
                        }
                )

    }


}