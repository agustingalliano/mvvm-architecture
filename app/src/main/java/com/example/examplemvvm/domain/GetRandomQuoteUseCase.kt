package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider){

    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()) {
            val range = quotes.indices
            val position = range.random()
            return quotes[position]
        }
        return null
    }

}