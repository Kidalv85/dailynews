package com.kryvovyaz.dailynews.domain.usecases.app_entry

import com.kryvovyaz.dailynews.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}