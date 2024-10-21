package com.clubin.com.ui.fragment.hosts.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.clubin.com.R
import com.clubin.com.databinding.HostsFragmentBinding
import com.clubin.com.ui.fragment.hosts.viewmodel.HostsViewModel
import com.clubin.com.ui.tabbar.TabBarActivity
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import java.time.LocalDate
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

class HostsFragment : Fragment(), View.OnClickListener {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    private lateinit var vm: HostsViewModel
    lateinit var binding: HostsFragmentBinding
    val activeTabColor: Int by lazy { ContextCompat.getColor(mContext, R.color.white) }
    val inactiveTabColor: Int by lazy { ContextCompat.getColor(mContext, R.color.dull_white) }
    private val selectedDates = mutableSetOf<LocalDate>()
    private val today = LocalDate.now()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this@HostsFragment).get(HostsViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.hosts_fragment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayOf(binding.createTab, binding.onlineTab, binding.chooseThisDate).forEach { it.setOnClickListener(this) }

        binding.calendarView.dayBinder = object : DayBinder<DayViewContainer> {
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                // Set the calendar day for this container.
                container.day = day

                container.textView.text = day.date.dayOfMonth.toString()
                if (day.owner == DayOwner.THIS_MONTH) {
                    container.textView.setTextColor(ContextCompat.getColor(mContext, R.color.white))
                    container.textView.visibility = View.VISIBLE

                    when {
                        selectedDates.contains(day.date) -> {
                            container.textView.setTextColor(ContextCompat.getColor(mContext, R.color.black))
                            container.textView.setBackgroundResource(R.drawable.green_calendar_background)
                        }
                        today == day.date -> {
                            container.textView.setTextColor(ContextCompat.getColor(mContext, R.color.white))
                            container.textView.setBackgroundResource(R.drawable.calendar_today)
                        }
                        else -> {
                            container.textView.background = null
                        }
                    }
                } else {
                    container.textView.setTextColor(ContextCompat.getColor(mContext, R.color.text_light_white))
                    container.textView.visibility = View.INVISIBLE
                }
            }

            override fun create(view: View): DayViewContainer {
                return DayViewContainer(view)
            }

        }

        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(10)
        val lastMonth = currentMonth.plusMonths(10)
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
        binding.calendarView.setup(firstMonth, lastMonth, firstDayOfWeek)
        binding.calendarView.scrollToMonth(currentMonth)
    }

    inner class DayViewContainer(view: View) : ViewContainer(view) {
        val textView = view.findViewById<TextView>(R.id.calendarDayText)
        lateinit var day: CalendarDay

        init {
            view.setOnClickListener {
                Log.e(TAG, "Day click ${day.date}")
                if (day.owner == DayOwner.THIS_MONTH) {
                    if (selectedDates.contains(day.date)) {
                        selectedDates.remove(day.date)
                    } else {
                        selectedDates.clear();
                        selectedDates.add(day.date)
                        textView.background = ContextCompat.getDrawable(mContext, R.drawable.green_calendar_background)
                    }
                    binding.calendarView.notifyDayChanged(day)
                }
            }
        }
    }



    /*    init {
            view.setOnClickListener {
                if (day.owner == DayOwner.THIS_MONTH) {
                    if (selectedDates.contains(day.date)) {
                        selectedDates.remove(day.date)
                    } else {
                        selectedDates.add(day.date)
                    }
                    binding.exOneCalendar.notifyDayChanged(day)
                }
            }
        }*/



    override fun onClick(p0: View?) {
        when (p0) {
            binding.createTab -> {
                binding.createContainer.isVisible = true
                binding.createTabDivider.isVisible = true
                binding.onlineContainer.isVisible = false
                binding.onlineTabDivider.visibility = View.INVISIBLE

                binding.createTabTxt.setTextColor(activeTabColor)
                binding.onlineTabTxt.setTextColor(inactiveTabColor)
            }
            binding.onlineTab -> {
                binding.createContainer.isVisible = false
                binding.createTabDivider.visibility = View.INVISIBLE
                binding.onlineContainer.isVisible = true
                binding.onlineTabDivider.isVisible = true

                binding.createTabTxt.setTextColor(inactiveTabColor)
                binding.onlineTabTxt.setTextColor(activeTabColor)
            }
            binding.chooseThisDate -> {
                (activity as TabBarActivity).let {
                    it.addFragment(HostCreationPeopleFragment(), true)
                }
            }
        }
    }
}