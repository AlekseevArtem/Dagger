package ru.job4j.dagger

import android.app.Application


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        store = DaggerStoreComponent.create()
    }

    companion object {
        var store: StoreComponent? = null
            private set
    }
}