package com.stefano.search.fruitsearch


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.Menu
import android.view.View
import android.widget.LinearLayout
import android.widget.SearchView
import com.stefano.base.BaseActivity
import com.stefano.feature_search.R
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

import com.stefano.showmsg.fruitdetail.FruitVegDetailFragment
import kotlinx.android.synthetic.main.activity_main.*
import net.stefano.fruitveg.model.FruitVeg



import javax.inject.Inject


class FruitVegActivity : BaseActivity(), HasSupportFragmentInjector, FruitVegContract.View {




    private val fruitVegsAdapter = FruitVegAdapter(this)
    private lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var presenter: FruitVegPresenter

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    override fun showLoading() {
        progressBar.visibility= View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility= View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        rv_fruitVegs.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv_fruitVegs.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rv_fruitVegs.adapter = fruitVegsAdapter
        showResultInFragment("")

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
                showResultInFragment(query)
                presenter.searchForResults(query)
            }
            return false
        }

        override fun onQueryTextChange(newText: String): Boolean {
            if (newText=="")
                showResultInFragment("")

            return false
        }
    }

    private fun showResultInFragment(query: String) {
        val kotlinFragment = FruitVegDetailFragment.newInstance(query)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_content, kotlinFragment, "fruitdetail")
                .commit()
    }
}