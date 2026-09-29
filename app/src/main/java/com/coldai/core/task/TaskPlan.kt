package com.coldai.core.ai

class AIOrchestrator(
    private val providers: List<AIProvider>
) {
    fun decideIntent(input: String): IntentClassification {
        val normalized = input.trim().lowercase()

        return when {
            normalized.contains("відкрий") || normalized.contains("знайди") || normalized.contains("постав") ->
                IntentClassification(IntentType.LOCAL_ACTION, 0.92f, "Local device action")
            normalized.contains("пам'ятай") || normalized.contains("збережи") || normalized.contains("забудь") ->
                IntentClassification(IntentType.MEMORY_OPERATION, 0.94f, "Memory command")
            normalized.contains("що") && normalized.contains("сьогодні") ->
                IntentClassification(IntentType.SIMPLE_QUESTION, 0.88f, "User asks for info")
            normalized.contains("youtube") || normalized.contains("google") || normalized.contains("maps") ->
                IntentClassification(IntentType.WEB_TASK, 0.90f, "Web-related request")
            normalized.contains("режим") || normalized.contains("підготуй") || normalized.contains("день") ->
                IntentClassification(IntentType.COMPLEX_TASK, 0.95f, "Multi-step task")
            else ->
                IntentClassification(IntentType.CONVERSATION, 0.80f, "General chat or conversation")
        }
    }

    suspend fun handleRequest(input: String): Result<String> {
        val provider = providers.firstOrNull { it.isReady } ?: return Result.failure(IllegalStateException("No AI provider available"))
        return provider.generateText(input)
    }
}
