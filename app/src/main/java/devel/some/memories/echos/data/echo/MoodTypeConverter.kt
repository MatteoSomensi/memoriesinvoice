package devel.some.memories.echos.data.echo

import androidx.room.TypeConverter
import devel.some.memories.echos.domain.echo.Mood

class MoodTypeConverter {

    @TypeConverter
    fun fromMood(mood: Mood): String {
        return mood.name
    }

    @TypeConverter
    fun toMood(moodName: String): Mood {
        return Mood.valueOf(moodName)
    }
}