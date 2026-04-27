package com.sugar.noteapp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sugar.noteapp.feature_note.data.data_source.NoteDatabase
import com.sugar.noteapp.feature_note.data.repository.NoteRepositoryImpl
import com.sugar.noteapp.feature_note.domain.repository.NoteRepository
import com.sugar.noteapp.feature_note.domain.use_case.AddNote
import com.sugar.noteapp.feature_note.domain.use_case.DeleteNote
import com.sugar.noteapp.feature_note.domain.use_case.GetNote
import com.sugar.noteapp.feature_note.domain.use_case.GetNotes
import com.sugar.noteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module // 标记这是一个依赖模块
@InstallIn(SingletonComponent::class) // 把 模块 安装到 指定容器中 SingletonComponent是应用级容器 所以生命周期是全局(作用域匹配)
object AppModules {

    @Provides // 当依赖图中缺少某个对象的构造方式时  Hilt 会查找 @Provides 方法 用它来生成对象
    @Singleton // 在 SingletonComponent 作用域内，这个依赖只会创建一次，并被缓存复用 Scope
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(noteRepository),
            deleteNote = DeleteNote(noteRepository),
            addNote = AddNote(noteRepository),
            getNote = GetNote(noteRepository)
        )
    }
}

/*
Component（生命周期）
→ 定义对象“活多久 / 属于哪个容器”

Scope（作用域）
→ 定义对象在该容器内“是否复用”

Dependency Graph（依赖图）
→ 决定“哪里可以拿到这个对象”
 */