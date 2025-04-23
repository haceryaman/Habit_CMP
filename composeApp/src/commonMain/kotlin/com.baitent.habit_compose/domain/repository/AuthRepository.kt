package com.baitent.habit_compose.domain.repository

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object AuthRepository {
    private val auth: FirebaseAuth = Firebase.auth

    fun signIn(email: String, password: String): Flow<Result<FirebaseUser>> = flow {
        try {
            val user = auth.signInWithEmailAndPassword(email, password)
            emit(Result.success(user.user!!))
        } catch(e: Exception) {
            emit(Result.failure(e))
        }
    }

    fun signUp(email: String, password: String): Flow<Result<FirebaseUser>> = flow {
        try {
            val user = auth.createUserWithEmailAndPassword(email, password)
            emit(Result.success(user.user!!))
        } catch(e: Exception) {
            emit(Result.failure(e))
        }
    }

    suspend fun signOut() {
        auth.signOut()
    }

    val currentUser: FirebaseUser?
        get() = auth.currentUser
}
