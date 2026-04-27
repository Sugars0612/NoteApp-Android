package com.sugar.noteapp.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title: String,
    val context: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(Color(0xFFFF8A80), Color(0xFF82B1FF), Color(0xFFB9F6CA), Color(0xFFFFF3CD), Color(0xFFE1BEE7))
    }
}