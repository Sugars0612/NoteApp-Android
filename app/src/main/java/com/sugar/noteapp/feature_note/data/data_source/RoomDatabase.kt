package com.sugar.noteapp.feature_note.data.data_source
import androidx.room.RoomDatabase
import androidx.room.Database;
import com.sugar.noteapp.feature_note.domain.model.Note;


// 数据库注解会自动处理生成一个数据库对象类
@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object {
        val DATABASE_NAME = "db_test"
    }
}
