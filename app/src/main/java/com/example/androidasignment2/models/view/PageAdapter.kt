package com.example.androidasignment2.models.view


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.androidasignment2.R
import com.example.androidasignment2.fragment_tab1
import com.example.androidasignment2.fragment_tab2
import com.example.androidasignment2.fragment_tab3

class PageAdapter(var fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {

                return fragment_tab1()
            }
            1 -> {
//                fm.beginTransaction()
//                    .replace(R.id.container2, SingsListFragment("pop", "music", "song", "50"))
//                    .commit()
                return fragment_tab2()
            }
            2 -> {
                return fragment_tab3()
            }
            else -> {
                return fragment_tab1()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return ""
            }
            1 -> {
                return ""
            }
            2 -> {
                return ""
            }
        }
        return super.getPageTitle(position)
    }

}
