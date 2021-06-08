package gu_android_1032.mymovieslibrary.domain.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genre(
    @SerializedName("name")
    val name: String
) : Parcelable
