package gu_android_1032.mymovieslibrary.domain.responses

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("id")
    val listItemMovieId: Int,
    @SerializedName("title")
    val listItemTitle: String,
    @SerializedName("original_title")
    val listItemOriginalTitle: String,
    @SerializedName("vote_average")
    val listItemVoteAverage: Number
)
