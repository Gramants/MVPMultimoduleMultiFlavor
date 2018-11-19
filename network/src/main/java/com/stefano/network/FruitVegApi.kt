package com.stefano.network


import io.reactivex.Single
import com.stefano.network.model.RemoteModel

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * The interface which provides methods to get result of webservices
 */
interface FruitVegApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/api/tfvjsonapi.php")
    fun getFruitVegs(@Query("search") query: String): Single<RemoteModel>

}