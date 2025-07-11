package devel.some.memories.echos.presentation.echos

import devel.some.memories.echos.domain.recording.RecordingDetails

interface EchosEvent {
    data object RequestAudioPermission: EchosEvent
    data object RecordingTooShort: EchosEvent
    data class OnDoneRecording(val details: RecordingDetails): EchosEvent
}