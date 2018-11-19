package com.stefano.search.fruitsearch


import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.Menu
import android.view.View
import android.widget.LinearLayout
import android.widget.SearchView
import com.stefano.base.BaseActivity
import com.stefano.feature_search2.R
import dagger.android.AndroidInjection


import kotlinx.android.synthetic.main.activity_no_fragment.*
import net.stefano.fruitveg.model.FruitVeg



import javax.inject.Inject


class FruitVegActivity : BaseActivity(), FruitVegContract.View {




    private val fruitVegsAdapter = FruitVegAdapter(this)
    private lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var presenter: FruitVegPresenter


    override fun showLoading() {
        progressBar.visibility= View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility= View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_no_fragment)
        rv_fruitVegs.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv_fruitVegs.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rv_fruitVegs.adapter = fruitVegsAdapter


    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
        hideLoading()

    }

    override fun updateFruitVegs(fruitVegs: List<FruitVeg>) {
        fruitVegsAdapter.updateFruitVegs(fruitVegs)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        val menuItem = menu.findItem(R.id.search)
        val searchView = menuItem.actionView as SearchView
        searchView.setIconifiedByDefault(true)
        searchView.isSubmitButtonEnabled = false
        searchView.queryHint = getString(R.string.title_search_result)
        searchView.setOnQueryTextListener(onQueryTextListener)
        searchView.clearFocus();
        return true
    }


    private val onQueryTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {
            if (!TextUtils.isEmpty(query)) {
                fruitVegsAdapter.deleteAll()
                presenter.searchForResults(query)
            }
            return false
        }

        override fun onQueryTextChange(newText: String): Boolean {

            return false
        }
    }


}