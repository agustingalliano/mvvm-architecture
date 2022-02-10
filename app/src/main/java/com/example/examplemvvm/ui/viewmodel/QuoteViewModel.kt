package com.example.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider
import com.example.examplemvvm.domain.GetQuotesUseCase
import com.example.examplemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel(){

    val quoteModel = MutableLiveData<QuoteModel>()
    var getQuotesUseCase = GetQuotesUseCase()
    val isLoading = MutableLiveData<Boolean>()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {

        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if(!result.isNullOrEmpty()) quoteModel.postValue(result[0])
            isLoading.postValue(false)
        }

    }

    fun randomQuote() {
        isLoading.postValue(true)
        val result = getRandomQuoteUseCase()
        if(result!=null) quoteModel.postValue(result)
        isLoading.postValue(false)

    }

}