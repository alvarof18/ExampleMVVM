package com.alvaro.examplemvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alvaro.examplemvvm.Models.QuoteModel
import com.alvaro.examplemvvm.Models.QuoteProvide

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuotes(){
        val currentQuote :QuoteModel = QuoteProvide.random()
        quoteModel.postValue(currentQuote)
    }
}