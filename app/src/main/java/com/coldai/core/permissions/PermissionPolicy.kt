package com.coldai.core.permissions

data class PermissionRequirement(
    val androidPermission: String,
    val explanation: String
)

class PermissionPolicy {
    fun requirementFor(action: String): PermissionRequirement? = when {
        action.contains("call", ignoreCase = true) -> PermissionRequirement(
            "android.permission.CALL_PHONE", "Phone access is required to place a call."
        )
        action.contains("contact", ignoreCase = true) -> PermissionRequirement(
            "android.permission.READ_CONTACTS", "Contacts access is required to find a person."
        )
        action.contains("calendar", ignoreCase = true) -> PermissionRequirement(
            "android.permission.READ_CALENDAR", "Calendar access is required to read events."
        )
        action.contains("voice", ignoreCase = true) -> PermissionRequirement(
            "android.permission.RECORD_AUDIO", "Microphone access is required for voice input."
        )
        else -> null
    }
}
