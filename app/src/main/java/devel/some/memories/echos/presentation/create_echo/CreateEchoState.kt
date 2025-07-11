package devel.some.memories.echos.presentation.create_echo

import devel.some.memories.core.presentation.composable.dropdowns.Selectable
import devel.some.memories.echos.presentation.echos.models.PlaybackState
import devel.some.memories.echos.presentation.models.MoodUi
import kotlin.time.Duration

data class CreateEchoState(
    val titleText: String = "",
    val addTopicText: String = "",
    val topics: List<String> = listOf(),
    val noteText: String = "",
    val showMoodSelector: Boolean = true,
    val selectedMood: MoodUi = MoodUi.NEUTRAL,
    val showTopicSuggestions: Boolean = false,
    val mood: MoodUi? = null,
    val searchResults: List<Selectable<String>> = emptyList(),
    val showCreateTopicOption: Boolean = true,
    val canSaveEcho: Boolean = false,
    val playbackAmplitudes: List<Float> = emptyList(),
    val playbackTotalDuration: Duration = Duration.ZERO,
    val playbackState: PlaybackState = PlaybackState.STOPPED,
    val durationPlayed: Duration = Duration.ZERO,
    val showConfirmLeaveDialog: Boolean = false
) {
    val durationPlayedRatio = (durationPlayed / playbackTotalDuration).toFloat()
}