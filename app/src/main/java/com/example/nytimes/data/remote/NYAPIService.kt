
package com.example.nytimes.data.remote

import com.example.nytimes.data.models.Response
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NYAPIService {
    @GET("/svc/mostpopular/v2/viewed/7.json")
    fun getNyTimesData(@Query ("api-key") apiKey:String)
            : Single<Response>
}