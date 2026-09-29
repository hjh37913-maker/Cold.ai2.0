package com.coldai.app.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class QuickAction(val label: String, val meta: String)

data class HomeUiState(
    val status: String = "Ready",
    val lastCommand: String = "None",
    val currentTask: String = "No active task",
    val quickActions: List<QuickAction> = listOf(
        QuickAction("Good morning", "Routine"),
        QuickAction("Open music", "Media"),
        QuickAction("Check battery", "System"),
        QuickAction("Set timer 25 min", "Productivity")
    )
)

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun triggerAction(action: QuickAction) {
        _uiState.value = _uiState.value.copy(
            status = "Executing",
            lastCommand = action.label,
            currentTask = "Executing ${action.label}"
        )
    }
}
