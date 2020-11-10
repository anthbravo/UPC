package pe.edu.upc.u201320891

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class SearchResponse (
    @SerializedName("results")
    var heroes: List<Heroe>
)

@Entity
class Heroe (
    @PrimaryKey
    @SerializedName("id")
    var id: String,


    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String

)
