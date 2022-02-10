package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()) {
            val range = quotes.indices
            val position = range.random()
            return quotes[position]
        }
        return null
    }

}