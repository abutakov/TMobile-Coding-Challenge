package io.butakov.composeAPI.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.butakov.composeAPI.model.Card

/**
 * Card to display API response item with 'card_type' = 'title_description'
 */
@Composable
fun TitleCard(
    card: Card,
    onClick: () -> Unit
) {
    androidx.compose.material.Card(
        modifier = Modifier
            .padding(
                all = 12.dp
            )
            .clickable(onClick = onClick)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = card.card.title.value,
                fontSize = card.card.title.attributes.font.size.sp,
                fontWeight = Bold,
                color = Color(color = android.graphics.Color
                    .parseColor(card.card.title.attributes.text_color)),
                modifier = Modifier.fillMaxWidth(0.85f)
            )
            Text(
                text = card.card.description.value,
                fontSize = card.card.description.attributes.font.size.sp,
                fontWeight = Light,
                color = Color(color = android.graphics.Color
                    .parseColor(card.card.description.attributes.text_color)),
                modifier = Modifier.fillMaxWidth(0.85f)
            )
        }
    }
}