package devel.some.memories.echos.presentation.create_echo

sealed interface CreateEchoEvent {
    data object FailedToSaveFile: CreateEchoEvent
    data object EchoSuccessfullySaved: CreateEchoEvent
}