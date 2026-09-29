package com.coldai.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coldai.app.navigation.AppDestinations
import com.coldai.app.ui.commandcenter.CommandCenterScreen
import com.coldai.app.ui.home.HomeScreen
import com.coldai.app.ui.settings.SettingsScreen
import com.coldai.app.ui.task.TaskRunnerScreen
import com.coldai.app.ui.voice.VoiceScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ColdAiApp() }
    }
}

@Composable
fun ColdAiApp() {
    val navController = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = navController,
                startDestination = AppDestinations.HOME
            ) {
                composable(AppDestinations.HOME) { HomeScreen(navController) }
                composable(AppDestinations.COMMAND_CENTER) { CommandCenterScreen(navController) }
                composable(AppDestinations.TASK_RUNNER) { TaskRunnerScreen(navController) }
                composable(AppDestinations.VOICE) { VoiceScreen(navController) }
                composable(AppDestinations.SETTINGS) { SettingsScreen(navController) }
            }
        }
    }
}
