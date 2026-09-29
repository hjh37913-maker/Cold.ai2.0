package com.coldai.core.security

class SecurityManager {
    fun requireConfirmation(action: String): Boolean {
        return action.lowercase().let {
            it.contains("sms") || it.contains("delete") || it.contains("call") || it.contains("external")
        }
    }
}
