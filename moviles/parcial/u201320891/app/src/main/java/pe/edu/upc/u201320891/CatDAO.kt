package pe.edu.upc.u201320891

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CatDAO {

    @Query("select * from cat")
    fun getAll() : List<Cat>

    @Insert
    fun insert(vararg cat: Cat)

    @Delete
    fun delete(vararg cat: Cat)
}