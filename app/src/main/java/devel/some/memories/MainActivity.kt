package devel.some.memories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import devel.some.memories.core.presentation.theme.MemoriesInVoiceTheme
import devel.some.memories.navigation.NavigationRoot

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MemoriesInVoiceTheme {
                NavigationRoot(
                    navController = rememberNavController()
                )
            }
        }
    }
}
