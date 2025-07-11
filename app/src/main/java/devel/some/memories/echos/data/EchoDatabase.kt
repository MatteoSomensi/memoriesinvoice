package devel.some.memories.echos.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import devel.some.memories.echos.data.echo.EchoDao
import devel.some.memories.echos.data.echo.EchoEntity
import devel.some.memories.echos.data.echo.FloatListTypeConverter
import devel.some.memories.echos.data.echo.MoodTypeConverter
import devel.some.memories.echos.data.echo_topic_relation.EchoTopicCrossRef
import devel.some.memories.echos.data.topic.TopicEntity

@Database(
    entities = [EchoEntity::class, TopicEntity::class, EchoTopicCrossRef::class],
    version = 1,
)
@TypeConverters(
    MoodTypeConverter::class,
    FloatListTypeConverter::class
)
abstract class EchoDatabase: RoomDatabase() {
    abstract val echoDao: EchoDao
}