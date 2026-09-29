package com.coldai.core.task

data class TaskStep(
    val id: String,
    val title: String,
    val requiredPermission: String? = null
)

data class TaskPlan(
    val id: String,
    val title: String,
    val steps: List<TaskStep>
)

enum class TaskState {
    QUEUED,
    PLANNING,
    WAITING_PERMISSION,
    EXECUTING,
    VERIFYING,
    SUCCESS,
    FAILED,
    CANCELLED,
    PAUSED
}
