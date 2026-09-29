package com.coldai.core.ai

class IntentRouter {
    fun route(input: String): IntentClassification {
        val text = input.trim().lowercase()
        return when {
            text.isBlank() -> IntentClassification(IntentType.CONVERSATION, 1f, "Empty input")
            listOf("відкрий", "запусти", "постав", "увімкни").any(text::contains) ->
                IntentClassification(IntentType.LOCAL_ACTION, .94f, "Device action")
            listOf("пам'ятай", "збережи", "забудь").any(text::contains) ->
                IntentClassification(IntentType.MEMORY_OPERATION, .96f, "Memory operation")
            listOf("режим", "підготуй", "виконай", "зроби").any(text::contains) ->
                IntentClassification(IntentType.COMPLEX_TASK, .92f, "Multi-step task")
            listOf("youtube", "google", "карта", "maps").any(text::contains) ->
                IntentClassification(IntentType.WEB_TASK, .90f, "Web task")
            listOf("що", "коли", "чому", "як").any(text::contains) ->
                IntentClassification(IntentType.SIMPLE_QUESTION, .86f, "Question")
            else -> IntentClassification(IntentType.CONVERSATION, .81f, "Conversation")
        }
    }
}
