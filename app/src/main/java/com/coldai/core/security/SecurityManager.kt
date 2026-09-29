package com.coldai.core.permissions

import android.app.Activity
import android.content.pm.PackageManager

class PermissionManager(
    private val activity: Activity
) {
    fun getRequiredPermissionFor(action: String): String? = when (action.lowercase()) {
        "calls" -> "android.permission.CALL_PHONE"
        "contacts" -> "android.permission.READ_CONTACTS"
        "calendar" -> "android.permission.READ_CALENDAR"
        "voice" -> "android.permission.RECORD_AUDIO"
        "notifications" -> "android.permission.POST_NOTIFICATIONS"
        else -> null
    }

    fun hasPermission(permissionName: String): Boolean {
        return activity.checkSelfPermission(permissionName) == PackageManager.PERMISSION_GRANTED
    }
}
