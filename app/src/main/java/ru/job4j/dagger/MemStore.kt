package ru.job4j.dagger

class MemStore : Store {
    private val list: MutableList<String> = ArrayList()

    override fun add(value: String) = list.add(value)

    override val all: List<String>
        get() = list
}