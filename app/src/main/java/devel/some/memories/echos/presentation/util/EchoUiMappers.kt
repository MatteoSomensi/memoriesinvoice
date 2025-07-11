package devel.some.memories.echos.presentation.util

import devel.some.memories.echos.domain.echo.Echo
import devel.some.memories.echos.presentation.echos.models.PlaybackState
import devel.some.memories.echos.presentation.models.EchoUi
import devel.some.memories.echos.presentation.models.MoodUi
import kotlin.time.Duration

fun Echo.toEchoUi(
    currentPlaybackDuration: Duration = Duration.ZERO,
    playbackState: PlaybackState = PlaybackState.STOPPED
): EchoUi {
    return EchoUi(
        id = id!!,
        title = title,
        mood = MoodUi.valueOf(mood.name),
        recordedAt = recordedAt,
        note = note,
        topics = topics,
        amplitudes = audioAmplitudes,
        playbackTotalDuration = audioPlaybackLength,
        audioFilePath = audioFilePath,
        playbackCurrentDuration = currentPlaybackDuration,
        playbackState = playbackState
    )
}