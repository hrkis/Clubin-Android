package com.clubin.com.ui.themeparty.model

import java.io.Serializable

data class ThemePartyModel(
    var date: String = "",
    var distanceTxt: String = "",
    var partyLocation: String = "",
    var organizerName: String = "",
    var rating: String = "",
    var imagePerson: String = "",
    var bannerImage: String = ""
): Serializable