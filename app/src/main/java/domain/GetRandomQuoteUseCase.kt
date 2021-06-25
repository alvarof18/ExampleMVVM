package domain

import data.Models.QuoteModel
import data.Models.QuoteProvide

class GetRandomQuoteUseCase {
    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvide.quotes

        if (!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}