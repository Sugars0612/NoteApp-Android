package com.sugar.noteapp.feature_note.domain.use_case

import com.sugar.noteapp.feature_note.domain.model.Note
import com.sugar.noteapp.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("标题 不能为空")
        }

        if (note.context.isBlank()) {
            throw InvalidNoteException("正文 不能为空")
        }

        repository.insertNote(note)
    }
}