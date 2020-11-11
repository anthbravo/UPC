package pe.edu.upc.u201320891

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Cat::class], version = 1)
abstract class CatDatabase : RoomDatabase() {

    abstract fun getDao(): CatDAO

    companion object {

        private var INSTANCE: CatDatabase? = null

        fun getInstance(context: Context): CatDatabase {

            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(context, CatDatabase::class.java, "cat.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as CatDatabase
        }
    }
}