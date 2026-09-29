package com.coldai.core.memory

enum class MemoryCategory { PREFERENCES, PEOPLE, ROUTINES, PROJECTS, IMPORTANT_FACTS, CUSTOM_COMMANDS }

data class MemoryEntry(
    val key: String,
    val value: String,
    val category: MemoryCategory,
    val createdAt: Long = System.currentTimeMillis()
)

class MemoryStore {
    private val entries = linkedMapOf<String, MemoryEntry>()

    fun save(key: String, value: String, category: MemoryCategory) {
        entries[key] = MemoryEntry(key, value, category)
    }

    fun get(key: String): MemoryEntry? = entries[key]
    fun all(): List<MemoryEntry> = entries.values.toList()
    fun byCategory(category: MemoryCategory): List<MemoryEntry> = all().filter { it.category == category }
    fun delete(key: String): Boolean = entries.remove(key) != null
    fun clear() = entries.clear()
}
