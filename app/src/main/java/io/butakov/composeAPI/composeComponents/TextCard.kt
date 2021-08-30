package io.butakov.composeAPI.composeComponents


import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import io.butakov.composeAPI.model.Card



@Composable
fun TextCard(
    card: Card,
    onClick: () -> Unit
) {
    androidx.compose.material.Card(
        modifier = Modifier
            .padding(
                all = 8.dp
            )
            .clickable(onClick = onClick)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.small
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