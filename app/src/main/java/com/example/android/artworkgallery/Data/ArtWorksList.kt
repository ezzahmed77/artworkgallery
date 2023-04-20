package com.example.android.artworkgallery.Data

import com.example.android.artworkgallery.R

data class ArtWork(val imgSrc: Int, val title: String, val artist: String)

val listOfArtWork = mutableListOf<ArtWork>(
    ArtWork(
        R.drawable.artwork_1,
        "Art Work 1",
        "Artist 1"
    ),
    ArtWork(
        R.drawable.artwork_2,
        "Art Work 2",
        "Artist 2"
    ),
    ArtWork(
        R.drawable.artwork_3,
        "Art Work 3",
        "Artist 3"
    ),
    ArtWork(
        R.drawable.artwork_4,
        "Art Work 4",
        "Artist 4"
    ),
    ArtWork(
        R.drawable.artwork_5,
        "Art Work 5",
        "Artist 5"
    ),
)