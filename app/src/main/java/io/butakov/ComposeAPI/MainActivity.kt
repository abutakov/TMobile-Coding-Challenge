package io.butakov.ComposeAPI

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import io.butakov.ComposeAPI.network.CardRetrofitService
import io.butakov.ComposeAPI.repository.Repository
import io.butakov.ComposeAPI.viewmodel.CardViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: CardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Better practice is to do it with Dependency Ejection
        viewModel.initViewModel(Repository(CardRetrofitService.cardService))

        setContent {
            val cards = viewModel.cards.value

            LazyColumn{
                itemsIndexed(items = cards){ index, item ->
                    if(item.card_type == "image_title_description"){
                        ImageCard(card = item, onClick = {})
                    } else {
                        TextCard(card = item, onClick = {})
                    }
                }
            }
        }
    }
}
