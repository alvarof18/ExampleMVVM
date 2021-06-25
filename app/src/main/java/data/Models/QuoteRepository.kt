package data.Models

import network.QuoteServices

class QuoteRepository {
    private val api = QuoteServices()
    suspend fun getAllQuotes():List<QuoteModel>{
        val response: List<QuoteModel> = api.getQuotes()
        QuoteProvide.quotes = response
        return response
    }

}