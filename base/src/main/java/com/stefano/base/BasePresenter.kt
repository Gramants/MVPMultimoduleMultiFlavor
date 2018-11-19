package com.stefano.base

import android.support.annotation.CallSuper


interface BasePresenter<T : BaseView> {

    var view: T?

    @CallSuper
    fun attachView(view: T?) {
        this.view = view
    }

    @CallSuper
    fun detachView() {
        this.view = null
    }

}

open class BasePresenterImpl<T : BaseView> : BasePresenter<T> {
    override var view: T? = null

}


