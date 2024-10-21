package com.clubin.com.ui.fragment.message.view

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.clubin.com.R
import com.clubin.com.databinding.MessageTabFragmentBinding
import com.clubin.com.ui.fragment.message.adapter.MessageTabAdapter
import com.clubin.com.ui.fragment.message.model.MessageTabModel
import com.clubin.com.ui.fragment.message.viewmodel.MessageTabViewModel

class MessageTabFragment : Fragment() {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    private lateinit var vm: MessageTabViewModel
    private lateinit var binding: MessageTabFragmentBinding

    val list: MutableList<MessageTabModel> = mutableListOf()
    private var adapter: MessageTabAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this@MessageTabFragment).get(MessageTabViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.message_tab_fragment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val str = "En attendant, afin de " + "<b>" + "communiquer avec les autres participants/Hôtes" + "</b>" + " d'un évènement, vous recevrez un <font color=#86D8FF>lien d'invitation Whatsapp</font> pour rejoindre votre <font color=#96F587>conversation de groupe</font> associé."
        binding.descriptionTxt.setText(if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) Html.fromHtml(str) else Html.fromHtml(str, Html.FROM_HTML_MODE_LEGACY))

        list.add(MessageTabModel())
        list.add(MessageTabModel())
        list.add(MessageTabModel())

        adapter = MessageTabAdapter(mContext, list)
        binding.messagesRecyclerView.layoutManager = LinearLayoutManager(mContext)
        binding.messagesRecyclerView.adapter = adapter
    }
}