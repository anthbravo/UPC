package pe.edu.upc.u201320891

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Heroe::class], version = 1)
abstract class HeroeDatabase : RoomDatabase() {

    abstract fun getDao(): HeroeDAO

    companion object {

        private var INSTANCE: HeroeDatabase? = null

        fun getInstance(context: Context): HeroeDatabase {

            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(context, HeroeDatabase::class.java, "heroe.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as HeroeDatabase
        }
    }
}