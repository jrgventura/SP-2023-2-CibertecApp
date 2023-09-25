package com.cibertec.cibertecapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Nota::class], version = 1)
abstract class CibertecRoomDatabase: RoomDatabase() {

    abstract fun noteDao(): NotaDao

    companion object {

        private const val DATABASE_NAME = "cibertec_database"

        @Volatile
        private var INSTANCE: CibertecRoomDatabase? = null

        fun getInstance(context: Context): CibertecRoomDatabase? {
            INSTANCE?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    CibertecRoomDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }

    }

}