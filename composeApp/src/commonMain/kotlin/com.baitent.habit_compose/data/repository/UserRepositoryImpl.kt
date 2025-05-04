package com.baitent.habit_compose.data.repository

import com.baitent.habit_compose.data.models.UserEntity
import com.baitent.habit_compose.domain.repository.SettingsRepository
import com.baitent.habit_compose.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserRepositoryImpl(
    private val settingsRepo: SettingsRepository,
) : UserRepository {

    private val _user = MutableStateFlow<UserEntity?>(null)
    override val currentUser: StateFlow<UserEntity?> = _user

    override suspend fun getRemembered(): UserEntity? {
        return if (settingsRepo.rememberMe) {
            UserEntity(
                email = settingsRepo.email.orEmpty(),
                userName = settingsRepo.userName,
                firstName = settingsRepo.firstName,
                lastName = settingsRepo.lastName,
                avatarUrl = settingsRepo.avatarUrl,
                isRememberMe = true
            )
        } else {
            null
        }
    }

    override suspend fun save(user: UserEntity) {
        settingsRepo.rememberMe = user.isRememberMe == true
        settingsRepo.email = user.email
        settingsRepo.userName = user.userName
        settingsRepo.firstName = user.firstName
        settingsRepo.lastName = user.lastName
        settingsRepo.avatarUrl = user.avatarUrl

        _user.value = user
    }

    override suspend fun clearRememberMe() {
        settingsRepo.clearAll()
        _user.value = null
    }
}
