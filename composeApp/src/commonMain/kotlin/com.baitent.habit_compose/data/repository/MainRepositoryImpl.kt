package com.baitent.habit_compose.data.repository

import com.baitent.habit_compose.data.source.remote.MainService
import com.baitent.habit_compose.domain.repository.MainRepository

class MainRepositoryImpl(
    private val mainService: MainService
) : MainRepository
