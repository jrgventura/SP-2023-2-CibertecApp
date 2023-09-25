package com.cibertec.cibertecapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotaDao {
    @Insert
    fun insert(nota: Nota)

    @Update
    fun update(nota: Nota)

    @Delete
    fun delete(nota: Nota)

    @Query("SELECT * FROM note_table ORDER BY date_note DESC")
    fun list(): LiveData<List<Nota>>
}