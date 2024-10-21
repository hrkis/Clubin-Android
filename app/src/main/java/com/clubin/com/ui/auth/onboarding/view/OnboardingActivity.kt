package com.clubin.com.ui.auth.onboarding.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.clubin.com.R
import com.clubin.com.ui.auth.signup.SignUpActivity
import com.clubin.com.ui.auth.onboarding.adapter.OnboardingPagerAdapter
import com.clubin.com.ui.auth.onboarding.model.ViewPagerDM
import com.clubin.com.ui.auth.onboarding.viewmodel.OnboardingVM
import com.clubin.com.utills.CommonUtilities

class OnboardingActivity : AppCompatActivity() {
    var binding: com.clubin.com.databinding.ActivityOnboardingBinding? = null
    var vm: OnboardingVM? = null
    var whichScreen: String? = null
    var pos: Int? = 0
    var pager_itemList = ArrayList<ViewPagerDM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)
        vm = ViewModelProvider(this).get(OnboardingVM::class.java)
        binding?.mview = vm
        pager_itemList.add(
            ViewPagerDM(
                R.drawable.blueberry,
                getString(R.string.onboarding_one_title),
                getString(R.string.onboarding_one_headline),
                R.color.black,
                R.color.ColorBlueberryDark
            )
        )
        pager_itemList.add(
            ViewPagerDM(
                R.drawable.strawberry,
                getString(R.string.onboarding_two_title),
                getString(R.string.onboarding_two_headline),
                R.color.ColorStrawberryLight,
                R.color.ColorStrawberryDark
            )
        )
        pager_itemList.add(
            ViewPagerDM(
                R.drawable.lemon,
                getString(R.string.onboarding_three_title),
                getString(R.string.onboarding_three_headline),
                R.color.ColorLemonLight,
                R.color.ColorLemonDark
            )
        )
        pager_itemList.add(
            ViewPagerDM(
                R.drawable.plum,
                getString(R.string.onboarding_four_title),
                getString(R.string.onboarding_four_headline),
                R.color.ColorPlumLight,
                R.color.ColorPlumDark
            )
        )

        pager_itemList.add(
            ViewPagerDM(
                R.drawable.lime,
                getString(R.string.onboarding_five_title),
                getString(R.string.onboarding_five_headline),
                R.color.ColorLimeLight,
                R.color.ColorLimeDark
            )
        )

        pager_itemList.add(
            ViewPagerDM(
                R.drawable.pomegranate,
                getString(R.string.onboarding_six_title),
                getString(R.string.onboarding_six_headline),
                R.color.ColorPomegranateLight,
                R.color.ColorPomegranateDark
            )
        )

        val adapter = OnboardingPagerAdapter(this, pager_itemList)
        binding?.viewpager!!.adapter = adapter
        binding?.dotsIndicator!!.setViewPager(binding?.viewpager!!)
        binding?.viewpager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position == pager_itemList.size - 1) {
                    whichScreen = "last"
                    binding?.btnNext!!.setText(resources.getText(R.string.button_text))
                } else {
                    whichScreen = "non-last"
                    pos = position
                    binding?.btnNext!!.setText(resources.getText(R.string.button_text))
                }
            }

        })


        binding?.btnNext!!.setOnClickListener {
            //   if (whichScreen == "last") {
            CommonUtilities.fireActivityIntent(
                this,
                Intent(this, SignUpActivity::class.java),
                isFinish = false,
                isForward = true
            )
            //  }
            /* else{
                 binding!!.viewpager.setCurrentItem(pos!!.plus(1),true)
             }*/
        }

    }

}