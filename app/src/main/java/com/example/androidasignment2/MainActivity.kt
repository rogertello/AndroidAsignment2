package com.example.androidasignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.androidasignment2.databinding.ActivityMainBinding
import com.example.androidasignment2.models.SingsList
import com.example.androidasignment2.models.SingsModel
import com.example.androidasignment2.models.remote.SingsService
import com.example.androidasignment2.models.view.PageAdapter
import com.example.androidasignment2.models.view.SingsAdapter
import com.example.androidasignment2.models.view.SingsListFragment
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    //private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = PageAdapter(supportFragmentManager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_baseline_dashboard_24_purple)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_baseline_home_24_blue)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_baseline_notifications_24_green)

//https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50
//https://itunes.apple.com/search?term=classic&%26media=music&%26entity=song&%26limit=50
//https://itunes.apple.com/search?term=pop&amp;media=music&amp;entity=song&amp;limit=50
//https://itunes.apple.com/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50
//supportFragmentManager.beginTransaction()
//    .replace(R.id.container, SingsListFragment("pop", "music", "song", "50"))
//    .commit()


}

    private fun errorMessage(message: String) {
        Log.d(TAG, "errorMessage: Retrofit Error: $message")
    }

    private fun updateUI(response: SingsList) {
        Log.d(TAG, "updateUI: REtrofit.response: $response")

//        binding.booksList.layoutManager= LinearLayoutManager(this)
//        binding.booksList.adapter = BooksAdapter(response.items)
//        binding.booksList.itemAnimator
    }
        private fun openDetails(movieItem: SingsModel){

            Toast.makeText(this,  "$movieItem", Toast.LENGTH_SHORT).show()
            // Toast.makeText(this, text : "", Toast.)
        }


    }
