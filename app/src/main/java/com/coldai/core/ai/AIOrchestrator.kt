package com.coldai.core.ai

interface AIProvider {
    val name: String
    val isReady: Boolean
    suspend fun generateText(prompt: String): Result<String>
    suspend fun classifyIntent(input: String): Result<IntentClassification>
}

enum class IntentType {
    SIMPLE_QUESTION,
    LOCAL_ACTION,
    COMPLEX_TASK,
    WEB_TASK,
    ANDROID_TASK,
    AUTOMATION,
    MEMORY_OPERATION,
    CONVERSATION
}

data class IntentClassification(
    val type: IntentType,
    val confidence: Float,
    val reason: String
)
