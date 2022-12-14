package com.jskako.githubrepobrowser.data.remote


import com.jskako.githubrepobrowser.data.remote.dto.RepositoriesDto
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get

class GithubServiceImpl(
    private val client: HttpClient
) : GithubService {

    override suspend fun getAllRepositories(
        repositoryName: String,
        language: String
    ): List<GithubRepository> {
        return try {
            val searchByLanguage = if (language.isNotEmpty()) "+language:$language" else ""
            val url =
                "${GithubService.Endpoints.GetAllRepositories.url}$repositoryName$searchByLanguage&sort=stars&order=desc"
            client.get(url)
                .body<RepositoriesDto>().getAllItems()

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