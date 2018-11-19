package com.stefano.showmsg.fruitdetail



interface FruitVegDetailContract {


    interface View{
        fun printSearchString(searchstring: String)
    }

    interface Presenter {
        fun onSearched(searchString: String)

        fun onAttach(fragment: FruitVegDetailFragment)
    }


}
