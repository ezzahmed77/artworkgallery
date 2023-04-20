package com.example.android.artworkgallery

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.artworkgallery.Data.listOfArtWork


@Composable
fun ArtWorkGalleryScreen(modifier: Modifier = Modifier) {
    var artWorkIndex by remember { mutableStateOf(0) }
    val currentArtWork = listOfArtWork[artWorkIndex]

    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .verticalScroll(rememberScrollState()),

        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtImage(imgSrc = currentArtWork.imgSrc, contentDescription = currentArtWork.title)

        ArtDetails(title = currentArtWork.title, artist = currentArtWork.artist)

        ArtButtons(
            onNextClicked = {
                if (artWorkIndex == listOfArtWork.size - 1) {
                    artWorkIndex = 0
                } else {
                    artWorkIndex++
                }
            },
            onPreviousClicked = {
                if (artWorkIndex == 0) {
                    artWorkIndex = listOfArtWork.size - 1
                } else {
                    artWorkIndex--
                }
            })

    }

}

@Composable
fun ArtImage(
    @DrawableRes imgSrc: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            painter = painterResource(id = imgSrc),
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxSize(.65f)
                .aspectRatio(.75F) ,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun ArtDetails(
    title: String,
    artist: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = artist,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

        }
    }
}

@Composable
fun ArtButtons(
    onNextClicked: () -> Unit,
    onPreviousClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentSize(Alignment.Center),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = onPreviousClicked,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(id = R.string.previous))
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onNextClicked,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ArtWorkGalleryApp(modifier: Modifier = Modifier) {
    ArtWorkGalleryScreen(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(32.dp)
    )
}
