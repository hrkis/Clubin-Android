package com.clubin.com.ui.fragment.event.model

import java.io.Serializable

data class EventModel(
    var date: String = "",
    var distanceTxt: String = "",
    var partyLocation: String = "",
    var organizerName: String = "",
    var rating: String = "",
    var imagePerson: String = "",
    var bannerImage: String = ""
): Serializable
