package gu_android_1032.mymovieslibrary.domain.responses

import com.google.gson.annotations.SerializedName


data class MovieDBLists(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)