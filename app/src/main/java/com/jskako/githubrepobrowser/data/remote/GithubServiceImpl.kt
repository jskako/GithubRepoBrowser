package com.jskako.githubrepobrowser.data.remote


import com.jskako.githubrepobrowser.data.remote.dto.RepositoriesDto
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

class GithubServiceImpl(
    private val client: HttpClient
) : GithubService {

    override suspend fun getAllRepositories(
        repositoryName: String,
        language: String
    ): List<GithubRepository> {
        return try {
            val searchByLanguage = if (language.isNotEmpty()) {
                "+language:$language"
            } else ""
            val url =
                "${GithubService.Endpoints.GetAllRepositories.url}$repositoryName$searchByLanguage&sort=stars&order=desc"
            client.get(url)
                .body<RepositoriesDto>().toList()

        } catch (e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }
}