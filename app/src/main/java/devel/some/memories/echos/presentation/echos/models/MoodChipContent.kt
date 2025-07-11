package devel.some.memories.echos.presentation.echos.models


import devel.some.memories.core.presentation.util.UiText
import devel.some.memories.R

data class MoodChipContent(
    val iconsRes: List<Int> = emptyList(),
    val title: UiText = UiText.StringResource(R.string.all_moods)
)
