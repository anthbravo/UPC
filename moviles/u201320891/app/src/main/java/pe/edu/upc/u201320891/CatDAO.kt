package pe.edu.upc.u201320891

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroeDAO {

    @Query("select * from heroe")
    fun getAll() : List<Heroe>

    @Insert
    fun insert(vararg heroe: Heroe)

    @Delete
    fun delete(vararg heroe: Heroe)
}