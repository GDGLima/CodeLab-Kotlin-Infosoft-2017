package com.emedinaa.infosoft2017

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.MenuItem
import com.emedinaa.infosoft2017.ui.BaseActivityK
import com.emedinaa.infosoft2017.ui.fragmentskt.HomeFragmentK
import com.emedinaa.infosoft2017.ui.fragmentskt.ScheduleFragmentK
import com.emedinaa.infosoft2017.ui.fragmentskt.SpeakersFragmentK
import com.emedinaa.infosoft2017.ui.fragmentskt.SponsorsFragmentK
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityK : BaseActivityK() {

    private var itemId=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app()
    }

    /**
     * Kotlin when
     * https://kotlinlang.org/docs/reference/basic-syntax.html
     */
    private fun app() {

        val menuItem:MenuItem= bottomNavigation.menu.getItem(0)
        itemId= menuItem.itemId
        changeFragment(HomeFragmentK.newInstance())

        bottomNavigation.setOnNavigationItemSelectedListener {item: MenuItem ->
            var fragment:Fragment?=null
            var tab=0
            itemId= item.itemId

            when(item.itemId){
                R.id.action_home -> {
                    tab = 0
                    fragment= HomeFragmentK.newInstance()
                }
                R.id.action_speakers ->  {
                    tab =1
                    fragment= SpeakersFragmentK.newInstance()
                }
                R.id.action_schedule-> {
                    tab=2
                    fragment= ScheduleFragmentK.newInstance()
                }
                R.id.action_sponsors-> {
                    tab=3
                    fragment= SponsorsFragmentK.newInstance()
                }
            }
            changeFragment(fragment!!)
            true
        }
    }

    private fun  changeFragment(fragment: Fragment){
        val fragmenTransaction:FragmentTransaction= supportFragmentManager.beginTransaction()
        fragmenTransaction.replace(R.id.frameLayout,fragment,null)
        fragmenTransaction.commit()
    }


}
