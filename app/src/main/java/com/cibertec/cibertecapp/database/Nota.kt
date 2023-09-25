package com.cibertec.cibertecapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Nota(
    @ColumnInfo("title_note")
    val title: String,
    @ColumnInfo(name = "description_note")
    val description: String,
    @ColumnInfo(name = "date_note")
    val date: String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_note")
    var noteId: Int = 0

}

