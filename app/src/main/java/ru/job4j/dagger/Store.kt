package ru.job4j.dagger

interface Store {
    fun add(value: String) : Boolean
    val all: List<String>
}