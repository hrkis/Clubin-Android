package com.clubin.com.ui.tabbar

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.clubin.com.R
import com.clubin.com.ui.fragment.event.view.EventFragment
import com.clubin.com.ui.fragment.hosts.view.HostsFragment
import com.clubin.com.ui.fragment.profile.ProfileFragment
import com.clubin.com.ui.fragment.tickets.view.TicketsMainFragment

class TabBarActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var container: FrameLayout

    lateinit var eventTab: LinearLayout
    lateinit var hostTab: LinearLayout
    lateinit var billetsTab: LinearLayout
    lateinit var profileTab: LinearLayout

    lateinit var ic_search: ImageView
    lateinit var ic_home: ImageView
    lateinit var ic_billets: ImageView
    lateinit var ic_profile: ImageView

    lateinit var tab_event_txt: TextView
    lateinit var tab_home_txt: TextView
    lateinit var tab_billets_txt: TextView
    lateinit var tab_profile_txt: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tabbar_activity)

        setupFindViewById()
        setupClickListeners()

        eventTab.performClick()

    }

    companion object {
        var mInstance: TabBarActivity? = null
        fun getInstance(): TabBarActivity {
            return mInstance!!
        }
    }

    private fun setupFindViewById() {
        container = findViewById(R.id.container)

        eventTab = findViewById(R.id.eventTab)
        hostTab = findViewById(R.id.hostTab)
        billetsTab = findViewById(R.id.billetsTab)
        profileTab = findViewById(R.id.profileTab)

        ic_search = findViewById(R.id.ic_search)
        ic_home = findViewById(R.id.ic_home)
        ic_billets = findViewById(R.id.ic_billets)
        ic_profile = findViewById(R.id.ic_profile)

        tab_event_txt = findViewById(R.id.tab_event_txt)
        tab_home_txt = findViewById(R.id.tab_home_txt)
        tab_billets_txt = findViewById(R.id.tab_billets_txt)
        tab_profile_txt = findViewById(R.id.tab_profile_txt)
    }

    private fun setupClickListeners() {
        arrayOf(eventTab, hostTab, billetsTab, profileTab).forEach { it.setOnClickListener(this) }
    }

    private fun setupTabs(pos: Int) {
        val activeIconColor = ContextCompat.getColor(this, R.color.dull_green)
        val deactiveIconColor = ContextCompat.getColor(this, R.color.dull_white)
        val activeTextColor = ContextCompat.getColor(this, R.color.white)
        val deactiveTextColor = ContextCompat.getColor(this, R.color.dull_white)

        ic_search.setColorFilter(if (pos == 0) activeIconColor else deactiveIconColor)
        tab_event_txt.setTextColor(if (pos == 0) activeTextColor else deactiveTextColor)

        ic_home.setColorFilter(if (pos == 1) activeIconColor else deactiveIconColor)
        tab_home_txt.setTextColor(if (pos == 1) activeTextColor else deactiveTextColor)

        ic_billets.setColorFilter(if (pos == 2) activeIconColor else deactiveIconColor)
        tab_billets_txt.setTextColor(if (pos == 2) activeTextColor else deactiveTextColor)

        ic_profile.setColorFilter(if (pos == 3) activeIconColor else deactiveIconColor)
        tab_profile_txt.setTextColor(if (pos == 3) activeTextColor else deactiveTextColor)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            eventTab -> {
                setupTabs(0)
                addFragment(EventFragment(), false)
            }
            hostTab -> {
                setupTabs(1)
                addFragment(HostsFragment(), false)
            }
            billetsTab -> {
                setupTabs(2)
                addFragment(TicketsMainFragment(), false)
            }
            profileTab -> {
                setupTabs(3)
                addFragment(ProfileFragment(), false)
            }
        }
    }


    public fun addFragment(frag: Fragment, addToBackStack: Boolean) {
        /*if (!isFinishing) {
            util.hideKeyboard(this)
        }*/

        val trans = supportFragmentManager.beginTransaction()

        if (addToBackStack) {
            trans.setCustomAnimations(R.anim.slide_in_from_right,
                R.anim.slide_out_to_right, R.anim.slide_in_from_right,
                R.anim.slide_out_to_right)
            trans.add(R.id.container, frag)
        } else {
            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            trans.replace(R.id.container, frag)
        }

        if (addToBackStack) trans.addToBackStack(frag::class.java.simpleName)

        trans.commit()
        supportFragmentManager.executePendingTransactions()
    }

    fun removeFragment() {
        /*if (!isFinishing) {
            util.hideKeyboard(this)
        }*/

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
            val v = currentFragment()
            //noinspection ConstantConditions
            if (supportFragmentManager.backStackEntryCount > 0) {
                v?.view?.requestFocus()
            }
        }
    }

    fun isVisible(): Boolean {
        return !isFinishing
    }

    fun currentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(R.id.container)
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount != 0) {
            removeFragment()
        } else {
            super.onBackPressed()
        }
    }
}