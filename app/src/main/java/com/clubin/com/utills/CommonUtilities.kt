package com.clubin.com.utills

import android.app.Activity
import android.content.Intent
import com.clubin.com.R

class CommonUtilities {
    companion object {
        fun fireActivityIntent(
            sourceActivity: Activity,
            mIntent: Intent,
            isFinish: Boolean,
            isForward: Boolean
        ) {
            sourceActivity.startActivity(mIntent)
            if (isFinish) {
                sourceActivity.finish()
            }
            if (isForward) {
                sourceActivity.overridePendingTransition(
                    R.anim.slide_in_left,
                    R.anim.slide_out_left
                )
            } else {
                sourceActivity.overridePendingTransition(
                    R.anim.slide_in_right,
                    R.anim.slide_out_right
                )
            }
        }
    }
}