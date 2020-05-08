package com.example.nytimes.presentation.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimes.NewsList
import com.example.nytimes.R
import java.util.concurrent.atomic.AtomicBoolean


class NyAdapter constructor( val context: Context) :
    RecyclerView.Adapter<NyAdapter.NyViewHolder>() {
    private var newsList :MutableList<NewsList> = emptyArray<NewsList>().toMutableList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NyViewHolder {

        val context = parent.context
        val layoutIdForListItem = R.layout.item_ny
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false
        val view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately)
        return NyViewHolder(view)
    }

    override fun onBindViewHolder(nyViewHolder: NyViewHolder, position: Int) {
        val mPosition = newsList.get(position)
        nyViewHolder.ibForward.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("title", mPosition.title)
            intent.putExtra("des", mPosition.abstract)
            startActivity(context, intent, Bundle.EMPTY)
        }
        nyViewHolder.txtNyNewsTitle.setText(mPosition.title)
        nyViewHolder.txtNyNewsAuther.setText(mPosition.byline)
        nyViewHolder.txtDate.setText(mPosition.published_date)
    }

    fun setNewsList(list: MutableList<NewsList>) {
        newsList = list!!
        this.notifyDataSetChanged()
    }

    inner class NyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ibForward: ImageView = itemView.findViewById(R.id.ib_forward_arrow)
        val txtNyNewsTitle: TextView = itemView.findViewById(R.id.tv_ny_title)
        val txtNyNewsAuther: TextView = itemView.findViewById(R.id.tv_ny_auther)
        val txtDate: TextView = itemView.findViewById(R.id.tv_date)
    }

    override fun getItemCount(): Int =
        newsList.size

}