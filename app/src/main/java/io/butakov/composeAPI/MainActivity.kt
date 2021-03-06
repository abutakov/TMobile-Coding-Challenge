package io.butakov.composeAPI

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import io.butakov.composeAPI.composables.ImageCard
import io.butakov.composeAPI.composables.TextCard
import io.butakov.composeAPI.composables.TitleCard
import io.butakov.composeAPI.network.CardRetrofitService
import io.butakov.composeAPI.repository.Repository
import io.butakov.composeAPI.viewmodel.CardViewModel
import java.lang.Exception

class MainActivity : ComponentActivity() {

    private val viewModel: CardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.initViewModel(Repository(CardRetrofitService.cardService))

        setContent {
            val cards = viewModel.cards.value

            LazyColumn{
                itemsIndexed(items = cards){ _, item ->
                    when(item.card_type){
                        "image_title_description" -> ImageCard(card = item, onClick = {})
                        "title_description" -> TitleCard(card = item, onClick = {})
                        "text" -> TextCard(card = item, onClick = {})
                        else -> throw Exception("Invalid card type.")
                    }
                }
            }
        }
    }
}
