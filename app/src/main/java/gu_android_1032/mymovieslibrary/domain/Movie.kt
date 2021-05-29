package gu_android_1032.mymovieslibrary.domain

enum class MoviesCategory {
    HORROR,
    ACTION,
    COMEDY,
    DRAMA,
    FANTASY,
    FANTASTIC
}

data class Movie(
    val id: Double,
    val originalTitle: String,
    val localTitle: String,
//    val backdropUrl: String?,
//    val category: MoviesCategory,
//    val voteAverage: Number,
//    val voteCount: Int,
//    val isForAdultOnly: Boolean
)