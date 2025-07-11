package devel.some.memories.echos.data.echo

import devel.some.memories.echos.domain.echo.Echo
import devel.some.memories.echos.data.echo_topic_relation.EchoWithTopics
import devel.some.memories.echos.data.topic.TopicEntity
import java.time.Instant
import kotlin.time.Duration.Companion.milliseconds

fun EchoWithTopics.toEcho(): Echo {
    return Echo(
        mood = echo.mood,
        title = echo.title,
        note = echo.note,
        topics = topics.map { it.topic },
        audioFilePath = echo.audioFilePath,
        audioPlaybackLength = echo.audioPlaybackLength.milliseconds,
        audioAmplitudes = echo.audioAmplitudes,
        recordedAt = Instant.ofEpochMilli(echo.recordedAt),
        id = echo.echoId
    )
}

fun Echo.toEchoWithTopics(): EchoWithTopics {
    return EchoWithTopics(
        echo = EchoEntity(
            echoId = id ?: 0,
            title = title,
            mood = mood,
            recordedAt = recordedAt.toEpochMilli(),
            note = note,
            audioAmplitudes = audioAmplitudes,
            audioFilePath = audioFilePath,
            audioPlaybackLength = audioPlaybackLength.inWholeMilliseconds
        ),
        topics = topics.map { TopicEntity(it) }
    )
}