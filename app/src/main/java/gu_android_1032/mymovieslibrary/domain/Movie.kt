package gu_android_1032.mymovieslibrary.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

enum class MoviesCategory {
    HORROR,
    ACTION,
    COMEDY,
    DRAMA,
    FANTASY,
    FANTASTIC
}
@Parcelize
data class Movie(
    val id: Double,
    val originalTitle: String,
    val localTitle: String
): Parcelable