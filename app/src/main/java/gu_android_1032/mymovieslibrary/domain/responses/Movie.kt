package gu_android_1032.mymovieslibrary.domain.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import kotlin.collections.ArrayList

@Parcelize
data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("genres")
    val genres: @RawValue ArrayList<Genre>,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("revenue")
    val revenue: Int?,
    @SerializedName("vote_average")
    val voteAverage: Number,
    @SerializedName("adult")
    val adult: Boolean
): Parcelable