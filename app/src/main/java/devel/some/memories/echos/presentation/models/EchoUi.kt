package devel.some.memories.echos.presentation.models

import devel.some.memories.echos.presentation.echos.models.PlaybackState
import devel.some.memories.echos.presentation.util.toReadableTime
import java.time.Instant as JavaInstant
import kotlin.time.Duration

data class EchoUi(
    val id: Int,
    val title: String,
    val mood: MoodUi,
    val recordedAt: JavaInstant,
    val note: String?,
    val topics: List<String>,
    val amplitudes: List<Float>,
    val playbackTotalDuration: Duration,
    val audioFilePath: String,
    val playbackCurrentDuration: Duration = Duration.ZERO,
    val playbackState: PlaybackState = PlaybackState.STOPPED
) {
    val formattedRecordedAt = recordedAt.toReadableTime()
    val playbackRatio = (playbackCurrentDuration / playbackTotalDuration).toFloat()
}
