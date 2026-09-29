package com.coldai.core.task

enum class TaskExecutionStatus {
    QUEUED, PLANNING, WAITING_PERMISSION, EXECUTING, VERIFYING, SUCCESS, FAILED, CANCELLED, PAUSED
}

data class TaskExecutionResult(
    val status: TaskExecutionStatus,
    val message: String,
    val stepIndex: Int = 0,
    val totalSteps: Int = 0
)

class TaskExecutionEngine {
    fun start(plan: TaskPlan): TaskExecutionResult = TaskExecutionResult(
        status = TaskExecutionStatus.EXECUTING,
        message = "Executing ${plan.title}",
        stepIndex = 1,
        totalSteps = plan.steps.size.coerceAtLeast(1)
    )

    fun verify(plan: TaskPlan): TaskExecutionResult = TaskExecutionResult(
        status = TaskExecutionStatus.VERIFYING,
        message = "Verifying task completion",
        stepIndex = plan.steps.size,
        totalSteps = plan.steps.size.coerceAtLeast(1)
    )

    fun cancel(plan: TaskPlan): TaskExecutionResult = TaskExecutionResult(
        status = TaskExecutionStatus.CANCELLED,
        message = "Task cancelled: ${plan.title}",
        totalSteps = plan.steps.size.coerceAtLeast(1)
    )
}
