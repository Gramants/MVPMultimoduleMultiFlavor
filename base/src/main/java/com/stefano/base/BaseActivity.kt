package com.stefano.base

import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.test.espresso.IdlingResource


abstract class BaseActivity : BaseView, AppCompatActivity() {

// put NOT VIEW RELATED OBJECT HERE LIKE SNACKBARS DIALOG AND WHATEVER

    // The Idling Resource which will be null in production.
    @Nullable
    private var mIdlingResource: SimpleIdlingResource? = null

    override fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    @VisibleForTesting
    @NonNull
    fun getIdlingResource(): IdlingResource {
        if (mIdlingResource == null) {
            mIdlingResource = SimpleIdlingResource()
        }
        return mIdlingResource as SimpleIdlingResource
    }

}