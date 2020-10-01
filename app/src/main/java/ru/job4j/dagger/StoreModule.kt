package ru.job4j.dagger

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StoreModule {
    @Singleton
    @Provides
    fun providesStore(): Store {
        return MemStore()
    }
}