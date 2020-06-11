package com.example.nytimes.domain

import com.example.nytimes.data.models.NewsList
import com.example.nytimes.data.remote.NYAPIService
import com.example.nytimes.presentation.view.NYView
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class Repo(
    newsList: List<NewsList>, nyView: NYView
) {
    var newsList: List<NewsList>
    var nyView: NYView
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getData() {
        val requestInterface = Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build().create(NYAPIService::class.java)

        compositeDisposable.add(
            requestInterface.getNyTimesData("wAYfy4WW0jXYtRMIhMFGVC3nzmrCkcDr")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.status == "OK") {
                        newsList = it.results
                        nyView.setData(it.results)
                    }
                }, {
                    it.message
                })
        )

    }

    init {
        this.newsList = newsList
        this.nyView = nyView
    }
}