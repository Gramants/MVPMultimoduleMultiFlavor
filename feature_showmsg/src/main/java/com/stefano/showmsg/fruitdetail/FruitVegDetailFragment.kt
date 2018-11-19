package com.stefano.showmsg.fruitdetail


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ste.showmsg.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_detail.*


import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject


//https://github.com/serapbercin/dagger-architecture/blob/master/a

class FruitVegDetailFragment : Fragment(), FruitVegDetailContract.View, AnkoLogger {

    private lateinit var myPassedValue: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { myPassedValue = it.getString(KEY_SAMPLE) }



    }

    override fun printSearchString(searchstring: String) {
        when (searchstring) {
            "" -> searchedfor.setText("Type your showmsg")
            else -> searchedfor.setText("Searched for $searchstring")
        }

    }

    @Inject
    lateinit var presenter: FruitVegDetailPresenter


    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

    override
    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                     savedInstanceState: Bundle?): View? {
        presenter.onAttach(this)

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onSearched(myPassedValue)
    }


    companion object {
        private const val KEY_SAMPLE: String = "QUERY"

        fun newInstance(query: String) =
                FruitVegDetailFragment().apply {
                    arguments = Bundle().apply {
                        putString(KEY_SAMPLE, query)
                    }
                }
    }
}
