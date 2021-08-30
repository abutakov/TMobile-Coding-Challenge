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
import io.butakov.composeAPI.composeComponents.loadImage
import io.butakov.composeAPI.model.Card

@Composable
fun ImageCard(
    card: Card,
    onClick: () -> Unit,
) {
    androidx.compose.material.Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                all = 16.dp
            )
            .fillMaxSize()
            .clickable(onClick = onClick)
    ) {
        Box {
            loadImage(imageURL = card.card.image.url).value?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentScale = ContentScale.Crop,
                    contentDescription = card.card.description.value,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Column(
                    Modifier
                        .align(
                            alignment = Alignment.BottomStart
                        )
                        .padding(20.dp)
                ) {
                    Text(
                        text = card.card.title.value,
                        fontSize = card.card.title.attributes.font.size.sp,
                        color = Color(color = android.graphics.Color.parseColor(card.card.title.attributes.text_color)),
                        fontWeight = Bold
                    )
                    Text(
                        text = card.card.description.value,
                        fontSize = card.card.description.attributes.font.size.sp,
                        color = Color(color = android.graphics.Color.parseColor(card.card.description.attributes.text_color)), //Color.White,
                        fontWeight = Light
                    )
                }
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Composable
fun loadImage(imageURL: String): MutableState<Bitmap?> {

    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(imageURL)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }
            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })
    return bitmapState
}