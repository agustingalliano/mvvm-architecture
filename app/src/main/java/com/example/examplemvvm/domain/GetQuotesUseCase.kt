package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.database.entity.toEntity
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
){


    suspend operator fun invoke() :List<Quote>? {

        val quotes = repository.getAllQuotesFromApi()
        return if(quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes = quotes.map { it.toEntity() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }

}