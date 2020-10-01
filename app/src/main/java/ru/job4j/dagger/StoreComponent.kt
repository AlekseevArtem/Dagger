package ru.job4j.dagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StoreModule::class])
interface StoreComponent {
    fun injectTo(activity: MainActivity)
}