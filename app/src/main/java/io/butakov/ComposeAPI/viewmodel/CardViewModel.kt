package io.butakov.ComposeAPI.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.butakov.ComposeAPI.model.Card
import io.butakov.ComposeAPI.repository.Repository
import io.butakov.ComposeAPI.util.Logger.Companion.logError
import io.butakov.ComposeAPI.util.Logger.Companion.logMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CardViewModel: ViewModel() {
    //special observable data structure built for compose
    //it subscribes to recompose scope, when a composable is rebuilt it will then update any of other compose scopes that use that value
    val cards: MutableState<List<Card>> = mutableStateOf(listOf())

    fun initViewModel(repository:Repository) {
        viewModelScope.launch(Dispatchers.IO) {
            try{
                logMessage("Data received")
                cards.value = repository.getCards().page.cards
                logMessage("Number of cards received: " + cards.value.size)
            } catch(e: Exception){
                logError(e.localizedMessage)
            }
        }
    }


}




