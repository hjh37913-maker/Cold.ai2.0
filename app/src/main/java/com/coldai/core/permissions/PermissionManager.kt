package com.coldai.core.automation

enum class TriggerType {
    VOICE,
    MANUAL,
    SCHEDULE,
    APP_LAUNCH,
    NOTIFICATION,
    SYSTEM_EVENT
}

data class AutomationAction(
    val name: String,
    val command: String
)

data class AutomationRule(
    val id: String,
    val name: String,
    val trigger: TriggerType,
    val actions: List<AutomationAction>
)

class AutomationEngine {
    private val rules = mutableListOf<AutomationRule>()

    fun register(rule: AutomationRule) {
        rules.add(rule)
    }

    fun availableRules(): List<AutomationRule> = rules.toList()

    fun execute(rule: AutomationRule): Result<String> {
        val summary = rule.actions.joinToString { it.command }
        return Result.success("Executed automation: ${rule.name} -> $summary")
    }
}
