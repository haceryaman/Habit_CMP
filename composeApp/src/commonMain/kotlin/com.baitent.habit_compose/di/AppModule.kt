package com.baitent.habit_compose.di

import androidx.lifecycle.SavedStateHandle
import com.baitent.habit_compose.data.repository.MainRepositoryImpl
import com.baitent.habit_compose.data.source.remote.MainService
import com.baitent.habit_compose.domain.repository.MainRepository
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
}

val viewModelModule = module {
    factoryOf(::MainViewModel)
}

fun initKoin() {
    startKoin {
        modules(
            dataModule,
            viewModelModule,
        )
    }
}