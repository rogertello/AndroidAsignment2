package com.example.androidasignment2.models.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidasignment2.R
import com.example.androidasignment2.models.SingsList
import com.example.androidasignment2.models.SingsModel
import com.squareup.picasso.Picasso

class SingsAdapter(private val dataSet : SingsList,
private val openDetails : (SingsModel) -> Unit):
RecyclerView.Adapter<SingsAdapter.SingsViewHolder>()
{

    class SingsViewHolder(private val view:View) :
    RecyclerView.ViewHolder(view)
    {
        private val singTitle:TextView=view.findViewById(R.id.tv_sing_title)
        private val singImage : ImageView=view.findViewById(R.id.iv_sing_image)
        private val singArtist:TextView=view.findViewById(R.id.tv_sing_artist)
        private val singPrice:TextView=view.findViewById(R.id.tv_sing_price)

        fun onBind(dataItem : SingsModel, openDetails: (SingsModel) -> Unit)
        {
            singTitle.text=dataItem.collectionName
            Picasso.get().load(dataItem.artworkUrl60).into(singImage)
            singArtist.text=dataItem.artistName
            singPrice.text=dataItem.trackPrice
            view.setOnClickListener{
                openDetails(dataItem)
            }
        }
    }
    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):SingsViewHolder
    {
        return SingsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_sing_layout_fragment,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder:SingsViewHolder, position:Int)
    {
        holder.onBind(dataSet.results[position], openDetails)


    }

    override fun getItemCount(): Int {
        return dataSet.results.size
    }


}