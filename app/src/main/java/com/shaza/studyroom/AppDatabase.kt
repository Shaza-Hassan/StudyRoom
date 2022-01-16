package com.shaza.studyroom

import android.content.Context
import androidx.room.*
import com.shaza.studyroom.converter.Converter
import com.shaza.studyroom.converter.UserForConverter

@Database(
    entities = [UserForConverter::class,User::class,Car::class,Post::class],
    version = 2
)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val db = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "database-name"
                ).build()

                INSTANCE = db
                // return instance
                db
            }
        }
    }
}