package com.baitent.habit_compose.presentation.common

import com.baitent.habit_compose.presentation.features.home.HomeViewModel
import com.baitent.habit_compose.features.welcome.WelcomeViewModel
import com.baitent.habit_compose.presentation.features.settings.SettingsViewModel
import com.baitent.habit_compose.features.sign_in.SignInViewModel
import com.baitent.habit_compose.presentation.features.sign_up.SignUpViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // ViewModels
    viewModel { WelcomeViewModel() }
    viewModel { SignInViewModel() }
    viewModel { SignUpViewModel() }
    viewModel { HomeViewModel() }
    viewModel { SettingsViewModel() }
   /* // Repositories
    single { UserRepository() }
    single { BookRepository() }
    single { AuthorRepository() }*/

    // Firebase (örnek olarak)
    single { FirebaseAuth.getInstance() }
}