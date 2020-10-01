package ru.job4j.dagger

import dagger.Module
import dagger.Provides

@Module
class StoreModule {
    @Provides
    fun providesStore(): Store {
        return MemStore()
    }
}