package com.example.androidasignment2.models.view

import android.media.AudioManager
import android.media.MediaPlayer
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.androidasignment2.R
import com.example.androidasignment2.models.SingsModel
import com.squareup.picasso.Picasso
import java.io.IOException


//class SingsDetailFragment (private val dataSet : List<SingsModel>,
//private val openDetails : (SingsModel)->Unit):RecyclerView.Adapter<SingsDetailFragment.SingsViewHolder>()
//{
//
//
// class SingsViewHolder (private val view :View):
//         RecyclerView.ViewHolder(view)
//    {
//        private val singTitle :TextView=view.findViewById(R.id.tv_sing_title)
//        private val singArtist :TextView=view.findViewById(R.id.tv_sing_artist)
//        private val singPrice :TextView=view.findViewById(R.id.tv_sing_price)
//         }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingsViewHolder {
//        TODO("Not yet implemented")
//    }
//
//    override fun onBindViewHolder(holder: SingsViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
//    }
//}
private const val TAG = "SingsDetailFragment"
class SingsDetailFragment : Fragment(){
    var mediaPlayer : MediaPlayer? = null

    companion object{
        val SING_DETAIL_DATA = "SING_DETAIL_DATA"
        fun newInstance(singDetail : SingsModel)=
            SingsDetailFragment().apply {
            arguments=Bundle().apply {
                putParcelable(SING_DETAIL_DATA, singDetail)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(
            R.layout.detail_fragment_sing,
            container,
            false
        )
        arguments?.getParcelable<SingsModel>(SING_DETAIL_DATA)?.let{
            initViews(view, it)
        }
        return view
    }

    private fun initViews(viewParent: View, itMovieDetal: SingsModel)
    {
        viewParent.run{
            Picasso.get().load(itMovieDetal.artworkUrl60).into(findViewById<ImageView>(R.id.iv_sing_image_detf))
            findViewById<TextView>(R.id.tv_sing_artist_detf).text = itMovieDetal.artistName
            findViewById<TextView>(R.id.tv_sing_title_detf).text = itMovieDetal.collectionName
            playAudio(itMovieDetal.previewUrl)
            val i = findViewById<Button>(R.id.btn_close_det)

            i.setOnClickListener {
                pauseAudio()
                viewParent.visibility =View.INVISIBLE
            }
        }

    }

    private fun playAudio( audioURL:String)
    {
        mediaPlayer = MediaPlayer()
        mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mediaPlayer?.setDataSource(audioURL)
            mediaPlayer?.prepare()
            mediaPlayer?.start()
        }catch (e:IOException){

        }
    }

    private fun pauseAudio()
    {
        if(mediaPlayer!!.isPlaying){
            mediaPlayer!!.stop()
            mediaPlayer!!.reset()
            mediaPlayer!!.release()
        }
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach: ")
        super.onDetach()
    }

    override fun onStop() {
        Log.d(TAG, "onStop: ")
        super.onStop()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onOptionsMenuClosed(menu: Menu) {
        super.onOptionsMenuClosed(menu)
        Log.d(TAG, "onOptionsMenuClosed: ")
    }

}