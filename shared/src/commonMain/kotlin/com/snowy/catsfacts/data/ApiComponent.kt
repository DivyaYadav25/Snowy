package com.snowy.catsfacts.data

import com.snowy.catsfacts.data.DTO.CatsResponse
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.client.request.*
import io.ktor.client.call.*

const val API_URL = "https://cat-fact.herokuapp.com/facts"

class ApiComponent {
    private val httpClient = HttpClient{
        install(ContentNegotiation){
            json(Json{
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getData(): List<CatsResponse> {
        return httpClient.get(API_URL).body()
    }

}
