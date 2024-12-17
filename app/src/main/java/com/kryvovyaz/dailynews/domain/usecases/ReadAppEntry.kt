package com.kryvovyaz.dailynews.domain.usecases

import com.kryvovyaz.dailynews.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow


class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}