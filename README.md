package com.coldai.core.system

data class DeviceHealthReport(
    val battery: String,
    val storage: String,
    val memory: String,
    val network: String,
    val androidVersion: String,
    val appVersion: String,
    val permissions: List<String>
)

class SystemDiagnostics {
    fun generateReport(): DeviceHealthReport {
        return DeviceHealthReport(
            battery = "Healthy",
            storage = "Available",
            memory = "Normal",
            network = "Online",
            androidVersion = "Android 14",
            appVersion = "1.0.0",
            permissions = listOf(
                "RECORD_AUDIO",
                "POST_NOTIFICATIONS",
                "READ_CONTACTS",
                "READ_CALENDAR"
            )
        )
    }
}
