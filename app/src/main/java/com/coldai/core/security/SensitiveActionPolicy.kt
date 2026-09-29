package com.coldai.core.security

class SensitiveActionPolicy {
    fun requiresConfirmation(action: String): Boolean {
        val value = action.lowercase()
        return listOf("call", "sms", "message", "delete", "send", "purchase").any(value::contains)
    }
}
