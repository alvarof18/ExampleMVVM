package network

import core.RetrofitHelper
import data.Models.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteServices {

    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes():List<QuoteModel>{
        //Corrutinas ejecuta lo que esta dentro de withContext en otro hilo
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}