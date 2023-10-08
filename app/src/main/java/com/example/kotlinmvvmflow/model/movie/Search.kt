package com.example.kotlinmvvmflow.model.movie

import com.google.gson.annotations.SerializedName


data class Search (

  @SerializedName("Title"  ) var Title  : String? = "",
  @SerializedName("Year"   ) var Year   : String? = "",
  @SerializedName("imdbID" ) var imdbID : String? = "",
  @SerializedName("Type"   ) var Type   : String? = "",
  @SerializedName("Poster" ) var Poster : String? = ""

)