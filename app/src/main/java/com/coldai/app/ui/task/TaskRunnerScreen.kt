package com.coldai.app.ui.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.coldai.app.navigation.AppDestinations

@Composable
fun TaskRunnerScreen(navController: NavController) {
    val steps = listOf("Check permissions", "Prepare environment", "Execute action", "Verify result", "Respond")
    Column(Modifier.fillMaxSize().background(Color(0xFF0B1020)).padding(20.dp)) {
        Text("TASK", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))
        Text("Preparing…", color = Color(0xFF8BE9B2), fontWeight = FontWeight.SemiBold)
        Text("3/${steps.size}", color = Color.White, modifier = Modifier.padding(vertical = 10.dp))
        LinearProgressIndicator(progress = { .6f }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(20.dp))
        steps.forEachIndexed { index, step ->
            Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("${index + 1}. $step", color = if (index < 3) Color.White else Color(0xFF9AA5B1))
                if (index < 3) Text("OK", color = Color(0xFF8BE9B2))
            }
        }
        Spacer(Modifier.height(20.dp))
        Button(onClick = { navController.navigate(AppDestinations.HOME) }) { Text("Back to Home") }
    }
}
