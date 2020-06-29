package com.example.sampleapp.model

import androidx.annotation.DrawableRes
import com.example.sampleapp.R

data class Sample(
    val sampleCaption: String = "Some caption - sample",
    val title: String = "Title",
    val heading1: String = "Heading 1",
    val heading2: String = "Heading 2",
    val heading3: String = "Heading 3",
    val heading4: String = "Heading 4",
    val subHeading1: String = "Sub heading 1",
    val subHeading2: String = "Sub heading 2",
    val subHeading3: String = "Sub heading 3",
    val subHeading4: String = "Sub heading 4",
    @DrawableRes val icon: Int = R.drawable.ic_android_black_24dp
)