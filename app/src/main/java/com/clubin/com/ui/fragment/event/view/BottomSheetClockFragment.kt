package com.clubin.com.ui.fragment.event.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.clubin.com.R
import com.clubin.com.databinding.FragmentBottomSheetClockBinding
import com.clubin.com.ui.fragment.event.adapter.EventLocationTimeAdapter
import com.clubin.com.ui.fragment.event.adapter.EventLocationTimeAdapterDisable
import com.clubin.com.ui.tabbar.TabBarActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BottomSheetClockFragment : BottomSheetDialogFragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mContext: Context
    var locationTimeAdapter: EventLocationTimeAdapter? = null
    var locationTimeAdapter2: EventLocationTimeAdapterDisable? = null
    val list: MutableList<String> = mutableListOf()
    private lateinit var binding: FragmentBottomSheetClockBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet_clock, container, false)
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

        locationTimeAdapter = EventLocationTimeAdapter(mContext, list, object : EventLocationTimeAdapter.ItemClickListener {
            override fun onItemClickListener(pos: Int) {
                (activity as TabBarActivity)?.let {
                    // it.addFragment(HostCreationPlaceTypeFragment(), true)
                }
            }
        })

        binding.recycler.layoutManager = LinearLayoutManager(mContext)
        binding.recycler.adapter = locationTimeAdapter

        locationTimeAdapter2 = EventLocationTimeAdapterDisable(mContext, list, object : EventLocationTimeAdapterDisable.ItemClickListener {
            override fun onItemClickListener(pos: Int) {
                (activity as TabBarActivity)?.let {
                    // it.addFragment(HostCreationPlaceTypeFragment(), true)
                }
            }
        })

        binding.recycler2.layoutManager = LinearLayoutManager(mContext)
        binding.recycler2.adapter = locationTimeAdapter2

        val submit = view.findViewById<Button>(R.id.btnValider)
        submit.setOnClickListener {
            dialog?.dismiss()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BottomSheetClockFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
