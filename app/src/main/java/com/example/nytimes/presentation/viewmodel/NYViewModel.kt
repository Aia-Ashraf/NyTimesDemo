package com.example.nytimes


import androidx.lifecycle.ViewModel
import com.example.nytimes.presentation.view.NYView
import com.example.nytimes.presentation.view.NyAdapter
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NYViewModel() : ViewModel() {
    private var nyAdapter: NyAdapter? = null
    var nYResponse: Response? = null
    lateinit var newsList: MutableList<NewsList>
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var nyView: NYView

    fun getNyNews() {


        val requestInterface = Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build().create(NYAPIService::class.java)

        compositeDisposable?.add(
            requestInterface.getNyTimesData("wAYfy4WW0jXYtRMIhMFGVC3nzmrCkcDr")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.status == "OK") {
                        newsList = it.results
                        print(it.toString() + "+++++++++++++++++++++")
                        nyView.setData(it.results)
                    }
                }, {
                    it.message
                    print(it.message.toString() + "+++++++++++++++++++++")

                })
        )
    }
}



