package com.clubin.com.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.clubin.com.R
import com.clubin.com.ui.auth.login.model.User


abstract class BaseFragment(@LayoutRes private val screenLayoutId: Int) : Fragment() {
    lateinit var alertDialog: Dialog
    private val ARG_PARAM1 = "param1"
    private val ARG_PARAM2 = "param2"
    private val ARG_PARAM3 = "param3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        processArguments(arguments)
        // injectDaggerComponent()
        registerBackPressListener()

    }

    abstract fun injectDaggerComponent()

    open fun processArguments(arguments: Bundle?) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        restoreInstanceState(savedInstanceState)
        return inflater.inflate(screenLayoutId, container, false)
    }

    open fun restoreInstanceState(savedInstanceState: Bundle?) {
    }

    protected fun show() {
        alertDialog.show()
    }

    protected fun dismiss() {
        alertDialog.let {
            alertDialog.dismiss()
        }
    }

    protected fun fragmentChange(fragment: Fragment,
                                 param1: User? = null,
                                 param2: String = "",
                                 param3: String = "") {
        val trans = requireActivity().supportFragmentManager.beginTransaction()
        trans.setCustomAnimations(
            R.anim.slide_in_from_right,
            R.anim.slide_out_to_right,
            R.anim.slide_in_from_right,
            R.anim.slide_out_to_right)
        val bundle = Bundle()
        bundle.putSerializable(ARG_PARAM1, param1 as User)
        bundle.putString(ARG_PARAM2, param2)
        bundle.putString(ARG_PARAM3, param3)
        fragment.arguments = bundle
        trans.add(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
        requireActivity().supportFragmentManager.executePendingTransactions()
    }
    // region Navigation
    /**
     * This function is called in the onCreate() of the Base fragment. This will enable the child fragments
     * to receive onBackPress callback and will be cleaner than routing it via the holding activity
     *
     * Ref: https://developer.android.com/guide/navigation/navigation-custom-back
     */
    private fun registerBackPressListener() {
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val consumedInChildFragment = onBackPress()
                    if (!consumedInChildFragment) {
                        isEnabled = false
                        requireActivity().onBackPressed()
                    }
                }
            })
    }


    open fun onBackPress(): Boolean = false
    // endregion Navigation
}