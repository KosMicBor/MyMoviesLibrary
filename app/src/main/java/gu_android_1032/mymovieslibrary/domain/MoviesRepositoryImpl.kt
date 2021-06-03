package gu_android_1032.mymovieslibrary.domain

class MoviesRepositoryImpl: MoviesRepository {

    override fun getMovies(){

    }

    fun getTestMovies() = listOf(
            Movie(1.0, "someTitle", "Some Local Title"),
            Movie(1.0, "someTitle1", "Some Local Title"),
            Movie(1.0, "someTitle2", "Some Local Title"),
            Movie(1.0, "someTitle3", "Some Local Title"),
            Movie(1.0, "someTitle4", "Some Local Title"),
            Movie(1.0, "someTitle5", "Some Local Title"),
            Movie(1.0, "someTitle6", "Some Local Title"),
            Movie(1.0, "someTitle7", "Some Local Title"),
            Movie(1.0, "someTitle8", "Some Local Title")
        )
}

