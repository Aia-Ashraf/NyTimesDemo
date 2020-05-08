
package com.example.nytimes

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NYAPIService {
    @GET("/svc/mostpopular/v2/viewed/7.json")
    fun getNyTimesData(@Query ("api-key") api_key:String)
            : Single<Response>
}