package com.baitent.habit_compose.di

import androidx.lifecycle.SavedStateHandle
import com.baitent.habit_compose.data.repository.MainRepositoryImpl
import com.baitent.habit_compose.data.source.locale.database.AppDatabase
import com.baitent.habit_compose.data.source.remote.MainService
import com.baitent.habit_compose.database.getRoomDatabase
import com.baitent.habit_compose.domain.repository.MainRepository
import com.baitent.habit_compose.presentation.features.welcome.WelcomeViewModel
import com.baitent.habit_compose.presentation.features.sign_up.SignUpViewModel
import com.baitent.habit_compose.presentation.features.sign_in.SignInViewModel
import com.baitent.habit_compose.ui.main.MainViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient {
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
    single<MainService> { MainService(get()) }
    single<MainRepository> { MainRepositoryImpl(get()) }
    single { SavedStateHandle() }
    single<AppDatabase> { getRoomDatabase(get()) }
}

val viewModelModule = module {
    factoryOf(::MainViewModel)
    factoryOf(::WelcomeViewModel)
    factoryOf(::SignUpViewModel)
    factoryOf(::SignInViewModel)
}

fun initKoin() {
    startKoin {
        modules(
            dataModule,
            viewModelModule,
        )
    }
}