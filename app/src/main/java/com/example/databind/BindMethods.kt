package com.example.databind

import android.widget.ImageView
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods


@BindingMethods(value = [
    BindingMethod(
            type = ImageView::class,
            attribute = "android:tint",
            method = "setImageTintList")])

class BindMethods 