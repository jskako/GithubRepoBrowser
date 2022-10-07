package com.jskako.githubrepobrowser.di

import com.jskako.githubrepobrowser.data.remote.GithubService
import com.jskako.githubrepobrowser.data.remote.GithubServiceImpl
import com.jskako.githubrepobrowser.domain.use_case.GetRepositoriesUseCase
import com.jskako.githubrepobrowser.domain.use_case.MainUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import io.ktor.client.plugins.logging.Logging

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient() {
            install(Logging)
            install(ContentNegotiation) {
                json()
            }
        }
    }

    @Provides
    @Singleton
    fun provideGithubService(client: HttpClient): GithubService {
        return GithubServiceImpl(client)
    }

    @Provides
    @Singleton
    fun provideMainUseCases(githubService: GithubService): MainUseCases {
        return MainUseCases(
            getRepositories = GetRepositoriesUseCase(githubService)
        )
    }
}