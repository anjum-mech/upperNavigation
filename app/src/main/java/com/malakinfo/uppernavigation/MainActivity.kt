package com.malakinfo.uppernavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.malakinfo.uppernavigation.R.*
import com.malakinfo.uppernavigation.fragments.SentFragment
import com.malakinfo.uppernavigation.fragments.TabFragment
import com.malakinfo.uppernavigation.fragments.draftFragment


class MainActivity : AppCompatActivity() {
    lateinit var mDrawerLayout: DrawerLayout
    lateinit var mNavigationView: NavigationView
    lateinit var mFragmentManager: FragmentManager
    lateinit var mFragmentTransaction: FragmentTransaction


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        mDrawerLayout = findViewById<View>(id.drawerLayout) as DrawerLayout
        mNavigationView = findViewById<View>(id.navView) as NavigationView

        mFragmentManager = supportFragmentManager
        mFragmentTransaction = mFragmentManager.beginTransaction()
        mFragmentTransaction.replace(id.containerView, TabFragment()).commit()

        mNavigationView.setNavigationItemSelectedListener { menuItem ->
            mDrawerLayout.closeDrawers()

            if (menuItem.itemId == R.id.nav_item_inbox) {

                val ft = mFragmentManager.beginTransaction()
                ft.replace(id.containerView, TabFragment()).commit()


            }
            if (menuItem.itemId == R.id.nav_item_sent) {

                val ft = mFragmentManager.beginTransaction()
                ft.replace(id.containerView, SentFragment()).commit()


            }
            if (menuItem.itemId == R.id.nav_item_draft) {

                val ft = mFragmentManager.beginTransaction()
                ft.replace(id.containerView, draftFragment()).commit()


            }




            false

        }

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        val mDrawerToggle = ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name,R.string.app_name)

        mDrawerLayout.setDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()




    }
}


