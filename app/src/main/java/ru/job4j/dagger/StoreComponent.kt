package ru.job4j.dagger

import dagger.Component

@Component(modules = [StoreModule::class])
interface StoreComponent {
    fun injectTo(activity: MainActivity)
}