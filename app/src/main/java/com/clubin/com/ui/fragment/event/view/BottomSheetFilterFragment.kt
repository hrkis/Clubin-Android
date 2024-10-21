package com.clubin.com.ui.fragment.event.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.clubin.com.R
import com.clubin.com.databinding.FragmentBottomSheetFilterBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BottomSheetFilterFragment : BottomSheetDialogFragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mContext: Context
    private lateinit var binding: FragmentBottomSheetFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet_filter, container, false)
        // binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //show full screen
        dialog?.setOnShowListener {
            val dialog = it as BottomSheetDialog
            val bottomSheet = dialog.findViewById<View>(R.id.bottom_sheet)
            bottomSheet?.let { sheet ->
                dialog.behavior.peekHeight = sheet.height
                sheet.parent.parent.requestLayout()
            }
        }
        val btnClose = view.findViewById<ImageView>(R.id.iv_cancel)
        btnClose.setOnClickListener {
            dialog?.dismiss()
        }

        var nightChip = true
        binding.llNights.setOnClickListener {
            if (nightChip) {
                nightChip = false
                binding.chipGroupNights.visibility = View.VISIBLE
                binding.ivNightArrow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                nightChip = true
                binding.chipGroupNights.visibility = View.GONE
                binding.ivNightArrow.setImageResource(R.drawable.ic_arrow_down)
            }
        }

        var disChip = true
        binding.llDiscovery.setOnClickListener {
            if (disChip) {
                disChip = false
                binding.chipGroupDiscovery.visibility = View.VISIBLE
                binding.ivDisArrow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                disChip = true
                binding.chipGroupDiscovery.visibility = View.GONE
                binding.ivDisArrow.setImageResource(R.drawable.ic_arrow_down)
            }
        }

        var vibesChip = true
        binding.llVibes.setOnClickListener {
            if (vibesChip) {
                vibesChip = false
                binding.chipGroupVibe.visibility = View.VISIBLE
                binding.ivVibesArrow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                vibesChip = true
                binding.chipGroupVibe.visibility = View.GONE
                binding.ivVibesArrow.setImageResource(R.drawable.ic_arrow_down)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BottomSheetFilterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}