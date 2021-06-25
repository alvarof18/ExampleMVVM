package domain

import data.Models.QuoteModel
import data.Models.QuoteRepository

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>?{
        return repository.getAllQuotes()
    }
}

/* la linea suspend operator fun invoke lo que hace es que cuando se instancie un objeto de la clase
 se ejecute ese codigo inmediatamente
 Ej:
 val test = GetQuotesUseCase()
  test()

 */