package com.clubin.com.ui.fragment.profile.views


import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R
import com.clubin.com.databinding.ProfileDetailsFragmentDataBinding
import com.clubin.com.base.BaseDataBindingFragment
import com.clubin.com.ui.fragment.event.model.EventModel
import com.clubin.com.ui.fragment.profile.adapter.UserEventAdapter
import com.clubin.com.ui.fragment.profile.callbacks.PreferencesFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProfileDetailsFragment : BaseDataBindingFragment<ProfileDetailsFragmentDataBinding>
    (R.layout.fragment_profile_details),
    PreferencesFragmentCallback {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mContext: Context
    val list: MutableList<EventModel> = mutableListOf()

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


    override fun onDataBindingCreated() {
        binding.imageViewCancel.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.textViewProfileEdit.setOnClickListener {
            fragmentChange(AccountEditFragment())

        }
        binding.tvVerify.setOnClickListener {
            fragmentChange(AllVerifyFragment())
        }

        binding.textViewMore1.setOnClickListener {
            fragmentChange(UserEventListFragment())
        }

        binding.textViewMore2.setOnClickListener {
            fragmentChange(UserEventListFragment())
        }

        binding.textViewMore3.setOnClickListener {
            fragmentChange(UserEventListFragment())
        }

        binding.textViewMore4.setOnClickListener {
            fragmentChange(UserReviewFragment())
        }
        setAdapter();
    }

    private fun setAdapter() {
        val adapter = UserEventAdapter(mContext, list)
        var layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)

        binding.arriveRecycler.layoutManager = layoutManager
        binding.arriveRecycler.adapter = adapter

        layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.orgRecycler.layoutManager = layoutManager
        binding.orgRecycler.adapter = adapter

         layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.partRecycler.layoutManager = layoutManager
        binding.partRecycler.adapter = adapter
    }

    override fun injectDaggerComponent() {

    }

    override fun onBackPress(): Boolean {
        requireActivity().finish();

        return true;
    }


}
/*

Screen :
AccountView

opens on click :: --- MenuView - on click of username and profile photo

navigation button - close :: xmark

view 1::
(image: "Profil", size: 120)
Image("instagram") - 40, 40
Image("facebook") - 40, 40

@ugo_l
---username ---- style: .Bold, ofSize: 22)

Image(systemName: "person")
Text("Ugo Lafosse, 22")
------ (style: .Medium, ofSize: 16)

(icon: "square.and.pencil", text: "Modifier mon profil",
----on click:: AccountEditView()

icon: "square.text.square", text: "Tâches restantes"
----- blue color
----on click:: AccountRemainingTasksView()


BIO: Digital goodies designer @pixsellz. Everything is designed.
-----style: .Medium, ofSize: 16


----uppertext :: (style: .Bold, ofSize: 22)
----lowertext::   style: .Medium, ofSize: 16)
upperText: "4.6", lowerText: "Etoiles", image: "star.fill", color: .yellow
upperText: "12", lowerText: "Organisés", image: "house.fill", color: .blue
upperText: "32",lowerText: "Participés", image: "theatermasks.fill", color: Color.red

--- 1. UserComingSoonEvent
title: "Arrive bientôt", seeMoreText: "Voir plus d'évènements"

----table - cell --- UserEventListView

Image(partyList.image)
.cornerRadius([.topLeft, .topRight], 12)

Text(partyList.title)
.bold()
.body()


Text(partyList.date )
.semibold()
.footnote()
.foregroundColor(Color.secondary)

Text(partyList.grade)
.bold()
.body()

Image(systemName: "star.fill")
.foregroundColor(Color.yellow)


model and dummy data


struct PartyList: Identifiable {

    var id = UUID()
    var image: String
    var title: String
    var date: String
    var grade: String
    var circleColor: Color
    var level: String
    var people: String

}

let partyListData: [PartyList] = [

PartyList(image: "vin", title: "Best Wine Ever. Period", date: "09/03/2021", grade: "4.9", circleColor: Color.green, level: "Awesome", people: "14 people"),
PartyList(image: "pool", title: "Pool party", date: "12/01/2021", grade: "3.7", circleColor: Color.blue, level: "Great", people: "8 people"),
PartyList(image: "cocktail", title: "Cocktails Party", date: "19/02/2021", grade: "4.1", circleColor: Color.green, level: "Awesome", people: "6 people"),
PartyList(image: "party", title: "The one and only", date: "09/03/2021", grade: "2.7", circleColor: Color.orange, level: "Ok", people: "22 people"),
PartyList(image: "tasting", title: "Dégustation de Whiskey", date: "12/09/2020", grade: "1.7", circleColor: Color.red, level: "Bad", people: "4 people")

]


--- 2. UserOrganizedEvent
title: "Organisés", seeMoreText: "Voir plus d'évènements"

----table - cell --- UserEventListView
same cell as above


--- 3. UserParticipatedEvent
title: "Participés", seeMoreText: "Voir plus d'évènements"

----table - cell --- UserEventListView
same cell as above

--- 4. UserReviewView
title: "Avis", seeMoreText: "Voir tout les avis"

----table - cell ---
ImageCircleComponent(image: "Profil", size: 50)
name --- (style: .Medium, ofSize: 16)
Image(systemName: "star.fill")
I bought this book to understand about the thought process in Ansel's mind. But was disappointed to see that all that has been explained is about the stories behind those photographs.
--- style: .SemiBold, ofSize: 13) secondary color*/
