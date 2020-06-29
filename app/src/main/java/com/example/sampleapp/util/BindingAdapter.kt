package com.example.sampleapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:src")
fun setImageResource(imageView: ImageView, iconRes:Int) {
    imageView.setImageResource(iconRes)
}