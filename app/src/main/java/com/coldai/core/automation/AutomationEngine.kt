package com.coldai.core.memory

class MemoryEngine {
    private val preferences = mutableMapOf<String, String>()
    private val routines = mutableMapOf<String, String>()
    private val facts = mutableMapOf<String, String>()

    fun savePreference(key: String, value: String) {
        preferences[key] = value
    }

    fun saveRoutine(key: String, value: String) {
        routines[key] = value
    }

    fun saveFact(key: String, value: String) {
        facts[key] = value
    }

    fun getPreference(key: String): String? = preferences[key]
    fun getRoutine(key: String): String? = routines[key]
    fun getFact(key: String): String? = facts[key]

    fun delete(key: String) {
        preferences.remove(key)
        routines.remove(key)
        facts.remove(key)
    }

    fun snapshot(): Map<String, Any> = mapOf(
        "preferences" to preferences,
        "routines" to routines,
        "facts" to facts
    )
}
