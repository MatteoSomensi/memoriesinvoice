package devel.some.memories.core.presentation.theme

import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import devel.some.memories.R

val Icons.Filled.Pause: ImageVector
    @Composable
    get() = ImageVector.vectorResource(R.drawable.pause)

val Icons.Filled.Microphone: ImageVector
    @Composable
    get() = ImageVector.vectorResource(R.drawable.microphone)