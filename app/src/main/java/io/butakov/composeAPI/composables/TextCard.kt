package io.butakov.composeAPI.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.butakov.composeAPI.model.Card


/**
 * Card to display API response item with 'card_type' = 'text'
 */
@Composable
fun TextCard(
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
                text = card.card.value,
                fontSize = card.card.attributes.font.size.sp,
                fontWeight = Bold,
                color = Color(color = android.graphics.Color
                    .parseColor(card.card.attributes.text_color)),
                modifier = Modifier.fillMaxWidth(0.85f)
            )
        }
    }
}