package devel.some.memories.echos.presentation.echos.models

import devel.some.memories.core.presentation.util.UiText
import devel.some.memories.echos.presentation.models.EchoUi

data class EchoDaySection(
    val dateHeader: UiText,
    val echos: List<EchoUi>
)
