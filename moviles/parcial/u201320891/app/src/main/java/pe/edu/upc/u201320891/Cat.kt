package pe.edu.upc.u201320891

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class Cat(

    @PrimaryKey(autoGenerate = true)
    var uId: Int?,

    @SerializedName("id")
    var name: String,

    @SerializedName("url")
    var url: String,

    @SerializedName("width")
    var width: Int,

    @SerializedName("height")
    var height: Int
)
