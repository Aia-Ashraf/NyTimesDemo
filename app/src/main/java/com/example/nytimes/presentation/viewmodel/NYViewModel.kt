package com.example.nytimes.presentation.viewmodel


import androidx.lifecycle.ViewModel
import com.example.nytimes.domain.Repo
import com.example.nytimes.data.models.NewsList
import com.example.nytimes.presentation.view.NYView

class NYViewModel : ViewModel() {
    private lateinit var newsList: MutableList<NewsList>
    lateinit var nyView: NYView

    fun getNyNews() {
        newsList = emptyArray<NewsList>().toMutableList()
        var repo = Repo(newsList, nyView)
        repo.getData();
    }
}



