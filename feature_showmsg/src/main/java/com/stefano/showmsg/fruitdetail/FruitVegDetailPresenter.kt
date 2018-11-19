package com.stefano.showmsg.fruitdetail




class FruitVegDetailPresenter() : FruitVegDetailContract.Presenter {

    var view: FruitVegDetailFragment?=null


    override fun onSearched(searchString: String) {
       view?.printSearchString(searchString);
    }


    override fun onAttach(fragment: FruitVegDetailFragment) {
        this.view=fragment;
    }


}