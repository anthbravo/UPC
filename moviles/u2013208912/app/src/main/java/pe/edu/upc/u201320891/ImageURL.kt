package pe.edu.upc.u201320891

import com.google.gson.annotations.SerializedName

class Heroe (
    @SerializedName("id")
    var id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("image")
    var image: ImageURL
)
