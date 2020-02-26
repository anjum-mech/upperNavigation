package com.malakinfo.uppernavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.malakinfo.uppernavigation.R
import kotlinx.android.synthetic.main.tab_layout.*

class TabFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val x = inflater.inflate(R.layout.tab_layout, null)
        tabLayout = x.findViewById<View>(R.id.tabs)as TabLayout
        viewPager = x.findViewById<View>(R.id.viewpager)as ViewPager

        viewpager.adapter = MyAdapter(childFragmentManager)
        tabLayout.post { tabLayout.setupWithViewPager( viewPager) }

        return x
    }
    internal inner class MyAdapter(fm:FragmentManager): FragmentPagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            when(position){
                0 -> return BoyFragment()
                1 -> return GirlFragment()
                2 -> return FavFragment()
            }
            return null!!
        }

        override fun getCount(): Int {
            return int_items
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when(position){
                0-> return "Boy"
                1-> return "Girl"
                2-> return "Favourite"
            }
            return null
        }



    }

    companion object{
        lateinit var tabLayout: TabLayout
        lateinit var viewPager: ViewPager
        var int_items =3
    }
}