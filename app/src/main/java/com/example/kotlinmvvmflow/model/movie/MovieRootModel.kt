package com.example.kotlinmvvmflow.model.movie

import com.google.gson.annotations.SerializedName


data class MovieRootModel (

    @SerializedName("Search"       ) var Search       : ArrayList<Search> = arrayListOf(),
    @SerializedName("totalResults" ) var totalResults : String?           = null,
    @SerializedName("Response"     ) var Response     : String?           = null

)