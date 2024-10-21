package com.clubin.com.ui.fragment.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.clubin.com.R
import com.clubin.com.ui.fragment.profile.views.ProfileDetailsFragment

class AccountEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_edit)

        addFragment(ProfileDetailsFragment(), true)
    }

    private fun addFragment(frag: Fragment, addToBackStack: Boolean) {
        val trans = supportFragmentManager.beginTransaction()

        if (addToBackStack) {
            trans.setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_right, R.anim.slide_in_from_right, R.anim.slide_out_to_right)
            trans.add(R.id.container, frag)
        } else {
            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            trans.replace(R.id.container, frag)
        }

        if (addToBackStack) trans.addToBackStack(frag::class.java.simpleName)

        trans.commit()
        supportFragmentManager.executePendingTransactions()
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount != 1) {
            removeFragment()
        } else {
            super.onBackPressed()
        }
    }

    fun removeFragment() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
            val v = currentFragment()
            //noinspection ConstantConditions
            if (supportFragmentManager.backStackEntryCount > 0) {
                v?.view?.requestFocus()
            }
        }
    }

    fun currentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(R.id.container)
    }

}