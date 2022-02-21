package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.QuoteRepository_Factory
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository){

    suspend operator fun invoke(): Quote? {
        val quotes = quoteRepository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()) {
            val range = quotes.indices
            val position = range.random()
            return quotes[position]
        }
        return null
    }

}