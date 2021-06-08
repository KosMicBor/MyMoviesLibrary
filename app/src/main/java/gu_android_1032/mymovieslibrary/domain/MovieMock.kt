package gu_android_1032.mymovieslibrary.domain

import android.os.Parcelable
import gu_android_1032.mymovieslibrary.domain.responses.Genre
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class MovieMock(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val genres: @RawValue List<Genre>,
    val overview: String?,
    val releaseDate: String,
    val runtime: Int,
    val status: String,
    val budget: Int,
    val revenue: Int?,
    val voteAverage: Number,
    val adult: Boolean
): Parcelable