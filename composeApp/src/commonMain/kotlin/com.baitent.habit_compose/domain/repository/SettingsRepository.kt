package com.baitent.habit_compose.domain.repository

import com.russhwolf.settings.Settings

class SettingsRepository(private val settings: Settings = Settings()) {

    private companion object {
        const val KEY_REMEMBER_ME = "remember_me"
        const val KEY_EMAIL       = "user_email"
        const val KEY_USERNAME    = "user_name"
        const val KEY_FIRST_NAME  = "first_name"
        const val KEY_LAST_NAME   = "last_name"
        const val KEY_AVATAR_URL  = "avatar_url"
    }

    var rememberMe: Boolean
        get() = settings.getBoolean(KEY_REMEMBER_ME, false)
        set(v) = settings.putBoolean(KEY_REMEMBER_ME, v)

    var email: String?
        get() = settings.getStringOrNull(KEY_EMAIL)
        set(v) {
            if (v == null) settings.remove(KEY_EMAIL)
            else            settings.putString(KEY_EMAIL, v)
        }

    var userName: String?
        get() = settings.getStringOrNull(KEY_USERNAME)
        set(v) {
            if (v == null) settings.remove(KEY_USERNAME)
            else            settings.putString(KEY_USERNAME, v)
        }

    var firstName: String?
        get() = settings.getStringOrNull(KEY_FIRST_NAME)
        set(v) {
            if (v == null) settings.remove(KEY_FIRST_NAME)
            else            settings.putString(KEY_FIRST_NAME, v)
        }

    var lastName: String?
        get() = settings.getStringOrNull(KEY_LAST_NAME)
        set(v) {
            if (v == null) settings.remove(KEY_LAST_NAME)
            else            settings.putString(KEY_LAST_NAME, v)
        }

    var avatarUrl: String?
        get() = settings.getStringOrNull(KEY_AVATAR_URL)
        set(v) {
            if (v == null) settings.remove(KEY_AVATAR_URL)
            else            settings.putString(KEY_AVATAR_URL, v)
        }

    /** Hepsini bir arada silmek için: */
    fun clearAll() {
        settings.remove(KEY_REMEMBER_ME)
        settings.remove(KEY_EMAIL)
        settings.remove(KEY_USERNAME)
        settings.remove(KEY_FIRST_NAME)
        settings.remove(KEY_LAST_NAME)
        settings.remove(KEY_AVATAR_URL)
    }
}

